$(function() {
	$('#tabspan1').click(function() {
		showTab1();
	})

	$('#tabspan2').click(function() {
		showTab2();
	})

	$('#people').blur(function() {
		people();
	})

	$('#name').blur(function() {
		name();
	})

	$('#email').blur(function() {
		email();
	})

	$('#address').blur(function() {
		address();
	})

	$('#edit').click(function() {
		edit();
	})

	$('#cancel').click(function() {
		location.reload();
	})

	$('#confirm').click(
			function() {
				if (people() && name() && email() && address()
						&& testArea("province") && testArea("city")
						&& testArea("area")) {
					updatePartner();
				}
			})
})

function updatePartner() {
	var people = $.trim($("#people").val());
	var name = $.trim($("#name").val());
	var email = $.trim($("#email").val());
	var province = $.trim($("#province").val());
	var city = $.trim($("#city").val());
	var area = $.trim($("#area").val());
	var address = $.trim($("#address").val());
	var partner = {
		"contacts" : people,
		"company" : name,
		"mail" : email,
		"province" : province,
		"city" : city,
		"district" : area,
		"address" : address
	};
	$.ajax({
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		url : ctxPath + "publisher/partner/modify.do",
		data : JSON.stringify(partner),
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					location.reload();
				} else if (data.code == "1001") {
					showError($('#people'), data.msg);
				} else if (data.code == "1002") {
					showError($('#name'), data.msg);
				} else if (data.code == "1003") {
					showError($('#address'), data.msg);
				} else if (data.code == "1004") {
					showError($('#email'), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}
	});
}

function edit() {
	$('#edit_button,#add_span').hide();
	$('#op_button').removeClass('hide');
	$('#add').css('opacity', 1);
	$('.long_input').css('border-color', '#ccc').attr('disabled', false);
}

var people_empty = '请输入联系人';
function people() {
	return check($('#people'), people_empty);
}

var name_empty = '请输入商家名称';
function name() {
	return check($('#name'), name_empty);
}

var email_empty = '请输入电子邮箱';
var email_error = '电子邮箱输入有误';
var email_reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
function email() {
	return check($('#email'), email_empty, email_error, email_reg);
}

var address_empty = '请输入详细联系地址';
function address() {
	return check($('#address'), address_empty);
}

function testArea(area) {
	var val;
	var option;
	var empty_content;
	if (area == "province") {
		val = $('#province').val();
		option = $('#province + .select_option li');
		empty_content = "<p class='error'>请选择省份</p>";
	} else if (area == "city") {
		val = $('#city').val();
		option = $('#city + .select_option li');
		empty_content = "<p class='error'>请选择地级市</p>";
	} else if (area == "area") {
		val = $('#area').val();
		option = $('#area + .select_option li');
		empty_content = "<p class='error'>请选择县区</p>";
	}
	if (val == "") {
		$('#add').append(empty_content);
		return false;
	} else {
		$('#add > .error').remove();
		return true;
	}
}

function showTab1() {
	$('#slidespan').css('transform', 'translateX(0)');
	$('#tab2').hide();
	$('#tab1').show();
}

function showTab2() {
	var state = $('#wx_state').val(); /* 微信公众号是否授权，0为未知，1为已授权，2为未授权 */
	$('#slidespan').css('transform', 'translateX(138px)');
	$('#tab1').hide();
	$('#tab2').show();
	if (state == 1) {
		$('#wx_state2').show();
		$('#wx_state1').hide();
	} else {
		$('#wx_state1').show();
		$('#wx_state2').hide();
	}
}