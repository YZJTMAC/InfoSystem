$(function() {
	showSignetList();
})

function showUploadSignet() {
	$(".tip14").fadeIn(200);
}
function closeUpload() {
	$(".tip14").fadeOut(200);
}

function close() {
	$(".tip0").fadeOut(200);
}
function toPage() {
	window.location.href = pathHeader
			+ "/furtheredu/edumanage/toSignet.htm?click=19872";
}

function saveUp(data) {
	if ($('#imageSrcTemp').val() == "") {
		$('#error').html("请上传电子印章！");
		return false;
	} else {
		$('#error').html("");
	}
	if ($('#signetName').val() == "") {
		$('#error').html("印章名称不能为空！");
		return false;
	} else {
		$('#error').html("");
	}
	$.ajax( {
		type : "POST",
		url : pathHeader + "/furtheredu/edumanage/saveSignet.do",
		data : {
			signetName : $('#signetName').val(),
			signetUrl : $('#imageSrcTemp').val()
		},
		async : true,
		success : function(msg) {
			$("#toCancel").css("display", "none");
			if (msg.success) {
				$('#msgHtml').html("保存成功！");
				$("#toPage").html("<input name=\"\" onclick='toPage();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);
			} else {
				$('#msgHtml').html("保存失败，请重试！");
				$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);

			}
		},
		error : function() {
			$("#toCancel").css("display", "none");
			$('#msgHtml').html("保存失败，请重试！");
			$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
			$(".tip0").fadeIn(200);
		}
	});
}

function updateSignet(flag, id) {
	$.ajax( {
		url : pathHeader + "/furtheredu/edumanage/updateSignet.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			flag : flag,
			id : id
		},
		success : function(data) {
			$("#toCancel").css("display", "none");
			if (data.success) {
				$('#msgHtml').html("删除成功！");
				$("#toPage").html("<input name=\"\" onclick='toPage();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);
			} else {
				$('#msgHtml').html("删除失败，请重试！");
				$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
				$(".tip0").fadeIn(200);
			}
		},
		error : function() {
			$("#toCancel").css("display", "none");
			$('#msgHtml').html("删除失败，请重试！");
			$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
			$(".tip0").fadeIn(200);
		}
	});
}

function deleteSignet(flag, id) {
	var ids=id;
	var flags=flag;
	$('#msgHtml').html("确定删除吗？");
	$("#toCancel").css("display", "");
	
	$("#toPage").html("<input name=\"\" onclick='updateSignet("+flags+", "+ids+");'  type=\"button\" class=\"sure1\" value=\"确定\" />");

	$("#toCancel").click(function() {
		close();
	});
	$(".tip0").fadeIn(200);

}

function showSignetList() {
	$.ajax( {
		url : pathHeader + "/furtheredu/edumanage/querySignetList.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			flag : 1
		},
		success : function(data) {
			if (data.success) {
				var accLog=data.accLog;
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index, element) {
					gridHtml += getDivHtml(element,accLog);
				});
				if(gridHtml==""){
					$('#targetList').html("<div style='margin-left:20px'>无查询记录<div>");
				}else{
					$('#targetList').html(gridHtml);
				}
			} else {
				$('#targetList').html("<div  style='margin-left:20px'>无查询记录<div>");
			}
		},
		error : function() {
			$("#toCancel").css("display", "none");
			$('#msgHtml').html("查询失败！");
			$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
			$(".tip0").fadeIn(200);
		}
	});
}

function getDivHtml(obj,accLog) {

		
	
	var ht = "";
	ht += "<div class=\"xiangmuList\">";
	ht += "<div class=\"xiangmuName\"  style=\"width: 260px\">";
	ht += "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
	ht += "<tr>";
	//if(obj.createBy==accLog){
	ht += "<td rowspan=\"2\"><img title='"+obj.signetName+"' alt='"+obj.signetName+"' src=\""+imageServer+obj.signetUrl+"\" width=\"150\" height=\"150\" /></td></tr></table>";
	ht += "<p>";
	ht += "<span title=\""
			+ obj.signetName
			+ "\">"
			+ (obj.signetName.toString().length > 7 ? obj.signetName.toString()
					.substr(0, 7) : obj.signetName) + "</span> &nbsp";
	ht += "<span class=\"xm\"><a href=\"#\" id='"+obj.id+"' onclick='deleteSignet(0,"+obj.id+");' class=\"go\">&nbsp;&nbsp;删除&nbsp;&nbsp;</a></span></p></div></div>";
	//}
	return ht;
}