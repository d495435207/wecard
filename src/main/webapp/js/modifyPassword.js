$(function() {
	$('#old_password').blur(function() {
		old_password();
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
	$('#confirmed').click(function() {
		if (old_password() & password() & repassword()) {
			updatePassword();
		} else {
			return false
		}
	})
})

function updatePassword() {
	var password = $.trim($("#password").val());
	var oldPassword = $.trim($("#old_password").val());
	$.ajax({
		type : "POST",
		url : ctxPath + "user/modifyPassword.do",
		dataType : "json",
		data : {
			"password" : $.md5(password),
			"oldPassword" : $.md5(oldPassword)
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					alert(data.msg);
					window.location.href = ctxPath + 'login.do';
				} else if (data.code == "1003" || data.code == "1004") {
					showError($('#password'), data.msg);
				} else if (data.code == "1013" || data.code == "1014"
						|| data.code == "1015") {
					showError($('#old_password'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}

var old_password_empty = '请输入原密码';
var old_password_error = '密码为6-18位';
function old_password() {
	return checkMin($('#old_password'), old_password_empty, old_password_error,
			6);
}

var password_empty = '请输入新密码';
var password_error = '密码为6-18位';
var repassword_empty = '请再次输入新密码';
var repassword_error = '两次密码输入不一致';
function password() {
	return checkMin($('#password'), password_empty, password_error, 6);
}
function repassword() {
	return checkSame($('#repassword'), repassword_empty, repassword_error);
}