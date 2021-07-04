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

function removeComma(str) {
	return  str.replace(/,/gi, "");
};

function changeName(str){
	var asterik = '*';
	if (str.length > 1) {
		for (var i = 0; i<(str.length - 1); i++){
			asterik += '*';
		}
	}
	
	return str.substring(0,1) + asterik;
}

function today(seperator){
	var date = new Date(); 
	var year = date.getFullYear(); 
	var month = new String(date.getMonth()+1); 
	var day = new String(date.getDate()); 
	var sep = '';
	// 한자리수일 경우 0을 채워준다. 
	if(month.length == 1){ 
	  month = "0" + month; 
	} 
	if(day.length == 1){ 
	  day = "0" + day; 
	} 
	if (seperator == '' || seperator == undefined || seperator == null) {
		sep = ''
	} else {
		sep = seperator;
	}
	return year + sep + month + sep + day;
};

function firstDayOfMonth(seperator){
	var date = new Date(); 
	var year = date.getFullYear(); 
	var month = new String(date.getMonth()+1); 
	var day = new String(date.getDate()); 
	var sep = '';
	// 한자리수일 경우 0을 채워준다. 
	if(month.length == 1){ 
	  month = "0" + month; 
	} 
	if(day.length == 1){ 
	  day = "0" + day; 
	} 
	if (seperator == '' || seperator == undefined || seperator == null) {
		sep = ''
	} else {
		sep = seperator;
	}
	return year + sep + month + sep + "01";
};

