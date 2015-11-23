$(function(){
	$('#deleteAccount_cancel').click(function(){
		closeAlertWindow('deleteAccount');
	})
	$('#deleteAccount_confirm').click(function(){
		closeAlertWindow('deleteAccount');
		deleteAccount();		
	})
})

function deleteAccount(){
	$.ajax({
		type : "POST",
		url : ctxPath + "manager/deleteAccount.do",
		dataType : "json",
		data : {
			"partnerId" : partnerId,
			"userId" : userId
		},
		success : function(data) {
			if (data.res == "success") {
				if (data.code == "1000") {
					alert(data.msg);
					window.location.href = ctxPath
							+ "manager/publisherManage.do";
				} else if (data.code == "1001" || data.code == "1002") {
					showError($("userId"), data.msg);
				} else {
					alert(data.msg);
				}
			} else {
				alert(data.msg);
			}
		}		
	});
}