package model.DAO;

import java.sql.ResultSet;
import java.util.Calendar;

import model.VO.ItemVO;
import model.VO.PedidoVO;

public interface PedidoInterDAO {
	public void cadastrar(PedidoVO pedido);
	public void excluir(PedidoVO pedido);
	public void atualizar(PedidoVO pedido);
	public ResultSet listar();
	public ResultSet buscarPorData(Calendar inicio, Calendar fim);
	public double buscarPrecoPorCopo(ItemVO copo);
	public ResultSet buscarPorId(PedidoVO pedido);
	public ResultSet buscarPorCopo(PedidoVO pedido);
}
