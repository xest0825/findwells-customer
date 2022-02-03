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
		<section class="password_enter">
			<div class="password_enter_wrap">
				<div class="notice">
					<p>잠금비밀번호 입력</p>
					<p>잠금비밀번호 4자리를 입력하세요</p>
				</div>
				<form action="" class="numpad_wrap">
					<div class="numpad">
						<div class="password">
							<div class="bleep" id="bleep_one_display">
								<input type="checkbox" value="None" id="bleep_one"/>
								<label for="bleep_one"></label>
							</div>
							<div class="bleep" id="bleep_two_display">
								<input type="checkbox" value="None" id="bleep_two"/>
								<label for="bleep_two"></label>
							</div>
							<div class="bleep" id="bleep_three_display">
								<input type="checkbox" value="None" id="bleep_three"/>
								<label for="bleep_three"></label>
							</div>
							<div class="bleep" id="bleep_four_display">
								<input type="checkbox" value="None" id="bleep_four"/>
								<label for="bleep_four"></label>
							</div>
						</div>
						<div class="num clearfix">
							<div class="button button_num " id="button_1">1</div>
							<div class="button button_num " id="button_2">2</div>
							<div class="button button_num " id="button_3">3</div>
							<div class="button button_num " id="button_4">4</div>
							<div class="button button_num " id="button_5">5</div>
							<div class="button button_num " id="button_6">6</div>
							<div class="button button_num " id="button_7">7</div>
							<div class="button button_num " id="button_8">8</div>
							<div class="button button_num " id="button_9">9</div>
							<div class="button" id="op" readonly disabled>&nbsp;</div>
							<div class="button button_num " id="button_0">0</div>
							<div class="button " id="button_c"></div>
						</div>
					</div>
				</form>
				<div class="centerT">
					<button class=" font_16 white_color find_btn" onclick="location.href='./password_find.html'">잠금번호 찾기</button>
				</div>
			</div>	
		</section>
		<!-- 팝업시작 -->
		<div class="pop_wrap enter_pop1">
			<div class="pop_dim">
				<div class="pop_cont">
					<p>비밀번호가 맞지 않습니다.</p>
					<button type="button" class="pop_close pop_close_btn">확인</button>
				</div>
			</div>
		</div>
		<!--재직상태가 퇴사일 시 띄우는 팝업  -->
		<!-- <div class="pop_wrap enter_pop2"> -->
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
		$('input').click(function(){
		  return false;
		});

		var temp = '',
			 pressed = 0,
			 press_max = 4;

		$('.button_num').click(function(){
		  
		  pressed++;
		  var ii = $(this).attr("id").split('_')[1];
		  if(pressed <= press_max){
			 $($('input')[pressed-1]).prop('checked', true);
			 temp += $(this).attr("id").split('_')[1];
		  }
		  console.log(ii)
		  
		});

		$('#button_c').click(function(){
		  
		  if(pressed > 0){
			 $($('input')[pressed-1]).prop('checked', false);
			 pressed--;
			 temp = temp.slice(0,pressed);
		  }
		  
		});
	</script>
</html>