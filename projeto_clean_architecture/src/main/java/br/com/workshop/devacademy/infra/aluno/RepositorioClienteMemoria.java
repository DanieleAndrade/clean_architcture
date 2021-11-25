package br.com.workshop.devacademy.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.workshop.devacademy.dominio.cliente.Cliente;
import br.com.workshop.devacademy.dominio.cliente.ClienteNaoEncontradoException;
import br.com.workshop.devacademy.dominio.cliente.CPF;
import br.com.workshop.devacademy.dominio.cliente.RepositorioCliente;

public class RepositorioClienteMemoria implements RepositorioCliente {

	private List<Cliente> matriculados = new ArrayList<>();
	
	@Override
	public void salva(Cliente aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Cliente buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new ClienteNaoEncontradoException(cpf));
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		return this.matriculados;
	}

}
