$(function(){
	$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$("#close").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
			
		});
$('#tanqi2').hide();
 $(".select1").uedSelect({
		width : 345			  
	});

	$(".select3").uedSelect({
		width : 100
	});
	$('#tanqi').hide();
	$('#setSignup').click(function(){
			
			$('#tanqi').show();
			
		}
	);
	$('#btnOK').click(function(){
		saveOP();
		})
	$('#btnQX').click(function(){
	  $('#tanqi').hide();
	  })
	orgList();
	opList();
});

function show2(){
$('#tanqi2').show();
}


function orgList(){
//	$('#orgList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/edupm/projectmanage/orgListByArea.do";
	$.ajax({
		url:url,
		data:{
		proId:proId
//		startIndex:pageIndex
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				$("#projectName").html(data.projectName);
				$("#planNum").html(data.planNum);
				$("#projectName2").html(data.projectName);
				$("#planNum2").html(data.planNum);
				$("#projectName3").html(data.projectName);
				createSelectArea(data.subjectName,data.subjectId,"selectS");
//				createSelectArea(data.trainScopeName,data.trainScopeId,"selectA");
				var rows = data.rows;
				if(rows.length>0){
					var opts = "";
				$.each(rows, function(index,element) {
					opts += "<option value="+element.organizationId+">"+element.organizationName+"</option>";
				});
				$("#orgs").append(opts);
				$(".select2").uedSelect({
							width : 167  
						});
				}
			}
		},
		error:function(){
			jQuery.generalAlert("url error");
		}
		
	});
}
/**
 * 已分配机构列表
 */
function opList(){
	$('#orgList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/edupm/projectmanage/poList.do";
	$.ajax({
		url:url,
		data:{
		projectId:proId,
		startIndex : pageIndex
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#orgList').append(gridHtml);
				pagination(data, function(){opList();});
			}else{
				$('#orgList').html("<tr><td colspan='12'>无查询记录</td></tr>");
			}
			}
		},
		error:function(){
			jQuery.generalAlert("url error ！")
		}
		
	});
	
}

function getTdHtml(obj){
		var s = "";
	if(obj.projectStatus == 1){
		s = "准备中";
	}else if(obj.projectStatus == 2){
		s = "正在进行中";
	}else{
		s = "已结束";
	}
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml += "<td>"+(obj.planNum==null?"":obj.planNum)+"</td>";
	gridHtml += "<td>"+(obj.classSubjectName==null?"":obj.classSubjectName)+"</td>";
	gridHtml += "<td>"+(obj.areaName==null?"":obj.areaName)+"</td>";
	gridHtml += "<td>"+s+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
			returnStr += 	 "<a href='###' class='tablelink' onclick='toSetOrg(" + row.id + ",\""+row.organizationName+"\","+row.projectId+");'>分配任务</a>&nbsp;&nbsp;&nbsp;";
			returnStr += 	 "<a href='###' class='tablelink' onclick='del(" + row.id + ",\""+row.projectId+"\");'>取消</a>";
		return returnStr;
	}
}


function saveOP(){
	var opt = getSelected("orgs");
	var url = pathHeader + "/edupm/projectmanage/saveOP.do";
	$.ajax({
		url:url,
		data:{
		projectId:proId,
		orgId:opt.value,
		orgName:opt.text
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success != -1){
				if(data.success){
				$('#tanqi').hide();
				opList();
				}
			}else{
				jQuery.generalAlert("该机构已经被分配给该项目，不能重复分配！");
				$('#tanqi').hide();
				opList();
			}
		},
		error:function(){
			jQuery.generalAlert("url error！")
		}
		
		
	});
}

function toSetOrg(id,name,projectId){
	var url = pathHeader + "/edupm/projectmanage/hasTeacherEnter.do";
	$.ajax({
		url:url,
		data:{projectId:projectId},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				if(data.has){
					$("#toSelectA").attr("disabled",true);
					$("#toSelectS").attr("disabled",true);
				}
			}
		},
		error:function(){
			
		}
		
	});
	$("#orgName2").html(name);
	$("#opId").val(id);
	$(".tip").fadeIn(200);
}

