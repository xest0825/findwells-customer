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
		<section class="form_page login">
			<form name="loginForm" id="loginForm" action="/j_spring_security_check" method="POST">
				<ul>
					<li class="logo">
						<a href="/mobile/login.go">
							<img src="/img/logo.png">
						</a>
					</li>
					<li>
						<input type="hidden" name="MB_ID" id="MB_ID" value="YNG">
						<input type="text" id="j_username" name="j_username" placeholder="사원번호" />
					</li>
					<li>
						<input type="password" id="j_password" name="j_password" placeholder="비밀번호" />
					</li>
				</ul>
				<div class="btn_wrap">
					<!-- <button type="button" class="submit_btn" onclick="javascript:window.location.href='/mobile/password_set.go';">인증확인</button> -->
					<button type="button" class="submit_btn" onclick="javascript:doLogin();">로그인</button>
				</div>
			</form>
		</section>
		<script>
			//인풋 입력 시 버튼 활성화
			$(document).ready(function(){
				$('input[name=j_username], input[name=j_password]').keyup(function(){
					var result = txtFieldCheck() == true ? true : false;
					if(result == true){
						$('.submit_btn').addClass('on');
					} else {
						$('.submit_btn').removeClass('on');						
					}
				});
				function txtFieldCheck(){
					flag = true;
					var txtEle = $('input[name=j_username], input[name=j_password]');
					for(var i = 0; i < txtEle.length; i ++){
						if("" == $(txtEle[i]).val() || null == $(txtEle[i]).val()){
							flag = false;
						}
					}
					return flag;
				};
				<c:if test="${not empty param.fail}">
				alert('가입되지 않은 아이디거나 잘못된 비밀번호입니다.');
				</c:if>
			});
			function doLogin(){
				$("#loginForm").submit();
			}
		</script>
	</body>
</html>