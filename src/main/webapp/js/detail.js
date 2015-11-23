$(function(){
	$('.close_button').click(function(){
		var parent=window.parent.document;
		$(parent).find(".block").remove();
		$(parent).find('.iframe').remove();
	})
})