$(function() {
	$('#stock_input').blur(function() {
		stock();
	})
	$('#stock_confirm').click(function() {
		if (stock()) {
			closeAlertWindow('stock');
			updateStock();
		}
	})
	$('#stock_cancel').click(function() {
		closeAlertWindow('stock');
	})
	$('#add_coupon').click(function(){
		
	})
	$('#wx_coupon').click(function() {
		var isAuth=$('#isAuth').val();
		if(isAuth==0){
			alertWindow('warrant');
		}
		if(isAuth==1){
			$.ajax({
				type : "POST",
				url : ctxPath+"card/syncCard.do",
				dataType : "json",
				data : {
				},
				success : function(data) {
					if (data.res == "success") {
						alert(data.msg);
						window.location.href = ctxPath+data.url;
					} else {
						alert(data.msg);
					}
				}
			});
		}
	})
	$('#warrant_confirm,#warrant_cancel').click(function() {
		closeAlertWindow('warrant');
		window.location.href="/wechatOAuth.html";
	})
	$('#delete_cancel').click(function() {
		closeAlertWindow('delete');
	})
	$('#delete_confirm').click(function() {
		closeAlertWindow('delete');
		cardDelete();
	})
})

var stock_empty = '请输入库存数量';
var stock_error = '库存数量为不得少于0的整数';
var stock_reg = /^[0-9]\d*$/;
function stock() {
	return check($('#stock_input'), stock_empty, stock_error, stock_reg)
}