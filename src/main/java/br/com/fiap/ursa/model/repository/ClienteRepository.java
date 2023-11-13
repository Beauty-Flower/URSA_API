package br.com.fiap.ursa.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.ursa.model.entity.Cliente;

public class ClienteRepository extends Repository{
	
	public static Cliente save(Cliente cliente) {
		String sql = "insert into tb_cliente" + "(id_cliente, nm_cliente, cpf_cliente, senha_cliente)"
				+ " values(SQ_TB_CLIENTE.NEXTVAL, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setLong(2, cliente.getCpf());
			ps.setString(3, cliente.getSenha());
			if (ps.executeUpdate() > 0) {
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static ArrayList<Cliente> findAll() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from tb_cliente";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("id_cliente"));
					cliente.setNome(rs.getString("nm_cliente"));
					cliente.setCpf(rs.getLong("cpf_cliente"));
					cliente.setSenha(rs.getString("senha_cliente"));
					clientes.add(cliente);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return clientes;
	}
	
	public static Cliente findById(int id) {
		String sql = "select * from tb_cliente where id_cliente=?";
		Cliente cliente = new Cliente();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				cliente.setId(id);
				cliente.setNome(rs.getString("nm_cliente"));
				cliente.setCpf(rs.getLong("cpf_cliente"));
				cliente.setSenha(rs.getString("senha_cliente"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return cliente;
	}
	
	public static Cliente update(Cliente cliente) {
		String sql = "UPDATE tb_cliente SET nm_cliente=?, cpf_cliente=?, senha_cliente=? WHERE id_cliente=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setLong(2, cliente.getCpf());
			ps.setString(3, cliente.getSenha());
			ps.setInt(4, cliente.getId());
			if (ps.executeUpdate() > 0) {
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(int id) {
		String sql = "delete from tb_cliente where id_cliente=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao deletar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
}
