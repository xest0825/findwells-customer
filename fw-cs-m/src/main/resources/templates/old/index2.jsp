<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>FIND WELLS</title>
<style>
html,
body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}
body>div {
	min-height: 100%;
	position: relative;
	_padding-bottom: 100px;
	background: #99cc99;  /* fallback for old browsers */
	background: -webkit-linear-gradient(to top, #038FED, #9dc1d2);  /* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to top, #038FED, #9dc1d2); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	padding:0 20px 0 20px;
}
h1, h2, h3, h4 {
	margin: 0;
	padding: 0;
}
h2 {
	color: #fff;
	margin-bottom: 10px;
}
a {
	text-decoration: none;
	font-weight: bold;
	color: #fff;
}
ul {
	list-style: none;
	padding: 0;
	margin: 0;
}
ol {
	margin: 10px 0 0 10px;
	color: #fff;
	font-size: 15px;
	font-weight: 900;
}
ul>li {
	padding: 5px;
	border-bottom: 1px dotted #999;
	color: #333
}
h1 {
	width: 100%;
	height: 150px;
	line-height: 150px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}
ol>li {
	line-height: 30px;
	padding: 0;
	margin: 0;
}
.hidden {
	display: none;
}
span {
	display: inline-block;
	float: right;
	width: 200px;
	color: #005bfc;
}
.blue a {color:blue;}
</style>
</head>

<body>
	<div>
		<h2>FIND WELLS</h2>
		<ul class="link">
			<li><a href="./login.html">로그인</a>
			 <ol>
			  <li><a href="./login.html">로그인</a></li>
			  <li><a href="/mobile/password_set.go">잠금비밀번호 설정</a></li>
			  <li><a href="/mobile/password_enter.go">잠금비밀번호 입력</a></li>
			  <li><a href="./password_find.html">잠금비밀번호 찾기</a></li>
			 </ol>
			</li>
			<li><a href="./index.html">메인</a>
			 <ol>
			  <li><a href="./index.html">메인</a> 
			 </ol>
			</li>
			<li><a href="/mobile/notice.go">게시판</a>
			  <ol>
				<li><a href="/mobile/notice.go">게시판</a></li>
			    <li><a href="/mobile/notice_detail.go">게시판 - 상세페이지</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/data.go">자료실</a>
			  <ol>
				<li><a href="/mobile/data.go">자료실</a></li>
			    <li><a href="/mobile/data_detail.go">자료실 - 상세페이지</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/contract.go">계약관리</a>
			  <ol>
				<li><a href="/mobile/contract.go">계약관리</a></li>
			    <li><a href="/mobile/contract_detail.go">계약관리 - 상세페이지</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/member.go">고객조회</a>
			  <ol>
				<li><a href="/mobile/member.go">고객조회</a></li>
			    <li><a href="/mobile/member_detail.go">고객조회 - 상세페이지</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/schedule.go">일정관리</a>
			  <ol>
				<li><a href="/mobile/schedule.go">일정관리</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/personnel.go">인사관리</a>
			  <ol>
				<li><a href="/mobile/personnel.go">인사관리</a></li>
			    <li><a href="./personnel_detail.html">인사관리 - 상세페이지</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/achievement.go">업적관리</a>
			  <ol>
				<li><a href="/mobile/achievement.go">업적관리</a></li>
			    <li><a href="./achievement_detail.html">업적관리 - 상세페이지</a></li>
			  </ol>
			</li>
			<li><a href="/mobile//mobile/insco.go">원수사</a>
			  <ol>
				<li><a href="/mobile//mobile/insco.go">원수사</a></li>
			  </ol>
			</li>
			<li><a href="/mobile/help.go">헬프데스크</a>
			  <ol>
				<li><a href="/mobile/help.go">헬프데스크</a></li>
			  </ol>
			</li>
		</ul>
		
	</div>
</body>
</html>