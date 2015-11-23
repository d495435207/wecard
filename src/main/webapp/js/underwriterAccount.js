$(function(){
	$('#tabspan1').click(function(){
		showTab1();
	})

	$('#tabspan2').click(function(){
		showTab2();
	})

	$('#bank').blur(function(){
		bank();
	})

	$('#beneficiary').blur(function(){
		beneficiary();
	})

	$('#bank_name').blur(function(){
		bank_name();
	})

	$('#bank_account').blur(function(){
		bank_account();
	})

	$('#edit').click(function(){
		edit();
	})

	$('#cancel').click(function(){
		cancel();
	})
	$('#confirm').click(function(){
		if (bank()&beneficiary()&bank_name()&bank_account()) {
			confirmed();
			save();
			updateUnderwriter();
		}
	})
	save();
})

var bank_val,beneficiary_val,bank_name_val,bank_account_val;
function save(){
	bank_val=$('#bank').val();
	beneficiary_val=$('#beneficiary').val();
	bank_name_val=$('#bank_name').val();
	bank_account_val=$('#bank_account').val();
}

function edit(){
	$('#edit_button').hide();
	$('#op_button').show();
	$('#add').css('opacity',1);
	$('.red').fadeIn(500);
	$('.long_input').css('border-color','#ccc').attr('disabled',false);
}

function confirmed(){
	$('#edit_button').show();
	$('#op_button').hide();
	$('#add').css('opacity',0);
	$('.red').fadeOut(500);
	$('.long_input').css('border-color','#fff').attr('disabled',true);
}

function cancel(){
	$('#bank').val(bank_val);
	$('#beneficiary').val(beneficiary_val);
	$('#bank_name').val(bank_name_val);
	$('#bank_account').val(bank_account_val);
	$('#edit_button').show();
	$('#op_button').hide();
	$('#add').css('opacity',0);
	$('.red').fadeOut(500);
	$('.long_input').css('border-color','#fff').attr('disabled',true);
	$('.error').remove();
}

var bank_empty='请输入银行名称';
function bank(){
	return check($('#bank'),bank_empty);
}

var beneficiary_empty='请输入收款方';
function beneficiary(){
	return check($('#beneficiary'),beneficiary_empty);
}

var bank_name_empty='请输入开户行名称';
function bank_name(){
	return check($('#bank_name'),bank_name_empty);
}

var bank_account_empty='请输入银行账号';
function bank_account(){
	return check($('#bank_account'),bank_account_empty);
}

function showTab1(){
	$('#slidespan').css('transform','translateX(0)');
	$('#tab2').hide();
	$('#tab1').show();
}

function showTab2(){
	$('#slidespan').css('transform','translateX(138px)');
	$('#tab1').hide();
	$('#tab2').show();
}