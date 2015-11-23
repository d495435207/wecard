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
	$('#price_input').blur(function() {
		price();
	})
	$('#price_confirm').click(function() {
		if (price()) {
			closeAlertWindow('price');
			updateCost();
		}
	})
	$('#price_cancel').click(function() {
		closeAlertWindow('price');
	})
	$('#down_cancel').click(function() {
		closeAlertWindow('down');
	})
	$('#down_confirm').click(function() {
		closeAlertWindow('down');
		cardDown();
	})
})

var stock_empty = '请输入库存数量';
var stock_error = '库存数量为不得少于0的整数';
var stock_reg = /^[0-9]\d*$/;
function stock() {
	return check($('#stock_input'), stock_empty, stock_error, stock_reg)
}

var price_empty = '请输入单价';
var price_error = '单价为不得少于0的数字';
var price_reg = /^[0-9]\d*\.?\d*$|^0\.\d*[1-9]\d*$/;
function price() {
	return check($('#price_input'), price_empty, price_error, price_reg)
}