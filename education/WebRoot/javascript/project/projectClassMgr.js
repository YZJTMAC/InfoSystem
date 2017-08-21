$(function(){
	querySubject("subject");
	querySubject("sub");
	qryClassList();
	$(".select8").uedSelect({
		width : 167  
	})
//	initSelect();
})

function initSelect(){
	$(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
}

function showTip(id){
	initSelect();
	$("#"+id).fadeIn(100);
}

function hideTip(id){
	clearContent();
	clearClass();
	$("#"+id).fadeOut(100);
}
var cid;

function createClass(){
	initSelect();
	var content = getSelected("classTypeId");
	var classTypeId = content.value;
	var classTypeName = content.text;
	var classSubjectName = getSelected("sub");
	
	var url = pathHeader +"/edupm/projectclass/createClass.do";
	var clazz = {
		id:cid,
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
				clearContent();
				hideTip("addClass");
				window.location.reload();
			}
		},
		error:function(){
			
		}
	});
}

function qryClass(){
	if(validateYear()){
		qryClassList()
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}

function qryClassList(){
	$('#classList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/edupm/projectclass/qryClasses.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		proId:projectId,
		className:$("#className").val(),
		classSubjectId:$("#subject").val(),
		startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
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
			jQuery.generalAlert("url error");
		}
		
	});
}

function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.classSubjectName+"</td>";
	gridHtml += "<td>"+(obj.className==null?"":obj.className)+"</td>";
	gridHtml += "<td>"+obj.classType+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
			returnStr += 	 "<a href='###' class='tablelink' onclick='info(\"" + row.id + "\");'>查 看</a>&nbsp;&nbsp;&nbsp;";
			returnStr += 	 "<a href='###' class='tablelink' onclick='modify(\"" + row.id + "\");'>修 改</a>&nbsp;&nbsp;&nbsp;";
			returnStr += "<a href='###' class='tablelink' onclick='del(\"" + row.id + "\");'>删 除</a>";
		return returnStr;
	}
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
				url = pathHeader + "/edupm/projectclass/toClassListPage.htm?proId="+projectId;
				openWindow(url);
			}
		},
		error:function(){
			
		}
	});
}



function info(id){
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
			clearClass();
			if(data.success){
				var obj = data.obj;
				cid = obj.id;
				$("input[name='className']").val(obj.className);
				$("#classTypeId").val(obj.classTypeId);
				$("#sub").val(obj.classSubjectId);
				$("#classUrl").val(obj.classUrl);
				$("#memo").val(obj.memo);
				$(".select7").attr("class","select2");
				showTip("addClass");
//				initSelect();
			}
		},
		error:function(){
			
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