$(function(){
	initSelect();
	qryChangeInfoList();
	$("#chk_all").click(function(){
     	/*$("input[name='chk_list']").attr("checked",$(this).attr("checked"));*/
		if($(this).attr('checked')){
			$("input[name='chk_list']").attr('checked', true);
		} else {
			$("input[name='chk_list']").attr('checked', false);
		}
		
	});
	
	$(".huibtn_a.audit").click(function(){
		var arrChk=$("input[name='chk_list']:checked");
		if(arrChk == null || arrChk == "" || arrChk.length <=0) {
			jQuery.generalAlert("请选择要审核的信息");
			return;
		}
  		$(".tip").fadeIn(200);
  	});
	
	$("#pageSize").change(function(){
		qryChangeInfoList();
	});
	
	/*$(".huibtn_a audit").click(function(){
		var arrChk=$("input[name='chk_list']:checked");
		if(arrChk == null || arrChk == "" || arrChk.length <=0) {
			jQuery.generalAlert("请选择要审核的信息");
			return;
		}else{
			
		}
  	});*/
	
	
	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});
	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});
	
	$(".sure").click(function() {
		$('#myModal').modal('show');
		var ids = "";
		$("input[name='chk_list']:checked").each(function(){
			ids += $(this).val() + ',';
		});
		$(".tip").fadeOut(100);
			var url = pathHeader + "/edupm/teachermanage/batchAuditRecord.do";
			$.ajax({
				url:url,
				data:{
					ids:ids.substring(0,ids.length-1),
					status:$("input[name='status']:checked").val(),
					memo:$("#memo").val()
				},
				type:"post",
				async:true,
				success:function(data){
					if(data.success){
//						var url = pathHeader + "/edupm/teachermanage/toTeacherInfoChangeAuditPage.htm?click=2";
//						openWindow(url);
						qryChangeInfoList();
						$('#myModal').modal('hide');
					}
				},
				error:function(){
					
				}
		
	});
	});
});

function initSelect(){
	$(".select3").uedSelect({
		width : 100
	});
}
function qryChangeInfoList(){
	$("#chk_all").attr('checked', false);
	$('#records').html("");
	$('#totleCount').text("");
	var url = pathHeader + "/edupm/teachermanage/qryChangeRecordList.do";
	$.ajax({
		url:url,
		data:{
		startIndex:$("#pageIndex").val(),
		pageSize:$("#pageSize").val(),
		areaId:$("#areaId").val(),
		name:$("#name").val(),
		idNo:$("#idNo").val(),
		status:$("#status").val()
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var gridHtml = "";
				var rows = data.rows;
				if(rows.length>0){
					$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
					});
					
					$('#records').append(gridHtml);
					$('#totleCount').text(data.total);
					pagination(data, function(){qryChangeInfoList();});
				}else{
					$('#records').html("<tr><td colspan='9'>无查询记录</td></tr>");
					$('#totleCount').text(0);
					pagination(data, function(){qryChangeInfoList();});
				}
			}
		},
		error:function(){
			
		}
		
		
	});
	
}


function getTdHtml(obj){
	var date =obj.applyDate!= null ? new Date(obj.applyDate).format("yyyy-MM-dd HH:mm:ss"):"";
	var ss = obj.status ==11?'<font style="color: red">未审核</font>':obj.status==13?'审核通过':obj.status==12?'审核不通过':'';
	var gridHtml = "<tr>";
	//对于审核通过或审核不通过的不允许多次审核
	if(obj.status == 13 || obj.status == 12){
		gridHtml += "<td><input type='checkbox' name='chk_list1' disabled='disabled' value='"+obj.id+"'></td>";
	}
	else{
		gridHtml += "<td><input type='checkbox' name='chk_list' value='"+obj.id+"'></td>";
	}
	//gridHtml += "<td><input type='checkbox' name='chk_list' value='"+obj.id+"'></td>";
	gridHtml += "<td>"+obj.idno+"</td>";
	gridHtml += "<td>"+obj.name+"</td>";
	gridHtml += "<td>"+obj.gender+"</td>";
	gridHtml += "<td>"+obj.address+"</td>";
	gridHtml += "<td>"+obj.applier+"</td>";
	gridHtml +="<td>"+ obj.applyDate.replace(".0","")+"</td>";
		gridHtml +="<td>"+ss+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.status == 11){
			returnStr += 	 "<a href='###' class='tablelink' onclick='audit(\"" + row.id + "\");'>审 核</a>&nbsp;&nbsp;&nbsp;";
		}
		return returnStr;
	}
}

function lastForSure(){
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1];
		var text = conditionArray[2];
		$("#areaId").val(belone);
		$("#area").val(text);
	}
	
	qryChangeInfoList();
	
	clear();
}

function audit(id){
	var url = pathHeader + "/edupm/teachermanage/viewDetail.htm?auditId="+id+ "&click=" + click;
	openWindow(url);
}

//批量删除，暂时不做
function batchDel(){
	var ids = "";
		$("input[name='chk_list']").each(function(){
			ids += $(this).val() + ',';
		});
		var url = pathHeader + "";
}