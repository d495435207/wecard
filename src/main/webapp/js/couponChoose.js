$(function() {
	$('#prev').click(function() {
		prev();
	})
	$('#price_input').blur(function() {
		price();
	})
	$('#confirm').click(function() {
		$(this).attr('disabled', true);
		var test=$.trim($("#price_input").val());
		if (price()) {
			updateCostPut();
		} else {
			$(this).attr('disabled', false)
		}
	})
})

var price_empty = '请输入单价';
var price_error = '单价为不得少于0的数字';
var price_reg = /^[0-9]\d*\.?\d*$|^0\.\d*[1-9]\d*$/;
function price() {
	return check($('#price_input'), price_empty, price_error, price_reg)
}

function prev() {
	$('.tab1').show();
	$('.tab2').hide();
	$('.step').css('background-color', '');
	$('#step2 span').css('color', '#646464');
}