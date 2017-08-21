$(function(){
	projectList();
});

function projectList(){
	$('#modelManageList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader+ "/edupm/projectmanage/getModelList.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
//			projectName : $('#projectName').val(),
//			start : $('#beginDate').val(),
//			end : $('#endDate').val(),
			sizePerPage :sizePerPage,
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			$("#counts").html(data.total);
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#modelManageList').append(gridHtml);
				pagination(data, function(){projectList();});
			}else {
				$('#modelManageList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				}
		},
		error:function(){
			
		}
		
	});
	
}


function parseDate(str) {
    var mdy = str.split('-');
    return new Date(mdy[0], mdy[1], mdy[2]);
}

function daydiff(first, second) {
    return (second-first)/(1000*60*60*24);
}

function getTdHtml(obj){
//	var startArray = obj.startDate.split("-");
//	var syyyy = startArray[0];
//
//	var endArray = obj.endDate.split("-");
//	var eyyyy = endArray[0];
 		
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.modelName+"</td>";
//	var val = eyyyy-syyyy;
//	var result = "";
//	if(val==0){
//		result = "1年";
//	}else{
//		result = val+"年";
//	}
//	
//	var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
//	var firstDate = new Date(2008,01,12);
//	var secondDate = new Date(2008,01,22);
//
//	var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));

	//alert(parseDate(obj.startDate));
	//alert(obj.endDate);
	
 
	gridHtml += "<td>"+daydiff(parseDate(obj.startDate), parseDate(obj.endDate))+"天</td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
}
function optionFormatter(obj){
	var returnStr = "";
	//都可以查看
	//returnStr += 	 "<a href='###' class='tablelink' onclick='editModelInfo(\"" + obj.id + "\");'>编辑</a>&nbsp;&nbsp;&nbsp;";
	returnStr += 	 "<a href='###' class='tablelink' onclick='getModelInfo(\"" + obj.id + "\");'>查看</a>&nbsp;&nbsp;&nbsp;";
	//如果没有被用到，可以编辑，启用，禁用
	if(obj.used==0){
		returnStr += 	 "<a href='###' class='tablelink' onclick='editModelInfo(\"" + obj.id + "\");'>编辑</a>&nbsp;&nbsp;&nbsp;";
		returnStr += 	 "<a href='###' class='tablelink' onclick='deleteModelInfo(\"" + obj.id + "\");'>删除</a>&nbsp;&nbsp;&nbsp;";
		if(obj.status == 1){
			returnStr += 	 "<a href='###' class='tablelink' onclick='updateModeInfo(\"" + obj.id + "\",\"" + obj.status + "\");'>禁用</a>&nbsp;&nbsp;&nbsp;";
		}else if(obj.status == 0){
			returnStr += 	 "<a href='###' class='tablelink' onclick='updateModeInfo(\"" + obj.id + "\",\"" + obj.status + "\");'>启用</a>&nbsp;&nbsp;&nbsp;";
		}else{
			returnStr += 	 "<a href='###' class='tablelink'>数据错误</a>&nbsp;&nbsp;&nbsp;";
		}
	}else{
		returnStr += 	 "板块使用中&nbsp;&nbsp;&nbsp;";
	}
	
	return returnStr;
}
function addModelInfo(){
	var url = pathHeader+ "/edupm/projectmanage/addModelInfo.htm?click=19";
	window.location.href=url;
}
function editModelInfo(id){
	var url = pathHeader+ "/edupm/projectmanage/editModelInfo.htm?click=19&id="+id;
	window.location.href=url;
}

function getModelInfo(id){
	var url = pathHeader+ "/edupm/projectmanage/selectModelInfo.htm?click=19&id="+id;
	window.location.href=url;
}
function deleteModelInfo(id){
	var url = pathHeader+ "/edupm/projectmanage/deleteModeInfo.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			id : id
		},
		async:true,
		success:function(data){
			if(data.success) 
			{
				var url = pathHeader+ "/edupm/projectmanage/toModelListPage.htm?click=19";
				jQuery.generalAlertAndJump("删除成功！",url);
			}
		},
		error:function(){
			jQuery.generalAlert("状态修改失败");
		}
		
	});
}

function updateModeInfo(id,status){
	status== '0' ? status= '1': status= '0';
	var url = pathHeader+ "/edupm/projectmanage/upateModeInfo.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			id : id,
			status : status
		},
		async:true,
		success:function(data){
			if(data.success) 
			{
				var url = pathHeader+ "/edupm/projectmanage/toModelListPage.htm?click=19";
				jQuery.generalAlertAndJump("状态修改成功！",url);
			}
			
		},
		error:function(){
			jQuery.generalAlert("状态修改失败");
		}
		
	});

}

