var setting = {
	check : {
		enable : true,
		chkboxType : {
			"Y" : "ps",
			"N" : "ps"
		}
	},

	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		 beforeClick : beforeClick,
		 onCheck : onCheck
	}
};




function getNode() {
	var url = pathHeader + "/notice/getNode.do";
	$.ajax({
		url : url,
		dataType : "json",
		type : "post",
		async : true,
		success : function(data) {
			var zNodes = data;
			//console.info("子节点的长度：" + data.length);
			var treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			treeObj.expandAll(true);
		},
		error : function() {
			alert("节点加载失败");
		}
	});

}

function dblClickExpand(treeId, treeNode) {
	return treeNode.level > 0;
}

function beforeClick(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, true, true);
	return false;
}

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	//得到已经选中的节点
	var nodes = zTree.getCheckedNodes(true);
	//console.info("选中节点的长度："+ nodes.length);
	var allNodes = zTree.transformToArray(zTree.getNodes());
	//console.info("全部节点的长度："+ allNodes.length);
	var v = "";
	var values = "";
	var cityObj = $("#citySel");
	var selectValueObj = $("#selectValue");
	if(nodes.length == allNodes.length && nodes.length!=1){
		//全部选中且管理员是区管理员
		for ( var i = 0, l = nodes.length; i < l; i++) {
			if(nodes[i].isParent){
				v += nodes[i].name + ",";
				values += nodes[i].id + ",";
			}
		}
	}else{
		//部分选中
		for ( var i = 0, l = nodes.length; i < l; i++) {
			if(!nodes[i].isParent){
				v += nodes[i].name + ",";
				values += nodes[i].id + ",";
			}
		}
	}
//	for ( var i = 0, l = nodes.length; i < l; i++) {
//			v += nodes[i].name + ",";
//			values += nodes[i].id + ",";
//	}
	
	if (v.length > 0)
		v = v.substring(0, v.length - 1);
	if (values.length > 0)
		values = values.substring(0, values.length - 1);

	cityObj.attr("value", v);
	selectValueObj.attr("value", values);
	//console.info(v);
	//console.info(values);
}

function showMenu() {
	var cityObj = $("#citySel");
	var cityOffset = $("#citySel").offset();
	$("#menuContent").css({
		left : cityOffset.left + "px",
		top : cityOffset.top + cityObj.outerHeight() + "px"
	}).slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "citySel"
			|| event.target.id == "menuContent" || $(event.target).parents(
			"#menuContent").length > 0)) {
		hideMenu();
	}
}

/**
 * 通知 tip切换
 * 
 * @param {Object}
 *            type
 */
function change(type) {
	if (type == 1) {
		$('#tab_1').attr('class', 'selected');
		$('#tab1').show();
		$('#tab_2').attr('class', '');
		$('#tab2').hide();
		$('#tab_3').attr('class', '');
		$('#tab3').hide();
		$('#tab_4').attr('class', '');
		$('#tab4').hide();
		noticeList(1);
	}
	if (type == 2) {
		$('#tab_1').attr('class', '');
		$('#tab1').hide();
		$('#tab_2').attr('class', 'selected');
		$('#tab2').show();
		$('#tab_3').attr('class', '');
		$('#tab4').hide();
		$('#tab_4').attr('class', '');
		$('#tab4').hide();
		noticeList(2);
	} else if (type == 3) {
		$('#tab_1').attr('class', '');
		$('#tab1').hide();
		$('#tab_2').attr('class', '');
		$('#tab2').hide();
		$('#tab_3').attr('class', 'selected');
		$('#tab3').show();
		$('#tab_4').attr('class', '');
		$('#tab4').hide();
		noticeList(3);
	} else if (type == 4) {
		$('#tab_1').attr('class', '');
		$('#tab1').hide();
		$('#tab_2').attr('class', '');
		$('#tab2').hide();
		$('#tab_3').attr('class', '');
		$('#tab3').hide();
		$('#tab_4').attr('class', 'selected');
		$('#tab4').show();
		noticeList(4);
	}
}

function noticeList(type) {
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/notice/noticeList.do";
	$.ajax({
		url : url,
		type : "post",
		data:{
			noticeType:type,	
			startIndex : pageIndex,
			pageSize:sizePerPage
			},
		success : function(data) {
			if (data.success) {
				var rows = data.rows;
				if (rows.length > 0) {
					var gridHtml = "";
					$.each(rows, function(index, element) {
						gridHtml += getTdHtml(element);
					});
					$('#noticeList').html(gridHtml);
					pagination2(data,type);
					//pagination(data, function noticeList(type));
				} else {
					$('#noticeList').html(
							"<tr><td colspan='7'>无查询记录！</td></tr>");
					pagination2(data,type);
				}
			}
		},
		error : function() {
			jQuery.generalAlert("查询错误");
		}
	});
}

function pagination2(data,type){
	if(type==1){
		pagination(data, function(){ noticeList(1);});
	}
	if(type==2){
		pagination(data, function(){ noticeList(2);});
	}
	if(type==3){
		pagination(data, function(){ noticeList(3);});
	}
	if(type==4){
		pagination(data, function(){ noticeList(4);});
	}
	
}




function sendNotice(){
	
	if(!$.trim($("#title").val()).length > 0){
		jQuery.generalAlert("通知标题不为空!");
		return;
	}
	if(!$.trim($("#citySel").val()).length > 0){
		jQuery.generalAlert("发送范围不为空!");
		return;
	}
	
	if(!$.trim($("#content").val()).length > 0){
		jQuery.generalAlert("通知内容不为空!");
		return;
	}
	
	
	$("#noticeForm").ajaxSubmit({
		success : function(data) {
			var url = pathHeader + "/notice/myNoticeList.htm?click=4"
			var jsonData = jQuery.parseJSON(data)
			if(jsonData.success){
				jQuery.generalAlertAndJump("通知发送成功！",url);
			}else{
				jQuery.generalAlertAndJump("通知发送失败！",url);
			}
			
		},
		error : function() {
			jQuery.generalAlert("URL ERROR");
		}
	});
}


