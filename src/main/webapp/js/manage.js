$(function(){
	$('#charge_cancel').click(function(){
		closeAlertWindow('charge');
	})
	$('#charge_input').blur(function(){
		charge();
	})
	$('#charge_confirm').click(function(){
		if (charge()) {
			closeAlertWindow('charge');
			updateCharge();
		}
	})
})

var charge_empty='请输入充值金额';
var charge_error='充值金额为不得少于0的数字';
var charge_reg=/^[0-9]\d*\.?\d*$|^0\.\d*[1-9]\d*$/;
function charge(){
	return check($('#charge_input'),charge_empty,charge_error,charge_reg)
}