package StepDefinition;

import Control.BaseController;
import ObjectPage.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class HomeDefinition {
    private HomePage homePage = new HomePage();


    @Then("se valida el mensaje Logged In Successfully")
    public void seValidaElMensaje() {
        homePage.validarMsgBienvenida();}

}
