<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/initialize.css">
<link rel="stylesheet" href="../resources/shopStyle.css">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,  maximum-scale=1.0, minimum-scale=1.0">
<title>가게 메뉴 정보 수정</title>
</head>
  <body style="background: #DA0037;">
    <div id="wrap">
      <div style="width: 90%; height: 100%; background: white; margin-top: 30px; padding: 20px; box-shadow: 0 15px black; border-radius: 30px;">
      <form method="post" action="updateShop" class="flexForm" enctype="multipart/form-data">
      <span class="text" style="color: #DA0037;">가게 사업자 번호</span>
        <input name="businessNumber" type="text" class="text readonlyinput" readonly value="${shop.businessNumber }"/>
      <span class="text" style="color: #DA0037;">가게 이름</span>
	    <input name="shopName" type="text" class="text readonlyinput" readonly value="${shop.shopName }"/>
      <span class="text" style="color: #DA0037;">가게 번호</span>
      	<input name="shopTel" class="text input_box" value="${shop.shopTel }"/>
      <span class="text" style="color: #DA0037;">가게 주소</span>
      	<input name="shopAddress" class="text input_box" value="${shop.shopAddress }"/>
      <span class="text" style="color: #DA0037;">영업 시간</span>
      	<input name="shopHours" class="text input_box" value="${shop.shopHours }"/>
      <span class="text" style="color: #DA0037;">가게 테이블 보유 수</span>
      <input name="shopTables" class="text input_box" value="${shop.shopTables }"/>
      <span class="text" style="color: #DA0037;">가게 테이블당 최대 수용 인원 수</span>
      <input name="shopMaxPeoples" class="text input_box" value="${shop.shopMaxPeoples }"/>
      <span class="text" style="color: #DA0037;">수정 전 가게 사진</span>
      	<img src="../resources/shop/shop_Img/${shop.shopImg }.jpg" style="border-radius: 30px;" />
      	<input name="shopImg" value="${shop.shopImg }" style="display:none;">
            <p style="text-align:center; font-size: 22px; margin-top: 15px;">수정 할 사진을 업로드 해주세요!<br>전의 사진을 그대로 사용하고싶다면<br>사진 업로드를 하지 않으셔도 됩니다.</p>
            <div class="file_upload_wrap">
              <label for="upload_file" class="upload_label">사진 등록</label>
              <input id="upload_file" type="file" name="shop_img" onchange="readURL(this)" accept="image/jpeg, image/png, image/jpg">
              <br>
              <span style="margin-bottom: 15px; font-size: 28px;">미리보기</span>
              <img style="width: 380px; height: 400px;" id="preview" />
            </div>
            <hr>
      	<input type="submit" class="next_btn" style="width: 80%; margin: 30px 0 25px; border: 5px solid white; border-radius: 30px; box-shadow: 0 10px black;" value="수정 완료">
      	</form>
      </div>
      <button type="button" name="button" class="prev_btn" style=" width: 80%; margin: 30px 0 25px; border: 5px solid white; border-radius: 30px; box-shadow: 0 10px black;" onclick="location.href='viewMyShop'">뒤로 돌아가기</button>
    </div>
      <script type="text/javascript">
	function readURL(input) {
		const type = input.files[0].name.split('.');
		if(type[1] != "jpg" && type[1] != "png" &&  type[1] != "jpeg"){
			alert("이미지 파일은 (jpg, png, jpeg) 형식만 등록 가능합니다.");
			document.getElementById('preview').src = "";
			document.getElementById('img').value = null;
			return false;
		}
		  if (input.files && input.files[0]) {
		    var reader = new FileReader();
		    reader.onload = function(e) {
		      document.getElementById('preview').src = e.target.result;
		    };
		    reader.readAsDataURL(input.files[0]);
		  } else {
		    document.getElementById('preview').src = "";
		  }
		}
  </script>
  </body>
</html>