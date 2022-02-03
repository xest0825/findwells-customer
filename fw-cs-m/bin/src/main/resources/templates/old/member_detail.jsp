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
		<script type="text/javascript">
		var cust_id = '';
		var customerListPage = '';
		var customer = {};
		$(document).ready(function(){
			console.log('customer_detail');
			cust_id = '${CustomerVO.CUST_ID}';
			customerListPage = '${CustomerVO.page}';
			getCustomer();
		});
		
		function getCustomer(){
			var params = {
				CUST_ID : cust_id,
				page : 1,
				pageSize: 10,
			}
			console.log(params);
			$.ajax({
				url : "/customer/selectCustomer.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('selectCustomer success');
					console.log(data.customerInfo);
					customer = data.customerInfo;
					var html = '';
					$('#cust_nm').text(customer.CUST_NM + '(' + customer.CUST_NME + ')');
					$('#passport_num').text(customer.PASSPORT_NUM);
					if (customer.SSN != '' && customer.SSN != null && customer.SSN != undefined) {
						$('#ssn').text(customer.SSN.substring(0,8) + '******');
						var foreign = '';
						var gender = '';
						if (customer.GNDR_CD == 'M'){
							gender = '남';
						} else if (customer.GNDR_CD == 'W'){
							gender = '여';							
						} else {
							gender = '기업';							
						}
						if (customer.FOREIGN_YN == 'Y') {
							foreign = '외국인';
						} else {
							foreign = '내국인';
						}
						$('#gender_foreign').text('(' + gender + ', ' + foreign + ')');
					}
					$('#email').text(customer.EMAIL);
					$('#telno').text(customer.CUST_CELL);
					$('#address').text('('+customer.ZIPCD + ')' + customer.ADDR1 + ' ' + customer.ADDR2)
					$('#address_eng').text(customer.ADDRE1 + ' ' + customer.ADDRE2);
					$('#company').text(customer.COMPANY);
					$('#job').text(customer.JOB);
					$('#jikgub').text(customer.JIKGUB);
					$('#business_num').text(customer.BUSINESS_NUM);
					if (customer.COMPANY_ADDR1 != null && customer.COMPANY_ADDR1 != ''){
						var company_zipcd = '';
						if (customer.COMPANY_ZIPCD !=null && customer.ZIPCD != ''){
							company_zipcd = '(' + customer.COMPANY_ZIPCD + ') ';
						} 
						$('#company_address').text(company_zipcd + cusomer.COMPANY_ADDR1 + ' ' + customer.COMPANY_ADDR2);
					}
					if (customer.BANK != null && customer.BANK != '') {
						$('#bank_account').text(customer.BK_ID + ' ' + customer.BANK);
					}
					if (customer.CARD_NO != null && customer.CARD_NO != '') {
						$('#card_no').text(customer.CARD_NO);
						$('#card_end').text(customer.CARD_END_MM + '/' + customer.CARD_END_YY);
						$('@card_cvs').text(customer.CARD_CVS);
					}
					if(customer.TALL != null && customer.TALL != ''){
						$('#tall').text(customer.TALL);
					}
					if(customer.WEIGHT != null && customer.WEIGHT != ''){
						$('#tall').text(customer.WEIGHT);
					}
					if(customer.MEMO != null && customer.MEMO != ''){
						$('#memo').text(customer.MEMO);
					}
					
				},
				error : function(){
					alert('error');
				}
			});
		}
		
		function goCustomerList(){
			location.href = '/mobile/member.go?page='+customerListPage;
		}
		
		function call(){
			console.log('call');
			location.href = 'tel:' + customer.CUST_CELL;
		}
		function sms(){
			console.log('sms');
			location.href = 'sms:' + customer.CUST_CELL;
		}
		function email(){
			console.log('email');
			location.href = 'email:' + customer.CUST_EMAIL;
		}
		function map(){
			console.log('map');
		}
		</script>
	</head>
	<body>	
		<header>
			<div class="back_wrap">
				<a href="javascript:;" onclick="goCustomerList();"><img src="/img//icons/back_btn.png" alt="뒤로가기 버튼"></a>
			</div>
			<p class="header_title">고객 상세</p>
		</header>
		<section class="member_detail detail">
			<div id="cust_nm" class="detail_top"></div>
			<ul class="contract_list">
				<li>
					<ul class="list_box clearfix">
						<li>
							<a href="javascript:call();"><img src="/img//icons/call_icon.png" alt="전화 아이콘"></a>
						</li>
						<li>
							<a href="javascript:sms();"><img src="/img//icons/message_icon.png" alt="문자 아이콘"></a>
						</li>
						<li>
							<a href="javascript:email();"><img src="/img//icons/mail_icon.png" alt="메일 아이콘"></a>
						</li>
						<li>
							<a href="javascript:map();"><img src="/img//icons/map_icon.png" alt="지도 아이콘"></a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="container">
				<div class="contract_table table2">
					<table>
						<colgroup>
							<col style="width: 25%;">
							<col style="width: 75%;">
						</colgroup>
						<tbody>
							<tr class="tr_left">
								<th>여권번호</th>
								<td id="passport_num"></td>
							</tr>
							<tr class="tr_left">
								<th>주민번호</th>
								<td><span id="ssn"></span><span id="gender_foreign" class="font_14 grey3_color ml30"></span></td>
							</tr>
							<tr class="tr_left">
								<th>이메일</th>
								<td id="email"></td>
							</tr>
							<tr class="tr_left">
								<th>휴대폰번호</th>
								<td id="telno"></td>
							</tr>
							<tr class="tr_left">
								<th valign="top">주소</th>
								<td class="address_wrap">
									<p id="address" class="address_ko"></p>
									<p id="address_eng" class="address_en"></p>
								</td>
							</tr>
							<tr class="tr_left">
								<th>직장명</th>
								<td id="company"></td>
							</tr>
							<tr class="tr_left">
								<th>사업자번호</th>
								<td id="business_num"></td>
							</tr>
							<tr class="tr_left">
								<th>직급</th>
								<td id="jikgub"></td>
							</tr>
							<tr class="tr_left">
								<th>하는 일</th>
								<td id="job"></td>
							</tr>
							<tr class="tr_left">
								<th valign="top">직장주소</th>
								<td class="address_wrap">
									<p id="company_address" class="address_ko"></p>
								</td>
							</tr>
							<tr class="tr_left">
								<th>계좌정보</th>
								<td id="bank_account"></td>
							</tr>
							<tr class="tr_left">
								<th>신용카드</th>
								<td class="card_info">
									<p id="card_no"><span id="card_end"></span><span id="card_cvs"></span></p>
								</td>
							</tr>
							<tr class="tr_left">
								<th>키</th>
								<td id="tall"></td>
							</tr>
							<tr class="tr_left">
								<th>몸무게</th>
								<td id="weight"></td>
							</tr>
							<tr class="tr_left">
								<th>기타정보</th>
								<td id="memo"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</body>
</html>