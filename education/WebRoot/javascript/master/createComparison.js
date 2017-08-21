var checkScool = new Array();
$(function(){
	checkScool =new Array();
	initDictionary("comparison_type","comparisonTypeValue");
	if(id != "null"){
		queryComparison();
		$("#update").css('display','block');
		$("#save").css('display','none');
	}
	initSelectClass();
})

/**
 * 查找某一项目（修改时）
 */
var updateId = "";
function queryComparison(){
	var url = pathHeader + "/master/queryComparison.do";
	$.ajax({
		url:url,
		data:{
			id:id
		},
		type:"post",
		async:false,
		success:function(data){
			var obj = data.rows[0];
			$("#comparisonNameValue").val(obj.comparisonName);
			$("#signupStartDateValue").val(obj.signupStartDate);
			$("#signupEndDateValue").val(obj.signupEndDate);
			$("#auditStartDateValue").val(obj.auditStartDate);
			$("#auditEndDateValue").val(obj.auditEndDate);
			$("#publishDateValue").val(obj.publishDate);
			$("#comparisonTypeValue").val(obj.comparisonTypeId);
			$("#comparisonNumValue").val(obj.comparisonPlanNum);
			$("#comparisonNumValue").val(obj.comparisonPlanNum);
			$("#memoValue").val(obj.memo);
			var schools = obj.schools;
			var checkedSchools = schools.split(",");
			for(var i = 0 ; i < checkedSchools.length ; i++){
				var s = checkedSchools[i].split("-");
				var school = {
						schoolId:s[0],
						schoolName:s[1]
					}
				checkScool.push(school);
			}
			setSchool();
			queryFile(obj.id);
			updateId = obj.id;
		},
		error:function(){
			
		}
	});
}

/**
 * 查询附件
 */
function queryFile(isId) {
	var url = pathHeader + "/fileupload/viewFiles.do?time=" + (new Date()).getTime();
	$(".addMore").html('');
	$('#projectId').val(isId);
	$.ajax({
			cache: false,
			dataType : 'json',
			url : url,
			async:"true",
			type : 'post',
			data : {
				projectId : isId,
				type:'comparison'
			},
			success : function(data) {
				var tr = "";
				$.each(data.files,function(i, item) {
					tr += "<tr>" +
						  	"<td width='260' colspan='2'>" +
						  		"<a onclick='previewFile(\""+item.url+"\");'>"+ item.name+ "</a>&nbsp;" +
						  		"<a onclick='delFile(\""+item.id+"\");'>刪 除</a>" +
						  	"</td>" +
						 "</tr>";
				});
				$("#files").append(tr);
			},
			error : function() {
				jQuery.generalAlert("查询数据出错！请联系管理员");
			}
		});
}

/**
 * 删除附件
 * @param id
 */
function delFile(id){
	var url = pathHeader + "/master/delComprisonFile.do";
	$.ajax({
		url:url,
		data:{
			id:id
		},
		type:"post",
		async:false,
		success:function(data){
			queryFile(updateId);
		},
		error:function(){
			
		}
	});
}

/**
 * 查询字典
 */
