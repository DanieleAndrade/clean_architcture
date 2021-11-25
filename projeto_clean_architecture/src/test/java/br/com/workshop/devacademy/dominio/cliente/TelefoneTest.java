package br.com.workshop.devacademy.dominio.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.workshop.devacademy.dominio.cliente.Telefone;

class TelefoneTest {


	@Test
	void naoDeveriaCriarTelefoneComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("100000001999999"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone(""));
	}

	@Test
	void deveriaPermitirCriarTelefoneComDDDENumeroValidos() {
		String numero = "989354401";
		Telefone telefone = new Telefone(numero);
		assertEquals(numero, telefone.getNumero());
	}

}
