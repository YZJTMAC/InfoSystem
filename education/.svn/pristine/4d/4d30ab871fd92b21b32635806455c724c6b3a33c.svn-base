$(function(){
	// 查询地区
	areaList(0, 'root','');
	
	$(".areaSelect").click(function(){
		clear();
  		$(".tip11").fadeIn(200);
//		$("#selectArea").fadeIn(200);
  	});
	
	$(".tiptop a").click(function() {
		clear();
	});
});

function areaSelect(){
	clear();
  	$(".tip11").fadeIn(200);
}


var lastSelect = "";

// 地区ID
var districtId=0;

// 筛选条件数组
var chilkQueryConditionArray = [];

var chilkQueryConditionHtml= [];

var waitPushCondition = [];

var indexFlag = 0;

//展现筛选查询
function showAreaQueryCondition(backHis) {
	$(".area").remove();
	$('.flag').remove();
	var flag = 1;
	for ( var i=chilkQueryConditionArray.length-1; i>=0; --i ){
		if(chilkQueryConditionArray[i] != null && chilkQueryConditionArray[i] != "" && chilkQueryConditionArray[i].length > 0) {
			var conditionArray = chilkQueryConditionArray[i].split("_");
			var belone = conditionArray[0];
			var area = conditionArray[1]
			var text = conditionArray[2]
			if(area == "schoolId") {
				addSchoolQueryCondition(belone,"", text );
			} else {
				if(backHis == 1 && flag == 1 ) {
					$('#schoolId').html("");
					$('#cityId').html("");
					if(area == 'districtId') {
						districtId = belone;
						querySchool();
					} else if(area == 'cityId') {
						areaListB(belone, 'districtId', text);
					} else if(area == 'provinceId') {
						areaListB(belone, 'cityId', text);
					}
					
					flag ++;
				}
				addAreaQueryCondition(belone, area, text);
			}
		}
	}
}

function addAreaQueryCondition(belone, area, text) {
//	lastSelect = area +"_" + belone +"_" + text;
	var gridHtml = "<li class='area'><span><a href='###' id='"+belone+"_"+ area + "_"+ text+ "' >"+text+"</a></span></li>";
	gridHtml += "<li class='flag'>&gt;</li>";
	$('#selectedPlace').after(gridHtml);
	indexFlag ++;
}

function addSchoolQueryCondition(id, value, text) {
	lastSelect = id +"_schoolId_" + text;
	var gridHtml = "<li class='area nowThis'><span><a href='###'  id='"+id+"_schoolId_"+ text+ "'>"+text+"</a></span><a href='###' class='closed' title='删除'><img src='"+pathHeader +"/images/closed2.jpg' width='9' height='9'></a></li>";
	$('#selectedPlace').after(gridHtml);
}

function clear() {
	//清空
	chilkQueryConditionArray = [];
	chilkQueryConditionHtml = [];
	waitPushCondition = [];
	$('#schoolId').html("");
	$('#cityId').html("");
	$(".area").remove();
	$('.flag').remove();
	$("#XXshow").fadeOut(200);
}

/**
 * 一级确认
 */
function forSure() {
	for ( var i=chilkQueryConditionHtml.length-1; i>=0; --i ){  
		$('#selectedPlace').after(chilkQueryConditionHtml[i]);
		if(i == chilkQueryConditionHtml.length-1) {
			waitPushCondition.push($(chilkQueryConditionHtml[i]).children().children().attr("id"));
		}
	} 
}

function districtNoClick(area, text) {
	hisbackToLocation("districtId");
	lastSelect = area + "_districtId_"  + text;
}

function districtClick(area, text) {
	hisbackToLocation("districtId");
	lastSelect = area + "_districtId_"  + text;
	chilkQueryConditionArray[indexFlag]= lastSelect;
	showAreaQueryCondition();
}

function cityClick(area, text) {
	hisbackToLocation("cityId");
	lastSelect = area + "_cityId_"  + text;
	chilkQueryConditionArray[indexFlag]= lastSelect;
	showAreaQueryCondition();
}

function schoolClick(area, text) {
	hisbackToLocation("schoolId");
	lastSelect =  area + "_schoolId_" + text;
	chilkQueryConditionArray[indexFlag]= lastSelect;
	showAreaQueryCondition();
}

function provinceClick(area, text) {
	chilkQueryConditionArray = [];
	$('#cityId').html("");
	$('#schoolId').html("");
	hisbackToLocation("provinceId");
	lastSelect =  area + "_provinceId_" + text;
	chilkQueryConditionArray[indexFlag]= lastSelect;
	showAreaQueryCondition();
}
/**
 * 退到上一级
 */
function hisback() {
	
	var flag = false;
	var obj = chilkQueryConditionArray.pop();
	while(obj == null && chilkQueryConditionArray.length > 0) {
		// 回退并删除元素
		obj = chilkQueryConditionArray.pop();
		
	}
	showAreaQueryCondition(1);
	if(obj == null || obj.length == 0) { return;}
	
	// 设置最后一级标记
	var conditionArray = obj.split("_");
	var areaA = conditionArray[1]
	if(areaA == "provinceId") {
		flag = true;
	}
		
	//当清除到最后一级 ，清除地区 内容
	if(flag) {
		chilkQueryConditionArray = [];
		$('#schoolId').html("");
		$('#cityId').html("");
	}
}

/**
 * 退回到指定一级
 * @param {Object} area
 */
