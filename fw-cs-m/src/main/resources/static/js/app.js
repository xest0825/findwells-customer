$(document).ready(function () {
  const input_value = $("#password");

  //disable input from typing

  $("#password").keypress(function () {
    return false;
  })


  function handleOnInput(el, maxlength) {
    if (el.value.length > maxlength) {
      el.value
        = el.value.substr(0, maxlength);
    }
  }




  //add password
  /*
  $(".calc").click(function () {
    let value = $(this).val();
    console.log('' + value);
    field(value);
  });
  function field(value) {
    input_value.val(input_value.val() + value);
    if (input_value.val().length == 4 ){
		  location.href = '/m/PM01'
	  }
  }
   */
  
  
  $("#clear").click(function () {
	  console.log('clear');
	  input_value.val("");
  });
  
  $("#delete").click(function () {
	  console.log('delete');
	  //input_value.val("");
	  var val = input_value.val();
	  console.log('val : ' + val);
	  console.log('val.length : ' + val.length);
	  console.log('val -1 char : ' +  val.substr(0, val.length-1));
	  
	  input_value.val(val.substr(0, val.length-1));
  });
  
  $("#enter").click(function () {
    alert("Your password " + input_value.val() + " added");
  });
});