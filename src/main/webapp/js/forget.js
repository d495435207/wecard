$(function() {
	arrow();
	$('#prev').click(function() {
		step1();
	})
	$('#next').click(function() {
		step2();
	})
	$('#confirm').click(function() {
		step3();
	})
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
})

// 验证手机号码
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
				if (data.code == "1002") {
					getCode(which);
				} else if (data.code == "1001" || data.code == "1000") {
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

function forget() {
	var phone = $.trim($("#phone").val());
	var security = $.trim($("#security").val());
	$.ajax({
		type : "POST",
		url : ctxPath + "user/forget.do",
		dataType : "json",
		data : {
			"phone" : phone,
			"security" : security
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					$('.step_active:last').next().addClass('step_line_active');
					$('.step_active:last').next().next()
							.addClass('step_active');
					$('#step1,#step3,#bubble1,#bubble3').hide();
					$('#step2,#bubble2').show();
				} else if (data.code == "1001" || data.code == "1002") {
					showError($('#phone'), data.msg);
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

function updatePassword() {
	var password = $.trim($("#password").val());
	$.ajax({
		type : "POST",
		url : ctxPath + "user/forgetPassword.do",
		dataType : "json",
		data : {
			"password" : $.md5(password)
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					$('.step_active:last').next().addClass('step_line_active');
					$('.step_active:last').next().next()
							.addClass('step_active');
					$('#step1,#step2,#bubble1,#bubble2').hide();
					$('#step3,#bubble3').show();
					setInterval(function() {
						count();
					}, 1000);
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

function arrow() {
	var canvas = document.getElementsByTagName("canvas");
	for (var i = 0; i < canvas.length; i++) {
		var arrow = canvas[i].getContext('2d');
		arrow.moveTo(0, 0);
		arrow.lineTo(5, 6);
		arrow.lineTo(10, 0);
		arrow.strokeStyle = '#ccc';
		arrow.stroke();
	}
}

function step1() {
	$('.step_active:last').prev().removeClass('step_line_active');
	$('.step_active:last').removeClass('step_active');
	$('#step2,#step3,#bubble2,#bubble3').hide();
	$('#step1,#bubble1').show();
}

function step2() {
	if (phone() & security()) {
		forget();
	} else {
		return false
	}
}

function step3() {
	if (password() & repassword()) {
		updatePassword();
	} else {
		return false
	}
}

var count_num = 4;
function count() {
	if (count_num == -1) {
		window.open(ctxPath + 'login.do', '_self');
	} else {
		$('#count').text(count_num--);
	}
}

var phone_empty = '请输入手机号';
var phone_error = '手机号输入有误';
var phone_reg = /^[1]\d{10}$/;
var security_empty = '请输入验证码';
function phone() {
	return check($('#phone'), phone_empty, phone_error, phone_reg);
}
function security() {
	return check($('#security'), security_empty);
}

var password_empty = '请输入新密码';
var password_error = '新密码为6-18位';
var repassword_empty = '请再次输入新密码';
var repassword_error = '两次密码输入不一致';
function password() {
	return checkMin($('#password'), password_empty, password_error, 6);
}
function repassword() {
	return checkSame($('#repassword'), repassword_empty, repassword_error);
}