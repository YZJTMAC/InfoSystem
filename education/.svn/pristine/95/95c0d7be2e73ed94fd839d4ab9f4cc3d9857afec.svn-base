var openFlagB = true;
var openFlagC = true;
var openFlagD = true;

$(function(){
	
	$(".goback").click(function(){
    	showWindow(pathHeader +"/teacher/teachermanage/teacherManagePage.htm?click=1");
	});
	
		$('.click').click(function(){
//		if(validateTeacherId()) {
			$("#div" + $(this).attr("id")).toggle();
			if($(this).attr("id") == 'B') {
				openFlagB = openFlagB ? false:true;
				if(openFlagB) {
					$(this).children().attr("src", pathHeader + "/images/btn_shrink.gif");
				} else {
					$(this).children().attr("src", pathHeader + "/images/btn_spread.gif");
				}
			}
			if($(this).attr("id") == 'C') {
				openFlagC = openFlagC ? false:true;
				if(openFlagC) {
					$(this).children().attr("src", pathHeader + "/images/btn_shrink.gif");
				} else {
					$(this).children().attr("src", pathHeader + "/images/btn_spread.gif");
				}
			}
			if($(this).attr("id") == 'D') {
				openFlagD = openFlagD ? false:true;
				if(openFlagD) {
					$(this).children().attr("src", pathHeader + "/images/btn_shrink.gif");
				} else {
					$(this).children().attr("src", pathHeader + "/images/btn_spread.gif");
				}
			}
//		}
	});
});
 
function showWindow(url) {
	window.location.href = url;
}

/**
 * 审核教师
 */
function teacherAudit(data) {
	var auditTeacher = $('input:radio[name="auditTeacher"]:checked').val();	
	
	$.ajax({
		url : pathHeader + "/teacher/teachermanage/auditTeacher.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{data:data, isPass:auditTeacher,memo:$('#memo').val()},
		success:function(data){
			if(data.success) {
				var url = pathHeader +"/teacher/teachermanage/teacherManagePage.htm?click=1";
				jQuery.generalAlertAndJump("审核操作成功！", url);
//				showWindow(pathHeader +"/teacher/teachermanage/teacherManagePage.htm");
			} else {}
		},
		error:function(){
		}
	});
	
}

function test(data) {
		
	
}