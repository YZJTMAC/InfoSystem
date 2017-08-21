$(document).ready(function(e) {
	var projectName=GetURLParameter('projectName');
	$('#pname').html(decodeURIComponent(projectName));
	//getAreaList();
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

	
});

/*function getAreaList(){
	$.ajax({
		url : pathHeader + '/org/orgAreaList.do',
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
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#target').append(gridHtml);
				$('#pagebar').html('');
			}		
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 

}

function getTdHtml(obj){
	var gridHtml = "<tr>";		
	gridHtml += "<td>"+obj.realName+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td><input type='text' class='scinput' style='width: 80px;' id='t_score' value='"+ (obj.teacherScore == null ? '' : obj.teacherScore) +"'/></td>";
	gridHtml += "<td><input type='text' class='scinput' style='width: 80px;' id='t_period' value='"+ (obj.teacherClassPeriod == null ? '' : obj.teacherClassPeriod)+"'/></td>";
	gridHtml += "<td><a name='btn_bc' onclick='modifyScore(this,"+ obj.projectId +","+ obj.id +");'  href='#' class='tablelink'>保存</a>&nbsp;&nbsp;</td>";	
	gridHtml += "</tr>";
	return gridHtml;
}
/*function formatProject(projectList) {
	  var template = $('#template').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  
	  var obj = eval('(' + projectList + ')');
	  var rendered = Mustache.render(template,obj);
	  $('#target').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
	}*/

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

/*function getUserListForArea(){
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var teacherName=$('#txtTeacherName').val();
	var schoolType = $("#txtSchoolType").val();
	var projectId;
	var pageIndex =0;
	var pageSize =20;
	
	
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
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				var myJsonString = JSON.stringify(objList);
				var str = '{"users":'+myJsonString +'}';
				//document.write(str);
					formatProject(str) ;
					pagination(data, function() {
						getUserListForArea();
					});
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
					$('#target').html(gridHtml);
					$('#pagebar').html('');
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>错误,暂无查询结果！</td></tr>";
			$('#target').html(gridHtml);
			$('#pagebar').html('');
		}
	}); 

}*/

function onClick(e,treeId, treeNode) {
	//  alert(treeNode.id + ", -" + treeNode.name+", " + treeNode.type+",isSchool= " + treeNode.isSchool);
		
	  		if(treeNode.isSchool ==="true"){ //学校类型
//	  			alert('小学');
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
	  		
//	  		getUserListFrArea();
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


//修改button click
function modifyScore(a,pid,tid  ){
//	alert("hi"); 
//	alert(score);
//	alert(tid);
//	alert(pid);
//	alert(a);
	//var score = $( a ).parent().prev().find('input').val();
	//获取培训成绩
	var teacherScore = $( a ).parent().prev().prev().find('#t_score').val();
	//获取培训学时
	var teacherPeriod = $( a ).parent().prev().find('#t_period').val();
	
//	alert(score);
	$.ajax({
		url : pathHeader + '/org/orgScoreUpdate.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			pid:pid,
			tid:tid,
			score:teacherScore, 
			period:teacherPeriod
		},
		success:function(data){
			if(data) {
				alert("成绩修改成功!");
				 
			} else {
				alert("成绩修改失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});
	
	/* alert(this.tagName);
	 
	var parentTag = $( this ).parent().prop('tagName');
	alert(parentTag);
	alert("hi");
	var parent = $( this ).parent();
	alert(parent);
	var count = $( this ).parent().children().length;
	alert(count);
	$(this).next("a[name=btn_bc]").css('display','block');*/
	//alert($(this).siblings('a').count());
}
 
/*

function zTreeOnClick(event, treeId, treeNode) {
alert(treeNode.id + ", " + treeNode.name);
alert(treeNode.id + ", -" + treeNode.name+", " + treeNode.type);
var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.expandNode(treeNode);
};

function onClick(e,treeId, treeNode) {
alert(treeNode.id + ", " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.expandNode(treeNode, null, null, null, true);
}


function onExpand(event, treeId, treeNode) {
	curExpandNode = treeNode;
}

var curExpandNode = null;
function beforeExpand(treeId, treeNode) {
	var pNode = curExpandNode ? curExpandNode.getParentNode():null;
	var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
		if (treeNode !== treeNodeP.children[i]) {
			zTree.expandNode(treeNodeP.children[i], false);
		}
	}
	while (pNode) {
		if (pNode === treeNode) {
			break;
		}
		pNode = pNode.getParentNode();
	}
	if (!pNode) {
		singlePath(treeNode);
	}

}

function singlePath(newNode) {
	if (newNode === curExpandNode) return;
	if (curExpandNode && curExpandNode.open==true) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		if (newNode.parentTId === curExpandNode.parentTId) {
			zTree.expandNode(curExpandNode, false);
		} else {
			var newParents = [];
			while (newNode) {
				newNode = newNode.getParentNode();
				if (newNode === curExpandNode) {
					newParents = null;
					break;
				} else if (newNode) {
					newParents.push(newNode);
				}
			}
			if (newParents!=null) {
				var oldNode = curExpandNode;
				var oldParents = [];
				while (oldNode) {
					oldNode = oldNode.getParentNode();
					if (oldNode) {
						oldParents.push(oldNode);
					}
				}
				if (newParents.length>0) {
					zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
				} else {
					zTree.expandNode(oldParents[oldParents.length-1], false);
				}
			}
		}
	}
	curExpandNode = newNode;
}


var setting = {
	view: {
		dblClickExpand: false,
		showLine: true,
		showIcon: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick,
		beforeExpand: beforeExpand,
		onExpand: onExpand
	}
};

var zNodes =[
	{ id:1, pId:0, name:"pNode 1", open:true},
			{ id:11, pId:1, name:"pNode 11"},
			{ id:111, pId:11, name:"leaf node 111"},
			{ id:112, pId:11, name:"leaf node 112"},
			{ id:113, pId:11, name:"leaf node 113"},
			{ id:114, pId:11, name:"leaf node 114"},
			{ id:12, pId:1, name:"pNode 12"},
			{ id:121, pId:12, name:"leaf node 121"},
			{ id:122, pId:12, name:"leaf node 122"},
			{ id:123, pId:12, name:"leaf node 123"},
			{ id:124, pId:12, name:"leaf node 124"},
			{ id:13, pId:1, name:"pNode 13 - no child", isParent:true},
			{ id:2, pId:0, name:"pNode 2"},
			{ id:21, pId:2, name:"pNode 21", open:true},
			{ id:211, pId:21, name:"leaf node 211"},
			{ id:212, pId:21, name:"leaf node 212"},
			{ id:213, pId:21, name:"leaf node 213"},
			{ id:214, pId:21, name:"leaf node 214"},
			{ id:22, pId:2, name:"pNode 22"},
			{ id:221, pId:22, name:"leaf node 221"},
			{ id:222, pId:22, name:"leaf node 222"},
			{ id:223, pId:22, name:"leaf node 223"},
			{ id:224, pId:22, name:"leaf node 224"},
			{ id:23, pId:2, name:"pNode 23"},
			{ id:231, pId:23, name:"leaf node 231"},
			{ id:232, pId:23, name:"leaf node 232"},
			{ id:233, pId:23, name:"leaf node 233"},
			{ id:234, pId:23, name:"leaf node 234"},
			{ id:3, pId:0, name:"pNode 3 - no child", isParent:true}
];*/

/*$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	$.fn.zTree.init($("#treeDemo2"), setting2);
});*/
 
