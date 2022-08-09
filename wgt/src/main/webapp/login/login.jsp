<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="login" method="post">
		<div>아이디</div><input type="text" name="userId">
		<div>비밀번호</div><input type="password" name="passwd">
		<input type="submit" value="로그인">
	</form>
</body>
</html>