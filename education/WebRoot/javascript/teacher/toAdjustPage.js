$(function() {
	if (judgeAuthority("teacher_007_add")) {
		$('#action').html(
						"<li><a href=\""
								+ pathHeader
								+ "/teacher/teachermanage/toAdjustAddPage.htm?click=333\">发起编制调整</a></li>"+$('#action').html());
	}
	queryDic('adjust_type');
	showAdjustList();

	// 条件查询
	$("#select").click(function() {
		showAdjustList();
	});
})

/**
 * 查询字典表
 */
function queryDic(type) {
	var url = pathHeader + "/sys/queryDicByType.do";
	$.ajax( {
		url : url,
		data : {
			dicType : type
		},
		type : "post",
		async : false,
		success : function(data) {
			if (data.rows.length > 0) {
				var objList = data.rows;

				$.each(objList, function(index, element) {
					$("#adjustId").append(
							"<option value='" + element.dictionaryId + "'>"
									+ element.dictionaryName + "</option>");
				});

			}
		}
	});
}

function showAdjustList() {
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/teacher/teachermanage/queryAdjust.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					realName : $('#realName').val(),
					idNumber : $('#idNumber').val(),
					sizePerPage : sizePerPage,
					pageIndex : pageIndex,
					adjustId : $('#adjustId').val(),
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$("#counts").html(data.total);
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});

						$('#proTeacher_list').append(gridHtml);
						if (gridHtml == "") {
							gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
							$('#proTeacher_list').append(gridHtml);
						}
						pagination(data, function() {
							showAdjustList();
						});
					} else {
						gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var flag=0;
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>" + obj.idNumber + "</td>";
	gridHtml += "<td>" + obj.sex + "</td>";
	gridHtml += "<td>" + obj.oldAdjustName  + "</td>";
	gridHtml += "<td>" + obj.newAdjustName + "</td>";
	gridHtml += "<td>" + obj.auditCreateBy + "</td>";
	gridHtml += "<td>" + new Date(obj.auditCreateDate).format("yyyy-MM-dd");
	+"</td>";
	gridHtml += "<td>";
	if (obj.auditStatus == "15") {
		gridHtml += "自动审核通过";
		flag=1;
	} else if (obj.auditStatus == "13") {
		gridHtml += "通过";
		flag=1;
	} else if (obj.auditStatus == "12") {
		gridHtml += "未通过";
		flag=1;
	} else if (obj.auditStatus == "11") {
		gridHtml += "<font style='color: red;'>未审核</font>";
	}
	gridHtml += "</td>";
	gridHtml += "<td>";
	gridHtml += "<a href='#none' class='tablelink' onclick='adjustInfo(\""+obj.oldAdjustName+"\",\""+obj.newAdjustName+"\",\""+obj.mobilizeMark+"\",\""+obj.auditOption+"\","+flag+","+obj.auditStatus+")'>详情</a>";
	gridHtml += "</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function adjustInfo(oldAdjustName,newAdjustName,mobilizeMark,auditOption,flag,auditStatus){
	$('#oldAdjustName').html(oldAdjustName);
	$('#newAdjustName').html(newAdjustName);
	$('#mobilizeMark').html(mobilizeMark);
	$('#auditOption').html(auditOption);
	if(flag==1){
		$('#auditOptionHtml').css("display","");
		if(auditStatus=="15"){
			$('#auditOption').html("自动审核通过");
		}
	}else{
		$('#auditOptionHtml').css("display","none");
	}
	$(".tip2").fadeIn(200);
	
	  
  $(".tip2top a").click(function(){
  $(".tip2").fadeOut(200);
});

  $(".sure2").click(function(){
  $(".tip2").fadeOut(100);
});

}