jQuery(document).ready(function(){
	var pname=GetURLParameter("projectName");
	$('#pname').html(decodeURIComponent(pname));
	
	$('.cancel').click(function(){
		$('.tip').fadeOut(100);
	});
	showInfoList(); //未审核用户列表
	showInfoList2(); //未审核用户列表

	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});
	
	
	$('#tabPage0').click(function(){
		$('#isScorePublished').val(1); //未审核
	});
	
	$('#tabPage1').click(function(){
		$('#isScorePublished').val(2); //已审核
	});
	
	//批量审核
	$('#btnBatch').click(function(){
		enterBatchCredit();
	});
	 
	$("#select").click(function() {
		var queryType = 	$('#isScorePublished').val();
		if(queryType ==="1"){
			showInfoList(); //未审核用户列表
		}else if(queryType ==="2"){
			showInfoList2(); //已审核用户列表
		}
	});
	
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


function showInfoList(){
	$('#target').html('');
	var teacherName=$('#txtTeacherName').val();
	var pageSize = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	 
	$.ajax({
		url : pathHeader + '/org/orgRegionUserListNotrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			queryType:"creditNotAudit", 
			projectId:GetURLParameter("projectId"),
			teacherName:teacherName,
			pageIndex : pageIndex,
			pageSize:pageSize
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var users ={"users":objList};
				formatTemplate1(users) ;
				jQuery('#page_2').children("div").attr("id","newId");
				$('#page_1').html("<div id='pagebar' class='pagin'></div>");
				pagination(data, function() { showInfoList(); });
			} else {
				gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
					$('#target').html('');
					$('#target').append(gridHtml);
					$('#page_1').html('');
			}
			getAndSetChecked();
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='6'>错误,暂无查询结果！</td></tr>";
			$('#target').html('');
			$('#target').append(gridHtml);
			$('#page_1').html('');
		}
	}); 

}

function showInfoList2(){
	$('#target2').html('');
	var teacherName=$('#txtTeacherName').val();
	var pageSize = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();	
	 
	$.ajax({
		url : pathHeader + '/org/orgRegionUserListNotrain.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			queryType:"creditAlreadyAudited", 
			projectId:GetURLParameter("projectId"),
			teacherName:teacherName,
			pageIndex : pageIndex,
			pageSize:pageSize
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var users ={"users":objList};
				formatTemplate2(users) ;
				jQuery('#page_1').children("div").attr("id","newId");
				$('#page_2').html("<div id='pagebar' class='pagin'></div>");
				pagination(data, function() { showInfoList2(); });
			} else {
				gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
					$('#target2').html('');
					$('#target2').append(gridHtml);
					$('#page_2').html('');
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='6'>错误,暂无查询结果！</td></tr>";
			$('#target2').append(gridHtml);
			$('#target2').html('');
			$('#target2').append(gridHtml);
			$('#page_2').html('');
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



function formatTemplate1(projectList) {
	 $('#target').empty();
	  var template = $('#template').html();
	  Mustache.parse(template);    
	  var rendered = Mustache.render(template,projectList);
	  $('#target').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
}

function formatTemplate2(projectList) {
	 $('#target2').empty();
	  var template = $('#template2').html();
	  Mustache.parse(template);    
	  var rendered = Mustache.render(template,projectList);
	  $('#target2').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
}


//打开弹出窗口 
function popup(userId,name,score){
	$("#userId").val(userId);
	$('#pTeacherName').html("教师姓名:"+name);
	$('#pscore').html(" 登记学分:"+score);
	$(".tip").fadeIn(200);
}
 
//审核学分 click
function auditOneCredit(){
	var id = $("#userId").val();
	var score = $('#txt_fp').val();
	var status=$('input[name=isPass]:checked').val();
	if(score===""){
		alert("请输入审核学分!");
		return;
	}
	if(id===""){
		alert("请选择教师!");
		return;
	}
	var isPass=$('input[name=isPass]:checked').length;
	if(isPass===0){
		alert("请选择审核状态!");
		return;
	}
	//enterCreditOneByOne(id,score);//enterCredit(id,score,statusName);//审核学分
	enterCredit(id,score,status);
//	 alert("审核学分成功");
//	location.reload();
	jQuery.alertWindowReloadCurrent("提示信息","审核学分成功");
	 
	/*var projectId = GetURLParameter("projectId");
	
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/auditCredit.do',
		type:"POST",
		cache:"false",
		async:false,
		dataType:"json",
		data:{
			id:id,
			projectId:projectId,
			status:13,
			statusName:statusName,
			score:score
		},
		sucess:function(data){
			alert(data);
			if(data) {
				alert("学分审核成功!");
				$(".tip").fadeOut(100);
			  	location.reload();
				 
			} else {
				alert("学分审核失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});*/
  
}

//审核学分 click
function enterBatchCredit(){
	 var result = $('#batchResult').val();
	 if(result ==="0"){
		 alert("请选择审核结果");
		 return;
	 } 
	 var score = $("#batchScore").val();
	 if(score ===""){
		 alert("请输入批量审核学分");
		 return;
	 }
	 
	var count=$('input[name=chkEnterCredit]:checked').length;
	 if(count ===0){
		 alert("请选择审核人员");
		 return;
	 }
	 $('input[name=chkEnterCredit]:checked').each(function(e){
		 var teacherId= $(this).val();
//		 alert(teacherId);
		 enterCreditOneByOne(teacherId,score,result);
	 });
//  	 alert("批量审核学分成功");
//  	location.reload();
  	jQuery.alertWindowReloadCurrent("提示信息","批量审核学分成功");
}

//审核学分
function enterCredit(id,score,status){
	var statusName="合格";
	if(stautus == 12){
		statusName = "不合格";
	}
	var projectId = GetURLParameter("projectId");
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/auditCredit.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			id:id,
			projectId:projectId,
			status:status,
			statusName:statusName,
			score:score
		},
		sucess:function(data){
			if(data) {
				alert("学分审核成功!");
				 
			} else {
				alert("学分审核失败!");
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
		alert("请输入审核学分!");
		return;
	}
	if(teacherId===""){
		alert("请选择教师!");
		return;
	}
	var projectId = GetURLParameter("projectId");
	
	$.ajax({
		url:pathHeader + '/furtheredu/certificate/auditCredit.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			id:teacherId,
			projectId:projectId,
			status:13,
			statusName:'合格',
			score:score
		},
		sucess:function(data){
			if(data) {
				alert("学分审核成功!");
				 
			} else {
				alert("学分审核失败!");
			}
		},
		error:function(){
			alert("错误.");
		}
	});
}
 
