package application.model;
import java.time.LocalDate;

public class Employee extends Users{
	private double salary;
	private LocalDate hiringDate;

	public Employee(String name, int age, int idUser, int CP, String email, String phone, String password, String address, LocalDate hiringDate, double salary) {
		super(name, age, idUser, CP, email, phone, password, address);
		this.hiringDate = hiringDate;
		setSalary(salary);
	}
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if(salary <= 0) {
			throw new IllegalArgumentException("Ingrese un salario valido");
		}
		this.salary = salary;
	}


	public LocalDate getHiringDate() {
		return hiringDate;
	}	
}
