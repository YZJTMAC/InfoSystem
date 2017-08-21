$(function(){
	queryOrgByProId();
});


/**
 * 查询项目下已分配的承培机构
 */
function queryOrgByProId(){
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/queryOrgByProId.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			proId : proId
		},
		success:function(data){
			if(data.success) {
				var objList = data.obj;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$("#org_list").html(gridHtml);
				
			} 
		},
		error:function(){
			jQuery.generalAlert('查询项目下已分配的承培机构失败!');
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.organizationName)+"</td>";
	gridHtml += "<td><span class='td_plan_num'>"+nullFormatter(obj.planNum)+"</span></td>";
	gridHtml += "<td>"+nullFormatter(obj.areaName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.classSubjectName)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	gridHtml += "</tr>";

	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(obj){
		return "<a href='###' class='tablelink' name='td_a_name' onclick='assignTaskForOrg(this,\""+obj.id+"\",\""+obj.subjectId+"\",\""+obj.subjectName+"\");'>分配任务</a>";
	}
}


/**
 * 分配任务
 * @param {Object} obj
 * @param {Object} id	数据库存id
 * @param {Object} subjectId	项目可以分配的学科id
 * @param {Object} subjectName	项目可以分配的学科name
 */
function assignTaskForOrg(obj, id, subjectId, subjectName){
	$('#subjectIds').val('');
	$('#subjectNames').val('');
	
	$('#subjectIds').val(subjectId);
	$('#subjectNames').val(subjectName);
	
	var plan_num = $(obj).parent().prev().prev().prev().children().html();
	var area_name = $(obj).parent().prev().prev().html();
	var class_subject_name = $(obj).parent().prev().html();
	
	$(obj).parent().prev().prev().prev().html("<input id='planNum' onblur='validatePlanNum(this);' type='text' class='scinput' value='"+plan_num+"' >");
	$(obj).parent().prev().prev().html(
		'<div class="vocation">' +
			'&nbsp;<input id="area" name="input2" type="text" class="scinput" colspan="4" readonly="readonly" value="'+area_name+'"/>' +
			'&nbsp;<input name="input2" type="button" value="选 择" onclick="areaSelect();" class="btnXuan"/>' +
		'</div>'
	);
	$(obj).parent().prev().html(
		'<div class="vocation">' +
			'&nbsp;<input id="subject" name="input2" type="text" class="scinput" colspan="4" readonly="readonly" value="'+class_subject_name+'"/>' +
			'&nbsp;<input name="input2" type="button" value="选 择" class="btnXuan" onclick="toSelectSubject()" id="toSelectS"/>' +
		'</div>'
	);
	
	var htm = "<a href='###' class='tablelink' onclick='save("+id+")'>保存</a> &nbsp;&nbsp;";
	htm += "<a href='###' class='tablelink' onclick='cancel(this,\""+id+"\",\""+plan_num+"\",\""+area_name+"\",\""+class_subject_name+"\")'>取消</a> &nbsp;&nbsp;";
	$(obj).parent().html(htm);
	
	// 禁用其他列分配任务onclick事件
	//$("a[name='td_a_name']").each(function(){
	//	$(this).attr('onclick', false);
	//});

}


/**
 * 校验给机构分配的人数是否大于项目计划人数
 */
var isOK = true; 
function validatePlanNum(obj){
	isOK = false;

	var pro_plan_num = countPlanNum();
	var plan_num = $(obj).val();
	var planNum = pro_plan_num*1 + plan_num*1;
	if(planNum > (proPlanNum*1)){
		jQuery.generalAlert('分配人数已大于项目计划人数!');
	} else {
		isOK = true;
	}
}


/**
 * 统计已分配给机构的计划人数
 */
function countPlanNum(){
	var num = '';
	$("span[class='td_plan_num']").each(function(){
		num += $(this).html();
	});
	return num;
}


/**
 * 选择地区
 */
function lastForSure(){
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1]
		var text = conditionArray[2]
		$("#areaCode").val(belone);
		$("#area").val(text);
	}
	clear();
}


/**
 * 创建选择学科
 */
function toSelectSubject(){
	var html = "<li>";
	var ids = $('#subjectIds').val().split(",");
	var names = $('#subjectNames').val().split(",");
	for(var i = 0;i<names.length;i++){
		id = ids[i];
		name = names[i];
		var str = "<li>";
		str += "<input type='checkbox' name='"+name+"' value='"+id+"'>"+name+"</li>";
		html += str;
	}
	$("#selectS").html(html);
	
	$("#selectSubject").fadeIn(100);
}


/**
 * 选择学科
 */
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
		$('#subject').val(names.substring(0,names.length-1));
		hideMe();
		clearCheckBox();
	}else{
		jQuery.generalAlert("请至少选择一个学科！");
	}
}


/**
 * 取消选择学科
 */
function hideMe(){
	$("#selectSubject").fadeOut(100);
	clearCheckBox();
}


/**
 * 保存分配任务
 */
function save(id){
	if(!isOK){
		jQuery.generalAlert('请修改计划分配人数, 当前分配总人数已超过项目计划人数');
		return false;
	}
	$.ajax({
		url : pathHeader + "/edupm/projectmanage/setOPOtherInfo.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			id : id,
			planNum : $('#planNum').val(),
			areaName : $('#area').val(),
			subjectName : $("#subjectName").val(),
			subjectId : $("#subjectId").val(),
			areaCode : $("#areaCode").val(),
			proId : proId
		},
		success:function(data){
			if(data.success) {
				jQuery.generalAlert("成功!");
				//goBack();
				window.location.reload();
				
				//clearOnclick();
			} 
		},
		error:function(){
			jQuery.generalAlert('保存失败!');
			
			//clearOnclick();
		}
	});
}


/**
 * 取消分配任务
 * @param {Object} obj
 * @param {Object} id
 * @param {Object} plan_num
 * @param {Object} area_name
 * @param {Object} class_subject_name
 */
function cancel(obj, id, plan_num, area_name, class_subject_name){
	$(obj).parent().prev().prev().prev().html("<span class='td_plan_num'>"+plan_num+"</span>");
	$(obj).parent().prev().prev().html(area_name);
	$(obj).parent().prev().html(class_subject_name);
	var str = "<a href='###' class='tablelink' name='td_a_name' onclick='assignTaskForOrg(this,\""+id+"\",\""+$('#subjectIds').val()+"\",\""+$('#subjectNames').val()+"\");'>分配任务</a>";
	$(obj).parent().html(str);
	
	//clearOnclick();
}

/**
 * 返回
 */
function goBack(){
	var openUrl = pathHeader + '/edupm/projectmanage/toOrgTaskingPage.htm?click=25';
	window.location.href = openUrl;
}


/**
 * 清楚已选项
 */
function clearCheckBox(){
	$("input[type='checkbox']").each(function(){
		$(this).attr("checked",false);
	});
}


function clearOnclick(){
	$("a[name='td_a_name']").each(function(){
		$(this).attr('onclick', 'onclick');
	});
}