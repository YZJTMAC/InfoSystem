$(function(){
	if($("#pageFlag").val()==1){
		messageList(1);
	}
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

function messageList(type){
	$('#messageList').html("");
	
	var url = pathHeader+ "/message/messageManagement/messageList.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			type : type,
			startIndex : $("#pageIndex").val(),
			pageSize : $("#sizePerPage").val()
		},
		async:true,
		success:function(data){
			if(data.success){
				var totalNum = data.noReadTotal;
				$("#messageCounts").html(totalNum);
				$("#counts").html(totalNum);
				
				var rows = data.rows;
				if(rows.length > 0){
					var gridHtml = "";
					$.each(rows, function(index, element) {
						gridHtml += getTdHtml(element);
					});
					$('#messageList').html(gridHtml);
				}else{
					$('#messageList').html("<tr><td colspan='6'>无查询记录！</td></tr>");
				}
				$('#tab1_num').html(data.noread1);
				$('#tab2_num').html(data.noread2);
				$('#tab3_num').html(data.noread3);
				$('#tab4_num').html(data.noread4);
				
				if(type == 1){
					pagination(data, function(){ messageList(1);});
				}else if(type == 2){
					pagination(data, function(){ messageList(2);});
				}else if(type == 3){
					pagination(data, function(){ messageList(3);});
				}else if(type == 4){
					pagination(data, function(){ messageList(4);});
				}
			}
		},
		error:function(){
			jQuery.generalAlert("查询错误");
		}
	});
}

function transFormMessageType(messageType){
	if(messageType==1)
		return "省级通知";
	if(messageType==2)
		return "市级通知";
	if(messageType==3)
		return "区级通知";
	if(messageType==4)
		return "学校通知";
}

function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + (obj.status==0 ? '<font color=\'red\'>未读</font>' : (obj.status==1 ? '已读' : '')) + "</td>";
	gridHtml += "<td>" + obj.title + "</td>";
	gridHtml += "<td>" + obj.sendUserName + "</td>";
	gridHtml += "<td>" + new Date(obj.sendTime).format("yyyy-MM-dd") + "</td>";
	gridHtml += "<td>"+ transFormMessageType(obj.messageType) +"</td>";
	gridHtml += "<td><a href='" + pathHeader + "/message/messageManagement/messageDetail.htm?messageId="+ obj.id + "&messageUserId="+ obj.messageUserId +"'>查看</a> &nbsp; <a href='#' onclick='deleteMessage("+ obj.messageUserId + ");'>删除</a></td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function deleteMessage(messageUserId){
	var url = pathHeader+ "/message/messageManagement/deleteMessage.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			id:messageUserId
		},
		async:true,
		success:function(data){
			if(data.success){
				window.location.reload();
			}else{
				jQuery.generalAlert("删除失败");
			}
		},
		error:function(){
			jQuery.generalAlert("错误");
		}
	});
}

//我的通知
function myMessageList() {
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/message/messageManagement/myMessageList.do";
	$.ajax({
		url : url,
		type : "post",
		data:{
			startIndex : pageIndex,
			pageSize:sizePerPage
		},
		success : function(data) {
			if (data.success) {
				var rows = data.rows;
				if (rows.length > 0) {
					var gridHtml = "";
					$.each(rows, function(index, element) {
						gridHtml += getTdHtml2(element);
					});
					$('#messageList').html(gridHtml);
					pagination(data, function(){ myMessageList();});
				} else {
					$('#messageList').html("<tr><td colspan='7'>无查询记录！</td></tr>");
				}
			}
		},
		error : function() {
			jQuery.generalAlert("查询错误");
		}
	});
}

function getTdHtml2(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.title + "</td>";
	gridHtml += "<td>" +  transFormMessageType(obj.messageType) + "</td>";
	gridHtml += "<td>" + obj.sendUserName + "</td>";
	gridHtml += "<td>" + new Date(obj.createDate).format("yyyy-MM-dd") +"</td>";
	gridHtml += "<td><a href='" + pathHeader + "/message/messageManagement/messageDetail.htm?messageId=" + obj.id + "' >查看</a> &nbsp; <a href='#' onclick='deleteMyMessage("+ obj.id + ");'>删除</a></td></tr>";
	return gridHtml;

}

//删除我创建的消息
function deleteMyMessage(messageId){
	var url = pathHeader+ "/message/messageManagement/deleteMyMessage.do";
	$.ajax({
		url:url,
		type:"post",
		data:{
			messageId: messageId
		},
		async:true,
		success:function(data){
			if(data.success){
				window.location.reload();
			}else{
				jQuery.generalAlert("删除失败");
			}
		},
		error:function(){
			jQuery.generalAlert("错误");
		}
	});
}

/*function deleteAllMessage(){
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
}*/

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