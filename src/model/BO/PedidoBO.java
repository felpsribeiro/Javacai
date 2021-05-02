package model.BO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.DAO.PedidoDAO;
import model.VO.ItemVO;
import model.VO.PedidoVO;

public class PedidoBO implements PedidoInterBO{
	PedidoDAO pedidoDao = new PedidoDAO();
	ItemBO itemBo = new ItemBO();

	@Override
	public void cadastrar(PedidoVO pedido) {
		pedidoDao.cadastrar(pedido);
	}

	@Override
	public void excluir(PedidoVO pedido) {
		pedidoDao.excluir(pedido);
	}

	@Override
	public void atualizar(PedidoVO pedido) {
		pedidoDao.atualizar(pedido);
	}

	@Override
	public List<PedidoVO> listar() {
		List<PedidoVO> lista = new ArrayList<PedidoVO>();
		ResultSet rs = pedidoDao.listar();
		ItemVO item = new ItemVO();
		
		try {
			while(rs.next()) {
				PedidoVO pedido = new PedidoVO();
				
				
				pedido.setId(rs.getLong("id"));
				item.setId(rs.getLong("copo_id"));
				pedido.setCopo(itemBo.buscarPorId(item));
				
				item.setId(rs.getLong("creme_id"));
				pedido.setCreme(itemBo.buscarPorId(item));
				
				item.setId(rs.getLong("acai_id"));
				pedido.setAcai(itemBo.buscarPorId(item));
				
				item.setId(rs.getLong("cobertura_id"));
				pedido.setCobertura(itemBo.buscarPorId(item));
				
				List<ItemVO> listaRecheios = new ArrayList<ItemVO>();
				item.setId(rs.getLong("recheio1_id"));
				listaRecheios.add(itemBo.buscarPorId(item));
				item.setId(rs.getLong("recheio2_id"));
				listaRecheios.add(itemBo.buscarPorId(item));
				item.setId(rs.getLong("recheio3_id"));
				listaRecheios.add(itemBo.buscarPorId(item));
				pedido.setRecheios(listaRecheios);
				
				Date date = rs.getDate("datapedido");
				Time time = rs.getTime("horariopedido");
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(date);
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(time);
				cal1.set(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY));
				cal1.set(Calendar.MINUTE, cal2.get(Calendar.MINUTE));
				cal1.set(Calendar.SECOND, cal2.get(Calendar.SECOND));
				pedido.setDataPedido(cal1);
				
				lista.add(pedido);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<PedidoVO> buscarPorData(Calendar inicio, Calendar fim) {
		List<PedidoVO> lista = new ArrayList<PedidoVO>();
		ResultSet rs = pedidoDao.buscarPorData(inicio, fim);
		ItemVO item = new ItemVO();
		
		try {
			while(rs.next()) {
				PedidoVO pedido = new PedidoVO();
				
				
				pedido.setId(rs.getLong("id"));
				item.setId(rs.getLong("copo_id"));
				pedido.setCopo(itemBo.buscarPorId(item));
				
				item.setId(rs.getLong("creme_id"));
				pedido.setCreme(itemBo.buscarPorId(item));
				
				item.setId(rs.getLong("acai_id"));
				pedido.setAcai(itemBo.buscarPorId(item));
				
				item.setId(rs.getLong("cobertura_id"));
				pedido.setCobertura(itemBo.buscarPorId(item));
				
				List<ItemVO> listaRecheios = new ArrayList<ItemVO>();
				item.setId(rs.getLong("recheio1_id"));
				listaRecheios.add(itemBo.buscarPorId(item));
				item.setId(rs.getLong("recheio2_id"));
				listaRecheios.add(itemBo.buscarPorId(item));
				item.setId(rs.getLong("recheio3_id"));
				listaRecheios.add(itemBo.buscarPorId(item));
				pedido.setRecheios(listaRecheios);
				
				Date date = rs.getDate("datapedido");
				Time time = rs.getTime("horariopedido");
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(date);
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(time);
				cal1.set(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY));
				cal1.set(Calendar.MINUTE, cal2.get(Calendar.MINUTE));
				cal1.set(Calendar.SECOND, cal2.get(Calendar.SECOND));
				pedido.setDataPedido(cal1);
				
				lista.add(pedido);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public double buscarPrecoPorCopo(ItemVO copo) {
		return pedidoDao.buscarPrecoPorCopo(copo);
	}

}
