$(function() {
	if ($('#count').length) {
		setInterval(function() {
			count();
		}, 1000);
	}
	$('#phone').blur(function() {
		phone();
	})
	$('#security').blur(function() {
		security();
	})
	$('#security_btn').click(function() {
		if (phone()) {
			security_word(this);
		}
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
		if (phone() & security() & password() & repassword()) {
			register();
		} else {
			return false
		}
	})
})

function register() {
	var phone = $.trim($("#phone").val());
	var password = $.trim($("#password").val());
	var security = $.trim($("#security").val());
	$.ajax({
		type : "POST",
		url : ctxPath+"user/register.do",
		dataType : "json",
		data : {
			"phone" : phone,
			"password" : $.md5(password),
			"security" : security
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					window.location.href = ctxPath+"registerSuccess.do";
				} else if (data.code == "1001" || data.code == "1002") {
					showError($('#phone'), data.msg);
				} else if (data.code == "1003" || data.code == "1004") {
					showError($('#password'), data.msg);
				} else if (data.code == "1005" || data.code == "1006"
						|| data.code == "1007") {
					showError($('#security'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}

//验证手机号码
function security_word(which) {
	var phone = $("#phone").val();
	$.ajax({
		type : "post",
		url : ctxPath + "user/isRegist.do",
		dataType : "json",
		data : {
			"phone" : phone
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					getCode(which);
				} else if (data.code == "1001" || data.code == "1002") {
					showError($('#phone'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}

var count_num = 4;
function count() {
	if (count_num == -1) {
		window.open(ctxPath+'login.do', '_self');
	} else {
		$('#count').text(count_num--);
	}
}

var phone_empty = '请输入手机号';
var phone_error = '手机号输入有误';
var phone_reg = /^[1][3-9]+\d{9}$/;
var security_empty = '请输入验证码';
function phone() {
	return check($('#phone'), phone_empty, phone_error, phone_reg);
}
function security() {
	return check($('#security'), security_empty);
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