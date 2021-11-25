package br.com.workshop.devacademy.aplicacao.cliente.criar;

import br.com.workshop.devacademy.dominio.cliente.Cliente;
import br.com.workshop.devacademy.dominio.cliente.CPF;
import br.com.workshop.devacademy.dominio.cliente.Email;

public class CriarClienteDto {

	private String nome;
	private String cpf;
	private String email;
	
	public CriarClienteDto(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public Cliente criarCliente() {
		return new Cliente(
				new CPF(cpf), 
				nome, 
				new Email(email));
	}
	
}
