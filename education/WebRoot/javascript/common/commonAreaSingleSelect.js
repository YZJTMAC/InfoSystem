$(function() {

	$(".areaSelect").click(function() {
		areaList(0, 'provinceId');
		$(".tip11").fadeIn(200);
	});

	$(".tiptop a").click(function() {
		clear();
	});
});

// 省地区ID
var provinceId = 0;
var provinceName = "";
// 市地区
var cityId = 0;
var cityName = "";

// 地区ID
var districtId = 0;
var districtName = "";

// 筛选条件数组
var chilkQueryConditionArray = [];

var chilkQueryConditionHtml = [];

var waitPushCondition = [];

var indexFlag = 0;

function addAreaQueryCondition(belone, area, text) {
	var gridHtml = "<li class='area'><span><a href='###' id='" + belone + "_"
			+ area + "_" + text + "' >" + text + "</a></span></li>";
	gridHtml += "<li class='flag'>&gt;</li>";
	chilkQueryConditionArray[indexFlag] = belone + "_" + area + "_" + text;
	chilkQueryConditionHtml.push(gridHtml);
	$('#childCondition').append(gridHtml);
	indexFlag++;
}

function addSchoolQueryCondition(id, value, text) {
	chilkQueryConditionArray[indexFlag] = id + "_" + value + "_" + text;
	var gridHtml = "<li class='area nowThis'><span><a href='###'  id='" + id
			+ "_schoolId_" + text + "'>" + text
			+ "</a></span><a href='###' class='closed' title='删除'><img src='"
			+ pathHeader
			+ "/images/closed2.jpg' width='9' height='9'></a></li>";
	chilkQueryConditionHtml.push(gridHtml);
	$('#childCondition').append(gridHtml);
}

///**
// * 最后确认, 个开发人 自己实现
// */
//function lastForSure() {
//	var temp = waitPushCondition[0].split("_");
//	
//	var id = temp[temp.length -3];
//	var area = temp[temp.length -2];
//	var text = temp[temp.length -1];
////	alert(id);
////	alert(text);
//	$('#selectSchoolId').val(id);
//	$('#schoolName').val(text);
////	addQueryCondition(9, "", "地区：" +text);
//	clear();
//	
//}

function clear() {
	//清空
	chilkQueryConditionArray = [];
	chilkQueryConditionHtml = [];
	waitPushCondition = [];
	$(".area").remove();
	$('.flag').remove();

	$(".tip11").fadeOut(200);
}

/**
 * 一级确认
 */
function forSure() {
	for ( var i = chilkQueryConditionHtml.length - 1; i >= 0; --i) {
		$('#selectedPlace').after(chilkQueryConditionHtml[i]);
		if (i == chilkQueryConditionHtml.length - 1) {
			waitPushCondition.push($(chilkQueryConditionHtml[i]).children()
					.children().attr("id"));
		}
	}
}

/**
 * 退到上一级
 */
function hisback() {
	//	chilkQueryConditionArray.pop();
	//	var newArray = chilkQueryConditionArray[chilkQueryConditionArray.length -1].split("_");
	//	var text = newArray[newArray.length -1];
	//	var area = newArray[newArray.length -2];
	//	var belong = newArray[newArray.length -3];
	//	alert(area);
	//	if(area == 'cityId' || area == 'districtId'){
	//		areaList(belong, area, text);
	//	}
}

function areaList(belong, area, text) {
	var url = pathHeader + "/sys/curLoginAreaList.do";
	$.ajax( {
		url : url,
		data : {
			area : area,
			belong : belong
		},
		dataType : "json",
		type : "post",
		async : true,
		success : function(data) {
			if (data.success) {
				var obj = eval(data.obj);
				if (obj.length > 0) {
					if (area == 'cityId') {
						$('#cityId').html("");
						queryStdutySection();
						$('#' + area).append(cHtml(obj));
						provinceId = belong;
						provinceName = text;
						addAreaQueryCondition(belong, "provinceId", text);
					} else if (area == 'districtId') {
						$('#cityId').html("");
						$('#cityId').append(dHtml(obj));
						cityId = belong;
						cityName = text;
						addAreaQueryCondition(belong, "cityId", text);
					} else if (area == 'schoolId') {
						alert('school');
					} else if (area == 'provinceId') {
						$('#' + area).html("");
						$('#' + area).append(pHtml(obj));
					}
				}
			}
		},
		error : function() {
		}

	});
}
/**
 * 地区
 * @param {Object} obj
 * @return {TypeName} 
 */
