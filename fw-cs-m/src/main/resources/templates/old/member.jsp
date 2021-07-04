<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 
######################################################################
페이지 설명 : 고객 조회 페이지 
######################################################################
 -->
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
		var customerList = [];
		var cusomer = {};
		var pageSize = 100;
		var page = 1;
		var pageSizeTmp = 100;
		var pageTmp = 1;
		var contractCount = 0;
		var total = 0;
		$(document).ready(function(){
			console.log('member 고객');
			pageTmp = '1';
			pageSizeTmp = pageTmp * pageSize;
			getCustomerList();
			$('#bt_more').on('click', function(){
				//page = 1;
				pageTmp =  Number(pageTmp) + 1;
				console.log(pageTmp);
				pageSizeTmp = pageTmp * pageSize;
				console.log(pageSizeTmp);
				
				getCustomerList();
			});
			$('#bt_search').on('click', function(){
				getCustomerList();
			});
			
			
		});
		
		function getCustomerList(){
			console.log('getCustomerList');
			var params = { SRCH_CUS_WORD: $('#search_word').val(), page: page, pageSize: pageSizeTmp}
			$.ajax({
				url : "/customer/selectCustomerList2.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getContractList success');
					console.log(data.results);
					customerList = data.results;
					customerCount = data.results.length;
					total = customerCount;
					
					$('#customerList').empty();
					$('#div_more').hide();
					var html = '';
					for (var i = 0; i<customerList.length; i++){
						customer = customerList[i];
						//if (i == 0) { total = contract.TOTAL;}
						var gender = customer.GNDR_CD;
						var src = '';
						if (gender == 'M') {
							src = '/img//profile.png';
						} else if (gender =='W') {
							src = '/img//profile2.png';
						} else {
							src = '/img//profile3.png';
						}
						html += ''
							 + '<li>'
							 + '	<a href="/mobile/member_detail.go?CUST_ID='+customer.CUST_ID+'&page=' +pageTmp + '">'
							 + '		<div class="clearfix img_box">'
							 + '			<img src="'+src+'" alt="">'
							 + '		</div>'
							 + '		<div class="member_info">'
							 + '			<p class="ellipsis">'+customer.CUST_NM+'('+customer.CUST_NME+')</p>'
							 + '			<p>'+(customer.SSN==''|| customer.SSN == null || customer.SSN == undefined ? '': customer.SSN.substring(0,8)+'******')+'</p>'
							 + '		</div>'
							 + '	</a>'
							 + '</li>'
							 ;
					}
					$('#customerList').html(html);
					
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
		</script>
	</head>
	<body>	
		<%@ include file="./lnb.jsp" %>
		<section class="member list_wrap">
			<div class="search_bar point_bg">
				<input type="text" id="search_word" class="search" placeholder="검색어를 입력하세요.">
				<button type="button" id="bt_search" class="search_icon"></button>
			</div>
			<div>
				<ul id="customerList" class="list">
					
				</ul>
				<div id="div_more" class="centerT">
					<button type="button" id="bt_more" class="more">더보기</button>
				</div>
			</div>
		</section>
	</body>
</html>