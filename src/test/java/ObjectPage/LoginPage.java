package ObjectPage;

import Control.BaseController;
import Control.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BaseController{
    //Para que visualmente se sepa que hay un extends (Esto es clave pero java lo pone internatemente tambien)
    public LoginPage(){
        super();
    }

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement userName;
    public void escribirUser(String userN){
        escribirTexto(this.userName, userN);
    }

    @FindBy(name="password")
    private WebElement passwordUsuario;
    public void escribirPass(String passW){
        escribirTexto(this.passwordUsuario, passW);
    }

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button')]")
    private WebElement btnSubmit;
    public void clickBtnSubm(){
        clickearElemento(this.btnSubmit);
    }


    @FindBy(xpath="//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement txtAlertaLogin;
    /*
    FUNCION
   La primera linea, crea una variable wait con ciertas condiciones (que dure 5 segundos)
   pero hasta ese punto no ejecuta nada, solo la creó.

   En cambio, dentro del try, inicializa la variable wait con wait.until, es decir, se queda
   mirando la pantalla hasta que algo ocurra, respetando el limite de tiempo de arriba.
   */
    public void validarAlertaLogin(String mensajeEsperado){
        WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(5));

        try{
            //El intento DE VER EL ELEMENTO WEB
            wait.until(ExpectedConditions.visibilityOf(this.txtAlertaLogin));

            String alertaActual = this.txtAlertaLogin.getText();
            Assert.assertEquals("ERROR: LOS MENSAJES NO COINCIDEN ",mensajeEsperado,alertaActual);
        }catch(Exception e){
                Assert.fail("La alerta no apareció");
        }

    }














}
