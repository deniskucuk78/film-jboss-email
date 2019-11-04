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

<table>
	<c:forEach items="${films }" var="film">
		<tr><td>${film.titre }</td>
			  <td><a href="PanierServlet?id=${film.id }">Ajouter au panier </a></td>
		</tr>
	</c:forEach>
</table>
<a href="index.jsp">Retour</a>
</body>
</html>