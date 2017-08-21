$(function(){
	initEduModel();
	initEduProject();
	qrySubject();
	querySection();
	queryList();
	$("input[type='checkbox']").click(function(){
		if($(this).attr("checked")){
			var name = $(this).attr("name");
			$("hasSelected").append(name); 
		}
	});
	
})
/**
 * 初始列表数据
 */
function queryList(){
	var model = $('#eduModelType').val();
	var project = $('#eduProject').val();
	var areaId = $('#areaId').val();
	var areaType = $('#areaType').val();
	var gender = $('#gender').val();
	var subs = $("input[name='subjectId']").val();
	var ageStart = $('#beginDate').val();
	var ageEnd = $('#endDate').val();
	var url = pathHeader + "/edupm/paper/questionSurverSummaryList.do";
	$('#targetList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			model:model,
			project:project,
			areaId:areaId,
			gender:gender,
			subs:subs,
			ageStart:ageStart,
			ageEnd:ageEnd,
			areaType:areaType
		},
		beforeSend: function(){
			$('#targetList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			
			var rows = data.rows;
			var totalNum = data.totalNum;
			
			
			$('#totalNum').html("<br/>参加调研人数:"+totalNum);
			
			
			
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#targetList').html(gridHtml);
//				pagination(data, function(){projectList();});
			}else{
				$('#targetList').html("<tr><td colspan='14'>无查询记录</td></tr>");
//				pagination(data, function(){projectList();});
			}
		},
		error:function(){
			$('#targetList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}

/**
 * 继教信息板块
 */
function initEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
				if(data.success){
					var rows = data.rows;
//					var opts = "";
					var opts = "<option value=''>全部板块...</option>";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+(obj.id)+"'>";
					opts += obj.name;
					opts+="</option>";
				}
				$("select[name='eduModelType']").html(opts);
				}
		},
		error:function(){
			$('#eduModelType').html("<option value=''>无记录</option>");
		}
		
	});
}

/**
 * 项目列表
 */
function initEduProject(){
	var url = pathHeader+ "/edupm/projectmanage/queryProjectByStatus.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			eduModelType:$('#eduModelType').val(),
			pageSize:999,
			startIndex:1
		},
		async: false,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				$('#eduProject').html("");
				var opts = "<option value=''>全部项目...</option>";
				$.each(rows, function(index,element) {
					opts += getTdHtml(element);
				});
				$("select[name='eduProject']").html(opts);
			}else {
				$('#eduProject').html("<option value=''>全部项目...</option>");
			}
		},
		error:function(){
			
		}
		
	});
}

/**
 * 查询列表
 */
function showInfoList(){
	if(validateYear()){
		queryList();
	}else{
		jQuery.generalAlert("请选择正确的年龄范围");
	}
	
}
/**
 * 地区查询
 */
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$('#areaName').val(text);
		$('#areaType').val(areaA);
		$('#areaId').val(belone);
	}
	//清空
	clear();
	$(".tip11").fadeOut(200);
}







//全选操作
var h = "";
function selectAll(allSubjectData,sectionId){
	h = allSubjectData.length;
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		};
		
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				subAry.splice(j,1);
				$("[name='"+obj.dictionaryName+"']").attr("checked",true);
			}
		}
		
		if($("[id='"+sectionId+"']").attr("checked")){
			subAry.push(sub);
		}
	}	
		$("#hasSelected").html("");
		for(var i = 0;i<subAry.length;i++){
			$("#hasSelected").append(subAry[i].subjectName+" ");
		}
}






function getTdHtml(obj){
	var opts ="<option value='"+(obj.id)+"'>";
	opts += obj.projectName;
	opts+="</option>";
	return opts;
}



function showS(){
	$("#XDXKshow").show();
	$("#showCheck").css("display","none");
	showSection();
}

function hideMe(){
	$("#XDXKshow").hide();
}
/**
 * 查询学段
 */
