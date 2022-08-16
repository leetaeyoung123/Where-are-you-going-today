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
            <input type="text" name="bns_num" class="input_box" maxlength="13">
            <p>가게 이름</p>
            <input type="text" name="shop_name" class="input_box" maxlength="10">
            <p>가게 주소</p>
			<input type="button" onclick="sample6_execDaumPostcode()" class="next_btn" value="우편번호 찾기"><br>
			<input type="text" name="shop_address1" id="sample6_postcode" class="input_box" placeholder="우편번호">
			<input type="text" name="shop_address2" id="sample6_address" class="input_box" placeholder="주소"><br>
			<input type="text" name="shop_address3" id="sample6_detailAddress" class="input_box" placeholder="상세주소">
			<input type="text" name="shop_address4" id="sample6_extraAddress" class="input_box" placeholder="참고항목">
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
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
  </body>
</html>
