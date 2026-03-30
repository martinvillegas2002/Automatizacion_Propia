package ObjectPage;


import Control.BaseController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.fail;

public class HomePage extends BaseController {

    private WebDriver driver;
    @FindBy(xpath = "//*[text() ='Congratulations student. You successfully logged in!']")
    public WebElement msgBienvenida;


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
