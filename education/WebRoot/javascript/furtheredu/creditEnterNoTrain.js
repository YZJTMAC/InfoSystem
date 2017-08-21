$(document).ready(function(e) {
	
	
	$('#tabPage0').click(function(){
		$('#isCreditEntered').val(0); //未登记
		$("#select").click();
	});
	
	$('#tabPage1').click(function(){
		$('#isCreditEntered').val(1); //已登记
		$("#select").click();
	});
	
	
	$("#select").click(function() {
		getUserList(); //根据查询条件查出学员列表
	});
	
	$("#btnBatch").click(function(){ //批量登记学分
		enterBatchCredit();
	});
	
	var rootId =$('#txtNoTraintProjectAreaId').val();//非培训类项目的培训范围的地区id
	rootId= GetURLParameter("scope");
	 
	 $.post(pathHeader + '/org/orgRegionList.do?rootId='+rootId,function(result){
		 var myJsonString = JSON.stringify(result);
		 var zNodes =eval("(" + myJsonString + ")");
		 setAreaIdByNode(zNodes);
		 $.fn.zTree.init($("#treeDemo2"), setting2,zNodes);   
	 });

	 setTimeout( firstClick, 1000 );
	 $("#chkAll").click( function () {
		   if($(this).attr("checked")){
			   $("input[name='chkEnterCredit']").attr("checked",true);
		   }else{
			   $("input[name='chkEnterCredit']").attr("checked",false);
		   }
		 }
	 );
	 $("#chkAll").attr("checked",false);
});

//多选
function getAndSetChecked(){	
	// 子选项全选中同时选中全选项, 子选项未选中全选项取消选中
	$('#chkAll').attr('checked', false);
	$("input[name='chkEnterCredit']").click(function () {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='chkEnterCredit']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='chkEnterCredit']").length){
				$('#chkAll').attr('checked', true);
			}
		} else {				
			$('#chkAll').attr('checked', false);
		} 		
		});
}

function firstClick(){
	$("#treeDemo2").find('li a').click();
}
 
function getUserList(){
	var province = $("#txtProvinceId").val();
	var city  = $("#txtCityId").val();
	var district = $("#txtDistrictId").val();
	var school = $("#txtSchoolId").val();
	var schoolType = $("#txtSchoolType").val();
	var teacherName=$('#txtTeacherName').val();
	var pageSize = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	var isCreditEntered = $("#isCreditEntered").val();
	var queryType="";
	if(isCreditEntered ==="0"){
		queryType="creditNotEntered";
	}
	if(isCreditEntered ==="1"){
		queryType="creditAlreadyEntered";
	}
	$.ajax({
		url : pathHeader + '/org/orgRegionUserListNotrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			queryType:queryType,
			projectId:GetURLParameter("projectId"),
			province: province,
			city: city,
			district:district,
			school:school,
			schoolType:schoolType,
			teacherName:teacherName,
			pageIndex : pageIndex,
			pageSize:pageSize
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				$.each(objList, function(index,element) {
					if(objList[index].auditStatus===11){
						objList[index].auditStatus='未审核';
					}else {
						objList[index].auditStatus='已审核';
					}
				});
				var gridHtml = "";
				var myJsonString = JSON.stringify(objList);
				var str = '{"users":'+myJsonString +'}';
				//alert(str);
				if(isCreditEntered==0){
					formatProject(str) ;
					jQuery('#page_2').children("div").attr("id","newId");
					$('#page_1').html("<div id='pagebar' class='pagin'></div>");
				}else{
					formatProject2(str) ;
					jQuery('#page_1').children("div").attr("id","newId");
					$('#page_2').html("<div id='pagebar' class='pagin'></div>");
				}
					pagination(data, function() {
						getUserList();
					});
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
				if(isCreditEntered==0){
					$('#page_1').html('');
					$('#target').html('');
					$('#target').append(gridHtml);
				}else {
					$('#page_2').html('');
					$('#target2').html('');
					$('#target2').append(gridHtml);
				}
			}
			getAndSetChecked();
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='6'>错误,暂无查询结果！</td></tr>";
			if(isCreditEntered==0){
				$('#page_1').html('');
				$('#target').html('');
				$('#target').append(gridHtml);
			}else {
				$('#page_2').html('');
				$('#target2').html('');
				$('#target2').append(gridHtml);
			}
		}
	}); 

}

function formatProject(projectList) {
	  var template = $('#template').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  
	  var obj = eval('(' + projectList + ')');
	  var rendered = Mustache.render(template,obj);
	  $('#target').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
	}
function formatProject2(projectList) {
	  var template = $('#template2').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  
	  var obj = eval('(' + projectList + ')');
	  var rendered = Mustache.render(template,obj);
	  $('#target2').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
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
		url:pathHeader + '/org/orgRegionList.do',
		autoParam:["id","type","isSchool","pId=pid"],
		otherParam:{"otherParam":"zTreeAsyncTest"},
		dataFilter: filter
	},
	callback: {
		onClick: onClick
	}
	
};
 

