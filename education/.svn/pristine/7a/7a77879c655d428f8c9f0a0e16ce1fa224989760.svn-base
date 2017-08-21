$(function(){
	projectList();
	$(".sure").click(function(){
	  var radioVal = $("input[name='radio']:checked").val();
	  var url = pathHeader +"/teacher/teacherProject/createTeacherComment.do";
	  $.ajax({
		  url:url,
		  type:"post",
		  data:{projectScore:radioVal,projectId:proId},
		  async:true,
		  success:function(data){
			  if(data.success){
				  url = pathHeader +"/teacher/teacherProject/teacherOverProjectPage.htm";
				  openWindow(url);
				  $(".tip").fadeOut(100);
			  }
		  },
		  error:function(){
			  jQuery.generalAlert("url error!");
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
				
			}else {
				$('#proOverList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				}
			pagination(data, function(){projectList();});
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
	gridHtml += "<td>"+teacherClassScoreFormatter(obj.classScore)+"</td>";
	gridHtml += "<td>"+teacherStatusFormatter(obj.teacherTrainStatusName)+"</td>";
	
	return gridHtml;
	
	function teacherScoreFormatter(score){
		var a = (score==null || score=='null' || score=='')?'暂无成绩': score;
		return a;
	}
	function teacherClassScoreFormatter(score){
		var a = (score==null || score=='null' || score=='')?'无学分信息': score;
		return a;
	}
	
	function teacherStatusFormatter(status){
		var a = (status==null || status=='null' || status=='')?'暂无状态': status;
		return a;
	}
	
}
var proId;
function setup(id,proName){
//	$(".tip").fadeIn(200);
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
