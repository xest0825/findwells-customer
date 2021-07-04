<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/jstl-tld.jsp" %>

		<header>
			<div class="menu_wrap">
				<a><img src="/img/icons/menu.png" alt="메뉴 버튼">
				</a>
			</div>
 			<div style="float:right;position:absolute;top:15px;right:15px;z-index:10;">
				<a href="/mobile/index.go"><img src="/img/icons/ico_fixnav01_off.png" style="width:40px;" alt="홈으로"></a>
			</div>
			<p class="header_title">${menu_name}</p>
			<div class="nav">
				<div class="dim"></div>
				<button type="button" class="close_btn"><img src="/img/icons/close_btn.png" alt="닫기버튼"></button>
				<div class="nav_inner">
					<div class="member_img clearfix" style="height:80px;">
						<div class="img_box"><img src="/img/profile.png" alt="프로필사진"></div>
						<div class="name">
							<p class="font_16">${loginUser.USER_NM}</p>
							<p class="font_14">${loginUser.USER_EMP_CD}</p>
						</div>
					</div>
					<ul class="nav_list">
						<li class="clearfix">
							<a href="/mobile/notice.go" class="clearfix2">
								<p class="font_16">게시판<!-- <span></span> --></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/report.go?BD_NO=62" class="clearfix2">
								<p class="font_16">리포트<!-- <span></span> --></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/data.go" class="clearfix2">
								<p class="font_16">상품자료실<!-- <span></span> --></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/data2.go" class="clearfix2">
								<p class="font_16">교육자료실<!-- <span></span> --></p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						
						<li class="clearfix">
							<a href="/mobile/contract.go" class="clearfix2">
								<p class="font_16">계약관리</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<li class="clearfix">
							<a href="/mobile/member.go" class="clearfix2">
								<p class="font_16">고객조회</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						<!-- 
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
							<a href="/mobile/insco.go" class="clearfix2">
								<p class="font_16">원수사</p><img src="/img/icons/nav_arrow.png" alt="더보기버튼">
							</a>
						</li>
						-->
						<!-- 
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
						 -->
					</ul>
					<div class="bottom_wrap" style="margin-top:0px;margin-bottom:0px;">
						<ul class="address">
							<li>FIND WELLS</li>
							<li>서울 강남구 테헤란로 508 16층</li>
							<li>와얏트 스페이스 A04 FIND WELL</li>
							<li>Copyright (C) FIND WELLS Rights Reserved.</li>
						</ul>
						<ul class="btn_wrap clearfix">
							<li>
								<!-- <a href="/mobile/password_enter.go"><img src="/img/icons/logout_icon.png" alt="로그아웃 아이콘">로그아웃</a> -->
								<a href="/mobile/login.go"><img src="/img/icons/logout_icon.png" alt="로그아웃 아이콘">로그아웃</a>
							</li>
							<li>
								<a href="/mobile/password_set.go"><img src="/img/icons/password_icon.png" alt="비밀번호 아이콘">잠금비밀번호</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</header>
