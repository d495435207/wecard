$(function() {
	$('#phone').blur(function() {
		phone();
	})
	$('#password').blur(function() {
		$('#password_temp').val(this.value);
		password();
		if ($('#repassword').val()) {
			repassword();
		}
	})
	$('#repassword').blur(function() {
		repassword();
	})
	$('#name').blur(function() {
		name();
	})
	$('#percent').next().find('li').click(function() {
		percent();
	})
	$('#bank').blur(function() {
		bank();
	})
	$('#beneficiary').blur(function() {
		beneficiary();
	})
	$('#bank_name').blur(function() {
		bank_name();
	})
	$('#bank_account').blur(function() {
		bank_account();
	})
	$('#confirm')
			.click(
					function() {
						if (phone() & password() & repassword() & name()
								& percent() & bank() & beneficiary()
								& bank_name() & bank_account()) {
							createUnderwriter();
						} else
							return false
					});
	$('#cancel').click(function() {
		window.open(ctxPath + "manager/underwriterManage.do", '_self');
	})
})

function createUnderwriter() {
	var phone = $.trim($("#phone").val());
	var password = $.trim($("#password").val());
	var name = $.trim($("#name").val());
	var percent = $.trim($("#percent").val());
	var bank = $.trim($("#bank").val());
	var beneficiary = $.trim($("#beneficiary").val());
	var bank_name = $.trim($("#bank_name").val());
	var bank_account = $.trim($("#bank_account").val());
	var partner = {
		"devId" : phone,
		"devSecret" : $.md5(password),
		"company" : name,
		"shareRate" : percent,
		"bankName" : bank,
		"payee" : beneficiary,
		"openingBankName" : bank_name,
		"bankAccount" : bank_account
	};
	$.ajax({
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		url : ctxPath + "manager/addUnderwriter.do",
		data : JSON.stringify(partner),
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					window.open(ctxPath + "manager/underwriterManage.do",
							'_self');
				} else if (data.code == "1001" || data.code == "1002") {
					showError($('#phone'), data.msg);
				} else if (data.code == "1003") {
					showError($('#name'), data.msg);
				} else if (data.code == "1004" || data.code == "1005") {
					showError($('#password'), data.msg);
				} else if (data.code == "1006") {
					showError($('#percent'), data.msg);
				} else if (data.code == "1007") {
					showError($('#bank'), data.msg);
				} else if (data.code == "1008") {
					showError($('#beneficiary'), data.msg);
				} else if (data.code == "1009") {
					showError($('#bank_name'), data.msg);
				} else if (data.code == "1010") {
					showError($('#bank_account'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}

var phone_empty = '请输入手机号';
var phone_error = '手机号输入有误';
var phone_reg = /^[1]\d{10}$/;
function phone() {
	return check($('#phone'), phone_empty, phone_error, phone_reg);
}

var password_empty = '请输入密码';
var password_error = '密码为6-18位';
var repassword_empty = '请再次输入密码';
var repassword_error = '两次密码输入不一致';
function password() {
	return checkMin($('#password'), password_empty, password_error, 6);
}
function repassword() {
	return checkSame($('#repassword'), repassword_empty, repassword_error);
}

var name_empty = '请输入承销商名称';
function name() {
	return check($('#name'), name_empty);
}

var percent_empty = '请选择分成比例';
function percent() {
	return checkSelect('percent', percent_empty);
}

var bank_empty = '请填写银行名称';
function bank() {
	return check($('#bank'), bank_empty);
}

var beneficiary_empty = '请填写收款方';
function beneficiary() {
	return check($('#beneficiary'), beneficiary_empty);
}

var bank_name_empty = '请填写开户行名称';
function bank_name() {
	return check($('#bank_name'), bank_name_empty);
}

var bank_account_empty = '请填写银行账号';
function bank_account() {
	return check($('#bank_account'), bank_account_empty);
}