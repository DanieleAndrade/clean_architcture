package br.com.workshop.devacademy.dominio.cliente;

public class Email {
	
	private String descricao;

	public Email(String descricao) {
		if (descricao == null || 
				!descricao.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail invalido!");
		}

		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
