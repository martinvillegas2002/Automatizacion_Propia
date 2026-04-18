package StepDefinition;

import ObjectPage.HomePage;
import io.cucumber.java.PendingException;
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
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        loginPage.escribirUser(nombreUsuario);
    }

    @And("ingresar la pass {string}")
    public void ingresarLaPass(String pass) {
        loginPage.escribirPass(pass);

    }

    @When("presiono el boton Submit")
    public void presionoElBotonSubmit() {
        loginPage.clickBtnSubm();

    }

    @And("inicia sesion con el usuario {string} y contrasena {string}")
    public void iniciaSesion(String usuario, String contrasena) {
        // 1. Pausa técnica vital para esperar que rendericen las cajas
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        // 2. Le pasamos los parámetros dinámicos a tu página
        loginPage.escribirUser(usuario);
        loginPage.escribirPass(contrasena);

        // 3. Hacemos clic para entrar
        loginPage.clickBtnSubm();
    }
}
