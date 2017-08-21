$(function(){
	showOrgProjectList();
	
	// 条件查询
	$("#select").click(function() {
		showOrgProjectList();
	});
	
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
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#orgProject_list').append(gridHtml);
			}
			pagination(data, function(){showOrgProjectList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
			$('#orgProject_list').append(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+infoFormatter(obj)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function infoFormatter(obj){
		return "<a href='###' class='tablelink'  onclick='info(\"" + obj.id + "\");'>"+ nullFormatter(obj.projectName)+"</a>";
	}
	
	//"<a href='###' class='tablelink'  onclick='info(\"" + row.id + "\");'>查 看</a>"trainingHomeAddress
	function optionFormatter(row){
		return "<a href='###' class='tablelink'  onclick='setup(\"" + row.id + "\",\""+row.trainingAddress+"\",\""+row.updateDate+"\",\""+row.trainingHomeAddress+"\",\""+row.orgName+"\");'>设 置</a>";
	}
}

/**
 * 查看详情
 * @param {Object} projectId
 */
function info(projectId){
	var openUrl = pathHeader + '/org/orgProjectInfoPage.htm?projectId=' + projectId+'&click=11';
	window.open(openUrl);
}

/**
 * 设置
 * @param {Object} projectId
 */
function setup(projectId, trainingAddress, updateDate, trainingHomeAddress, orgName){
	$('#projectId').val('');
	$('#orgName').html('');
	$('#updateDate').val('');
	$('#trainingAddress').val('');
	$('#trainingHomeAddress').val('');

	$("#tishi").fadeIn(100);	
	//$("#tishi_2").fadeOut(100); 

	$('#orgName').html('承培机构：'+orgName);
	$('#projectId').val(projectId);
	$('#updateDate').val(updateDate);
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


$(function(){
	$("#sure").click(function() {
		$(".tip").fadeOut(100);
		setTrainingAddress();
	});
	
	$("#cancel").click(function() {
		$(".tip").fadeOut(100);
	});
	$(".tiptop a").click(function() {
		$(".tip").fadeOut(100);
	});
});

function setTrainingAddress(){
	$.ajax({
		url : pathHeader + '/org/orgProjectModify.do',
		type:"POST",
		cache:"false",
		async:"true",
		data :{
			projectId : $('#projectId').val(),
			trainingAddress : $('#trainingAddress').val(),
			trainingHomeAddress : $('#trainingHomeAddress').val(),
			updateDate :  $('#updateDate').val()
		},
		success:function(data){
			if(data.success) {
				//alert("设置成功!");
				$('#tishi_3').fadeIn(200);
			} else {
				//alert("设置失败!");
				$('#label').html('设置失败!');
				$('#tishi_2').fadeIn(200);
			}
		},
		error:function(){
			//alert("设置失败!");
			$('#label').html('设置失败!');
				$('#tishi_2').fadeIn(200);
		}
	});
}

function ok(){
	$("#tishi_2").fadeOut(100); 
}


function queding(){
	window.location.href = pathHeader + '/org/orgProjectListPage.htm?click=11';
}