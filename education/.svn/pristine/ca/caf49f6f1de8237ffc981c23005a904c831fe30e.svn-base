$(document).ready(function(e) {
		getProjectList();
		// 条件查询
		$("#select").click(function() {
			getProjectList();
		});

		$("#rdoAdd").click(function(){
			$("#txtAdd").focus();
			$("#txtAdd").removeAttr('disabled');
			$("#txtSub").val("");
			$("#txtGive").val("");
			$("#txtSub").attr('disabled','disabled');
			$("#txtGive").attr('disabled','disabled');
		});
		
		$("#rdoSub").click(function(){
			$("#txtSub").removeAttr('disabled');
			$("#txtAdd").val("");
			$("#txtGive").val("");
			$("#txtAdd").attr('disabled','disabled');
			$("#txtGive").attr('disabled','disabled');
			$("#txtSub").focus();
		});
		
		$("#rdoGive").click(function(){
			$("#txtGive").removeAttr('disabled');
			$("#txtSub").val("");
			$("#txtAdd").val("");
			$("#txtSub").attr('disabled','disabled');
			$("#txtAdd").attr('disabled','disabled');
			$("#txtGive").focus();
		});
		
		$("#batchModify").click(function(){
			batchUpdate();
		});
		
		$("#cancelModify").click(function(){
			$(".tip").fadeOut(200);
		});
});

function getProjectList(){
	$('#target').html('');
	
	var isScorePublished=$('#isScorePublished').val(); //是否已公布成绩
	var pageIndex = $("#pageIndex").val();
	var projectName = $('#projectName').val();
	var projectYear = $('#projectYear').find("option:selected").val();
	var trainType = $('#trainType').find("option:selected").val();
	
	$.ajax({
		url : pathHeader + '/org/orgScorePublishListUpdate.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : projectName,
			projectYear : projectYear,
			trainType :trainType,
			isScorePublished:isScorePublished,
			pageIndex : pageIndex,
			pageSize:10
		},
		success:function(data){
			if(data.success) {
				var rows = data.rows;
				var areaId = data.areaId;
				var orgId = data.orgId;
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId,orgId);
				});
				$('#target').append(gridHtml);
				pagination(data, function() {getProjectList();});
			} else {
				gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";
				if(isScorePublished==0){
					$('#target').html('');
					$('#target').append(gridHtml);
				}else{
					$('#target2').html('');
					$('#target2').append(gridHtml);
				}
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='11'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 
}

function getTdHtml(obj,areaId,orgId){
	
	var gridHtml = "<tr>";		
	//实施机构、 创建项目者所属地区和登陆者地区相同，方可查看项目信息。
	
//	if (obj.createByArea == areaId || obj.organizationId == orgId) {
		gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>" + obj.projectName + "</a></td>";
//	} else {
//		gridHtml += "<td>" + obj.projectName + "</td>";
//	}
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.attendNum+"</td>";
	gridHtml += "<td>"+obj.shenheNum+"</td>";	
	gridHtml += "<td>"+obj.auditor+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
			/*returnStr += 	 "<a href='###' class='tablelink' onclick='stopSign(\"" + row.projectId + "\");'>结束报名</a>&nbsp;&nbsp;&nbsp;";*/
			//实施机构、 创建项目者所属地区和登陆者地区相同，方可修改。
//			if (obj.createByArea == areaId || obj.organizationId == orgId) {
			//returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.projectId + "\",\"" + row.projectName + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
				
				returnStr += "<a href='orgScoreModifyPage.htm?click=33&projectId="+row.projectId+ "&projectName="+row.projectName+ "' class='tablelink'>修改</a>&nbsp;&nbsp";
				returnStr += "<a href='#' onclick='showPopWindow(" +row.projectId+ ",\""+row.projectName+ "\");' class='tablelink'>批量修改</a>&nbsp;&nbsp";
//			}
//			else{
//				returnStr += "";
//			}
		
		return returnStr;
	}
}

