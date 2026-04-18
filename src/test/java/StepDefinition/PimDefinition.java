package StepDefinition;

import ObjectPage.AddEmployeePage;
import ObjectPage.DashboardPage;
import ObjectPage.LoginPage;
import ObjectPage.ViewEmployeeListPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PimDefinition {
    private AddEmployeePage  addEmployeePage = new AddEmployeePage();
    private DashboardPage dashboardPage = new DashboardPage();
    private ViewEmployeeListPage viewListPage = new ViewEmployeeListPage();
    private LoginPage loginPage = new LoginPage();

    private String idEmpleadoMemoria;


    @When("navega al modulo {string}")
    public void navegaAlModulo(String nombreModulo) {
        dashboardPage.clickMenuLateral(nombreModulo);
    }


    @And("selecciona agregar empleado")
    public void seleccionaAgregarEmpleado() {
        addEmployeePage.clickAddEmployee();

    }

    @And("ingresa el nombre {string} y apellido {string}")
    public void ingresaElNombreYApellido(String nombre, String apellido) {
        addEmployeePage.llenarDatosBasicos(nombre, apellido);
    }

    @And("captura el ID autogenerado del empleado")
    public void capturaElIDAutogeneradoDelEmpleado() {
    //Llamamos variable para almacenar
      this.idEmpleadoMemoria = addEmployeePage.capturarIdGenerado();
    // Imprimimos en consola para que nosotros (los QA) veamos que funcionó
      System.out.println("DEBUG: ¡ID capturado en la memoria del robot! -> " + this.idEmpleadoMemoria);
    }

    @And("activa el switch para crear credenciales de acceso")
    public void activaElSwitchParaCrearCredencialesDeAcceso() {
    addEmployeePage.clickSwitch();
    }

    @And("ingresa el usuario {string} y contrasena {string}")
    public void ingresaElUsuarioYContrasena(String usuario, String contraseña) {
       addEmployeePage.crearUsuario(usuario, contraseña);
    }

    @And("presiona el boton Guardar")
    public void presionaElBotonGuardar() {
        addEmployeePage.clickGuardar();
    }

    @Then("el sistema muestra el mensaje emergente de exito")
    public void elSistemaMuestraElMensajeEmergente() {
        addEmployeePage.validarMensajeEmergente();
    }

    @And("navega a la pestana de Lista de Empleados")
    public void navegaALaPestanaDeListaDeEmpleados() {
        addEmployeePage.irAListaDeEmpleados();
    }

    @And("busca al empleado usando el ID capturado")
    public void buscaAlEmpleadoUsandoElIDCapturado() {
        viewListPage.buscarPorId(this.idEmpleadoMemoria);
    }

    @And("la tabla de resultados muestra el registro con {string} y {string}")
    public void laTablaDeResultadosMuestraElRegistroConY(String nombre, String apellido) {
        viewListPage.validarEmpleadoTabla(nombre, apellido);
    }

    @Then("el sistema muestra el mensaje de error {string} bajo el campo")
    public void elSistemaMuestraElMensajeDeErrorBajoElCampo(String msjError) {
      addEmployeePage.validarErrorBajoElCampo(msjError);
    }

    @And("el formulario retiene los datos sin mostrar el mensaje de exito")
    public void elFormularioRetieneLosDatosSinMostrarElMensajeDeExito() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("el sistema muestra la alerta roja de credenciales invalidas con el texto {string}")
    public void elSistemaMuestraLaAlertaRojaDeCredencialesInvalidasConElTexto(String txtAlertaLogin) {
        loginPage.validarAlertaLogin(txtAlertaLogin);
    }
}

