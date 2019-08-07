<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Clientes</title>
		<script type="text/javascript" src="../JS/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="../JS/table.js"></script>
		<script type="text/javascript" src="../JS/dataTables.min.js"></script>
		
		<link href="../CSS/jquery.dataTables.min.css" rel="stylesheet">
	</head>
	<body>
	<H1><c:out value="${mensagem}" /></H1>	
	<div align="center">
		<P>Lista de Clientes</P>
		<h3><a href="cadastrar.jsp">Cadastrar</a></h3><br>
		<table id="example" class="display" style="width:80%">
		  <thead>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Data Cadastro</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
        </thead>
         <tbody>
			<c:forEach var="pessoa" items="${pessoas}">
				<tr>
					<td>${pessoa.cpf}</td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.telefone}</td>
					<td>${pessoa.email}</td>
					<td>${pessoa.dataCadastroStr}</td>
					<td><a href="../PessoaServlet?acao=Editar&id=${pessoa.id}">Editar</a></td>
					<td><a href="../PessoaServlet?acao=Excluir&id=${pessoa.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Data Cadastro</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
        </tfoot>	
		</table>
		<c:if test="${fn:length(listaPessoa) > 0}">
   		Existem ${fn:length(listaPessoa)} clientes!
 		</c:if><br> 		
	</div>
	<a href="../index.jsp">Voltar</a>
	</body>
</html>
