$(function() {
	showTeacherAssessList();
	
	getAndSetChecked();
});

function showTeacherAssessList() {
	$('#cHtml').html('');
	$.ajax( {
		url : pathHeader + '/sys/sysFunctionWithRole.do',
		type : "POST",
		cache : "false",
		async : false,
		dataType : "json",
		data : {
			id : roleId
		},
		success : function(data) {
			if (data.success) {
				var func = data.obj.func;
				var gridHtml = "";
				var footH = "";
				$.each(func,function(index, element) {
					if (footH == ""|| footH == element.funcCode.split('_')[0]) {
						gridHtml += getTdHtml(element);
					} else {
						gridHtml += "</td></tr></table>"+ getTdHtml(element);
					}
					footH = element.funcCode.split('_')[0];

				});
				$('#cHtml').append(gridHtml);

				var role = data.obj.role;
				$.each(role, function(index, element) {
					$('#roleName').val(element.roleName);
					if (element.status.toString() == "1") {
						$('#stautsY').attr("checked", "checked");
					} else {
						$('#stautsN').attr("checked", "checked");
					}
					$('#remark').val((element.remark!=null?element.remark:""));

					$('#id' + element.funcId + '').attr("checked", true);
				});
			}
		}
	});
}

var input_title = 0;

function getTdHtml(obj) {
	var gridHtml = "";
	if (obj.funcType == "1") {
		
		input_title += 1;
		
		gridHtml += "<h4 style=\"padding: 20px 0 20px 20px; margin-top: 30px; border-top: 1px dashed #a7b5bc;\"><input id=\"id"
				+ obj.id
				+ "\" name=\"FUNCTION\" class='FUNCTION_H4_"+input_title+"' value='"+obj.id+"' style='margin-right: 6px;' type=\"checkbox\">"
				+ obj.funcName + ":</h4>";
		gridHtml += "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"line-height: 36px; margin: 0 auto; width: 90%;\"><tr><td>";
	} else {
		gridHtml += "<div style='float:left;padding-right:0px; width:320px'><input value='"+obj.id+"' id=\"id"
				+ obj.id
				+ "\" name=\"FUNCTION\" class='FUNCTION_DIV_"+input_title+"'"
				+ (obj.funcType == "2" ? "checked style='margin-right: 6px;display:none'"
						: "style=\"margin-right: 6px;\"")
				+ " type=\"checkbox\"><strong "
				+ (obj.funcType == "2" ? "style='display:none'" : "")
				+ ">"
				+ obj.funcName + "</strong></div>";
	}
	return gridHtml;
}


function getAndSetChecked(){
	// 批量选中/取消
	$('input[class^="FUNCTION_H4_"]').click(function(){
		var h4_index = $(this).attr('class').substr(12, 13);
	
		
		if($(this).attr('checked')){
			$('.FUNCTION_DIV_'+h4_index).attr('checked', true);
		} else {
			$('.FUNCTION_DIV_'+h4_index).attr('checked', false);
		}
	});
	
	// 子选项选中同时选中父选项, 子选项都未选中父选项取消选中
	$('input[class^="FUNCTION_DIV_"]').click(function(){
		var div_index = $(this).attr('class').substr(13, 14);
		if($(this).attr('checked')){
			$('.FUNCTION_H4_'+div_index).attr('checked', true);
		} else {
			var sum = 0;
			$('.FUNCTION_DIV_'+div_index).each(function(){
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == 0){
				$('.FUNCTION_H4_'+div_index).attr('checked', false);
			}
		} 
	});
	
}

function getDivChecked(){ 
	var sum = 0;
	$('input[class^="FUNCTION_DIV_"]').each(function(){
		if($(this).attr('checked')){
			sum += 1;
		} else {
			sum += 0;
		}
	});
	return sum;
}

function setRole() {
	var roleName=$('#roleName').val();
	var funcStr="";
	$("input[name='FUNCTION']:checked").each(function() {
		funcStr += $(this).val() + ",";
	})
	if(funcStr.length>0){
		funcStr=funcStr.substr(0,funcStr.length-1);
	}
	var stauts_=1;
	if($('#stautsN').attr("checked")){
		stauts_=0;
	}
	$("#btn").attr('disabled', true);
	$.ajax( {
		url : pathHeader + '/sys/setFunctionRole.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			id : roleId,
			roleName:roleName,
			remark:$('#remark').val(),
			status:stauts_,
			funcStr:funcStr
			
		},
		success : function(data) {
			if (data.success) {
				$('#msgHtml').html("保存成功！");
				$("#toPage").click(function() {
					toPage();
				});
				$(".tip").fadeIn(200);
			} else {
				$('#msgHtml').html("保存失败！");
				$("#btn").attr('disabled', false);
				$("#toPage").click(function() {
					close();
				});
				$(".tip").fadeIn(200);
			}
		},
		error : function() {
			$('#msgHtml').html("保存失败！");
			$("#btn").attr('disabled', false);
			$("#toPage").click(function() {
				close();
			});
			$(".tip").fadeIn(200);
		}
	});
}

function close() {
	$(".tip").fadeOut(200);
}

function toPage() {
	window.location.href = pathHeader + "/sys/toRolePage.htm?click=1";
}
