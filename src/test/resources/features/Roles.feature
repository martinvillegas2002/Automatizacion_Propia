Feature: Validar permisos de acceso en el menú principal según el rol

  @TEST_OrangeHRM_001 @Verificado @Regresivo @CaminoCrítico
  Scenario Outline: Validar acceso a opciones del menu segun los permisos del rol
    Given abrir el navegador en la url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And ingresar el usuario "<usuario>"
    And ingresar la pass "<password>"
    When presiono el boton Submit
    Then valida el acceso al menu "<opcion_menu>" segun permiso "<visibilidad>"

    @VisibilidadAlta
    Examples:
      | rol           | usuario | password | opcion_menu | visibilidad |
      | Administrador | Admin   | admin123 | Admin       | true        |
      | Administrador | Admin   | admin123 | PIM         | true        |

    @VisibilidadBaja
    Examples:
      | rol      | usuario | password | opcion_menu | visibilidad |
      | Empleado | martinQA | Martin1234!   | Admin       | false       |
      | Empleado | martinQA | Martin1234!   | My Info     | true        |



  #Tu código le dice al navegador: "Ve a https://opensource-demo.orangehrmlive.com/".

  #OrangeHRM es astuto. Apenas entras, hace una redirección automática para enviarte a /web/index.php/auth/login.

  #Pero en tu archivo NavDefinition.java (línea 22), pusiste un "Juez" (Assert.assertEquals) que revisa la URL inmediatamente.

  #Como el robot lee el código más rápido de lo que la página tarda en redirigir, lee la URL corta, el Juez dice "¡Esto no coincide con lo que esperaba!" y detiene la prueba con un ComparisonFailure.

  @TEST_OrangeHRM_002 @Regresivo @CaminoCrítico
  Scenario Outline: Crear empleado, capturar ID y validar registro en la grilla
    # 1. Precondiciones (Contexto)
    Given abrir el navegador en la url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And inicia sesion con el usuario "Admin" y contrasena "admin123"

    # 2. Acciones principales
    When navega al modulo "PIM"
    And selecciona agregar empleado
    And ingresa el nombre "<nombre>" y apellido "<apellido>"
    And captura el ID autogenerado del empleado
    And activa el switch para crear credenciales de acceso
    And ingresa el usuario "<usuario_emp>" y contrasena "<password_emp>"
    And presiona el boton Guardar

    # 3. Validaciones y Auditoría
    Then el sistema muestra el mensaje emergente de exito
    And navega a la pestana de Lista de Empleados
    And busca al empleado usando el ID capturado
    And la tabla de resultados muestra el registro con "<nombre>" y "<apellido>"

    Examples:
      | nombre    | apellido | usuario_emp  | password_emp |
      | Martin    | QA       | martinqa104  | Martin321@   |
      | Catalina  | Automat  | CataQA4      | Admin321Q    |



  @TEST_OrangeHRM_003
  Scenario Outline: Validar alerta de error al registrar un usuario existente

  # 1. Precondiciones (Contexto)
    Given abrir el navegador en la url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And inicia sesion con el usuario "Admin" y contrasena "admin123"

  # 2. Acciones principales
    When navega al modulo "PIM"
    And selecciona agregar empleado
    And ingresa el nombre "<nombre_nuevo>" y apellido "<apellido_nuevo>"
    And activa el switch para crear credenciales de acceso
  # Se inyecta un usuario que sabemos que ya fue creado en ejecuciones anteriores
    And ingresa el usuario "<usuario_duplicado>" y contrasena "<password>"
    And presiona el boton Guardar

  # 3. Validaciones y Auditoría
    Then el sistema muestra el mensaje de error "Username already exists" bajo el campo

  # Nota de QA: Se usan los mismos usuarios del CP-001 ya que ahora existen en BD.
    Examples:
      | nombre_nuevo | apellido_nuevo | usuario_duplicado | password   |
      | Pedro        | QA         | martinqa104       | Martin321@ |
      | Juana        | Calidad        | CataQA4           | Admin321Q  |



  @TEST_OrangeHRM_004
  Scenario Outline: Bloqueo de acceso por credenciales invalidas

  # 1. Precondiciones
    Given abrir el navegador en la url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  # 2. Acciones principales
    When inicia sesion con el usuario "<usuario_prueba>" y contrasena "<password_prueba>"

  # 3. Validaciones de Seguridad
    Then el sistema muestra la alerta roja de credenciales invalidas con el texto "<mensaje_esperado>"

  # Nota de QA: Se prueban 3 vectores de ataque comunes.
    Examples:
      | usuario_prueba | password_prueba | mensaje_esperado    |
      | Admin          | ClaveFalsa123   | Invalid credentials |
      | UsuarioFalso   | admin123        | Invalid credentials |
      | HackerQA       | Hacker321@      | Invalid credentials |