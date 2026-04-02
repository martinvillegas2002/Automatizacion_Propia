package Control;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;
import java.time.Duration;

public class BaseController {
    private WebDriver driver;
    private WebDriverWait wait; //Poner tiempo de espera antes de que el robot busque. Para darle tiempo

//CONSTRUCTOR. Para evitar que este vacio el driver
    public BaseController() {
        this.driver = DriverContext.getDriver();
        if(this.driver != null){
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIME_DISPLAY),Duration.ofSeconds(Constant.PULLING));
            PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, Constant.TIME_RESPONSE), this);
        }else{
            System.out.println("El web driver no esta inicializado");
        }
    }


//Funciones publicas REUTILIZABLES
    public boolean visualizarElemento(WebElement elementoWeb, int tiempoEspera){
        try{
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(tiempoEspera));
            wait.until(ExpectedConditions.visibilityOf(elementoWeb));
            System.out.println("Es visible el elemento web" + elementoWeb.getText());
            return true;
        }catch(Exception var3){
            System.out.println("No es visible el elemento web" + var3);
            return false;
        }
    }
// Función reutilizable para ESCRIBIR
    public void escribirTexto(WebElement elemento, String texto){
        //Se valida que el elemento se ve
        if(visualizarElemento(elemento, Constant.TIME_DISPLAY)){
            elemento.clear();
            elemento.sendKeys(texto);
            System.out.println("Se escribió correctamente el texto: " +texto);
        }else{
            //Usamos Assert ya que esto PARALIZA la prueba y no provoca falso positivo
            org.junit.Assert.fail("No se pudo interactuar con el elemento para escribir: " + texto);
        }
    }



// Funcion reeutlizable para hacer click
    public void clickearElemento(WebElement elemento){
        if(visualizarElemento(elemento, Constant.TIME_DISPLAY)){
           elemento.click();
           System.out.println("Se hizo click en el elemento correctamente");
        }else{
            org.junit.Assert.fail("No se pudo hacer click porque el elemento no es visible");
        }
    }

//Funcion para obtener texto de forma dinamica de una tabla usando XPath
//NO, no usamos @FindBy para elementos dinámicos.La etiqueta @FindBy tiene una limitación técnica muy estricta en Java: Solo acepta textos estáticos (constantes).
/*String navegador = "Chrome";
// ERROR DE JAVA: No puedes meter una variable dentro de un @FindBy
@FindBy(xpath = "//td[text()='" + navegador + "']")
private WebElement celdaDinamica;*/
public String obtenerTextoDinamico(String xpathDinamico){
        try{
        //Usaremos xpath en vez de webElement para q el contenido se busque en base a lo que dice no a posiciones
        WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(Constant.TIME_DISPLAY));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath(xpathDinamico)));
        return elemento.getText();
        }catch(Exception e){
        org.junit.Assert.fail("No se encontró el elemento con el Xpath:" + xpathDinamico);
            return null;
        }
    }

    //Funcion para buscar en la tabla
    // Xpath Dinamico. Se ajustaa  lo que le pedimos. Cambiar si hay mas de dos tablas
    public boolean verificarColumna(int columna, String textoEsperado) {
        // --- AGREGA ESTE FRENO DE MANO AQUÍ ---
        try {
            Thread.sleep(2000); // Le damos 2 segundos a la tabla para que se actualice
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String xpathColumna = "//tbody/tr/td[" + columna + "]";
        java.util.List<org.openqa.selenium.WebElement> celdas =
                Control.DriverContext.getDriver().findElements(org.openqa.selenium.By.xpath(xpathColumna));

        System.out.println("DEBUG: Se encontraron " + celdas.size() + " filas en la columna " + columna);

        for (org.openqa.selenium.WebElement celda : celdas) {
            // 1. EL DETECTOR DE INVISIBILIDAD: Si la fila está oculta, la saltamos
            if (!celda.isDisplayed()) {
                continue; // Pasa a la siguiente celda inmediatamente
            }
            // 2. EL TRIM: Quita espacios en blanco basura al inicio o al final
            String textoCelda = celda.getText().trim();

            System.out.println("DEBUG: Leyendo celda -> [" + textoCelda + "]"); // <-- Esto nos dirá la verdad
            if (!celda.getText().equals(textoEsperado)) {
                return false;
            }
        }
        return true;

    }

    //Desmarcar ticket
    public void desmarcarCheckBox(WebElement checkbox) {
        // Le preguntamos al elemento: ¿Tienes el ticket puesto?
        if(checkbox.isSelected()){
            checkbox.click();
            System.out.println("DEBUG (BaseController): Se desmarcó el checkbox exitosamente.");
        }else{
            System.out.println("DEBUG (BaseController): El checkbox ya estaba desmarcado.");
        }
    }





}



