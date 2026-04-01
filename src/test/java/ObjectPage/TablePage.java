package ObjectPage;

import Control.BaseController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class TablePage extends BaseController {

    public TablePage() {
        super();
    }

    @FindBy(xpath = "//input[@name='lang' and @value='Java']")
    private WebElement rdbLenguajeJava;

    //Funcion para hacer click en Java
    public void seleccionarLenguajeJava() {
        clickearElemento(this.rdbLenguajeJava);
        System.out.println("Se seleccionó el filtro de lenguaje: Java");
    }


    /*------------------------------------------------------------------------*/
    @FindBy(xpath = "//input[@name='level' and @value='Advanced']")
    private WebElement chkAdvanced;

    @FindBy(xpath = "//input[@name='level' and @value='Intermediate']")
    private WebElement chkIntermediate;

    //Funcion para desmarcar elementos de la tabla
    // Nueva función que recibe el texto exacto desde Cucumber
    public void desmarcarCheckboxPorNombre(String nombreNivel) {
        // Armamos el XPath usando la variable
        String xpathDinamico = "//input[@name='level' and @value='" + nombreNivel + "']";

        // Buscamos el elemento en el momento
        WebElement checkbox = Control.DriverContext.getDriver().findElement(By.xpath(xpathDinamico));

        // Usamos la función de tu BaseController
        desmarcarCheckBox(checkbox);
    }
}

