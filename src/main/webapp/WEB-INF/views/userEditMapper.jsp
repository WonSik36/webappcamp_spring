<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8 ">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>JSP 게시판</title>
	
	<c:if test="${empty user}">
		<script>
			alert("올바르지 않은 접근입니다.");
			location.href="/webcamp/usermappers"
		</script>
	</c:if>

</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="/webcamp/usermappers">JSP 게시판 웹사이트</a>
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post">
					<h3 style="text-align: center;">회원 수정 화면</h3>
					<input type="hidden" name="_method" value="put">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="userID" maclength="20" value="${user.userID}" required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="userPassword" maclength="20" value="${user.userPassword}" required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름"
							name="userName" maclength="20" value="${user.userName}" required>
					</div>
					
					<div class="form-group" style="text-align: center;">
					
						<div class="btn-group" data-toggle="buttons">
							<c:if test="${user.userGender == 'm' }">
							<label class="btn btn-primary active"> 
								<input type="radio" name="userGender" autocomplete="off" value="m" checked>남자
							</label> 
							<label class="btn btn-primary"> 
								<input type="radio" name="userGender" autocomplete="off" value="f">여자
							</label>
							</c:if>
							<c:if test="${user.userGender == 'f' }">
							<label class="btn btn-primary"> 
								<input type="radio" name="userGender" autocomplete="off" value="m">남자
							</label> 
							<label class="btn btn-primary active"> 
								<input type="radio" name="userGender" autocomplete="off" value="f" checked>여자
							</label>
							</c:if>
						</div>
					</div>
					
					<div class="form-group">
						<input type="email" class="form-control" placeholder="이메일"
							name="userEmail" maclength="20" value="${user.userEmail}" required>
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="수정">
				</form>
			</div>
		</div>
		
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

		<!-- Popper JS -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>