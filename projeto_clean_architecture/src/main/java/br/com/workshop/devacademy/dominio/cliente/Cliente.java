package br.com.workshop.devacademy.dominio.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	
	private CPF cpf;

	private String nome;
	
	private Email email;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private Date dataNascimento;
	
	public Cliente(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String numero) {
		this.telefones.add(new Telefone(numero));
	}
	
	public String getCpf() {
		return cpf.getNumero();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getDescricao();
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
}






