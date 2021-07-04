<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 
######################################################################
페이지 설명 : 상품자료실 조회 페이지
######################################################################
 -->
<html>
	<head>
		<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, shrink-to-fit=no">
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
		<script type="text/javascript">
		var boardList = [];
		var board = {};
		var itemList = [];
		var item = {};
		var pageSize = 20;
		var page = 1;
		var pageSizeTmp = 20;
		var pageTmp = 1;
		var itemCount = 0;
		$(document).ready(function(){
			console.log('data 상품자료실');
			pageTmp = '${BoardVO.page}';
			pageSizeTmp = pageTmp * pageSize;
			getBoardList();
			getItemList();
			$('#bt_more').on('click', function(){
				//page = 1;
				pageTmp =  Number(pageTmp) + 1;
				// console.log(pageTmp);
				pageSizeTmp = pageTmp * pageSize;
				// console.log(pageSizeTmp);
				
				getItemList();
			});
			$('#bt_search').on('click', function(){
				getItemList();
			});
			
			
		});
		
		function getBoardList(){
			console.log('getBoardList')
			var params = {
			}
			$.ajax({
				url : "/board/selectBoardList.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getBoardList success');
					// console.log(data.results);
					if (data.results != null && data.results != undefined && data.results.length != 0){
						for (var i = 0; i<data.results.length; i++) {
							board = data.results[i];
							
							if (board.FOLDER_YN == 'N' && board.ISLEAF == 1 && board.LV == 3 && board.PBD_NO == 3) {
								boardList.push(board);
							}
						}
					}
					// console.log(boardList);
				},
				error : function(){
					alert('error');
				}
			});
			
		}
		
		function getItemList(){
			console.log('getItemList');
			var params = { BD_NO : "3", SEARCH_WORD: $('#search_word').val(), page: page, pageSize: pageSizeTmp}
			$.ajax({
				url : "/board/selectItemList.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getSelectItemList success');
					// console.log(data.results);
					item = data.results;
					itemCount = data.results.length;

					$('#itemList').empty();
					$('#div_more').hide();
					var html = '';
					for (var i = 0; i<item.length; i++) {
						html += ''					
							 +	'<li>'
							 +	'	<a href="/mobile/data_detail.go?BD_NO='+item[i].BD_NO +'&ITEM_NO=' + item[i].ITEM_NO+ '&page=' + pageTmp + '">'
							 +	'		<div class="clearfix title_wrap new">'
							 +	'			<p class="ellipsis title">' + item[i].TITL.replace(/"/g, '') + '</p>'
							 +  '			<img src="/img/icons/new_icon.png" alt="" class="new_icon">' // read 여부를 확인하여 표시
							 +	'		</div>'
							 +	'		<div class="clearfix2 name_wrap">'
							 +	'			<div class="left">'
							 +	'				<p class="has_right_border">' + item[i].BD_NM + '</p>'
							 +	'				<p>' + item[i].AUTHOR_NM + '</p>'
							 +	'			</div>'
							 +	'			<p class="date">' + item[i].WRT_DTM.substring(0,10) + '</p>'
							 +	'		</div>'
							 +	'	</a>'
							 +	'</li>'
							 ;
					}
					$('#itemList').html(html);
					
					// console.log(item.length)
					// console.log(pageSizeTmp)
					if (item.length == pageSizeTmp) {
						// console.log('itemCount == pageSizeTmp')
						$('#div_more').show();
					}
					// console.log(itemList);
				},
				error : function(){
					alert('error');
				}
			});
			
		}
		</script>
	</head>
	<body>
		<%@ include file="./lnb.jsp" %>
		<section class="data list_wrap">
			<div class="search_bar point_bg">
				<input type="text" id="search_word" class="search" placeholder="검색어를 입력하세요.">
				<button type="button" id="bt_search" class="search_icon"></button>
			</div>
			<div>
				<ul id="itemList" class="list">
				</ul>
				<div id="div_more" class="centerT">
					<button type="button" id="bt_more" class="more">더보기</button>
				</div>
			</div>
		</section>
	</body>
</html>