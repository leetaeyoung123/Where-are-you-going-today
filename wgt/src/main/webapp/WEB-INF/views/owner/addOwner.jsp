<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="addUser" method="post">
		<div>점주 회원가입</div>
		<div>점주 아이디 <input type="text" name="userId"></div><br>
		<div>비밀번호 <input type="password" name="passwd"></div><br>
		<div>이름 <input type="text" name="name"></div><br>
		<div>사업자 번호 <input type="text" name="bn"></div>
		<div>전화번호 <input type="text" name="phone"></div><br>
		<div>주소 <input type="text" name="addr"></div><br>
		<input type="submit" value="회원가입" />
	</form>
</body> 
</html>