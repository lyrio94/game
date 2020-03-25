<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="views/cadastro.jsp">Cadastrar</a>
	<table border="5" align="center">
		<tr>
			<th>Nome</th>
			<th>Plataforma</th>
		    <th>Ações</th>
		</tr>
		<tr>
			<c:forEach var="jogo" items="${jogos}">
				<tr>
					<td>${jogo.nome}</td>
					<td>${jogo.plataforma}</td>
					<td><a
						href="jogo?acao=editar&id=${jogo.id}">Editar</a>
						<a href="jogo?acao=deletar&id=${jogo.id}">Deletar</a>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>

</body>
</html>