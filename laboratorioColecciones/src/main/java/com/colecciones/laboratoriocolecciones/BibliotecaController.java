package com.colecciones.laboratoriocolecciones;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class BibliotecaController {
    private Biblioteca biblioteca;

    private ObservableList<Prestamo> observablePrestamos;
    private ObservableList<Bibliotecario> observableBibliotecarios;
    private ObservableList<Estudiante> observableEstudiantes;
    private ObservableList<Libro> observableLibros;

    // Elementos de la interfaz de Bibliotecarios
    @FXML
    private TextField txtNombreBibliotecario;

    @FXML
    private TextField txtIdBibliotecario;

    @FXML
    private Button btnAgregarBibliotecario;

    @FXML
    private Button btnEliminarBibliotecario;

    @FXML
    private Button btnActualizarBibliotecario;

    @FXML
    private TableView<Bibliotecario> tblBibliotecarios;

    @FXML
    private TableColumn<Bibliotecario, String> colNombreBibliotecario;

    @FXML
    private TableColumn<Bibliotecario, Integer> colIdBibliotecario;

    // Elementos de la interfaz de Estudiantes
    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private TextField txtIdEstudiante;

    @FXML
    private Button btnAgregarEstudiante;

    @FXML
    private Button btnEliminarEstudiante;

    @FXML
    private Button btnActualizarEstudiante;

    @FXML
    private TableView<Estudiante> tblEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> colNombreEstudiante;

    @FXML
    private TableColumn<Estudiante, Integer> colIdEstudiante;

    @FXML
    private TableColumn<Estudiante, Integer> colLibrosEstudiante;

    // Elementos de la interfaz de Libros
    @FXML
    private TextField txtTituloLibro;

    @FXML
    private TextField txtAutorLibro;

    @FXML
    private Button btnAgregarLibro;

    @FXML
    private Button btnEliminarLibro;

    @FXML
    private Button btnActualizarLibro;

    @FXML
    private TableView<Libro> tblLibros;

    @FXML
    private TableColumn<Libro, String> colTituloLibro;

    @FXML
    private TableColumn<Libro, String> colAutorLibro;

    @FXML
    private TableColumn<Libro, Boolean> colDisponibleLibro;

    //transacciones

    @FXML
    private TextField txtEstudianteTransaccion;

    @FXML
    private Button btnPrestamo;

    @FXML
    private Button btnDevolucion;

    @FXML
    private TableView<Libro> tblLibrosBiblioteca;

    @FXML
    private TableColumn<Libro, String> colTituloLibroBiblioteca;

    @FXML
    private TableColumn<Libro, String> colAutorLibroBiblioteca;

    @FXML
    private TableColumn<Libro, Boolean> colDisponibleLibroBiblioteca;


    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public BibliotecaController() {

    }

    @FXML
    void initialize() {
        inicializarDatos();
    }

    public void inicializarDatos() {

        biblioteca = new Biblioteca();

        Estudiante estudiante1 = new Estudiante("Carlos", 1);
        Estudiante estudiante2 = new Estudiante("Juan", 2);
        Estudiante estudiante3 = new Estudiante("Esteban", 3);
        Estudiante estudiante4 = new Estudiante("Laura", 4);
        Estudiante estudiante5 = new Estudiante("Ana", 5);
        Estudiante estudiante6 = new Estudiante("Sofia", 6);
        Estudiante estudiante7 = new Estudiante("Nicolas", 7);


        Bibliotecario bibliotecario1 = new Bibliotecario("Bryan", 101);
        Bibliotecario bibliotecario2 = new Bibliotecario("Camila", 102);


        Libro libro1 = new Libro("Cronica de una Muerte Anunciada", "Gabriel Garcia Marquez");
        Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");
        Libro libro3 = new Libro("1984", "George Orwell");
        Libro libro4 = new Libro("Matar a un ruiseñor", "Harper Lee");
        Libro libro5 = new Libro("El Gran Gatsby", "F. Scott Fitzgerald");
        Libro libro6 = new Libro("Crimen y castigo", "Fiodor Dostoievski");



        biblioteca.agregarEstudiante(estudiante1);
        biblioteca.agregarEstudiante(estudiante2);
        biblioteca.agregarEstudiante(estudiante3);
        biblioteca.agregarEstudiante(estudiante4);
        biblioteca.agregarEstudiante(estudiante5);
        biblioteca.agregarEstudiante(estudiante6);
        biblioteca.agregarEstudiante(estudiante7);

        biblioteca.agregarBibliotecario(bibliotecario1);
        biblioteca.agregarBibliotecario(bibliotecario2);


        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);

        this.observablePrestamos = FXCollections.observableArrayList(biblioteca.getPrestamos().values());
        this.observableBibliotecarios = FXCollections.observableArrayList(biblioteca.getBibliotecarios());
        this.observableEstudiantes = FXCollections.observableArrayList(biblioteca.getEstudiantes());
        this.observableLibros = FXCollections.observableArrayList(biblioteca.getLibros());



    }

    private void inicializarTablaBibliotecarios() {
        colNombreBibliotecario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colIdBibliotecario.setCellValueFactory(new PropertyValueFactory<>("id"));

        tblBibliotecarios.setItems(observableBibliotecarios);
    }

    private void inicializarTablaEstudiantes() {
        colNombreEstudiante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colIdEstudiante.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLibrosEstudiante.setCellValueFactory(new PropertyValueFactory<>("cantLibros"));

        tblEstudiantes.setItems(observableEstudiantes);
    }

    // Métodos para registrar un préstamo y una devolución
    public boolean registrarPrestamo(Estudiante estudiante, Libro libro) {
        return biblioteca.registrarPrestamo(estudiante, libro);
    }

    public boolean recibirDevolucion(Libro libro, Estudiante estudiante) {
        return biblioteca.recibirDevolucion(libro, estudiante);
    }

    // Métodos para eliminar elementos de las colecciones
    public boolean eliminarPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            biblioteca.eliminarPrestamo(prestamo);
            return true;
        }
        return false;
    }

    public boolean eliminarBibliotecario(Bibliotecario bibliotecario) {
        if (bibliotecario != null) {
            biblioteca.eliminarBibliotecario(bibliotecario);
            return true;
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            biblioteca.eliminarEstudiante(estudiante);
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(Libro libro) {
        if (libro != null) {
            biblioteca.eliminarLibro(libro);
            return true;
        }
        return false;
    }

    // Métodos para consultar información
    public ArrayList<DetallePrestamo> obtenerDetallesPrestamo(int idPrestamo) {
        Prestamo prestamo = biblioteca.obtenerPrestamo(idPrestamo);
        if (prestamo != null) {
            return prestamo.getDetalles();
        }
        return null;
    }

    public TreeSet<Libro> obtenerLibrosPorTitulo() {
        return biblioteca.obtenerLibrosPorTitulo();
    }

    public Bibliotecario obtenerBibliotecario(int id) {
        return biblioteca.obtenerBibliotecario(id);
    }

    public Estudiante obtenerEstudiante(int id) {
        return biblioteca.obtenerEstudiante(id);
    }

    private void abrirNuevaVentana(String rutaFXML, String titulo) {
        try {

            // Cargar el archivo FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            // Crear una nueva escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(titulo);

            // Mostrar la nueva ventana
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void CrudEstudianteOnAction(ActionEvent actionEvent) {
        // Abre una nueva ventana sin cerrar la actual
        abrirNuevaVentana("crudEstudianteView.fxml", "Gestión de Estudiantes");
        inicializarTablaEstudiantes();
    }

    public void CrudBibliotecarioOnAction(ActionEvent actionEvent) {
        // Abre una nueva ventana sin cerrar la actual
        abrirNuevaVentana("crudBibliotecarioView.fxml", "Gestión de Bibliotecarios");
        inicializarTablaBibliotecarios();
    }

    public void CrudLibroOnAction(ActionEvent actionEvent) {
        // Abre una nueva ventana sin cerrar la actual
        abrirNuevaVentana("crudLibroView.fxml", "Gestión de Libros");
    }

    public void transaccionesOnAction(ActionEvent actionEvent) {
        // Abre una nueva ventana sin cerrar la actual
        abrirNuevaVentana("transaccionesView.fxml", "Transacciones");
    }

    public void agregarBibliotecarioOnAction(ActionEvent event) {
        String nombre = txtNombreBibliotecario.getText();
        String idStr = txtIdBibliotecario.getText();

        if (!nombre.isEmpty() && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                Bibliotecario bibliotecario = new Bibliotecario(nombre, id);
                biblioteca.agregarBibliotecario(bibliotecario);
                txtNombreBibliotecario.clear();
                txtIdBibliotecario.clear();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarBibliotecarioOnAction(ActionEvent event) {
        String idStr = txtIdBibliotecario.getText();

        if (!idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                Bibliotecario bibliotecario = biblioteca.obtenerBibliotecario(id);

                if (bibliotecario != null) {
                    biblioteca.eliminarBibliotecario(bibliotecario);
                    txtNombreBibliotecario.clear();
                    txtIdBibliotecario.clear();
                } else {
                    // Manejar el caso en el que no se encuentra el bibliotecario
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarBibliotecarioOnAction(ActionEvent actionEvent) {
        // Implementación para actualizar un bibliotecario en la interfaz
        Bibliotecario bibliotecarioSeleccionado = tblBibliotecarios.getSelectionModel().getSelectedItem();
        if (bibliotecarioSeleccionado != null) {
            String nuevoNombre = txtNombreBibliotecario.getText();
            if (!nuevoNombre.isEmpty()) {
                bibliotecarioSeleccionado.setNombre(nuevoNombre);
                // Actualizar la tabla
                tblBibliotecarios.refresh();
                limpiarCamposBibliotecario();
            }
        }
    }

    public void agregarEstudianteOnAction(ActionEvent actionEvent) {
        // Implementación para agregar un estudiante en la interfaz
        String nombreEstudiante = txtNombreEstudiante.getText();
        String idEstudianteStr = txtIdEstudiante.getText();

        if (!nombreEstudiante.isEmpty() && !idEstudianteStr.isEmpty()) {
            try {
                int idEstudiante = Integer.parseInt(idEstudianteStr);
                Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, idEstudiante);
                biblioteca.agregarEstudiante(nuevoEstudiante);
                tblEstudiantes.getItems().add(nuevoEstudiante);
                limpiarCamposEstudiante();
            } catch (NumberFormatException e) {
                // Manejar la excepción si el ID no es un número válido
                // Por ejemplo, mostrar un mensaje de error al usuario
            }
        }
    }

    public void eliminarEstudianteOnAction(ActionEvent actionEvent) {
        // Implementación para eliminar un estudiante en la interfaz
        Estudiante estudianteSeleccionado = tblEstudiantes.getSelectionModel().getSelectedItem();
        if (estudianteSeleccionado != null) {
            biblioteca.eliminarEstudiante(estudianteSeleccionado);
            tblEstudiantes.getItems().remove(estudianteSeleccionado);
        }
    }

    public void actualizarEstudianteOnAction(ActionEvent actionEvent) {
        // Implementación para actualizar un estudiante en la interfaz
        Estudiante estudianteSeleccionado = tblEstudiantes.getSelectionModel().getSelectedItem();
        if (estudianteSeleccionado != null) {
            String nuevoNombre = txtNombreEstudiante.getText();
            if (!nuevoNombre.isEmpty()) {
                estudianteSeleccionado.setNombre(nuevoNombre);
                // Actualizar la tabla
                tblEstudiantes.refresh();
                limpiarCamposEstudiante();
            }
        }
    }

    public void agregarLibroOnAction(ActionEvent actionEvent) {
        // Implementación para agregar un libro en la interfaz
        String tituloLibro = txtTituloLibro.getText();
        String autorLibro = txtAutorLibro.getText();
        if (!tituloLibro.isEmpty() && !autorLibro.isEmpty()) {
            Libro nuevoLibro = new Libro(tituloLibro, autorLibro);
            biblioteca.agregarLibro(nuevoLibro);
            tblLibros.getItems().add(nuevoLibro);
            limpiarCamposLibro();
        }
    }

    public void eliminarLibroOnAction(ActionEvent actionEvent) {
        // Implementación para eliminar un libro en la interfaz
        Libro libroSeleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            biblioteca.eliminarLibro(libroSeleccionado);
            tblLibros.getItems().remove(libroSeleccionado);
        }
    }

    public void actualizarLibroOnAction(ActionEvent actionEvent) {
        // Implementación para actualizar un libro en la interfaz
        Libro libroSeleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            String nuevoTitulo = txtTituloLibro.getText();
            String nuevoAutor = txtAutorLibro.getText();
            if (!nuevoTitulo.isEmpty() && !nuevoAutor.isEmpty()) {
                libroSeleccionado.setTitulo(nuevoTitulo);
                libroSeleccionado.setAutor(nuevoAutor);
                // Actualizar la tabla
                tblLibros.refresh();
                limpiarCamposLibro();
            }
        }
    }

    private void limpiarCamposBibliotecario() {
        txtNombreBibliotecario.clear();
        txtIdBibliotecario.clear();
    }

    private void limpiarCamposEstudiante() {
        txtNombreEstudiante.clear();
        txtIdEstudiante.clear();
    }

    private void limpiarCamposLibro() {
        txtTituloLibro.clear();
        txtAutorLibro.clear();
    }


    public void realizarPrestamoOnAction(ActionEvent actionEvent) {
        // Obtener el ID del estudiante desde el campo de texto de transacción
        String idEstudianteStr = txtEstudianteTransaccion.getText();

        if (!idEstudianteStr.isEmpty()) {
            try {
                int idEstudiante = Integer.parseInt(idEstudianteStr);

                // Obtener el estudiante correspondiente usando obtenerEstudiante
                Estudiante estudiante = obtenerEstudiante(idEstudiante);

                if (estudiante != null) {
                    // Obtener el libro seleccionado de la tabla
                    Libro libroSeleccionado = tblLibrosBiblioteca.getSelectionModel().getSelectedItem();

                    if (libroSeleccionado != null) {
                        // Llamar al método registrarPrestamo con el estudiante y el libro
                        boolean exito = registrarPrestamo(estudiante, libroSeleccionado);

                        if (exito) {
                            // Operación de préstamo exitosa, puedes mostrar un mensaje de éxito
                            // o realizar otras acciones necesarias.
                            System.out.println("Préstamo registrado exitosamente.");
                        } else {
                            // Manejar el caso en el que el préstamo no pudo ser registrado.
                            System.out.println("No se pudo registrar el préstamo.");
                        }
                    } else {
                        // Manejar el caso en el que no se seleccionó ningún libro.
                        System.out.println("Por favor, seleccione un libro.");
                    }
                } else {
                    // Manejar el caso en el que no se encontró al estudiante con el ID proporcionado.
                    System.out.println("Estudiante no encontrado.");
                }

                // Limpiar el campo de texto de transacción
                txtEstudianteTransaccion.clear();

            } catch (NumberFormatException e) {
                // Manejar la excepción si el ID no es un número válido
                // Por ejemplo, mostrar un mensaje de error al usuario
                System.out.println("Ingrese un ID de estudiante válido.");
            }
        } else {
            // Manejar el caso en el que el campo de texto de transacción está vacío.
            System.out.println("Ingrese un ID de estudiante.");
        }
    }

    public void recibirDevolucionOnAction(ActionEvent actionEvent) {
        // Obtener el ID del estudiante desde el campo de texto de transacción
        String idEstudianteStr = txtEstudianteTransaccion.getText();

        if (!idEstudianteStr.isEmpty()) {
            try {
                int idEstudiante = Integer.parseInt(idEstudianteStr);

                // Obtener el estudiante correspondiente usando obtenerEstudiante
                Estudiante estudiante = obtenerEstudiante(idEstudiante);

                if (estudiante != null) {
                    // Obtener el libro seleccionado de la tabla
                    Libro libroSeleccionado = tblLibrosBiblioteca.getSelectionModel().getSelectedItem();

                    if (libroSeleccionado != null) {
                        // Llamar al método recibirDevolucion con el estudiante y el libro
                        boolean exito = recibirDevolucion(libroSeleccionado, estudiante);

                        if (exito) {
                            // Operación de devolución exitosa, puedes mostrar un mensaje de éxito
                            // o realizar otras acciones necesarias.
                            System.out.println("Devolución registrada exitosamente.");
                        } else {
                            // Manejar el caso en el que la devolución no pudo ser registrada.
                            System.out.println("No se pudo registrar la devolución.");
                        }
                    } else {
                        // Manejar el caso en el que no se seleccionó ningún libro.
                        System.out.println("Por favor, seleccione un libro.");
                    }
                } else {
                    // Manejar el caso en el que no se encontró al estudiante con el ID proporcionado.
                    System.out.println("Estudiante no encontrado.");
                }

                // Limpiar el campo de texto de transacción
                txtEstudianteTransaccion.clear();

            } catch (NumberFormatException e) {
                // Manejar la excepción si el ID no es un número válido
                // Por ejemplo, mostrar un mensaje de error al usuario
                System.out.println("Ingrese un ID de estudiante válido.");
            }
        } else {
            // Manejar el caso en el que el campo de texto de transacción está vacío.
            System.out.println("Ingrese un ID de estudiante.");
        }
    }
}

