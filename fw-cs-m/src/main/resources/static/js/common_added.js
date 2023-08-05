//<![CDATA[



/**
 * 공통 함수 모음
 * @namespace
 */
 var common = {
  /**
 * 모달 팝업
 * @param {jQuery|HTMLElement} $btnLayer data-target을 담고 있는 요소
 */
  modalPopup: function($btnLayer) {
      console.log('modalPopup open');
      var $modalButton = $('.btnLayer');
      var $mask = $('.layerDim');
      var modalId = $btnLayer.data('target');
      var $layerContainer = $(modalId).closest('.layerContainer');

      $('.layerPopup').removeClass('active');
      $mask.addClass('active');
      $(modalId).addClass('active');
      $(modalId).closest('.layerContainer').addClass('active');
      $(modalId).fadeIn();

      // $('html').css('overflow-y', 'hidden');
      
      // 팝업위치 수정
      common.modalPopupSize($(modalId));
      $(window).resize(function() {
          common.modalPopupSize($(modalId));
      })

      $(document).off('click.modalPopupClose').on('click.modalPopupClose', '.layerClose', function(e) {
          common.modalPopupClose($(this));
          e.preventDefault();
      });

  },
  modalPopup2: function($btnLayer) {
      console.log('modalPopup2 open');
      var $modalButton = $('.btnLayer2');
      var modalId = $btnLayer.data('target');
      var $layerContainer = $(modalId).closest('.layerContainer');

      $('.layerPopup').removeClass('active');
      // $mask.addClass('active');
      $(modalId).addClass('active');
      $(modalId).closest('.layerContainer').addClass('active');
      $(modalId).fadeIn();

      // $('html').css('overflow-y', 'hidden');
      
      // 팝업위치 수정
      common.modalPopupSize($(modalId));
      $(window).resize(function() {
          common.modalPopupSize($(modalId));
      })

      $(document).off('click.modalPopupClose').on('click.modalPopupClose', '.layerClose', function(e) {
          common.modalPopupClose($(this));
          e.preventDefault();
      });

  },

  /**
 * 모달 팝업 닫기
 * @param {jQuery|HTMLElement} $close 닫을 레이어의 내부에 있는 엘리먼트 아무거나..?
 */
  modalPopupClose: function($close) {
      console.log('modalPopup close');
      // 2017.11.27 #45275
      var $layerPopup = $close.closest('.layerPopup'), 
          $container = $layerPopup.closest('.layerContainer');

      $layerPopup.removeClass('active');

      // 2017.11.27 layerContainer가 여러개일 때 해당하는 Container내부의 layerpop만 계산하도록 수정.
      /*
      if ($container.find('.layerPopup.active').size() <= 0) {
          $('.layerDim').removeClass('active');
          $close.closest('.layerContainer').removeClass('active');
          $('html').css('overflow-y', 'auto');
      } else if ($(".layerContainer.detail").hasClass("active")) {
          $('html').css('overflow-y', 'auto');
      } else {
          $('html').css('overflow-y', 'auto');
      }
      */
  },

  /**
 * 팝업 호출
 * @param {string} id 띄울 팝업 id 값 (#은 빼고 사용)
 * @example
 * // #layer 요소 팝업 호출
 * common.autoPopup('layer');
 */
  autoPopup: function(id) {
      var popup = $('#' + id)
        , $mask = $('.layerDim')
        , $modalClosed = $('.layerPopup').find('.layerClose');

      $('.layerPopup').removeClass('active');
      // $mask.addClass('active');
      popup.addClass('active');
      popup.fadeIn();
      popup.closest('.layerContainer').addClass('active');
      popup.find("a:first-child").focus();
      //$('html').css('overflow-y', 'hidden');

      // 팝업위치 수정
      if (popup.find('img').length > 0) {
          var $img = $('img');
          $img.load(function() {
              common.modalPopupSize(popup);
          })
      } else {
          common.modalPopupSize(popup);
      }

      $(window).resize(function() {
          common.modalPopupSize(popup);
      })
      
      $modalClosed.on('click', function() {
          $(this).closest('.layerPopup').removeClass('active');
          $(this).closest('.layerContainer').removeClass('active');
          // $mask.removeClass('active');
          //$('html').css('overflow-y', 'auto');
      });

  },

  /**
 * 모달 팝업 위치 지정
 * @param {jQuery|HTMLElement} objt 적용할 요소
 */
  modalPopupSize: function(objt) {

      var $winWidth = $(window).width()
        , $winHeight = $(window).height()
        , $objt = objt
        , $objWidth = $objt.outerWidth()
        , $objHeight = $objt.outerHeight();

      if ($objHeight >= $winHeight) {
          $objt.css({
              // 'left': ($winWidth / 2) - ($objWidth / 2),
              'top': 0
          });
      } else {
          $objt.css({
              // 'left': ($winWidth / 2) - ($objWidth / 2),
              'top': ($winHeight / 2) - ($objHeight / 2)
          });
      }
  },

  /**
 * 윈도우 팝업 (스크롤바 있음)
 */
  windowPopup: function(name, url, windowW, windowH) {

      //onclick시 입력한 높이값이 화면보다 클경우 팝업 잘림현상 때문에 추가.2016-12-19.maddie
      //if(windowH >= $(window).height()) windowH = $(window).outerHeight();

      var settings = 'toolbar=0, status=no, menubar=0, scrollbars=yes, width=' + windowW + ', height=' + windowH + '';
      return window.open(url, name, settings);
  },

  /**
 * 윈도우 팝업 (scrollbar 없음)
 */
  windowPopup2: function(name, url, windowW, windowH) {

      var settings = 'toolbar=0, status=no, menubar=0, scrollbars=no, width=' + windowW + ', height=' + windowH + '';
      return window.open(url, name, settings);
  },

  /**
 * ???
 */
  windowPopStart: function() {
      $('.windowpop').filter(function() {
          $('.windowpop').addClass('container');
      });
  }
  
}

