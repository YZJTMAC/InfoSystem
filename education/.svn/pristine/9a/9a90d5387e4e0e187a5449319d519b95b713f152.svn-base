	var ex={}; //全局变量,存学时学分转换规则
$(function(){
	$('.cancel').click(function(){
		$('.tip').fadeOut(100);
	});
	

	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});
	showInfoList();
	showInfoList2();
	/*initEduModel();
	initEduModeles();*/
	
	
	$('#tabPage0').click(function(){
		$('#isScorePublished').val(1); //培训类
	
		showInfoList();
	});
	
	$('#tabPage1').click(function(){
		$('#isScorePublished').val(2); //非培训类项目和校本项目
		
		showInfoList2();
	});
	

	$("#select").click(function() {
		/*var queryType = 	$('#isScorePublished').val();
		alert(queryType);*/
		/*var eduModeType=jQuery("#modelType").val();*/
		/*var queryType = 	$('#isScorePublished').val();
		alert(queryType);
		if(queryType ==="1"){
			showInfoList(); //根据查询条件查出列表培训类
		}else if(queryType ==="2"){
			showInfoList2(); //根据查询条件查出列表  非培训类项目和校本项目
		}*/
		showInfoList();
	});
	
	
	$("#select2").click(function() {
		showInfoList3();
	});
});
  
function gotoAudit(projectId, exchangeRule, projectName, exchangeRule, excellentRule){
//	alert(exchangeRule == "");
//	alert(excellentRule);
//	var unit = ex[modelId];
	if(exchangeRule == "" || excellentRule == ""){
		jQuery.generalAlert("未设置学分兑换规则，请在【继教信息】->【学分兑换规则】中为该项目进行配置");
	}else{
		this.location="creditAuditTrainPage.htm?click=9&projectId="+projectId+"&projectName="+projectName+"&exchangeRule="+exchangeRule;
	}
}

/*function initEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
				if(data.success){
					var rows = data.rows;
				var opts = "";
				    opts+="<option value=''>请选择 </option>"
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
					ex[obj.id]=obj.unit;
				}
				$("select[name='modelId']").html(opts);
				}
		},
		error:function(){
			alert("初始化继教信息模块失败！");
		}
		
	});
}
function initEduModeles(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				var opts = "";
				opts+="<option value=''>请选择 </option>"
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
					ex[obj.id]=obj.unit;
				}
				$("select[name='modelIdes']").html(opts);
			}
		},
		error:function(){
			alert("初始化继教信息模块失败！");
		}
		
	});
}*/

function showInfoList(){
	$('#target').html('');
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/org/orgScorePublishList.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			isScorePublished:1,
			projectName : $('#projectName').val(),
			eduModeType: $("#modelType").val(),
			projectYear: $('#queryYear').val(),
			pageIndex : pageIndex,
			pageSize: sizePerPage
		},
		success:function(data){
			if(data.success) {
				var rows = data.rows;
				if(rows.length > 0){
					$('#target').html("");
					var gridHtml = "";				
					$.each(rows, function(index,element) {
						gridHtml += getTdHtml(element);
					});
					$('#target').append(gridHtml);
					
					jQuery('#page_2').children("div").attr("id","newId");
					$('#page_1').html("<div id='pagebar' class='pagin'></div>");
				}
				else {
					gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";				
					$('#target').html('');
					$('#target').append(gridHtml);
				}
				pagination(data, function() {
					showInfoList();
				});
				 
			
				 
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#target').html('');
				$('#target').append(gridHtml);
				$('#page_1').html('');
				
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>错误,暂无查询结果！</td></tr>";
			$('#target').html('');
			$('#target').append(gridHtml);
			$('#page_1').html('');
		}
	}); 
}

