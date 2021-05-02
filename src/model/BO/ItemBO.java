package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ItemDAO;
import model.VO.ItemVO;
import model.VO.TipoItem;

public class ItemBO implements ItemInterBO{
	ItemDAO itemDao = new ItemDAO();

	@Override
	public void cadastrar(ItemVO item) {
		itemDao.cadastrar(item);
	}

	@Override
	public void excluir(ItemVO item) {
		itemDao.excluir(item);
	}

	@Override
	public void atualizar(ItemVO item) {
		itemDao.atualizar(item);
	}
	
	@Override
	public ItemVO buscarPorId(ItemVO item) {
		ItemVO resultado = new ItemVO();
		ResultSet rs = itemDao.buscarPorId(item);
		
		try {
			if(rs.next()) {
				resultado.setId(rs.getLong("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				resultado.setQuantidade(rs.getDouble("quantidade"));
				resultado.setPorcao(rs.getDouble("porcao"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	@Override
	public List<ItemVO> buscarPorNome(ItemVO item){
		List<ItemVO> lista = new ArrayList<ItemVO>();
		ResultSet rs = itemDao.buscarPorNome(item);
		
		try {
			while(rs.next()) {
				ItemVO resultado = new ItemVO();
				
				resultado.setId(rs.getLong("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				resultado.setQuantidade(rs.getDouble("quantidade"));
				resultado.setPorcao(rs.getDouble("porcao"));
				
				lista.add(resultado);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<ItemVO> listar() {
		List<ItemVO> lista = new ArrayList<ItemVO>();
		
		ResultSet rs = itemDao.listar();
		
		try {
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setId(rs.getLong("id"));
				item.setNome(rs.getString("nome"));
				item.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				item.setQuantidade(rs.getDouble("quantidade"));
				item.setPorcao(rs.getDouble("porcao"));
				
				lista.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<ItemVO> listarCopos() {
List<ItemVO> lista = new ArrayList<ItemVO>();
		
		ResultSet rs = itemDao.listarCopos();
		
		try {
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setId(rs.getLong("id"));
				item.setNome(rs.getString("nome"));
				item.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				item.setQuantidade(rs.getDouble("quantidade"));
				item.setPorcao(rs.getDouble("porcao"));
				
				lista.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<ItemVO> listarCremes() {
List<ItemVO> lista = new ArrayList<ItemVO>();
		
		ResultSet rs = itemDao.listarCremes();
		
		try {
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setId(rs.getLong("id"));
				item.setNome(rs.getString("nome"));
				item.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				item.setQuantidade(rs.getDouble("quantidade"));
				item.setPorcao(rs.getDouble("porcao"));
				
				lista.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<ItemVO> listarAcais() {
List<ItemVO> lista = new ArrayList<ItemVO>();
		
		ResultSet rs = itemDao.listarAcais();
		
		try {
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setId(rs.getLong("id"));
				item.setNome(rs.getString("nome"));
				item.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				item.setQuantidade(rs.getDouble("quantidade"));
				item.setPorcao(rs.getDouble("porcao"));
				
				lista.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<ItemVO> listarRecheios() {
List<ItemVO> lista = new ArrayList<ItemVO>();
		
		ResultSet rs = itemDao.listarRecheios();
		
		try {
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setId(rs.getLong("id"));
				item.setNome(rs.getString("nome"));
				item.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				item.setQuantidade(rs.getDouble("quantidade"));
				item.setPorcao(rs.getDouble("porcao"));
				
				lista.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<ItemVO> listarCoberturas() {
List<ItemVO> lista = new ArrayList<ItemVO>();
		
		ResultSet rs = itemDao.listarCoberturas();
		
		try {
			while(rs.next()) {
				ItemVO item = new ItemVO();
				
				item.setId(rs.getLong("id"));
				item.setNome(rs.getString("nome"));
				item.setTipoItem(TipoItem.values()[rs.getInt("tipoitem")]);
				item.setQuantidade(rs.getDouble("quantidade"));
				item.setPorcao(rs.getDouble("porcao"));
				
				lista.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void cadastrarPreco(ItemVO copo, double preco) {
		itemDao.cadastrarPreco(copo, preco);
	}

	@Override
	public void atualizarPreco(ItemVO copo, double preco) {
		itemDao.atualizarPreco(copo, preco);
	}

	

}
