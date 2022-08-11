<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	${shop.businessNumber }<br>
	${shop.shopName }<br>
	${shop.shopTel }<br>
	${shop.shopAddress }<br>
	${shop.shopHours }<br>
	${shop.shopTables }<br>
	${shop.shopMaxPeoples }<br>
	${shop.shopImg }<br>
</div>
	<c:forEach var="menu" items="${menus }">
		${menu.menuName }<br>
		${menu.menuIntro }<br>
		${menu.menuPrice }<br>
		${menu.menuImg }<br>
	</c:forEach>
</body>
</html>