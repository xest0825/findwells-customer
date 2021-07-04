<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		var bd_no = '';
		var item_no = '';
		var itemListPage = '';
		$(document).ready(function(){
			console.log('notice_detail');
			bd_no = '${BoardItemVO.BD_NO}';
			item_no = '${BoardItemVO.ITEM_NO}';
			itemListPage = '${BoardItemVO.page}';
			getItem();
		});
		
		function getItem(){
			var params = {
				BD_NO : bd_no,
				ITEM_NO : item_no,
				page : 1,
				pageSize: 10,
			}
			$.ajax({
				url : "/board/selectItem.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getSelectItemList success');
					console.log(data.results);
					itemCount = data.results;
					if (data.results != null && data.results != undefined) {
						item = data.results;
					}
					//console.log(item);
					$('#div_file_down').empty();
					var filehtml = '';
					if (item.fileList.length > 0){
						
						for (var i = 0; i<item.fileList.length; i++){
							filehtml += ''
									 + '<li>'
									 + '<a href="'+'http://fims.genexon.co.kr'+  item.fileList[i].FILE_URL  +'"><img src="/img/icons/down_icon.png" alt="파일다운 아이콘">'+item.fileList[i].FILE_NM+'</a>'
									 + '</li>'
									 ;
						}
					}
					$('#div_file_down').html(filehtml);
					
					$('#title').text(item.TITL);
					$('#bd_nm').text(item.BD_NM);
					$('#author_nm').text(item.AUTHOR_NM);
					$('#wrt_dtm').text(item.WRT_DTM.substring(0,10));
					var html = item.CONT;
					$('#cont').empty();
					var html1 = $('#cont').html(html).text();
					html1 = html1.replace(/\/Upload/g, 'http://fims.genexon.co.kr/Upload');
					html1 += '<br/><br/>';
					$('#cont').html(html1);
					//console.log(html1);
					$('#cont').find('img').each(function(i,e){
						$(this).css("width", '99%');
					})
					
				},
				error : function(){
					alert('error');
				}
			});
		}
		function goItemList(){
			location.href = '/mobile/data.go?page='+itemListPage;
		}
		</script>
	</head>
	<body>	
		<header>
			<div class="back_wrap">
				<a href="javascript:;" onclick="goItemList();"><img src="/img/icons/back_btn.png" alt="뒤로가기 버튼"></a>
			</div>
			<p class="header_title">상품자료실 상세</p>
		</header>
		<section class="detail">
			<div class="detail_title_wrap">
				<p id="title" class="top_title"></p>
				<div class="name_wrap clearfix2">
					<div class="left">
						<p id="bd_nm" class="has_right_border"></p>
						<p id="author_nm"></p>
					</div>
					<p id="wrt_dtm" class="date"></p>
				</div>
			</div>
			<div class="container">
				<ul id="div_file_down" class="file_down">
				</ul>
				<div id="cont" class="text_wrap">
				</div>
			</div>
		</section>
	</body>
</html>