function showInfoList2(){
	$('#target2').html('');
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/furtheredu/certificate/queryNotrainList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		queryYear:$('#queryYear').val(),
		/*modelId:$('#modelType').val(),*/
		 
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				/*var users ={"projects":objList};
				formatTemplate2(users) ;
				jQuery('#page_1').children("div").attr("id","newId");
				$('#page_2').html("<div id='pagebar' class='pagin'></div>");*/
				var rows = data.rows;
				if(rows.length > 0){
				$('#target2').html("");
				var gridHtml = "";				
				$.each(rows, function(index,element) {
					gridHtml += getTdHtmle(element);
				});
				$('#target2').append(gridHtml);
				jQuery('#page_1').children("div").attr("id","newId");
				$('#page_2').html("<div id='pagebar' class='pagin'></div>");
				}
				else {
					gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";				
					$('#target2').html('');
					$('#target2').append(gridHtml);
				}
				
				pagination(data, function(){showInfoList2(); });
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#target2').html('');
				$('#target2').append(gridHtml);
				$('#page_2').html('');
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
			$('#target2').html('');
			$('#target2').append(gridHtml);
			$('#page_2').html('');
		}
	});
}
function showInfoList3(){
	$('#target2').html('');
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/furtheredu/certificate/queryNotrainList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			queryYear:$('#queryYear').val(),
			modelId:$('#modelTypes').val(),
			
			sizePerPage:sizePerPage, 
			pageIndex:pageIndex},
			success:function(data){
				if(data.success) {
					/*var objList = data.rows;
					var users ={"projects":objList};
					formatTemplate2(users) ;
					jQuery('#page_1').children("div").attr("id","newId");
					$('#page_2').html("<div id='pagebar' class='pagin'></div>");*/
					
					var rows = data.rows;
					if(rows.length > 0){
					$('#target2').html("");
					var gridHtml = "";				
					$.each(rows, function(index,element) {
						gridHtml += getTdHtmle(element);
					});
					$('#target2').append(gridHtml);
					}
					else {
						gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";				
						$('#target2').html('');
						$('#target2').append(gridHtml);
					}
					
					pagination(data, function(){showInfoList3(); });
				} else {
					gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
					$('#target2').html('');
					$('#target2').append(gridHtml);
					$('#page_2').html('');
				}
			},
			error:function(){
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#target2').html('');
				$('#target2').append(gridHtml);
				$('#page_2').html('');
			}
	});
}



function getTdHtml(obj){
	var gridHtml = "<tr>";	
	gridHtml += "<td>" + obj.projectName + "</td>";
	gridHtml += "<td>" + obj.projectPropertyName + "</td>";
	gridHtml += "<td>"+obj.trainTypeName+"</td>";
	gridHtml += "<td>"+obj.classPeriod+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(obj){
		var areaId= $("input[name='areaId']").val();
		var returnStr = "";
//			if (obj.createByArea == areaId  ) {
				returnStr +=  "<a href='###' class='tablelink' onclick='popup(\"" + obj.id + "\",\"" + obj.exchangeRule + "\",\"" + obj.excellentRule + "\",\""+ obj.eduModelName + "\",\""+ obj.exchangeWay + "\");'>查看学分规则</a>&nbsp;&nbsp;&nbsp; <a href='###' class='tablelink' onclick='gotoAudit(\"" + obj.id + "\",\"" + obj.exchangeRule + "\",\"" + obj.projectName + "\",\"" + obj.exchangeRule + "\",\"" + obj.excellentRule + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";	
//			}
//			else{
//				returnStr += "";
//			}
		return returnStr;
	}
}

function popup(projectId, exchangeRule, excellentRule, modelName, exchangeWay){
//	var unit = ex[modelId];
	if(exchangeWay == 1){
		$("#punit").html("全员兑换规则:1学时=" + exchangeRule +"学分");
		$("#excellentunit").html("优秀学员兑换规则:1学时=" + excellentRule +"学分");
	}else{
		$("#punit").html("全员兑换规则:1学分=" + exchangeRule +"学时");
		$("#excellentunit").html("优秀学员兑换规则:1学分=" + excellentRule +"学时");
	}

	$('#modelname').html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>  继教信息板块:"+modelName+"</b>");
	$(".tip").fadeIn(200);
}

function getTdHtmle(obj){
	var gridHtml = "<tr>";	
	gridHtml += "<td>" + obj.name + "</td>";
	gridHtml += "<td>" + obj.organizer + "</td>";
	gridHtml += "<td>"+obj.scopeName+"</td>";
	gridHtml += "<td>"+obj.credit+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	return gridHtml;
	
	function optionFormatter(obj){
		var areaId= $("input[name='areaId']").val();
		var returnStr = "";
			if (obj.createByArea == areaId  ) {
				returnStr += 	 "<a href='creditAuditNoTrainPage.htm?click=9&projectId="+obj.id+"&projectName="+obj.name+"' class='tablelink' >审 核</a>&nbsp;&nbsp;&nbsp;";	
			}
			else{
				returnStr += "";
			}
		
		return returnStr;
	}
}