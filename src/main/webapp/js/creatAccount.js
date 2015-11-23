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
	$('#confirm').click(function() {
		if (phone() & password() & repassword()) {
			createAccount();
		} else {
			return false
		}
	})
})

var phone_empty = '请输入手机号';
var phone_error = '手机号输入有误';
var phone_reg = /^[1]\d{10}$/;
var security_empty = '请输入验证码';
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

function createAccount() {
	var phone = $.trim($("#phone").val());
	var password = $.trim($("#password").val());
	$.ajax({
		type : "POST",
		url : ctxPath + "manager/createAccount.do",
		dataType : "json",
		data : {
			"phone" : phone,
			"password" : $.md5(password)
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					alert(data.msg);
					window.location.href = ctxPath
							+ "manager/publisherManage.do";
				} else if (data.code == "1001" || data.code == "1002") {
					showError($('#phone'), data.msg);
				} else if (data.code == "1003" || data.code == "1004") {
					showError($('#password'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}