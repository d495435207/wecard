$(function() {
	$('#search_btn').click(
			function() {
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				window.open(ctxPath + "publisher/spend.do?startTime="
						+ startTime + "&endTime=" + endTime, '_self');
			})
	$('#download').click(
			function() {
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				window.open(ctxPath + "publisher/spendExcel.do?startTime="
						+ startTime + "&endTime=" + endTime, '_self');
			})
})