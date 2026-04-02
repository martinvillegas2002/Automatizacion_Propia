package ObjectPage;

import Control.BaseController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Constant.Constant;
import static org.junit.jupiter.api.Assertions.fail;

public class LoginPage extends BaseController{
    //Para que visualmente se sepa que hay un extends (Esto es clave pero java lo pone internatemente tambien)
    public LoginPage(){
        super();
    }

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name="password")
    private WebElement passwordUsuario;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button')]")
    private WebElement btnSubmit;


    //Metodos
    public void escribirUser(String userN){
        escribirTexto(this.userName, userN);
    }

    public void escribirPass(String passW){
        escribirTexto(this.passwordUsuario, passW);
    }

    public void clickBtnSubm(){
        clickearElemento(this.btnSubmit);
    }


}
