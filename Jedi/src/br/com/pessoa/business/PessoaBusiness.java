package br.com.pessoa.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.pessoa.dao.PessoaDAO;
import com.pessoa.entidade.Pessoa;

public class PessoaBusiness extends GenericBusiness {
	private PessoaDAO dao = new PessoaDAO();

	public Map<String, String> cadastrar(Pessoa pessoa) {
		try {
			if (dao.existe(pessoa)) {
				return put("/pessoa/pessoas.jsp", "Pessoa ja cadastrada, cpf duplicado!");
			} else {
				dao.inserir(pessoa);
				return put("/pessoa/pessoas.jsp", "Pessoa cadastrada com sucesso!");
			}
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
			return put("../error.jsp", "Ops, ocorreu um erro ao cadastrar a pessoa!");
		}
	}

	public Map<String, String> editar(Pessoa pessoa) {
		try {
			if (pessoa.getId() == null) {
				return put("/pessoa/pessoas.jsp", "Pessoa com dados invalidos!");
			} else {
				dao.alterar(pessoa);
				return put("/pessoa/pessoas.jsp", "Pessoa editada com sucesso!");
			}
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
			return put("../error.jsp", "Ops, ocorreu um erro ao atualizar pessoa!");
		}
	}

	public Pessoa buscar(Integer id) {
		try {
			return dao.findById(id);
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	public Map<String, String> excluir(Integer id) {
		try {
			dao.excluir(id);
			return put("/pessoa/pessoas.jsp", "Pessoa removida com sucesso!");
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
			return put("../error.jsp", "Ops, ocorreu um erro ao remover a pessoa!");
		}
	}

	public List<Pessoa> listar() throws SQLException, ClassNotFoundException {
		return Optional.of(dao.listarTodos()).orElse(new ArrayList<Pessoa>());
	}
}
