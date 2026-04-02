Feature: Validar permisos de acceso en el menú principal según el rol

  @TEST_OrangeHRM_001 @Verificado @Regresivo
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