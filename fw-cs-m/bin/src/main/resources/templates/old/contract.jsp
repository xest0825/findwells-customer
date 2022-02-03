<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 
######################################################################
페이지 설명 :보유 계약 조회 페이지 
#####################################################################3
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
		var contractList = [];
		var contract = {};
		var pageSize = 100;
		var page = 1;
		var pageSizeTmp = 100;
		var pageTmp = 1;
		var contractCount = 0;
		var total = 0;
		$(document).ready(function(){
			console.log('contract 계약');
			pageTmp = '1';
			pageSizeTmp = pageTmp * pageSize;
			getContractList();
			$('#bt_more').on('click', function(){
				//page = 1;
				pageTmp =  Number(pageTmp) + 1;
				console.log(pageTmp);
				pageSizeTmp = pageTmp * pageSize;
				console.log(pageSizeTmp);
				
				getContractList();
			});
			$('#bt_search').on('click', function(){
				getContractList();
			});
			
			
		});
		
		function getContractList(){
			console.log('getContractList');
			var params = {SEARCH_WORD: $('#search_word').val(), page: page, pageSize: pageSizeTmp}
			$.ajax({
				url : "/contract/selectExistingContractList2.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getContractList success');
					console.log(data.results);
					contractList = data.results;
					contractCount = data.results.length;
					total = contractCount;
					
					$('#contractList').empty();
					$('#div_more').hide();
					var html = '';
					for (var i = 0; i<contractList.length; i++){
						contract = contractList[i];
						if (i == 0) { total = contract.TOTAL;}
						html += ''
							 + '<li style="height:115px;">'
							 + '	<a href="/mobile/contract_detail.go?SEQ='+contract.SEQ+'&page='+ pageTmp+ '">'
							 + '		<div class="clearfix title_wrap">'
							 + '			<p class="ellipsis title">' + '' + contract.MO_NM + '(' + contract.MO_CD +')' + ',&nbsp;&nbsp;' + contract.GEAJA_NM+' / ' + contract.PIABO_NM 
							 + ((contract.BENEFICIARY_NM == null || contract.BENEFICIARY_NM == undefined)?'':', ' + contract.BENEFICIARY_NM) +'</p>'
							 + '		</div>'
							 + '		<div class="clearfix2 name_wrap">'
							 + '			<div class="left">'
							 + '				<p>' + contract.IFA_CD + ' / ' + contract.INSCO_CD 
							 + ' ' + contract.PROD_NM + ', ' + contract.CONT_STATUS 
							 + ', ' + contract.NAPMETHOD + ', ' + contract.NAPGI + contract.NAPGI_GBN_NM + '</p>'
							 + '				</br>'
							 + '			<p style="margin-top:5px;" class="font_14 grey3_color">'
							 + (contract.UPREM_AMT!='0'?'USD : ' + formatComma(contract.UPREM_AMT):'HKD : ' + formatComma(contract.HPREM_AMT))
							 + ', CREDIT : ' + formatComma(contract.CREDIT) + '</p>'
							 + '				</br>'							 
							 + '				<p style="margin-top:5px;">'+ '이슈: ' + contract.INSU_STRT_DATE + ', 계약: '+ contract.CONT_DATE + ', 종료: '+ contract.INSU_END_DATE +  '</p>'
							 + '			</div>'
							 + '		</div>'
							 + '	</a>'
							 + '</li>'
							 ;
					}
					$('#contractList').html(html);
					
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
		<section class="contract list_wrap">
			<div class="search_bar point_bg">
				<input type="text" id="search_word" class="search" placeholder="검색어를 입력하세요.">
				<button type="button" id="bt_search" class="search_icon"></button>
			</div>
			<div>
				<ul id="contractList" class="list">
				</ul>
				<div id="div_more" class="centerT">
					<button type="button" id="bt_more" class="more">더보기</button>
				</div>
			</div>
		</section>
	</body>
</html>