
$(function(){
	showOrgProjectList();
	$("#select").click(function() {
		showOrgProjectList();
	});
	
	// 设置项目状态
//	$(".sure").click(function() {
//		$(".tip").fadeOut(100);
//		setProjectStatus();
//	});
});


function showOrgProjectList(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgProjectList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			startTime : $('#beginDate').find("option:selected").val(),
			endTime : $('#endDate').find("option:selected").val(),
			pageIndex : pageIndex
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#orgProject_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='9'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
			pagination(data, function(){showOrgProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='9'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
	gridHtml += "<td>"+statusFormatter(obj)+"</td>";
	gridHtml += "<td>"+proStatusFormatter(obj)+"</td>";
	gridHtml += "<td>"+optFormatter(obj)+"</td></tr>";
	//gridHtml += "<td>"+"<a href='###' class='tablelink click' onclick='updateStatus(\""+obj.projectName+"\", \""+obj.id+"\", \""+obj.projectStatus+"\");'>设 置</a></td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	
	function statusFormatter(row){
		if(row.status==30){ 
			return '待启动'; 
		} else if(row.status==40){
			return '进行中';
		} else if(row.status==50){
			return '已结束';
		} else if(row.status==60){
			return '已关闭	';
		}	
	}
	
	
	function proStatusFormatter(row){
		if(row.projectStatus==30){ 
			return '待启动'; 
		} /*else if(row.projectStatus==31){//废弃此状态值
			return '准备就绪';
		}*/ else if(row.status==40 && row.projectStatus==40){
			return '进行中';
		} else if(row.status==40 && row.projectStatus==41){
			return '暂停中';
		} else if(row.status==50 && row.projectStatus==40){
			return '开放访问';
		} else if(row.status==50 && row.projectStatus==41){
			return '暂停访问';
		} else {
			return '已关闭';
		}
	}
	
	
	function optFormatter(obj){
		/*if(proStatusFormatter(obj)=='未准备就绪'){
			return "<a href='###' class='tablelink click' onclick='setProjectStatus(\""+obj.id+"\", \""+obj.projectStatus+"\", \""+31+"\");'>准备就绪</a>";
		} else */if(proStatusFormatter(obj)=='进行中' || proStatusFormatter(obj)=='开放访问'){
			return "<a href='###' class='tablelink click' onclick='setProjectStatus(\""+obj.id+"\", \""+obj.projectStatus+"\", \""+41+"\");'>暂停</a>";
		} else if(proStatusFormatter(obj)=='暂停中' || proStatusFormatter(obj)=='暂停访问'){
			return "<a href='###' class='tablelink click' onclick='setProjectStatus(\""+obj.id+"\", \""+obj.projectStatus+"\", \""+40+"\");'>继续</a>";
		} else {
			return '';
		}
	}
}


/**
 * 设置项目状态
 * @param {Object} projectId

function updateStatus(projectName, projectId, oldStauts){
	$('#projectId').val(projectId);
	$('#projectStatus').val(oldStauts);
	$('#projectName1').html('项目名称: '+projectName);
	$(".tip").fadeIn(200); 	
}
*/
 
/**
 * 
 * @param {Object} projectId
 * @param {Object} oldStatus
 * @param {Object} status
function setProjectStatus(projectId, oldStatus, status){
	//var status =  $('#status').find("option:selected").val();
	//var oldStatus = $('#projectStatus').val();
	//if(status == 0){
	//	jQuery.generalAlert('请选择要调整的状态!');
	//	return false;
	//}
	//if(status == oldStatus){
	//	jQuery.generalAlert("状态未变更, 请重新选择");
	//	return false;
	//}
	
	var isOK = confirm('是否变更项目状态？');
	
	if(isOK){
		$.ajax({
			url : pathHeader + '/org/modifyOrgProjectStatus.do',
			type:"POST",
			cache:"false",
			async:"true",
			dataType:"json",
			data:{
				projectId : projectId,
				status : status,
				oldStatus : oldStatus
			},
			success:function(data){
				if(data.success == 'noURL'){
					jQuery.generalAlert("此项目未设置培训平台地址, 请先设置培训平台地址!");
				} else if(data.success) {
					jQuery.generalAlert("更改成功!");
					window.location.href = pathHeader + '/org/orgProjectStatusPage.htm?click=12';
				} else {
					jQuery.generalAlert("更改失败!");
				}
			},
			error:function(){
				jQuery.generalAlert("更改失败!");
			}
		});
	}
}
 */

/**
 * 
 * @param {Object} projectId
 * @param {Object} oldStatus
 * @param {Object} status
 */
function setProjectStatus(projectId, oldStatus, status){
	$('#projectId').val(projectId);
	$('#oldStatus').val(oldStatus);
	$('#statu').val(status);
	
	$("#tishi").fadeIn(100); 	
}


function surew(){
	$("#tishi").fadeOut(100); 
	
	$.ajax({
		url : pathHeader + '/org/modifyOrgProjectStatus.do',
		type:"POST",
		cache:"false",
		async:false,
		dataType:"json",
		data:{
			projectId : $('#projectId').val(),
			status : $('#statu').val(),
			oldStatus : $('#oldStatus').val()
		},
		success:function(data){
			if(data.success == 'noURL'){
				//jQuery.generalAlert("此项目未设置培训平台地址, 请先设置培训平台地址!");
				$('#label').html('此项目未设置培训平台地址, 请先设置培训平台地址!');
				$('#tishi_2').fadeIn(200);
			} else if(data.success) {
				//jQuery.generalAlert("更改成功!");
				$('#tishi_3').fadeIn(200);
			} else {
				//jQuery.generalAlert("更改失败!");
				$('#label').html('更改失败!');
				$('#tishi_2').fadeIn(200);
			}
		},
		error:function(){
			//jQuery.generalAlert("更改失败!");
			$('#label').html('更改失败!');
			$('#tishi_2').fadeIn(200);
		}
	});
}


function cancel(){
	$("#tishi").fadeOut(100); 
}

function ok(){
	$("#tishi_2").fadeOut(100); 
}


function queding(){
	window.location.href = pathHeader + '/org/orgProjectStatusPage.htm?click=12';
}