function onClick(e,treeId, treeNode) {
		
	  		if(treeNode.isSchool ==="true"){ //学校类型
	  			$("#txtSchoolType").val(treeNode.type);
	  			$("#txtDistrictId").val(treeNode.pId);
	  		}else if(treeNode.isSchool ==="school"){ //学校类型
	  			$("#txtSchoolId").val(treeNode.id);
	  			$("#txtDistrictId").val(treeNode.pId);
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

function setAreaIdByNode(treeNode){
	if(treeNode[0].isSchool ==="true"){ //学校类型
			$("#txtSchoolType").val(treeNode[0].type);
			$("#txtDistrictId").val(treeNode[0].pId);
		}else if(treeNode[0].isSchool ==="school"){ //学校类型
			$("#txtSchoolId").val(treeNode[0].id);
			$("#txtDistrictId").val(treeNode[0].pId);
		}else{
			var type=treeNode[0].type;
			if(type=="0"){
  			$("#txtProvinceId").val(treeNode[0].id);
  			$("#txtCityId").val("");
  			$("#txtDistrictId").val("");
  			$("#txtSchoolId").val("");
			}else if(type=="1"){
  			$("#txtCityId").val(treeNode[0].id);
  			$("#txtDistrictId").val("");
  			$("#txtSchoolId").val("");
			}else if(type=="2"){
  			$("#txtDistrictId").val(treeNode[0].id);
  			$("#txtSchoolId").val("");
			}
		}
}


function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}


//修改button click
function modifyScore(a,pid,tid  ){
	var score = $( a ).parent().prev().find('input').val();
	$.ajax({
		url : pathHeader + '/org/orgScoreUpdate.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			pid:pid,
			tid:tid,
			score:score 
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
	
	 
}

//打开弹出窗口 
function popup(userId){
	$("#userId").val(userId);
	$(".tip").fadeIn(200);
}
 
//登记学分 click
function enterOneCredit(){
	var teacherId = $("#userId").val();
  	//enterCredit(teacherId);//登记学分
  	var score = $("#txt_fp").val();
	if(score===""){
		alert("请输入登记学分!");
		return;
	}
	if(teacherId===""){
		alert("请选择教师!");
		return;
	}
//	var teacherId = $("#userId").val();
	var projectId = GetURLParameter("projectId");
	 enterCreditOneByOne(teacherId,score);
 
	/// jQuery.generalAlert("登记学分成功");
	// setTimeout( location.reload(), 10000 );
	 jQuery.alertWindowReloadCurrent("提示信息","登记学分成功");
	/*$.ajax({
		url:pathHeader + '/furtheredu/certificate/enterCredit.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			teacherId:teacherId,
			projectId:projectId,
			score:score
		},
		sucess:function(data){
			if(data) {
				alert("学分登记成功!");
				 
			} else {
				alert("学分登记失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});*/
	
  	//$(".tip").fadeOut(100);
  	//location.reload();
}

//登记学分 click
function enterBatchCredit(){
	 var score = $("#batchScore").val();
	 if(score ===""){
		 alert("请输入批量登记学分");
		 return;
	 }
	 
	var count=$('input[name=chkEnterCredit]:checked').length;
	 if(count ===0){
		 alert("请选择登记人员");
		 return;
	 }
	 $('input[name=chkEnterCredit]:checked').each(function(e){
		 var teacherId= $(this).val();
		 
		 enterCreditOneByOne(teacherId,score);
	 });
 	jQuery.alertWindowReloadCurrent("提示信息","批量登记学分成功");
}

function reloadpage(){
	this.location.reload();
}
//登记学分
function enterCredit(teacherId){
	var score = $("#txt_fp").val();
	if(score===""){
		alert("请输入登记学分!");
		return;
	}
	if(teacherId===""){
		alert("请选择教师!");
		return;
	}
//	var teacherId = $("#userId").val();
	var projectId = GetURLParameter("projectId");
	
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/enterCredit.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			teacherId:teacherId,
			projectId:projectId,
			score:score
		},
		sucess:function(data){
			if(data) {
				alert("学分登记成功!");
				 
			} else {
				alert("学分登记失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});
}
 
//update credit one by one
function enterCreditOneByOne(teacherId,score){
	if(score===""){
		alert("请输入登记学分!");
		return;
	}
	if(teacherId===""){
		alert("请选择教师!");
		return;
	}
	var projectId = GetURLParameter("projectId");
	
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/enterCredit.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			teacherId:teacherId,
			projectId:projectId,
			score:score
		},
		sucess:function(data){
		 
			if(data) {
				alert("学分登记成功!");
				 
			} else {
				alert("学分登记失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});
}

 