$(function(){
	checkMedals();
	$('.more').click(function(){
		showMorePage(this);
	})
})
function paging(page,which,max_page){
	var id = $(which).parent().parent().find('.paging').attr('id');
	var page_div=$('#'+id);

	if(max_page != "" && max_page > 1){
		$(page_div).html(pagehtml(page,max_page)).attr('maxpage',max_page);
	}
	$('.page').click(function(){
		pageClick(this);
	})
	$('.prev').click(function(){
		prevClick(this);
	})
	$('.next').click(function(){
		nextClick(this);
	})
	$('.page_text').keyup(function(event){
		if (event == "undefined") {
			event = window.event;
		}
		if (event.keyCode == 13) {
			jump(this);
		}
	})
}

function pagehtml(page,max_page){
	var PageStr = "",jj = "";
	page=parseInt(page);
	var xPage = page - 2,dPage = page + 2;
	if(xPage < 1){
		xPage = 1
		dPage = 5
	}
	if(dPage > max_page){
		dPage = max_page
		xPage = (dPage - 4)
	}
	if(xPage < 1){
		xPage = 1
	}
	PageStr += "<a class='prev'><img src='images/prev.png'></a>";
	if(xPage > 1){
		PageStr += "<a class='page'>1</a>"
	}
	if(xPage > 2){
		PageStr += " ..."
	}
	for(var j = xPage;j <= dPage;j++) {
		PageStr += (page == j) ? " <a class=\"page page_active\">" + j + "</a>" : " <a class=\"page\">" + j + "</a>";
	}
	if(dPage < max_page - 1){
		PageStr += " ..."
	}
	if(dPage < max_page){
		PageStr += " <a class='page'>" + max_page + "</a>"
	}
	PageStr += "<a class='next'><img src='images/next.png'></a>";
	PageStr += '<input class="page_text" type="text" name="page_text">'
	return PageStr;
}
function prevClick(which){
	var value=parseInt($(which).siblings('.page_active').text());
	var page_a=$(which).siblings('.page');
	for (var i = 0; i < page_a.length; i++) {
		var text=parseInt($(page_a[i]).text());
		if (text==value-1) {
			if (value-1!=1) {
				$(which).parent().siblings('.medals').hide();
			} else {$(which).parent().siblings('.medals').hide()}
			$(page_a[i]).click();
			break;
		}
	}
}

function nextClick(which){
	var value=parseInt($(which).siblings('.page_active').text());
	var page_a=$(which).siblings('.page');
	for (var i = 0; i < page_a.length; i++) {
		var text=parseInt($(page_a[i]).text());
		if (text==value+1) {
			if (value+1!=1) {
				$(which).parent().siblings('.medals').hide();
			} else {$(which).parent().siblings('.medals').hide()}
			$(page_a[i]).click();
			break;
		}
	}
}

function jump(which){
	var value=parseInt($(which).val());
	var max=parseInt($(which).parent().attr('maxpage'));
	var r = /^[0-9]*[1-9][0-9]*$/;
	var id = $(which).parent().parent().find('.paging').attr('id');
	var page_div=$('#'+id);
	if(value != "" && r.test(value)){
		if (value>max) {
			value=max
		}
		$(page_div).html(pagehtml(value,max));
		var page_button=$(page_div).find('.page');
		$('.page').click(function(){
			pageClick(this);
		})
		$('.prev').click(function(){
			prevClick(this);
		})
		$('.next').click(function(){
			nextClick(this);
		})
		$('.page_text').keyup(function(event){
			if (event == "undefined") {
				event = window.event;
			}
			if (event.keyCode == 13) {
				jump(this);
			}
		})
		for (var i = 0; i <= max ; i++) {
			var text=parseInt($(page_button[i]).text());
			if (text==value) {
			if (value!=1) {
				$(which).parent().siblings('.medals').hide();
			} else {$(which).parent().siblings('.medals').hide()}
				pageClick($(page_button[i]));
				break;
			}
		}
	}
}

