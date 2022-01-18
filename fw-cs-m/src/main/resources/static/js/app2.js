$(function () {
	$(".calc").click(function () {

		var value = $(this).val();
    document.getElementsByClassName("password_wrap").innerText = value;



		if (value !== "<") {
			$(".numberinput").each(function () {
				var a = $(this).text();
				if (!a) {
					$(this).text(value);
					$(this).addClass("nocircle");
					return false;
				}
			});
		} else {
			$($(".numberinput").get().reverse()).each(function () {
				var a = $(this).text();
				if (a) {
					$(this).text("");
					$(this).removeClass("nocircle");
					return false;
				}
			});
		}
	});
});