$(document).ready(function() {

  //LayerPopup
  $('.btnLayer').on('click', function(e) {
      common.modalPopup($(this));
      e.preventDefault();
  });
  $('.btnLayer2').on('click', function(e) {
      common.modalPopup2($(this));
      e.preventDefault();
  });
});





/****************************  체크박스 전체선택 *******************************/
//console.clear()

// 최상단 체크박스 클릭 시 하단 체크박스 활성, 비활성화 (동기화안됨)

// $(document).ready(function(){
//     //최상단 체크박스 클릭
//     $("#checkbox1").click(function(){
//         //클릭되었으면
//         if($("#checkbox1").prop("checked")){
//             //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
//             $("input[name=checkOne]").prop("checked",true);
//             //클릭이 안되있으면
//         }else{
//             //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
//             $("input[name=checkOne]").prop("checked",false);
//         }
//     })
// })

// 모두 => 동기화
function allCheckFunc(obj) {
  $('[name=checkOne]').prop('checked', $(obj).prop('checked'))
}

// 체크박스 체크시 전체선택 체크 여부
function oneCheckFunc(obj) {
  var allObj = $('[name=checkAll]')
  var objName = $(obj).attr('name')

  if ($(obj).prop('checked')) {
    checkBoxLength = $('[name=' + objName + ']').length
    checkedLength = $('[name=' + objName + ']:checked').length

    // console.log("checkBoxLength : " + checkBoxLength + ", checkedLength : " + checkedLength);
    // 확인용

    if (checkBoxLength == checkedLength) {
      allObj.prop('checked', true)
    } else {
      allObj.prop('checked', false)
    }
  } else {
    allObj.prop('checked', false)
  }
}

/* 메뉴 */
$(function () {
  // function slideMenu() {
  //   var activeState = $('#menu-container .menu-list').hasClass('active')
  //   $('#menu-container .menu-list').animate({
  //       left: activeState ? '0%' : '-100%'
  //     },
  //     400,
  //   )
  // }

  $('#menu-wrapper').click(function (event) {
    event.stopPropagation()
    $('#hamburger-menu').toggleClass('open')
    $('#menu-container .menu-list').toggleClass('active')
    $(".dim").toggleClass("active")
    

    // slideMenu()


    $('body').toggleClass('overflow-hidden')
    $("html, body").toggleClass("not_scroll")

    // if($('.dim').click(function () {
    //   $('#menu-container .menu-list').css('left', '-100%')
    // })
  })


  

  $('.dim').click(function() {
    // $('#menu-container .menu-list').css('left', '-100%')
    $(".dim").removeClass("active")
    $('#hamburger-menu').removeClass('open')
    $('#menu-container .menu-list').removeClass('active')
  })
  
  

  /* 2depth
  $('.menu-list')
    .find('.accordion-toggle')
    .click(function () {
      $(this).next().toggleClass('open').slideToggle('fast')
      $(this).toggleClass('active-tab').find('.menu-link').toggleClass('active')

      $('.menu-list .accordion-content')
        .not($(this).next())
        .slideUp('fast')
        .removeClass('open')
      $('.menu-list .accordion-toggle')
        .not(jQuery(this))
        .removeClass('active-tab')
        .find('.menu-link')
        .removeClass('active')
    })
    */
})
/* 메뉴 끝 */

/* 체크박스 동의비동의 */
$(function () {
  $('[name=checkAll]').change(function () {
    allCheckFunc(this)
  })

  $('[name=checkOne]').change(function () {
    oneCheckFunc($(this))
  })

  /* 클릭시 비밀번호 보이기 */
  /*
  $(function () {
    $('.b_point').click(function () {
      $('.pw_view').show()

      // goodsBtn을 클릭하면 goodsDiv를 보여줘라
    })
  })
   */
})


/* 공지사항 더보기 누르면 리스트 */
$(function(){
  $(".notice_list ul li").slice(0, 5).show(); // select the first ten
  $(".b_notice_more").click(function(e){ // click event for load more
      e.preventDefault();
      $(".notice_list ul li:hidden").slice(0, 3).show(); // select next 10 hidden divs and show them
      if($(".notice_list ul li:hidden").length == 0){ // check if any hidden divs still exist
          $('.end_list').show();
          $('.b_notice_more').hide();

      }
      else {
        $('.end_list').show();
      }
  });
});


$(function(){
  $(".message_wrap ul li").slice(0, 3).show(); // select the first ten
  $(".b_notice_more").click(function(e){ // click event for load more
      e.preventDefault();
      $(".message_wrap ul li:hidden").slice(0, 3).show(); // select next 10 hidden divs and show them
      if($(".message_wrap ul li:hidden").length == 0){ // check if any hidden divs still exist
          $('.end_list').show();
          $('.b_notice_more').hide();

      }
      else {
        $('.end_list').show();
      }
  });

});

// function scroll_start() {
  

//   if($('div').hasClass('wrapper_lock')) {

//     var offset = $('.partner').offset();
  
//     $('.wrapper_lock.partner').animate({scrollTop:offset.top + 500}, 400)

//     console.log(offset)
//   }
// }


