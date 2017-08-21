$(function(){
	paperList();
});

function paperList(){
	$('#proList').html("");
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/teacher/teacherProject/paperList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			proId : $('#projectId').val(),
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			var map = data.map;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,map);
				});
				$('#proList').append(gridHtml);
				pagination(data, function(){paperList();});
			}else{
				$('#proList').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj,map){
	var tn = "";
	var ps = "";
	if(obj.projectScopeName!="请选择"){
		ps = obj.projectScopeName;
	}
	if(obj.trainTypeName!='请选择'){
		tn = obj.trainTypeName;
	}
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.name+"</td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.username+"</td>";
	gridHtml += "<td>"+(obj.isforce==0?'是':'否')+"</td>";  
	if(obj.status==0){
		gridHtml += "<td>待启动</td>";
	}else if(obj.status==1){
		gridHtml += "<td>启动中</td>";
	}else{
		gridHtml += "<td>已结束</td>";
	}
	if(map[obj.id]==undefined){
		gridHtml += "<td>未提交</td>";
	}else{
		gridHtml += "<td>已提交</td>";
	}
	
	gridHtml += "<td>"+optionFormatter(obj,map)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row,map){
		var returnStr = "";
	     if(row.status==1){
			if(map[row.id]==undefined){
				returnStr += 	 "<a href='###' class='tablelink' onclick='tj(\"" + row.id + "\");'>提交问卷</a>&nbsp;&nbsp;&nbsp;";
			}else{
				returnStr += 	 "<a href='###' class='tablelink' onclick='ck(\"" + row.id + "\");'>查看</a>&nbsp;&nbsp;&nbsp;";
			} 
	     }else if(row.status==3){
	    		if(map[row.id]=="undefined"){
				}else{
					returnStr += 	 "<a href='###' class='tablelink' onclick='ck(\"" + row.id  + "\");'>查看</a>&nbsp;&nbsp;&nbsp;";
				} 
	      }
		return returnStr;
	}
}


function openWindow(url){
	window.location.href = url;
}

function qryPro(){
	if(validateYear()){
		paperList();
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}


function tj(id){
	var url = pathHeader + "/teacher/teacherProject/paperPrepview.htm?click=11&paperId="+id;
	openWindow(url);
}

function ck(id){
	var url = pathHeader + "/teacher/teacherProject/myPaperView.htm?click=11&paperId="+id;
	openWindow(url);
}
