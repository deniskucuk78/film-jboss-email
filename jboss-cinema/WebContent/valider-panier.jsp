<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="GET" action="Validation">

<label for="email_1">Email</label> <input type="email" id="email_1" name="email1" accept-charset="UTF-8">

<input type="submit" value="Valider">

</form>

<h2>Resumé</h2>
<h3>${total }</h3>

<table>
	<c:forEach items="${filmsDto }" var="filmDto">
	<tr>
		<td>${filmDto.titre }</td>
		<td>${filmDto.realisateur }</td>
	</tr>
	</c:forEach>
</table>



</body>
</html>