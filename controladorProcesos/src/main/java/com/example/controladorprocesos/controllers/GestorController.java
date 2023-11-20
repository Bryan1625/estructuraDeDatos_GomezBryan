package com.example.controladorprocesos.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.controladorprocesos.model.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestorController {


    @FXML
    public TabPane tabPane;
    AdministradorController administradorController;
    LoginController loginController;
    ModelFactoryController modelFactoryController;
    UsuarioController usuarioController;
    private ObservableList<Proceso> listaTotalProcesos = FXCollections.observableArrayList();
    private ObservableList<Proceso> listaBusquedaProcesos = FXCollections.observableArrayList();

    private ObservableList<Actividad> listaTotalActividades = FXCollections.observableArrayList();
    private ObservableList<Actividad> listaBusquedaActividades = FXCollections.observableArrayList();

    private ObservableList<Tarea> listaTotalTareas = FXCollections.observableArrayList();
    private ObservableList<Tarea> listaBusquedaTareas = FXCollections.observableArrayList();

    private Proceso procesoSeleccionado;
    private Actividad actividadSeleccioada;

    private Tarea tareaSeleccionada;

    Usuario login;

    //////////////////////////////////login///////////////////////////////
    @FXML
    public TextField txtFieldLoginUsuario;
    @FXML
    public PasswordField txtFieldLoginContrasenia;

    /////////////////////////////usuario///////////////////////////////////////
    @FXML
    public Tab tabUIUsuario;
    @FXML
    public TableView<Proceso> tableViewUsuarioProcesos;
    @FXML
    public TableColumn<Proceso, Integer> colUsuarioIdProceso;
    @FXML
    public TableColumn<Proceso, String> colUsuarioNombreProceso;
    @FXML
    public TableColumn<Proceso, Integer> colUsuarioNumeroActividades;
    @FXML
    public TableColumn<Proceso, Double> colUsuarioDuracionEstimadaProceso;
    @FXML
    public TextField txtFieldUsuarioNombreProceso;
    @FXML
    public TextField txtFieldUsuarioIdProceso;
    @FXML
    public TextField txtFieldUsuarioDuracionProceso;
    @FXML
    public TextField txtFieldUsuarioActividadesProceso;
    @FXML
    public TableView<Actividad> tableViewUsuarioActividades;
    @FXML
    public TableColumn<Actividad, Boolean> colUsuarioObligatorioActividad;
    @FXML
    public TableColumn<Actividad, String> colUsuarioNombreActividad;
    @FXML
    public TableColumn<Actividad, Integer> colUsuarioNumeroTareas;
    @FXML
    public TableColumn<Actividad, Double> colUsuarioDuracionEstimadaActividad;
    @FXML
    public TextField txtFieldUsuarioNombreActividad;
    @FXML
    public TextArea txtAreaUsuarioDescripcionActividad;
    @FXML
    public ComboBox<Boolean> comboBoxUsuarioObligatorioActividad;
    @FXML
    public TextField txtFieldUsuarioNombreTarea;
    @FXML
    public ComboBox<Boolean> comboBoxUsuarioObligatorioTarea;
    @FXML
    public TextArea txtAreaUsuarioDescripcionTarea;
    @FXML
    public TableView<Tarea> tableViewUsuarioTareas;
    @FXML
    public TableColumn<Tarea, Boolean> colUsuarioObligatorioTarea;
    @FXML
    public TableColumn<Tarea, String> colUsuarioNombreTarea;
    @FXML
    public TableColumn<Tarea, Double> colUsuarioDuracionEstimadaTarea;
    @FXML
    public SplitMenuButton splitMenuButtonUsuarioNotificaciones;
    @FXML
    public ChoiceBox<String> choiceBoxUsuarioNotificaciones;

    ////////////////////////administrador/////////////////////////////////////
    @FXML
    public Tab tabUIAdministrador;
    @FXML
    public TableView<Proceso> tableViewAdministradorProcesos;
    @FXML
    public TableColumn<Proceso, Integer> colAdministradorIdProceso;
    @FXML
    public TableColumn<Proceso, String> colAdministradorNombreProceso;
    @FXML
    public TableColumn<Proceso, Integer> colAdministradorNumeroActividades;
    @FXML
    public TableColumn<Proceso, Double> colAdministradorDuracionProceso;
    @FXML
    public TextField txtFieldAdminNombreProceso;
    @FXML
    public TextField txtFieldAdminIdProceso;
    @FXML
    public TextField txtFieldAdminDuracionProceso;
    @FXML
    public TextField txtFieldAdminActividadesProceso;
    @FXML
    public TableView<Actividad> tableViewAdministradorActividades;
    @FXML
    public TableColumn<Actividad, Boolean> colAdministradorObligatorioActividad;
    @FXML
    public TableColumn<Actividad, String> colAdministradorNombreActividad;
    @FXML
    public TableColumn<Actividad, Integer> colAdministradorNumeroTareas;
    @FXML
    public TableColumn<Actividad, Double> colAdministradorDuracionActividad;
    @FXML
    public TextField txtFieldAdminitradorNombreActividad;
    @FXML
    public TextArea txtAreaAdminDescripcionActividad;
    @FXML
    public ComboBox<Boolean> comboBoxAdminObligatorioActividad;
    @FXML
    public TextField txtFieldAdminitradorNombreTarea;
    @FXML
    public ComboBox<Boolean> comboBoxAdminObligatorioTarea;
    @FXML
    public TextArea txtAreaAdminDescripcionTarea;
    @FXML
    public TableView<Tarea> tableViewAdministradorTareas;
    @FXML
    public TextField txtFieldAdminitradorNombreTareaUsuario;
    @FXML
    public TableView<Usuario> tableViewAdministradorUsuarios;
    @FXML
    public TableColumn<Usuario, String> colAdminUsuario;
    @FXML
    public TableColumn<Usuario, String> colAdminContrasenia;
    @FXML
    public TextField txtFieldAdminitradorContrasenia;



    //////////////////////metodos graficos//////////////////////////////

    @FXML
    public void initialize(){
        usuarioController = new UsuarioController();
        loginController = new LoginController();
        administradorController = new AdministradorController();
        modelFactoryController = ModelFactoryController.getInstance();
        modelFactoryController.iniciarlizarDatos();
    }

    public void inicializarUsuario(){
        comboBoxUsuarioObligatorioActividad.setItems(FXCollections.observableArrayList(true, false));
        comboBoxUsuarioObligatorioTarea.setItems(FXCollections.observableArrayList(true, false));
    }

    public void inicializarAdministrador(){
        comboBoxAdminObligatorioActividad.setItems(FXCollections.observableArrayList(true, false));
        comboBoxAdminObligatorioTarea.setItems(FXCollections.observableArrayList(true, false));
    }

    private void inicializarActividades() {
        colUsuarioObligatorioActividad.setCellValueFactory(new PropertyValueFactory<>("obligatoria"));
        colUsuarioNombreActividad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuarioNumeroTareas.setCellValueFactory(new PropertyValueFactory<>("numeroTareas"));
        colUsuarioDuracionEstimadaActividad.setCellValueFactory(new PropertyValueFactory<>("duracionEstimada"));
    }

    private void inicializarTareas() {
        colUsuarioNombreTarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuarioDuracionEstimadaTarea.setCellValueFactory(new PropertyValueFactory<>("duracionEstimada"));
        colUsuarioObligatorioTarea.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item ? "Sí" : "No");
            }
        });
    }

    private void inicializarColumnasProcesos() {
        colUsuarioIdProceso.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsuarioNombreProceso.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuarioNumeroActividades.setCellValueFactory(new PropertyValueFactory<>("numeroActividades"));
        colUsuarioDuracionEstimadaProceso.setCellValueFactory(new PropertyValueFactory<>("duracionEstimada"));
    }



    private void mostrarInformacionProceso(Proceso procesoSeleccionado) {
        if (procesoSeleccionado != null) {
            txtFieldUsuarioNombreProceso.setText(procesoSeleccionado.getNombre());
            txtFieldUsuarioIdProceso.setText(String.valueOf(procesoSeleccionado.getId()));
            txtFieldUsuarioDuracionProceso.setText(String.valueOf(procesoSeleccionado.getTiempoMinutos()));
            // Otros campos específicos de Proceso
        }
    }
    private void mostrarInformacionActividad(Actividad actividadSeleccionada) {
        if (actividadSeleccionada != null) {
            txtFieldUsuarioNombreActividad.setText(actividadSeleccionada.getNombre());
            // Otros campos específicos de Actividad
        }
    }
    private void mostrarInformacionTarea(Tarea tareaSeleccionada) {
        if (tareaSeleccionada != null) {
            txtFieldUsuarioNombreTarea.setText(tareaSeleccionada.getNombre());
            // Otros campos específicos de Tarea
        }
    }



    //////////////////////////////////login///////////////////////////////
    public void loginIniciarSesion(ActionEvent actionEvent) {
        String nombreUsuario = txtFieldLoginUsuario.getText();
        String contraseniaUsuario = txtFieldLoginContrasenia.getText();
        this.login = loginController.login(nombreUsuario,contraseniaUsuario);
        if(this.login.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){
            tabPane.getTabs().remove(tabUIUsuario);
        }else{
            tabPane.getTabs().remove(tabUIAdministrador);
        }
    }

    /////////////////////////////////usuario///////////////////////////////////////
    public void usuarioBuscarProcesoNombre(ActionEvent actionEvent) {
        String nombreProceso = txtFieldUsuarioNombreProceso.getText();
        usuarioController.buscarProcesoNombre(nombreProceso);
    }

    public void usuarioBuscarProcesoId(ActionEvent actionEvent) {
        int idProceso = Integer.parseInt(txtFieldUsuarioIdProceso.getText());
        usuarioController.buscarProcesoId(idProceso);
    }

    public void usuarioActualizarTablaProcesos(ActionEvent actionEvent) {

    }

    public void usuarioBuscarActividadNombre(ActionEvent actionEvent) {
    }

    public void usuarioActualizarTablaActividades(ActionEvent actionEvent) {
    }

    public void usuarioBuscarTareaNombre(ActionEvent actionEvent) {
    }

    public void usuarioActualizarTablaTareas(ActionEvent actionEvent) {
    }

    public void usuarioExportarDatosExcel(ActionEvent actionEvent) {
    }

    ////////////////////////administrador/////////////////////////////////////
    public void adminBuscarProcesoNombre(ActionEvent actionEvent) {
    }

    public void adminBuscarProcesoId(ActionEvent actionEvent) {
    }

    public void adminActualizarTablaProcesos(ActionEvent actionEvent) {
    }

    public void adminBuscarActividadNombre(ActionEvent actionEvent) {
    }

    public void adminActualizarTablaActividades(ActionEvent actionEvent) {
    }

    public void adminBuscarTareaNombre(ActionEvent actionEvent) {
    }

    public void adminActualizarTablaTareas(ActionEvent actionEvent) {
    }

    public void adminExportarProcesosExcel(ActionEvent actionEvent) {
    }

    public void adminImportarProcesosCSV(ActionEvent actionEvent) {
    }

    public void adminActualizarProceso(ActionEvent actionEvent) {
    }

    public void adminActualizarActividad(ActionEvent actionEvent) {
    }

    public void adminActualizarTarea(ActionEvent actionEvent) {
    }

    public void adminBuscarUsuario(ActionEvent actionEvent) {
    }

    public void adminActualizarUsuario(ActionEvent actionEvent) {
    }

    public void adminEliminarUsuario(ActionEvent actionEvent) {
    }

    public void adminAgregarUsuario(ActionEvent actionEvent) {
    }

    public void adminExportarUsuariosExcel(ActionEvent actionEvent) {
    }

    public void adminImportarUsuariosCSV(ActionEvent actionEvent) {
    }

    public void adminEliminarTarea(ActionEvent actionEvent) {
    }

    public void adminEliminarActividad(ActionEvent actionEvent) {
    }

    public void adminEliminarProceso(ActionEvent actionEvent) {
    }

    public void adminAgregarProceso(ActionEvent actionEvent) {
    }

    public void adminAgregarActividad(ActionEvent actionEvent) {
    }

    public void adminAgregarTarea(ActionEvent actionEvent) {
    }
}
