<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Waiting</title>
</head>
<body>
	<h3>웨이팅</h3>
	<form action="waiting" method="post">
		<input placeholder="아이디" type="text" name="userId"> <input
			placeholder="가게명" type="text" name="barName"> <input
			placeholder="인원수" type="number" min="1" required name="num_people">
		<button>Waiting</button>
	</form>
</body>
</html>