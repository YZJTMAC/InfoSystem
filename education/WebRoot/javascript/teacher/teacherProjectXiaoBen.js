$(function(){
	projectList();
	 
	//选择机构
	$(".sure").click(function(){
	  var radioVals = $("input[name='radio']:checked").val();
	  var values = new Array();
	  values = radioVals.split(",");
		var organizationId = values[0];
		var projectId = values[1];
		var URL = values[2];
		var url = pathHeader +"/teacher/teacherProject/teacherGoStatySelectOrg.do";
	  $.ajax({
		  url:url,
		  type:"post",
		  data:{organizationId:organizationId,projectId:projectId},
		  async:true,
		  success:function(data){
			  if(data.success){
//				  urlGo =URL;
//				 window.location.href = urlGo;
//				  // window.open(urlGo);
				  jQuery.generalAlert("选择机构成功!");
				  projectList();
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
  $(".tiptop").click(function(){
  $(".tip").fadeOut(100);
	});
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader+ "/teacher/teacherProject/teacherProjectXiaoBen.do";
	
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
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList').append(gridHtml);
				$("#counts").html(data.total);
				pagination(data, function(){projectList();});
			}
			else {
				$('#proList').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
		
	});
	
}


function getTdHtml(obj){
	var trainTypeName = "";
	var projectScopeName="";
	var planNum ="";
	var startDate = new Date(obj.startDate).format("yyyy-MM-dd");
	var endDate = new Date(obj.endDate).format("yyyy-MM-dd");
	if(obj.trainTypeName!==null){
		trainTypeName = obj.trainTypeName;
	}
	if(obj.projectScopeName!==null){
		projectScopeName = obj.projectScopeName;
	}
	if(obj.planNum!==null){
		planNum = obj.planNum;
	}
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+startDate+"</td>";
	gridHtml += "<td>"+endDate+"</td>";
	gridHtml += "<td>"+trainTypeName+"</td>";
	gridHtml += "<td>"+projectScopeName+"</td>";
	gridHtml += "<td>"+planNum+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.contins=="noContin"){
			returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>您不在培训的范围内</a>&nbsp;&nbsp;&nbsp;";
			
		} else if(row.contins==null){
			returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>您(学科)不在培训的范围内</a>&nbsp;&nbsp;&nbsp;";
		} else if(row.contins=="contin"){
				if(row.teacherOkOrNo==null||row.teacherOkOrNo==""){
//			if(row.xueke!==null&row.xueduan!=null){
//				var result = row.xueke;
//			returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>"+result+"</a>&nbsp;&nbsp;&nbsp;";
//			}
//			if(row.xueduan!=null){
//				var result = row.xueduan;
//			returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>"+result+"</a>&nbsp;&nbsp;&nbsp;";
//			}
					if(row.xueke!==null){
					var result = row.xueke;
					returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>"+result+"</a>&nbsp;&nbsp;&nbsp;";
					}
				}
				//补报
				if(row.teacherOkOrNo=="Ok"&row.status==null&(row.projectStatus==40||row.projectStatus ==41) && row.signUpWay == 2){
					returnStr += 	 "<a href='###' class='tablelink' onclick='addProjectInfo2(\"" + row.id + "\");'>报名</a>&nbsp;&nbsp;&nbsp;";
				}
				// update_by: zxq
				// 项目已分配给机构且项目未启动
				if(row.teacherOkOrNo=="Ok"&row.status==null&(row.projectStatus==30) && row.signUpWay == 2){
					returnStr += 	 "<a href='###' class='tablelink' onclick='addProjectInfo(\"" + row.id + "\");'>报名</a>&nbsp;&nbsp;&nbsp;";
				}
				// update_by: zxq
				// 项目未分配给机构且项目未启动
				if(row.teacherOkOrNo=="Ok"&row.status==null&(row.projectStatus==null) && row.signUpWay == 2){
					returnStr += 	 "<a href='###' class='tablelink' onclick='addProjectInfo(\"" + row.id + "\");'>报名</a>&nbsp;&nbsp;&nbsp;";
				}
				if(row.teacherOkOrNo=="Ok"&row.status==11 ){
					returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>审核中</a>&nbsp;&nbsp;&nbsp;";
				}
				if(row.teacherOkOrNo=="Ok"&row.status==12){
					returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>审核未通过</a>&nbsp;&nbsp;&nbsp;";
				}
				if(row.teacherOkOrNo=="Ok"&row.status==13&row.organizationId==null){
					returnStr += 	 "<a href='###' class='tablelink' onclick='goStaty("+row.id+")'>审核通过-请选择机构</a>&nbsp;&nbsp;&nbsp;";
//			returnStr +="<a href='#' id='goStady' class='go' onclick='goStatyByPro("+values.id+','+values.organizationId+")'>审核通过请选择机构</a>";
				}
				if(row.teacherOkOrNo=="Ok"&row.organizationId!=null){
					returnStr += 	 "<a href='###' class='tablelink' onclick='projectInfo(\"" + row.id + "\");'>报名成功</a>&nbsp;&nbsp;&nbsp;";
				}
		}
		return returnStr;
 }
}
//审核通过---查询机构
function goStaty(id){
	$(".tip").fadeIn(200);
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherProjectOrganization.do",
		type:"POST",
		cache:"false",
		async:false,
		dataType:"json",
		data:{
		projectId:id
		},
		success:function(data){
			var projectName = data.name;
			if(data.success) 
			{
			var objList = data.infoList;
			 var divValues ="" ;
				if(objList.length==1){//只有一个机构时默认选中状态
					var values = objList[0];
					divValues += "<input type='radio' name='radio' checked='checked' value='"+values.organizationId+","+values.projectId+","+values.trainingAddress+"'>" +values.organizationName+
						"<a href='javascript:viewOrgInfo("+values.organizationId+")' style='color:blue'>"+"——点击查看"+"</a>"
						"</input>";
				} else {
					for(var i = 0 ;i<objList.length;i++){
						var values = objList[i];
					 	//var organizationUrl = pathHeader +'/sys/organizationInfo.htm?click=9&organizationId='+values.organizationId;
					   	divValues += "<input type='radio' name='radio' value='"+values.organizationId+","+values.projectId+","+values.trainingAddress+"'>" +values.organizationName+
						"<a href='javascript:viewOrgInfo("+values.organizationId+")' style='color:blue'>"+"——点击查看"+"</a>"
						"</input>";
						//projectName = values.projectName;
					}
				}
			}else{
				divValues="<font style='color:red'>没有查询到可以学习的机构</font>";
			}
			$('#projectName22').html(projectName);
			$('#organizationName').html(divValues);
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
	});
	}
function projectInfo(id){
	var url = pathHeader+ "/teacher/teacherProject/teacherProjectInfo.htm?projectId="+id + "&click=" + click;
	openWindow(url);
}
function addProjectInfo(id){
	var url = pathHeader+ "/teacher/teacherProject/teacherRealyAddProjectInfo.htm?projectId="+id+"&type=0&click=" + click;
	openWindow(url);
}
//补报
function addProjectInfo2(id){
	var url = pathHeader+ "/teacher/teacherProject/teacherRealyAddProjectInfo.htm?projectId="+id+"&type=1&click=" + click;
	openWindow(url);
}

function openWindow(url){
	window.location.href = url;
}
//条件查询
function qryPro(){
		projectList();
	
}

function viewOrgInfo(orgId){
	var url = pathHeader +'/sys/organizationInfoPage.htm?click=9&organizationId='+orgId;
	window.open(url);
}
