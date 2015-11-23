$(function(){
	$('#name').blur(function(){
		name();
	})
	$('#percent').next().find('li').click(function(){
		percent();
	})
	$('#confirm').click(function(){
		if (name()&percent()) {
			updateUnderwriter();
		}
	})
	$('#cancel').click(function(){
		history.back();
	})
})

var name_empty='请输入承销商名称';
function name(){
	return check($('#name'),name_empty);
}

var percent_empty='请选择分成占比';
function percent(){
	return checkSelect('percent',percent_empty)
}