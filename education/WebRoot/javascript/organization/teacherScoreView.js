$(function(){
	var projectId = GetURLParameter('projectId');
	var projectName = GetURLParameter('projectName');
	$('#pname').html(decodeURIComponent(projectName));
	
	$("#select").click(function() {
		getUserList();
	});
	
	getUserList();
	
	$.post(pathHeader + '/org/orgAreaList.do?projectId='+projectId,function(result){
		var myJsonString = JSON.stringify(result);
		var zNodes =eval("(" + myJsonString + ")");
		$.fn.zTree.init($("#treeDemo2"), setting2,zNodes);   
	});
});
 


function getUserList(){
	$('#target').html("");
	
	var pageSize = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	var province = $("#txtProvinceId").val();
	var city = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var schoolType = $("#txtSchoolType").val();
	var teacherName = $('#txtTeacherName').val();
	
	/*put("直接公布分数",1);
	put("按是否合格公布",2);
	put("按四等级公布",3);*/
	var publishRule="3"; //成绩公布规则
	var levelRule="2,3,4";//成绩分布的等级划分规则
	publishRule = GetURLParameter('pubRule');
	levelRule = GetURLParameter('lvRule');
	
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
			district: district,
			school: school,
			schoolType: schoolType,
			teacherName: teacherName,
			pageIndex : pageIndex,
			pageSize: pageSize
		},
		success:function(data){
			if(data.success) {
				var rows = data.rows;
				if(rows.length > 0){
					var gridHtml = "";				
					$.each(rows, function(index,element) {
						gridHtml += getTdHtml(element,publishRule,levelRule);
					});
					$('#target').append(gridHtml);
				}
				else{
					gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";				
					$('#target').append(gridHtml);		
				}
				
				pagination(data, function() {
					getUserList();
				});
				 
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				$('#target').append(gridHtml);
				$('#pagebar').html('');
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='4'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 

}

function getTdHtml(obj,pubRule,lvRule){
	var gridHtml = "<tr>";		
	gridHtml += "<td>" + obj.realName + "</td>";
	gridHtml += "<td>"+ obj.schoolName +"</td>";
	gridHtml += "<td>"+ optionFormatter(obj.teacherScore) +"</td>";
	gridHtml += "<td>"+ obj.teacherClassPeriod +"</td>";
	gridHtml += "<td>"+ obj.auditScore +"</td>";
	gridHtml += "</tr>";
	return gridHtml;
	
	function optionFormatter(score){
		var returnStr = "";
		
		if(pubRule=="2"){
			if(score >= lvRule){
				returnStr = '合格';
			}else{
				returnStr = '不合格';
			}
			
		}else if(pubRule=="3"){
			var levels = lvRule.split(",");
			var levelC = levels[0];//中
			var levelB = levels[1];//良好
			var levelA = levels[2];//优秀
			if(score >= levelA){
				returnStr = '优';
			}else if(score >= levelB){
				returnStr = '良';
			}else if(score >= levelC){
				returnStr = '合格';
			}else{
				returnStr = '不合格';
			}
			
		}else{
			returnStr = score;
		}
		
		return returnStr;
	}
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

function getUserListForArea(){
	$('#target').html("");
	
	var pageSize = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var schoolType = $("#txtSchoolType").val();
	var teacherName = $('#txtTeacherName').val();
	var publishRule = "3"; //成绩公布规则
	var levelRule = "2,3,4";//成绩分布的等级划分规则
	publishRule = GetURLParameter('pubRule');
	levelRule = GetURLParameter('lvRule');
	
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
			district: district,
			school: school,
			schoolType: schoolType,
			teacherName: teacherName,
			pageIndex : pageIndex,
			pageSize: pageSize
		},
		success:function(data){
			if(data.success) {
				var rows = data.rows;
				
				if(rows.length > 0){
					var gridHtml = "";				
					$.each(rows, function(index,element) {
						gridHtml += getTdHtml(element,publishRule,levelRule);
					});
					$('#target').append(gridHtml);
					$('.tablelist tbody tr:odd').addClass('odd');
				}
				else{
					gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";				
					$('#target').append(gridHtml);		
				}
				
				pagination(data, function() {
					getUserListForArea();
				});
				 
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				$('#target').html(gridHtml);
				$('#pagebar').html('');
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='4'>错误,暂无查询结果！</td></tr>";
			$('#target').html(gridHtml);
			$('#pagebar').html('');
		}
	}); 

}

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
	
	getUserListForArea();
}


function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}

	 