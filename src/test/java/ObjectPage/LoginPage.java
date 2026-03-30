package ObjectPage;

import Control.BaseController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginPage extends BaseController{
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement nombreUsuario;

    @FindBy(css = "input[name='password']")
    private WebElement passwordUsuario;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement btnSubmit;


    //Funciones publicas para usarlas en otras partes
    //el try catch eviat que el programa se caiga cuando la pagina cambie
    public void escribirUsername(String nUsuario){
        try{
            if(visualizarElemento(this.nombreUsuario, 10)) {
                this.nombreUsuario.clear(); //DEJA LA CAJA DE TEXTO EN BLANCO
                this.nombreUsuario.sendKeys(nUsuario); //RECIBE "Student". Feature -> StepDefinition -> ObjectPage
            }else{
                fail("No se encuentra el campo nombre de usuario en la pagina");
            }

        }catch(Exception e){
            fail("Error al escribir el campo de usuario" + e.getMessage());
        }

    }

    //Funcion para clave
    public void escribirPassword(String pass){
        try{
            this.passwordUsuario.clear(); //DEJA LA CAJA DE TEXTO EN BLANCO
            this.passwordUsuario.sendKeys(pass); //RECIBE "Student". Feature -> StepDefinition -> ObjectPage

        }catch(Exception e){
            fail("Error al escribir el campo de usuario" + e.getMessage());
        }

    }

    //Funcion para apretar boton
    public void clickBtnSubmit(){
        try{
            this.btnSubmit.click();
        }catch(Exception e){
            fail("Error al escribir el campo de usuario" + e.getMessage());
        }

    }




}
