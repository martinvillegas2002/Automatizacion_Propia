package StepDefinition;

import ObjectPage.DashboardPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DashboardDefinition {
DashboardPage dashboardPage = new DashboardPage();

@Then("valida el acceso al menu {string} segun permiso {string}")
public void validaAccesoMenu(String opcionMenu, String visibilidadEsperada){

    boolean debeEstarVisible = Boolean.parseBoolean(visibilidadEsperada);

    boolean menuExiste = dashboardPage.verificarVisibilidadMenu(opcionMenu);

    Assert.assertEquals("Alerta de Seguridad: La visibilidad del menú [" + opcionMenu + "] no coincide con los permisos del usuario.",
            debeEstarVisible, menuExiste);
}

}
