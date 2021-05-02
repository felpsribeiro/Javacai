package model.BO;

import java.util.List;

import model.VO.UsuarioVO;

public interface UsuarioInterBO {
	public void cadastrar(UsuarioVO usuario);
	public void excluir(UsuarioVO usuario);
	public void atualizar(UsuarioVO usuario);
	public List<UsuarioVO> listar();
	public List<UsuarioVO> buscarPorNome(UsuarioVO usuario);
	public List<UsuarioVO> buscarPorId(UsuarioVO usuario);
	public List<UsuarioVO> buscarPorCpf(UsuarioVO usuario);
}
