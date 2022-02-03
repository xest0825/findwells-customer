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
		<header>
			<div class="menu_wrap">
				<a href="javascript:;"><img src="/img/icons/menu.png" alt="메뉴 버튼"></a>
			</div>
			<p class="header_title">헬프 데스크</p>
			<div class="nav">
				<div class="dim"></div>
				<button type="button" class="close_btn"><img src="/img/icons/close_btn.png" alt="닫기버튼"></button>
				<div class="nav_inner">
					<div class="member_img clearfix">
						<div class="img_box"><img src="/img/profile.png" alt="프로필사진"></div>
						<div class="name">
							<p class="font_16">홍길동</p>
							<p class="font_14">VM150003</p>
						</div>
					</div>
					<ul class="nav_list">
						<li class="clearfix">
							<a href="/mobile/notice.go" class="clearfix2">
								<p class="font_16">게시판<span>99</span></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/data.go" class="clearfix2">
								<p class="font_16">자료실<span>100</span></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/contract.go" class="clearfix2">
								<p class="font_16">계약관리<span>9</span></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/member.go" class="clearfix2">
								<p class="font_16">고객조회</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/schedule.go" class="clearfix2">
								<p class="font_16">일정관리</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/personnel.go" class="clearfix2">
								<p class="font_16">인사관리</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/achievement.go" class="clearfix2">
								<p class="font_16">업적관리</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile//mobile/insco.go" class="clearfix2">
								<p class="font_16">원수사</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="javascript:;" class="clearfix2">
								<p class="font_16">수수료</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="javascript:;" class="clearfix2">
								<p class="font_16">기타</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/help.go" class="clearfix2">
								<p class="font_16">헬프데스크</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
					</ul>
					<div class="bottom_wrap">
						<ul class="address">
							<li>FIND WELLS</li>
							<li>서울 강남구 테헤란로 508 16층</li>
							<li>와얏트 스페이스 A04 FIND WELL</li>
							<li>Copyright (C) FIND WELLS Rights Reserved.</li>
						</ul>
						<ul class="btn_wrap clearfix">
							<li>
								<a href="/mobile/password_enter.go"><img src="/img/icons/logout_icon.png" alt="로그아웃 아이콘">로그아웃</a>
							</li>
							<li>
								<a href="/mobile/password_set.go"><img src="/img/icons/password_icon.png" alt="비밀번호 아이콘">잠금비밀번호</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<section class="help list_wrap">
			<div class="search_bar point_bg">
				<input type="text" class="search" placeholder="검색어를 입력하세요.">
				<button type="button" class="search_icon"></button>
			</div>
			<div class="tab_menu">
				<ul>
					<li class="on"><a href="/mobile/help.go">본사 업무담당</a></li>
					<li><a href="/mobile/help.go">제휴사 담당</a></li>
					<li><a href="/mobile/help.go">지점 안내</a></li>
				</ul>
			</div>
			<div>
				<ul class="list">
					<li class="clearfix">
						<div class="name_wrap">
							<p class="ellipsis">인사담당</p>
							<div class="left">
								<p class="has_right_border">영업인사팀</p>
								<p>박인사 대리</p>
							</div>
						</div>
						<a href="javascript:;" class="help_box">
							<img src="/img/icons/help.png" alt="">
						</a>
					</li>
					<li class="clearfix">
						<div class="name_wrap">
							<p class="ellipsis">수수료담당</p>
							<div class="left">
								<p class="has_right_border">영업지원팀</p>
								<p>백만원 과장</p>
							</div>
						</div>
						<a href="javascript:;" class="help_box">
							<img src="/img/icons/help.png" alt="">
						</a>
					</li>
					<li class="clearfix">
						<div class="name_wrap">
							<p class="ellipsis">IT운영담당</p>
							<div class="left">
								<p class="has_right_border">영업지원팀</p>
								<p>나정보 주임</p>
							</div>
						</div>
						<a href="javascript:;" class="help_box">
							<img src="/img/icons/help.png" alt="">
						</a>
					</li>
					<li class="clearfix">
						<div class="name_wrap">
							<p class="ellipsis">인사담당</p>
							<div class="left">
								<p class="has_right_border">영업인사팀</p>
								<p>박인사 대리</p>
							</div>
						</div>
						<a href="javascript:;" class="help_box">
							<img src="/img/icons/help.png" alt="">
						</a>
					</li>
					<li class="clearfix">
						<div class="name_wrap">
							<p class="ellipsis">인사담당</p>
							<div class="left">
								<p class="has_right_border">영업인사팀</p>
								<p>박인사 대리</p>
							</div>
						</div>
						<a href="javascript:;" class="help_box">
							<img src="/img/icons/help.png" alt="">
						</a>
					</li>
					<li class="clearfix">
						<div class="name_wrap">
							<p class="ellipsis">인사담당</p>
							<div class="left">
								<p class="has_right_border">영업인사팀</p>
								<p>박인사 대리</p>
							</div>
						</div>
						<a href="javascript:;" class="help_box">
							<img src="/img/icons/help.png" alt="">
						</a>
					</li>
				</ul>
				<div class="centerT">
					<button type="button" class="more">더보기</button>
				</div>
			</div>
		</section>
	</body>
</html>