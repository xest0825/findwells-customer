<!DOCTYPE html>
<%@ include file="/common/jstl-tld.jsp" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, shrink-to-fit=no">
		<meta name="HandheldFriendly" content="true">
		<title>FINDWELLS</title>
		<!-- googlefont -->
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.4.0/main.min.css" />
		<link rel="stylesheet" href="https://unpkg.com/@fullcalendar/daygrid@4.4.0/main.min.css" />
		<link rel="stylesheet" href="/css/mobile/common.css"/>
		<link rel="stylesheet" href="/css/mobile/style.css"/>
		<script type="text/javascript" src="/js/mobile/jquery.js"></script>
		<script type="text/javascript" src="/js/genexon.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/core@4.4.0/main.min.js"></script>
		<script src="https://unpkg.com/@fullcalendar/interaction@4.4.0/main.min.js"></script>
		<script src="https://unpkg.com/@fullcalendar/daygrid@4.4.0/main.min.js"></script>
		<script type="text/javascript" src="/js/mobile/style.js"></script>
		<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
		<script type="text/javascript">
		var bd_no = '';
		var item_no = '';
		var itemListPage = '';
		var title = '';
		$(document).ready(function(){
			Kakao.init('9f36306bded4e1ed5b333f37d9313d38');
			console.log('notice_detail');
			bd_no = '${BoardItemVO.BD_NO}'||'';
			item_no = '${BoardItemVO.ITEM_NO}'||'';
			itemListPage = '${BoardItemVO.page}'||0;
			in_emp_cd = '${BoardItemVO.IN_EMP_CD}'||'';
			in_emp_nm = '${BoardItemVO.IN_EMP_NM}'||'';
			getItem();
		});
		
		function initKakao(){
			//<![CDATA[
			Kakao.init('9f36306bded4e1ed5b333f37d9313d38');
			Kakao.Link.createTalkLinkButton({
				container: '#kakao-link-btn',
				label: '리포트 공유',
				image: {
					src: 'http://m.f-ims.com/resources/img/logo.png',
					width: '300',
					height: '200'
				},
				webButton: {
					text: '리포트 공유',
					url: 'http://m.f-ims.com/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG'
				}
			});
			//]]>
		}
		

		
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
					//console.log(data.results);
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
					title = item.TITL;
					$('#bd_nm').text(item.BD_NM);
					$('#author_nm').text(in_emp_nm);
					$('#wrt_dtm').text(item.WRT_YMD.substring(0,10));
					var html = item.CONT;
					$('#cont').empty();
					var html1 = $('#cont').html(html).text();
					html1 = html1.replace(/\/Upload/g, 'http://fims.genexon.co.kr/Upload');
					html1 += '<br/><br/>';
					$('#cont').html(html1);
					//console.log(html1);
					$('#cont').find('img').each(function(i,e){
						$(this).css("width", '99%');
					});
					
				},
				error : function(){
					alert('error');
				}
			});
		}
		function goItemList(){
			location.href = '/mobile/report.go?page='+itemListPage;
		}
		
		function shareReport(){
			console.log('shareReport');
			console.log('http://m.f-ims.com/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG');
			var snsName = 'kakao';
			var link = 'http://m.f-ims.com/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG';
			var title = '리포트공유';
			
			//function snsShare(snsName, link, title) {

				if (title === null) return false;

				var snsPopUp;
				var _width = '500';
				var _height = '450';
				var _left = Math.ceil(( window.screen.width - _width )/2);
				var _top = Math.ceil(( window.screen.height - _height )/2);

				switch(snsName){
					case 'facebook':
						snsPopUp = window.open("http://www.facebook.com/sharer/sharer.php?u=" + link, '', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top);
						break;

					case 'twitter' :
						snsPopUp = window.open("http://twitter.com/intent/tweet?url=" + link + "&text=" + title, '', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top);
						break;

					case 'kakao' :
						snsPopUp = window.open("https://story.kakao.com/share?url=" + link, '', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top);
						break;

					case 'addurl' :
						var dummy = document.createElement("textarea");
						document.body.appendChild(dummy);
						dummy.value = link;
						dummy.select();
						document.execCommand("copy");
						document.body.removeChild(dummy);
						oneBtnModal("URL이 클립보드에 복사되었습니다.");
						break;
				}
			// }
		}
		
		function sendLink() {
			// location.href = 'http://localhost:8080/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG';
			
		    Kakao.Link.sendDefault({
		      objectType: 'feed',
		      content: {
		        title: '리포트 공유 ' + genexon.getYymmdd(new Date(), '/'),
		        description: title,
		        imageUrl :'http://m.f-ims.com/resources/img/logo.png',
		        link: {
		          mobileWebUrl: 'http://m.f-ims.com/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG',
		          webUrl:  'http://m.f-ims.com/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG',
		          //mobileWebUrl: 'http://localhost:8080/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG',
		          //webUrl:  'http://localhost:8080/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG',
		        },
		      },

		    })
		    
		}
		
	</script>
	</head>
	<body>	
		<header>
			<div class="back_wrap">
				<a href="javascript:;" onclick="goItemList();"><img src="/img/icons/back_btn.png" alt="뒤로가기 버튼"></a>
			</div>
			<p class="header_title">리포트</p>
		</header>
		<section class="detail">
			<div class="detail_title_wrap">
				<p id="title" class="top_title"></p>
				<div class="name_wrap clearfix2">
					<div class="left">
						<p id="bd_nm" class="has_right_border"></p>
						<p id="author_nm"></p>
						<!-- 
						<p id="share_icon" style="margin-left:10px;margin-bottom:5px;z-index:2" onclick="shareReport();">
						<img src="/img/icons/share-icon.png" style="width:24px;" alt="공유"/>
						</p>
						 -->
						<a id="kakao-link-btn" href="javascript:sendLink();">
							<img src="//dev.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_small.png"/>
						</a>

					</div>
					<p id="wrt_dtm" class="date"></p>
				</div>
			</div>
			<div class="container">
				<ul id="div_file_down" class="file_down">
				</ul>
				<div id="cont"  class="text_wrap">
				</div>
			</div>
		</section>
	</body>
	<script>
	//<![CDATA[
	//Kakao.init('9f36306bded4e1ed5b333f37d9313d38');
	Kakao.Link.createTalkLinkButton({
		container: '#kakao-link-btn',
		label: '리포트 공유',
		image: {
			src: 'http://m.f-ims.com/resources/img/logo.png',
			width: '300',
			height: '200'
		},
		webButton: {
			text: '리포트 공유',
			url: 'http://m.f-ims.com/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG'
			//url: 'http://localhost:8080/user_report.go?BD_NO=62&ITEM_NO='+ item_no + '&SHARER=' + in_emp_cd + '&MB_ID=YNG'
		}
	});
	//]]>	
	</script>

	

</html>