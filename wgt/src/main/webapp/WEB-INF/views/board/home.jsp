<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
<title>게시판 - 목록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/boardstyle.css'/>"/>
<body>

<div class="navbar navbar-dark bg-dark shadow-sm mb-3">
  <div class="container d-flex justify-content-between">
    <a href="/" class="navbar-brand d-flex align-items-center">
      <strong>게시판</strong>
    </a>
  </div>
</div>

<header th:insert="common/header.html"></header>
    <div class="container">
      <table class="table">
        <thead class="thead-light">
          <tr class="text-center">
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr class="text-center" th:each="post : ${postList}">
            <th scope="row">
              <span th:text="${post.id}"></span>
            </th>
            <td>
              <a th:href="@{'/post/' + ${post.id}}">
                <span th:text="${post.title}"></span>
              </a>
            </td>
            <td>
              <span th:text="${post.author}"></span>
            </td>
            <td>
              <span th:text="${#temporals.format(post.createdDate, 'yyyy-MM-dd HH:mm')}"></span>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <div class="col-auto mr-auto"></div>
        <div class="col-auto">
          <a class="btn btn-primary" th:href="@{/post}" role="button">글쓰기</a>
        </div>
      </div>
    </div>
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</body>
</html>