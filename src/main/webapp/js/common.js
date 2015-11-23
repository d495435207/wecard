$(function() {
	$(window).resize(function() {
		$(".left_scroll").css("height", $(window).height());
	})
	leftMenu();
	$('.input_select').mouseover(function() {
		showOption(this);
	})
	$('.input_select').mouseout(function() {
		hideOption(this);
	})
	$('.page').click(function() {
		$('.page').removeClass('page_active');
		$(this).addClass('page_active');
	})
	for (var i = 0; i < $('.first_menu').length; i++) {
		if ($($('.first_menu')[i]).next().length == 0) {
			$($('.first_menu')[i]).addClass('single_menu');
		}
	}
})

// js获取项目根路径
function getRootPath() {
	// 获取当前网址
	var webPath = window.document.location.href;
	// 获取主机地址之后的目录
	var pathName = window.document.location.pathname;
	var pos = webPath.indexOf(pathName);
	// 获取主机地址
	var localhostPaht = webPath.substring(0, pos);
	// 获取带"/"的项目名
	var pos2 = pathName.substr(1).indexOf('/') + 1;
	var projectName = pathName.substring(0, pos2);
	return (localhostPaht + projectName + "/");
}

// var ctxPath = getRootPath();

// 获取验证码
function getCode(which) {
	var phone = $("#phone").val();
	$.ajax({
		type : "post",
		url : ctxPath + "user/getCode.do",
		dataType : "json",
		data : {
			"phone" : phone
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					alert(data.msg);
					security_getCodeCss(which);
				} else if (data.code == "1001") {
					showError($('#phone'), data.msg);
				} else if (data.code == "1002") {
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

function security_getCodeCss(which) {
	var time = 60;
	var word = '秒后重新获取';
	$(which).addClass('security_btn_disabled').attr('disabled', true);
	var t = setInterval(function() {
		if (time >= 0) {
			var text = time + word;
			$(which).text(text);
			time--;
		} else {
			clearInterval(t);
			$(which).removeClass('security_btn_disabled').attr('disabled',
					false);
			$(which).text('获取验证码');
		}
	}, 1000);
}

function leftMenu() {
	$('.active_menu').next('ul').show();
	$('.left_scroll').css('height', $(window).height());
	$(".first_menu:not('.active_menu')").bind({
		'click' : function() {
			$(".first_menu:not('.single_menu')").removeClass('active_menu');
			$(this).addClass('active_menu');
			if (!$(this).next().is(':visible')) {
				$(this).next('ul').slideDown(200);
			} else {
				$(this).removeClass('active_menu');
				$(this).next('ul').slideUp(200);
			}
		}
	})
	$('.second_menu a').click(function() {
		$(this).addClass('active_second_menu');
	})
}

/* 滑动滑块方法 */
var width = $('#tab_border li:eq(0)').width(); // 设定滑块初始宽度，在这里设为首个li
var padding = parseFloat($('#tab_border li').css('padding-left')) * 2;
var left; // 设定滑块初始位置，在这里设为首个li
function moveBorder(which) {
	left = $('#tab_border li:eq(0)').offset().left;
	var width_now = $(which).width();
	var left_which = $(which).offset().left;
	var left_now = left_which - left;
	$('#slide_border').css({
		'width' : width_now + padding + 'px',
		'transform' : 'translateX(' + left_now + 'px)',
	})
}

function check(which, emptytip, errortip, reg) {
	var value = $(which).val();
	var empty_content = "<p class='error'>" + emptytip + "</p>";
	var error_content = "<p class='error'>" + errortip + "</p>";
	var parent = $(which).parent();
	if (!value) {
		$(parent).find('.error').remove();
		$(parent).css('position', 'relative').append(empty_content);
		return false;
	}
	if (reg) {
		if (!reg.test(value)) {
			$(parent).find('.error').remove();
			$(parent).css('position', 'relative').append(error_content);
			return false;
		} else {
			$(parent).find('.error').remove();
			return true;
		}
	} else {
		$(parent).find('.error').remove();
		return true;
	}
}

function showError(which, errortip) {
	var error_content = "<p class='error'>" + errortip + "</p>";
	var parent = $(which).parent();
	$(parent).find('.error').remove();
	$(parent).css('position', 'relative').append(error_content);
	return true;
}

/* 验证限制条件为大于某位数 */
function checkMin(which, emptytip, errortip, min) {
	var value = $(which).val();
	var empty_content = "<p class='error'>" + emptytip + "</p>";
	var error_content = "<p class='error'>" + errortip + "</p>";
	var parent = $(which).parent();
	if (!value) {
		$(parent).find('.error').remove();
		$(parent).css('position', 'relative').append(empty_content);
		return false;
	}
	if (min) {
		if (value.length < min) {
			$(parent).find('.error').remove();
			$(parent).css('position', 'relative').append(error_content);
			return false;
		} else {
			$(parent).find('.error').remove();
			return true;
		}
	} else {
		$(parent).find('.error').remove();
		return true;
	}
}

/* 验证下拉选框未选择 */
function checkSelect(which, emptytip) {
	var id = $("#" + which);
	var text = $(id).text();
	var option = $(id).next().find('li');
	var parent = $(id).parent().parent();
	var empty_content = "<p class='error'>" + emptytip + "</p>";
	for (var i = 0; i < option.length; i++) {
		if ($(option[i]).text() == text) {
			var value = $(option[i]).val();
			if (!value) {
				$(parent).find('.error').remove();
				$(parent).css('position', 'relative').append(empty_content);
				return false;
			} else {
				$(parent).find('.error').remove();
				return true;
			}
		}
	}
}

/*
 * 验证密码重复录入，需要为新密码后面新增一个id为password_temp的隐藏input
 * 并且在第一次输入密码的blur时间中加入：$('#password_temp').val(this.value);
 */
function checkSame(which, emptytip, errortip) {
	var value = $(which).val();
	var empty_content = "<p class='error'>" + emptytip + "</p>";
	var error_content = "<p class='error'>" + errortip + "</p>";
	var parent = $(which).parent();
	if (!value) {
		$(parent).find('.error').remove();
		$(parent).css('position', 'relative').append(empty_content);
		return false;
	} else if (value != $('#password_temp').val()) {
		$(parent).find('.error').remove();
		$(parent).css('position', 'relative').append(error_content);
		return false;
	} else {
		$(parent).find('.error').remove();
		return true;
	}
}

/* 自定义下拉框 */
function showOption(which) {
	$(which).find('.select_option').show().css('opacity', '1');
	$(which).find('.arrow').css('transform', 'rotate(180deg)');
	return false;
}

function hideOption(which) {
	$(which).find('.select_option').hide().css('opacity', '0');
	$(which).find('.arrow').css('transform', 'rotate(0)');
	return false;
}

function selectAreaOption(which) {
	var text = $(which).text();
	var val = $(which).attr("value");
	if ($(which).parent().prev().attr("id") == "province"
			&& text != $(which).parent().prev().text()) {
		loadArea("city", val);
		$('#city').text("地级市");
		$('#city').val("");
		$('#area').text("县区");
		$('#area').val("");
		$("#area + .select_option").html("");
	} else if ($(which).parent().prev().attr("id") == "city"
			&& text != $(which).parent().prev().text()) {
		loadArea("area", val);
		$('#area').text("县区");
		$('#area').val("");
	}
	$(which).parent().prev().text(text);
	$(which).parent().prev().val(val);
	$(which).parent().hide().css('opacity', '0');
}

function selectOption(which) {
	var text = $(which).text();
	var val = $(which).attr("value");
	$(which).parent().prev().text(text);
	$(which).parent().prev().val(val);
	$(which).parent().hide().css('opacity', '0');
}

/* 弹出窗口 */
function alertWindow(div_id) {
	var div = '<div class="block"></div>';
	var id = '#' + div_id;
	$(id).fadeIn(200);
	$(id).find('input').val('');
	$(id).find('.error').remove();
	$('body').append(div);
}

/* 关闭弹窗 */
function closeAlertWindow(div_id) {
	var id = '#' + div_id;
	$(id).fadeOut(200);
	$('.block').remove();
}

/* iframe弹窗 */
function iframeOpen(src, width, height) {
	var div = '<div class="block"></div>';
	$('body').append(div).append(
			'<iframe class="iframe" src=' + src + '></iframe>');
	$('.iframe').attr('src', src).css({
		"width" : width + 'px',
		"height" : height + 'px',
		"margin-top" : -height / 2 + 'px',
		"margin-left" : -width / 2 + 'px'
	})
	$('.iframe').fadeIn(200);
}

/* 右侧滑出弹窗 */
function slideWindow(id) {
	var coupon_state, coupon_id, coupon_type, m_title, v_title, bg_color, date, coupon_name;
	var coupon_src, stock, coupon_form, tip, limit, share, give, notice, benefit, tel, store_name, add;
	var html;
	$.ajax({
		type : 'POST',
		data : {cardId:id},
		dataType : 'json',
		url : ctxPath+'card/cardDetail.do',
		success : function(data) {
			slideDiv(data.status, data.cardId, data.cardType,
					data.title, data.subTitle, data.color,
					data.coupon_name, data.coupon_src, data.quantity,
					data.codeType, data.description, data.getLimit, data.isShare,
					data.isGiveFriend, data.notice, data.notice, data.tel,
					data.locationIdList, data.add,data.dateType,data.beginTime,data.endTime,data.fixedTerm,data.fixedBeginTerm,data.wCname,data.wClogo);
			$('body').append(html);
			$('.slide_left_show').css('background-color', data.color);
			$('.bg_color').css('background-color', data.color);
			$('.slide_window').animate({
				right : 0
			}, 300);
			$('#slide_close').click(function() {
				closeSlideWindow();
			})
			$(document).mouseup(function(e) {
				var area = $('.slide_window');
				if (!area.is(e.target) && area.has(e.target).length === 0) {
					closeSlideWindow();
				}
			})
			if (data.data.codeType=='1') {
				$('.slide_left').css('background-image','url(../images/slide_bg2.png)')
			} else if (data.data.codeType=='2') {
				$('.slide_left').css('background-image','url(../images/slide_bg3.png)')
			}
		}
	})
	function slideDiv(coupon_state, coupon_id,coupon_type, m_title, v_title,
			bg_color, coupon_name, coupon_src, stock, coupon_form, tip,
			limit, share, give, notice, benefit, tel, store_name, add,dateType,beginTime,endTime,fixedTerm,fixedBeginTerm,wCname,wClogo) {
		var slide_window = '<div class="slide_window">';
		var slide_head = '<div class="slide_head"><span>详情</span><span class="slide_close" id="slide_close">×</span></div>';
		var slide_content = '<div class="slide_content clearfix">';
		var slide_left = '<div class="slide_left">';
		var slide_left_type = '<p class="slide_left_type">' + parseCardType(coupon_type)
				+ '</p>';
		var slide_left_show = '<div class="slide_left_show">';
		var slide_left_img = '<div class="slide_left_img"><img src='
				+ wClogo + '></div>';
		var slide_left_data = '<span>' + parseString(wCname) + '</span><p>' + m_title
				+ '</p><p>' + parseString(v_title) + '</p><p>有效期 ' + parseDate(dateType, fixedBeginTerm, fixedTerm, beginTime, endTime) + '</p>';
		slide_left += slide_left_type + slide_left_show + slide_left_img
				+ slide_left_data + '</div></div>';
		var slide_right = '<div class="slide_right">';
		slide_right += '<div><div class="data_head">卡券状态</div><div class="data_text">'
				+ coupon_state + '</div></div>';
		slide_right += '<div><div class="data_head">卡券ID</div><div class="data_text">'
				+ coupon_id + '</div></div>';
		slide_right += '<p>券面信息</p>';
		slide_right += '<div><div class="data_head">卡券类型</div><div class="data_text">'
				+ parseCardType(coupon_type) + '</div></div>';
		slide_right += '<div><div class="data_head">卡券标题</div><div class="data_text">'
				+ m_title + '</div></div>';
		slide_right += '<div><div class="data_head">副标题</div><div class="data_text">'
				+ parseString(v_title) + '</div></div>';
		slide_right += '<div><div class="data_head">卡券颜色</div><div class="data_text"><div class="bg_color"></div></div></div>';
		slide_right += '<div><div class="data_head">有效期</div><div class="data_text">'
				+ parseDate(dateType, fixedBeginTerm, fixedTerm, beginTime, endTime) + '</div></div>';
		slide_right += '<div><div class="data_head">商家名称</div><div class="data_text">'
				+ parseString(wCname) + '</div></div>';
		slide_right += '<div><div class="data_head">商家Logo</div><div class="data_text"><img src='
				+ parseString(wClogo) + '></div></div>';
		slide_right += '<p class="mt20">投放设置</p>';
		slide_right += '<div><div class="data_head">库存</div><div class="data_text">'
				+ stock + '</div></div>';
		slide_right += '<div><div class="data_head">销券条码</div><div class="data_text">'
				+ coupon_form + '</div></div>';
		slide_right += '<div><div class="data_head">操作提示</div><div class="data_text">'
				+ tip + '</div></div>';
		slide_right += '<div><div class="data_head">领取限制</div><div class="data_text">'
				+ parseGetLimit(limit) + '</div></div>';
		slide_right += '<div><div class="data_head">分享设置</div><div class="data_text">'
				+ parseIsShare(share) + '</div></div>';
		slide_right += '<div><div class="data_head">转赠设置</div><div class="data_text">'
				+ parseIsGive(give) + '</div></div>';
		slide_right += '<p class="mt20">团购券详情</p>';
		slide_right += '<div><div class="data_head">使用须知</div><div class="data_text">'
				+ parseString(notice) + '</div></div>';
		slide_right += '<div><div class="data_head">优惠详情</div><div class="data_text">'
				+ parseString(benefit) + '</div></div>';
		slide_right += '<div><div class="data_head">客服电话</div><div class="data_text">'
				+ parseString(tel) + '</div></div>';
		slide_right += '<p class="mt20">服务信息</p>';
		slide_right += '<div><div class="data_head">适用门店</div><div class="data_text"><table><tbody><tr><th>门店名称</th><th>地址</th></tr><tr><td>'
				+ '潮link-紫花路店'
				+ '</td><td>'
				+ '浙江杭州紫花苑14幢301'
				+ '</td></tr></tbody></table></div></div>';
		slide_right += '</div>';
		slide_content += slide_left + slide_right + '</div>';
		slide_window += slide_head + slide_content + '</div>';

		var block = '</div><div class="block"></div>';
		html = slide_window + block;
	}
}
function parseDate(type,fixBegin,fixTerm,beginTime,endTime){
	if(type ==1){
		if(fixBegin==0){
			return "领取后当天生效"+fixTerm+"天有效";
		}
		else{
			return "领取后"+fixBegin+"天生效"+fixTerm+"天有效";
		}
	}
	if(type==0){
		var bt=formatDate(beginTime);
		var et=formatDate(endTime);
		return bt+" 至 "+et;
	}
	
}
function formatDate(time)   {     
	var now = new Date(time);
    var   year=now.getFullYear();     
    var   month=now.getMonth()+1;     
    var   date=now.getDate();     
    var   hour=now.getHours();     
    var   minute=now.getMinutes();     
    var   second=now.getSeconds();     
   return year+"-"+month+"-"+date;     
} 
//JS转换时间戳
//后台返回null数据，防止前台出现undefined
function parseString(str){
	if(str==""||str=='undefined'||str==null){
		return "";
	}else{
		return str;
	}
}
function parseGetLimit(limit){
	return "每个用户限领"+limit+"张";
}
function parseIsGive(give){
	if(give==1){
		return '用户领券后可转赠其他好友';
	}else{
		return '用户领券后不可转赠其他好友';
	}
}
function parseIsShare(share){
	if(share==1){
		return "用户可以分享领券链接";
	}
	if(share==0){
		return "不可分享给其他好友";
	}else{
		return "不可分享给其他好友";
	}
}
//转换卡券类型
function parseCardType(type){
	if(type==1){
		return '礼品券';
	}
	if(type==2){
		return '代金券';
	}
	if(type==3){
		return '团购券';
	}
	if(type==4){
		return '折扣券';
	}
	if(type==5){
		return '优惠券';
	}
	
}
/* 关闭右侧滑出弹窗 */
function closeSlideWindow() {
	$('.slide_window').animate({
		right : '-740px'
	}, 300);
	$('.block').remove();
	setTimeout("$('.slide_window').remove()", 300);
	$(document).unbind('mouseup');
}

function ChangeParam(name, value) {
	return ChangeParam2(window.location.href, name, value);
}

function ChangeParam2(url, name, value) {
	var newUrl = "";
	var reg = new RegExp("(^|)" + name + "=([^&]*)(|$)");
	var tmp = name + "=" + value;
	if (url.match(reg) != null) {
		newUrl = url.replace(eval(reg), tmp);
	} else {
		if (url.match("[\?]")) {
			newUrl = url + "&" + tmp;
		} else {
			newUrl = url + "?" + tmp;
		}
	}
	return newUrl;
}

/* 翻页方法 */
var Page = 1;
function paging() {
	var url = window.location.search;
	if (url.indexOf("?") != -1) {
		var str = url.substr(1)
		strs = str.split("&");
		for (i = 0; i < strs.length; i++) {
			if ([ strs[i].split("=")[0] ] == 'page')
				Page = unescape(strs[i].split("=")[1]);
		}
	}
	if (MaxPage != "" && MaxPage > 1) {
		document.getElementById("page").innerHTML = Pagehtml()
		document.getElementById("page_btn").onclick = function() {
			var _page = document.getElementById("page_text").value
			var r = /^[0-9]*[1-9][0-9]*$/;
			if (_page != "" && r.test(_page)) {
				if (MaxPage < _page) {
					_page = MaxPage;
				}
				this.href = ChangeParam("page", _page);
			}
		}
		document.getElementById("page_text").onkeyup = function(event) {
			if (event == "undefined") {
				event = window.event;
			}
			if (event.keyCode == 13) {
				document.getElementById("page_btn").click();
				return false;
			}
		}
	}
}

function Pagehtml() {
	var PageStr = "", jj = "";
	Page = parseInt(Page);
	var xPage = Page - 2, dPage = Page + 2
	if (xPage < 1) {
		xPage = 1
		dPage = 5
	}
	if (dPage > MaxPage) {
		dPage = MaxPage
		xPage = (dPage - 4)
	}
	if (xPage < 1) {
		xPage = 1
	}
	if (Page == 1) {
		PageStr += "<a class='prev'><img src='../images/prev.png'></a>"
	} else {
		PageStr += "<a class='prev' href='" + ChangeParam("page", (Page - 1))
				+ "'><img src='../images/prev.png'></a>"
	}
	if (xPage > 1) {
		PageStr += "<a class='page' href='" + ChangeParam("page", 1)
				+ "'>1</a>"
	}
	if (xPage > 2) {
		PageStr += " ..."
	}
	for (var j = xPage; j <= dPage; j++) {
		PageStr += (Page == j) ? " <a class=\"page page_active\">" + j + "</a>"
				: " <a class=\"page\" href='" + ChangeParam("page", j) + "'>"
						+ j + "</a>";
	}
	if (dPage < MaxPage - 1) {
		PageStr += " ..."
	}
	if (dPage < MaxPage) {
		PageStr += " <a class='page' href='" + ChangeParam("page", MaxPage)
				+ "'>" + MaxPage + "</a>"
	}
	if (Page == MaxPage) {
		PageStr += "<a class='next'><img src='../images/next.png'></a>"
	} else {
		PageStr += "<a class='next' href='" + ChangeParam("page", (Page + 1))
				+ "'><img src='../images/next.png'></a>"
	}
	PageStr += '<input id="page_text" type="text" name="page_text"><a id="page_btn" style="display:none" href="javascript:;">GO</a>'
	return PageStr;
}

/* 图标制作 */
function chart(which, name, data) {
	$(which).highcharts({
		chart : {
			type : 'area'
		},
		title : {
			text : '最近7天走势图'
		},
		xAxis : {
			categories : [ '1', '2', '3', '4', '5', '6', '7' ],
			tickmarkPlacement : 'on',
			title : {
				enabled : false
			}
		},
		yAxis : {
			title : {
				enabled : false
			},
		},
		plotOptions : {
			area : {
				stacking : 'normal',
				lineColor : '#9cc6f0',
				lineWidth : 1,
				marker : {
					lineWidth : 1,
					lineColor : '#fff'
				}
			}
		},
		series : [ {
			name : name,
			data : data
		} ]
	});
}

function loadArea(area, pid) {
	$.ajax({
		type : "POST",
		url : ctxPath + "area/" + pid + ".do",
		dataType : "json",
		success : function(data) {
			var html = "";
			for (var i = 0; i < data.length; i++) {
				html = html + "<li value='" + data[i].id + "'>" + data[i].name
						+ "</li>";
			}
			if (area == "province") {
				$("#province + .select_option").html(html);
				$("#province + .select_option li").click(function() {
					selectAreaOption(this);
				})
			} else if (area == "city") {
				$("#city + .select_option").html(html);
				$("#city + .select_option li").click(function() {
					selectAreaOption(this);
				})
			} else if (area == "area") {
				$("#area + .select_option").html(html);
				$("#area + .select_option li").click(function() {
					selectAreaOption(this);
				})
			}
		}
	});
}