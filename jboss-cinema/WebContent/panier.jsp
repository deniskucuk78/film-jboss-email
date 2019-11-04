<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>films</title>
</head>
<body>

<h2>${total }</h2>

<table>
	<c:forEach items="${filmsDto }" var="filmDto">
		<tr><td>${filmDto.titre }</td>
			<td>${filmDto.prixHT }</td>
			<td><a href="SupprimerArticleServlet?id=${filmDto.id }">Supprimer </a></td>
			
		</tr>
	</c:forEach>
</table>
<a href="ValiderPanier">Valider</a>
<br>
<a href="FilmServlet">Retour</a>
</body>
</html>