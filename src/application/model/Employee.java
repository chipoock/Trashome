package application.model;
import java.time.LocalDate;

public class Employee extends Users{
	private LocalDate hiringDate;

	public Employee(String name, int age, int idUser, int CP, String email, String phone, String password, String address, LocalDate hiringDate) {
		super(name, age, idUser, CP, email, phone, password, address);
		this.hiringDate = hiringDate;
	}
	
	public LocalDate getHiringDate() {
		return hiringDate;
	}	
}
