@Login @pruebasRegresion
Feature: funcionalidad de login

#Autor: Mvillegas
#Fecha creacion: 12-12-2025
@testCase_1 @rutaCritica
Scenario: validar login
  Given abrir el navegador en la url "https://practicetestautomation.com/practice-test-login/"
  And ingresar el usuario "student"
  And ingresar la pass "Password123"
  When presiono el boton Submit
  Then se valida el mensaje Logged In Successfully

@testCase_2 @flujoNegativo
 Scenario: Validar error con usuario incorrecto
  Given abrir el navegador en la url "https://practicetestautomation.com/practice-test-login/"
  And ingresar el usuario "incorrectUser"
  And ingresar la pass "Password123"
  When presiono el boton Submit
  Then el sistema muestra el mensaje de error "Your username is invalid!"



