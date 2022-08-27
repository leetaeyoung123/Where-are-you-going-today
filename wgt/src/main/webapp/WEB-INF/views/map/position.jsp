<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>position</title>
</head>
<body>
	<form action="position" method="get">
	가게 이름: ${shopName}
	사업자 번호: ${shopBns}
	</form>
	<form action="position" method="post">
		<label>경도</label><input name="longitude">
		<label>위도</label><input name="latitude">
		<input type="submit">
	</form>
</body>
</html>