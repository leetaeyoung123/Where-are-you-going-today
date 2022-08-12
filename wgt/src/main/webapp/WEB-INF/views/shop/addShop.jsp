<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <link rel="stylesheet" href="resources/initialize.css">
    <link rel="stylesheet" href="resources/shopStyle.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
    <title>가게 등록</title>
  </head>
  <body>
    <div id="wrap">
      <header id="header"><h1>1/4</h1><h1>가게 &nbsp;등록</h1></header>
      <hr>
      <div id="content">
        <div class="inner">
          <form action="add_shop2" method="post" id="addForm">
            <p>사업자 등록 번호</p>
            <input type="text" name="bns_num" class="input_box">
            <p>가게 이름</p>
            <input type="text" name="shop_name" class="input_box">
            <p>가게 주소</p>
            <input type="text" name="shop_address" class="input_box">
            <hr>
            <div class="btn_wrap">
              <input type="button" value="취소하기" onclick="location.href='map/map'" class="prev_btn">
              <input type="submit" value="다음으로" class="next_btn">
            </div>
          </form>
        </div>
      </div>
      <hr>
      <footer id="footer">Copyright (c) 2022 Copyright Holder All Rights Reserved.</footer>
    </div>
  </body>
</html>
