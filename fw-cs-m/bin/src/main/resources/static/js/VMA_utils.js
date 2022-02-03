/**
 * 
 */


/* 조직계층검색 dropdownlist 생성 */
var initScdDropDonwList = function(com_ym_ID, scd_ID, minLv, maxLv){
	
	/* 마감월 id */
	var com_ym_ID = com_ym_ID;
	
	/* 조직 계층검색 object id */
	var scd_ID = scd_ID;
	
	/* 조직 최소 lv */
	var minLv = minLv;
	
	/* 조직 최대 lv */
	var maxLv = maxLv;
	
	this.initDDL = function(){
		
		$("#"+scd_ID+minLv).kendoDropDownList({
	        optionLabel: "조직검색",
	        dataTextField: "SNM",
	        dataValueField: "SCD",
	        height: "auto",
	        cascade: function(e){
	        	if(e.sender.value() == ""){
	    			$("#"+scd_ID+(Number(minLv)+1)).closest(".k-widget").hide();
	        	}else{
	        		$("#"+scd_ID+(Number(minLv)+1)).closest(".k-widget").show();
	        	}
	        },
	        dataSource: {
	        	dataType: "json",
	            contentType: "application/json;charset=UTF-8",
	            transport: {
	            	read: {
	            		url : "/inscom/monthInfo/selectScdListByLevel.ajax",
	            		data : {COM_YM :$("#"+com_ym_ID).val(), SCD_LV : 2}
	            	}
	            },
	            schema: {
	                data: "results" 
	            }
	        }
	    }).data("kendoDropDownList");
		
		for(var i=Number(minLv)+1; i<=maxLv; i++){
			$("#"+scd_ID + i).kendoDropDownList({
		        optionLabel: "전체",
		        dataTextField: "SNM",
		        dataValueField: "SCD",
		        height: "auto",
				cascadeFrom: scd_ID+(i-1),
		        cascadeFromField: "PSCD",
		        cascade: function(e){
		        	var this_id = this.span.context.id;
		        	var start_number = Number(this_id.replace(scd_ID, "")) + 1;
		        	
		        	for(var j=8; j>=start_number; j--){
		        		if($("#"+scd_ID + j).prop("disabled")){
		        			if($("#"+scd_ID + (j-1)).val() != ""){
		        				$("#"+scd_ID + j).closest(".k-widget").show();
		        			}else{
		        				$("#"+scd_ID + j).closest(".k-widget").hide();
		        			}//end else
		        		}else{
		        			$("#"+scd_ID + j).closest(".k-widget").show();
		        		}//end else
		        	}//end for
	
		        },
		        dataSource: {
		        	dataType: "json",
		            contentType: "application/json;charset=UTF-8",
		            transport: {
		                read: {
		                	url : "/inscom/monthInfo/selectScdListByLevel4Payment_cascade.ajax",
		                	data : {
		                		COM_YM :$("#"+com_ym_ID).val()
		                		/* 
								SCD_LV : next,
								PSCD: $('#srch_scd_lv'+lv).val()
								 */
							} 
		            	}
		            },
		            schema: {
		                data: "results" 
		            }
		        }
		    }).data("kendoDropDownList");
			
			$("#"+scd_ID + i).closest(".k-widget").hide();
			
		}//end for
	
	};
	
};

/* 마지막으로 호출한 function 담아두는 함수 */
var lastSrchFunc = function(){
	var wholeFunction = null;
	
	this.setLastSrchFunc = function(srchFunc){
		wholeFunction = srchFunc;
	};
	
	this.getLastSrchFunc = function(){
		return wholeFunction;
	};
};
