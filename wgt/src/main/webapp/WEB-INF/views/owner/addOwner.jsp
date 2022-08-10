<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="addOwner" method="post">
		<div>점주가입</div>
		<div>아이디 <input type="text" name="ownerId"></div><br>
		<div>비밀번호 <input type="password" name="passwd"></div><br>
		<div>이름 <input type="text" name="name"></div><br>
		<div>사업자 번호 <input type="text" name="bnumber"></div>
		<div>전화번호 <input type="text" name="phone"></div><br>
		<div>가게주소 <input type="text" name="addr"></div><br>
		<input type="submit" value="점주가입" />
	</form>
</body> 
</html>