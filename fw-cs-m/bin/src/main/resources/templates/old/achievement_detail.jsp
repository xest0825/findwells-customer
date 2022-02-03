<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/jstl-tld.jsp" %>
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
		
		<script type="text/javascript">
		var emp_cd = '';
		var achievementListPage = '';
		var achieveDetailList = [];
		var achieveDetail = {};
		var pageSize = 100;
		var page = 1;
		var pageSizeTmp = 100;
		var pageTmp = 1;
		var achieveDetailCount = 0;
		var total = 0;
		$(document).ready(function(){
			console.log('achievement_detail');
			emp_cd = '${AchievementVO.EMP_CD}';
			srch_start_date = '${AchievementVO.SRCH_TERM_START_VALUE}';
			srch_end_date = '${AchievementVO.SRCH_TERM_END_VALUE}';
			achievementListPage = '${ContractVO.page}';
			console.log(emp_cd);
			console.log(srch_start_date);
			console.log(srch_end_date);
			console.log(achievementListPage);
			
			// 검색날짜 조회 
			$('#srch_start_date').val(srch_start_date);
			$('#srch_end_date').val(srch_end_date);
			
			getAchievementDetailList();
			
			$('#bt_search').on('click', function(){
				getAchievementDetailList();
			});
			
		});
		
		function getAchievementDetailList(){
			console.log('getAchievementDetailList');
			var params = { 
					page: page, 
					pageSize: pageSizeTmp,
					SRCH_TERM_START_VALUE : $('#srch_start_date').val(),
					SRCH_TERM_END_VALUE : $('#srch_end_date').val(),
					SRCH_CON_EMP_WORD : emp_cd,
			}
			$.ajax({
				url : "/contract/selectTotalContViewList.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getAchievementList success');
					console.log(data.results);
					achievementList = data.results;
					achievementCount = data.results.length;
					total = achievementCount;
										
					var html = '';
					for (var i = 0; i<achievementList.length; i++){
						achievement = achievementList[i];
						// if (i == 0) { total = achievement.TOTAL;}
						html += ''
							 + '<li>'
							 + '	<div class="clearfix2 top">'
							 + '		<p class="">' + achievement.EMP_NM + ''
							 + '			<span class="font_14 white_color">(' + achievement.EMP_CD + ')<span>'
							 + '		</p>'
							 + '		<div class="right">'
							 + '			<p class="has_right_border">' + achievement.EMPSTA + '</p>'
							 + '			<p>' + achievement.CONT_CNT + '건</p>'
							 + '		</div>'
							 + '	</div>'
							 + '	<div class="clearfix2 bottom">'
							 + '		<p>CREDIT : ' + formatComma(achievement.CONT_CREDIT) + '</p>'
							 + '		<div class="right">'
							 + '			<p>USD : ' + formatComma(achievement.CONT_USD)+'</p>'
							 + '			<p>HKD : ' + formatComma(achievement.CONT_HKD)+ '</p>'
							 + '		</div>'
							 + '	</div>'
							 + '</li>'
							 ;
					}
					if (achievementList.length > 0) {
						$('#div_more').hide();
						$('#achieveDetailList').empty();
						$('#achieveDetailList').html(html);
					}

				},
				error : function(){
					alert('error');
				}
			});	
			console.log(params);
			$.ajax({
				url : "/contract/selectEmpContDetailList.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getAchievementDetailList success');
					console.log(data.results);
					achieveDetailList = data.results;
					achieveDetailCount = data.results.length;
					total = achieveDetailCount;
					
					//$('#achieveDetailList').empty();
					$('#div_more').hide();
					var html = '';
					for (var i = 0; i<achieveDetailList.length; i++){
						achieveDetail = achieveDetailList[i];
						// if (i == 0) { total = achievement.TOTAL;}
						console.log(achieveDetail);
						html += ''
							 + ''
							 + '<li>'
							 + '	<div class="top">'
							 + '		<p class="ellipsis">' + achieveDetail.IFA_CD + ' / '+ achieveDetail.INSCO_CD + '&nbsp;'+ achieveDetail.PROD_NM +'</p>'
							 + '		<div class="clearfix">'
							 + '			<p>' + changeName(achieveDetail.GEAJA_NM) + '</p>'
							 + '			<div class="right">'
							 + '				<p class="has_right_border">' + achieveDetail.NAPMETHOD + '</p>'
							 + '				<p>' + achieveDetail.NAPGI + '</p>'
							 + '			</div>'
							 + '		</div>'
							 + '	</div>'
							 + '	<div class="clearfix2 bottom">'
							 + '		<p>CREDIT : ' + formatComma(achieveDetail.CREDIT) + '</p>'
							 + '		<div class="right">'
							 + '			<p>USD : ' + formatComma(achieveDetail.USD_NAP_MONTH) + '</p>'
							 + '			<p>HKD : ' + formatComma(achieveDetail.HKD_NAP_MONTH) + '</p>'
							 + '		</div>'
							 + '	</div>'
							 + '</li>'
							 ;
					}
					$('#achieveDetailList').append(html);
					
					if (total > pageSizeTmp) {
						console.log('total > pageSizeTmp')
						$('#div_more').show();
					}

				},
				error : function(){
					alert('error');
				}
			});		
		}
		
		function changeName(str){
			var asterik = '*';
			if (str.length > 1) {
				for (var i = 0; i<(str.length - 1); i++){
					asterik += '*';
				}
			}
			
			return str.substring(0,1) + asterik;
		}
		</script>
	</head>
		<body>	
		<header>
			<div class="back_wrap">
				<a href="javascript:;" onclick="history.back(-1);"><img src="/img/icons/back_btn.png" alt="뒤로가기 버튼"></a>
			</div>
			<p class="header_title">업적상세</p>
		</header>
		<section class="achievement detail">
			<div class="date_bar clearfix2"> 
				<div class="clearfix2">
					<input id="srch_start_date" type="date">
					<input id="srch_end_date" type="date">
				</div>
				<button id="bt_search" type="button">검색</button>
			</div>
			<ul id="achieveDetailList">
				<li>
					<div class="clearfix2 top">
						<p class="">OOO<span class="font_14 white_color">(OO0000)</span></p>
						 <div class="right">
							<p class="has_right_border"></p>
							<p>0건</p>
						</div>
					</div>
					<div class="clearfix2 bottom">
						<p>CREDIT :0</p>
						<div class="right">
							<p>USD : 0</p>
							<p>HKD : 0</p>
						</div>
					</div>
				</li>
				 
			</ul>
		</section>
	</body>
</html>