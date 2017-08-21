$(function(){
	queryModel();
});

function queryModel(){
	var url = pathHeader + "/edupm/projectmanage/queryModelForSet.do";
	$.ajax({
		url:url,
		data:{
			startIndex:$("#pageIndex").val(),
			pageSize:$("#sizePerPage").val(),
			modelName:$("#modelName").val()
		},
		async:true,
		type:"POST",
		success:function(data){
			$("#modelList").html("");
			if(data.success){
				var rows = data.rows;
				if(rows.length >0){
					var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#modelList').html(gridHtml);
				}else{
					$('#modelList').html("<tr><td colspan='7'>无查询记录！</td></tr>");
				}
				pagination(data, function(){queryModel();});
				
			}else{
				$('#modelList').html("<tr><td colspan='7'>无查询记录！</td></tr>");
				jQuery.generalAlert("查询错误！");
			}
		},
		error:function(){
			$('#modelList').html("<tr><td colspan='7'>无查询记录！</td></tr>");
			jQuery.generalAlert("查询错误！");
		}
	});
}

function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.modelName+"</a></td>";
	gridHtml += "<td>"+getYear(obj)+"</td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";
	gridHtml += "<td><span id='a"+obj.id+"'>"+obj.trainScore+"</span></td>";
	gridHtml +="<td>1学分="+ obj.exchangeRole +"学时</td>";
	gridHtml +="<td>1学分="+ obj.excellentRule +"学时</td>";
	
	gridHtml +="<td><a href=javascript:toSetRole("+ obj.id +"," +
						"'"+ obj.exchangeRole +"'," +
						"'"+ obj.excellentRule +"')>设置兑换规则</a></td></tr>";
	
	return gridHtml;
}

function getYear(obj){
	var val = new Date(obj.endDate).format("yyyy")-new Date(obj.startDate).format("yyyy");
	var result = "";
	if(val==0){
		 result = "1年";
	}else{
		result = val+"年";
	}
	return result;
}

function showExchangeRule(ruleType){
	$("#msg").html("");
	if(ruleType==1){
		$("#excellentRule").hide();
		$("#commonRule").show();
		
	}else{
		$("#commonRule").hide();
		$("#excellentRule").show();
	}
}


var rowId;
function toSetRole(id,commonPeriod,excellentPeriod){
	$("#commonPeriod").val(commonPeriod);
	$("#excellentPeriod").val(excellentPeriod);
	
	var num = $("#a"+id).html();
	$("#tss").html("计划学分："+num);
	rowId = id;
	$(".tip").show();
}

function hideMe(){
	$(".tip").hide();
}

function setRole(){
	var rule = $("input[type='radio']:checked").val();
	if(rule==1){//一般规则
		var commonPeriod = $("#commonPeriod").val();
		if(!(/^\d+(\.\d+)?$/).test(commonPeriod)){
			$("#msg").html("学时不能为空且必须为数字");
			return ;
		}
		
	}else{//优秀学员规则
		var excellentPeriod = $("#excellentPeriod").val();
		if(!(/^\d+(\.\d+)?$/).test(excellentPeriod)){
			$("#msg").html("学时不能为空且必须为数字");
			return ;
		}
	}
	
	hideMe();
	$('#myModal').modal('show');
	
	setTimeout(function() {
		var url = pathHeader + "/edupm/projectmanage/setExchangeRole.do";
		$.ajax({
			url:url,
			data:{
				id: rowId,
				rule: rule,
				commonPeriod: $("#commonPeriod").val(),
				excellentPeriod: $("#excellentPeriod").val()
			},
			async:true,
			type:"post",
			success:function(data){
				if(data){
					$(".period").val("");
					queryModel();
				}
				$('#myModal').modal('hide');
			},
			error:function(){
				jQuery.generalAlert("设置失败！");
			}
		});
	}, 500);
}
