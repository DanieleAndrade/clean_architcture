package br.com.workshop.devacademy.dominio.cliente;

import java.util.List;

public interface RepositorioCliente {
	
	void salva(Cliente cliente);
	
	Cliente buscarPorCPF(CPF cpf);
	
	List<Cliente> listarTodosClientes();
	


}
