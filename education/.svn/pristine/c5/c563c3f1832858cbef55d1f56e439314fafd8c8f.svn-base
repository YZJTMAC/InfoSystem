$(function(){
	initAutoComplete();
	
	$('#select').click(function(){
		queryProList();
	});
	
	$("#pageSize").change(function(){
		queryProList();
	});
});

function initAutoComplete(){
	lastForSure();
	//继教信息板块
	queryEduModel();
	
	//查询项目性质
	queryProjectScope();
	
	$(".select1").uedSelect({
		width : 70
	});
	$(".select3").uedSelect({
		width : 110
	});
	
	//列表复选框
	$("#chk_all").click(function(){
		if(this.checked){
			$("input[name='chk_list']").attr("checked",$(this).attr("checked"));
		}
		else{
			$("input[name='chk_list']").attr("checked",false);
		}
	});
	
	//弹框复选框
	$("#certificate_chk").click(function(){
		if(this.checked){
			$("input[name='checkbox']").attr("checked",$(this).attr("checked"));
		}
		else{
			$("input[name='checkbox']").attr("checked",false);
		}
	});
	
	$("input[name='checkbox']").click(function() {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='checkbox']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='checkbox']").length){
				$('#certificate_chk').attr('checked', true);
			}
		} else {				
			$('#certificate_chk').attr('checked', false);
		} 		
	});
	
	$(".tiptop2 a").click(function() {
		$(".tip1").fadeOut(200);
	});
	
	$(".cancel").click(function() {
		$(".tip1").fadeOut(100);
	});
}

//继教信息板块
function queryEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				var opts = "";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
				}
				$("#eduModelType").append(opts);
			}
		},
		error:function(){
			jQuery.generalAlert("初始化继教信息模块失败！");
		}
	});
}

//查询项目性质
function queryProjectScope(){
	var url = pathHeader+ "/org/queryXiangMuList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				var rows = data.rows;
				var str = "";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					str +="<option value='"+ obj.dictionaryId+"'>";
					str += obj.dictionaryName;
					str +="</option>";
				}
				$("#projectScope").append(str);
			}
		},
		error:function(){ }
	});
}

/**
 * 查询项目下有成绩的参训教师
 */
function queryProList(){
	$('#teacher_list').html('');
	var sizePerPage = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	
	$.ajax({
		url : pathHeader + '/furtheredu/edumanage/queryCertificateByTeacher.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			queryModelType: $("#eduModelType").val(),
			queryProjectScope: $("#projectScope").val(),
			queryProjectName : $('#queryProjectName').val(),
			queryYearStart : $('#queryYearStart').val(),
			queryYearEnd : $('#queryYearEnd').val(),
			queryStatus : $('#queryStatus').val(),
			teacherName : $('#teacherName').val(),
			areaId : $('#areaId').val(),
			areaType : $('#areaType').val(),
			idcard: $('#idcard').val(),
			pageIndex : pageIndex,
			sizePerPage : sizePerPage
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#teacher_list').append(gridHtml);
				$('#totalCount').text(data.total);
				
			} else {
				gridHtml = "<tr><td align='center'colspan='13'>暂无查询结果！</td></tr>";
				$('#teacher_list').append(gridHtml);
				$('#totalCount').text(0);
			}
			
			pagination(data, function(){queryProList();});
			
			getAndSetChecked();
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}

//多选
function getAndSetChecked(){
	// 子选项全选中同时选中全选项, 子选项未选中全选项取消选中
	$('#chk_all').attr('checked', false);
	$("input[name='chk_list']").click(function () {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='chk_list']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='chk_list']").length){
				$('#chk_all').attr('checked', true);
			}
		} else {				
			$('#chk_all').attr('checked', false);
		} 		
	});
}