function initDictionary(dictionaryType, name){
	$("#"+name+"").html("");
	var url = pathHeader + "/org/queryDictionaryByType.do";
	$.ajax({
		url:url,
		data:{
			dictionaryType:dictionaryType,
			status:1
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#"+name+"").append("<option  value='' >请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#"+name+"").append(
							"<option  value=\"" + value.dictionaryId + "\">"
							+ value.dictionaryName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
}

/**
 * 保存
 * @returns {Boolean}
 */
function saveInfo(){
	if(checkout()){
		var comparisonName = $('#comparisonNameValue').val();	//
		var comparisonYear = $('#comparisonYearValue').val();	//
		var comparisonType = $('#comparisonTypeValue').val();
		var comparisonTypeName = $("#comparisonTypeValue option:selected").text();//
		var comparisonNum = $('#comparisonNumValue').val();
		var signupStartDate = $('#signupStartDateValue').val();//
		var signupEndDate   = $('#signupEndDateValue').val();//
		var auditStartDate = $('#auditStartDateValue').val();//
		var auditEndDate   = $('#auditEndDateValue').val();//
		var publishDate   = $('#publishDateValue').val();//
		var memo      = $('#memoValue').val();	//
		
		$("input[name='comparisonName']").val(comparisonName);
		$("input[name='comparisonYear']").val(comparisonYear);
		$("input[name='comparisonTypeId']").val(comparisonType);
		$("input[name='comparisonTypeName']").val(comparisonTypeName);
		$("input[name='comparisonPlanNum']").val(comparisonNum);
		$("input[name='signupStartDate']").val(signupStartDate);
		$("input[name='signupEndDate']").val(signupEndDate);
		$("input[name='auditStartDate']").val(auditStartDate);
		$("input[name='auditEndDate']").val(auditEndDate);
		$("input[name='publishDate']").val(publishDate);
		$("input[name='memo']").val(memo);

		if(checkout()){
			var url = pathHeader + "/master/addComparison.do";
			$("#proForm").ajaxSubmit({
				url:url,
				async:false,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.success){
						urlGo=pathHeader +"/master/toManageComparison.htm";	
						jQuery.generalAlertAndJump(data.message,urlGo);
					}else{
						jQuery.generalAlert(data.message);
					}
				},
				error:function(){
					jQuery.generalAlert("新增失败");
				}
			});
		}
		
		
	}
}

/**
 * 修改
 * @returns {Boolean}
 */
function updateInfo(){
	if(checkout()){
		var comparisonName = $('#comparisonNameValue').val();	//
		var comparisonYear = $('#comparisonYearValue').val();	//
		var comparisonType = $('#comparisonTypeValue').val();
		var comparisonTypeName = $("#comparisonTypeValue option:selected").text();//
		var comparisonNum = $('#comparisonNumValue').val();
		var signupStartDate = $('#signupStartDateValue').val();//
		var signupEndDate   = $('#signupEndDateValue').val();//
		var auditStartDate = $('#auditStartDateValue').val();//
		var auditEndDate   = $('#auditEndDateValue').val();//
		var publishDate   = $('#publishDateValue').val();//
		var memo      = $('#memoValue').val();	//
		
		$("input[name='comparisonName']").val(comparisonName);
		$("input[name='comparisonYear']").val(comparisonYear);
		$("input[name='comparisonTypeId']").val(comparisonType);
		$("input[name='comparisonTypeName']").val(comparisonTypeName);
		$("input[name='comparisonPlanNum']").val(comparisonNum);
		$("input[name='signupStartDate']").val(signupStartDate);
		$("input[name='signupEndDate']").val(signupEndDate);
		$("input[name='auditStartDate']").val(auditStartDate);
		$("input[name='auditEndDate']").val(auditEndDate);
		$("input[name='publishDate']").val(publishDate);
		$("input[name='memo']").val(memo);
		$("input[name='id']").val(id);
		if(checkout()){
			var url = pathHeader + "/master/updateComparison.do";
			$("#proForm").ajaxSubmit({
				url:url,
				async:false,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.success){
						urlGo=pathHeader +"/master/toManageComparison.htm";	
						jQuery.generalAlertAndJump(data.message,urlGo);
					}else{
						jQuery.generalAlert(data.message);
					}
				},
				error:function(){
					jQuery.generalAlert("新增失败");
				}
			});
		}
		
		
	}
}

/**
 * 检测数据正确
 * @returns {Boolean}
 */
