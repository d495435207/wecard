$(function(){
	$('#search_btn').click(
			function() {
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				window.open(ctxPath + "underwriter/cash.do?startTime="
						+ startTime + "&endTime=" + endTime, '_self');
			})
	$('#download').click(
			function() {
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				window.open(ctxPath + "underwriter/cashExcel.do?startTime="
						+ startTime + "&endTime=" + endTime, '_self');
			})
})