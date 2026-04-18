package ObjectPage;

import Control.BaseController;
import Control.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddEmployeePage extends BaseController {

    public AddEmployeePage() {
        super();
    }


    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement btnAdd;

    public void clickAddEmployee() {
        this.btnAdd.click();
    }


    @FindBy(name = "firstName")
    private WebElement txtFirstName;
    @FindBy(name = "lastName")
    private WebElement txtLastName;

    public void llenarDatosBasicos(String nombre, String apellido) {
        escribirTexto(this.txtFirstName, nombre);
        escribirTexto(this.txtLastName, apellido);
    }

    /*
    Este path le dice a selenim: Captura lo que esta abajo de "Employee Id"

    Tu mente: "Busca el título 'Employee Id'".
    El robot: //label[normalize-space()='Employee Id'] (Encuentra la etiqueta de texto en la pantalla).

    Tu mente: "Sal del texto para ver el bloque completo".
    El robot: /parent::div (Sube al contenedor padre que envuelve a esa etiqueta).

    Tu mente: "Busca abajito (o al bloque de al lado)".
    El robot: /following-sibling::div (Salta al siguiente contenedor "hermano" en la estructura del código).

    Tu mente: "Entra en la cajita donde están los números".
    El robot: /input (Apunta directamente al campo de texto donde, en tu foto, dice "0458").
    */
    @FindBy(xpath = "//label[normalize-space()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement txtEmployeeId;

    public String capturarIdGenerado() {
        // Truco de Senior: Usamos getAttribute("value") en lugar de getText() ya que el id esta dentro de un input
        return this.txtEmployeeId.getAttribute("value");
    }


    /*
    Al tratarse de un Switch nosotros agarramos la primera parte
    precisamente para que no juzge en si esta active o no
     */
    @FindBy(xpath = "//span[contains(@class, 'oxd-switch-input')]")
    private WebElement switchLoginDetails;
    public void clickSwitch(){
        this.switchLoginDetails.click();
        try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
    }

    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div/input")
    private WebElement txtUsername;
    @FindBy(xpath = "//label[normalize-space()='Password']/parent::div/following-sibling::div/input")
    private WebElement txtPassword;
    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/parent::div/following-sibling::div/input")
    private WebElement txtConfirmPassword;

    public void crearUsuario(String user, String pass) {
    escribirTexto(this.txtUsername, user);
    escribirTexto(this.txtPassword, pass);
    escribirTexto(this.txtConfirmPassword, pass);
    }

    @FindBy(xpath="//button[normalize-space()='Save']")
    private WebElement btnSave;
    public void clickGuardar(){
        this.btnSave.click();
    }

   /*
    ¿Por qué no usamos @FindBy aquí? Porque el texto cambia.
    A veces dirá "Successfully Saved", a veces "Successfully Deleted".

    El asterisco (*) le dice a Selenium: "No me importa si es un div, un span o un p.
    Solo búscame algo que tenga la clase de las alertas de OrangeHRM (oxd-toast)"
    */
    public void validarMensajeEmergente(){
        // Armamos el localizador del mensaje
        String xpathToast = "//div[contains(@class, 'oxd-toast--success')]";

        try{
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToast)));
        }catch( Exception e){
            e.printStackTrace();
            org.junit.Assert.fail("ERROR FATAL: El cartelito de éxito no apareció. Posible servidor lento o error al guardar.");
        }
    }

    /*
    Usamos un ancla (<a>) porque en el menú superior de OrangeHRM estos son enlaces directos,
     no botones (<button>)
     */

    @FindBy(xpath="//a[normalize-space()='Employee List']")
    private WebElement tabEmployeeList;
    public void irAListaDeEmpleados(){
        // Pausa técnica: A veces la página de detalles del empleado tarda en cargar
        try{Thread.sleep(1500);}catch(InterruptedException e){e.printStackTrace();}

        this.tabEmployeeList.click();
    }

    @FindBy(xpath="//span[contains(@class, 'oxd-input-field-error-message')]")
    private WebElement txtError;
    public void validarErrorBajoElCampo(String mensajeErrorEsperado){
    try{Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
    String errorActual = this.txtError.getText();

    Assert.assertEquals("ERROR: NO COINCIDEN LOS MENSAJES O NO APARECIÓ:",mensajeErrorEsperado, errorActual );
    System.out.println("DEBUG: ¡Validación exitosa! El sistema mostró el error: " + errorActual);
    }






}



