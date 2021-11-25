package br.com.workshop.devacademy.aplicacao.cliente.criar;

import br.com.workshop.devacademy.dominio.cliente.Cliente;
import br.com.workshop.devacademy.dominio.cliente.RepositorioCliente;

public class CriarCliente {
	
	private final RepositorioCliente repositorio;

	public CriarCliente(RepositorioCliente repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executa(CriarClienteDto dados) {
		Cliente novo = dados.criarCliente();
		repositorio.salva(novo);
	}

}
