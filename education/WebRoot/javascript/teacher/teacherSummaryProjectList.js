$(function(){
	projectList();
	  $(".sure").click(function(){
		  	var summaryTitle = $("#summaryTitle").val();
		  	var summaryContent = $("#summaryContent").val();
		  	var summaryId = $("#summaryId").val();
		  	var pid = $("#pid").val();
		  	var url="<%=path1%>/edupm/summary/savaOrUpdateSummary.do?time="+(new Date()).getTime();
		  	$.ajaxFileUpload({
		        fileElementId:'attchmentPath',  
		        dataType: 'xml',  
		  		url:url,
		  		data:{title:summaryTitle,content:summaryContent,id:summaryId,projectId:pid,type:0},
		  		success:function(data){
		  			$(".tip").fadeOut(100);
		  		},
		  		error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("保存数据出错！请联系管理员");
				}
		  	});
  	
	});
  
  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});
});

function projectList(){
	$('#proOverList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/teacher/teacherProject/teacherOverProjectList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
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
				$('#proOverList').append(gridHtml);
				pagination(data, function(){projectList();});
			}else {
				$('#proOverList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var startDate = new Date(obj.startDate).format("yyyy-MM-dd");
	var endDate = new Date(obj.endDate).format("yyyy-MM-dd");
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+startDate+"</td>";
	gridHtml += "<td>"+endDate+"</td>";
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.projectPropertyName+"</td>";
	gridHtml += "<td>"+teacherScoreFormatter(obj.teacherScore)+"</td>";
	gridHtml += "<td>"+teacherStatusFormatter(obj.teacherTrainStatusName)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function teacherScoreFormatter(score){
		var a = (score==null || score=='null' || score=='')?'暂无成绩': score;
		return a;
	}
	
	function teacherStatusFormatter(status){
		var a = (status==null || status=='null' || status=='')?'暂无状态': status;
		return a;
	}
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.projectScore==null){
			returnStr += 	 "<a href='###' class='huibtn_a click' onclick='setup(" + row.id +",\""+row.projectName+ "\");'>总结</a>";
		}else if(row.projectScore!==null){
			returnStr += 	 "<a href='###' class='tablelink click' onclick='projectInfo(\"" + row.id + "\");'>已发表总结</a>&nbsp;&nbsp;&nbsp;";
		}
		
		return returnStr;
	}
}
var proId;
function setup(id,proName){
	$("#proName").html(proName);
	proId = id;
	$(".tip").fadeIn(200);
}
function projectInfo(id){
	var url = pathHeader+ "/teacher/teacherProject/teacherOverProjectInfo.htm?projectId="+id;
	openWindow(url);
}
function addProjectInfo(id){
	var url = pathHeader+ "/teacher/teacherProject/teacherRealyAddProjectInfo.htm?projectId="+id;
	openWindow(url);
}


function openWindow(url){
	window.location.href = url;
}
//条件查询
function qryPro(){
	projectList();
}
