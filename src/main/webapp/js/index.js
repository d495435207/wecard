$(function(){
	$('#tab_border li').click(function(){
		moveBorder(this);
		$('#tab_border li').removeClass('tab_active');
		$(this).addClass('tab_active');
		if ($(this).index()==0) {
			tab1Click('卡券领取数',chartData1);
		} else {
			tab2Click('消耗',chartData2);
		}
	})
	tab1Click('卡券领取数',chartData1);
	$('.cell').mouseover(function(){
		$(this).css('box-shadow','0 1px 7px 1px #ccc');
	})
	$('.cell').mouseout(function(){
		$(this).css('box-shadow','none');
	})
	$('.data').mouseover(function(){
		$(this).css('box-shadow','0 -1px 10px 1px #ccc');
	})
	$('.data').mouseout(function(){
		$(this).css('box-shadow','none');
	})
})

function tab1Click(name,data){
	$('#chart1,#chart2').hide();
	$('#chart1').show();
	chart($('#chart1'),name,data);
}

function tab2Click(name,data){
	$('#chart1,#chart2').hide();
	$('#chart2').show();
	chart($('#chart2'),name,data);
}