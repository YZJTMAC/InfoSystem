$(function(){
	queryTeacher(areaId);
	initSelect();
	var projectId= GetURLParameter('projectId');
	 $.post(pathHeader + '/org/orgTeacherForReportList.do?projectId='+projectId,function(result){
		 var myJsonString = JSON.stringify(result);
		 var zNodes =eval("(" + myJsonString + ")");
		 $.fn.zTree.init($("#treeDemo2"), setting2,zNodes);   
	 });
})
function initSelect(){
	
	 $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

}

function queryTeacher(id){
	areaId = id;
	$("#proList1").html("");
	var realName=$("input[name='input']").val();
	var schoolTypeId=$('#schoolTypeId').val();
	var startIndex = $("#pageIndex").val();
	var pageSize = $("#sizePerPage").val();
	var url = pathHeader + "/edupm/projectmanage/queryTeacherListByArea.do";
	var teacherStatus = "";
	$.ajax({
		url:url,
		data:{
		areaId:id,
		realName:realName,
		subject:schoolTypeId,
		startIndex:startIndex,
		pageSize:pageSize,
		projectId:projectId,
		reportType:0
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				var gridHtml = "";
				$.each(rows,function(index,element){
					gridHtml += getTdHtml(element);
				});
				pagination(data, function(){queryTeacher(areaId);});
				$("#proList1").html(gridHtml);
			}
			
		},
		error:function(){
			
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td><input name='tid' type='checkbox' value='"+obj.id+"'></td>";
	gridHtml += "<td>"+obj.name+"</td>";
	gridHtml += "<td>"+obj.idNO+"</td>";
	gridHtml += "<td>"+obj.subject+"</td>";
	gridHtml += "<td>"+obj.province+"</td>";
	gridHtml += "<td>"+obj.city+"</td>";
	gridHtml += "<td>"+obj.district+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+obj.mobile+"</td>";
	gridHtml += "<td>"+(obj.signStatus==0?'未报名':obj.status ==13?'审核通过':obj.status==12?'审核未通过':'等待审核')+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml +="</tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var status = row.status;
		var returnStr = "";
		if(obj.signStatus==0){
			returnStr += "<a href='###' class='tablelink' onclick='signUp("+row.schoolId+","+row.id+");'>报  名</a>&nbsp;&nbsp;";
		}
		else if(status == 12){
			returnStr += "<a href='###' class='tablelink' onclick='signUp("+row.schoolId+","+row.id+");'>重新报名</a>&nbsp;&nbsp;";
			returnStr += "<a href='###' class='tablelink' onclick='deleteTeacher("+row.id+","+row.projectId+");'>取消报名</a>&nbsp;&nbsp;";
		}
		else if(status == 11){
			returnStr += "<a href='###' class='tablelink' onclick='deleteTeacher("+row.id+","+row.projectId+");'>取消报名</a>&nbsp;&nbsp;";
		}
		
		return returnStr;
	}
}



function deleteTeacher(teacherId,projectId){
	$.ajax({
		/*url : pathHeader + "/teacher/teachermanage/removeTeacher.do",*/  //假删教师信息
		url : pathHeader + "/edupm/projectmanage/deleteTeacher.do",   //真删教师信息
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{teacherIds:teacherId,projectId:projectId,schoolID:0},
		success:function(data){
			
			if(data.success) { 
				queryTeacher(areaId);
			} else {
				alert("删除失败");
				queryTeacher(areaId);
			}
		},
		error:function(){
		}
	});
	
}

/**
 * 报名
 * @param {Object} id
 */
function signUp(schoolId,id){
	var url = pathHeader + "/edupm/projectmanage/signUp.do";
	$.ajax({
		url:url,
		data:{areaId:schoolId,teacherId:id,projectId:projectId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success && data.sign){
				queryTeacher(areaId);
			}			
//				alert("报名失败，请确认是否符合报名条件！");				
				if(!data.success){
					jQuery.generalAlert("报名失败！"+data.result);
				}
				else{
					if(!data.sign){
						showAlert();
					}
				}				
		},
		error:function(){
			alert("URL ERROR !");
		}
		
	});
}
function showAlert(){
	$("#alertDiv").show();
}
function hideAlert(){
	$("#alertDiv").hide();
}


/*function getAreaList(){
	$.ajax({
		url : pathHeader + '/org/orgTeacherForReportList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			 
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				alert("success.")
				 
			} else {
				alert("failure.")
			}
		},
		error:function(){
			alert("error.")
		}
	});
}*/

var setting2 = {
		view: {
			dblClickExpand: false,
			showLine: true,
			showIcon: false
		},
	async: {
		enable: true,
		url:pathHeader + '/org/orgTeacherForReportList.do?projectId='+ GetURLParameter('projectId'),
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
	  		
//	  		getUserListForArea();
	  		queryTeacher(treeNode.id);
}
function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
//	alert(childNodes);
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}


function bathSignUp(){
	var teacherId = [];
	$("input[name='tid']:checked").each(function(){		
		teacherId.push($(this).val());
	});
	if(teacherId.length ==0){
		jQuery.generalAlert("请选择要报名的教师！");
		return;
	}
	var url = pathHeader + "/edupm/projectmanage/bathSignUp.do";
	$.ajax({
		url:url,
		data:{areaId:areaId,teacherIds:teacherId.toString(),projectId:projectId},
		type:"post",
		async:true,
		success:function(data){
			//如果有不符合条件的教师，查询出来
			if(data.success){
				if(data.teachers.length != 0){
					var thtml = "";
					var teachers = data.teachers;
					for(var i=0;i<teachers.length;i++){
						var teacher = teachers[i];
						thtml +="<tr><td>"+teacher.name+"</td><td>"+teacher.idNO+"</td></tr>";
					}
					$("#orgStatus").html(thtml);
					$("#tip").show();
					$("input[name='tids']").attr("checked",false);
					queryTeacher(areaId);
//					alert(data.teachers.length);
				}
				else{
					queryTeacher(areaId);
				}
			}else{				
				jQuery.generalAlert("报名失败！" +data.result);
			}
			
		},
		error:function(){
			jQuery.generalAlert("报名失败！");
		}
		
	});
}

//批量选中
$(function(){
	$("input[name='tids']").click(function(){
		if($(this).attr("checked") == "checked"){
			$("input[name='tid']").attr("checked",true);
		}else{
			$("input[name='tid']").attr("checked",false);
		}
		
	});
})

function hideMe(){
	$("#tip").hide();
}


/**
 * 查询项目
 */
function qryPro(){
	queryTeacher(areaId);
}



