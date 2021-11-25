package br.com.workshop.devacademy.dominio.cliente;

import java.util.Objects;

public class Telefone {
	
	private String numero;

	public Telefone(String numero) {
		if (Objects.isNull(numero)) {
			throw new IllegalArgumentException("Número é obrigatorio!");
		}
		
		if (!numero.matches("\\d{8}|\\d{9}")) {
			throw new IllegalArgumentException("Número invalido!");
		}
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}

}