function showPopWindow(pid, pname){
	$("#lblProjectName").text(pname);
	$("#txtProjectId").val(pid);
	$(".tip").fadeIn(200);
	//modifyScore单选按钮默认选中
	showScoreModifyInfo();
	 
}

function showScoreModifyInfo(){
	$("#modifyScore").attr("checked",true);
	$(".periodTip").css("display","none");
	$(".scoreTip").css("display","block");
}
function showPeriodModifyInfo(){
	//$("#modifyPeriod").click(function(){
		$(".scoreTip").css("display","none");
		$(".periodTip").css("display","block");
	//});
}
function periodValidate(obj){
	//var b = /^[0-9]+$/;
	var b = /^[0-9]*[1-9][0-9]*$/;
	var patt1 = new RegExp(b);
	var result = patt1.test(obj);
	return result;
}
function batchUpdate(){
	var projectId= $("#txtProjectId").val();
	//alert("pid="+projectId);
	var start = $("#txtScoreStart").val(); //成绩开始范围
	var end = $("#txtScoreEnd").val();	//成绩结束范围
	var addScore=""; //修改分数
	var method=""; //修改方式
	var period="";
	
	 //如果选中修改培训学时
   var selectedRadio =$("input[name=modifyGroup]:checked").attr("id");
   if(selectedRadio == 'modifyPeriod'){
	   method = 'modifyPeriod';
	   period = $("#givePeriod").val();
	   if($("#givePeriod").val() === "" || $("#givePeriod").val() === null){
		   jQuery.generalAlert("请输入要修改的培训学时！");
		   $("#givePeriod").focus();
		   return;
	   }
	   if(!periodValidate(period)){
		   jQuery.generalAlert("培训学时必须是正整数！");
		   $("#givePeriod").focus();
		   return;
	   }
   }else{
		if(start ==="" || start === null){
			jQuery.generalAlert("请输入成绩的开始范围");
			$("#txtScoreStart").focus();
			return;
		}
		if(end ==="" || end === null){
			jQuery.generalAlert("请输入成绩的结束范围");
			$("#txtScoreEnd").focus();
			return;
		}
		//转换成int 类型进行比对
	    var startScore = parseInt(start);
	    var endScore = parseInt(end);    
		if(startScore > endScore){
			jQuery.generalAlert("成绩范围有误,请重新输入.");
			$("#txtScoreStart").val("");
			$("#txtScoreEnd").val("");
			$("#txtScoreStart").focus();
			return;
		}
		
	   var selectedRadio =$("input[name=scoreGroup]:checked").val();
	   //alert(selectedRadio);
	   if(!selectedRadio){
		   jQuery.generalAlert("请选择修改方式!");
			return;
	   } 
	   if(selectedRadio==="add"){
		   method="add";
		    addScore = $("#txtAdd").val();
		   if(addScore ===""){
			   jQuery.generalAlert("请输入分数!");
			   $("#txtAdd").focus();
				return;
		   }
	   }
	   if(selectedRadio==="sub"){
		   method="sub";
		   addScore = $("#txtSub").val();
		   if(addScore ===""){
			   jQuery.generalAlert("请输入分数!");
			   $("#txtSub").focus();
				return;
		   }
	   }
	   if(selectedRadio==="give"){
		   method="give";
		    addScore = $("#txtGive").val();
		   if(addScore ===""){
			   jQuery.generalAlert("请输入分数!");
			   $("#txtGive").focus();
				return;
		   }
	   }
   }
   $.ajax({
		url : pathHeader + '/org/orgScoreBatchUpdate.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId : projectId,
			method : method,
			addScore :addScore,
			start : start,
			end:end,
			period:period
		},
		success:function(data){
			if(data) {
				jQuery.generalAlert("批量修改成绩成功!");
				$(".tip").fadeOut(200);
			} else {
				jQuery.generalAlert("批量修改成绩失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("批量修改成绩.错误!");
		}
	}); 
}
 