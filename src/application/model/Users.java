package application.model;

public abstract class Users {
	private String name;
	private int age;
	private int idUser;
	private int CP;
	private String email;
	private String phone;
	private String password;
	private String address;
	
	public Users() {
	
	}
	
	public Users(String name, int age, int idUser, int CP, String email, String phone, String password, String address) {
	    if (age < 18) {
	        throw new IllegalArgumentException("El usuario debe ser mayor de edad");
	    }

	    if (name == null || name.trim().isEmpty()) {
	        throw new IllegalArgumentException("El campo de nombre no puede estar vacío");
	    }


	    if (email == null || !email.contains("@")) {
	        throw new IllegalArgumentException("Verifique su Correo Electrónico");
	    }


	    if (CP < 10000 || CP > 99999) {  
	        throw new IllegalArgumentException("Verifique su código postal (debe tener 5 dígitos)");
	    }


	    if (phone == null || !phone.matches("\\d{10}")) {
	        throw new IllegalArgumentException("Ingrese un número de teléfono válido (10 dígitos)");
	    }
	    
	    if (password == null || password.length() < 6) {
	        throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
	    }

	    this.name = name;
	    this.age = age;
	    this.idUser = idUser;
	    this.CP = CP;
	    this.email = email;
	    this.phone = phone;
	    this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
	        throw new IllegalArgumentException("El campo de nombre no puede estar vacío");
	    }
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 18) {
	        throw new IllegalArgumentException("El usuario debe ser mayor de edad");
	    }
		this.age = age;
	}

	public int getIdUser() {
		return idUser;
	}
	
	public void setidUser(int idUser) {
		this.idUser = idUser;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int CP) {
	    if (CP < 10000 || CP > 99999) {
	        throw new IllegalArgumentException("Verifique su código postal (debe tener 5 dígitos)");
	    }
	    this.CP = CP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || !email.contains("@")) {
	        throw new IllegalArgumentException("Verifique su Correo Electrónico");
	    }
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
	        throw new IllegalArgumentException("Ingrese un número de teléfono válido (10 dígitos)");
	    }
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.length() < 6) {
	        throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
	    }
		this.password = password;
	}

	public void setAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("Este campo no puede estar vacio");
		}
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
	
}
