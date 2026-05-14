package application.controller;

import application.model.Conductor;
import application.model.ConexionSQL;
import application.model.Employee;
import application.model.EmployeeDaoImpl;
import application.model.GeneralEmployee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class RegistroEmpleadoController {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCP;
    @FXML
    private TextField txtDireccion;
    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private TableView<Employee> tablaEmpleados;
    @FXML
    private TableColumn<Employee, Integer> colId;
    @FXML
    private TableColumn<Employee, String> colNombre;
    @FXML
    private TableColumn<Employee, Integer> colEdad;
    @FXML
    private TableColumn<Employee, String> colCargo;
    @FXML
    private TableColumn<Employee, String> colTelefono;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpiar;

    private EmployeeDaoImpl employeeDao;
    private ObservableList<Employee> listaEmpleados;
    private boolean modoEdicion = false;

    @FXML
    public void initialize() {
        // Inicializar DAO
        ConexionSQL conexionSQL = new ConexionSQL();
        Connection conexion = conexionSQL.conectar();
        employeeDao = new EmployeeDaoImpl(conexion);

        // Inicializar ComboBox
        cbCargo.setItems(FXCollections.observableArrayList("Conductor", "Empleado General"));

        // Configurar columnas de la tabla
        colId.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("age"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colCargo.setCellValueFactory(cellData -> {
            Employee emp = cellData.getValue();
            if (emp instanceof Conductor) {
                return new SimpleStringProperty("Conductor");
            } else {
                return new SimpleStringProperty("Empleado General");
            }
        });

        // Cargar datos
        cargarEmpleados();

        // Listener para seleccionar empleado en la tabla
        tablaEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                cargarEmpleadoEnFormulario(newSelection);
            }
        });
    }

    private void cargarEmpleados() {
        List<Employee> empleados = employeeDao.obtenerEmpleados();
        listaEmpleados = FXCollections.observableArrayList(empleados);
        tablaEmpleados.setItems(listaEmpleados);
    }

    @FXML
    private void guardarEmpleado() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String correo = txtCorreo.getText();
            String password = txtPassword.getText();
            String telefono = txtTelefono.getText();
            int cp = Integer.parseInt(txtCP.getText());
            String direccion = txtDireccion.getText();
            String cargo = cbCargo.getValue();

            if (cargo == null) {
                mostrarAlerta(Alert.AlertType.WARNING, "Error", "Debe seleccionar un cargo");
                return;
            }

            Employee empleado;
            LocalDate fechaActual = LocalDate.now();
            if (cargo.equals("Conductor")) {
                empleado = new Conductor(nombre, edad, id, cp, correo, telefono, password, direccion, fechaActual, 0,
                        null);
            } else {
                empleado = new GeneralEmployee(nombre, edad, id, cp, correo, telefono, password, direccion, fechaActual,
                        0.0);
            }

            if (modoEdicion) {
                employeeDao.actualizarEmpleado(empleado);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Empleado actualizado correctamente");
            } else {
                employeeDao.guardarEmpleado(empleado);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Empleado registrado correctamente");
            }

            limpiarCampos();
            cargarEmpleados();

        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de formato",
                    "Verifique que los campos numéricos sean válidos (ID, Edad, CP)");
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de validación", e.getMessage());
        }
    }

    @FXML
    private void eliminarEmpleado() {
        Employee seleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            employeeDao.eliminarEmpleado(seleccionado);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Empleado eliminado correctamente");
            limpiarCampos();
            cargarEmpleados();
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Atención", "Seleccione un empleado de la lista para eliminar");
        }
    }

    @FXML
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEdad.clear();
        txtCorreo.clear();
        txtPassword.clear();
        txtTelefono.clear();
        txtCP.clear();
        txtDireccion.clear();
        cbCargo.setValue(null);

        txtId.setDisable(false); // Habilitar ID por si estaba deshabilitado en edición
        modoEdicion = false;
        tablaEmpleados.getSelectionModel().clearSelection();
    }

    private void cargarEmpleadoEnFormulario(Employee empleado) {
        txtId.setText(String.valueOf(empleado.getIdUser()));
        txtId.setDisable(true); // No permitir cambiar ID en edición
        txtNombre.setText(empleado.getName());
        txtEdad.setText(String.valueOf(empleado.getAge()));
        txtCorreo.setText(empleado.getEmail());
        txtPassword.setText(empleado.getPassword());
        txtTelefono.setText(empleado.getPhone());
        txtCP.setText(String.valueOf(empleado.getCP()));
        txtDireccion.setText(empleado.getAddress());

        if (empleado instanceof Conductor) {
            cbCargo.setValue("Conductor");
        } else {
            cbCargo.setValue("Empleado General");
        }

        modoEdicion = true;
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
