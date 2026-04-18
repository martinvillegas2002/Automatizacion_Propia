package ObjectPage;

import Control.BaseController;
import Control.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewEmployeeListPage extends BaseController {

    public ViewEmployeeListPage() {
        super();
    }


    @FindBy(xpath = "//label[normalize-space()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement txtSearchEmployeeId;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement btnSearch;

    public void buscarPorId(String idBuscado){
        try{Thread.sleep(1500);}catch(InterruptedException e){e.printStackTrace();}

        escribirTexto(this.txtSearchEmployeeId, idBuscado);
        this.btnSearch.click();

        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void validarEmpleadoTabla(String nombre, String apellido){
        String xpathFila= "//div[contains(@class, 'oxd-table-card')]//*[contains(text(), '"+nombre+"')]";

        List<WebElement> resultados = DriverContext.getDriver().findElements(By.xpath(xpathFila));

        /*
        Si el test es Exitoso: El robot busca en la tabla y encuentra al empleado "Martin".
        Lo guarda en la lista. La lista ahora tiene un tamaño de 1.
        Java evalúa la condición matemática: ¿Es 1 > 0? Sí (Verdadero).
        El Juez se queda callado, ignora el mensaje de error y tu prueba se pone en color verde.
        */
        Assert.assertTrue("ERROR FATAL: El empleado:" + nombre + " "+apellido+ "NO aparece en la tabla",resultados.size() > 0 );
    }

}