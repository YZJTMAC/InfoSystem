$(function(){
	initAutoComplete();
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
				  urlGo =URL;
				 window.location.href = urlGo;
				  // window.open(urlGo);
				  $("#choose1").fadeOut(100);
			  }
		  },
		  error:function(){
			  alert("url error!");
		  }
	 	  });
  	
	});
  
  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
  
 
  });
  
  $(".tiptop a").click(function(){
		$(".tip").fadeOut(200);
	});
  
});

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
}

function showInfoList() {
	$('#teacherList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherProjectList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		},
		success:function(data){
			if(data.success) 
			{
			var objList = data.projectList;
			 var divValues ="" ;
			for(var i = 0 ;i<objList.length;i++){
				var values = objList[i];
				var startDate = "";
				var endDate = "";
				if(values.startDate!=null){
					var datas = new Date(values.startDate).format("yyyy-MM-dd");
					strs = datas.split("-");
					startDate = 
									 strs[0]+"年"+strs[1]+"月"+strs[2]+"日";
					}else{
						startDate="----"
					}
				if(values.endDate!=null){
					
				var dd = new Date(values.endDate).format("yyyy-MM-dd");
					strs = dd.split("-");
					endDate = 
									 strs[0]+"年"+strs[1]+"月"+strs[2]+"日";
					}else{
						endDate="----"
					}
				var color = "";
				if(values.trainTypeId == 1){
					color = "#cb6868";
//					color = "#06fa3f";
				}else if(values.trainTypeId == 2){
					color = "#8b8bc4";
//					color = "#fa2d06";
				}else if(values.trainTypeId == 3){
					color = "#6fbc6fs";
//					color = "#061dfa";
				}else{
					color = "#249c40";
//					color = "#fa06d7";
				}
	//去学习项目进行中	
	if(values.projectStatus==40){
				if(values.organizationId==null||values.organizationId==""){
				    divValues += "<div class='xiangmuList'>" +
										"<div class='xiangmuName'>"+
					"<table border='0' cellspacing='0' cellpadding='0'>"+
					"<tr>"+
					"<td rowspan='2'><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'><img src='../../images/2014101405.jpg' width='150' height='150' /></a></td>"+
					/*"<td style='padding-left:10px;'><h5>"+values.projectName+"<b>"+"（共"+values.planNum+"人）"+"</b></h5></td>"+*/
					"<td style='padding-left:10px;'><font color='"+color+"' style='font-size:17px'>"+values.projectName+"</font></td>"+
					"</tr>"+
					"<tr>"+
					"<td style='padding-left:10px;'><h4><b>"+"（共"+values.planNum+"人）"+"</b></h4><span>开始时间："+startDate+"</span><br /><span>结束时间："+endDate+"</span></td>"+
					 /*<td style="padding-left:10px;"><h4><b>该项目共计3345人</b></h4><span>开始时间：2013年2月2日</span><br /><span>结束时间：2014年1月8日</span></td>	*/
					"</tr>"+
					"</table>"+
					"<p>介绍："+values.memo+"</p>"+
					"<div class='xiangmu_study'>"+
					"<ul>";
				   //培训形式2为面授，面授是没有对接设置的，所以是没有去学习的超链接的
					if(values.trainTypeId != 2){
						divValues +="<li><a href='#' id='goStady' class='go' onclick='goStaty("+values.id+")'>去学习</a></li>";
					}
					
					divValues +="<li><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'>详细信息</a></li>"+
					"</ul>"+
					"</div>"+
					"</div>"+
					"</div>";
				}else if(values.organizationId!=null){
					 divValues += "<div class='xiangmuList'>" +
									"<div class='xiangmuName'>"+
					"<table border='0' cellspacing='0' cellpadding='0'>"+
					"<tr>"+
					"<td rowspan='2'><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'><img src='../../images/2014101405.jpg' width='150' height='150' /></a></td>"+
					/*"<td style='padding-left:10px;'><h5>"+values.projectName+"<b>"+"（共"+values.planNum+"人）"+"</b></h5></td>"+*/
					"<td style='padding-left:10px;'><font color='"+color+"' style='font-size:17px'>"+values.projectName+"</font></td>"+
					"</tr>"+
					"<tr>"+
					"<td style='padding-left:10px;'><h4><b>"+"（共"+values.planNum+"人）"+"</b></h4><span>开始时间："+startDate+"</span><br /><span>结束时间："+endDate+"</span></td>"+
					"</tr>"+
					"</table>"+
					"<p>介绍："+values.memo+"</p>"+
					"<div class='xiangmu_study'>"+
					"<ul>";
						//培训形式2为面授，面授是没有对接设置的，所以是没有去学习的超链接的
						 if(values.trainTypeId != 2){
							 divValues += "<li><a href='#' id='goStady' class='go' onclick='goStatyByPro("+values.id+','+values.organizationId+")'>去学习</a></li>";
						 }
						 divValues +="<li><a href='#' id='trainingMaterials' class='go' onclick='viewFiles("+values.id+','+values.organizationId+",\""+values.projectName+"\")'>查看资料</a></li>"+
						"<li><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'>详细信息</a></li>"+
						"</ul>"+
						"</div>"+
						"</div>"+
						"</div>";
				}
	}else if(values.projectStatus==30){//待启动
		divValues += "<div class='xiangmuList'>" +
									"<div class='xiangmuName'>"+
				"<table border='0' cellspacing='0' cellpadding='0'>"+
				"<tr>"+
				"<td rowspan='2'><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'><img src='../../images/2014101405.jpg' width='150' height='150' /></a></td>"+
				/*"<td style='padding-left:10px;'><h5>"+values.projectName+"<b>"+"（共"+values.planNum+"人）"+"</b></h5></td>"+*/
				"<td style='padding-left:10px;'><font color='"+color+"' style='font-size:17px'>"+values.projectName+"</font></td>"+
				"</tr>"+
				"<tr>"+
				"<td style='padding-left:10px;'><h4><b>"+"（共"+values.planNum+"人）"+"</b></h4><span>开始时间："+startDate+"</span><br /><span>结束时间："+endDate+"</span></td>"+
				"</tr>"+
				"</table>"+
				"<p>介绍："+values.memo+"</p>"+
				"<div class='xiangmu_study'>"+
				"<ul>"+
				"<li><a href='teacherProjectInfoPage.htm?projectId="+values.id+"' style='color:blue'>项目待启动&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
				"<li><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'>详细信息</a></li>"+
				"</ul>"+
				"</div>"+
				"</div>"+
				"</div>";
	}else if(values.projectStatus==41){//暂停中
		divValues += "<div class='xiangmuList'>" +
									"<div class='xiangmuName'>"+
				"<table border='0' cellspacing='0' cellpadding='0'>"+
				"<tr>"+
				"<td rowspan='2'><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'><img src='../../images/2014101405.jpg' width='150' height='150' /></a></td>"+
				/*"<td style='padding-left:10px;'><h5>"+values.projectName+"<b>"+"（共"+values.planNum+"人）"+"</b></h5></td>"+*/
				"<td style='padding-left:10px;'><font color='"+color+"' style='font-size:17px'>"+values.projectName+"</font></td>"+
				"</tr>"+
				"<tr>"+
				"<td style='padding-left:10px;'><h4><b>"+"（共"+values.planNum+"人）"+"</b></h4><span>开始时间："+startDate+"</span><br /><span>结束时间："+endDate+"</span></td>"+
				"</tr>"+
				"</table>"+
				"<p>介绍："+values.memo+"</p>"+
				"<div class='xiangmu_study'>"+
				"<ul>"+
				"<li><a href='teacherProjectInfoPage.htm?projectId="+values.id+"' style='color:blue'>项目暂停中，请稍后...&nbsp;&nbsp;&nbsp;&nbsp;</a></li>"+
				"<li><a href='teacherProjectInfoPage.htm?projectId="+values.id+"&click="+click+"'>详细信息</a></li>"+
				"</ul>"+
				"</div>"+
				"</div>"+
				"</div>";
	}
			$('#teacherProjectList').html(divValues);
			}
			}
		},
		error:function(){
			alert("查询错误");
		}
	});
}

