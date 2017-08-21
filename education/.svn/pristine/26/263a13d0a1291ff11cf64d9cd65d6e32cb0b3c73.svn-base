$(function(){
	queryProject(1);
	
	// 待分配(条件查询)
	$('#select_1').click(function(){
		queryProject(1);
	});
	
	// 已分配(条件查询)
	$('#select_2').click(function(){
		queryProject(0);
	});
	
	$('#btnOK').click(function() {
		// 确定指定承培机构
		btnOKAssignOrg();
	});
	
	$('#btnQX').click(function() {
		$('#tanqi').hide();
	});
});


/**
 * 待分配/已分配	tip切换
 * @param {Object} type
 */

var state = 1;
function change(type){
	if(type == 1){
		queryProject(1);
		state = 1;
		
		$('#tab_1').attr('class','selected');
		$('#tab1').show();
		$('#tab_2').attr('class','');
		$('#tab2').hide();
	} else {
		queryProject(0);
		state = 0;
		
		$('#tab_1').attr('class','');
		$('#tab1').hide();
		$('#tab_2').attr('class','selected');
		$('#tab2').show();
	}
}


function queryProject(status){
	$('#table_list_1').html('');
	$('#table_list_2').html('');
	
	var projectName = '';
	var year = '';
	var trainType = '';
	var startDate = '';
	var endDate = '';
	
	// 参数
	if(status == 1){
		projectName = $('#project_name_1').val();
		year = $('#yearpicker').find("option:selected").val();
		trainType = $('#trainType').find("option:selected").val();
	} else {
		projectName = $('#project_name_2').val();
		startDate = $('#startDate').find("option:selected").val();
		endDate = $('#endDate').find("option:selected").val();
	}
	
	var pageIndex = $("#pageIndex").val();
	
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/selectProjectByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : projectName,
			year : year,
			trainType : trainType,
			startDate : startDate,
			endDate : endDate,
			status : status,// 1: 待分配, 0:已分配
			pageIndex : pageIndex
		},
		success:function(data){
			
			clear();
			
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element, status);
				});
				if(status == 1){
					$('#table_list_1').append(gridHtml);
					$('#page_1').append("<div id='pagebar' class='pagin'></div>");
				} else {
					$('#table_list_2').append(gridHtml);
					$('#page_2').append("<div id='pagebar' class='pagin'></div>");
				}
				
			} else {
				changeTip(status);
			}
			
			pagination(data, function(){queryProject(state);});
		},
		error:function(data){
			changeTip(status);
		}
	});
}


/**
 * 待分配/已分配	查不出数据时
 * @param {Object} status
 */
function changeTip(status){
	if(status == 1){
		gridHtml = "<tr><td align='center'colspan='5'>暂无查询结果！</td></tr>";
		$('#table_list_1').append(gridHtml);
		$('#page_1').append("<div id='pagebar' class='pagin'></div>");
	} else {
		gridHtml = "<tr><td align='center'colspan='9'>暂无查询结果！</td></tr>";
		$('#table_list_2').append(gridHtml);
		$('#page_2').append("<div id='pagebar' class='pagin'></div>");
	}
}


function getTdHtml(obj, status){
	var gridHtml = "<tr>";
	if(status == 1){
		gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.trainScopeName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.organizationName)+"</td>";
		
		gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	} else {
		gridHtml += "<td>"+nullFormatter(obj.projectName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.planNum)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.createBy)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.createDate)+"</td>";
		gridHtml += "<td>"+auditStatusFormatter(obj.auditStatus)+"</td>";
		gridHtml += "<td>"+nullFormatter(obj.auditorRealName)+"</td>";
		gridHtml += "<td>"+optionFormatter2(obj)+"</td></tr>";
	} 
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(obj){
		if(enableOrg == "0") {
			return "<a href='###' class='tablelink' );'>功能已被禁用</a>";
		}  
		
		return 	"<a href='###' class='tablelink' onclick='assignOrg(\"" + obj.projectId + "\",\""+obj.projectName+"\",\""+obj.planNum+"\",\""+obj.organizationId+"\",\""+obj.trainScopeId+"\");'>指定承培机构</a>&nbsp;&nbsp;&nbsp;"+
				"<a href='###' class='tablelink' onclick='assignTask(\"" + obj.projectId+"\",\""+obj.planNum+"\");'>分配任务</a>";
	}
	
	function optionFormatter2(obj){
		if(enableOrg == "0") {
			return "<a href='###' class='tablelink' );'>功能已被禁用</a>";
		}  
		return 	"<a href='###' class='tablelink' onclick='assignTask(\"" + obj.projectId+"\",\""+obj.planNum+"\");'>分配任务</a>";
	}

	function auditStatusFormatter(auditStatus){
		if(auditStatus == 1){
			return '审核通过';
		} else {
			return '审核不通过';
		}
	}
}