function hisbackToLocation(area, replace) {
	var flag = false;
	for ( var i=chilkQueryConditionArray.length-1; i>=0; --i ){
		if(chilkQueryConditionArray[i] != null && chilkQueryConditionArray[i] != "" && chilkQueryConditionArray[i].length > 0) {
			var conditionArray = chilkQueryConditionArray[i].split("_");
			var belone = conditionArray[0];
			var areaA = conditionArray[1]
			var text = conditionArray[2]
			if(areaA == area) {
				flag = true;
				chilkQueryConditionArray.splice(i,1,replace)
			}
		}
	}
	if(!flag) {
		chilkQueryConditionArray[indexFlag]= replace;
	}
}


function areaListB(belong, area, text){
	var url = pathHeader + "/edupm/projectmanage/curAreaList.do";
	$.ajax({
		url:url,
		data:{
			area:area,
			belong:belong,
			projectId:proId
		},
		dataType:"json",
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = eval(data.obj);
				if(obj.length > 0){
					if(area == 'cityId'){
						//省 默认清空数组
//						chilkQueryConditionArray = [];
//						$('#cityId').html("");
						$('#'+area).append(cHtml(obj));
						lastSelect = belong + "_provinceId_"+ text;
						$('#cityId').show();
						$('.sanji').hide();
					}else if(area == 'districtId'){
						//默认退回到市级 
						$('#cityId').show();
						$('#cityId').html("");
						$('#cityId').append(dHtml(obj));
						lastSelect = belong +"_cityId_" + text;
					} else if(area =='schoolId'){
					}else if(area =='provinceId'){
						$('#'+area).html("");
						$('#'+area).append(pHtml(obj));
					}
				}
			}
		},
		error:function(){
			alert("error");
		}
	});
	}
	
function areaList(belong, area, text){
	var url = pathHeader + "/edupm/projectmanage/curAreaList.do";
	$.ajax({
		url:url,
		data:{
			area:area,
			belong:belong,
			projectId:proId
		},
		dataType:"json",
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = eval(data.obj);
				if(obj.length > 0){
					if(area == 'cityId'){
						//省 默认清空数组
						chilkQueryConditionArray = [];
						$('#cityId').html("");
						$('#'+area).append(cHtml(obj));
						lastSelect = belong + "_provinceId_"+ text;
						chilkQueryConditionArray[indexFlag]= lastSelect;
						showAreaQueryCondition();
						$('#cityId').show();
						$('.sanji').hide();
					}else if(area == 'districtId'){
						//默认退回到市级 
						$('#cityId').html("");
						$('#cityId').append(dHtml(obj));
						lastSelect = belong +"_cityId_" + text;
						hisbackToLocation("cityId", lastSelect);
						showAreaQueryCondition();
					} else if(area =='schoolId'){
					}else if(area =='root'){
						$('#provinceId').html("");
						$('#provinceId').append(pHtml(obj));
					}
				}
			}
		},
		error:function(){
			alert("error");
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
		for(var i=0; i<obj.length; i++){
			htmlStr += "<dd>";
			if(obj[i].schoolCount > 0) {
				districtId = obj[i].code;
				htmlStr += "<a href='###' onclick='districtClick("+districtId+", \""+obj[i].name+"\" );' class='tablelink'>" + obj[i].name ;
				htmlStr += "<img src='"+pathHeader+"/images/more.jpg' width='13' height='13'></a>";
			} else {
				htmlStr += "<a href='###' onclick='districtClick("+districtId+", \""+obj[i].name+"\" );' class='tablelink'>" + obj[i].name + "</a>";
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
		for(var i=0; i<obj.length; i++){
			htmlStr += "<dd>";
			if(obj[i].childrenCount > 0) {
				htmlStr += "<a href='###' onclick='areaList(" + obj[i].code + ", \"districtId\", \"" + obj[i].name + "\")' class='tablelink'>" + obj[i].name ;
				htmlStr += "<img src='"+pathHeader+"/images/more.jpg' width='13' height='13'></a>";
			} else {
				htmlStr += "<a href='###' onclick='cityClick("+obj[i].code+", \""+obj[i].name+"\" );' class='tablelink'>" + obj[i].name + "</a>";
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
		htmlStr += "<dt></dt>";
		for(var i=0; i<obj.length; i++){
			if(obj[i].childrenCount > 0) {
				htmlStr += "<dd><a href='###' onclick='areaList(" + obj[i].code + ", \"cityId\", \"" + obj[i].name + "\")' >" + obj[i].name + "</a></dd>";
			} else {
				htmlStr += "<dd><a href='###' onclick='provinceClick(" + obj[i].code + ", \"" + obj[i].name + "\")'>" + obj[i].name + "</a></dd>";
			}
		}
		htmlStr += "</dl>";
		return htmlStr;
	}
	
	/**
	 * 查询学段
	 */
	function queryStdutySection(){
		var url = pathHeader+ "/sys/queryDicByType.do";
	
		$.ajax({
			url:url,
			data:{dicType:'stduty_section'},
			type:"post",
			async:false,
			success:function(data){
				if(data.success) {
					var objList = data.rows;
					var gridHtml = "";
					$.each(objList, function(index,element) {
						gridHtml += "<td width='80'>";
						gridHtml += "<INPUT  name='schoolTypeId' value='"+element.dictionaryId+"' type='radio' >";
						gridHtml += element.dictionaryName;
						gridHtml += "</td>";
					});
					$('#querySection').after(gridHtml);
				} else {
				}
			},
			error:function(){
				
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
							htmlStr += "<td width=\"200\"><a href=\"###\" onclick='schoolClick("+obj[i].schoolId+", \""+obj[i].schoolName+"\")' class=\"tablelink\">"+obj[i].schoolName+"</a></td>";
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