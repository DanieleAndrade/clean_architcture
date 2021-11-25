package br.com.workshop.devacademy;

import br.com.workshop.devacademy.aplicacao.cliente.criar.CriarCliente;
import br.com.workshop.devacademy.aplicacao.cliente.criar.CriarClienteDto;
import br.com.workshop.devacademy.infra.cliente.RepositorioClienteMemoria;

public class ClienteMain {
	
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";
		
		CriarCliente matricular = new CriarCliente(new RepositorioClienteMemoria());
		matricular.executa(
				new CriarClienteDto(nome, cpf, email));
	}

}
