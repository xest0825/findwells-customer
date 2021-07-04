<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, shrink-to-fit=no"">
		<meta name="HandheldFriendly" content="true">
		<title>FIND WELLS</title>
		<!-- googlefont -->
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.4.0/main.min.css" />
		<link rel="stylesheet" href="https://unpkg.com/@fullcalendar/daygrid@4.4.0/main.min.css" />
		<link rel="stylesheet" href="/css/mobile/common.css"/>
		<link rel="stylesheet" href="/css/mobile/style.css"/>
		<script type="text/javascript" src="/js/mobile/jquery.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.4.0/main.min.js"></script>
		<script src="https://unpkg.com/@fullcalendar/interaction@4.4.0/main.min.js"></script>
		<script src="https://unpkg.com/@fullcalendar/daygrid@4.4.0/main.min.js"></script>
		<script type="text/javascript" src="/js/mobile/style.js"></script>
	</head>
	<body>
		<section class="form_page password_find">
			<form>
				<ul>
					<li class="logo">
						<a href="/mobile/index.go">
							<img src="/img/logo.png">
						</a>
					</li>
					<li>
						<h2 class="title">비밀번호 찾기</h2>
					</li>
					<li>
						<input type="text" placeholder="사원명">
					</li>
					<li>
						<input type="text" placeholder="사원번호" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
					</li>
					<li>
						<input type="text" placeholder="핸드폰번호" onkeyup="inputPhoneNumber(this);" maxlength="13"/>
					</li>
				</ul>
				<div class="btn_wrap">
					<button type="button" class="submit_btn pop_show">확인</button>
				</div>
			</form>
		</section>
		<!-- 팝업시작 -->
		<div class="pop_wrap find_pop1">
			<div class="pop_dim">
				<div class="pop_cont">
					<p>임시 비밀번호가 발송되었습니다.</p>
					<button type="button" class="pop_close pop_close_btn">확인</button>
				</div>
			</div>
		</div>
		<!--정보가 일치하지 않을 시 띄우는 팝업  -->
		<!-- <div class="pop_wrap find_pop2"> -->
			<!-- <div class="pop_dim"> -->
				<!-- <div class="pop_cont"> -->
					<!-- <p>정보가 일치하지 않습니다.</p> -->
					<!-- <button type="button" class="pop_close pop_close_btn">확인</button> -->
				<!-- </div> -->
			<!-- </div> -->
		<!-- </div> -->

		<!--재직상태가 퇴사일 시 띄우는 팝업  -->
		<!-- <div class="pop_wrap find_pop3"> -->
			<!-- <div class="pop_dim"> -->
				<!-- <div class="pop_cont"> -->
					<!-- <p class="text2">재직상태가 퇴사로 로그인 할 수 없습니다.</p> -->
					<!-- <button type="button" class="pop_close pop_close_btn">확인</button> -->
				<!-- </div> -->
			<!-- </div> -->
		<!-- </div> -->
		<!-- 팝업끝 -->
	</body>
	<script>
		//휴대폰번호 자동 하이픈
		function inputPhoneNumber(obj) { 
			var number = obj.value.replace(/[^0-9]/g, "");
			obj.value = number.replace(/(^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");	
		};

		//인풋 입력시 버튼 활성화
		$(document).ready(function(){
			$('input').keyup(function(){
				var result = txtFieldCheck() == true ? true : false;
				if(result == false){
					$('.submit_btn').addClass('on');
				}
			});
			function txtFieldCheck(){
				var txtEle = $("input");
				for(var i = 0; i < txtEle.length; i ++){
					if("" == $(txtEle[i]).val() || null == $(txtEle[i]).val()){
						return true;
					}
				}
			};
		});
	</script>
</html>