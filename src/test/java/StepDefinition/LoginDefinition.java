package StepDefinition;

import ObjectPage.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ObjectPage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDefinition {
    private LoginPage loginPage = new LoginPage();

    @And("ingresar el usuario {string}")
    public void ingresarElUsuario(String nombreUsuario) {
        loginPage.escribirUsername(nombreUsuario);
    }

    @And("ingresar la pass {string}")
    public void ingresarLaPass(String pass) {
        loginPage.escribirPassword(pass);

    }

    @When("presiono el boton Submit")
    public void presionoElBotonSubmit() {
        loginPage.clickBtnSubmit();

    }
    /*---------------------------------------------------------------*/
    @Then("el sistema muestra el mensaje de error {string}")
    public void elSistemaMuestraElMensajeDeError(String mensajeEsperado) {
        // 1. Obtenemos el texto real que aparece en la pantalla
        String mensajeReal = loginPage.obtenerTextoError();

        // 2. Comparamos usando Assert (JUnit 4)
        // El formato es: Assert.assertEquals(Mensaje_Si_Falla, Esperado, Real)
        org.junit.Assert.assertEquals("El mensaje de error no es el correcto", mensajeEsperado, mensajeReal);
    }

}
