$(function(){
	querySubject("classSubject");
	querySubject("sub");
	qryClassList();
	//initSelect();
	$('#subject').uedSelect({
		width : 167  
	});
	
	
	$(".close").click(function(){
		clearContent();
		$(".tips_zb").fadeOut(100);
	});
})


function querySubject(sid){
	queryDic("project_subject")
	if(subject.length > 0){
		createOpt(subject,sid);
	}
}


function createOpt(rows,sid){
	for(var i = 0;i<rows.length;i++){
		var opt = "<option value='"+rows[i].dictionaryId+"'>"+rows[i].dictionaryName+"</option>";
		$("#"+sid).append(opt);
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


function initSelect(){
	$(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
}


function showTip(id){
	$('#title').html('');
	$('#title').html('添加课程');
	$("#"+id).fadeIn(100);
	initSelect();
}


function hideTip(id){
	clearContent();
	clearClass();
	$("#"+id).fadeOut(100);
}


/**
 * 机构: 某一项目下课程设置列表
 */
function qryClassList(){
	$('#classList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/org/selectOrgProClass.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectId:projectId,
			classSubjectId:$("#classSubject").find("option:selected").val(),
			className:$("#className").val(),
			pageIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){	
				
			/**
				var subject = rows[0].organizationProject;
				var classSubjectId = subject.classSubjectId;
				var classSubjectName = subject.classSubjectName;
				var length = (classSubjectId.length + 1)/2;
				// 清空下拉
				$('#classSubject').empty();
				$('#classSubject').append("<option value='0'>请选择</option>");
				$('#sub').empty();
				$('#sub').append("<option value='0'>请选择</option>");
				
				for(var i=0; i<length; i++){
					$opt = $("<option value='" + classSubjectId.split(',')[i] + "'>" + classSubjectName.split(',')[i] + "</option>");
					$('#classSubject').append($opt);
				}
				for(var i=0; i<length; i++){
					$opt = $("<option value='" + classSubjectId.split(',')[i] + "'>" + classSubjectName.split(',')[i] + "</option>");
					$('#sub').append($opt);
				}
			*/
			
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#classList').append(gridHtml);
				pagination(data, function(){qryClassList();});
				}else{
					$('#classList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				}
		},
		error:function(){
			jQuery.generalAlert("error");
		}
		
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+(obj.classSubjectName==null?"":obj.classSubjectName)+"</td>";
	gridHtml += "<td>"+(obj.className==null?"":obj.className)+"</td>";
	gridHtml += "<td>"+obj.classType+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
			returnStr += 	 "<a href='###' class='tablelink' onclick='info(\"" + row.classId + "\");'>查 看</a>&nbsp;&nbsp;&nbsp;";
			returnStr += 	 "<a href='###' class='tablelink' onclick='modify(\"" + row.classId + "\");'>修 改</a>&nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='tablelink' onclick='del(\"" + row.classId + "\");'>删 除</a>";
		return returnStr;
	}
}


function getSelected(sid){
	var value,text;
	text = $("#"+sid+" option:selected").text();
	value = $("#"+sid).val();
	scontent={
		value:value,
		text:text
	};
	return scontent;
}


var cid;
function createClass(){
	var content = getSelected("classTypeId");
	var classTypeId = content.value;
	var classTypeName = content.text;
	var classSubjectName = getSelected("sub");
	
	var url = pathHeader +"/edupm/projectclass/createClass.do";
	var clazz = {
		id: cid,
		className:$("input[name='className']").val(),
		classSubjectName:classSubjectName.text,
		classTypeId:classTypeId,
		classType:classTypeName,
		classUrl:$("#classUrl").val(),
		memo:$("#memo").val(),
		classSubjectId:classSubjectName.value
	}; 
	$.ajax({
		url:url,
		data:{
		proId:projectId,
		clazz:$.toJSON(clazz)
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				jQuery.generalAlert("添加课程成功!");
				clearContent();
				hideTip("addClass");
				window.location.reload(true);
			} else {
				jQuery.generalAlert("添加课程失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("添加课程失败!");
		}
	});
}


function del(id){
	var url = pathHeader + "/edupm/projectclass/deleteClass.do"
	$.ajax({
		url:url,
		data:{classId:id},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				jQuery.generalAlert("删除成功!");
				//url = pathHeader + "/org/selectOrgProClass.do?projectId="+projectId;
				window.location.reload(true);
			} else {
				jQuery.generalAlert("删除失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("删除失败!");
		}
	});
}


function info(id){
	$('#title2').html('');
	$('#title2').html('查看课程详情');
	var url = pathHeader + "/edupm/projectclass/qryClassInfo.do";
	$.ajax({
		url:url,
		data:{classId:id},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = data.obj;
				$("#className_info").html(obj.className);
				$("#classType_info").html(obj.classType);
				$("#classSubjectName_info").html(obj.classSubjectName);
				$("#classUrl_info").html(obj.classUrl);
				$("#memo_info").html(obj.memo);
			}
		},
		error:function(){
			
		}
		
	});
	showTip("classInfo");
}


function modify(id){
	
	var url = pathHeader + "/edupm/projectclass/qryClassInfo.do";
	$.ajax({
		url:url,
		data:{classId:id},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var obj = data.obj;
				cid = obj.id;
				$("input[name='className']").val(obj.className);
				$("#classTypeId").val(obj.classTypeId);
				$("#sub").val(obj.classSubjectId);
				$("#classUrl").val(obj.classUrl);
				$("#memo").val(obj.memo);
				showTip("addClass");
				$('#title').html('');
				$('#title').html('修改课程');
				initSelect();
			}
		},
		error:function(){
			jQuery.generalAlert('error');
		}
		
	});
}


function clearContent(){
	$("input[name='className']").val("");
	$("#classTypeId").val("");
	$("#sub").val("");
	$("#classUrl").val("");
	$("#memo").val("");
}

function clearClass(){
	$(".select2").attr("class","select7");
}