$(document).ready(function(){
	//header nav
	var height = $(window).height();
	if(height <= 836 ){
		$('header .bottom_wrap').css({'position':'unset'});
	}else if(height > 836 ){
		$('header .bottom_wrap').css({'position':'absolute'});
	}
	
	$('header .menu_wrap').click(function(){
		posY = $(window).scrollTop();
		$('html, body').addClass('not_scroll');
		$('.nav').show();
		$('.nav_inner').animate({'left':'0'},500,function(){
			$('.nav .close_btn').show();
		});
		$('section').css('top',-posY);
		
		//회원프로필사진 사이즈
		var imgWidth = $('header .img_box img').width();
		var imgHeight = $('header .img_box img').height();
		if(imgWidth > imgHeight){
			$('header .img_box img').css({'height':'100%'});
		}else if(imgWidth < imgHeight){
			$('header .img_box img').css({'width':'100%'});
		}else if(imgWidth = imgHeight){
			$('header .img_box img').css({'width':'100%'});
		}
	});

	$('.nav .close_btn').click(function(){
		$('html, body').removeClass('not_scroll');
		$('.nav .close_btn').hide();
		$('.nav_inner').animate({'left':'-100%'},500,function(){
			$('.nav').hide();
		});
		posY = $(window).scrollTop(posY);
	});

	//팝업
	$('.pop_show').click(function(){
		$('.pop_wrap').show();
	});
	$('.pop_close').click(function(){
		$('.pop_wrap').hide();
	});

});

