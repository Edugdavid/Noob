<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">	
		<title>Cadastro</title>
		<script type="text/javascript" src="../JS/jquery-1.2.6.pack.js"></script>
		<script type="text/javascript" src="../JS/jquery.maskedinput-1.1.4.pack.js"/></script>
		<script type="text/javascript" src="../JS/maskCPF.js"/></script>
	</head>
	<body>
	<div align="center">
		<form method="post" action="../PessoaServlet">
		 		<input type="hidden" id="acao" name="acao" value="Cadastrar">
				<label>CPF: </label><input name="cpf" id="cpf" required value="${pessoa.cpf}" /><br /> 
				<label>Nome:</label><input name="nome" autofocus="autofocus"  value="${pessoa.nome}"/><br />
				 <label>Telefone:</label><input type="tel" name="telefone" value="${pessoa.telefone}" /><br />
				 <label>Email:</label><input type="email" name="email" placeholder="jedi@gmail.com"  value="${pessoa.email}"/><br />	
				 <input type="submit" value="Salvar"> <br />
		</form>
	</div>
	<a href="pessoas.jsp">Voltar</a>
	</body>
</html>