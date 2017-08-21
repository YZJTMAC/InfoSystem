$(function(){
	showOrgProjectTeachers();
	// 查询地区
	//areaList(0, 'provinceId');
	// 查询学科
	querySubject();
	//$('#cityId').append("<option value=''>请选择市</option>");
	//$('#districtId').append('<option value="">请选择区/县</option>');
	//$('#schoolId').append('<option value="">请选择学校</option>');
/**	
	 省变更	$('#provinceId').change(function(){
		$('#cityId').empty();
		$('#cityId').append("<option value=''>请选择市</option>");
		$('#districtId').empty();
		$('#districtId').append('<option value="">请选择区/县</option>');
		$('#schoolId').empty();
		$('#schoolId').append('<option value="">请选择学校</option>');
		if($(this).val() == ''){
			return false;
		}
		areaList($(this).val(), 'cityId');
	});
	
	 市变更	$('#cityId').change(function(){
		$('#districtId').empty();
		$('#districtId').append('<option value="">请选择区/县</option>');
		$('#schoolId').empty();
		$('#schoolId').append('<option value="">请选择学校</option>');
		if($(this).val() == ''){
			return false;
		}
		areaList($(this).val(), 'districtId');
	});
	
	 区/县变更	$('#districtId').change(function(){
		$('#schoolId').empty();
		$('#schoolId').append('<option value="">请选择学校</option>');
		if($(this).val() == ''){
			return false;
		}
		areaList($(this).val(), 'schoolId');
	});
	*/
	// 条件查询
	$("#select").click(function() {
		showOrgProjectTeachers();
	});
	
});

// 创建opt
function createOpt(rows,sid){
	for(var i = 0;i<rows.length;i++){
		var opt = "<option value='"+rows[i].dictionaryName+"'>"+rows[i].dictionaryName+"</option>";
		$("#"+sid).append(opt);
	}
}

/**
 * 查询学科
 */
function querySubject(){
	queryDic("project_subject")
	if(subject.length > 0){
		createOpt(subject,"subject");
	}
}

/**
 * 查询字典表
 */
var section;
var subject;
function queryDic(dicType){
	var url = pathHeader+ "/sys/queryDicByType.do";
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				if(dicType == "project_subject"){
					subject = data.rows;
				}else if(dicType == "stduty_section"){
					section = data.rows;
				}
			}
		},
		error:function(){
			
		}
	});
}
/**
 function areaList(belong, area){
	var url = pathHeader + "/sys/areaList.do";
	$.ajax({
		url:url,
		data:{
			belong:belong
		},
		dataType:"json",
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = eval(data.obj);
				if(obj.length > 0){
					for(var i=0; i<obj.length; i++){
						$opt2 = $("<option value='" + obj[i].code + "'>" + obj[i].name + "</option>");
						$('#'+area).append($opt2);
					}
				}
			}
		},
		error:function(){
			alert(" error");
		}
	});
}
*/


var provinceId = '';
var provinceName= '';
var cityId= '';
var cityName= '';
var districtId= '';
var districtName = '';
var schoolId = '';
var schoolName = '';
function showOrgProjectTeachers(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgProjectTeachers.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId : projectId,
			provinceId : provinceId,
			cityId : cityId,
			districtId : districtId,
			schoolId : schoolId,
			subject : $('#subject').find("option:selected").val(),
			pageIndex : pageIndex
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				//$('#projectName').html('项目名称：'+objList[0].projectName);
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#orgProject_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
			pagination(data, function(){showOrgProjectTeachers();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.teacherNo)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.realName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.idNumber)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.teachingSubject)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.schoolProvinceName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.schoolCityName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.schoolDistrictName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.schoolName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.mobile)+"</td>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
}


function lastForSure() {
	clear2();
	if(lastSelect != null && lastSelect.length > 0) {
		var tempArray = lastSelect.split("_");
		if(tempArray[1] == "provinceId") {
			provinceId = tempArray[0];
			provinceName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(provinceName);
		} else if(tempArray[1] == "cityId") {
			cityId = tempArray[0];
			cityName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(cityName);
		} else if(tempArray[1] == "districtId") {
			districtId = tempArray[0];
			districtName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(districtName);
		} else if(tempArray[1] == "schoolId"){
			schoolId = tempArray[0];
			schoolName = tempArray[2];
			$('#schoolName').val('');
			$('#schoolName').val(schoolName);
		}
	}
	clear();
}


function clear2(){
	provinceId = '';
	cityId = '';
	districtId = '';
	schoolId = '';
}


function exportTeacher(){
	var subject = $('#subject').find("option:selected").val();
	$("#downIframe",document.body).attr("src",pathHeader + "/org/exportTeacher.do?projectId="+projectId+"&provinceId="+provinceId+"&cityId="+cityId+"&districtId="+districtId+"&schoolId="+schoolId+"&subject="+subject);
}

