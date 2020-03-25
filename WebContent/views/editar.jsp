<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/game/jogo?acao=editar" method="POST">
		<fieldset>
			<legend>Cadastro de Jogo:</legend>

			<input type="hidden" name="id" value="${jogo.id}">

			Nome:<br> <input type="text" name="nome" value="${jogo.nome}"> <br>
			Plataforma:<br> <input type="text" name="plataforma" value="${jogo.plataforma}"> <br> <br>

			<input type="submit" value="Salvar">
		</fieldset>
	</form>


</body>
</html>