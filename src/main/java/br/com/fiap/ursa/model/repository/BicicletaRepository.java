	package br.com.fiap.ursa.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.ursa.model.entity.Bicicleta;

public class BicicletaRepository extends Repository{

	public static Bicicleta save(Bicicleta bicicleta) {
		String sql = "insert into tb_bicicleta" + "(id_bicicleta, id_cliente, nr_serie, modelo_bicicleta, marca_bicicleta, valor_bicicleta)"
				+ " values(SQ_TB_BICICLETA.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdCliente());
			ps.setString(2, bicicleta.getNumeroSerie());
			ps.setString(3, bicicleta.getModelo());
			ps.setString(4, bicicleta.getMarca());
			ps.setFloat(5, bicicleta.getValor());
			if (ps.executeUpdate() > 0) {
				return bicicleta;
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
	
	public static ArrayList<Bicicleta> findAll() {
		ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
		String sql = "select * from tb_bicicleta";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Bicicleta bicicleta = new Bicicleta();
					bicicleta.setId(rs.getInt("id_bicicleta"));
					bicicleta.setIdCliente(rs.getInt("id_cliente"));
					bicicleta.setNumeroSerie(rs.getString("nr_serie"));
					bicicleta.setModelo(rs.getString("modelo_bicicleta"));
					bicicleta.setMarca(rs.getString("marca_bicicleta"));
					bicicleta.setValor(rs.getFloat("valor_bicicleta"));
					bicicletas.add(bicicleta);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return bicicletas;
	}
	
	public static Bicicleta findById(int id) {
		String sql = "select * from tb_bicicleta where id_bicicleta=?";
		Bicicleta bicicleta = new Bicicleta();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				bicicleta.setId(id);
				bicicleta.setIdCliente(rs.getInt("id_cliente"));
				bicicleta.setNumeroSerie(rs.getString("nr_serie"));
				bicicleta.setModelo(rs.getString("modelo_bicicleta"));
				bicicleta.setMarca(rs.getString("marca_bicicleta"));
				bicicleta.setValor(rs.getFloat("valor_bicicleta"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return bicicleta;
	}
	
	public static Bicicleta update(Bicicleta bicicleta) {
		String sql = "UPDATE tb_bicicleta SET id_cliente=?, nr_serie=?, modelo_bicicleta=?, marca_bicicleta=?, valor_bicicleta=? WHERE id_bicicleta=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdCliente());
			ps.setString(2, bicicleta.getNumeroSerie());
			ps.setString(3, bicicleta.getModelo());
			ps.setString(4, bicicleta.getMarca());
			ps.setFloat(5, bicicleta.getValor());
			ps.setInt(6, bicicleta.getId());
			if (ps.executeUpdate() > 0) {
				return bicicleta;
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
		String sql = "delete from tb_bicicleta where id_bicicleta=?";
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
