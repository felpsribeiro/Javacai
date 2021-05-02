package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.UsuarioVO;

public class UsuarioDAO extends BaseDAO implements UsuarioInterDAO {

	@Override
	public void cadastrar(UsuarioVO usuario) {
		String sqlInsert = "insert into usuarios (nome, telefone, cpf, senha, tipousuario) values (?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, usuario.getNome());
			ptst.setString(2, usuario.getTelefone());
			ptst.setString(3, usuario.getCpf());
			ptst.setString(4, usuario.getSenha());
			ptst.setInt(5, usuario.getTipoUsuario().ordinal());
			
			int affectedRolls = ptst.executeUpdate();
			
			if(affectedRolls == 0) {
				System.out.println("Falha em cadastro, usuário não cadastrado.");
				return;
			}
			
			ResultSet genKey = ptst.getGeneratedKeys();
			if(genKey.next()) {
				usuario.setId(genKey.getLong(1));
			} else {
				System.out.println("Falha ao obter Id de usuário cadastrado.");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(UsuarioVO usuario) {
		String sqlDelete = "delete from usuarios where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sqlDelete);
			ptst.setLong(1, usuario.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(UsuarioVO usuario) {
		String sqlUpdate = "update usuarios set "
				+ "nome = ?,"
				+ "telefone = ?,"
				+ "cpf = ?,"
				+ "senha = ?,"
				+ "tipousuario = ?"
				+ " where id = ?;";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlUpdate);
			ptst.setString(1, usuario.getNome());
			ptst.setString(2, usuario.getTelefone());
			ptst.setString(3, usuario.getCpf());
			ptst.setString(4, usuario.getSenha());
			ptst.setInt(5, usuario.getTipoUsuario().ordinal());
			ptst.setLong(6, usuario.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() {
		String sqlSelect = "select * from usuarios";
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
	public ResultSet buscarPorNome(UsuarioVO usuario) {
		String sqlSearchByName = "select * from usuarios where nome like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchByName);
			ptst.setString(1, usuario.getNome() + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet buscarPorId(UsuarioVO usuario) {
		String sqlSearchById = "select * from usuarios where id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchById);
			ptst.setLong(1, usuario.getId());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet buscarPorCpf(UsuarioVO usuario) {
		String sqlSearchByCpf = "select * from usuarios where cpf like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchByCpf);
			ptst.setString(1, usuario.getCpf() + "%");
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
