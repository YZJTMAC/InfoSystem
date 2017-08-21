$(function(){
	var projectId = $("#projectId").val();
	
	$("#cancleSave").click(function(){
		if(confirm("确定取消吗？")){
			window.location.href="<%=basePathHeader%>/edupm/projectmanage/toProjectPaperListPage.htm?click=32&proId="+projectId;
		}else{
			return false;
		}
	});
	
	questionInit();
});

function questionInit(){
	$('#questionList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/paper/getQuestion.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			paperId : $('#paperId').val(),
			start : 1,
			end : 100,
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,index);
				});
				$('#questionList').append(gridHtml);
				//pagination(data, function(){questionInit();});
			}else{
				$('#questionList').html("<tr><td colspan='8'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
}


//修改调查问卷
function savePaper(){
	$("#savePaper").attr("disabled",true);
	var url = pathHeader+"/edupm/paper/updatePaper.do";
	if(!validateName()){
		alert("请填写调查问卷名称！");
		$("input[name='name']").focus();
		$("#savePaper").attr("disabled",false);
		return ;
	}
	
	$("#paperForm").ajaxSubmit({
		url:url,
		async:false,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data){
				alert("保存成功！");
				url = pathHeader+"/edupm/projectmanage/toProjectPaperListPage.htm?click=32&proId="+ $("#projectId").val();
				window.location.href=url;
			}else{
				alert("保存失败！");
				$("#savePaper").attr("disabled",false);
			}
		}, 
		error:function(){
			$("#savePaper").attr("disabled",false);
		}
	});
}

function addQuestion(paperId){
	var url = pathHeader+"/edupm/paper/toAddQuestion.htm?click=32&paperId="+paperId;
	window.location.href=url;
	
}

function getTdHtml(obj,index){
	var gridHtml = "<tr>";
	index=index+1;
	gridHtml += "<td>"+index+"</td>";
	gridHtml += "<td>"+obj.title+"</td>";
	var i = obj.questionType;
	if(i==0){
		gridHtml += "<td>填空</td>";
	}
	if(i==1){
		gridHtml += "<td>问答</td>";
	}
	if(i==2){
		gridHtml += "<td>单选</td>";
	}
	if(i==3){
		gridHtml += "<td>多选</td>";
	}
	
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		returnStr += 	 "<a href='###' class='tablelink' onclick='setup(\"" + row.id + "\");'>修改</a>&nbsp;&nbsp;&nbsp;";
		returnStr += 	 "<a href='###' class='tablelink' onclick='del(\"" + row.id + "\");'>删除</a>&nbsp;&nbsp;&nbsp;";
		return returnStr;
	}
}

function setup(id){
	var url = pathHeader + "/edupm/paper/toUpdateQuestion.htm?click=32&qid="+id;
	openWindow(url);
}
function del(id){
	var url = pathHeader+ "/edupm/paper/delQuestion.do";
	com(id,url,"确定要删除该试题");
}
function com(id,url,tishi){
	if(confirm(tishi)){
		$.ajax({
			url:url,
			data:{
				qId:id
			},
			type:"post",
			async:false,
			success:function(data){
				if(data.success){
					questionInit();
				}
			},
			error:function(){
				alert("URL error！");
			}
		});
	}
}
function goback(proId){
	var url1 = pathHeader + "/edupm/projectmanage/toProjectPaperListPage.htm?click=32&proId="+proId;
	window.location.href=url1;
}