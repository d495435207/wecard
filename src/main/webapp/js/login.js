$(function() {
	$('#phone').blur(function() {
		check(this, phone_empty, phone_error, phone_reg);
	})
	$('#password').blur(function() {
		check(this, password_empty);
	})
	$('#login').click(function() {
		var phone = check($('#phone'), phone_empty, phone_error, phone_reg);
		var password = check($('#password'), password_empty);
		if (phone & password) {
			login();
		}
		return false;
	})
})

function login() {
	var phone = $.trim($("#phone").val());
	var password = $.trim($("#password").val());
	$.ajax({
		type : "POST",
		url : ctxPath+"user/login.do",
		dataType : "json",
		data : {
			"phone" : phone,
			"password" : $.md5(password)
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					window.location.href = ctxPath+data.url;
				} else if (data.code == "1001" || data.code == "1002") {
					showError($('#phone'), data.msg);
				} else if (data.code == "1003" || data.code == "1004"|| data.code == "1005") {
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

var phone_empty = '请输入手机号';
var phone_error = '手机号输入有误';
var phone_reg = /^[1]\d{10}$/;
var password_empty = '请输入密码';