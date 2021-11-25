package br.com.workshop.devacademy.dominio.cliente;

public class FabricaDeCliente {
	
	private Cliente aluno;

	public FabricaDeCliente comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = new Cliente(new CPF(cpf), nome, new Email(email));
		return this;
	}
	
	public FabricaDeCliente comTelefone(String numero) {
		this.aluno.adicionarTelefone(numero);
		return this;
	}
	
	public Cliente criar() {
		return this.aluno;
	}
	
}
