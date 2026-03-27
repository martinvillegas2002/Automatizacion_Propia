package Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;
import java.time.Duration;

public class BaseController {
    private WebDriver driver;
    private WebDriverWait wait; //Poner tiempo de espera antes de que el robot busque. Para darle tiempo

//CONSTRUCTOR. Para evitar que este vacio
    public BaseController(WebDriver driver) {
        this.driver = DriverContext.getDriver();
        if(this.driver != null){
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIME_DISPLAY),Duration.ofSeconds(Constant.PULLING));
        }else{
            System.out.println("El web driver no esta inicializado");
        }
    }
}
