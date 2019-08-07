package com.pessoa.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pessoa.entidade.Pessoa;

import br.com.pessoa.business.PessoaBusiness;

@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = new Pessoa();
	private PessoaBusiness business = new PessoaBusiness();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handlerRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handlerRequest(request, response);
	}

	private void handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "Listar":
				request.getSession().setAttribute("pessoas", business.listar());
				response.sendRedirect(request.getContextPath() + "/pessoa/pessoas.jsp");
				break;
			case "Cadastrar":
				Map<String, String> result = business.cadastrar(montarPessoa(request, pessoa));
				request.getSession().setAttribute("pessoas", business.listar());
				request.getSession().setAttribute("mensagem", result.get("msg"));
				response.sendRedirect(request.getContextPath() + result.get("url"));
				break;
			case "Excluir":
				Map<String, String> resultExcluir = business
						.excluir(Optional.of(Integer.parseInt(request.getParameter("id"))).orElse(0));
				request.getSession().setAttribute("pessoas", business.listar());
				request.getSession().setAttribute("mensagem", resultExcluir.get("msg"));
				response.sendRedirect(request.getContextPath() + "/pessoa/pessoas.jsp");
				break;
			case "Editar":
				request.getSession().setAttribute("pessoa",
						business.buscar(Optional.of(Integer.parseInt(request.getParameter("id"))).orElse(0)));
				response.sendRedirect(request.getContextPath() + "/pessoa/atualizar.jsp");
				break;
			case "FinalizarEdicao":
				Map<String, String> resultEditar = business.editar(montarPessoa(request, pessoa));
				request.getSession().setAttribute("pessoas", business.listar());
				request.getSession().setAttribute("mensagem", resultEditar.get("msg"));
				response.sendRedirect(request.getContextPath() + resultEditar.get("url"));
				break;
			default:
				request.getRequestDispatcher("pessoas.jsp");
				break;
			}
		} catch (Exception e) {
			request.setAttribute("mensagem", "Ops, ocorreu um erro, reporte ao administrador.");
			request.getRequestDispatcher("index.jsp");
			e.printStackTrace();
		}
	}

	private Pessoa montarPessoa(HttpServletRequest request, Pessoa pessoa) {
		pessoa.setId(Integer.parseInt(request.getParameter("id")));
		pessoa.setCpf(request.getParameter("cpf").replaceAll("[^0-9]", ""));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setTelefone(request.getParameter("telefone"));
		pessoa.setEmail(request.getParameter("email"));

		return pessoa;
	}
}
