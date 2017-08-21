/**
 * 消息type： 0省  1市   2区  3行政管理员   4实施机构   5实施机构管理员   6学校类型  7学校  8校管理员   9教师
 */
$(function(){
	$(".select3").uedSelect({
		width : 300
	});

	initNodes();
});


function initNodes(){
	$("#selectUsers").val("");
	
	$.ajax({
		url : pathHeader + "/message/messageManagement/getAreaNode.do?receiveRole="+  $("#receiveRole").val(),
		dataType : "json",
		type : "post",
		async : true,
		success : function(data) {
			//console.info("节点的长度：" + data.length);
			var zNodes = eval("(" + JSON.stringify(data) + ")");
			var treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			//treeObj.expandAll(true);
		},
		error : function() {
			alert("节点加载失败");
		}
	});
}

var setting = {
	view: {
		dblClickExpand: false,
		showLine: true,
		showIcon: false
	},
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
	var names = "";
	var users = "";
	
	for(var i = 0, l = nodes.length; i < l; i++) {
		if(nodes[i].type==3 || nodes[i].type==5 || nodes[i].type==8 || nodes[i].type==9){//选中行政管理员  或 实施机构管理员 或 校管理员 或教师
			names += nodes[i].name + ",";
			users += nodes[i].id + "_" + nodes[i].name + ",";
		}
	}
	
	if(names.length > 0)
		names = names.substring(0, names.length - 1);
	if(users.length > 0)
		users = users.substring(0, users.length - 1);

	$("#selectUsers").attr("value", names);
	$("#area").attr("value", users);
	//console.info(names);
	//console.info(users);
}

function showMenu() {
	var cityObj = $("#selectUsers");
	var cityOffset = $("#selectUsers").offset();
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
	if (!(event.target.id == "menuBtn" || event.target.id == "selectUsers"
			|| event.target.id == "menuContent" || $(event.target).parents(
			"#menuContent").length > 0)) {
		hideMenu();
	}
}

function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}

function sendMessage(){
	if(!$.trim($("#title").val()).length > 0){
		jQuery.generalAlert("通知标题不为空!");
		return;
	}
	if(!$.trim($("#selectUsers").val()).length > 0){
		jQuery.generalAlert("发送范围不为空!");
		return;
	}
	
	if(!$.trim($("#content").val()).length > 0){
		jQuery.generalAlert("通知内容不为空!");
		return;
	}
	
	$("#messageForm").ajaxSubmit({
		url : pathHeader + "/message/messageManagement/sendMessageByScope.do?time="+new Date(),
		type:"post",
		async:true,
		beforeSend: function(){
		},
		success : function(data) {
			var url = pathHeader + "/message/messageManagement/sendMessageByScope.htm?click=3"
			var jsonData = jQuery.parseJSON(data)
			if(jsonData.success){
				jQuery.generalAlertAndJump("发送成功！",url);
			}else{
				jQuery.generalAlert(jsonData.info);
			}
		},
		error : function() {
			jQuery.generalAlert("ERROR");
		}
	});
}