package application.model;

public interface ClienteDao {
	void guardarCliente(Client cliente);
	Client buscarPorId(int idUser);
	void actualizarCliente(Client cliente);
	void eliminarCliente(int idUser);	
	Client inicioDeSesion(String email);
}
