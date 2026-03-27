package Controller;

import Constant.Navegador;
import org.openqa.selenium.WebDriver;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();
    private static Navegador tipoNavegador;

    private static String getSstring(){
        return tipoNavegador.toString();
    }

    public static void setTipoNavegador(Navegador tipoNavegador){
        DriverContext.tipoNavegador = tipoNavegador;
    }

    public static void setUp(Navegador nav){
        setTipoNavegador(nav);
        System.out.println("Driver context --> Navegador " +nav );
        driverManager.resolveDriver(nav);
    }

    public static WebDriver getDriver (){
        return driverManager.getDriver();
    }

    public static void quiDriver (){
        if(driverManager != null){
            driverManager.getDriver().quit();
        }
    }
}
