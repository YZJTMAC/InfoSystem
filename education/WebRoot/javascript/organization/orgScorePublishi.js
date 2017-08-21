$(function(){
		$('#tabPage0').click(function(){
			changeTab(1);
		});
		 
		$('#tabPage1').click(function(){
			changeTab(2);
		});
		
		$('#isScorePublished').val(0);
		getProjectList1();
});

/**
 * tab切换
 */
function changeTab(tab){
	if(tab == 1){
		$('#isScorePublished').val(0);
		$('#tabPage0').attr('class','selected');
		$('#tab1').show();
		$('#tabPage1').attr('class','');
		$('#tab2').hide();
		getProjectList1();
	}
	 if(tab == 2){
		 $('#isScorePublished').val(1);
		$('#tabPage0').attr('class','');
		$('#tab1').hide();
		$('#tabPage1').attr('class','selected');
		$('#tab2').show();
		getProjectList2();
	}
}

function getProjectList1(){	
	$('#target').html("");	
	var isScorePublished=$('#isScorePublished').val(); //是否已公布成绩	
	var pageIndex = $("#pageIndex").val();
	var projectName = $('#projectName1').val();
	var projectYear = $('#projectYear1').find("option:selected").val();		
	$.ajax({
		url : pathHeader + '/org/orgScorePublishListes.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : projectName,
			projectYear : projectYear,			
			isScorePublished:isScorePublished,
			pageIndex : pageIndex,
			pageSize:10
		},
		success:function(data){
			if(data.success) {
				//var objList = data.rows;
				var rows = data.rows;
				var areaId = data.areaId;
				var orgId = data.orgId;
				if(rows.length > 0){
				$('#target').html("");
				var gridHtml = "";				
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId,orgId);
				});
				$('#target').append(gridHtml);
				}
				else {
					gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";				
					$('#target').html('');
					$('#target').append(gridHtml);
				}
				pagination(data, function() {
					getProjectList1();
				});
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";				
					$('#target').html('');
					$('#target').append(gridHtml);				
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='11'>错误,暂无查询结果！</td></tr>";
			$('#target').append(gridHtml);
		}
	}); 
}

function getProjectList2(){	
	$('#target2').html("");
	var isScorePublished=$('#isScorePublished').val(); //是否已公布成绩
	var pageIndex = $("#pageIndex").val();
	var projectName = $('#projectName2').val();
	var projectYear = $('#projectYear2').find("option:selected").val();
	$.ajax({
		url : pathHeader + '/org/orgScorePublishListes.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : projectName,
			projectYear : projectYear,			
			isScorePublished:isScorePublished,
			pageIndex : pageIndex,
			pageSize:10
		},
		success:function(data){
			if(data.success) {				
				var rows = data.rows;
				var areaId = data.areaId;
				var orgId = data.orgId;
				if(rows.length > 0){
				var gridHtml = "";				
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,areaId,orgId);
				});
				$('#target2').append(gridHtml);
				}
				else{
					gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";				
					$('#target2').html("");
					$('#target2').append(gridHtml);		
				}
				pagination(data, function() {					
					getProjectList2();
				});
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='11'>暂无查询结果！</td></tr>";				
					$('#target2').html("");
					$('#target2').append(gridHtml);				
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='11'>错误,暂无查询结果！</td></tr>";
			$('#target2').append(gridHtml);
		}
	}); 
}

function getTdHtml(obj,areaId,orgId){
	var gridHtml = "<tr>";		
	//实施机构、 创建项目者所属地区和登陆者地区相同，方可查看项目信息。	
//	if (obj.createByArea == areaId || obj.organizationId == orgId) {
		gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>" + obj.projectName + "</a></td>";
//	} else {
//		gridHtml += "<td>" + obj.projectName + "</td>";
//	}
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+obj.organizationName+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.attendNum+"</td>";
	gridHtml += "<td>"+obj.shenheNum+"</td>";
	gridHtml += "<td>"+obj.weishenheNum+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
			//returnStr += 	 "<a href='###' class='tablelink' onclick='stopSign(\"" + row.projectId + "\");'>结束报名</a>&nbsp;&nbsp;&nbsp;";
			//实施机构、 创建项目者所属地区和登陆者地区相同，方可公布。
//			if (row.createByArea == areaId || row.organizationId == orgId) {
				//成绩未公布
				var isScorePublished=$('#isScorePublished').val();
				if(isScorePublished == 0){
					//returnStr += "<a href='orgScorePublishRulePage.htm?projectId="+row.projectId+"' target='_self' class='tablelink'>公布</a>&nbsp;&nbsp";
					returnStr += "<a href='###' target='_self' class='tablelink' onclick='public(\"" + row.projectId + "\",\"" + row.attendNum + "\",\"" + row.weishenheNum + "\");'>公布</a>&nbsp;&nbsp";
				}
				else{
					returnStr += "<a href='orgScorePublishedViewPage.htm?click=107&projectId="+row.projectId+"&pubRule="+row.scorePublishRule+"&lvRule="+row.scoreLevelRule+"&projectName="+row.projectName+"' class='tablelink'>查看</a>";
				}
//			}
//			else{
//				returnStr += "";
//			}
		
		return returnStr;
	}
}

function public(projectId,attendNum,weishenheNum){
	var url = pathHeader + "/org/orgScorePublishRulePage.htm?projectId="+projectId;	
	if(weishenheNum > 0){
		jQuery.generalAlert("还有 " + weishenheNum + " 学员成绩未审核，请在培训成绩审核列表中进行审核。");
		return;
	}else if(attendNum==0){
		jQuery.generalAlert("项目中没有教师报名,不能发布成绩!");
	}else{
		window.location.href=url;
	}
}

 