var aId = 0;
$(function(){	
	queryEduModel();
	initSelect("projectScope");
	lastForSure();
	showPojectStatisticsList();	
	
	$('#tabPage0').click(function(){
		$("#pagebar").show();
		$("#selectAreaId").show();
		$("#pageIndex").val("1");
			//当切换tab时，还原初始化地区
			lastSelect = initArea;
			lastForSure();			
			initSelect("projectScope");
			showPojectStatisticsList();	
			
	});
	// 条件查询
	$("#select").click(function() {
		showPojectStatisticsList();
	});

	$('#tabPage1').click(function(){
		$("#pageIndex").val("1");
		$("#pagebar").show();
		$("#selectAreaId").show();
		//当切换tab时，还原初始化地区
		lastSelect = initArea;
		lastForSure();		
		initEduModel();
		initSelect("modelProjectScope");
		showModelStatisticsList();
			$("#modelSelect").click(function() {
				showModelStatisticsList();
			});		
	});	
	$('#tabPage2').click(function(){
		$("#pagebar").hide();
		$("#selectAreaId").hide();
		//当切换tab时，还原初始化地区
		lastSelect = initArea;
		initSelect("areaProjectScope");	
		lastForSure();	
		aId = $("#areaId").val();
		showAreaStatisticsList(aId);
		$('#areaSelect').click(function() {
			showAreaStatisticsList(aId);
		});
	});
});

/**
 * 初始化选择菜单
 */
//继教信息板块
function queryEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				var opts = "";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
				}
				$("#eduModelType").append(opts);
			}
		},
		error:function(){
			jQuery.generalAlert("初始化继教信息模块失败！");
		}
	});
}


function initSelect(id){
	//项目范围
	var projectScope = SysCode.getJsonArray("PROJECT_DIM_PROJECT_SCOPE","");
	createCommonOpt(projectScope,id);
}

/**
 * 创建select选项
 * @param {Object} rows
 * @param {Object} sid
 */
function createCommonOpt(rows,sid){
	$("#"+sid).html("");
	var opt="<option value=''>--请选择--</option>";
	for(var i=0; i<rows.length; i++){
		opt+="<option value='"+rows[i].id+"' >"+rows[i].text+"</option>";
	}
	$("#"+sid).append(opt);
}

/**
 * 最后确认, 个人开发 自己实现
 */
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$('#areaId').val(belone);
		$('#areaType').val(areaA);
		$('#areaName').val(text);
	}	
	$(".tip11").fadeOut(200);
}

function showPojectStatisticsList(){
	$('#project_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/sys/queryProjectStatistics.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			status:$('#status').val(),
			year : $('#year').find("option:selected").val(),
			eduModelType : $('#eduModelType').find("option:selected").val(),
			projectScope : $('#projectScope').find("option:selected").val(),
			areaId:$('#areaId').val(),
			pageIndex : pageIndex
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#project_list').html(gridHtml);				
			} else {
				gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
				$('#project_list').html(gridHtml);
			}
			pagination(data, function(){showPojectStatisticsList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
			$('#project_list').html(gridHtml);
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.projectName+"</td>";
	gridHtml += "<td>"+obj.projectClassPeriod+"</td>";
	gridHtml += "<td>"+obj.year+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.actualNum+"</td>";
	gridHtml += "<td>"+obj.yesScoreNum+"</td>";
	gridHtml += "<td>"+obj.noScoreNum+"</td>";
	gridHtml += "<td>"+obj.waitScoreNum+"</td>";
	if(parseInt(obj.actualNum)>0){		
		gridHtml += "<td>"+((obj.percentOfPass)*100)+"%</td>";
	}else{
		gridHtml += "<td>0%</td>";
	}
	return gridHtml;
}

function showModelStatisticsList() {
	$('#model_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/sys/queryModelStatistics.do',	
		type:"post",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			modelId:$('#modelId').find('option:selected').val(),
			modelProjectScope:$('#modelProjectScope').find('option:selected').val(),
			modelYear:$('#modelYear').find('option:selected').val(),
			areaId:$('#areaId').val(),
			pageIndex : pageIndex			
		},
		success:function(data){
			if(data.success){
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList,function(index,element){
					gridHtml += getModelTdHtml(element);
				});
				$('#model_list').html(gridHtml);
			}
			else{
				gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
				$('#model_list').html(gridHtml);
			}
			pagination(data, function(){showModelStatisticsList();});
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
			$('#model_list').html(gridHtml);
		}
	});	
}

function getModelTdHtml(obj){
	
	gridHtml = "<tr>";
	gridHtml += "<td>"+obj.modelName+"</td>"
	gridHtml += "<td>"+obj.actualNum+"</td>";
	gridHtml += "<td>"+obj.yesScoreNum+"</td>";
	gridHtml += "<td>"+obj.noScoreNum+"</td>";
	gridHtml += "<td>"+obj.waitScoreNum+"</td>";
	if(parseInt(obj.actualNum)>0){		
		gridHtml += "<td>"+((obj.percentOfPass)*100)+"%</td>";
	}else{
		gridHtml += "<td>0%</td>";
	}
	return gridHtml;
}

 function showAreaStatisticsList(areaId){
	 aId = areaId;
	 $("#area_list").html('');
	 $.ajax({
		 url:pathHeader + '/sys/queryAreaStatistics.do',
		 type:"post",
		 cache:"false",
		 async:true,
		 dataType:"json",
		 data:{
			areaId:areaId, 
			areaYear :$('#areaYear').find('option:selected').val(),
			areaProjectScope:$('#areaProjectScope').find('option:selected').val()
		 },
		 beforeSend: function(){
				$('#area_list').html("<tr><td align='center' colspan='9'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		 success:function(data){
			 if(data.success){
				 var objList = data.rows;
				 var gridHtml = "";
				 $.each(objList,function(index,element){
					 gridHtml += getAreaTdHtml(element,index + 1);
				 });
				 $("#area_list").html(gridHtml);
			 }
			 else{
				 gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
				 $('#area_list').html(gridHtml);
			 }
		 },
		 error:function(){
			 gridHtml = "<tr><td align='center' colspan='9'>暂无查询结果！</td></tr>";
				$('#area_list').html(gridHtml);
		 }		
	 });
 }
 
 function getAreaTdHtml(obj,index) {
	 gridHtml = "<tr>";
		gridHtml += "<td><a href='#' onclick='showAreaStatisticsList("+ obj.areaId +");' class='tablelink'>"+obj.areaName+"</a></td>"
		gridHtml += "<td>"+index+"</td>"
		gridHtml += "<td>"+(obj.actualNum!=null?obj.actualNum:0)+"</td>";
		gridHtml += "<td>"+(obj.yesScoreNum!=null?obj.yesScoreNum:0)+"</td>";
		gridHtml += "<td>"+(obj.noScoreNum!=null?obj.noScoreNum:0)+"</td>";
		gridHtml += "<td>"+(obj.waitScoreNum!=null?obj.waitScoreNum:0)+"</td>";
		if(parseInt(obj.actualNum)>0){	
			gridHtml += "<td>"+((obj.percentOfPass)*100 + "").substring(0,5)+"%</td>";
		}else{
			gridHtml += "<td>0%</td>";
		}
		return gridHtml;
}

function initEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
				if(data.success){
					var rows = data.rows;
				var opts = "";
				opts +="<option value=''>--请选择--";
				opts+="</option>";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
				}
				$("select[name='modelId']").html(opts);
				}
		},
		error:function(){
			alert("初始化继教信息模块失败！");
		}
		
	});

}

//返回按钮
function returnArea() {
	$("#tabPage2").click();
}
