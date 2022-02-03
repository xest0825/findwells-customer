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
		<script type="text/javascript" src="/js/mobile/common.js"></script>
		<script>
		$(document).ready(function(){
			
		});
			
		function goInscoHomepage(code){
			var url = '';
			if (code == 'MetisHK') {
				url = 'https://www.metisgl.com';
			} else if (code == 'MM'){
				url = ''
			} else if (code == 'ITA'){
				url = 'http://www.investors-trust.com/kor'
			} else if (code == 'AXA'){
				url = 'http://www.axa.com.hk'
			} else if (code == 'Metlife'){
				url = 'https://www.metlife.com.hk'
			} else if (code == 'Sunlife'){
				url = 'http://www.sunlife.com.hk'
			} else if (code == 'Fubon'){
				url = 'http://www.fubonlife.com.hk/'
			} else if (code == 'RL360'){
				url = 'https://www.rl360.com'
			} else if (code == 'AIA'){
				url = 'http://www.aia.com.hk'
			} else if (code == 'FWD'){
				url = 'http://www.fwd.com.hk'
			} else if (code == 'YF'){
				url = 'https://www.yflife.com'
			} 
			
			window.open(url, code, '_blank'); 
		}
		</script>
	</head>
	<body>	
		<%@ include file="./lnb.jsp" %>
		<section class="investigation">
			<ul class="container">
				<li>
					<a href="javascript:goInscoHomepage('MetisHK');">
						<div class="img_box">
							<img src="/img/investigation.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">Metis</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('ITA');">
						<div class="img_box">
							<img src="/img/investigation2.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">ITA</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('AXA');">
						<div class="img_box">
							<img src="/img/investigation3.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">AXA</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('Metlife');">
						<div class="img_box">
							<img src="/img/investigation4.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">Metilife</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('Sunlife');">
						<div class="img_box">
							<img src="/img/investigation5.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">Sunlife</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('Fubon');">
						<div class="img_box">
							<img src="/img/investigation6.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">Fubon</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('RL360');">
						<div class="img_box">
							<img src="/img/investigation7.png" alt="">
						</div>
						<p class="centerT grey2_color font_14">RL360</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('AIA');">
						<div class="img_box">
							<img src="/img/investigation8.png" alt="" style="width: 50%;">
						</div>
						<p class="centerT grey2_color font_14">AIA</p>
					</a>
				</li>
				<li>
					<a href="javascript:goInscoHomepage('FWD');">
						<div class="img_box">
							<img src="/img/investigation9.png" alt="" style="width: 66%;">
						</div>
						<p class="centerT grey2_color font_14">FWD</p>
					</a>
				</li>
			</ul>
		</section>
	</body>
</html>