function querySection(){
	queryDic("stduty_section");//从字典表中插得学段
	if(section.length > 0){
		var girdHtml = "<tr>";
		for(var i = 0;i<section.length;i++){
			var obj = section[i];
			girdHtml +="<td><a id='target' href='javascript:qrySubject(\""+obj.dictionaryCode+"\","+obj.dictionaryId+")'>"+obj.dictionaryName+"</a></td>";
			if( i != 0 && (i%6) == 0){
				girdHtml +="</tr><tr>"
			}
		}
		girdHtml +="</tr>";
	}
	$("#section").html(girdHtml);
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
 * 查询学科
 */
var allSubjectData;
var sectionId;
function qrySubject(sectionName,id){
	sectionId = id;
	$("#subject").html("");
	$("#showCheck").css("display","block");
	var url = pathHeader + "/sys/querySubject.do";
	$.ajax({
		url:url,
		data:{sectionName:sectionName},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				allSubjectData = rows;
				$("[id=isAll]").attr("checked",false);
				$("[id=fanxuan]").attr("checked",false);
				if(rows.length > 0){
					var girdHtml = "<tr >";
					for(var i = 0;i<rows.length;i++){
						var obj = rows[i];
						girdHtml +="<td><input type='checkbox' id='"+sectionId+"' name='"+obj.dictionaryName+"' value='"+obj.dictionaryId+"' onclick='setValues(this)'>"+obj.dictionaryName+"</td>";
						if( i != 0 && (i%2) == 0){
							girdHtml +="</tr><tr>"
						}
					}
					girdHtml +="</tr>";
					$("#subject").html(girdHtml);
				}
			}
			//学科查询完成后触发模拟点击事件
			//var evt = document.createEvent("MouseEvents"); 
			//evt.initEvent("click", false, false);
			//$("#isAll").get(0).dispatchEvent(evt);
			//判断当前选中学段的学科是否被选中
			isChecked();
		},
		error:function(){
			
		}
	});
}

//var subAry = new Array();
function setValues(obj){
	
	var sub = {
		subjectId:obj.value,
		subjectName:obj.name
	}
	var flag = true;
	for(var i = 0;i<subAry.length;i++){
		if(subAry[i].subjectName == sub.subjectName){
			flag = false;
		}
	}
	if(flag && obj.checked){
		subAry.push(sub);
	}
	if(!obj.checked){//取消选择
		var index = -1;
		for(var i = 0;i<subAry.length;i++){
			if(subAry[i].subjectName == sub.subjectName){
				//subAry.pop(i);//不能pop，应该是删除指定位置,而且pop()方法是 不带参数的
				subAry.splice(i, 1);
				break;
			}
		}
	}
	var temp = $("input[id='"+sectionId+"']:checked");
	if(temp.length != allSubjectData.length){
		$("#isAll").attr("checked",false);
	}else{
		$("#isAll").attr("checked",true);
	}
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}
//触发学段中所有事件
function showSection(){
	queryDic("project_subject");
	if(subject.length > 0){
		allSubjectData = subject;
		var girdHtml = "<tr >";
		for(var i = 0;i<subject.length;i++){
			var obj = subject[i];
			girdHtml +="<td><input type='checkbox' id='res' name='"+obj.dictionaryName+"' value='"+obj.dictionaryId+"' onclick='setValues(this)'>"+obj.dictionaryName+"</td>";
			if( i != 0 && (i%4) == 0){
				girdHtml +="</tr><tr>"
			}
		}
		girdHtml +="</tr>";
		$("#subject").html(girdHtml);
	}
	var evt = document.createEvent("MouseEvents"); 
	evt.initEvent("click", false, false);
	$("[id=res]").trigger("click");
	selectAllSubject(subject);
}
//学科全选
var subAry = new Array();
function selectAllSub(){
	var CheckStatus = $("#isAll").attr("checked");
	$("#fanxuan").attr("checked",false);
	if(CheckStatus){
		$("[id='"+sectionId+"']").attr("checked",true);
		//触发全选
		selectAll(allSubjectData,sectionId);
	}else{
		$("[id='"+sectionId+"']").attr("checked",false);
		//取消全选
		unSelectAll(subAry,sectionId);
	}
}
//学科反选
function selectNoCheckSub(){
	var CheckStatus = $("#fanxuan").attr("checked");
	$("input[id=selectSub]").each(function(){
		if(this.checked){
			$(this).attr("checked",false);
		}else{
			$(this).attr("checked",true);
		}
		//反选操作
		invertSub();
	});
}

