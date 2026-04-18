package ObjectPage;

import Control.BaseController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BaseController {

    public DashboardPage(){
        super();
    }

    private WebDriver driver;

    //Metodo para ver si es visible elemento del Dashboard
    public boolean verificarVisibilidadMenu(String nombreMenu){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String xpathDinamico = "//span[text()='" + nombreMenu + "']";
        List<WebElement> elementosEncontrados = Control.DriverContext.getDriver().findElements(By.xpath(xpathDinamico));

        if(elementosEncontrados.size() > 0){
            System.out.println("DEBUG: El menú ["+ nombreMenu+ "] est VISIBLE ");
            return true;
        }else{
            System.out.println("DEBUG: El menú [" + nombreMenu + "] está OCULTO (Seguridad activada).");
            return false;
        }
    }

    //Metodo para seleccionar algo del Dashboard
    public void clickMenuLateral(String nombreMenu){

        try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}

        //Usamos el path dinamico
        String xpathDinamico = "//span[text()='"+ nombreMenu +"']";
        Control.DriverContext.getDriver().findElement(By.xpath(xpathDinamico)).click();

        //Pausa necesaria para que cargue
        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }




}
