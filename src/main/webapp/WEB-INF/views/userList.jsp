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
	<c:if test="${not empty userID}">
		<h3>
			안녕하세요 ${userID} 님 <a href="./logout">로그아웃</a>
		</h3>
	</c:if>
	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.getUserID()}</td>
				<td>${u.getUserName()}</td>
				<td>${u.getUserPassword()}</td>
				<td>${u.getUserGender()}</td>
				<td>${u.getUserEmail()}</td>
				<td><a href="./users/${u.userID}">UPDATE</a></td>
				<td><a href="#" onclick="deleteUser('${u.userID}')">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="./add">
			<button>사용자 추가</button>
		</a>
	</div>
	<div>
		<form method="post" id="delete">
			<input type="hidden" name="_method" value="delete"> 
		</form>
	</div>
	
	<script>
		function deleteUser(id){
			var frm = document.getElementById("delete");
			frm.setAttribute("action","./users/"+id);
			frm.submit();
		}
	</script>
</body>
</html>