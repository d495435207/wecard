$(function() {
	$('#tab_border li').click(function() {
		moveBorder(this);
		$('#tab_border li').removeClass('tab_active');
		$(this).addClass('tab_active');
		if ($(this).index() == 0) {
			tab1Click('卡券领取数', chartData1);
		} else {
			tab2Click('分成金额', chartData2);
		}
	})
	tab1Click('卡券领取数', chartData1);
})

function tab1Click(name, data) {
	$('#chart1,#chart2').hide();
	$('#chart1').show();
	chart($('#chart1'), name, data);
}

function tab2Click(name, data) {
	$('#chart1,#chart2').hide();
	$('#chart2').show();
	chart($('#chart2'), name, data);
}