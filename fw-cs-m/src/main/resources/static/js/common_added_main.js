/* 메인슬라이드 */
var swiper = new Swiper('.mySwiper', {
  spaceBetween: 30,
  pagination: {
    el: '.swiper-pagination',
    clickable: true,
  },
})

/* 각 로고 슬라이드 */
var swiper = new Swiper('.mySwiper2', {
  pagination: {
    el: '.swiper-pagination',
    type: 'progressbar',
  },
  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },
})