$(function(){

	projectList();
		$(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/projectList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList').append(gridHtml);
				pagination(data, function(){projectList();});
			}else{
				$('#proList').html("<tr><td colspan='4'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.projectName+"</td>";
	gridHtml += "<td>"+obj.trainScopeName+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.id + "\");'>指定培训机构</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}

function qryPro(){
	if(validateYear()){
		projectList();
		
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}
/**
 * 指定培训机构
 * @param {Object} id
 */
function setup(id){
	var url = pathHeader + "/edupm/projectmanage/toOrgListByAreaPage.htm?click=2&proId="+id;
	openWindow(url);
}