function checkout(){
	//校验活动名称
	$('#comparisonNameErr').html("");
	if($("#comparisonNameValue").val()==null||$("#comparisonNameValue").val()==""){
		$('#comparisonNameErr').html("名称不能为空!");
		return false;
	}
	//校验活动年度
	$('#comparisonYearErr').html("");
	if($("#comparisonYearValue").val()==null||$("#comparisonYearValue").val()==""){
		$('#comparisonYearErr').html("年度不能为空!");
		return false;
	}
	//开始日期验证
	$('#signupStartDateErr').html("");
	if($("#signupStartDateValue").val()==null||$("#signupStartDateValue").val()==""){
		$('#signupStartDateErr').html("报名开始日期不能为空!");
		return false;
	}else{
	    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
	    var r = $("#signupStartDateValue").val().match(reg);    
	    if(r==null){
	    	$('#signupStartDateErr').html("输入的日期格式不正确!");
			return false;
	    }
	}
	//结束日期验证
	$('#signupEndDateErr').html("");
	if($("#signupEndDateValue").val()==null||$("#signupEndDateValue").val()==""){
			$('#signupEndDateErr').html("报名截止日期不能为空!");
			return false;
	}else{
	    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
	    var r = $("#signupEndDateValue").val().match(reg);    
	    if(r==null){
	    	$('#signupEndDateErr').html("输入的日期格式不正确!");
			return false;
	    }else if($("#signupStartDateValue").val().replace(/-/g, "") - $("#signupEndDateValue").val().replace(/-/g, "") > 0){
	    	$('#signupEndDateErr').html("开始日期大于结束日期");
			return false;
	    }
	}
	
	//审核开始日期验证
	$('#auditStartDateErr').html("");
	if($("#auditStartDateValue").val()==null||$("#auditStartDateValue").val()==""){
		$('#auditStartDateErr').html("审核开始日期不能为空!");
		return false;
	}else{
	    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
	    var r = $("#auditStartDateValue").val().match(reg);    
	    if(r==null){
	    	$('#auditStartDateErr').html("输入的日期格式不正确!");
			return false;
	    }
	}
	//审核结束日期验证
	$('#auditEndDateErr').html("");
	if($("#auditEndDateValue").val()==null||$("#auditEndDateValue").val()==""){
			$('#auditEndDateErr').html("审核截止不能为空!");
			return false;
	}else{
	    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
	    var r = $("#auditEndDateValue").val().match(reg);    
	    if(r==null){
	    	$('#auditEndDateErr').html("输入的日期格式不正确!");
			return false;
	    }else if($("#auditStartDateValue").val().replace(/-/g, "") - $("#auditEndDateValue").val().replace(/-/g, "") > 0){
	    	$('#auditEndDateErr').html("开始日期大于结束日期");
			return false;
	    }
	}
	//活动类型
	$('#comparisonTypeErr').html("");
	if($("#comparisonTypeValue").val()==null||$("#comparisonTypeValue").val()==""){
		$('#comparisonTypeErr').html("活动类型不能为空");
		return false;
	}
	//公布日期验证
	$('#publishDateErr').html("");
	if($("#publishDateValue").val()==null||$("#publishDateValue").val()==""){
		$('#publishDateErr').html("公布日期不能为空!");
		return false;
	}else{
	    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;  
	    var r = $("#publishDateValue").val().match(reg);    
	    if(r==null){
	    	$('#publishDateErr').html("输入的日期格式不正确!");
			return false;
	    }
	}
	
	//单位参评额度
	$('#comparisonNumErr').html("");
	if($("#comparisonNumValue").val()==null||$("#comparisonNumValue").val()==""){
		$('#comparisonNumErr').html("单位参评额度不能为空!");
		return false;
	}else if(isNaN($("#comparisonNumValue").val())){
		$('#comparisonNumErr').html("单位参评额度不能是非数字!");
		return false;
	}
	
	//单位参评范围
	if($("input[name='schools']").val()==null||$("input[name='schools']").val()==""){
		$('#schoolsErr').html("参评单位范围不能为空!");
		return false;
	}
	
	return true;
}

/**
 * 上传附件相关
 * @param o
 */
function removeMe(o){
	$(o).parent().remove();
}
function addMore(){
	var tr = "<tr><td width='260' colspan='2'><input type='file' name='file'/><a onclick='removeMe(this)'>删除</a></td></tr>";
	$("#files").append(tr);
}

////////////参评单位相关////////////////////
/**
 * 弹出选择学校窗口
 */
function showS(){
	$("#tip").show();
	getProvince();
}
/**
 * 隐藏窗口
 */
function hideMe(){
	$("#tip").hide();
}
/**
 * 获取省
 */
function getProvince(){
	$("#province").html("");
	var url = pathHeader + "/master/getArea.do";
	var tr = ""
	$.ajax({
		url:url,
		data:{
			code:provinceId
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				var obj = data.rows[0];
				var tr = "<a onclick='getCity("+obj.code+")'>"+obj.name+"</a>";
				$("#province").append(tr);
				getCity();
				getSchool(provinceId,"1");
			}
//			$("#city").append(tr);
//			getDistrict(cityCode.join(","));
//			getSchool(provinceId,"1");
		},
		error:function(){
			
		}
	});
}

/**
 * 获得市
 */
