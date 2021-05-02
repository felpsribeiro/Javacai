package model.BO;

import java.util.Calendar;
import java.util.List;

import model.VO.ItemVO;
import model.VO.PedidoVO;

public interface PedidoInterBO {
	public void cadastrar(PedidoVO pedido);
	public void excluir(PedidoVO pedido);
	public void atualizar(PedidoVO pedido);
	public List<PedidoVO> listar();
	public List<PedidoVO> buscarPorData(Calendar inicio, Calendar fim);
	public double buscarPrecoPorCopo(ItemVO copo);
}
