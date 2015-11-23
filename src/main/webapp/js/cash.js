$(function() {
	$('#charge_btn').click(function() {
		showCharge();
	})
	$('#charge').blur(function() {
		charge();
	})
	$('#confirm').click(function() {
		if (charge()) {
			cashPay();
		}
	})
	$('#recharge_confirm').click(function() {
		closeAlertWindow('recharge');
		location.reload();
	})
	$('#recharge_cancel').click(function() {
		closeAlertWindow('recharge');
		$('#tip').show();
	})
	$('.back').click(function() {
		location.reload();
	})
})

function cashPay() {
	var charge = $.trim($("#charge").val());
	$.ajax({
		type : "POST",
		url : ctxPath + "publisher/cashPay.do",
		dataType : "json",
		data : {
			"charge" : charge
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					alert(data.msg);
					location.reload();
				} else if (data.code == "1002") {
					showError($('#charge'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}

function showCharge() {
	$('.cash_detail').hide();
	$('.cash_charge').show();
}

var charge_empty = '请输入充值金额';
var charge_error = '充值金额输入有误';
var charge_reg = /^[0-9]\d*\.?\d*$|^0\.\d*[1-9]\d*$/;
function charge() {
	return check($('#charge'), charge_empty, charge_error, charge_reg);
}

function hideMore() {
	$('#spend').show();
	$('#spend_detail').hide();
}