function pageClick(which){
	var coupon=$(which).parent().siblings('#coupon');
	var value=$(which).text();
	if (value!=1) {
		$(which).parent().siblings('.medals').hide();
	} else {$(which).parent().siblings('.medals').show()}
	var index=$(which).parent().parent().attr('item-num');
	if (!index) {return false}
	var id = $(which).parent().parent().find('.paging').attr('id');
	var page_div=$('#'+id);
	max=parseInt($(which).parent().attr('maxpage'));
	$(page_div).html(pagehtml(value,max));
	$(page_div).find('.page').click(function(){
		pageClick(this);
	})
	$(page_div).find('.prev').click(function(){
		prevClick(this);
	})
	$(page_div).find('.next').click(function(){
		nextClick(this);
	})
	$(page_div).find('.page_text').keyup(function(event){
		if (event == "undefined") {
			event = window.event;
		}
		if (event.keyCode == 13) {
			jump(this);
		}
	})
	$.ajax({
		type: 'GET',
		data: {},
		dataType: 'json',
		url: '/json/item'+index+'_page'+value+'.json',
		success: function(data) {
			var html="";
			for (var i = 0; i < 9; i++) {
				html+=couponDetail(data[i][0],data[i][1],data[i][2],data[i][3],data[i][4],data[i][5],data[i][6]);
			}
			$(coupon).html(html);
		}
	})
	max_page="";
	return false;
}

function checkMedals(){
	var item=$('.item');
	for (var i = 0; i < item.length; i++) {
		var num=$(item[i]).find('.mt30').children('.coupon_show').length;
		if (num==0) {
			$(item[i]).find('.medals').remove();
		} else if (num==1) {
			$(item[i]).find('.medals img:eq(1),.medals img:eq(2)').remove();
		} else if (num==2) {
			$(item[i]).find('.medals img:eq(2)').remove();
		}
		if (num<4) {
			$(item[i]).removeClass('hide_coupon');
		}
	}
}

function showMore(which,max_page){
	if (!$(which).parent().siblings('.paging').find('.page').length) {
		paging(1,which,max_page)
	}
	var stat=$(which).attr('data-stat');
	if (stat=='1') {
		$(which).attr('data-stat',2);
		$(which).text('收起');
		$(which).parent().parent().removeClass('hide_coupon');
	} else {
		$(which).attr('data-stat',1);
		$(which).text('全部');
		$(which).parent().parent().addClass('hide_coupon');
	}
}

/*点击全部展开卡券，包括读取max_page，这里为方便测试所以用GET*/
function showMorePage(which){
	var index=$(which).parent().parent().attr('item-num');
	var eq=parseInt(index)-1;
	var paging=$(which).parent().siblings('.paging');
	$.ajax({
		type: 'GET',
		data: {},
		dataType: 'json',
		url: '/json/item'+index+'.json',
		success: function(data) {
			showMore($('.more:eq('+eq+')'),data.max_page);
			$(paging).attr('maxpage',data.max_page);
		}
	})
}

function couponDetail(bgcolor,src,name,title,type,data,price){
	var coupon_logo='<div class="coupon_logo"><img src="'+src+'"></div>';
	var coupon_name='<p>'+name+'</p>';
	var coupon_title='<p class="coupon_title">'+title+'</p>';
	var coupon_detail='<div class="coupon_detail">'+coupon_name+coupon_title+'</div>';
	var coupon_content='<div class="coupon_content">'+coupon_logo+coupon_detail+'</div>';
	var coupon_num='<span>'+type+'：'+data+'</span>';
	var coupon_price='<span class="fr">单价：￥'+price+'</span>';
	var coupon_data='<div class="coupon_data">'+coupon_num+coupon_price+'</div>';
	var coupon_show='<div class="coupon_show" style="background-color:'+bgcolor+'">'+coupon_content+coupon_data+'</div>';
	return coupon_show;
}