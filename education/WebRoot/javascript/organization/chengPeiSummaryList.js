$(function(){
	selectCloseProjectList();
	// 条件查询
	$("#select").click(function() {
		selectCloseProjectList();
	});
	
});


function viewSummary(pid){
	var url = pathHeader + "/edupm/summary/chengPeiViewSummary.do?time="+(new Date()).getTime();
	$.ajax({
  		dataType: 'json',  
  		url:url,
  		data:{projectId:pid,type:2},
  		success:function(data){
  			if(data.eps!=null){
  	  			$("#summaryTitle").val(data.eps.title);
  	  			$("#summaryId").val(data.eps.id);
  	  			$("#pid").val(data.eps.projectId);
  	  			$("#summaryContent").val(data.eps.content);
  	  			if(nullFormatter(data.eps.attchementTitle)){
  	  				$("#download").html(data.eps.attchementTitle+"&nbsp;&nbsp;下载");
  	  				$("#download").attr("href",pathHeader+"/" +data.eps.attchementUrl+data.eps.attchementTitle);
  	  			}
  			}else{
  				$("#delete").html("");
  				$("#summaryId").val(null);
  				$("#pid").val(pid);
  	  			$("#summaryTitle").val("");
  	  			$("#summaryContent").val(""); 
  	  			$("#download").html("");
				$("#download").attr("href","#");
  			}
  			$(".tip").fadeIn(200);
  		},
  		error:function(XMLHttpRequest, textStatus, errorThrown){
  			jQuery.generalAlert("查询数据出错！请联系管理员");
		}
  	});
}

function nullFormatter(obj){
	if(obj==null || obj=='null' || obj.length==0){
		return false;
	} else {
		return true;
	}
}
$(document).ready(function(){
  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
  });
  
  $(".sure").click(function(){
  	var summaryTitle = $("#summaryTitle").val();
  	if(summaryTitle.length>50){
  		jQuery.generalAlert("标题最多50字");
  	}else{
  	  	var summaryContent = $("#summaryContent").val();
  	  	var summaryId = $("#summaryId").val();
  	  	var pid = $("#pid").val();
  	  	var isChange = false;
  	  	if($("#isChange").val()==1){
  	  		isChange = true;
  	  	}
  	  	$("#cite").show();
  	  	var url=pathHeader + "/edupm/summary/savaOrUpdateSummary.do?time="+(new Date()).getTime();
  	  	$.ajaxFileUpload({
  	        fileElementId:'attchmentPath',  
  	        dataType: 'xml',  
  	  		url:url,
  	  		data:{type:2,title:summaryTitle,content:summaryContent,id:summaryId,projectId:pid,isChange:isChange},
  	  		success:function(data){
  	  			$(".tip").fadeOut(100);
  	  		},
  	  		error:function(XMLHttpRequest, textStatus, errorThrown){
  	  			jQuery.generalAlert("保存数据出错！请联系管理员");
  			}
  	  	});  		
  	}
});


});
function selectCloseProjectList(){
	$('#summaryList').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$.ajax({
		url : pathHeader + '/org/searchChengPeiCloseProjectList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			start : $('#startTime').find("option:selected").val(),
			end : $('#endTime').find("option:selected").val(),
			sizePerPage :sizePerPage,
			startIndex : pageIndex
		},
		success:function(data){
			if(data!=null) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				
				$('#summaryList').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#summaryList').append(gridHtml);
			}
			pagination(data, function(){selectCloseProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
			$('#summaryList').append(gridHtml);
		}
	});
}
	
function check(){
	jQuery.generalAlert("上传成功！");
	value=$("#attchmentPath").val();
	$("#download").html(value);
	$("#delete").html("&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='removeMe()'>删除</a>");
	$("#isChange").val(1);
}

function removeMe(){
	$("#cite").hide();
	$("#isChange").val(1);
    var file = $("#attchmentPath");
    file.after(file.clone().val(""));   
    file.remove();
}

function getTdHtml(obj){
	var startDate = new Date(obj.startDate).format("yyyy-MM-dd");
	var endDate = new Date(obj.endDate).format("yyyy-MM-dd");
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	gridHtml += "<td>"+nullFormatter(startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(endDate)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(obj){
		var url2 = "<a href='../teacher/teacherProject/teacherProSummaryList.htm?projectId="+obj.id+"&click=104' class='tablelink'>老师的总结</a>&nbsp;&nbsp;";
		var url3 = "<a href='#' class='tablelink' onclick='viewSummary("+obj.id+")' >我的总结</a>&nbsp;&nbsp;"; 
		return url2+url3;
	}
}


