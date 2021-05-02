package model.DAO;

import java.sql.ResultSet;

import model.VO.UsuarioVO;

public interface UsuarioInterDAO {
	public void cadastrar(UsuarioVO usuario);
	public void excluir(UsuarioVO usuario);
	public void atualizar(UsuarioVO usuario);
	public ResultSet listar();
	public ResultSet buscarPorNome(UsuarioVO usuario);
	public ResultSet buscarPorId(UsuarioVO usuario);
	public ResultSet buscarPorCpf(UsuarioVO usuario);
}
