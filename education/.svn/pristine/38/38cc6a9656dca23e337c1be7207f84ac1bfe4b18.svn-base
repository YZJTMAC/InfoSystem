$(function(){
	$("#postPage").click(function() {
			setMobilize();
	});
})
function setMobilize() {
	var flag="0";
	$("input[name='audit']:checked").each(function() {
		flag = $(this).val();
	})
	$('#myModal').modal('show');
	var url = pathHeader + '/teacher/teachermanage/setAuditMobilize.do';
$.ajax( {
		url : url,
		data : {
			teacherId:teacherId,
			id:id,
			newProvinceId:newProvinceId,
			newProvinceName:newProvinceName,
			newCityId:newCityId,
			newCityName:newCityName,
			newDistrictId:newDistrictId,
			newDistrictName:newDistrictName,
			newSchoolId:newSchoolId,
			newSchoolName:newSchoolName,
			auditOption:$("#auditOption").html(),
			flag:flag
		},
		type : "POST",
		cache : false,
		async : true,
		dataType : "json",
		success : function(data) {
			if (data.success) {
				 if(click == 1006) {
				 	window.location.href = pathHeader + "/teacher/teachermanage/toReworkAuditListPage.htm?click=1006&flag=Y";
				 	$('#myModal').modal('hide');
				 } else {
					window.location.href = pathHeader + "/teacher/teachermanage/toMobilizeAuditListPage.htm?click=1000&flag=Y";
					$('#myModal').modal('hide');
				 }
//				$(".tip1").fadeIn(200);
//				//调动成功页面跳转
//		$("#msgHtml").html("提交成功！")
//		$("#toPage").val("确定");
//		$(".sure1").click(function() {
//			toPage(1);
//			$(".tip1").fadeOut(100);
//		});
	} else {
		$(".tip1").fadeIn(200);//显示提示框
		$("#msgHtml").html("提交失败，请稍后再试！");
		$("#toPage").val("关闭");
		$(".sure1").click(function() {
			toPage(0);
		});
	}
},
error : function() {
	$(".tip1").fadeIn(200);
	$("#msgHtml").html("提交失败，请稍后再试！");
	$("#toPage").val("关闭");
	$(".sure1").click(function() {
		toPage(0);
	});
}

	});

}

function toPage(lx) {
	if (lx == 1) {
		window.location.href = pathHeader
				+ backUrl;
	} else {
		$(".tip1").fadeOut(100);
	}
}