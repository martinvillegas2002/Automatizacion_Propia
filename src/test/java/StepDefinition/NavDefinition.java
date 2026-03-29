package StepDefinition;

import ObjectPage.LoginPage;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavDefinition {

    @Given("abrir el navegador en la url {string}")
    public  void abrirNavegador(String url) {

        String nav = System.getProperty("nav", "default");
        Navegador navegador = NavS

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

}
