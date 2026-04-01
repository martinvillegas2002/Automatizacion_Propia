package StepDefinition;

import Constant.Navegador;
import Control.DriverContext;
import Control.NavSelector;
import ObjectPage.LoginPage;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavDefinition {

    @Given("abrir el navegador en la url {string}")
    public  void abrirNavegador(String url) throws InterruptedException{
        String nav = System.getProperty("nav", "default");
        Navegador navegador = NavSelector.seleccionNavegador(nav);
        DriverContext.setUp(navegador, url);
        Thread.sleep(5000);
        String urlActual = DriverContext.getDriver().getCurrentUrl();
        System.out.println("URL Actual"+ urlActual);
        Assert.assertEquals(urlActual, url);
    }
}
