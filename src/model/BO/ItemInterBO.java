package model.BO;

import java.util.List;

import model.VO.ItemVO;

public interface ItemInterBO {
	public void cadastrar(ItemVO item);
	public void excluir(ItemVO item);
	public void atualizar(ItemVO item);
	public void atualizarQuantidade(ItemVO item);
	public ItemVO buscarPorId(ItemVO item);
	public List<ItemVO> buscarPorNome(ItemVO item);
	public List<ItemVO> listar();
	public List<ItemVO> listarCopos();
	public List<ItemVO> listarCremes();
	public List<ItemVO> listarAcais();
	public List<ItemVO> listarRecheios();
	public List<ItemVO> listarCoberturas();
	public void cadastrarPreco(ItemVO copo, double preco);
	public void atualizarPreco(ItemVO copo, double preco);
}
