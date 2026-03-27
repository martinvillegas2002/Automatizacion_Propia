package ObjectPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.fail;

public class HomePage {

    private WebDriver driver;
    @FindBy(xpath = "//*[text(),'Congratulations student. You successfully logged in!']")
    private WebElement msgBienvenida;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validarMsgBienvenida(){
        try{
           if(this.msgBienvenida.isDisplayed()){
               System.out.println("El mensaje es visible");
           }else{
               System.out.println("Error al vicualizar mensaje");
           }

        }catch(Exception e){
            fail("Error al detectar mensaje de bienvenida" + e.getMessage());
        }

    }

}
