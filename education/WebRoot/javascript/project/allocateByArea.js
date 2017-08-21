
$(function(){
	//SysCode.createSelect("SCHOOL_TYPE", "schoolTypeId", "<option value=''>请选择</option>");
	queryXxlx();
	var upId=$("input[name='upId']").val();
	var roleId=$("input[name='roleId']").val();
	
	/*if(roleId==3){
		$("#seach").show();
	}else{
		$("#seach").hide();
	}*/
	queryAllocate(upId);
	$("#seachform").hide();
});

function returnProjList(url) {
	
	 window.location.href = url;
}

function allCheck(obj) {
	
	if($(obj).attr("checked")) {


		$("input[name='areaCheck']").each(function(){
			
			$(this).attr("checked",true);
		    //alert("total num " + allocateTotal);
			
	 });

	}else {

		$("input[name='areaCheck']").each(function(){
	
			$(this).attr("checked",null);
		    //alert("total num " + allocateTotal);
			
	    });
	
	}
	
}

//平均分配
function allocateAverage() {
	var upId=$("input[name='upId']").val();
	var projectId=$("input[name='projectId']").val();
	
	//输入的总分配数
	var toAllocate = $("#avertotal").val(); 
	//当前地区名额总数
	var localTotal = $("#num").html();
	//总剩余名额
	var left = localTotal -$("#tt").html();
	if(left <=0 ) {
		jQuery.generalAlert("没有可分配名额");
		return;
	}
	if(toAllocate>left) {
		jQuery.generalAlert("可分配名额不足，最多还可分配："+left);
		return;
	}
	
	
	var type = 0;
	if(t==2){
		type = 1;
	}
	
	//alert("total num " + allocateTotal);
	var array= new Array();//存放地区id
	 $("input[name='areaCheck']").each(function(){
		    if ($(this).attr("checked")) {
		         // alert( $(this).attr('value') );
		    	 array.push($(this).val());
		    }
		    //alert("total num " + allocateTotal);
	 });
	 
	 var allocAreaCount = array.length;
	 if(allocAreaCount == 0) {
		 jQuery.generalAlert("没有选取参与分配的地区");
		 return;
	 }
	 
	 var yushu = toAllocate%allocAreaCount;
	 if(yushu !=0) {
		 jQuery.generalAlert("不能整除,分配总数:"+ toAllocate + " 分配地区数:" +allocAreaCount);
		 return;
	 }
	 
	 //alert(array.join(','));
	 areaIds = array.join(',');
	 var aver = toAllocate/allocAreaCount;
	 var url = pathHeader + "/edupm/projectmanage/allocateAverage.do";
	 $.ajax({
			url:url,
			data:{areaIds:areaIds,planNum:aver,projectId:projectId,type:type},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					jQuery.generalAlert("分配成功！");
					queryAllocate(upId);
				}else{
					jQuery.generalAlert("上级未给本地区分配名额！");
				}
			},
			error:function(){
				jQuery.generalAlert("URL ERROR !");
			}
		});
		
}

function queryXxlx(){
	var url = pathHeader+ "/org/queryXxlx.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#schoolTypeId").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#schoolTypeId").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}


var total=0;
//判断edu_project_allocate_by_area 中的ID类型
var t = -1;
function queryAllocate(up){
	var projectId=$("input[name='projectId']").val();
	var upId=$("input[name='upId']").val();
	total = 0;
	var schoolName=$("#schoolName").val();
	var url = pathHeader + "/edupm/projectmanage/queryAllocateInfo.do";
	$.ajax({
		url:url,
		data:{areaId:up,projectId:projectId,schoolName:schoolName},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				t = data.type;
				var rows = data.rows;
				var gridHtml = "";
				$.each(rows,function(index,element){
					gridHtml += getTdHtml(element,data.type);
				});
				gridHtml +="<tr><td></td><td>合计</td><td id='tt' colspan='1'>"+total+"</td><td>&nbsp;</td></tr>";
				$("#list").html(gridHtml);
				
				//$("#avertotal").value=total;
				$("#avertotal").attr("value", $("#num").html() - total);
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR !");
		}
	});
	
}
	

function getTdHtml(obj,type){
	total +=obj.allocatePlanNum;
	var gridHtml = "<tr>";
	gridHtml += "<td>"+ "<input type='checkbox'  name='areaCheck' value="+obj.areaId+" > " +"</td>";
	if(type != 2){
		$("#seachform").hide();
		gridHtml += "<td><a href='###' class='tablelink' onclick='queryAllocate("+obj.areaId+"); setArea(this); saveOld("+obj.areaId+")'>"+obj.areaName+"</a></td>";
	}else{
		gridHtml += "<td>"+obj.areaName+"</td>";
		$("#seachform").show();
	}
	gridHtml += "<td><span name='nn'>"+(obj.allocatePlanNum==null?0:obj.allocatePlanNum)+"</span></td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml +="</tr>";
	return gridHtml;
	
	function optionFormatter(obj){
		var returnStr = "";
		if(obj.status == 0 || obj.status == null){
			returnStr += "<a href='###' class='tablelink' onclick='allocate(this,"+obj.areaId+");'>分配名额</a>";
		}else{
			returnStr += "已上报";
		}
		return returnStr;
	}
}