/**
 * 清除分页div下的内容
 */
function clear(){
	$('#page_1').empty();
	$('#page_2').empty();
}


/**
 * 指定机构
 */
function assignOrg(projectId, projectName, planNum, orgId, trainScopeId){
	queryOrgByTrainScopeId(projectId, projectName, planNum, orgId, trainScopeId);
}


/**
 * 查询项目范围内同层及上级的承培机构
 */
function queryOrgByTrainScopeId(projectId, projectName, planNum, orgId, trainScopeId){
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/queryOrgByProScopeId.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			trainScopeId : trainScopeId
		},
		success:function(data){
			if(data.success) {
				$('#checkboxes').empty();
				
				var obj = data.obj;
				
				var objTest = obj;
				// 若只有一个承陪机构 则直接提交
				
				$('#projectId').val(projectId);
				if(objTest.length == 1) {
					var objA = new Object();
					objA.organizationId = objTest[0].organizationId;
					objA.organizationName = objTest[0].organizationName;
					btnOKAssignOrg(objA);
				} else { // 否则让用户自行选择
					$('#tanqi').show();
					$('#projectName').html(projectName);
					$('#planNum').html(planNum);
					
					$('#orgId').val(orgId);
				}
				
				var htm = '';
				for(var i=0; i<(data.total); i++){
					var org_id = obj[i].organizationId;
					var orgName = obj[i].organizationName;
					htm += "<input name='organization' type='checkbox' id='"+orgName+"' value='"+org_id+"'/>"+orgName+"&nbsp;";
				}
				$('#checkboxes').append(htm);
				
				$('input[name="organization"]').each(function(){
					for(var i=0; i<((orgId.length+1)/2); i++){
						var org = orgId.toString().split(',')[i];
						if(this.value == org){
							$(this).attr('checked','checked');
							$(this).attr('disabled',true);
						}
					}
				});
			} else {
				jQuery.generalAlert('查询机构失败!');
			}
		},
		error:function(){
			jQuery.generalAlert('查询机构失败!');
		}
	});
}

// 只有一个承陪机构，则直接提交 机构选择
function directAssignOrg(obj) {
	$org.length=0;
	$org.push(obj);
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/assignOrg.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			data : $.toJSON($org),
			projectId : $('#projectId').val()
		},
		success:function(data){
			if(data.success) {
				var openUrl = pathHeader + '/edupm/projectmanage/toOrgTaskingPage.htm?click=25';
				jQuery.generalAlertAndJump('指定承培机构成功!', openUrl);
			} else {
				jQuery.generalAlert('指定承培机构失败!');
			}
		},
		error:function(){
			jQuery.generalAlert('指定承培机构失败!');
		}
	});
}

/**
 * 确定指定承培机构
 */
$org = [];
function btnOKAssignOrg(objA){
	$org.length=0;
	if(objA != null) {
		$org.push(objA);
	} else {
		$('input[name="organization"]').each(function(){
			if($(this).attr('checked')) {
				var obj = new Object();
				obj.organizationId = $(this).val();
				obj.organizationName = $(this).attr('id');
				$org.push(obj);
			}
		});
	}
	$.ajax({
		url : pathHeader + '/edupm/projectmanage/assignOrg.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			data : $.toJSON($org),
			projectId : $('#projectId').val()
		},
		success:function(data){
			if(data.success) {
				//$('#tanqi').hide();
				var openUrl = pathHeader + '/edupm/projectmanage/toOrgTaskingPage.htm?click=25';
				jQuery.generalAlertAndJump('指定承培机构成功!', openUrl);
//				window.location.href = openUrl;
			}else {
				jQuery.generalAlert('指定承培机构失败11!');
			}
		},
		error:function(){
			jQuery.generalAlert('指定承培机构失败22!');
		}
	});
}


/**
 * 分配任务
 */
function assignTask(projectId, planNum){
	var openUrl = pathHeader + '/edupm/projectmanage/toAssignTaskPage.htm?click=25&projectId='+projectId+'&planNum='+planNum;
	window.location.href = openUrl;
}


