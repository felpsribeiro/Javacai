package model.DAO;

import java.sql.ResultSet;

import model.VO.ItemVO;

public interface ItemInterDAO {
	public void cadastrar(ItemVO item);
	public void excluir(ItemVO item);
	public void atualizar(ItemVO item);
	public ResultSet buscarPorId(ItemVO item);
	public ResultSet buscarPorNome(ItemVO item);
	public ResultSet listar();
	public ResultSet listarCopos();
	public ResultSet listarCremes();
	public ResultSet listarAcais();
	public ResultSet listarRecheios();
	public ResultSet listarCoberturas();
	public void cadastrarPreco(ItemVO copo, double preco);
	public void atualizarPreco(ItemVO copo, double preco);
}
