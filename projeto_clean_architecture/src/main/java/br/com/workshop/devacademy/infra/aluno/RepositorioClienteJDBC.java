package br.com.workshop.devacademy.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.workshop.devacademy.dominio.cliente.Cliente;
import br.com.workshop.devacademy.dominio.cliente.ClienteNaoEncontradoException;
import br.com.workshop.devacademy.dominio.cliente.CPF;
import br.com.workshop.devacademy.dominio.cliente.Email;
import br.com.workshop.devacademy.dominio.cliente.RepositorioCliente;
import br.com.workshop.devacademy.dominio.cliente.Telefone;

public class RepositorioClienteJDBC implements RepositorioCliente {

	private final Connection connection;
	
	public RepositorioClienteJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salva(Cliente aluno) {
		try {
			String sql = "INSERT INTO CLIENTE VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getNumero());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Cliente buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM CLIENTE WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new ClienteNaoEncontradoException(cpf);
			}

			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Cliente encontrado = new Cliente(cpf, nome, email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String numero = rs.getString("numero");
				encontrado.adicionarTelefone(numero);
			}
			
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM CLIENTE";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String nome = rs.getString("nome");
				Email email = new Email(rs.getString("email"));
				Cliente cliente = new Cliente(cpf, nome, email);
				
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE cliente_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String numero = rsTelefone.getString("numero");
					cliente.adicionarTelefone(numero);
				}
			
				clientes.add(cliente);
			}
			
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
