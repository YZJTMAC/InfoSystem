$(function(){
	queryList();
	initSelectClass();
})

function creditLendAdd(){
	var url =  pathHeader + "/teacher/teacherProject/toCreditLendAdd.htm?click=27";
	window.location.href=url;
}
function creditLendUpdate(id){
	var url =  pathHeader + "/teacher/teacherProject/toCreditLendUpdate.htm?click=27&id="+id;
	window.location.href=url;
}


/**
 * 查询借贷列表
 */
function queryList(){
	var lendYear = $('#lendYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
	$('#creditLendList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			lendYear:lendYear
		},
		beforeSend: function(){
			$('#creditLendList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			$('#creditRule').html("借贷规则：对于本年度多取得的学分可转存至下一年度使用，对因产假病假等特殊原因无法完成当年培训学分的教师，经学校同意可申请学分借贷，</br>"+
 			"预支下一年度的学分，但第二年要按借贷学分数的"+data.repayRate+"倍偿还，不允许连续两年申请学分借贷.");
			
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#creditLendList').html(gridHtml);
				initSelectClass();
			}else{
				$('#creditLendList').html("<tr><td colspan='14'>无借贷记录</td></tr>");
			}
		},
		error:function(){
			$('#creditLendList').html("<tr><td colspan='14'>无借贷记录</td></tr>");
		}
		
		
	});
}


function showUp(from){
	if(from == "repay"){
		$("#lendCreditRepay").css('display','block');
		$("#repay_btn").css('display','block');
	}else if(from == "repayView"){
		$("#lendCreditRepay").css('display','block');
	}
	$(".tip").fadeIn(200);
}

function disappear(){
	$(".tip").fadeOut(200);

	$("#lendCreditRepay").css('display','none');
	$("#repay_btn").css('display','none');
}

function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.lendYear+"</td>";
		gridHtml += "<td>"+obj.trainFormName+"</td>";
		gridHtml += "<td>"+obj.lendDate+"</td>";
		gridHtml += "<td>"+obj.lendReason+"</td>";
		gridHtml += "<td>"+obj.lendCredit+"</td>";
		if(obj.lendStatus == 0){
			gridHtml += "<td>未审批</td>";
			gridHtml += "<td><a href='javascript:creditLendUpdate("+obj.id+")'>编辑</a></td>";
		}
		if(obj.lendStatus == 1){
			gridHtml += "<td><a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>已通过</a></td>";
			gridHtml += "<td>" +
							"<a href='javascript:repayView("+obj.id+")'>偿还</a>	<a href='javascript:viewOne(\"" + obj.id + "\",\"view\")'>查看</a>" +
						"</td>";
		}
		if(obj.lendStatus == 2){
			gridHtml += "<td><a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>未通过</a></td>";
			gridHtml += "<td><a href='javascript:viewOne(\"" + obj.id + "\",\"view\")'>查看</a></td>";
		}
		if(obj.lendStatus == 3){
			gridHtml += "<td><a href='###' class='tablelink' onclick='queryAudit(\"" + obj.id + "\");'>已偿还</a></td>";
			gridHtml += "<td><a href='javascript:viewOne(\"" + obj.id + "\",\"repayView\")'>查看</a></td>";
		}
		gridHtml+= "</tr>";
	return gridHtml;
}


function viewOne(id,type){
	$("#update_credit").css('display','none');
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			var obj = data.rows;
			$("#yearView").val(obj.lendYear);
			$("#reasonView").val(obj.lendReason);
			$("#trainFormId").val(obj.trainFormId);
			$("#trainFormName").val(obj.trainFormName);
			$("#lendCredit").val(obj.lendCredit);
			$("#repayCredit").val(obj.repayCredit);
			showUp(type);
			updateId = id;
		},
		error:function(){
		}
		
	});
}


/**
 * 查看审核意见
 * @param id
 */
function queryAudit(id){
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			var obj = data.rows;
			if(obj.lendCommand == null){
				$("#reason").html("无");
			}else{
				$("#reason").html(obj.lendCommand);
			}
			
			$("#auditReasonModal").modal("show");
		},
		error:function(){
		}
		
	});
}

/**
 * 查看偿还
 */
var repayId;
function repayView(id){
	$("#repay_credit").css('display','none');
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			var obj = data.rows;
			$("#yearView").val(obj.lendYear);
			$("#reasonView").val(obj.lendReason);
			$("#lendCredit").val(obj.lendCredit);
			$("#trainFormId").val(obj.trainFormId);
			$("#trainFormName").val(obj.trainFormName);
			$("#repayCredit").val(data.repayCredit);
			showUp("repay");
			repayId = id;
		},
		error:function(){
		}
	});
}

/**
 * 偿还
 */
 function repay(){
	var url = pathHeader + "/teacher/teacherProject/repayLendCredit.do";
	var id = repayId;
	var repayCredit = $('#repayCredit').val();
	var repayYear = $('#yearView').val();
	var trainFormId = $('#trainFormId').val();
	 $.ajax({
		 url:url,
		 data:{
		 	id:id,
		 	repayCredit:repayCredit,
		 	repayYear:repayYear,
		 	trainFormId:trainFormId
		 },
		 type:"post",
		 async:false,
		 success:function(data){
			 if(data.success){
				 jQuery.generalAlert("偿还成功");
				 queryList();
			 }else{
				 jQuery.generalAlert(data.message);
			 }
			 disappear();
		 },
		 error:function(){
			 jQuery.generalAlert("偿还出现错误，请联系相关人员 !");
		 }
	 });
}
 
 
 
 
 function initSelectClass(){
	 $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	$(".select4").uedSelect({
		width : 100
	});
}