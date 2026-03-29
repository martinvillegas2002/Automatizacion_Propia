package Control;

import Constant.Navegador;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Locale;

import java.util.Map;

public class DriverManager {
    private WebDriver driver;

    //DesiredCapabilities QUE HACE?
    private final DesiredCapabilities ConfiguracionesNav = new DesiredCapabilities();

    protected void resolverDriver(Navegador nav, String url){
        String os = System.getProperty("os.name").toLowerCase();
        String osVersion = System.getProperty("os.version").toLowerCase();

        System.out.println("\nSistema Operativo : "+ os + "," + osVersion);
        System.out.println("\nNavegador : "+ nav);
        switch (nav){
            case Chrome:
                System.out.println("Chrome seleccionado");
                ChromeOptions configuracionChrome = new ChromeOptions();
                if(os.contains("linux")){
                    System.out.println(System.getProperty("user.name"));
                    configuracionChrome.addArguments("--disable-dev-shm-usage");
                    configuracionChrome.addArguments("--no-sandbox");
                    configuracionChrome.addArguments("--disable-gpu");
                    configuracionChrome.addArguments("--headless");
                    configuracionChrome.addArguments("--ignore-ssl-errors=yes");
                    configuracionChrome.addArguments("--windows-size-1980x1080");
                }
                WebDriverManager.chromedriver().browserVersion("146").setup();
                configuracionChrome.addArguments("...remote-allow-origins=yes");
                System.setProperty("webdriver.manager.verbose","true");
                this.driver=new ChromeDriver(configuracionChrome);
                this.driver.manage().deleteAllCookies();
                break;
            default:
                System.out.println("No es posible levantar el navegador" + nav);
                break;
        }
        driver.manage().window().maximize();
        driver.get(url);

    }

    //protected que implica?
    protected WebDriver getDriver(){
        if(driver == null){
            return null;
        }else{
            return driver;
        }
    }

}
