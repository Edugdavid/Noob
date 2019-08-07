package com.pessoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.pessoa.entidade.Pessoa;

import br.com.pessoa.util.ConvertsDate;
import br.com.pessoa.util.DAO;
import br.com.pessoa.util.SessionDAO;

public class PessoaDAO implements SessionDAO {
	private PreparedStatement prepareStatement;
	private Statement stm;
	private Connection conexao;

	public void alterar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		conexao = conexao();
		prepareStatement = prepareStatement(conexao,
				"update pessoa SET nome = ?, telefone = ?, email = ? WHERE cpf = ? ");
		prepareStatement.setString(4, pessoa.getCpf());
		prepareStatement.setString(1, pessoa.getNome());
		prepareStatement.setString(3, pessoa.getEmail());
		prepareStatement.setString(2, pessoa.getTelefone());
		executeAndClose(conexao, prepareStatement);
	}

	public void excluir(Integer id) throws SQLException, ClassNotFoundException {
		conexao = conexao();
		prepareStatement = prepareStatement(conexao, "delete from pessoa where id = ? ");
		prepareStatement.setInt(1, id);
		executeAndClose(conexao, prepareStatement);
	}

	public boolean existe(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		boolean achou = false;
		conexao = conexao();
		prepareStatement = prepareStatement(conexao, "select * from pessoa where cpf =	?");
		prepareStatement.setString(1, pessoa.getCpf());
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			achou = true;
		}
		executeAndClose(conexao, prepareStatement);
		return achou;
	}

	public void inserir(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		conexao = conexao();
		prepareStatement = prepareStatement(conexao,
				"insert into pessoa (cpf, nome, telefone, email, dt_cadastro) values (?,?,?,?,?)");
		prepareStatement.setString(1, pessoa.getCpf());
		prepareStatement.setString(2, pessoa.getNome());
		prepareStatement.setString(4, pessoa.getEmail());
		prepareStatement.setString(3, pessoa.getTelefone());
		prepareStatement.setTimestamp(5, ConvertsDate.convertToDateViaSqlTimestamp(pessoa.getDataCadastro()));
		executeAndClose(conexao, prepareStatement);

	}

	public List<Pessoa> listarTodos() throws SQLException, ClassNotFoundException {
		List<Pessoa> lista = new ArrayList<>();
		conexao = conexao();
		stm = conexao.createStatement();
		ResultSet rs = stm.executeQuery("select * from pessoa");
		while (rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setCpf(rs.getString("cpf"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setTelefone(rs.getString("telefone"));
			pessoa.setDataCadastroStr(rs.getTimestamp("dt_cadastro"));
			lista.add(pessoa);
		}
		closeStmConnection(conexao, stm);
		return lista;
	}

	public Pessoa findById(Integer id) throws SQLException, ClassNotFoundException {
		conexao = conexao();
		Pessoa pessoa = null;
		prepareStatement = prepareStatement(conexao, "select * from pessoa where id = ?");
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			pessoa = new Pessoa(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("telefone"),
					rs.getString("email"), ConvertsDate.convertToEntityAttribute(rs.getTimestamp("dt_cadastro")),
					rs.getTimestamp("dt_cadastro") != null
							? ConvertsDate.convertToEntityAttribute(rs.getTimestamp("dt_cadastro")).format(
									DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
							: "Sem data");
		}
		executeAndClose(conexao, prepareStatement);
		return pessoa;
	}

	private PreparedStatement prepareStatement(Connection conexao, String sql) throws SQLException {
		return conexao.prepareStatement(sql);
	}

	@Override
	public Connection conexao() throws SQLException, ClassNotFoundException {
		return DAO.getInstance().getConnection();
	}

	public void closeStmConnection(Connection conexao, Statement stm) throws SQLException {
		stm.close();
		conexao.close();
	}

	public void executeAndClose(Connection conexao, PreparedStatement prepareStatement) throws SQLException {
		prepareStatement.execute();
		prepareStatement.close();
		conexao.close();
	}
}
