$(function(){
	paperList();
});

function paperList(){
	$('#proList').html("");
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/paperDetailList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			proId : $('#projectId').val(),
			paperId : $('#paperId').val(),
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
				pagination(data, function(){paperList();});
			}else{
				$('#proList').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
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
	gridHtml += "<td>"+obj.userAddress+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+obj.teachingSection+"</td>";
	gridHtml += "<td>"+obj.teachingSubject+"</td>";
	gridHtml += "<td>"+obj.ipaddress+"</td>";
	gridHtml += "<td>"+obj.createDate.substring(0,obj.createDate.length-2);+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.paperId + "\",\"" + row.username + "\");'>查看调查结果 </a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}


function openWindow(url){
	window.location.href = url;
}

function setup(id,username){
	var url=pathHeader+ "/edupm/projectmanage/myPaperView.htm?click=32&paperId="+id+"&username="+username;
	openWindow(url);
}
