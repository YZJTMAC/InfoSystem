var receverNameFlag = false;
var receverNameError = false;
var titleError = false;
var receverId = null;
$(function(){
	messageList(1);
	getMessageCount();
	
	$(":radio").live("change",function(){
		clear();
		$(".sendType").hide();
  		$("#" + $(this).val()).show();
	});
	queryProject();
});


/**
 * 通知切换
 * @param {Object} type
 */
function change(type){
	if(type == 1){
		$('#tab_1').attr('class','selected');
		$('#tab1').show();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		$('#tab_3').attr('class','');
		$('#tab3').hide();
		$('#tab_4').attr('class','');
		$('#tab4').hide();
		messageList(1);
	}
	 if(type == 2){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','selected');
		$('#tab2').show();
		$('#tab_3').attr('class','');
		$('#tab4').hide();
		$('#tab_4').attr('class','');
		$('#tab4').hide();
		messageList(2);
	}else if(type == 3){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		$('#tab_3').attr('class','selected');
		$('#tab3').show();
		$('#tab_4').attr('class','');
		$('#tab4').hide();
		messageList(3);
	}else if(type == 4){
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
		$('#tab_3').attr('class','');
		$('#tab3').hide();
		$('#tab_4').attr('class','selected');
		$('#tab4').show();
		messageList(4);
	}
}


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
			$("#projectList").append("<option  value='-1'>请选择</option>");
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

function messageList(type){
	var url = pathHeader+ "/message/messageManagement/messageList.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			type:type
		},
		async:true,
		success:function(data){
			if(data.success){
				var mesList = data.info;
				var toMessage  = "";
				for(var i = 0;i<mesList.length;i++){
					var obj = mesList[i];
					var strs = new Date(obj.sendTime).format("yyyy-MM-dd");
					if(obj.status==3){
				toMessage += "<dl>"+
				"<dt><img src='../../images/i07.png' width='65' height='65' /></dt>"+
					"<dd class='ti'><h4><a href='#' onclick = 'read("+i+",\""+obj.id+"\",\""+obj.content+"\",\""+obj.userImageUrl+"\")' style='color:red'>"+obj.title+"</a></h4><cite>"+strs+"</cite></dd>"+
					"<dd id='read"+i+"'><p></p></dd>"+
					"<dd><cite><a href='#' class='tablelink' onclick='deleteMessage("+obj.id+")'>删 除</a></cite></dd>"
					+"</dl>"
					}else if(obj.status==2){
						toMessage += "<dl>"+
						"<dt><img src='../../images/i07.png' width='65' height='65' /></dt>"+
					"<dd class='ti'><h4><a href='#' onclick = 'readOff("+i+",\""+obj.id+"\",\""+obj.content+"\",\""+obj.userImageUrl+"\");'>"+obj.title+"</a></h4><cite>"+strs+"</cite></dd>"+
					"<dd id='read"+i+"'><p></p></dd>"+															
					"<dd><cite><a href='#' class='tablelink' onclick='deleteMessage("+obj.id+")'>删 除</a></cite></dd>"
					+"</dl>"
					}
				}
				$('#textContent').html(toMessage);
				if(data.noread1 != 0)
					$('#tab_1').html('省级消息('+ data.noread1+')');
				if(data.noread2 != 0)
					$('#tab_2').html('市级消息('+ data.noread2+')');
				if(data.noread3 != 0)
					$('#tab_3').html('区县消息('+ data.noread3+')');
				if(data.noread4 != 0)
					$('#tab_4').html('学校消息('+ data.noread4+')');
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
	});
	
}

function read(no,messageId,contents,userImageUrl){
	if(typeof(userImageUrl) == "undefined"||userImageUrl=='null'||userImageUrl==''){
		$("#read"+no).html(contents);
	}else{
		var fileName = 	userImageUrl.substring(userImageUrl.lastIndexOf("/")+1);
		$("#read"+no).html(contents+'附件：<a href="##" onclick="downloadFile(\''+userImageUrl+'\')" >'+fileName+"下载</a>");
		
	}
	
	var url = pathHeader+ "/message/messageManagement/readMessageInfo.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
		messageId:messageId
		},
		async:true,
		success:function(data){
			if(data.success){}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
	});
	

	

	
	
}
function readOff(no,messageId,contents,userImageUrl){
	if(typeof(userImageUrl) == "undefined"||userImageUrl=='null'||userImageUrl==''){
		$("#read"+no).html(contents);
	}else{
		var fileName = 	userImageUrl.substring(userImageUrl.lastIndexOf("/")+1);
		$("#read"+no).html(contents+'附件：<a href="##" onclick="downloadFile(\''+userImageUrl+'\')" >'+fileName+"下载</a>");
		
	}
}

function getMessageCount(){
	var url = pathHeader+ "/message/messageManagement/getMessageCounts.do";
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

function addMore() {
	var tr = '<tr><td width="450" colspan="2">'
			+ '<input type="file" style="float:left;" name="file" /> '
			+ '</td></tr>';
	$("#files").append(tr);
}








function sendInfo(){
	var sendType = $('input:radio[name="sendType"]:checked').val();
	if(!receverNameError && sendType == "byName"){
		$('#receverNameError').html("收信人不能为空!");
		return;
	}
	
	if(sendType=="byProject"){
		var project = $("#projectList").val();
		if(project=='-1'){
			$('#byProjectError').html("项目不能为空!");
		}
	}
	
	if(sendType=="byArea"){
		var areaName = $("#areaName").val();
		if(areaName==''){
			$('#byAreaError').html("地区不能为空!");
		}
	}
	
	if(sendType=="byRole"){
		var roleId = $("#roleId").val();
		if(roleId=='-1'){
			$('#byRoleError').html("角色不能为空!");
		}
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
	var url = pathHeader+ "/message/messageManagement/sendMessageToUser.do?time="+new Date();
	
	var areaId = $('#areaId').val();
	var roleId = $('#roleId').val();
	var projectId = $('#projectList').val();
	var areaIdName = $('#areaIdName').val();
	
	var files = $("input[name='file']");
	//通知里面的附件不一定是必须的
//	if(files==null || files.length ==0 || files[0].value == ""){
//		jQuery.generalAlert("请上传文件！");
//		return ;
//	}
	
	if(files != null && files.length !=0){
		for(var i = 0;i<files.length;i++){
			var name = files[i].value.toString();
			var ext = name.substring(name.lastIndexOf('.')+1,name.length);
			if(ext=="jsp" || ext == "html" || ext == "htm"){
				jQuery.generalAlert("上传文件格式非法！请重新上传！");
				return ;
			}
		}
	}
	
	
	
	$("#messageForm").ajaxSubmit({
				url:url,
				type:"post",
				data:{
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
					var jsonData =jQuery.parseJSON(data)
					if(jsonData.success){
						jQuery.generalAlert("发送成功");
						$(".tip").fadeOut(100);
						messageList(1);
					}else{
						jQuery.generalAlert(jsonData.info);
						$(".tip").fadeOut(100);
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

function downloadFile(filePathName){
	//下载能使用jquery的ajax，因为ajax的返回值不支持流
	var url =  pathHeader + '/message/messageManagement/downloadMessageFile.do';
	var form= $("<form>");//定义一个form表单
	form.attr("style","display:none");
	form.attr("method","post");
	form.attr("action",url);
	var input=$("<input>");
	input.attr("type","hidden");
	input.attr("name","filePathName");
	input.attr("value",filePathName);
	$("body").append(form);//将表单放置在web中
	form.append(input);
	form.submit();//表单提交
}

