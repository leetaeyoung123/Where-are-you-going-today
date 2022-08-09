<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ownerLogin" method="post">
		<div>점주 로그인</div><br>
		<div>아이디</div><input type="text" name="ownerId"><br>
		<div>비밀번호</div><input type="password" name="passwd"><br>
		<div>사업자 번호</div><input type="text" name="bnumber"><br>
		<input type="submit" value="로그인"><br>
	</form>
	<button type="button" onclick="location.href='addOwner';">점주가입</button>
</body>
</html>