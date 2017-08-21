

$(document).ready(function(){
  	$(".tiptop a").click(function(){
		$(".tip").fadeOut(200);
	});
  	
  	$(".cancel").click(function(){
  		$(".tipt").fadeOut(200);
  	});
  	
  	//查询本项目下的人员
  	searchTeacher();
  	
  	$("#searchButton").on("click",function(){
  		searchTeacher();
  	});
});


//查看教师总结
function  searchTeacher(){
	$('#teacherProSummaryList').html('');
	var sno = $("#sno").val();
	var name = $("#name").val();
	var school = $("#school").val();
	var projectId = $.getUrlParam("projectId");
	var pageIndex = $("#pageIndex").val();
	var url  = pathHeader + '/edupm/summary/teacherProSummaryList.do';
	$.ajax({
  		dataType: 'json',  
  		type:"post",
  		data:{
  			sno:sno,
  			name:name,
  			school:school,
  			projectId:projectId,
			pageIndex : pageIndex
		},
  		url:url,
  		beforeSend: function(){
			$('#teacherProSummaryList').html("<tr><td align='center'colspan='4'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
  		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#teacherProSummaryList').html(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
				$('#teacherProSummaryList').html(gridHtml);
			}
			pagination(data, function(){searchTeacher();});
		
  		},
  		error:function(XMLHttpRequest, textStatus, errorThrown){
			gridHtml = "<tr><td align='center'colspan='4'>暂无查询结果！</td></tr>";
			$('#teacherProSummaryList').append(gridHtml);
		
		}
  	});
}

function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.name)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.sno)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.school)+"</td>";
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
		var opt = '<a href="#" onclick="otherViewFiles('+obj.projectId+','+obj.userId+')" class="tablelink click">查看</a>&nbsp;&nbsp;</td>';
		return opt;
	}
}

//查看
function otherViewFiles(pid, userId) {
	var url = pathHeader + "/fileupload/otherViewFiles.do?time="
			+ (new Date()).getTime();
	$('#projectId').val(pid);
	$
			.ajax({
				dataType : 'json',
				url : url,
				type : 'post',
				data : {
					projectId : pid,
					type : "summarry",
					userId:userId
				},
				success : function(data) {
					var table = "<tr><td width='5%'>序号</td><td width='40%'>文件名</td><td width='15%'>上传人</td><td width='20%'>上传时间</td><td colspan='2' width='20%'>操作</td><tr>";
					$.each(data.files,function(i, item) {
							table += "<tr><td>"
									+ (i + 1)
									+ "</td><td>"
									+ item.name
									+ "</td><td>"+item.userName+"</td>"
									+ "<td>"+nullFormatter(item.createDate.replace(".0",""))+"</td><td>"
									+ "<a href='#' onclick=downloadFile('"
									+ item.url
									+ "') >下载 </a></td>"
									+ "</td></tr>";
									});
					$("#viewTable").html(table);
					$('#myModal').modal('show');
				},
				error : function() {
					jQuery.generalAlert("查询数据出错！请联系管理员");
				}
			});
}

// 下载文件
function downloadFile(filePathName) {
	// 下载能使用jquery的ajax，因为ajax的返回值不支持流
	var url = pathHeader + '/fileupload/downloadFiles.do';
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("method", "post");
	form.attr("action", url);
	var input = $("<input>");
	input.attr("type", "hidden");
	input.attr("name", "filePathName");
	input.attr("value", filePathName);
	$("body").append(form);// 将表单放置在web中
	form.append(input);
	form.submit();// 表单提交
}
