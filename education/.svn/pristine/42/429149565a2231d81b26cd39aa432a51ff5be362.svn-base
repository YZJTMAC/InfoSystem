
$(function(){
	showOrgProjectList();
	$("#select").click(function() {
		showOrgProjectList();
	});
	
	//对接设置
	$("#sure").click(function() {
		$(".tip").fadeOut(100);
		setTrainingAddress();
	});
	
	//取消对接设置
	$("#cancel").click(function() {
		$(".tip").fadeOut(100);
	});
	
	$(".tiptop a").click(function() {
		$(".tip").fadeOut(100);
	});
});

//对接设置
function setTrainingAddress(){
	$.ajax({
		url : pathHeader + '/org/ssOrgProjectModify.do',
		type:"POST",
		cache:"false",
		async:"true",
		data :{
			projectId : $('#projectId').val(),
			trainingAddress : $('#trainingAddress').val(),
			trainingHomeAddress : $('#trainingHomeAddress').val(),
			organizationName : $('#orgName').text(),
//			optionFlag : $('#optionFlag').val(),
//			updateDate :  $('#updateDate').val()
		},
		success:function(data){
			if(data.success) {
				showOrgProjectList();
				jQuery.generalAlert("设置成功!");
			} else {
				jQuery.generalAlert("设置失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("设置失败!");
		}
	});
}

function showOrgProjectList(){
	$('#orgProject_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/ssOrgProjectList.do',
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
				gridHtml = "<tr><td align='center'colspan='13'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
			pagination(data, function(){showOrgProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='13'>暂无查询结果！</td></tr>";
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
	//gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.orgName+"</td>";
	gridHtml += "<td>"+obj.auditor+"</td>";
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
	
	//edu_project表废弃status=21(审核通过)状态，其中status=30表示意义由"筹备中"改为"待启动"
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
	
	//edu_organization_project表废弃project_status=31(准备就绪状态)，其中project_status=30表示意义由"未准备就绪"改为"待启动"
	function proStatusFormatter(row){
		if(row.projectStatus==30){ 
			return '待启动'; 
		} else if(row.status==40 && row.projectStatus==40){
			return '进行中';
		} else if(row.status==40 && row.projectStatus==41){
			return '暂停中';
		} else if(row.status==50 && row.projectStatus==40){
			return '开放访问';
		} else if(row.status==50 && row.projectStatus==41){
			return '暂停访问';
		} else if(row.status==60 ){
			return '已关闭';
		} /*else {
			return '待对接设置';
		}*/
	}
	
	
	function optFormatter(obj){
		var optionHtml = "";		
		if(obj.trainTypeId != '2'){			
			optionHtml +=  "<a href='###' class='tablelink click' onclick='setup(\"" + obj.id + "\",\""+obj.trainingAddress+"\",\""+obj.trainingHomeAddress+"\",\""+obj.orgName+"\");'>对接设置</a>&nbsp;&nbsp;";			
		}			
		/*if(proStatusFormatter(obj)=='未准备就绪'){
			optionHtml +=  "<a href='###' class='tablelink click' onclick='setProjectStatus(\""+obj.id+"\", \""+obj.projectStatus+"\", \""+31+"\");'>准备就绪</a>";
		} else */
		if(proStatusFormatter(obj)=='进行中' || proStatusFormatter(obj)=='开放访问'){
			optionHtml +=  "<a href='###' class='tablelink click' onclick='setProjectStatus(\""+obj.id+"\", \""+obj.projectStatus+"\", \""+41+"\");'>暂停</a>";
		} else if(proStatusFormatter(obj)=='暂停中' || proStatusFormatter(obj)=='暂停访问'){
			optionHtml +=  "<a href='###' class='tablelink click' onclick='setProjectStatus(\""+obj.id+"\", \""+obj.projectStatus+"\", \""+40+"\");'>继续</a>";
		} else if(proStatusFormatter(obj)=='待对接设置' ){
			
		} else {
			optionHtml +=  "";
		}
		
		return optionHtml;
	}
}

/**
 * 设置
 * @param {Object} projectId
 */
function setup(projectId, trainingAddress, trainingHomeAddress, orgName){
	$('#projectId').val('');
	$('#orgName').html('');
//	$('#updateDate').val('');
	$('#trainingAddress').val('');
	$('#trainingHomeAddress').val('');
//	$('#optionFlag').val('');

	$("#tishi").fadeIn(100);	

	$('#orgName').html(orgName);
	$('#projectId').val(projectId);
//	$('#updateDate').val(updateDate);
//	$('#optionFlag').val(optionFlag);
	if(trainingAddress!=null && trainingAddress!='null' && trainingAddress.length!=0){
		$('#trainingAddress').val(trainingAddress);
	} else {
		$('#trainingAddress').val('http://');
	}
	if(trainingHomeAddress!=null && trainingHomeAddress!='null' && trainingHomeAddress!=0){
		$('#trainingHomeAddress').val(trainingHomeAddress);
	} else {
		$('#trainingHomeAddress').val('http://');
	}
}

/**
 * 暂停/继续
 * @param {Object} projectId
 * @param {Object} oldStatus
 * @param {Object} status
 */
function setProjectStatus(projectId, oldStatus, status){
	$('#projectId').val(projectId);
	$('#oldStatus').val(oldStatus);
	$('#statu').val(status);
	
	$("#tishi1").fadeIn(100); 	
}

//暂停/继续
function surew(){
	$("#tishi1").fadeOut(100); 
	
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
				jQuery.generalAlert("此项目未设置培训平台地址, 请先设置培训平台地址!");
			} else if(data.success) {
				showOrgProjectList();
				jQuery.generalAlert("更改成功!");
			} else {
				jQuery.generalAlert("更改失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("更改失败!");
			$('#tishi_2').fadeIn(200);
		}
	});
}


function cancel(){
	$("#tishi1").fadeOut(100); 
}

function ok(){
	$("#tishi_2").fadeOut(100); 
}


function queding(){
	window.location.href = pathHeader + '/org/orgProjectStatusPage.htm?click=12';
}