function dHtml(obj) {
	var htmlStr = "";
	for ( var i = 0; i < obj.length; i++) {
		htmlStr += "<dd><input type='checkbox'>";
		if (obj[i].schoolCount > 0) {
			districtId = obj[i].code;
			districtName = obj[i].name;
			htmlStr += "<a href='###' onclick='querySchool();addAreaQueryCondition("
					+ obj[i].code
					+ ", \"districtId\", \""
					+ obj[i].name
					+ "\");' class='tablelink'>" + obj[i].name ;
			htmlStr += "<img src='" + pathHeader
					+ "/images/more.jpg' width='13' height='13'></a>";
		} else {
			htmlStr += "<a href='###' class='tablelink'>" + obj[i].name
					+ "</a>";
		}
		htmlStr += "</dd>";
	}
	return htmlStr;
}

/**
 * 市
 * @param {Object} obj
 * @return {TypeName} 
 */
function cHtml(obj) {
	var htmlStr = "";
	for ( var i = 0; i < obj.length; i++) {
		htmlStr += "<dd><input type='checkbox'>";
		if (obj[i].childrenCount > 0) {
			htmlStr += "<a href='###' onclick='areaList(" + obj[i].code
					+ ", \"districtId\", \"" + obj[i].name
					+ "\")' class='tablelink'>" + obj[i].name;
			htmlStr += "<img src='" + pathHeader
					+ "/images/more.jpg' width='13' height='13'></a>";
		} else {
			htmlStr += "<a href='###' class='tablelink'>" + obj[i].name
					+ "</a>";
		}
		htmlStr += "</dd>";
	}
	return htmlStr;
}

/**
 * 大区-省
 * @param {Object} obj
 * @return {TypeName} 
 */
function pHtml(obj) {
	var htmlStr = "<dl>";
	htmlStr += "<dt>东北地区</dt>";
	for ( var i = 0; i < obj.length; i++) {
		if (obj[i].childrenCount > 0) {
			htmlStr += "<dd><a href='###' onclick='areaList(" + obj[i].code
					+ ", \"cityId\", \"" + obj[i].name + "\")' >" + obj[i].name
					+ "</a></dd>";
		} else {
			htmlStr += "<dd><a href='###' >" + obj[i].name + "</a></dd>";
		}
	}
	htmlStr += "</dl>";
	return htmlStr;
}

/**
 * 查询学段
 */
function queryStdutySection() {
	var url = pathHeader + "/sys/queryDicByType.do";

	$.ajax( {
		url : url,
		data : {
			dicType : 'stduty_section'
		},
		type : "post",
		async : false,
		success : function(data) {
			if (data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index, element) {
					gridHtml += "<td width='80'>";
					gridHtml += "<INPUT  name='schoolTypeId' value='"
							+ element.dictionaryId + "' type='radio' >";
					gridHtml += element.dictionaryName;
					gridHtml += "</td>";
				});
				$('#querySection').after(gridHtml);
			} else {
			}
		},
		error : function() {

		}
	});
}

/**
	 * 学校
	 * @param {Object} obj
	 * @return {TypeName} 
	 */
function querySchool() {
	var schoolTypeId = $('input:radio[name="schoolTypeId"]:checked').val();
	$.ajax({
		url: pathHeader + "/sys/querySchool.do",
		data:{
			schoolTypeId:schoolTypeId,
			schoolDistrictId:districtId,
			schoolName:$('#schoolName').val()
		},
		dataType:"json",
		type:"post",
		async:true,
		success:function(data){
			$('#schoolId').html("");
			if(data.success){
				var obj = eval(data.rows);
				if(obj.length > 0){
					var htmlStr = "<tr>";
						for(var i=0; i<obj.length; i++){
							htmlStr += "<td width=\"200\"><a href=\"###\" onclick='addSchoolQueryCondition("+obj[i].schoolId+", \"schoolId\", \""+obj[i].schoolName+"\")' class=\"tablelink\">"+obj[i].schoolName+"</a></td>";
						}
						htmlStr += "</tr>";
					$('#cityId').hide();
					$('.sanji').show();
					$('#schoolId').append(htmlStr);
				}
			}
		},
		error:function(){
			alert(" error");
		}
	});

} 