function showWindow(url) {
	window.location.href = url;
}

//去学习---查询机构
function goStaty(id){
	$("#choose1").fadeIn(200);
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherProjectOrganization.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:id
		},
		success:function(data){
			if(data.success) 
			{
			var objList = data.infoList;
			if(objList.length ==0){
				alert("没有符合条件的机构！");
				return ;
			}
			 var divValues ="" ;
			 var projectName = "";
			for(var i = 0 ;i<objList.length;i++){
				var values = objList[i];
			   divValues += "<input type='radio' name='radio' value='"+values.organizationId+","+values.projectId+","+values.trainingAddress+"'>" +values.organizationName
				"</input>";
			   projectName = values.projectName;
			}
			$('#projectName').html(projectName);
			$('#organizationName').html(divValues);
			
			}
		},
		error:function(){
			alert("查询错误");
		}
	});
	
	function openNewWindow(urlGo){
		window.open(URL);
		
	}
}

function viewFiles(projectId,orgId,pName){
	$("#projectName2").html(pName+"的培训材料");
	$("#viewTable").html('');//清空内容
	var url = pathHeader + "/fileupload/otherViewFiles.do?time="
	+ (new Date()).getTime();
	$.ajax({
  		dataType: 'json',  
  		url:url,
  		cache:false,
  		type:'post',
  		data : {
			projectId : projectId,
			type : "trainingMaterials"
		},
  		success:function(data){
  			if(data.files.length>0){
  				var table = "<tr><td width='5%'>序号</td><td width='40%'>文件名</td><td width='15%'>上传人</td><td width='20%'>上传时间</td><td colspan='2' width='20%'>操作</td><tr>";
				$
						.each(
								data.files,
								function(i, item) {
									table += "<tr><td>"
										+ (i + 1)
										+ "</td><td><a href='javascript:void(0)'; onclick='previewFile(\""+item.url+"\");'>"
										+ item.name
										+ "</a></td><td>"+item.userName+"</td>"
										+ "<td>"+nullFormatter(item.createDate.replace(".0",""))+"</td><td>"
										+ "<a href='#' onclick=downloadFile('"
										+ item.url
										+ "') >下载 </a></td>"
										+ "</td></tr>";
								});
				$("#viewTable").html(table);
				$('#trainingViewModal').modal('show');
  			}else{
  				$("#viewTable").html("还未上传培训材料");
  				$('#trainingViewModal').modal('show');
  			}
  		},
  		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("查询数据出错！请联系管理员");
		}
  	});
}

