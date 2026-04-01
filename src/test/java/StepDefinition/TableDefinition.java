package StepDefinition;

import ObjectPage.TablePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class TableDefinition {
    TablePage tablePage = new TablePage();

    @When("selecciono el lenguaje {string} en el filtro")
    public void seleccionoElLenguajeEnElFiltro(String lenguaje){
        tablePage.seleccionarLenguajeJava();

    }

    @Then("verifico que solo se muestran los cursos del lenguaje {string}")
    public void verificoQueSoloSeMuestranLosCursosDelLenguaje(String textoEsperado){
        boolean resultadoValidacion= tablePage.verificarColumna(3, textoEsperado);
        Assert.assertTrue("Fallo el filtro: La tabla muestra cursos de otros lenguajes", resultadoValidacion);
    }

/*------------------------------------------------------------------------*/
    @When("desmarco las opciones {string} y {string} del filtro de nivel")
    public void desmarcoOpciones(String nivel1, String nivel2){
        tablePage.desmarcarCheckboxPorNombre(nivel1);
        tablePage.desmarcarCheckboxPorNombre(nivel2);
    }

    @Then("verifico que solo se muestran los cursos del nivel {string}")
    public void verificoCursos(String nivelEsperado){
       boolean resultadoValidacion = tablePage.verificarColumna(4, nivelEsperado);

       Assert.assertTrue("Error: Se encontraron niveles distintos a " + nivelEsperado, resultadoValidacion);
        }

    }







