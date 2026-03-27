package StepDefinition;

import ObjectPage.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class HomeDefinition {

    private HomePage homePage;
    private WebDriver driver;

    @Then("se valida el mensaje Logged In Successfully")
    public void seValidaElMensaje(String arg0) {
        homePage= new HomePage(driver);
        homePage.validarMsgBienvenida();


    }

}