function getCity(){
	$("#city").html("");
	var url = pathHeader + "/master/getArea.do";
	
	$.ajax({
		url:url,
		data:{
			id:provinceId
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				var cityCode = new Array();
				var tr = "<tr>"
				var count = 0;
				$.each(data.rows, function(key, value) {
					tr +="<td><a onclick='getDistrict("+value.code+")'>"+value.name+"</a></td>";
					cityCode.push(value.code);
					if( i != 0 && ((++count)%8) == 0){
						tr +="</tr><tr>"
					}
				});
				tr+="</tr>"
			}
			$("#city").append(tr);
			getDistrict(cityCode.join(","));
			getSchool(provinceId,"1");
		},
		error:function(){
			
		}
	});
}
function getDistrict(code){
	$("#district").html("");
	var url = pathHeader + "/master/getArea.do";
	
	$.ajax({
		url:url,
		data:{
			id:code
		},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				var tr = "<tr>"
				var count = 0;
				$.each(data.rows, function(key, value) {
					tr +="<td><a onclick='getSchool("+value.code+",3)'>"+value.name+"</a></td>";
					if( i != 0 && ((++count)%8) == 0){
						tr +="</tr><tr>"
					}
				});
				tr += "</tr>";
			}
			$("#district").append(tr);
			getSchool(code,"2");
		},
		error:function(){
			
		}
	});
}
var allSchools;
function getSchool(areaId, areaType){
	if(areaType == 1){
		areaType = "provinceId";
	}else if(areaType == 2){
		areaType = "cityId";
	}else if(areaType == 3){
		areaType = "districtId";
	}
	$("#school").html("");
	var url = pathHeader + "/master/getSchool.do";
	var tr = ""
	$.ajax({
		url:url,
		data:{
			areaType:areaType,
			areaId:areaId
		},
		type:"post",
		async:false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				allSchools = rows;
				var girdHtml = "<tr >";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					if(isCkecked(obj.schoolId)){
						girdHtml +="<td><input id='checkSchools' type='checkbox' value='"+obj.schoolId+"' name='"+obj.schoolName+"' onclick='setValues(this)' checked='checked'>&nbsp"+obj.schoolName+"</td>";
					}else{
						girdHtml +="<td><input id='checkSchools' type='checkbox' value='"+obj.schoolId+"' name='"+obj.schoolName+"' onclick='setValues(this)'>&nbsp"+obj.schoolName+"</td>";
					}
					if( i != 0 && ((i+1)%3) == 0){
						girdHtml +="</tr><tr>"
					}
				}
				girdHtml +="</tr>";
				$("#school").html(girdHtml);
			}
		},
		error:function(){
			
		}
	});
}
function isCkecked(sId){
	for(var i = 0 ; i < checkScool.length ; i++){
		if(checkScool[i].schoolId == sId){
			return true;
		}
	}
	return false;
}
function setValues(obj){
	var school = {
			schoolId:obj.value,
			schoolName:obj.name
		}
	var flag = true;
	for(var i = 0 ; i < checkScool.length ; i++){
		if(checkScool[i].value == school.schoolId){
			flag = false;
		}
	}
	if(flag && obj.checked){
		checkScool.push(school);
	}
	if(!obj.checked){//取消选择
		var index = -1;
		for(var i = 0 ; i < checkScool.length ; i++){
			if(checkScool[i].schoolId == school.schoolId){
				checkScool.splice(i, 1);
				break;
			}
		}
	}
}
function setSchool(){
	$("input[name='schools']").val("");
	$("input[name='schoolNames']").val("");
	if(checkScool.length>0){
		var names = "";
		var id_name = "";
		for(var i = 0;i<checkScool.length;i++){
			var obj = checkScool[i];
			names += obj.schoolName+",";
			id_name += obj.schoolId + "-" +  obj.schoolName+",";
		}
		
		$("input[name='schools']").val(id_name.substring(0,id_name.length-1));
		$("input[name='schoolNames']").val(names.substring(0,names.length-1));
		
		$("#tip").hide();
	}else{
		jQuery.generalAlert("请选择学校");	
	}
	
}

//学科全选
function selectAllSub(){
	var CheckStatus = $("#isAll").attr("checked");
	if(CheckStatus){
		$("[id='checkSchools']").attr("checked",true);
		//触发全选
		selectAll();
	}else{
		$("[id='checkSchools']").attr("checked",false);
		//取消全选
		unSelectAll();
	}
}
//全选操作
function selectAll(){
	for(var i = 0; i < allSchools.length; i++){
		var school = {
			schoolId:allSchools[i].schoolId,
			schoolName:allSchools[i].schoolName
		}
		for(var j = 0 ; j < checkScool.length; j ++){
			if(checkScool[j].schoolId == school.schoolId){
				checkScool.splice(j, 1);
		     }
		}
		checkScool.push(school);
	}
}

//取消全选
function unSelectAll(){
	for(var j = 0 ; j < checkScool.length ; j++){
		for(var n = 0 ; n < allSchools.length ; n++){
			var schoolId = allSchools[n].schoolId;
			if(checkScool[j] != null && checkScool[j].schoolId == schoolId){
				checkScool.splice(j,1);
			}
		}
	}
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