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
		var emp_cd = '';
		var empInfo = {};
		$(document).ready(function(){
			console.log('personnel_detail');
			emp_cd = '${InSaVO.EMP_CD}';
			getEmpInfo();
		});
		
		function getEmpInfo(){
			var params = {
				EMP_CD : emp_cd,
			}
			console.log(params);
			$.ajax({
				url : "/empInfo/selectEmpInfo.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('selectEmpInfo success');
					console.log(data.results);
					empInfo = data.results;
					$('#emp_nm').text(empInfo.EMP_NM + '(' + empInfo.EMP_CD + ')');					
					$('#emp_nme').text(empInfo.EMP_NME);					
					$('#hpno').text(empInfo.HPNO);					
					$('#email').text(empInfo.EMAIL);					
					$('#ent_ymd').text(empInfo.ENT_YMD);	
					$('#clazz').text(empInfo.JIKGUB + ' / ' + empInfo.ROLE_NAME + ' / ' + empInfo.BOARD_ROLE_ID);
					$('#cnt').text(empInfo.CNT);
					$('#credit').text(formatComma(empInfo.CREDIT));
					$('uprem_amt').text(formatComma(empInfo.UPREM_AMT));
					$('hprem_amt').text(formatComma(empInfo.HPREM_AMT));
				},
				error : function(){
					alert('error');
				}
			});
		}
		
		function goEmpList(){
			location.href = '/mobile/personnel.go';
		}		
		</script>
	</head>
	<body>
		<header>
			<div class="back_wrap">
				<a href="javascript:;" onclick="goEmpList();"><img src="/img/icons/back_btn.png" alt="뒤로가기 버튼"></a>
			</div>
			<p class="header_title">인사관리 상세</p>
		</header>
		<section class="detail">
			<div id="emp_nm" class="detail_top">홍길동(FW001)</div>
			<div class="container">
				<div class="contract_table table2">
					<table>
						<colgroup>
							<col style="width: 25%;">
							<col style="width: 75%;">
						</colgroup>
						<tbody>
							<tr class="tr_left">
								<th>영문이름</th>
								<td id="emp_nme">English Name</td>
							</tr>
							<tr class="tr_left">
								<th>휴대전화</th>
								<td id="hpno">010-1234-1234</td>
							</tr>
							<tr class="tr_left">
								<th>이메일</th>
								<td id="email">email@gmail.com</td>
							</tr>
							<tr class="tr_left">
								<th>등급</th>
								<td id="clazz">A4 / 영업자 / E5</td>
							</tr>
							<tr class="tr_left">
								<th>등록일</th>
								<td id="ent_ymd">2020.05.05</td>
							</tr>
							<tr class="tr_left">
								<th>건수</th>
								<td id="cnt">19</td>
							</tr>
							<tr class="tr_left">
								<th>CREDIT</th>
								<td id="credit">180,000</td>
							</tr>
							<tr class="tr_left">
								<th>USD</th>
								<td id="uprem_amt">2,715</td>
							</tr>
							<tr class="tr_left">
								<th>HKD</th>
								<td id="hprem_amt">212,111</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</body>
</html>