$(document).ready(function(e) {
	initEduModel();
	 initAutoComplete();
	
	$('#tabPage0').click(function(){
		$('#isScorePublished').val(1); //校本项目
	});
	
	$('#tabPage1').click(function(){
		$('#isScorePublished').val(2); //非培训类项目
	});
	
	 
	$("#select").click(function() {
		var queryType = 	$('#isScorePublished').val();
		var model=$('#modelType').val();
		 
		if(queryType ==="1"){
			showInfoList(); //根据查询条件查出列表
		}else if(queryType ==="2"){
			showInfoList2(); //根据查询条件查出列表
		}
	});
});


/**
 * 初始化
 */
function initAutoComplete(){
	$('#isScorePublished').val(1); //校本项目
	showInfoList();
	$('#isScorePublished').val(2); //校本项目
	showInfoList2();
	$('#isScorePublished').val(1); //校本项目
}



function showInfoList2(){
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
		modelId:$('#modelType').val(),
		typeId:1,
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				var myJsonString = JSON.stringify(objList);
				var str = '{"projects":'+myJsonString +'}';
				formatProject2(str) ;
				jQuery('#page_1').children("div").attr("id","newId");
				$('#page_2').html("<div id='pagebar' class='pagin'></div>");
				pagination(data, function(){showInfoList2(); });
			} else {
				gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
				$('#target2').html(gridHtml);
				$('#page_2').html('');
				
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='6'>暂无查询结果！</td></tr>";
			$('#target2').html(gridHtml);
			$('#page_2').html('');
		}
	});

}

function showInfoList() {
	$("#target").html("");
	var isScorePublished=$('#isScorePublished').val(); //是否已公布成绩
//	alert(isScorePublished);
	var sizePerPage =20;// $("#sizePerPage").val();
	var pageIndex = 1;//$("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/furtheredu/certificate/queryNotrainList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectName : $('#projectName').val(),
		queryYear:$('#queryYear').val(),
		modelId:$('#modelType').val(),
		typeId:2,
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				//var indexFlag = data.startIndex ;
				var objList = data.rows;
				var areaId = data.areaId;
				var gridHtml = "";
				$.each(objList,function(index,element){
					gridHtml += getTdHtml(element,areaId);
				});
				$("#target").append(gridHtml);
				/*var myJsonString = JSON.stringify(objList);
				var str = '{"projects":'+myJsonString +'}';
					formatProject(str) ;*/
				jQuery('#page_2').children("div").attr("id","newId");
				$('#page_1').html("<div id='pagebar' class='pagin'></div>");
					
				pagination(data, function(){showInfoList(); });
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#target').html(gridHtml);
				$('#page_1').html('');
				
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
			$('#target').html(gridHtml);
			$('#page_1').html('');
		}
	});
}

function formatProject(projectList) {
//	alert(projectList);
	  var template = $('#template').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  
	  var obj = eval('(' + projectList + ')');
	  var rendered = Mustache.render(template,obj);
	  $('#target').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
	}
function formatProject2(projectList) {
	  var template = $('#template2').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  
	  var obj = eval('(' + projectList + ')');
	  var rendered = Mustache.render(template,obj);
	  $('#target2').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
	}

function formatModels(projectList) {
	 $('#modelType').empty();
	  var template = $('#template3').html();
	  Mustache.parse(template);   // optional, speeds up future uses
	  var rendered = Mustache.render(template,projectList);
	  $('#modelType').html(rendered);
	  $('.tablelist tbody tr:odd').addClass('odd');
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
					var opts = "<option value='0' selected>请选择</option>";
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

function getTdHtml(rows,areaId){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+rows.name+"</td>";
	gridHtml += "<td>"+rows.organizer+"</td>";
	gridHtml += "<td>"+rows.beginDate+"</td>";
	gridHtml += "<td>"+rows.endDate+"</td>";
	gridHtml += "<td>"+rows.scopeName+"</td>";
	gridHtml += "<td>"+rows.credit+"</td>";
	//创建项目者所属区域和登陆者区域相同，方可操作
	if(rows.createByArea==areaId){
		gridHtml += "<td><a href='creditEnterNoTrainPage.htm?projectId=" +rows.id+"&projectName="+rows.name+"&scope="+rows.scopeId+"&click=8' class='tablelink'>登记</a></td>";
	}
	else{
		gridHtml += "<td></td>";
	}	
	return gridHtml;
}

 