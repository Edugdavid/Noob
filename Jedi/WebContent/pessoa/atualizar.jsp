<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">	
		<title>Cadastro</title>
		<script type="text/javascript" src="../JS/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="../JS/jquery.maskedinput-1.1.4.pack.js"/></script>
		<script type="text/javascript" src="../JS/maskCPF.js"/></script>
	</head>
	<body>
	<div align="center">
		<form method="post" action="../PessoaServlet">
		 		<input type="hidden" id="acao" name="acao" value="FinalizarEdicao">
		 		<input type="hidden" id="id" name="id" value="${pessoa.id}">
				<label>CPF:</label><input name="cpf" id="cpf" required value="${pessoa.cpf}" /><br /> 
				<label>Nome:</label><input name="nome" value="${pessoa.nome}"/><br />
				<label>Telefone:</label><input type="tel" name="telefone" value="${pessoa.telefone}" /><br />
				<label>Email:</label><input type="email" name="email" placeholder="jedi@gmail.com"  value="${pessoa.email}"/><br />	
				<label>Data do cadastro:</label><input disabled="disabled" type="text" name="dataCadastro" value="${pessoa.dataCadastro}"/><br /> 
				<input type="submit" value="alterar"><br />
		</form>
	</div>
	<a href="pessoas.jsp">Voltar</a>
	</body>
</html>