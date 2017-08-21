var receverNameFlag = false;
var receverNameError = false;
var titleError = false;
var receverId = null;
$(function(){
	messageList();
	getMessageCount();
	
	$(":radio").live("change",function(){
		clear();
		$(".sendType").hide();
  		$("#" + $(this).val()).show();
	});
	queryProject();
});

/**
 * 查询项目
 */
function queryProject(){
	var url = pathHeader+ "/edupm/projectmanage/queryProjectByStatusAll.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#projectList").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#projectList").append(
					"<option  value=\"" + value.id + "\">"
					+ value.projectName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
}

function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1]
		var text = conditionArray[2]
		$('#areaName').val(text);
		$('#areaId').val(belone);
		$('#areaIdName').val(areaA);
//		queryConditionArray[9] = areaA+"_" + belone;
	}
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}

function messageList(){
	var url = pathHeader+ "/message/messageManagement/messageListShenghe.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		},
		async:true,
		success:function(data){
			if(data.success){
				var mesList = data.info;
				var toMessage  = "";
				for(var i = 0;i<mesList.length;i++){
					var obj = mesList[i];
					var strs = new Date(obj.createDate).format("yyyy-MM-dd");
					 if(obj.status==12){
						toMessage += "<dl>"+
				"<dt><img src='../../images/i07.png' width='65' height='65' /></dt>"+
				"<dd class='ti'><h4></h4><br><h4>审核人："+obj.updateBy+"</h4><br><h4>不通过原因："+obj.auditMemo+"</h4><br><h4>项目名称："+obj.projectName+"</h4><cite><h4>"+strs+"</cite></dd>"+
					"<dd id='read"+i+"'><p></p></dd>"+
					"<dd></dd>"
					+"</dl>"
					}
				}
				$('#textContent').html(toMessage);
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
	});
	
}

function read(no,messageId,contents){
	var url = pathHeader+ "/message/messageManagement/readMessageInfo.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		messageId:messageId
		},
		async:true,
		success:function(data){
			if(data.success){
//				window.location.reload();
				}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
	});
	$("#read"+no).html(contents);
}
function readOff(no,messageId,contents){
	$("#read"+no).html(contents);
	}

function getMessageCount(){
	var url = pathHeader+ "/message/messageManagement/getMessageShenheCounts.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		},
		async:true,
		success:function(data){
			if(data.success){
				$('#counts').html(data.total);
				}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
		
	});
}
function deleteMessage(id){
	var url = pathHeader+ "/message/messageManagement/deleteMessage.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		id:id
		},
		async:true,
		success:function(data){
			if(data.success){
				window.location.reload();
				}
		},
		error:function(){
			jQuery.generalAlert("错误");
		}
	});
}
function deleteAllMessage(){
	var url = pathHeader+ "/message/messageManagement/deleteAllMessage.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		},
		async:true,
		success:function(data){
			if(data.success){
				window.location.reload();
				}
		},
		error:function(){
			jQuery.generalAlert("错误");
		}
	});
}

$(function(){
	$("#title").blur(function(){
		$('#titleError').html("");
		var value = $('#title').val();
		if(value==null||value==""){
			$('#titleError').html("请输入标题!");
		}else{
			titleError = true;
		}
		});
	
	$("#receverName").blur(function(){
		$('#receverNameError').html("");
		var value = $('#receverName').val();
		if(value==null|| value==""){
			$('#receverNameError').html("收信人不能为空");
		}else{
			receverNameError = true;
			var url = pathHeader+ "/message/messageManagement/getAllUserName.do";
			$.ajax({
				url:url,
				type:"post",
				data:{
				receverName:value
				},
				async:true,
				success:function(data){
					if(data.success){
						if(data.ok){
							$('#receverNameError').html("用户不存在!");
						}else{
							receverNameFlag = true;
							receverId = (data.rows)[0].id;
						}
					}
				},
			error:function(){
			jQuery.generalAlert("错误");
		}
	});
		}
	});
});
function sendInfo(){
	var sendType = $('input:radio[name="sendType"]:checked').val();
	if(!receverNameError && sendType == "byName"){
		$('#receverNameError').html("收信人不能为空!");
		return;
	}
	if(!titleError){
		$('#titleError').html("请输入标题!");
		return;
	}
	if(!receverNameFlag && sendType == "byName"){
		$('#receverNameError').html("用户不存在!");
		return;
	}
	var content = $('#content').val();
	var title = $('#title').val();
	var receverName = $('#receverName').val();
	var url = pathHeader+ "/message/messageManagement/sendMessageToUser.do";
	
	var areaId = $('#areaId').val();
	var roleId = $('#roleId').val();
	var projectId = $('#projectList').val();
	var areaIdName = $('#areaIdName').val();
	$.ajax({
				url:url,
				type:"post",
				data:{
					sendType:sendType,
					areaId:areaId,
					areaIdName:areaIdName,
					projectId:projectId,
					roleId:roleId,
					content:content,
					title:title,
					receverId:receverId,
					receiveUserName:receverName
				},
				async:true,
				success:function(data){
					if(data.success){
						jQuery.generalAlert("发送成功！");
						$(".tip").fadeOut(100);
						messageList();
					}
				},
			error:function(){
			jQuery.generalAlert("错误");
		}
	});
}


function openWindow(url){
	window.location.href = url;
}