function myNoticeList() {
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader + "/notice/myNoticeList.do";
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
					$('#noticeList').html(gridHtml);
					pagination(data, function(){ myNoticeList();});
				} else {
					$('#noticeList').html(
							"<tr><td colspan='7'>无查询记录！</td></tr>");
				}
			}
		},
		error : function() {
			jQuery.generalAlert("查询错误");
		}
	});

}



function getTdHtml(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + transformRead(obj.isRead) + "</td>";
	gridHtml += "<td>" + obj.title + "</td>";
	gridHtml += "<td>" + obj.sendUserName + "</td>";
	gridHtml += "<td>" + new Date(obj.createDate).format("yyyy-MM-dd");
	+"</td>";
	gridHtml += "<td>" + transFormNoticeType(obj.noticeType) + "</td>";
	gridHtml += "<td>" + transFormSendType(obj.sendType) + "</td>";
	gridHtml += "<td><a href='" + pathHeader + "/notice/noticeDetail.htm?id="
			+ obj.id + "' >查看</a> &nbsp; <a href='" + pathHeader + "/notice/noticeDeleteFromOther.htm?id="
			+ obj.id + "' ></a></td></tr>";
	return gridHtml;

}

function transformRead(read){
	if(read)
		return "已读";
	return "<font color='red'>未读</font>";
}


function transFormNoticeType(noticeType){
	if(noticeType==1)
		return "省级通知";
	if(noticeType==2)
		return "市级通知";
	if(noticeType==3)
		return "区级通知";
	if(noticeType==4)
		return "学校通知";
}

function transFormSendType(sendType){
	if(sendType==0)
		return "全部";
	if(sendType==1)
		return "行政管理员";
	if(sendType==2)
		return "实施机构管理员";
	if(sendType==3)
		return "教师";
}


function getTdHtml2(obj) {
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.title + "</td>";
	gridHtml += "<td>" +  transFormSendType(obj.sendType) + "</td>";
	gridHtml += "<td>" + obj.sendUserName + "</td>";
	gridHtml += "<td>" + new Date(obj.createDate).format("yyyy-MM-dd");
	+"</td>";
	gridHtml += "<td><a href='" + pathHeader + "/notice/myNoticeDetail.htm?id="
			+ obj.id + "' >查看</a> &nbsp; <a href='" + pathHeader + "/notice/noticeDelete.htm?id="
			+ obj.id + "' >删除</a></td></tr>";
	return gridHtml;

}

function getNoticeCountsByNoticeType(){
	var url = pathHeader + "/notice/getNoticeCountsByNoticeType.do"
	$.ajax({
		url : url,
		type : "post",
		success : function(data) {
			if(data.success){
				//console.info("省未读通知："+ data.proviceNoReadCount);
				//console.info("市未读通知："+ data.cityNoReadCount);
				//console.info("县未读通知："+ data.districtNoReadCount);
				//console.info("校未读通知："+ data.schoolNoReadCount);
				$("#proviceNoReadCount").html(data.proviceNoReadCount);
				$("#cityNoReadCount").html(data.cityNoReadCount);
				$("#districtNoReadCount").html(data.districtNoReadCount);
				$("#schoolNoReadCount").html(data.schoolNoReadCount);
			}
			
		},
		error : function() {
			jQuery.generalAlert("查询错误");
		}
	});
}


function getNoticeCountsForOne(){
	var url = pathHeader+ "/notice/getNoticeCounts.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				$('#noticeNoReadCount').html(data.noticeCount);
				$('#allNoticeCount').html(data.allNoticeCount);
			}
		},
		error:function(){
			alert("查询错误");
		}
	});
}


//上传证书模板背景
function uploadFile(){
	$.ajaxFileUpload({
        url:pathHeader + '/notice/uploadFile.do',
        secureuri:false,
        fileElementId:'noticeFile',  //文件选择框的id属性（必须）
        dataType: 'json',  
        type:'post',
        data : {type: 'notice'},
		success:function(data){
			var table="";
			if(data.success){
				var item = data.file;
				table += "<tr id=file"+item.id+"><td><input type='hidden' value='"+item.url+"|"+item.name+"'  name='fileUrls' /> "
						+ item.name
						+ "</td><td>"
						+ "<a href='#' onclick=downloadFile('"
						+ item.url
						+ "') >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下载 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
						+ "<td><a href='#' onclick= removeFile('"
						+ item.id + "','" + item.url
						+ "','"
						+ item.projectId
						+ "') >删除 </a>" + "</td></tr>";
			
				$("#fileList").append(table);
			} else {
				table += "<tr><td>失败</td></tr>"
				$("#fileList").append(table);
			}
		},
		error:function(){
		}
	});
}

//下载文件
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

function removeFile(id, filePath, pid) {
	jQuery.confirmWindow(
					"提示",
					"是否删除该文件？",
					function() {
						var url = pathHeader
								+ "/fileupload/deleteFile.do?";
						$
								.ajax({
									dataType : 'json',
									type : 'post',
									url : url,
									data : {
										id : id,
										filePath : filePath,
										pid : pid
									},
									success : function(data) {
										jQuery.generalAlert("删除成功");
										$("#file"+id).remove();
										
									},
									error : function() {
										jQuery.generalAlert("删除失败");
									}
								});
					});

}