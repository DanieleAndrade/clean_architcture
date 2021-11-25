package br.com.workshop.devacademy.aplicacao.cliente.criar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.workshop.devacademy.dominio.cliente.Cliente;
import br.com.workshop.devacademy.infra.cliente.RepositorioClienteMemoria;
import br.com.workshop.devacademy.aplicacao.cliente.criar.CriarCliente;
import br.com.workshop.devacademy.aplicacao.cliente.criar.CriarClienteDto;
import br.com.workshop.devacademy.dominio.cliente.CPF;

class CriarClienteTest {

	@Test
	void deveriaSalvarCliente() {
		
		RepositorioClienteMemoria repositorio = new RepositorioClienteMemoria();
		CriarCliente useCase = new CriarCliente(repositorio);
		
		CriarClienteDto dados = new CriarClienteDto(
				"Cliente 1", 
				"123.456.789-00", 
				"cliente@gmail.com");
		useCase.executa(dados);
		
		Cliente encontrado = repositorio.buscarPorCPF(
				new CPF("123.456.789-00"));
		
		assertEquals("Cliente 1", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getCpf());
		assertEquals("cliente@gmail.com", encontrado.getEmail());
	}

}
