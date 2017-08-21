$(function(){
	showTeacherProScoreInfo();
	// 查询学科
	querySubject();
	// 条件查询
	$("#select").click(function() {
		showTeacherProScoreInfo();
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


var provinceId = '';
var provinceName= '';
var cityId= '';
var cityName= '';
var districtId= '';
var districtName = '';
var schoolId = '';
var schoolName = '';

function showTeacherProScoreInfo(){
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/edupm/teachermanage/teacherProScoreInfo.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectId : projectId,
			teacherName : $('#teacherName').val(),
			idNumber : $('#idNumber').val(),
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
				$('#projectName').html(objList[0].projectName);
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proTeacher_list').append(gridHtml);
				pagination(data, function(){showTeacherProScoreInfo();});
			} else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
				$('#proTeacher_list').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
			$('#proTeacher_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+objFormatter(obj.realName)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.idNumber)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.teachingSubject)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.schoolProvinceName)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.schoolCityName)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.schoolDistrictName)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.schoolName)+"</td>";
	gridHtml += "<td>"+objFormatter(obj.score)+"</td>";
	
	return gridHtml;
	
	function objFormatter(obj){
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