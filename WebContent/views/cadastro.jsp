<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/game/jogo?acao=cadastrar" method="POST">
		<fieldset>
			<legend>Cadastro de Jogo:</legend>
			
			Nome:<br> 
			<input type="text" name="nome"> <br> 
			Plataforma:<br> 
			<input type="text" name="plataforma"> <br> <br>
			
			<input type="submit" value="Salvar">
		</fieldset>
	</form>

</body>
</html>