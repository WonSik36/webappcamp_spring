<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Gender</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.getUserID()}</td>
				<td>${u.getUserName()}</td>
				<td>${u.getUserPassword()}</td>
				<td>${u.getUserGender()}</td>
				<td>${u.getUserEmail()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>