package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.DAO.UsuarioDAO;
import model.VO.TipoUsuario;
import model.VO.UsuarioVO;
import util.MyArrayList;

public class UsuarioBO implements UsuarioInterBO{
	UsuarioDAO usuarioDao = new UsuarioDAO();

	@Override
	public void cadastrar(UsuarioVO usuario) {
		usuarioDao.cadastrar(usuario);
	}

	@Override
	public void excluir(UsuarioVO usuario) {
		usuarioDao.excluir(usuario);
	}

	@Override
	public void atualizar(UsuarioVO usuario) {
		usuarioDao.atualizar(usuario);
	}

	@Override
	public List<UsuarioVO> listar() {
		List<UsuarioVO> lista = new MyArrayList<UsuarioVO>();
		ResultSet rs = usuarioDao.listar();
		
		try {
			while(rs.next()) {
				UsuarioVO usuario = new UsuarioVO();
				
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoUsuario(TipoUsuario.values()[rs.getInt("tipousuario")]);
				
				lista.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<UsuarioVO> buscarPorNome(UsuarioVO usuario) {
		List<UsuarioVO> lista = new MyArrayList<UsuarioVO>();
		ResultSet rs = usuarioDao.buscarPorNome(usuario);
		
		try {
			while(rs.next()) {
				UsuarioVO usu = new UsuarioVO();
				
				usu.setId(rs.getLong("id"));
				usu.setNome(rs.getString("nome"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setCpf(rs.getString("cpf"));
				usu.setSenha(rs.getString("senha"));
				usu.setTipoUsuario(TipoUsuario.values()[rs.getInt("tipousuario")]);
				
				lista.add(usu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<UsuarioVO> buscarPorId(UsuarioVO usuario) {
		List<UsuarioVO> lista = new MyArrayList<UsuarioVO>();
		ResultSet rs = usuarioDao.buscarPorId(usuario);
		
		try {
			while(rs.next()) {
				UsuarioVO usu = new UsuarioVO();
				
				usu.setId(rs.getLong("id"));
				usu.setNome(rs.getString("nome"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setCpf(rs.getString("cpf"));
				usu.setSenha(rs.getString("senha"));
				usu.setTipoUsuario(TipoUsuario.values()[rs.getInt("tipousuario")]);
				
				lista.add(usu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<UsuarioVO> buscarPorCpf(UsuarioVO usuario) {
		List<UsuarioVO> lista = new MyArrayList<UsuarioVO>();
		ResultSet rs = usuarioDao.buscarPorCpf(usuario);
		
		try {
			while(rs.next()) {
				UsuarioVO usu = new UsuarioVO();
				
				usu.setId(rs.getLong("id"));
				usu.setNome(rs.getString("nome"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setCpf(rs.getString("cpf"));
				usu.setSenha(rs.getString("senha"));
				usu.setTipoUsuario(TipoUsuario.values()[rs.getInt("tipousuario")]);
				
				lista.add(usu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

}