//全选操作
var h = "";
function selectAll(allSubjectData,sectionId){
	h = allSubjectData.length;
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		};
		
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				subAry.splice(j,1);
				$("[name='"+obj.dictionaryName+"']").attr("checked",true);
			}
		}
		
		if($("[id='"+sectionId+"']").attr("checked")){
			subAry.push(sub);
		}
	}	
		$("#hasSelected").html("");
		for(var i = 0;i<subAry.length;i++){
			$("#hasSelected").append(subAry[i].subjectName+" ");
		}
}
//当点击选择按钮时，选中全部学科[必须使用同一数组subAry]
function selectAllSubject(subject){
	h = subject.length;
	for(var i = 0;i<subject.length;i++){
		var obj = subject[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		};
		
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				subAry.splice(j,1);
			}
		}
		
		if($("[id='res']").attr("checked")){
			subAry.push(sub);
		}
	}	
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}

//判断数组中的学科是否包含选中学段里的学科
function isChecked(){
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				$("[name='"+obj.dictionaryName+"']").attr("checked",true);
			}
		}
	}
	var temp = $("input[id='"+sectionId+"']:checked");
	if(temp.length != allSubjectData.length){
		$("#isAll").attr("checked",false);
	}else{
		$("#isAll").attr("checked",true);
	}
}

//取消全选
function unSelectAll(subAry,sectionId){
	console.log("subAry:"+subAry);
	for(var j = 0;j<subAry.length;j++){
		for(var n=0;n<allSubjectData.length;n++){
			var name = allSubjectData[n].dictionaryName;
			if(subAry[j] != null && subAry[j].subjectName == name){
				subAry.splice(j,1);
			}
		}
	}
	
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}

//反选操作
function invertSub(){
	//将已选学科清空并取消已选
	//unSelectAll();
	//当点击反选按钮后,如果没有全选就将全选选中
	$("#isAll").attr("checked",false);
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		}
		if($("[name='"+obj.dictionaryName+"']").attr("checked")){
			if(subAry[i].subjectName == sub.subjectName){
				subAry.push(sub);
			}
		}
	}
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}
/**
 * 学段学科，选择确认
 */
function lastSure(){
	if(subAry.length>0){
		var ids = "";
		var names = "";
		for(var i = 0;i<subAry.length;i++){
			var obj = subAry[i];
			ids += obj.subjectId+",";
			names += obj.subjectName+",";
		}
	}
	$("input[name='subjectId']").val(ids.substring(0,ids.length-1));
	$("input[name='subjectName']").val(names.substring(0,names.length-1));
	var values = "";
	for(var i = 0;i<subAry.length;i++){
		values += subAry[i].subjectName+" ";
	}
	$("input[name='subject']").val(values);
	//subAry.length = 0;
	$("#XDXKshow").hide();
}



//function getSelected(sid){
//	var value,text;
//	text = $("#"+sid+" option:selected").text();
//	value = $("#"+sid).val();
//	scontent={
//		value:value,
//		text:text
//	};
//	return scontent;
//}

var title;
function getObjHtml(obj){
	var gridHtml = "<tr>";
	if(title != obj.title){
		gridHtml += "<td>"+obj.title+"</td>";
		title = obj.title;
	}else{
		gridHtml += "<td>  </td>";
	}
	
	gridHtml += "<td>"+obj.answerContent+"</td>";	
	if(obj.pickNum == null){
		gridHtml += "<td>0</td>";
	}else{
		gridHtml += "<td>"+obj.pickNum+"</td>";
	}
	gridHtml += "<td>"+obj.rate+"%</td>";
	gridHtml+= "</tr>";
	return gridHtml;
}
