$(document).ready(function () {
  const input_value = $("#password");

  //disable input from typing

  $("#password").keypress(function () {
    return false;
  });

  function handleOnInput(el, maxlength) {
    if (el.value.length > maxlength) {
      el.value
        = el.value.substr(0, maxlength);
    }
  }




  //add password
  $(".calc").click(function () {
    let value = $(this).val();
    field(value);
  });
  function field(value) {
    input_value.val(input_value.val() + value);
  }
  $("#clear").click(function () {
    input_value.val("");
  });
  $("#enter").click(function () {
    alert("Your password " + input_value.val() + " added");
  });
});