package br.com.workshop.devacademy.dominio.cliente;

import java.util.Objects;

public class CPF {

	private String numero;

	public CPF(String numero) {
		if (Objects.isNull(numero) || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
}
