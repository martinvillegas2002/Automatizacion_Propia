package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ObjectPage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDefinition {
    private LoginPage loginPage; //BUSCAAAAR¡¡¡ pero segun yo se crea una instancia de dicha clase para usarla aca PARA USAR FUNCIONES PUBLICAS
    private WebDriver driver;

    @Given("abrir el navegador en la url {string}")
    public  void abrirNavegador(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

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

    @Then("se valida el mensaje {string}")
    public void seValidaElMensaje(String arg0) {

    }
}
