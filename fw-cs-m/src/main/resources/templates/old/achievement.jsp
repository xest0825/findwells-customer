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
		var achievementList = [];
		var achievement = {};
		var pageSize = 100;
		var page = 1;
		var pageSizeTmp = 100;
		var pageTmp = 1;
		var contractCount = 0;
		var total = 0;
		$(document).ready(function(){
			console.log('achievement 업적');
			pageTmp = '1'; /* '${AchievementVO.page}' */
			pageSizeTmp = pageTmp * pageSize;
			
			// TODO : 기본검색일자 세팅
			console.log();
			$('#srch_start_date').val(firstDayOfMonth('-'));
			$('#srch_end_date').val(today('-'));
			
			getAchievementList();
			$('#bt_more').on('click', function(){
				//page = 1;
				pageTmp =  Number(pageTmp) + 1;
				console.log(pageTmp);
				pageSizeTmp = pageTmp * pageSize;
				console.log(pageSizeTmp);
				
				getAchievementList();
			});
			$('#bt_search, #bt_search2').on('click', function(){
				getAchievementList();
			});
		});
		
		function getAchievementList(){
			console.log('getAchievementList()');
			var params = { 
					page: page, 
					pageSize: pageSizeTmp,
					SRCH_CON_EMP_WORD: $('#search_word').val(), 
					SRCH_TERM_START_VALUE : $('#srch_start_date').val(),
					SRCH_TERM_END_VALUE : $('#srch_end_date').val(),
			}
			console.log(params);
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
					
					$('#achievementList').empty();
					$('#div_more').hide();
					var html = '';
					for (var i = 0; i<achievementList.length; i++){
						achievement = achievementList[i];
						// if (i == 0) { total = achievement.TOTAL;}
						html += ''
							 + '<li>'
							 + '	<a href="/mobile/achievement_detail.go?EMP_CD=' + achievement.EMP_CD + '&page=' + pageTmp 
							 + '&SRCH_TERM_START_VALUE=' + $('#srch_start_date').val() + '&SRCH_TERM_END_VALUE=' + $('#srch_end_date').val() + '">'
							 + '		<div class="clearfix2 title_wrap">'
							 + '			<div class="clearfix">'
							 + '				<p class="ellipsis">' + achievement.EMP_NM + '</p>'
							 + '				<p class="grey2_color ellipsis">(' + achievement.EMP_CD + ')</p>'
							 + '			</div>'
							 + '			<div>'
							 + '				<p class="has_right_border">' + achievement.EMPSTA + '</p>'
							 + '				<p class="point_color">' + achievement.CONT_CNT + '건</p>'
							 + '			</div>'
							 + '		</div>'
							 + '		<div class="clearfix2 bottom">'
							 + '			<p>CREDIT : ' + formatComma(achievement.CONT_CREDIT) + '</p>'
							 + '			<div class="right">'
							 + '				<p>USD : ' + formatComma(achievement.CONT_USD)+'</p>'
							 + '				<p>HKD : ' + formatComma(achievement.CONT_HKD)+ '</p>'
							 + '			</div>'
							 + '		</div>'
							 + '	</a>'
							 + '</li>'
							 ;
					}
					$('#achievementList').html(html);
					
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
		
		function today(seperator){
			var date = new Date(); 
			var year = date.getFullYear(); 
			var month = new String(date.getMonth()+1); 
			var day = new String(date.getDate()); 
			var sep = '';
			// 한자리수일 경우 0을 채워준다. 
			if(month.length == 1){ 
			  month = "0" + month; 
			} 
			if(day.length == 1){ 
			  day = "0" + day; 
			} 
			if (seperator == '' || seperator == undefined || seperator == null) {
				sep = ''
			} else {
				sep = seperator;
			}
			return year + sep + month + sep + day;
		};

		function firstDayOfMonth(seperator){
			var date = new Date(); 
			var year = date.getFullYear(); 
			var month = new String(date.getMonth()+1); 
			var day = new String(date.getDate()); 
			var sep = '';
			// 한자리수일 경우 0을 채워준다. 
			if(month.length == 1){ 
			  month = "0" + month; 
			} 
			if(day.length == 1){ 
			  day = "0" + day; 
			} 
			if (seperator == '' || seperator == undefined || seperator == null) {
				sep = ''
			} else {
				sep = seperator;
			}
			return year + sep + month + sep + "01";
		};
		
		</script>
	</head>
	<body>
		<%@ include file="./lnb.jsp" %>
		<section class="achievement list_wrap">
			<div class="search_bar point_bg">
				<input type="text" id="search_word"  name="SEARCH_WORD" class="search" placeholder="검색어를 입력하세요.">
				<button type="button" id="bt_search" class="search_icon"></button>
			</div>
			<div class="date_bar clearfix2"> 
				<div class="clearfix2">
					<input type="date" id="srch_start_date" name="SRCH_TERM_START_VALUE" placeholder="YYYY-MM-DD">
					<input type="date" id="srch_end_date"   name="SRCH_TERM_END_VALUE"   placeholder="YYYY-MM-DD">
				</div>
				<button id="bt_search2" type="button">검색</button>
			</div>
			<div>
				<ul id="achievementList" class="list">
				</ul>
				<div id="div_more" class="centerT">
					<button type="button" id="bt_more" class="more">더보기</button>
				</div>
			</div>
		</section>
	</body>
</html>