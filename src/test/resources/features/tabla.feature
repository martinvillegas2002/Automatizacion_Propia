
  Feature: Validar datos en tabla dinámica
    @testCase_Filtro_Lenguaje
    Scenario: Validar filtro de lenguaje Java en la tabla
      Given abrir el navegador en la url "https://practicetestautomation.com/practice-test-table/"
      When selecciono el lenguaje "Java" en el filtro
      Then verifico que solo se muestran los cursos del lenguaje "Java"

    @testCase_Filtro_Nivel
    Scenario: Validar filtro de nivel Beginner en la tabla
      Given abrir el navegador en la url "https://practicetestautomation.com/practice-test-table/"
      When desmarco las opciones "Intermediate" y "Advanced" del filtro de nivel
      Then verifico que solo se muestran los cursos del nivel "Beginner"
