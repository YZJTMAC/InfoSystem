$(function(){
	queryAllocate(upId);
});
var total=0;
//判断edu_project_allocate_by_area 中的ID类型 t=2:区 
var t = -1;

var canClick = true;//所有的下级地区都上报后 才能点击总的上报按钮

function queryAllocate(up){
	$("#proList1").html("");
	upId = up;
	total = 0;
	var url = pathHeader + "/edupm/projectmanage/queryAllocateInfo.do";
	$.ajax({
		url:url,
		data:{areaId:up,projectId:projectId},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				t = data.type;
				var rows = data.rows;
				var num=data.num;
				var gridHtml = "";
				$.each(rows,function(index,element){
					gridHtml += getTdHtml(element,data.type,num);
				});
				$("#proList1").html(gridHtml);
			}
		},
		error:function(){
			alert("URL ERROR !");
		}
	});
	
}
	

function getTdHtml(obj,type,num){
	if(obj.allocatePlanNum != 0 && obj.allocatePlanNum != null){
	
	//else{
		if(obj.status==null || obj.status == 0){
			canClick = false;
		}
		
	//}
	total +=obj.allocatePlanNum;
	var gridHtml = "<tr>";
	if(type != 2){
		gridHtml += "<td><a href='###' class='tablelink' onclick='queryAllocate("+obj.areaId+"); setArea(this);'>"+obj.areaName+"</a></td>";
	}else{
		gridHtml += "<td>"+obj.areaName+"</td>";
	}
	gridHtml += "<td>"+(obj.allocatePlanNum==null?0:obj.allocatePlanNum)+"</td>";
	if(obj.status==1 && ((obj.allocateFactNum==null?0:obj.allocateFactNum))>0){
		gridHtml += "<td>"+(obj.allocateFactNum==null?0:"<a class='tablelink' href=\""+pathHeader + "/edupm/projectmanage/toProjectReportByAreaInfoPage.htm?click=24&projectId="+projectId+"&type="+type+"&areaId="+obj.areaId+"\">"+obj.allocateFactNum+"</a>")+"</td>";
	}else{
		gridHtml += "<td>"+(num==null?0:num)+"</td>";
	}
	gridHtml += "<td>"+((obj.status==0 || obj.status==null)?'未上报':'已上报')+"</td>";
	gridHtml += "<td>"+optionFormatter(obj,num)+"</td>";
	gridHtml +="</tr>";
	return gridHtml;
	}
	else{
		return "";
	}
	function optionFormatter(row,num){
		var status = row.status;
		var num=num;
		var returnStr = "";
		if(status == 0 || status == null){
			if(row.allocatePlanNum>0){
			returnStr += "<a href='###' class='huibtn_a' onclick='importS(this,"+projectId+");'>导 入</a>&nbsp;&nbsp;";
			returnStr += "<a href='###' class='huibtn_a' onclick='toSelectTeacher("+row.areaId+");'>选择教师</a>&nbsp;&nbsp;";
			if(num>0){
				returnStr += "<a href='###' class='huibtn_a' onclick='report(this,"+row.areaId+");'>确定上报</a>";
			}
		
			}
		}else{
			returnStr += "已上报";
		}
		return returnStr;
	}
	
}


/**
 * 上报
 * @param {Object} obj
 * @param {Object} areaId
 */
function report(obj,areaId){
	jQuery.confirmWindow("提示","是否确定上报？",function(){
		var type = 0;
		if(t==2){
			type = 1;
		}
		var url = pathHeader + "/edupm/projectmanage/toReport.do";
		$.ajax({
			url:url,
			data:{areaId:areaId,projectId:projectId,type:type},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					queryAllocate(upId);
				}else{
					jQuery.generalAlert("上级未分配名额或下级未完全完成名额上报！");
				}
			},
			error:function(){
				alert("URL ERROR !");
			}
		});
	});
}


function setArea(obj){
	$("#Report").hide();
	var num = $(obj).parent().next().html();
	$("#area").html($(obj).html());
	$("#num").html(num);
}

/**
 * 转到选择教师页面
 * @param {Object} areaId
 */
function toSelectTeacher(areaId){
	var url = pathHeader + "/edupm/projectmanage/toSelectTeacherPage.htm?click=24&areaId="+areaId+"&projectId="+projectId;
	openWindow(url);
}

function importS(obj,id){
	var url = pathHeader + "/edupm/projectmanage/toBatchSignUpPage.htm?projectId="+id+"&type=0&click=24";
	openWindow(url);
}



/**
 * 上级上报
 * @param {Object} obj
 * @param {Object} areaId
 */
function reportByUpLvId(){
	if(canClick){
		var url = pathHeader + "/edupm/projectmanage/reportByUpLvId.do";
		$.ajax({
			url:url,
			data:{areaId:upId,projectId:projectId},
			type:"post",
			async:true,
			success:function(data){
				if(data.success){
					jQuery.generalAlert("上报成功！");
					queryAllocate(upId);
				}else{
					jQuery.generalAlert("下级未完全完成名额上报！");
				}
			},
			error:function(){
				alert("URL ERROR !");
			}
		});
	}else{
		jQuery.generalAlert("下级未完全完成名额上报！");
	}
	
	
}