package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.time.Instant;
import java.util.Calendar;

import model.VO.ItemVO;
import model.VO.PedidoVO;

public class PedidoDAO extends BaseDAO implements PedidoInterDAO{

	@Override
	public void cadastrar(PedidoVO pedido) {
		String sqlInsert = "insert into pedidos (copo_id, creme_id, acai_id, "
				+ "recheio1_id, recheio2_id, recheio3_id, cobertura_id, preco, datapedido, horariopedido) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			
			if(pedido.getCopo() != null) {
				ptst.setLong(1, pedido.getCopo().getId());
			} else {
				System.out.println("Pedido sem copo");
				return;
			}
			
			if(pedido.getCreme() != null) {
				ptst.setLong(2, pedido.getCreme().getId());
			} else {
				ptst.setNull(2, Types.BIGINT);
			}
			
			if(pedido.getAcai() != null) {
				ptst.setLong(3, pedido.getAcai().getId());
			} else {
				System.out.println("Pedido sem copo");
				return;
			}
			
			if(pedido.getRecheios().get(0) != null) {
				ptst.setLong(4, pedido.getRecheios().get(0).getId());
			} else {
				ptst.setNull(4, Types.BIGINT);
			}
			
			if(pedido.getRecheios().get(1) != null) {
				ptst.setLong(5, pedido.getRecheios().get(1).getId());
			} else {
				ptst.setNull(5, Types.BIGINT);
			}
			
			if(pedido.getRecheios().get(2) != null) {
				ptst.setLong(6, pedido.getRecheios().get(2).getId());
			} else {
				ptst.setNull(6, Types.BIGINT);
			}
			
			if(pedido.getCobertura() != null) {
				ptst.setLong(7, pedido.getCobertura().getId());
			} else {
				ptst.setNull(7, Types.BIGINT);
			}
			
			ptst.setDouble(8, pedido.getPreco());
			
			Instant instant = Instant.now();
			Date date = new Date(instant.toEpochMilli());
			ptst.setDate(9, date);
	
			Time time = new Time(instant.toEpochMilli());
			ptst.setTime(10, time);
			
			int affectedRolls = ptst.executeUpdate();
			
			if (affectedRolls == 0) {
				System.out.println("Cadastro de pedido não realizado");
				return;
			}
			
			ResultSet genKey = ptst.getGeneratedKeys();
			if(genKey.next()) {
				pedido.setId(genKey.getLong(1));
			} else {
				System.out.println("Cadastro de pedido falhou, id não retornado");
				return;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(PedidoVO pedido) {
		String sqlDelete = "delete from pedidos where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlDelete);
			ptst.setLong(1, pedido.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(PedidoVO pedido) {
		String sqlUpdate = "update pedidos set "
				+ "copo_id = ?,"
				+ "creme_id = ?,"
				+ "acai_id = ?,"
				+ "recheio1_id = ?"
				+ "recheio2_id = ?"
				+ "recheio3_id = ?"
				+ "cobertura_id = ?"
				+ "preco = ?"
				+ " where id = ?;";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlUpdate);
			
			if(pedido.getCopo() != null) {
				ptst.setLong(1, pedido.getCopo().getId());
			} else {
				System.out.println("Pedido sem copo");
				return;
			}
			
			if(pedido.getCreme() != null) {
				ptst.setLong(2, pedido.getCreme().getId());
			} else {
				ptst.setNull(2, Types.BIGINT);
			}
			
			if(pedido.getAcai() != null) {
				ptst.setLong(3, pedido.getAcai().getId());
			} else {
				System.out.println("Pedido sem copo");
				return;
			}
			
			if(pedido.getRecheios().get(0) != null) {
				ptst.setLong(4, pedido.getRecheios().get(0).getId());
			} else {
				ptst.setNull(4, Types.BIGINT);
			}
			
			if(pedido.getRecheios().get(1) != null) {
				ptst.setLong(5, pedido.getRecheios().get(1).getId());
			} else {
				ptst.setNull(5, Types.BIGINT);
			}
			
			if(pedido.getRecheios().get(2) != null) {
				ptst.setLong(6, pedido.getRecheios().get(2).getId());
			} else {
				ptst.setNull(6, Types.BIGINT);
			}
			
			if(pedido.getCobertura() != null) {
				ptst.setLong(7, pedido.getCobertura().getId());
			} else {
				ptst.setNull(7, Types.BIGINT);
			}
			
			ptst.setDouble(8, pedido.getPreco());
			
			ptst.setLong(9, pedido.getId());
			
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() {
		String sqlSelect = "select * from pedidos";
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
	public ResultSet buscarPorData(Calendar inicio, Calendar fim) {
		String sqlSearchByDate = "select * from pedidos where datapedido between ? and ? ";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchByDate);
			ptst.setDate(1, new Date(inicio.getTimeInMillis()));
			ptst.setDate(2, new Date(fim.getTimeInMillis()));
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public double buscarPrecoPorCopo(ItemVO copo) {
		String sqlSearchPrice = "select * from precos where copo_id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		double preco = 0;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchPrice);
			ptst.setLong(1, copo.getId());
			rs = ptst.executeQuery();
			preco = rs.getDouble("preco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preco;
	}

	@Override
	public ResultSet buscarPorId(PedidoVO pedido) {
		String sqlSearch = "select * from pedidos where id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearch);
			ptst.setLong(1, pedido.getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet buscarPorCopo(PedidoVO pedido) {
		String sqlSearch = "select * from pedidos where copo_id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearch);
			ptst.setLong(1, pedido.getCopo().getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}
