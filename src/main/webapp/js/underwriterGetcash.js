$(function(){
	$('#serial').blur(function(){
		serial();
	})
	$('#confirm').click(function(){
		if (serial()) {
			getCash();
		}
	})
	$('#cancel').click(function(){
		history.back();
	})
})

var serial_empty='请输入承销商名称';
function serial(){
	return check($('#serial'),serial_empty);
}