function allocate(obj,areaId){
	var num = $(obj).parent().prev().children().html();
	$(obj).parent().prev().html("<input type='text' class='scinput' value='"+num+"' >");
	var str = "<a href='###' class='tablelink' onclick='save(this,"+areaId+","+t+")'>保存</a> &nbsp;&nbsp;";
	str += "<a href='###' class='tablelink' onclick='history.go(0)'>取消</a> &nbsp;&nbsp;";
	$(obj).parent().html(str);

}
function cancel(obj,num){
		var str = "<a href='###' class='tablelink' onclick='allocate(this);'>分配名额</a>";
		$(obj).parent().prev().html(num);
		$(obj).parent().html(str);
}

function save(obj,areaId){
	//分配名额数量
	var upId=$("input[name='upId']").val();
	var num = $(obj).parent().prev().children().val()-0;
	var projectId=$("input[name='projectId']").val();
	if(num <0){
		jQuery.generalAlert("分配人数不能小于0");
		return;
	}
	//当前地区名额总数
	var total2 = $("#num").html();
	//合计
	//var tt = $("#tt").html();
	var tt = 0;
	$("span[name='nn']").each(function(){
		tt += $(this).html()-0;
	});
	if((tt+num) > total2){
		jQuery.generalAlert("剩余名额不足！剩余名额："+(total2-tt));
		return false;
	}
	var type = 0;
	if(t==2){
		type = 1;
	}
	var url = pathHeader + "/edupm/projectmanage/allocate.do";
	$.ajax({
		url:url,
		data:{areaId:areaId,planNum:num,projectId:projectId,type:type},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				jQuery.generalAlert("分配成功！");
				queryAllocate(upId);
			}else{
				jQuery.generalAlert("上级未给本地区分配名额！");
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR !");
		}
	});
}

function setArea(obj){
	
	var num = $(obj).parent().next().children().html();
	$("#area").html($(obj).html());
	$("#num").html(num);
}

function toBack(){
	var upId=$("input[name='upId']").val();
	var projectId=$("input[name='projectId']").val();
	total = 0;
	var url = pathHeader + "/edupm/projectmanage/queryAllocateInfo.do";
	$.ajax({
		url:url,
		data:{areaId:upId,projectId:projectId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				t = data.type;
				var rows = data.rows;
				var gridHtml = "";
				$.each(rows,function(index,element){
					gridHtml += getTdHtml(element,data.type);
				});
				gridHtml +="<tr><td>合计</td><td id='tt' colspan='1'>"+total+"</td><td>&nbsp;</td></tr>";
				$("#list").html(gridHtml);
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR !");
		}
	});
	
}
function saveOld(id){
	$("#upId").val(id);
	var old = $("input[name='old']").val();
	$("#bb").attr("href","javascript:queryAllocate("+old+")");
}

/**
 * 查询项目
 */
function qryPro(){
	var upId=$("input[name='upId']").val();
	var schoolTypeId=$('#schoolTypeId').val();
	queryAllocates(upId);

}

function queryAllocates(up){
	var projectId=$("input[name='projectId']").val();
	var upId=$("input[name='upId']").val();
	var schoolTypeId=$('#schoolTypeId').val();
	total = 0;
	var schoolName=$("#schoolName").val();
	var url = pathHeader + "/edupm/projectmanage/queryAllocateInfoes.do";
	$.ajax({
		url:url,
		data:{areaId:up,projectId:projectId,schoolName:schoolName,schoolTypeId:schoolTypeId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				t = data.type;
				var rows = data.rows;
				var gridHtml = "";
				$.each(rows,function(index,element){
					gridHtml += getTdHtmles(element,data.type);
				});
				gridHtml +="<tr><td>合计</td><td id='tt' colspan='1'>"+total+"</td><td>&nbsp;</td></tr>";
				$("#list").html(gridHtml);
			}
		},
		error:function(){
			jQuery.generalAlert("URL ERROR !");
		}
	});
	
}
	

function getTdHtmles(obj,type){
	total +=obj.allocatePlanNum;
	var gridHtml = "<tr>";
	gridHtml += "<td>"+ "<input type='checkbox' name='areaCheck' value= "+obj.areaId+" > " +"</td>";
	if(type != 2){
		$("#seachform").hide();
		gridHtml += "<td><a href='###' class='tablelink' onclick='queryAllocate("+obj.areaId+"); setArea(this); saveOld("+obj.areaId+")'>"+obj.areaName+"</a></td>";
	}else{
		gridHtml += "<td>"+obj.areaName+"</td>";
		$("#seachform").show();
	}
	gridHtml += "<td><span name='nn'>"+(obj.allocatePlanNum==null?0:obj.allocatePlanNum)+"</span></td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	gridHtml +="</tr>";
	return gridHtml;
	
	function optionFormatter(obj){
		var returnStr = "";
		if(obj.status == 0 || obj.status == null){
			returnStr += "<a href='###' class='tablelink' onclick='allocate(this,"+obj.areaId+");'>分配名额</a>";
		}else{
			returnStr += "已上报";
		}
		return returnStr;
	}
}
