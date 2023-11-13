package br.com.fiap.ursa.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.ursa.model.entity.Acessorio;
import br.com.fiap.ursa.model.entity.Documento;

public class DocumentoRepository extends Repository{

	public static Documento save(Documento documento) {
		String sql = "insert into tb_documentos" + "(id_documentos, id_bicicleta, id_cliente, boleto_bicicleta, nota_fiscal_bicicleta, foto_bicicleta)"
				+ " values(SQ_TB_DOCUMENTOS.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, documento.getIdBicicleta());
			ps.setInt(2, documento.getIdCliente());
			ps.setString(3, documento.getBoleto());
			ps.setString(4, documento.getNotaFiscal());
			ps.setString(5, documento.getFoto());
			if (ps.executeUpdate() > 0) {
				return documento;
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
	
	public static ArrayList<Documento> findAll() {
		ArrayList<Documento> documentos = new ArrayList<Documento>();
		String sql = "select * from tb_documentos";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Documento documento = new Documento();
					documento.setId(rs.getInt("id_documentos"));
					documento.setIdBicicleta(rs.getInt("id_bicicleta"));
					documento.setIdCliente(rs.getInt("id_cliente"));
					documento.setBoleto(rs.getString("boleto_bicicleta"));
					documento.setNotaFiscal(rs.getString("nota_fiscal_bicicleta"));
					documento.setFoto(rs.getString("foto_bicicleta"));
					documentos.add(documento);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return documentos;
	}
	
	public static Documento findById(int id) {
		String sql = "select * from tb_documentos where id_documentos=?";
		Documento documento = new Documento();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				documento.setId(id);
				documento.setIdBicicleta(rs.getInt("id_bicicleta"));
				documento.setIdCliente(rs.getInt("id_cliente"));
				documento.setBoleto(rs.getString("boleto_bicicleta"));
				documento.setNotaFiscal(rs.getString("nota_fiscal_bicicleta"));
				documento.setFoto(rs.getString("foto_bicicleta"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return documento;
	}
	
	public static Documento update(Documento documento) {
		String sql = "UPDATE tb_documentos SET id_bicicleta=?, id_cliente=?, boleto_bicicleta=?, nota_fiscal_bicicleta=?, foto_bicicleta=? WHERE id_documentos=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, documento.getIdBicicleta());
			ps.setInt(2, documento.getIdCliente());
			ps.setString(3, documento.getBoleto());
			ps.setString(4, documento.getNotaFiscal());
			ps.setString(5, documento.getFoto());
			ps.setInt(6, documento.getId());
			if (ps.executeUpdate() > 0) {
				return documento;
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
		String sql = "delete from tb_documentos where id_documentos=?";
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
