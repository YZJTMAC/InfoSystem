$(document).ready(function(e) {
	var projectName=GetURLParameter('projectName');
	$('#pname').html(decodeURIComponent(projectName));

	getUserList();
	
	$("#select").click(function() {
		getUserList();
	});
	
	var projectId= GetURLParameter('projectId');
	 $.post(pathHeader + '/org/orgAreaList.do?projectId='+projectId,function(result){
		 var myJsonString = JSON.stringify(result);
		 var zNodes =eval("(" + myJsonString + ")");
		 $.fn.zTree.init($("#treeDemo2"), setting2,zNodes);   
	 });
	 
	 $("#all").click(function(){
		if($("#all").attr("checked")){
			$("input[name='teacher']").each(function(){
				$(this).attr("checked",true);
			});
		}else{
			$("input[name='teacher']").each(function(){
				$(this).attr("checked",false);
			});
		}
	});
	 
	$("#cancel").click(function(){
		$(".tip").fadeOut(100);
	});
	 
	$("#save").click(function(){
		modifyTeacherTrainStatus();
	});
});

function getUserList(){
	$('#target').html('');
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var teacherName=$('#txtTeacherName').val();
	var schoolType = $("#txtSchoolType").val();
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	$.ajax({
		url : pathHeader + '/org/orgScoreModifyList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId: GetURLParameter('projectId'),
			province: province,
			city: city,
			district:district,
			school:school,
			schoolType:schoolType,
			teacherName:teacherName,
			pageIndex : pageIndex,
			pageSize:sizePerPage
		},
		success:function(data){
			if(data.success) {
				var gridHtml = "";
				var objList = data.rows;
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#target').append(gridHtml);
					
				pagination(data, function() {getUserList();});
			}else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#target').append(gridHtml);
				$('#pagebar').html('');
			}		
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 

}

function getTdHtml(obj){
	var gridHtml = "<tr>";	
	gridHtml += "<td><input type='checkbox' name='teacher' value='"+obj.id+"'></td>";
	gridHtml += "<td>"+obj.realName+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+ (obj.teacherScore == null ? '' : obj.teacherScore) +"</td>";
	gridHtml += "<td>"+ (obj.teacherClassPeriod == null ? '' : obj.teacherClassPeriod)+"</td>";
	gridHtml += "<td>"+ (obj.trainStatusName == null ? '' : obj.trainStatusName)+"</td>";
	gridHtml += "<td><a name='btn_bc' onclick='showAuditBox("+ obj.id +");'  href='#' class='tablelink'>审 核</a>&nbsp;&nbsp;</td>";	
	gridHtml += "</tr>";
	return gridHtml;
}

//单个审核框
function showAuditBox(id){
	$("#procommentId").val(id);
	$(".tip").fadeIn(200);
}

//批量/全部审核框
function showBatchAuditBox(type){
	if(type==1){
		$("#projectId").val("");
		
		var length = $("input[name='teacher']:checked").length;
		if(length==0){
			jQuery.generalAlert("请至少选择一个要审核的教师！");
			return ;
		}else{
			var ids = "";
			$("input[name='teacher']:checked").each(function(){
				ids += $(this).val()+",";
			});
			
			$("#procommentId").val(ids.substring(0,ids.length-1));
		}
		
	}else{
		$("#procommentId").val("");
		
		var projectId = GetURLParameter('projectId');
		$("#projectId").val(projectId);
	}
	
	$(".tip").fadeIn(200);
}

function modifyTeacherTrainStatus(){
	var projectId = $("#projectId").val();
	var ids = $("#procommentId").val();
	var trainStatusId = $("input[name='trainStatus']:checked").val();
	$(".tip").fadeOut(100);
	
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/auditTeacherTrainStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId: projectId,
			paramProjectId: GetURLParameter('projectId'),
			ids: ids,
			trainStatusId: trainStatusId
		},
		success:function(data){
			if(data){
				getUserList();
			} else {
				jQuery.generalAlert("审核失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("错误.");
		}
	});
}

function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

var setting2 = {
		view: {
			dblClickExpand: false,
			showLine: true,
			showIcon: false
		},
	async: {
		enable: true,
		url:pathHeader + '/org/orgAreaList.do?projectId='+ GetURLParameter('projectId'),
		autoParam:["id","type","isSchool","pId=pid"],
		otherParam:{"otherParam":"zTreeAsyncTest"},
		dataFilter: filter
	},
	callback: {
		onClick: onClick
	}
	
};

function onClick(e,treeId, treeNode) {
	//  alert(treeNode.id + ", -" + treeNode.name+", " + treeNode.type+",isSchool= " + treeNode.isSchool);
	if(treeNode.isSchool ==="true"){ //学校类型
		$("#txtSchoolType").val(treeNode.type);
		$("#txtDistrictId").val(treeNode.pId);
	}else if(treeNode.isSchool ==="school"){ //学校类型
		$("#txtSchoolId").val(treeNode.id);
		$("#txtDistrictId").val(treeNode.pId.split(",")[0]);
	}else{
		var type=treeNode.type;
		if(type=="0"){
  			$("#txtProvinceId").val(treeNode.id);
  			$("#txtCityId").val("");
  			$("#txtDistrictId").val("");
  			$("#txtSchoolId").val("");
		}else if(type=="1"){
  			$("#txtCityId").val(treeNode.id);
  			$("#txtDistrictId").val("");
  			$("#txtSchoolId").val("");
		}else if(type=="2"){
  			$("#txtDistrictId").val(treeNode.id);
  			$("#txtSchoolId").val("");
		}
	}
	  		
	getUserList();
}


function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
//	alert(childNodes);
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}