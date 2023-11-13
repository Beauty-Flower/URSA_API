package br.com.fiap.ursa.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.ursa.model.entity.Acessorio;

public class AcessorioRepository extends Repository{

	public static Acessorio save(Acessorio acessorio) {
		String sql = "insert into tb_acessorio" + "(id_acessorio, id_bicicleta, id_cliente, ds_acessorio, valor_acessorio)"
				+ " values(SQ_TB_ACESSORIOS.NEXTVAL, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, acessorio.getIdBicicleta());
			ps.setInt(2, acessorio.getIdCliente());
			ps.setString(3, acessorio.getDescricao());
			ps.setFloat(4, acessorio.getValor());
			if (ps.executeUpdate() > 0) {
				return acessorio;
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
	
	public static ArrayList<Acessorio> findAll() {
		ArrayList<Acessorio> acessorios = new ArrayList<Acessorio>();
		String sql = "select * from tb_acessorio";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Acessorio acessorio = new Acessorio();
					acessorio.setId(rs.getInt("id_acessorio"));
					acessorio.setIdBicicleta(rs.getInt("id_bicicleta"));
					acessorio.setIdCliente(rs.getInt("id_cliente"));
					acessorio.setDescricao(rs.getString("ds_acessorio"));
					acessorio.setValor(rs.getFloat("valor_acessorio"));
					acessorios.add(acessorio);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return acessorios;
	}
	
	public static Acessorio findById(int id) {
		String sql = "select * from tb_acessorio where id_acessorio=?";
		Acessorio acessorio = new Acessorio();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				acessorio.setId(id);
				acessorio.setIdBicicleta(rs.getInt("id_bicicleta"));
				acessorio.setIdCliente(rs.getInt("id_cliente"));
				acessorio.setDescricao(rs.getString("ds_descricao"));
				acessorio.setValor(rs.getFloat("valor_acessorio"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return acessorio;
	}
	
	public static Acessorio update(Acessorio acessorio) {
		String sql = "UPDATE tb_acessorio SET id_bicicleta=?, id_cliente=?, ds_acessorio=?, valor_acessorio=? WHERE id_acessorio=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, acessorio.getIdBicicleta());
			ps.setInt(2, acessorio.getIdCliente());
			ps.setString(3, acessorio.getDescricao());
			ps.setFloat(4, acessorio.getValor());
			ps.setInt(5, acessorio.getId());
			if (ps.executeUpdate() > 0) {
				return acessorio;
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
		String sql = "delete from tb_acessorio where id_acessorio=?";
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
