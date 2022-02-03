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
		var persnonnelList = [];
		var personnel = {};
		var personnelCount = 0;
		var total = 0;
		$(document).ready(function(){
			console.log('personnel');
			getPersonnelList();
		});
		function getPersonnelList(){
			console.log('getPersonnelList');
			var params = { }
			$.ajax({
				url : "/insa/selectInsaTreeView.ajax",
				type : "POST",
				dataType : "json",
				data : params,
				success : function(data){
					console.log('getPersonnelList success');
					// console.log(data.results);
					personnelList = data.results;
					
					personnelCount = data.results.length;
					total = personnelCount;
					
					$('#personnelList').empty();
					var maxLevel = 1;
					var html = '';
					var html2 = '';
					for (var i = 0; i<personnelList.length; i++){
						personnel = personnelList[i];
						maxLevel = Math.max(maxLevel, personnel.LEVEL);
					}
					console.log(maxLevel);
					
					for (var i = 0; i<personnelList.length; i++){
						personnel = personnelList[i];
						html = '';
						html2 = '';
						if (Math.round(personnel.LEVEL) == 1){
							console.log('LEVEL : ' + personnel.LEVEL + ', EMP_CD: '+ personnel.EMP_CD + ', EMP_NM: ' + personnel.EMP_NM + ', MG_EMP_CD: ' + personnel.MG_EMP_CD);
							html += ''
								 +  '<input type="checkbox" id="root"/><label for="root"><a href="./personnel_detail.go?EMP_CD='+personnel.EMP_CD+'">'+personnel.EMP_NM+'<span>('+personnel.EMP_CD+')</span></a></label>'
								 +  '<ul id="'+personnel.EMP_CD+'"></ul>'
								 ;
							$('#personnelList').html(html);
						} 
						if (Math.round(personnel.LEVEL) >= 2) {
							console.log('LEVEL : ' + personnel.LEVEL + ', EMP_CD: '+ personnel.EMP_CD + ', EMP_NM: '+ personnel.EMP_NM+ ', MG_EMP_CD: ' + personnel.MG_EMP_CD);
						    html2 += ''
								  +  '	<li>';
								  if (personnel.ISLEAF == 0){
							html2 +=  '		<input type="checkbox" id="group_'+personnel.EMP_CD+'"><label for="group_'+personnel.EMP_CD+'"><a href="./personnel_detail.go?EMP_CD='+personnel.EMP_CD+'" >'+personnel.EMP_NM+'<span>('+personnel.EMP_CD+')</span></a></label>'
								  } else {
							html2 +=  '		<a href="./personnel_detail.go" class="solo">'+personnel.EMP_NM+'<span>('+personnel.EMP_CD+')</span></a>'									  
								  }
							html2 +=  '		<ul id="'+personnel.EMP_CD+'"></ul>'
								  +  '  </li>'
								  ;
							$('#'+personnel.MG_EMP_CD).append(html2);
						} 

					}
					$('#root').trigger('click');
					

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
		<section class="personnel">
			<div class="search_bar point_bg">
				<input type="text" id="search_word" class="search" placeholder="검색어를 입력하세요.">
				<button type="button" id="bt_search" class="search_icon"></button>
			</div>
			<div id="personnelList" class="personnel_list">
			</div>
		</section>
	</body>
</html>