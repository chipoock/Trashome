package application.model;

import java.time.LocalDate;

public class GeneralEmployee extends Employee {
	private Camiones camionAsignado;

	public GeneralEmployee(String name, int age, int idUser, int CP, String email, String phone, String password, String address,
			LocalDate hiringDate, int salary, Camiones camionAsignado) {
		super(name, age, idUser, CP, email, phone, password, address, hiringDate, salary);
        

        setCamionAsignado(camionAsignado);
	}

	public Camiones getCamionAsignado() {
		return camionAsignado;
	}

	public void setCamionAsignado(Camiones camionAsignado) {
		if(camionAsignado == null) {
			throw new IllegalArgumentException("Todos los conductores deben tener un camion asignado");
		}
		this.camionAsignado = camionAsignado;
	}
}