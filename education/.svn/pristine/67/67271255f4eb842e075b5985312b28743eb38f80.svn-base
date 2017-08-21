$(function(){
	historyType = (historyType == null || historyType == "" || historyType == "null" ) ? "teacher" : historyType;
	queryTeacherRecord();
//	initSelect();
})


function initSelect(){
	$(".select1").uedSelect({
		width : 345			  
	});
	$(".select3").uedSelect({
		width : 100
	});
}
/**
 * 查询导入教师记录
 */
function queryTeacherRecord(){
	$("#records").html("");
	var url = pathHeader + "/edupm/teachermanage/queryImprotRecordInfo.do";
	$.ajax({
		url:url,
		data:{
		historyId:historyId,
		historyType:historyType,
		startIndex:$("#pageIndex").val()},
		type:"post",
		async:false,
		success:function(data){
			initSelectOpt(data.dtos);
			initSelectYear(data.years);
			$("#year").val(data.year);
			$("#optDate").val(data.optDate);
			$("#okCount").html("已成功导入记录："+data.okCount+"条教师信息；");
			$("#failCount").html("未导入的记录："+data.failCount+"条教师信息；");
			$("#fileNames").html("已上传的附件："+data.fileNames);
			if(data.failCount !=0){
				$("#url").html("点击下载：<a href='javascript:downZip(\""+data.url+"\")'>附件</a>");
			}
			initSelect();
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#records').append(gridHtml);
				pagination(data, function(){queryTeacherRecord();});
			}else{
				$('#records').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			jQuery.generalAlert("url error!");
		}
	});
}

function queryRecordsByDate(){
	$("#records").html("");
	var url = pathHeader + "/edupm/teachermanage/queryRecordsByDate.do";
	$.ajax({
		url:url,
		data:{startIndex:$("#pageIndex").val(),
		historyType:historyType,
		date:$("#optDate").val()},
		type:"post",
		async:false,
		success:function(data){
			
			if(data.success){
				$("#okCount").html("已成功导入记录："+data.okCount+"条教师信息；");
				$("#failCount").html("未导入的记录："+data.failCount+"条教师信息；");
				$("#fileNames").html("已上传的附件："+data.fileNames);
				if(data.failCount>0){
					$("#url").html("点击下载：<a href='javascript:downZip(\""+data.url+"\")'>附件</a>");
				}
				var rows = data.rows;
				if(rows.length > 0){
					
					var gridHtml = "";
					$.each(rows, function(index,element) {
						gridHtml += getTdHtml(element);
					});
					$('#records').append(gridHtml);
					pagination(data, function(){queryRecordsByDate();});
				}else{
					$('#records').html("<tr><td colspan='8'>无查询记录</td></tr>");
				}
			}
			
		},
		error:function(){
			
		}
		
	});
}


function getTdHtml(obj){
	var addr = obj.addr==null?"":obj.addr;
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.name+"</td>";
	gridHtml += "<td>"+obj.idNO+"</td>";
	gridHtml += "<td>"+addr+"</td>";
	gridHtml += "<td>"+obj.teacherNO+"</td>";
	gridHtml += "<td>"+obj.gender+"</td>";
	gridHtml += "<td>"+obj.political+"</td>";
	gridHtml += "<td>"+obj.section+"</td>";
	gridHtml += "<td>"+obj.subject+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='listRecords(\"" + row.id + "\");'>查看导入记录</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}


function initSelectOpt(dtos){
		var opts = "";
	for(var i = 0;i<dtos.length;i++){
		var dto = dtos[i];
		var opt = "<option value='"+dto.dateVal+"'>"+dto.optDate+"</option>";
		opts += opt;
	}
	$("#optDate").append(opts);
}


function initSelectYear(years){
	var opts = "";
	for(var i = 0;i<years.length;i++){
		var opt = "<option value='"+years[i]+"'>"+years[i]+"年</option>";
		opts +=opt;
	}
	$("#year").append(opts);
	
}
function downZip(url){
	if(url.length == 0){
		jQuery.generalAlert("无法下载附件，请联系管理员！");
	}else{
		var url = pathHeader + "/edupm/teachermanage/downFailFile.htm?path="+url;
		window.open(url);
	}
}

function qryDate(){
	var url = pathHeader + "/edupm/teachermanage/queryDateByYear.do";
	$.ajax({
		url:url,
		data:{year:$("#year").val()},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				$("#optDate").empty();
				var dtos = data.dtos;
				$(".uew-select-text").html(dtos[0].optDate);
				var opts = "";
				
				for(var i = 0;i<dtos.length;i++){
					var dto = dtos[i];
						var opt = "<option value='"+dto.dateVal+"'>"+dto.optDate+"</option>";
						opts += opt;
				}
				$("#optDate").append(opts);
				initSelect();
			}
		},
		error:function(){
			
		}
		
	});
	
}