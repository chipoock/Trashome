package application.model;

import java.time.LocalDate;

public class Conductor extends Employee {
	private Camiones camionAsignado;

	public Conductor(String name, int age, int idUser, int CP, String email, String phone, String password, String address,
			LocalDate hiringDate, Camiones camionAsignado) {
		super(name, age, idUser, CP, email, phone, password, address, hiringDate);
        

        setCamionAsignado(camionAsignado);
	}

	public Camiones getCamionAsignado() {
		return camionAsignado;
	}

	public void setCamionAsignado(Camiones camionAsignado) {
		this.camionAsignado = camionAsignado;
	}
}