function getTdHtml(obj){
	//periodCertCode projectCertCode
	var status = obj.trainStatus; 
	var auditStatus = obj.auditStatus;//学分状态
	var period = obj.teacherClassPeriod;
	
	var gridHtml = "<tr>";
	gridHtml += "<td><input name='chk_list' type='checkbox' value='"+ obj.teacherId +"_"+ obj.proId +"'></td>";
	gridHtml += "<td>"+obj.teacherName+"</td>";//教师姓名
	gridHtml += "<td>"+genderFormatter(obj.gender)+"</td>";//性别
	gridHtml += "<td>"+obj.schoolName+"</td>";//学校名称
	gridHtml += "<td>"+nullFormatter(obj.classPeriod)+"</td>";//项目学时
	gridHtml += "<td>"+nullFormatter(obj.teacherClassPeriod)+"</td>";//所获学时
	gridHtml += "<td>"+nullFormatter(obj.teacherScore)+"</td>";//所获成绩
	gridHtml += "<td>"+nullFormatter(obj.trainStatus)+"</td>";//成绩等级
	if(period>0 && status != '不合格'){ //学时证书
		//学时编号为空或者长度小于22，学时证书未打印，后22位是在成绩发布的时候生成的，前几位前缀是在打印证书的时候生成的
		if(obj.periodCertificateCode==null||obj.periodCertificateCode.length<=6) {			
			gridHtml += "<td>"+"学时证书未打印"+"</td>";  
		}else {
			gridHtml += "<td>"+obj.periodCertificateCode+"</td>";  
		}
		
	}
	else {
		gridHtml += "<td>"+"未取得学时证书"+"</td>";  
	}
	
	gridHtml += "<td>"+nullFormatter(obj.teacherClassScore)+"</td>";//学分

	gridHtml += "<td>"+nullFormatter(obj.auditStatus)+"</td>";//审核评价

	if(auditStatus == '合格'){//学分证书
		//学时编号为空或者长度小于22，学时证书未打印，后22位是在成绩发布的时候生成的，前几位前缀是在打印证书的时候生成的
        if(obj.projectCertificateCode==null||obj.projectCertificateCode.length<=6) {
			
			gridHtml += "<td>"+"项目证书未打印"+"</td>";  
		}else {
			gridHtml += "<td>"+obj.projectCertificateCode+"</td>";  
		}  
	} else {
		gridHtml += "<td>"+"未取得项目证书"+"</td>";  
	}

	gridHtml += "<td>"+obj.proName+"</td>";//项目名称
    gridHtml += "</tr>";
    
	return gridHtml;
	
	function genderFormatter(gender){
		if(gender == 1){
			return '男';
		} else {
			return '女';
		}
	}
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
}

/**
 * 最后确认, 个人开发 自己实现
 */
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$('#areaId').val(belone);
		$('#areaType').val(areaA);
		$('#areaName').val(text);
	}
	
	queryProList();
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}


function showTeacherInfoBox(){
	var totalCount = $("#totalCount").text();
	var teachers = $("input[name='chk_list']:checked").length;
	
	if(totalCount == 0){
		jQuery.generalAlert('没有数据可以导出！');
		return ;
	}else if(teachers==0 && totalCount > 60000){
		jQuery.generalAlert('导出数据不能超出60000条，请选择省级以下地区导出！');
		return;
	}
	
	$(".tip1").fadeIn(200);
}

function hideModal(){
	$('#myModal').modal('hide');
}

function hideTip(){
	$('#myModal').modal({show:true,backdrop: 'static', keyboard: false});
	setTimeout("hideModal()",2000); 
	$(".tip1").fadeOut(500);
}

//导出
function downTeacherCertificateExcl(){
	if($("input[name='checkbox']:checked").length==0){
		jQuery.generalAlert('请选择所需字段进行导出！');
		return ;
	}
	
	hideTip();
	
	var teacherArray = [];  //选中教师
	$("input[name='chk_list']:checked").each(function(){
		teacherArray.push($(this).val());
	});
	
	
	var fieldArray = [];  //选中导出的字段信息
	$("input[name='checkbox']:checked").each(function(){
		fieldArray.push($(this).val() + "_" +$(this).attr("id"));
	});
	
	var queryConditionArray = [];  //查询条件
	queryConditionArray.push("queryProjectName_" + $("#queryProjectName").val());
	queryConditionArray.push("queryYearStart_" + $("#queryYearStart").val());
	queryConditionArray.push("queryYearEnd_" + $("#queryYearEnd").val());
	queryConditionArray.push("queryStatus_" + $("#queryStatus").val());
	queryConditionArray.push("queryRealName_" + $("#teacherName").val());
	queryConditionArray.push("queryIdNumber_" + $("#idcard").val());
	queryConditionArray.push("eduModelType_" + $("#eduModelType").val());
	queryConditionArray.push("projectScope_" + $("#projectScope").val());
	
	//表单数据
	$("#certificateForm input[name='areaType']").val($("#areaType").val());
	$("#certificateForm input[name='areaId']").val($("#areaId").val());
	$("#certificateForm input[name='teacherArray']").val(teacherArray);
	$("#certificateForm input[name='fieldArray']").val(fieldArray);
	$("#certificateForm input[name='queryConditionArray']").val($.toJSON(queryConditionArray));
	
	$("#certificateForm").attr("action", pathHeader + "/furtheredu/edumanage/exportTeacherCertificateList.do");
	$("#certificateForm").submit();
}