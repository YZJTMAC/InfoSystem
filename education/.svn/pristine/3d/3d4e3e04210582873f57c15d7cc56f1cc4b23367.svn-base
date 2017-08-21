$(function(){
	queryPxxsList();
	projectList();
	initEduModel();
});

function queryPxxsList(){
	var url = pathHeader+ "/org/queryPxxsList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#projectTrainType").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#projectTrainType").append(
							"<option  value=\"" + value.dictionaryId + "\">"
							+ value.dictionaryName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
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
				opts +="<option  value=''>请选择</option>";
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

function projectList(){
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = pathHeader+ "/edupm/projectmanage/queryProjectByStatus.do";
	$('#proList1').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			year:$("#year").val(),
			startIndex : pageIndex,
			pageSize:sizePerPage,
			status:'10,20,22,30,40,50',
			projectTrainType:$('#projectTrainType').val(),
			projectName:$('#projectName').val(),
			eduModelType:$('#modelId').val(),
			flag: "Y"  //此标识表示查询申报人所管理的项目
			
		},
		beforeSend: function(){
			$('#proList1').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList1').html(gridHtml);
				pagination(data, function(){projectList();});
			}else{
				$('#proList1').html("<tr><td colspan='14'>无查询记录</td></tr>");
				pagination(data, function(){projectList();});
			}
		},
		error:function(){
			$('#proList1').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});

}


function getTdHtml(obj){
	var tn = "";
	var ps = "";
	if(obj.projectScopeName!="请选择"){
		ps = obj.projectScopeName;
	}
	if(obj.trainTypeName!='请选择'){
		tn = obj.trainTypeName;
	}
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
	//gridHtml += "<td><a href='javascript:projectInfo("+obj.id+",\"" + obj.createBy +"\",\""+ obj.auditStatus+ "\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
	gridHtml += "<td>"+obj.startDate+"</td>";
	gridHtml += "<td>"+obj.endDate+"</td>";	
	gridHtml += "<td>"+ps+"</td>";
	gridHtml += "<td>"+tn+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	gridHtml += "<td>"+obj.createBy+"</td>";
	gridHtml += "<td>"+(obj.organizationName == null ? '' : obj.organizationName)+"</td>";
	gridHtml += "<td>"+obj.applyer+"</td>";
	gridHtml += "<td>"+(obj.applyDate == null ? '' : nullFormatter(obj.applyDate.replace(".0","")))+"</td>";
	gridHtml += "<td>"+obj.auditor+"</td>";
	gridHtml += "<td>"+(obj.auditDate == null ? '' : nullFormatter(obj.auditDate.replace(".0","")))+"</td>";
	gridHtml +="<td>"+obj.classPeriod+"学时"+"</td>";
	//gridHtml +="<td title='adf'><font style='color: red'>"+optionFormatter(obj)+"</font></td></tr>";
	gridHtml +=optionFormatter(obj);
	return gridHtml;
	
	
	function optionFormatter(obj){	
			
		var returnStr = "";
		if(obj.status==10){
			//returnStr = "待申报";
			returnStr = "<td title='项目创建之后，有操作权限的人员可在‘培训项目申报’&#10列表中进行申报'><font style='color: red'>待申报</font></td></tr>";
		}
		else if(obj.status==20){
			//returnStr = "已申报  -->>  待审批";
			returnStr = "<td title='项目已申报，有操作权限的人员可在‘培训项目审核’&#10列表中进行审批'><font style='color: red'>已申报  -->>  待审批</font></td></tr>";
		}
		/*else if(obj.status==21){
			//returnStr = "审批通过  -->>  待开始筹备项目";
			returnStr = "<td title='项目已审批通过，有操作权限的人员可在‘培训项目申报’&#10审批通过列表中进行项目筹备'><font style='color: red'>审批通过  -->>  待开始筹备项目</font></td></tr>";
		}*/
		else if(obj.status==22){
			//returnStr = "审批未通过  -->>  重新申报）";
			returnStr = "<td title='项目审批未通过，有操作权限的人员可在‘培训项目申报’&#10进行重新申报'><font style='color: red'>审批未通过  -->>  重新申报</font></td></tr>";
		}
		else if(obj.status==30){
			//returnStr = "项目审核通过  -->>  待启动";
			returnStr = "<td title='项目审核通过，在提交培训材料中上传培训资料供学员进行学习，进行培训名额分配、培训名额上报、教师报名审核，完成后可在培训项目启动列表中进行启动项目'><font style='color: red'>项目审核通过  -->>  待启动</font></td></tr>";
		}
		else if(obj.status==40){
			//returnStr = "项目进行中(已启动)  -->>  待公布成绩(已结束)";
			returnStr = "<td title='项目启动后，学员可以在‘项目报名’列表中加入项目，加入项目之后在项目学习列表中进行学习。'><font style='color: red'>项目进行中(已启动)  -->>  待公布成绩(已结束)</font></td></tr>";
		}
		else if(obj.status==50){
			//returnStr = "项目已结束   -->>  待关闭";
			returnStr = "<td title='成绩公布之后，就是项目已经结束，在结束之后，可以查看成绩，打印证书，提交总结，项目评价。'><font style='color: red'>项目已结束   -->>  待关闭</font></td></tr>";
		}
		else if(obj.status==60){
			//returnStr = "项目已关闭";
			returnStr = "<td title='><font style='color: red'>项目已关闭</font></td></tr>";
		}
		return returnStr;
	}
}