<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0" />
<title>root page</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/mapcss/map.css'/>" />
<style>
</style>
</head>
<body>
	<form action="root" method="post">
		<c:forEach var="shop" items="${shop}">
				<button name="businessNumber" value="${shop.businessNumber}">가게이름: ${shop.shopName}<br>사업자 번호: ${shop.businessNumber}</button>
		</c:forEach>
	</form>
</body>
</html>