$(function(){
	paperList();
});

function paperList(){
	$('#proList').html("");
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/paperList.do";
	
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
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td>"+obj.username+"</td>";
	gridHtml += "<td>"+obj.attendedNum+"</td>";
	gridHtml += "<td>"+(obj.isforce==0?'是':'否')+"</td>";  
	if(obj.status==0){
		gridHtml += "<td>待启动</td>";
	}else if(obj.status==1){
		gridHtml += "<td>启动中</td>";
	}else{
		gridHtml += "<td>已结束</td>";
	}
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status==1||row.status==0){
			returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.id + "\");'>编辑</a>&nbsp;&nbsp;&nbsp;";
		}
		returnStr += 	 "<a href='###' class='tablelink' onclick='del(\"" + row.id + "\");'>删除</a>&nbsp;&nbsp;&nbsp;";
		returnStr += 	 "<a href='###' class='tablelink' onclick='preview(\"" + row.id + "\");'>预览</a>&nbsp;&nbsp;&nbsp;";
		if(row.status==1){
			returnStr += 	 "<a href='###' class='tablelink' onclick='closePaper(\"" + row.id + "\");'>结束问卷</a>&nbsp;&nbsp;&nbsp;";
		}else if(row.status==0){
			returnStr += 	 "<a href='###' class='tablelink' onclick='staPaper(\"" + row.id + "\");'>启动问卷</a>&nbsp;&nbsp;&nbsp;";
		}
		returnStr += 	 "<a href='"+pathHeader + "/edupm/projectmanage/paperReport.htm?click=32&paperId="+row.id+"' class='tablelink' >结果分析</a>&nbsp;&nbsp;&nbsp;";
		returnStr += 	 "<a href='"+pathHeader + "/edupm/projectmanage/toProjectPaperDetailPage.htm?click=32&paperId="+row.id+"&proId="+$('#projectId').val()+"' class='tablelink' >结果明细</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}

function projectInfo(id){
	var url = pathHeader+ "/edupm/projectmanage/projectInfo.htm?click=32&proId="+id;
//	openWindow(url);
	window.open(url);
}

function openWindow(url){
	window.location.href = url;
}

function qryPro(){
	if(validateYear()){
		paperList();
	}else{
		alert("查询开始年度不能大于结束年度！");
	}
}

function staPaper(id){
	var url = pathHeader+ "/edupm/projectmanage/staPaper.do";
	com(id,url,"确定要启动该问卷");
}
function closePaper(id){
	var url = pathHeader+ "/edupm/projectmanage/closePaper.do";
	com(id,url,"确定要结束该问卷");
}
function del(id){
	var url = pathHeader+ "/edupm/projectmanage/delPaper.do";
	com(id,url,"确定要删除该问卷");
}
function com(id,url,tishi){
	if(confirm(tishi)){
		//openWindow(url);
		$.ajax({
			url:url,
			data:{
				paperId:id
			},
			type:"post",
			async:false,
			success:function(data){
				if(data.success){
					paperList();
				}
			},
			error:function(){
				alert("URL error！");
			}
		});
	}
}


function setup(id){
	var url = pathHeader + "/edupm/paper/toUpdatePaper.htm?click=32&paperId="+id;
	openWindow(url);
}

function preview(id){
	var url = pathHeader + "/edupm/paper/toPaperPrepview.htm?click=32&paperId="+id;
	openWindow(url);
}
