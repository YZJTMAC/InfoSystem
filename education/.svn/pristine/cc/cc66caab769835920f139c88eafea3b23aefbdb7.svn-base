$(function(){
	initEduModel();
	initAutoComplete();
	$("#pageSize").change(function(){
		showInfoList();
	});
});

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
}




function showInfoList() {
	$('#targetList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/furtheredu/certificate/queryNotrainList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectName : $('#projectName').val(),
		queryYear:$('#queryYear').val(),
		modelId:$('#modelType').val(),
		typeId:2,
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				var areaId = data.areaId;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					indexFlag ++;
					gridHtml += getTdEHtml(element, indexFlag,areaId);
				});
				$('#targetList').append(gridHtml);
				
				$('#totleCount').text(data.total);
				pagination(data, function(){showInfoList(); });
			} else {
				$('#targetList').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
		},
		error:function(){
		}
	});
}

function getTdEHtml(obj ,index,areaId) {
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.name+"</td>";
	gridHtml += "<td>"+obj.organizer+"</td>";
	gridHtml += "<td>"+obj.beginDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.credit+"</td>";
	gridHtml += "<td>"+obj.scopeName+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	function optionFormatter(rows){
		var edit = "";
		var remove = "";
		if(rows.createByArea == areaId){
			edit = "<A class='tablelink click' href='###' onclick='edit("+rows.id+")' >编辑 </A>";
			remove = "<A class='tablelink  ' href='###' onclick='deleteNotrainInfo("+rows.id+")' >删除 </A>";
		}
		
		var returnStr = "";
		returnStr += edit;
		returnStr += remove;
		if(rows.status == 1) {
			returnStr += disable;
		} else if (rows.status == 0) {
			returnStr += enable;
		}   
		return returnStr;
	}
}

function deleteNotrainInfo(id){
	if(!confirm('确定要删除选中的信息吗？'))
		return false;
	$.ajax( {
			type : "POST",
			url : pathHeader + "/furtheredu/certificate/deleteNotrain.do",
			data:{id: id},
			async : true,
			success : function(msg) {
				if (msg.success) {
					showInfoList();
					alert("删除成功！");
				} else {
					
				}
 			},
			error : function() {
			}
		});
}

function initEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
				if(data.success){
					var rows = data.rows;
				var opts = "<option value='0' selected>请选择</option>";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
				}
				$("select[name='modelId']").html(opts);
				}
		},
		error:function(){
			alert("初始化继教信息模块失败！");
		}
		
	});
}

function edit(id) {
	var openUrl= pathHeader + "/furtheredu/certificate/mnotrainUpdPage.htm?click=7&id=" +id;
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}