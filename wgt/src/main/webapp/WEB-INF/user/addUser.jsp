<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="addUser" method="post">
		<div>회원 아이디 : </div><input type="text" name="userId">
		<div>비밀번호 : </div><input type="text" name="passwd">
		<div>이름 : </div><input type="text" name="name">
		<div>주민번호 : </div><input type="text" name="ssn">
		<div>전화번호 : </div><input type="text" name="phone">
		<div>주소 : </div><input type="text" name="addr">
	</form>
</body>
</html>