function setOrg(){
	var opId = $("#opId").val();
	var planNum = $("#pnToOrg").val();
	var area = $("#area").val();
	var subjectName = $("#subjectName").val();
	var url = pathHeader + "/edupm/projectmanage/setOPOtherInfo.do";
	if(planNum.length ==0){
		jQuery.generalAlert("请输入计划人数！");
		return;
	}
	$.ajax({
		url:url,
		data:{
			id:opId,
			planNum:planNum,
			areaName:area,
			subjectName:subjectName,
			areaCode:$("#areaCode").val(),
			proId:proId,
			subjectId:$("#subjectId").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				$(".tip").fadeOut(100);
				opList();
			}
		},
		error:function(){
			jQuery.generalAlert("url Error！");
		}
	});
}

function toSelectArea(){
	$("#selectSubject").fadeOut(100);
	$("#selectArea").fadeIn(100);
}

function toSelectSubject(){
	$("#selectArea").fadeOut(100);
	$("#selectSubject").fadeIn(100);
}

/**
 * 创建选择区域
 * @param {Object} subjects
 */
function createSelectArea(subjectNames,subjectIds,divId){
	$("#"+divId).html("");
	var html = "<li>";
	var names = subjectNames.split(",");
	var ids = subjectIds.toString().split(",");
	for(var i = 0;i<names.length;i++){
		name = names[i];
		id = ids[i];
		var str = "<li>";
		str += "<input type='checkbox' name='"+name+"' value='"+id+"'>"+name+"</li>";
		html += str;
	}
	$("#"+divId).html(html);
}

function hideMe(){
	$("#selectSubject").fadeOut(100);
	$("#selectArea").fadeOut(100);
}

function setArea(){
	var names = "";
	var ids = "";
	$("#selectA").find("input[type='checkbox']:checked").each(function(){
		names += $(this).attr("name")+",";
		ids += $(this).val()+","
	});
	if(names.length>0 && ids.length>0){
		$("#areaCode").val(ids.substring(0,ids.length-1));
		$("#area").val(names.substring(0,names.length-1));
		hideMe();
		clearCheckBox();
	}else{
		jQuery.generalAlert("请至少选择一个地点！");
	}
}


function setSubject(){
	var names = "";
	var ids = "";
	$("#selectS").find("input[type='checkbox']:checked").each(function(){
		names += $(this).attr("name")+",";
		ids += $(this).val()+","
	});
	if(names.length>0 && ids.length>0){
		$("#subjectId").val(ids.substring(0,ids.length-1));
		$("#subjectName").val(names.substring(0,names.length-1));
		hideMe();
		clearCheckBox();
	}else{
		jQuery.generalAlert("请至少选择一个学科！");
	}
}



function clearCheckBox(){
	$("input[type='checkbox']").each(function(){
		$(this).attr("checked",false);
	});
}
/**
 * 为一个机构分配了任务后，清空已分配的任务
 */
function clearInfo(){
	$("#subjectId").val("");
	$("#subjectName").val("");
	$("#areaCode").val("");
	$("#area").val("");
	$("#pnToOrg").val("");
}

function del(id,projectId){
	var url = pathHeader + "/edupm/projectmanage/cancelOP.do";
	$.ajax({
		url:url,
		data:{
		projectId:projectId,
		id:id
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success == -1){
				jQuery.generalAlert("已经有教师报名项目，不能取消该机构！");
			}else{
				opList();
			}
		},
		error:function(){
			
		}
		
	});
}

function lastForSure(){
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1]
		var text = conditionArray[2]
		var str = $("#ts").val();
		$("#areaCode").val(belone);
		$("#area").val(text);
	}
	clear();
}