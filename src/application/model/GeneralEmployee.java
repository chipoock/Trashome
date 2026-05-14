package application.model;

import java.time.LocalDate;

public class GeneralEmployee extends Employee {

	public GeneralEmployee(String name, int age, int idUser, int CP, String email, String phone, String password, String address,
			LocalDate hiringDate, double salary) {
		super(name, age, idUser, CP, email, phone, password, address, hiringDate, salary);
	}
}
