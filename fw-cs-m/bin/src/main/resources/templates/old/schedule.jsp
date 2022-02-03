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
		<script>
		$(document).ready(function(){
			console.log('schedule');
		});
		
		document.addEventListener('DOMContentLoaded', function() {
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				plugins: [ 'dayGrid'],
				titleFormat : function(date) {
				  return date.date.year +"."+(date.date.month +1); 
				},
				columnHeaderText: function(date) {
					let weekList = ["일", "월", "화", "수", "목", "금", "토"];
					return weekList[date.getDay()];
				},
				buttonText: {
					today : "오늘",
				},
				eventLimit : true,
				events: [
					{
						className: 'pop_show',
						title: '일정',
						start: '2020-06-04',
						end: '2020-06-04',
						color: '#F2A0AB',
						resourceEditable: false,
					},
					{
						className: 'pop_show',
						title: '일정',
						start: '2020-06-10',
						end: '2020-06-13',
						color: '#B4AAEC',
						resourceEditable: false,
					},
					{
						url: '/mobile/notice_detail.go',
						title: '[취소] FW 2~3월 홍콩정기투어 취소',
						start: '2020-06-22',
						end: '2020-06-27',
						color: '#95D1F6',
						resourceEditable: false,
					},
					{
						className: 'pop_show',
						title: '일정',
						start: '2020-06-29',
						end: '2020-06-30',
						color: '#FE9800',
						resourceEditable: false,
					},
				],
			});
			calendar.render();
		});
		
		</script>
	</head>
	<body>
		<%@ include file="./lnb.jsp" %>
		<section class="detail">
			<div id='calendar'></div>
		</section>
		<!-- 일정팝업 -->
		<div class="pop_wrap schedule_pop">
			<div class="pop_dim">
				<div class="pop_cont">
					<button type="button" class="pop_close"><img src="/img/icons/close_btn.png" alt="닫기버튼"></button>
					<div class="title_wrap">일정 타이틀</div>
					<div class="text_wrap">
						<p class="font_15">메시지 내용을 표시해주세요. 메시지 내용을 표시해주세요. 메시지 내용을 표시해주세요. 메시지 내용을 표시해주세요. 메시지 내용을 표시해주세요.</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>