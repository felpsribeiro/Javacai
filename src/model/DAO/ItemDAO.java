package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.ItemVO;
import model.VO.TipoItem;

public class ItemDAO extends BaseDAO implements ItemInterDAO{
	
	@Override
	public void cadastrar(ItemVO item){
		String sqlInsert = "insert into itens (nome, tipoItem, quantidade, porcao, unidadedeentrada) values (?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, item.getNome());
			ptst.setInt(2, item.getTipoItem().ordinal());
			ptst.setDouble(3, item.getQuantidade());
			ptst.setDouble(4, item.getPorcao());
			ptst.setString(5, item.getUnidadeDeEntrada());
			int affectedRolls = ptst.executeUpdate();
			
			if (affectedRolls == 0) {
				System.out.println("Cadastro de item não realizado");
				return;
			}
			
			ResultSet genKey = ptst.getGeneratedKeys();
			if(genKey.next()) {
				item.setId(genKey.getLong(1));
			} else {
				System.out.println("Cadastro de item falhou, id não retornado");
				return;
			}
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void excluir(ItemVO item) {
		String sqlDelete = "delete from itens where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlDelete);
			ptst.setLong(1, item.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void atualizar(ItemVO item) {
		String sqlUpdate = "update itens set "
				+ "nome = ?,"
				+ "tipoItem = ?,"
				+ "quantidade = ?,"
				+ "porcao = ?,"
				+ "unidadedeentrada = ?"
				+ " where id = ?;";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlUpdate);
			ptst.setString(1, item.getNome());
			ptst.setInt(2, item.getTipoItem().ordinal());
			ptst.setDouble(3, item.getQuantidade());
			ptst.setDouble(4, item.getPorcao());
			ptst.setString(5, item.getUnidadeDeEntrada());
			ptst.setLong(6, item.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void atualizarQuantidade(ItemVO item) {
		String sqlUpdate = "UPDATE itens SET quantidade= ? WHERE id= ?;";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlUpdate);
			ptst.setDouble(1, item.getQuantidade());
			ptst.setLong(2, item.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscarPorId(ItemVO item) {
		String sqlSearchById = "select * from itens where id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchById);
			ptst.setLong(1, item.getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet buscarPorNome(ItemVO item) {
		String sqlSearchById = "select * from itens where nome like ?;";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchById);
			ptst.setString(1, "%" + item.getNome() + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet listar() {
		String sqlSelect = "select * from itens";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet listarCopos() {
		String sqlSelect = "select * from itens where tipoItem = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			ptst.setInt(1, TipoItem.Copo.ordinal());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet listarCremes() {
		String sqlSelect = "select * from itens where tipoItem = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			ptst.setInt(1, TipoItem.Creme.ordinal());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet listarAcais() {
		String sqlSelect = "select * from itens where tipoItem = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			ptst.setInt(1, TipoItem.Acai.ordinal());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet listarRecheios() {
		String sqlSelect = "select * from itens where tipoItem = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			ptst.setInt(1, TipoItem.Recheio.ordinal());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public ResultSet listarCoberturas() {
		String sqlSelect = "select * from itens where tipoItem = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			ptst.setInt(1, TipoItem.Cobertura.ordinal());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	@Override
	public void cadastrarPreco(ItemVO copo, double preco) {
		String sqlInsert = "insert into precos (copo_id, preco) values (?, ?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlInsert);
			ptst.setLong(1, copo.getId());
			ptst.setDouble(2, preco);
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizarPreco(ItemVO copo, double preco) {
		String sqlInsert = "update precos set preco = ? where copo_id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlInsert);
			ptst.setDouble(1, preco);
			ptst.setLong(2, copo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
