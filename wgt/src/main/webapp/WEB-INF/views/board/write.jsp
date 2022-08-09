<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<title>게시판 - 글쓰기</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/board/write.css'/>"/>
</head>
<body>

<h3>게시판 글작성 페이지</h3>
	<form action="write" method="post">
	제목: <input type="text" name="title"><br>
	내용: <input type="text" name="content"><br>
	사진 첨부 : <input type="image" name="imgname"><br>
		<input type="submit" value="등록">
	</form>

</body>
</html>