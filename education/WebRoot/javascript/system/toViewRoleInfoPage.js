$(function() {
	showTeacherAssessList();
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
				/*if(roleId == roleType){
					$('cHtml').attr("disabled","disabled");
				}*/
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
		
		gridHtml += "<h4 style=\"padding: 20px 0 20px 20px; margin-top: 30px; border-top: 1px dashed #a7b5bc;\"><input disabled= \"disabled\" id=\"id"
				+ obj.id
				+ "\" name=\"FUNCTION\" class='FUNCTION_H4_"+input_title+"' value='"+obj.id+"' style='margin-right: 6px;' type=\"checkbox\">"
				+ obj.funcName + ":</h4>";
		gridHtml += "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"line-height: 36px; margin: 0 auto; width: 90%;\"><tr><td>";
	} else {
		gridHtml += "<div style='float:left;padding-right:0px; width:320px'><input disabled = \"disabled\" value='"+obj.id+"' id=\"id"
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

