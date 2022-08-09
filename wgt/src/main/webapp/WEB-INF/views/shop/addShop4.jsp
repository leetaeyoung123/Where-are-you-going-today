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
      <header id="header"><h1>4/5</h1><h1>메뉴 등록</h1></header>
      <hr>
      <div id="content">
        <div class="inner">
          <form action="add_shop5" method="post" id="addForm">
            <p>사장님만의 특색있는<br>가게 메뉴를 등록해주세요!</p>
            <div class="file_upload_wrap">
              <table>
                <tr>
                  <td>
                    <img src="" alt="" style="width: 150px; height: 150px;">
                  </td>
                  <td>
                    <input type="text" name="" value="" class="menu_inputBox" placeholder="메뉴 이름을 입력해주세요">
                    <input type="text" name="" value="" class="menu_inputBox" placeholder="메뉴 가격을 입력해주세요">
                    <input type="text" name="" value="" class="menu_inputBox" placeholder="메뉴 소개를 입력해주세요">
                  </td>
                </tr>
              </table>
              <div class="btn_wrap">
                <label for="upload_file" class="upload_label">메뉴 사진 등록</label>
                <input id="upload_file" type="file" name="shop_img">
                <input type="button" value="저장" class="upload_label" style="background: #444444; color: white;">
              </div>
            </div>
            <button type="button" name="button">추가</button>
            <hr>
            <div class="btn_wrap">
              <input type="button" value="취소하기" onclick="" class="prev_btn">
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
