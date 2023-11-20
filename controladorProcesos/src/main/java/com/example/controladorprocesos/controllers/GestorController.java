package com.example.controladorprocesos.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.controladorprocesos.model.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class GestorController {


    @FXML
    public TabPane tabPane;
    @FXML
    public TextField txtFieldUsuarioTiempoTarea;
    @FXML
    public TextField txtFieldUsuarioTareasActividad;
    @FXML
    public TextField txtFieldAdminitradorTiempoTarea;
    @FXML
    public TextField txtFieldAdminitradorTareasActividad;
    AdministradorController administradorController;
    LoginController loginController;
    ModelFactoryController modelFactoryController;
    UsuarioController usuarioController;
    private ObservableList<Proceso> listaTotalProcesos = FXCollections.observableArrayList();
    private ObservableList<Proceso> listaBusquedaProcesos = FXCollections.observableArrayList();
    private ObservableList<Usuario> listaBusquedaUsuarios = FXCollections.observableArrayList();
    private ObservableList<Usuario> listaTotalUsuarios = FXCollections.observableArrayList();

    private ObservableList<Actividad> listaTotalActividades = FXCollections.observableArrayList();
    private ObservableList<Actividad> listaBusquedaActividades = FXCollections.observableArrayList();

    private ObservableList<Tarea> listaTotalTareas = FXCollections.observableArrayList();
    private ObservableList<Tarea> listaBusquedaTareas = FXCollections.observableArrayList();
    private Usuario usuarioBuscado;

    private Proceso procesoSeleccionado;
    private Actividad actividadSeleccionada;

    private Tarea tareaSeleccionada;
    private Usuario usuarioSeleccionado;

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
    public TextField txtFieldAdminitradorNombreUsuario;
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
        modelFactoryController.inicializarDatos();
        actualizarDatosUsuario();
    }

    public void inicializarUsuario(){
        comboBoxUsuarioObligatorioActividad.setItems(FXCollections.observableArrayList(true, false));
        comboBoxUsuarioObligatorioTarea.setItems(FXCollections.observableArrayList(true, false));
        inicializarColumnasProcesos();
        inicializarColumnasActividades();
        inicializarColumnasTareas();
    }

    public void inicializarAdministrador(){
        comboBoxAdminObligatorioActividad.setItems(FXCollections.observableArrayList(true, false));
        comboBoxAdminObligatorioTarea.setItems(FXCollections.observableArrayList(true, false));
    }

    private void inicializarColumnasActividades() {
        colUsuarioObligatorioActividad.setCellValueFactory(new PropertyValueFactory<>("obligatoria"));
        colUsuarioObligatorioActividad.setCellFactory(column -> new TableCell<Actividad, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText("N/A");  // o cualquier otro valor predeterminado
                } else {
                    setText(item ? "Sí" : "No");
                }
            }
        });
        colUsuarioNombreActividad.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tableViewUsuarioActividades.setItems(listaTotalActividades);

        tableViewUsuarioActividades.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            actividadSeleccionada = newSelection;
            mostrarInformacionActividad(actividadSeleccionada);
        });
    }


    private void inicializarColumnasTareas() {
        colUsuarioNombreTarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuarioObligatorioTarea.setCellValueFactory(new PropertyValueFactory<>("obligatoria"));
        colUsuarioObligatorioTarea.setCellFactory(column -> new TableCell<Tarea, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText("N/A");  // o cualquier otro valor predeterminado
                } else {
                    setText(item ? "Sí" : "No");
                }
            }
        });


        tableViewUsuarioTareas.setItems(listaTotalTareas);

        tableViewUsuarioTareas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tareaSeleccionada = newSelection;
            mostrarInformacionTarea(tareaSeleccionada);
        });
    }

    private void inicializarColumnasProcesos() {
        colUsuarioIdProceso.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsuarioNombreProceso.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tableViewUsuarioProcesos.setItems(listaTotalProcesos);

        tableViewUsuarioProcesos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            procesoSeleccionado = newSelection;
            mostrarInformacionProceso(procesoSeleccionado);
        });
    }



    private void mostrarInformacionProceso(Proceso procesoSeleccionado) {
        if (procesoSeleccionado != null) {
            txtFieldUsuarioNombreProceso.setText(procesoSeleccionado.getNombre());
            txtFieldUsuarioIdProceso.setText(String.valueOf(procesoSeleccionado.getId()));
            txtFieldUsuarioDuracionProceso.setText(String.valueOf(procesoSeleccionado.getTiempoMinutos()));
            txtFieldUsuarioActividadesProceso.setText(""+procesoSeleccionado.getActividades().getSize());
            listaBusquedaActividades.setAll(procesoSeleccionado.obtenerTodasLasActividades());
            tableViewUsuarioActividades.setItems(listaBusquedaActividades);
            listaBusquedaTareas.setAll(procesoSeleccionado.obtenerTareasProceso());
            tableViewUsuarioTareas.setItems(listaBusquedaTareas);
        }
    }
    private void mostrarInformacionActividad(Actividad actividadSeleccionada) {
        if (actividadSeleccionada != null) {
            txtFieldUsuarioNombreActividad.setText(actividadSeleccionada.getNombre());
            txtAreaUsuarioDescripcionActividad.setText(actividadSeleccionada.getDescripcion());
            txtFieldUsuarioTareasActividad.setText(""+actividadSeleccionada.getTareas().getSize());
        }
    }
    private void mostrarInformacionTarea(Tarea tareaSeleccionada) {
        if (tareaSeleccionada != null) {
            txtFieldUsuarioNombreTarea.setText(tareaSeleccionada.getNombre());
            txtAreaUsuarioDescripcionTarea.setText(tareaSeleccionada.getDescripcion());
            txtFieldUsuarioTiempoTarea.setText(""+tareaSeleccionada.getTiempoMinutos());
        }
    }

    private void actualizarDatosUsuario(){
        listaTotalTareas.clear();
        listaTotalActividades.clear();
        listaTotalProcesos.clear();
        listaTotalActividades.setAll(modelFactoryController.gestor.obtenerTodasLasActividades());
        listaTotalProcesos.setAll(modelFactoryController.gestor.obtenerListaProcesos());
        listaTotalTareas.setAll(modelFactoryController.gestor.obtenerTodasLasTareas());
        tableViewUsuarioProcesos.refresh();
        tableViewUsuarioActividades.refresh();
        tableViewUsuarioTareas.refresh();
    }

    private void actualizarDatosAdmin(){
        listaTotalTareas.clear();
        listaTotalActividades.clear();
        listaTotalProcesos.clear();
        listaTotalActividades.setAll(modelFactoryController.gestor.obtenerTodasLasActividades());
        listaTotalProcesos.setAll(modelFactoryController.gestor.obtenerListaProcesos());
        listaTotalTareas.setAll(modelFactoryController.gestor.obtenerTodasLasTareas());
        tableViewAdministradorProcesos.refresh();
        tableViewAdministradorActividades.refresh();
        tableViewAdministradorTareas.refresh();
    }



    //////////////////////////////////login///////////////////////////////
    public void loginIniciarSesion(ActionEvent actionEvent) {
        String nombreUsuario = txtFieldLoginUsuario.getText();
        String contraseniaUsuario = txtFieldLoginContrasenia.getText();
        this.login = loginController.login(nombreUsuario,contraseniaUsuario);
        if(this.login != null) {
            if (this.login.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
                tabPane.getTabs().remove(tabUIUsuario);
                inicializarAdministrador();
            } else {
                tabPane.getTabs().remove(tabUIAdministrador);
                inicializarUsuario();
            }
        }else{
            lanzarAlertaError("el usuario o la contraseña son incorrectos");
        }
    }

    public void lanzarAlertaError(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null); // No mostrar encabezado
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    /////////////////////////////////usuario///////////////////////////////////////
    public void usuarioBuscarProcesoNombre(ActionEvent actionEvent) {
        String nombreProceso = txtFieldUsuarioNombreProceso.getText();
        listaBusquedaProcesos.setAll(usuarioController.buscarProcesoNombre(nombreProceso));
        if(!listaBusquedaProcesos.isEmpty()) {
            tableViewUsuarioProcesos.setItems(listaBusquedaProcesos);
        }else{
            lanzarAlertaError("no se encontro el proceso");
        }
    }

    public void usuarioBuscarProcesoId(ActionEvent actionEvent) {
        int idProceso = Integer.parseInt(txtFieldUsuarioIdProceso.getText());
        listaBusquedaProcesos.clear();
        listaBusquedaProcesos.addAll(usuarioController.buscarProcesoId(idProceso));
        if(!listaBusquedaProcesos.isEmpty()){
            tableViewUsuarioProcesos.setItems(listaBusquedaProcesos);
        }else{
            lanzarAlertaError("no se encontro el proceso");
        }
    }

    public void usuarioActualizarTablaProcesos(ActionEvent actionEvent) {
        actualizarDatosUsuario();
        tableViewUsuarioProcesos.setItems(listaTotalProcesos);
    }

    public void usuarioBuscarActividadNombre(ActionEvent actionEvent) {
        String nombre = txtFieldUsuarioNombreActividad.getText();
        listaBusquedaActividades.clear();
        if(procesoSeleccionado != null) {
            listaBusquedaActividades.setAll(procesoSeleccionado.buscarActividad(nombre));
        }else{
            lanzarAlertaError("debe seleccionar un proceso");
        }
        if(listaBusquedaActividades.isEmpty()){
            listaBusquedaActividades.setAll(usuarioController.buscarActividadesNombre(nombre));
        }
        if(listaBusquedaActividades.isEmpty()){
            lanzarAlertaError("no se encontro la actividad");
        }else{
            tableViewUsuarioActividades.setItems(listaBusquedaActividades);
        }
    }

    public void usuarioActualizarTablaActividades(ActionEvent actionEvent) {
        actualizarDatosUsuario();
        tableViewUsuarioActividades.setItems(listaTotalActividades);
    }

    public void usuarioBuscarTareaNombre(ActionEvent actionEvent) {
        String nombre = txtFieldUsuarioNombreTarea.getText();
        if(actividadSeleccionada != null){
            listaBusquedaTareas.setAll(actividadSeleccionada.buscarTareaPorNombre(nombre));
        }else if(procesoSeleccionado != null) {
            listaBusquedaTareas.setAll(procesoSeleccionado.buscarTareaInicio(nombre));
        }else{
            listaBusquedaTareas.setAll(usuarioController.buscarTareasNombre(nombre));
        }
        if(!listaBusquedaActividades.isEmpty()) {
            tableViewUsuarioTareas.setItems(listaBusquedaTareas);
        }else{
            lanzarAlertaError("no se encontro la tarea");
        }
    }

    public void usuarioActualizarTablaTareas(ActionEvent actionEvent) {
        actualizarDatosUsuario();
        tableViewUsuarioTareas.setItems(listaTotalTareas);
    }

    public void usuarioExportarDatosExcel(ActionEvent actionEvent) {
        usuarioController.exportarDatosExcel();
    }

    ////////////////////////administrador/////////////////////////////////////
    public void adminBuscarProcesoNombre(ActionEvent actionEvent) {
        String nombreProceso = txtFieldAdminNombreProceso.getText();
        listaBusquedaProcesos.setAll(administradorController.buscarProcesoNombre(nombreProceso));
        if (!listaBusquedaProcesos.isEmpty()) {
            tableViewAdministradorProcesos.setItems(listaBusquedaProcesos);
        } else {
            lanzarAlertaError("No se encontró el proceso");
        }
    }

    public void adminBuscarProcesoId(ActionEvent actionEvent) {
        int idProceso = Integer.parseInt(txtFieldAdminIdProceso.getText());
        listaBusquedaProcesos.clear();
        Proceso procesoEncontrado = administradorController.buscarProcesoId(idProceso);
        if (procesoEncontrado != null) {
            listaBusquedaProcesos.add(procesoEncontrado);
            tableViewAdministradorProcesos.setItems(listaBusquedaProcesos);
        } else {
            lanzarAlertaError("No se encontró el proceso");
        }
    }


    public void adminActualizarTablaProcesos(ActionEvent actionEvent) {
        actualizarDatosUsuario();
        tableViewAdministradorProcesos.setItems(listaTotalProcesos);
    }

    public void adminBuscarActividadNombre(ActionEvent actionEvent) {
        String nombreActividad = txtFieldAdminitradorNombreActividad.getText();
        listaBusquedaActividades.clear();
        if (procesoSeleccionado != null) {
            listaBusquedaActividades.setAll(procesoSeleccionado.buscarActividad(nombreActividad));
        } else {
            lanzarAlertaError("Debe seleccionar un proceso");
        }
        if (listaBusquedaActividades.isEmpty()) {
            listaBusquedaActividades.setAll(administradorController.buscarActividadesNombre(nombreActividad));
        }
        if (listaBusquedaActividades.isEmpty()) {
            lanzarAlertaError("No se encontró la actividad");
        } else {
            tableViewAdministradorActividades.setItems(listaBusquedaActividades);
        }
    }

    public void adminActualizarTablaActividades(ActionEvent actionEvent) {
        actualizarDatosUsuario();
        tableViewAdministradorActividades.setItems(listaTotalActividades);
    }

    public void adminBuscarTareaNombre(ActionEvent actionEvent) {
        String nombre = txtFieldAdminitradorNombreTarea.getText();
        if (actividadSeleccionada != null) {
            listaBusquedaTareas.setAll(actividadSeleccionada.buscarTareaPorNombre(nombre));
        } else if (procesoSeleccionado != null) {
            listaBusquedaTareas.setAll(procesoSeleccionado.buscarTareaInicio(nombre));
        } else {
            listaBusquedaTareas.setAll(administradorController.buscarTareasNombre(nombre));
        }
        if (!listaBusquedaActividades.isEmpty()) {
            tableViewAdministradorTareas.setItems(listaBusquedaTareas);
        } else {
            lanzarAlertaError("No se encontró la tarea");
        }
    }

    public void adminActualizarTablaTareas(ActionEvent actionEvent) {
        actualizarDatosAdmin();
        tableViewAdministradorTareas.setItems(listaTotalTareas);
    }

    public void adminExportarProcesosExcel(ActionEvent actionEvent) {
        administradorController.exportarDatosExcel();
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
        String nombre = txtFieldAdminitradorNombreUsuario.getText();
        usuarioBuscado = administradorController.buscarUsuario(nombre);
        listaBusquedaUsuarios.setAll(usuarioBuscado);
    }

    public void adminActualizarUsuario(ActionEvent actionEvent) {
    }

    public void adminEliminarUsuario(ActionEvent actionEvent) {
        if(listaTotalUsuarios.contains(usuarioSeleccionado)){
            administradorController.eliminarUsuario(usuarioSeleccionado);
        }else{
            lanzarAlertaError("el usuario no existe");
        }
    }

    public void adminAgregarUsuario(ActionEvent actionEvent) {
        String nombreUsuario = txtFieldAdminitradorNombreUsuario.getText();
        String contrasenia = txtFieldAdminitradorContrasenia.getText();
        if (administradorController.buscarUsuario(nombreUsuario) == null) {
            administradorController.agregarUsuario(new Usuario(nombreUsuario, contrasenia));
        } else {
            lanzarAlertaError("el usuario ya existe");
        }
    }

    public void adminExportarUsuariosExcel(ActionEvent actionEvent) {
    }

    public void adminImportarUsuariosCSV(ActionEvent actionEvent) {
    }

    public void adminEliminarTarea(ActionEvent actionEvent) {
        if(listaTotalTareas.contains(tareaSeleccionada)) {
            if(actividadSeleccionada != null) {
                administradorController.eliminarTarea(actividadSeleccionada, tareaSeleccionada);
            }else{
                lanzarAlertaError("debe seleccionar una actividad primero");
            }
        }else{
            lanzarAlertaError("no existe la tarea");
        }
    }

    public void adminEliminarActividad(ActionEvent actionEvent) {
        if(listaTotalActividades.contains(actividadSeleccionada)) {
            if(procesoSeleccionado != null) {
                administradorController.eliminarActividad(procesoSeleccionado, actividadSeleccionada);
            }else{
                lanzarAlertaError("debe seleccionar un proceso primero");
            }
        }else{
            lanzarAlertaError("no existe la actividad");
        }
    }

    public void adminEliminarProceso(ActionEvent actionEvent) {
        if(listaTotalProcesos.contains(procesoSeleccionado) && procesoSeleccionado != null){
            administradorController.eliminarProceso(procesoSeleccionado);
        }else{
            lanzarAlertaError("no se encontro el proceso");
        }
    }

    public void adminAgregarProceso(ActionEvent actionEvent) {
        String id = txtFieldAdminIdProceso.getText();
        String nombre = txtFieldAdminNombreProceso.getText();
        if (administradorController.buscarProcesoId(Integer.parseInt(id)) == null){
            administradorController.agregarProceso(new Proceso(Integer.parseInt(id), nombre));
        }else{
            lanzarAlertaError("el proceso ya existe");
        }

    }

    public void adminAgregarActividad(ActionEvent actionEvent) {
        String nombre = txtFieldAdminitradorNombreActividad.getText();
        String descripcion = txtAreaAdminDescripcionActividad.getText();
        administradorController.agregarActividad(procesoSeleccionado, new Actividad(nombre,descripcion));
    }

    public void adminAgregarTarea(ActionEvent actionEvent) {
        String nombre = txtFieldAdminitradorNombreTarea.getText();
        String descripcion = txtAreaAdminDescripcionTarea.getText();
        String tiempo = txtFieldAdminitradorTiempoTarea.getText();

        administradorController.agregarTarea(actividadSeleccionada, new Tarea(nombre,descripcion, Double.parseDouble(tiempo)));
    }
}
