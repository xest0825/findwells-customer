		// 전화번호 유효성 검사
		function isPhoneNum(obj) { 
			calcCheck = false;
			var regexp = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})[0-9]{3,4}[0-9]{4}$/
			var flag = true;
			var objVal = obj.value;
			if (objVal != "") {
				if (!regexp.test(objVal)) {
					flag = false;
				}
				if (!flag) {
					alert("올바른 전화번호 형식이 아닙니다.");
					obj.value = "";
					setTimeout(function () {$(obj).focus();}, 10);
					return;
				}
			}
		}
		
		// 콤마 추가
		function formatComma(str) {
			str += '';
			x = str.split('.');
			x1 = x[0];
			x2 = x.length > 1 ? '.' + x[1] : '';
			var rgx = /(\d+)(\d{3})/;
			while (rgx.test(x1)) {
				x1 = x1.replace(rgx, '$1' + ',' + '$2');
			}
			return x1 + x2;
		};

		// 콤마 쩨거
		function removeComma(str) {
			return  str.replace(/,/gi, "");
		};
		
		// LPAD
		function lpad(str, padLen, padStr) {
		    if (padStr.length > padLen) {
		        console.log("오류 : 채우고자 하는 문자열이 요청 길이보다 큽니다");
		        return str;
		    }
		    str += ""; // 문자로
		    padStr += ""; // 문자로
		    while (str.length < padLen)
		        str = padStr + str;
		    str = str.length >= padLen ? str.substring(0, padLen) : str;
		    return str;
		}
		
		// isEmpty
		function isEmpty(obj){
			if (obj == null || obj == '' || obj == 'null' || obj == undefined){
				return true;
			} else if (!obj) {
				return true;
			} else if (obj.length == 0) {
				return true;;
			} else {
				return false;
			}
		}
		
		// isNotEmpty
		function isNotEmpty(obj){
			return !isEmpty(obj);
		}
		
		// 다음 주소 API
		function execPostCode() {
			// 우편번호 찾기 화면을 넣을 element를 지정
			var element_wrap = document.getElementById("li_daum_post");
			
			// 우편번호 layer가 off 된 상태라면 다음 우편번호 레이어를 open한다. 
			if ($('#li_daum_post').css('display') == 'none'){
				daum.postcode.load(function(){
			        new daum.Postcode({
			            oncomplete: function(data) {
			               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
		
			               // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
			               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			               var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
			               var extraRoadAddr = ''; // 도로명 조합형 주소 변수
		
			               // 법정동명이 있을 경우 추가한다. (법정리는 제외)
			               // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			               if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			                   extraRoadAddr += data.bname;
			               }
			               // 건물명이 있고, 공동주택일 경우 추가한다.
			               if(data.buildingName !== '' && data.apartment === 'Y'){
			                  extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			               }
			               // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			               if(extraRoadAddr !== ''){
			                   extraRoadAddr = ' (' + extraRoadAddr + ')';
			               }
			               // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
			               if(fullRoadAddr !== ''){
			                   fullRoadAddr += extraRoadAddr;
			               }
		
			               // 우편번호와 주소 정보를 해당 필드에 넣는다.
			               console.log(data.zonecode);
			               console.log(fullRoadAddr);
			               
			               if ($('#zip_cd').val() != data.zonecode) {
						       over_flag = false;
						       $("#addr_dtl").removeAttr("readOnly"); 
						       $("#addr_dtl").val('');
						       console.log("주소정보가 변경되었습니다. 기존 정보를 덮어씌웁니다.");
						   }
			               $("[name=zip_cd]").val(data.zonecode);
			               $("[name=addr]").val(fullRoadAddr);
			               
			           }
				       , onclose:function(state) {
			                if(state === "COMPLETE_CLOSE") {
			 
			                    // 콜백함수를 실행하여 슬라이드 업 기능이 실행 완료후 작업을 진행한다.
			                    offDaumZipAddress(function() {
			                        element_wrap.style.display = "none";
			                    });
			                }
			           }
			        }).embed(element_wrap);
			        
			        //
			        $('#li_daum_post').slideDown();
				});
			}
			// li_daum_post 레이어가 open 상태라면 다음 우편 레이어를 off 상태로 변경한다. 
			else {
		        // 콜백함수를 실행하여 슬라이드 업 기능이 실행 완료후 작업을 진행한다.
		        offDaumZipAddress(function() {
		            element_wrap.style.display = "none";
		            return false;
		        });
				
				
			}
	    }
		
		// 슬라이드 업 기능을 이용해 다음주소 레이어 창을 닫기
		function offDaumZipAddress() {
		    jQuery("#li_daum_post").slideUp();
		}
		
		function wrap_mask(c, time){
				if(c == 1){
					console.log('wrap_mask(1)')
					$(".wrap-loading").removeClass("loading_none");
				} else {
					setTimeout(function() {
						$(".wrap-loading").addClass("loading_none");
					}, time || 300);
				}
			}
		
		//엑셀다운로드 ajax
		function excelDown(formId, data) {
			if(data.excelpath == null || data.excelpath == undefined || data.excelpath == "") {
				data.excelpath = "DEFAULT.xlsx";
			}
			
			$.fileDownload($(formId).prop('action'), {
				httpMethod: "POST",
				data: data,
				prepareCallback: function() {
					// kendo.ui.progress($("body"), true);
					wrap_mask(1, 0);
				},
				successCallback: function (url) {
					wrap_mask(0, 300);
					// kendo.ui.progress($("body"), false);
				},
				failCallback: function(responesHtml, url) {
					wrap_mask(0, 300);
					// kendo.ui.progress($("body"), false);
					alert('엑셀다운로드 실패');
					// alert('error', '엑셀다운로드', '알 수 없는 에러가 발생하였습니다. 관리자에게 문의 해주세요.');
				}
			});
		}
		
		/**
		 * 날자객체를 문자열로 되돌립니다.
		 *
		 * @date    날자 객체
		 * @concatChar 연결문자
		 */
		function getYyyymm(date, concatChar) {
			return date.getFullYear() + concatChar +lpad("" + (date.getMonth() + 1), 2, '0');
		};

		//yyyy(구분자)mm 형식 달 계산
		function getYyyymmMonth(date, concatChar, n) {
			var y = date.getFullYear();
			var m = date.getMonth();

			date.setMonth(m - n);
			
			return new Date(date.getFullYear()+"-"+lpad(""+(date.getMonth() + 1), 2, '0')+"-01").format("yyyy"+concatChar+"MM");
		};

		function getYymmdd(date, concatChar) {
			return new Date(date.getFullYear()+"-"+lpad(""+(date.getMonth() + 1), 2, '0') + "-" + lpad("" + date.getDate(), 2, '0')).format("yyyy"+concatChar+"MM"+concatChar+"dd");
		};

		function getYymmdd_hhmmss(date, concatChar) {
			return  date.getFullYear()
			            + concatChar + lpad("" + (date.getMonth() + 1), 2, '0')
			            + concatChar + lpad("" + date.getDate(), 2, '0')
			            + ' ' +lpad("" + date.getHours(), 2, '0')
			            + ':' +lpad("" + date.getMinutes(), 2, '0')
			            + ':' +lpad("" + date.getSeconds(), 2, '0');
		};

		// n주 전
		function getYymmddWeek(date ,concatChar, n) {
			var y = date.getFullYear();
			var m = date.getMonth();
			var d = date.getDate();

			date.setDate(d - (7*n));
			
			return new Date(date.getFullYear()+"-"+lpad(""+(date.getMonth() + 1), 2, '0') + "-" + lpad("" + date.getDate(), 2, '0')).format("yyyy"+concatChar+"MM"+concatChar+"dd");
		};

		// n달 전
		function getYymmddMonth(date ,concatChar, n) {

			var y = date.getFullYear();
			var m = date.getMonth();
			var d = date.getDate();

			date.setMonth(m - n);
			
			return new Date(date.getFullYear()+"-"+lpad(""+(date.getMonth() + 1), 2, '0') + "-" + lpad("" + date.getDate(), 2, '0')).format("yyyy"+concatChar+"MM"+concatChar+"dd");
		};

		// 지난달 마지막일 구하기
		function getYymmddLastMonth(date ,concatChar) {

			var firstDayOfMonth = new Date(date.getFullYear(), date.getMonth() , 1 );
			var lastMonth = new Date ( firstDayOfMonth.setDate( firstDayOfMonth.getDate() - 1 ) );
			
			return new Date(lastMonth.getFullYear()+"-"+lpad(""+(lastMonth.getMonth() + 1), 2, '0') + "-" + lpad("" + lastMonth.getDate(), 2, '0')).format("yyyy"+concatChar+"MM"+concatChar+"dd");
		};

		/*
		 * 현재 날짜에서 n달 전(후) n일 구하기(마지막일은 nDay 구분자가 숫자가 아닌 'lastDay', 당일은 'today')
		 * 사용예)
		 *  - 한달 전 오늘날짜를 yyyy-MM-dd 형식으로 나오게 하고 싶으면 getDate("YMD", date, '-', 1, 'today')
		 *  - 한달 전 마지막 날짜를 yyyy-MM 형식으로 나오게 하고 싶으면 getDate("YM", date, '-', 1, 'lastDay')
		 *  - 두달 후 26일을 yyyyMMdd 형식으로 나오게 하고 싶으면 getDate("YMD", date, '', -2, 26)
		 *  - 당월 첫번째 날짜를  yyyy/MM/dd 형식으로 나오게 하고 싶으면 getDate("YMD", date, '/', 0, 1)
		 *  - 당월 첫번째 날짜를  yyyyMM 형식으로 나오게 하고 싶으면 getDate("YM", date, '', 0, 1)
		 */ 
		function getDate(dateFormat, date, concatChar, nMonth, nDay) {
			var m = date.getMonth();
			var d = nDay;
			
			//변경 전 날짜의 오늘날짜
			var originalToday = date.getDate();
			
			//31일인 월에 30일 혹은 29,28일 까지밖에 없는 월로 넘어가서 31일로 세팅되면 1달+ 됨. 따라서 아래와 같이 1일로 만든 후 월을 뺀 다음 if문에서 일자 비교 후 세팅
			date = new Date(date.getFullYear(), date.getMonth(), 1);
			
			//n달 전(후) 구하기
			date.setMonth(m - nMonth);
			
			//d가 1 ~ 31일이 아니거나 lastDay이고 today가 아닌  경우 무조건 n달 전/후의 마지막 일자
			if((!(d >= 1 && d <= 31) || d == "lastDay") && d != "today") {
				d = (new Date(date.getFullYear(), lpad(""+(date.getMonth() + 1), 2, '0'), 0)).getDate();
			}else if(d == "today") {
				//n달 전/후 오늘 날짜
				//변경 된 년월의 마지막 일자
				var changeToday = new Date(date.getFullYear(), (date.getMonth()+1), 0).getDate();
				
				//31일인 월에 30일 혹은 29,28일 까지밖에 없는 월로 넘어가서 31일로 세팅되면 1달+ 됨. 따라서 아래와 같이 세팅
				if(originalToday > changeToday) {
					//변경 전 오늘날짜가 변경 후 마지막일자보다 크면 변경 후 마지막 일자로 세팅
					d = changeToday;
				}else {
					//그렇지 아니면 변경 전 오늘날짜로 세팅
					d = originalToday;
				}
			}
			
			if(dateFormat == "YM") {
				return new Date(date.getFullYear()+"-"+lpad(""+(date.getMonth() + 1), 2, '0') + "-" + lpad("" + d, 2, '0')).format("yyyy"+concatChar+"MM");
			}else {
				return new Date(date.getFullYear()+"-"+lpad(""+(date.getMonth() + 1), 2, '0') + "-" + lpad("" + d, 2, '0')).format("yyyy"+concatChar+"MM"+concatChar+"dd");
			}
		};
		