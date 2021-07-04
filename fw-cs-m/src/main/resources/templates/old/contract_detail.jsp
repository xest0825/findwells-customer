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
		var seq = '';
		var contractListPage = '';
		$(document).ready(function(){
			console.log('contract_detail');
			seq = '${ContractVO.SEQ}';
			contractListPage = '${ContractVO.page}';
			getContract();
		});
		
		function getContract(){
			var params = {
				SEQ : seq,
				page : 1,
				pageSize: 10,
			}
			console.log(params);
			$.ajax({
				url : "/contract/selectContract.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('selectContract success');
					console.log(data.ContractVO);
					contract = data.ContractVO;
					$('#ifa_insco').text(contract.IFA_CD_NM + ' / ' + contract.INSCO_NM);
					$('#prod_nm').text(contract.PROD_NM);
					$('#insu_strt_date').text(contract.INSU_STRT_DATE);
					$('#cont_status').text(contract.CONT_STATUS);
					$('#inspol_no').text(contract.INSPOL_NO);
					$('#nap').text(contract.AUTO_TRANS_YN + ', ' + contract.NAPMETHOD + ', ' + contract.NAPGI+contract.NAPGI_GBN);
					$('#cont_period').text(contract.CONT_DATE + ' ~ ' + contract.INSU_END_DATE);
					$('#prem_amt').text(contract.UPREM_AMT!='0'?'USD: ' + formatComma(contract.UPREM_AMT):'HKD: ' + formatComa(contract.HPREM_AMT));
					$('#credit').text(formatComma(contract.CREDIT));
					console.log(data.customerList);
					customerList = data.customerList;
					$('#div_customer').empty();
					var html = '';
					for (var i = 0; i<customerList.length; i++){
						customer = customerList[i];
						var gubun = '';
						if (customer.GUBUN == 'GEAJA') {
							gubun = '계약자'
						} else if (customer.GUBUN == 'PIABO'){
							gubun = '피보험자'
						} else {
							gubun = '수익자'							
						}
						html += ''
							 +  ''
							 +  '<ul class="contract_list">'
							 +  '	<li>'
							 +  '		<div class="clearfix2">'
							 +  '			<p class="font_16">'+customer.CUST_NM+'('+customer.CUST_NME+')</p>'
							 +  '			<p class="font_14 point_color">'+ gubun+'</p>'
							 +  '		</div>'
							 +  '		<ul class="list_box clearfix">'
							 +  '			<li>'
							 +  '				<a href="javascript:call(\''+customer.CUST_CELL+'\');"><img src="/img/icons/call_icon.png" alt="전화 아이콘"></a>'
							 +  '			</li>'
							 +  '			<li>'
							 +  '				<a href="javascript:sms(\''+customer.CUST_CELL+'\');"><img src="/img/icons/message_icon.png" alt="문자 아이콘"></a>'
							 +  '			</li>'
							 +  '			<li>'
							 +  '				<a href="javascript:email(\''+customer.CUST_EMAIL+'\');"><img src="/img/icons/mail_icon.png" alt="메일 아이콘"></a>'
							 +  '			</li>'
							 +  '			<li>'
							 +  '				<a href="javascript:map(\''+customer.CUST_ID+'\');"><img src="/img/icons/map_icon.png" alt="지도 아이콘"></a>'
							 +  '			</li>'
							 +  '		</ul>'
							 +  '	</li>'
							 +  '</ul>'
							 ;
						
					}
					$('#div_customer').html(html);
					//console.log(data.fileList);
					
				},
				error : function(){
					alert('error');
				}
			});
		}
		function goContractList(){
			location.href = '/mobile/contract.go?page='+contractListPage;
		}
		function call(cust_tel){
			console.log(cust_tel);
			location.href = 'tel:' + cust_tel;
		}
		function sms(cust_tel){
			console.log(cust_tel);
			location.href = 'sms:' + cust_tel;
		}
		function email(cust_email){
			console.log(cust_email);
			location.href = 'email:' + cust_emaill;
		}
		function map(cust_id){
			console.log(cust_id);
		}
		</script>
	</head>
	<body>
	<header>
		<div class="back_wrap">
			<a href="javascript:;" onclick="goContractList();"><img src="/img/icons/back_btn.png" alt="뒤로가기 버튼"></a>
		</div>
		<p class="header_title">보유계약 상세</p>
	</header>
	<section class="contract_detail detail">
		<div class="contract_table">
			<table>
				<colgroup>
					<col style="width: 40%;">
					<col style="width: 60%;">
				</colgroup>
				<thead>
					<tr class="tr_left">
						<th id="ifa_insco"></th>
						<td id="prod_nm"></td>
					</tr>
				</thead>
				<tbody>
					<tr class="tr_left">
						<th>이슈일자</th>
						<td id="insu_strt_date"></td>
					</tr>
					<tr class="tr_left">
						<th>계약상태</th>
						<td id="cont_status" class="point_color"></td>
					</tr>
					<tr class="tr_left">
						<th>증권번호</th>
						<td id="inspol_no"></td>
					</tr>
					<tr class="tr_left">
						<th>납입정보</th>
						<td id="nap"></td>
					</tr>
					<tr class="tr_left">
						<th>계약기간</th>
						<td id="cont_period"></td>
					</tr>
					<tr class="tr_left">
						<th>납입금</th>
						<td id="prem_amt"></td>
					</tr>
					<tr class="tr_left">
						<th>CREDIT</th>
						<td id="credit"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="div_customer">
		</div>
	</section>
</body>
</html>