//结束
//下载文件
function downloadFile(filePathName){
	//下载能使用jquery的ajax，因为ajax的返回值不支持流
	var url =  pathHeader + '/org/downloadFile.do';
	var form= $("<form>");//定义一个form表单
	form.attr("style","display:none");
	form.attr("method","post");
	form.attr("action",url);
	var input=$("<input>");
	input.attr("type","hidden");
	input.attr("name","filePathName");
	input.attr("value",filePathName);
	$("body").append(form);//将表单放置在web中
	form.append(input);
	form.submit();//表单提交
}


//去学习2---查询机构URL
function goStatyByPro(id,organizationId){
	$.ajax({
		url : pathHeader + "/teacher/teacherProject/teacherProjectOrganization.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId:id,
			organizationId:organizationId
		},
		success:function(data){
			if(data.success) 
			{
				var objList = data.infoList;
				var teacherUuid = data.teacherUuid;
				var url;
				var flag = true; //接口地址是否为空标识
				
				for(var i = 0 ;i<objList.length;i++){
					var obj = objList[i];

					if(obj.trainingAddress==null || obj.trainingAddress.length==0 || obj.trainingAddress=="http://"){
						flag = false;
						
					}else{
						if(obj.trainingAddress.indexOf("?") != -1){
							url = obj.trainingAddress+"&teacherUuid="+teacherUuid;
						}else{
							url = obj.trainingAddress+"?teacherUuid="+teacherUuid;
						}
					}
				 }
				
				 if(!flag){
					 jQuery.generalAlert("此项目未设置培训平台地址, 请先设置培训平台地址!");
				 }else{
					 window.open(url);
				 }
			}
		},
		error:function(){
			alert("学习链接查询错误");
		}
	});
	
	function openNewWindow(urlGo){
		window.open(URL);
		
	}
}