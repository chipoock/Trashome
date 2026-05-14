package application.model;

public interface EmployeeDao {
	void guardarEmpleado(Employee employee);
	
	void eliminarEmpleado(Employee employee);
	
	void actualizarEmpleado(Employee employee);
	
	java.util.List<Employee> obtenerEmpleados();
}
