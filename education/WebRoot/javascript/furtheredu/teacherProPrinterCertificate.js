$(function(){
	queryTeacherPro();
	$('#select').click(function(){
		queryTeacherPro();
	});
});

function queryTeacherPro(){
	$('#teacher_pro_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/furtheredu/edumanage/queryTeacherProByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			projectName : $('#projectName').val(),
			year : $('#yearpicker').find("option:selected").val(),
			trainType : $('#trainType').find("option:selected").val()
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#teacher_pro_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='7'>暂无查询结果！</td></tr>";
				$('#teacher_pro_list').append(gridHtml);
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.proName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.trainTypeName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.projectPropertyName)+"</td>";
	/*gridHtml += "<td>"+statusFormatter(obj.trainStatus)+"</td>";*/
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function statusFormatter(obj){
		if(obj =='合格'){
			return '已达标';
		} else if(obj == '不合格'){
			return '<i>未达标</i>';
		}
	}
	
	
	function optionFormatter(obj){
//		return '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherClassPeriod+'\',\''+obj.teacherClassScore+'\',\''+obj.year+'\',\''+obj.teacherScore+'\');">打印项目证书</a>';
		
		var status = obj.trainStatus;
		var period = obj.teacherClassPeriod;
		var str = '';
		//是否打印学时证书
		if(obj.printXueshiCertificate == 1){
			if(period>0 && status=='合格'){
				str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherId+'\',\'3\');">打印学时证书</a> &nbsp;&nbsp;';
			}
			else {
				str += '学时未达标，不能打印&nbsp;&nbsp;&nbsp;&nbsp;';
			}
		}
		else{
			str += '未设置学时证书打印&nbsp&nbsp&nbsp&nbsp';
		}
		
		//是否打印项目证书
		if(obj.printProjectCertificate == 1){
			if(obj.auditStatus == '合格'){
				str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherId+'\',\'2\');">下载项目证书</a> &nbsp;';
			} else {
				str += '学分未达标，不能打印';
			}
		}
		else{
			str += '&nbsp&nbsp&nbsp&nbsp未设置项目证书打印';
		}
		
		return str;
	}
	
}

//下载打印操作说明书
function printerReport(){
	
	var filePathName="template/printerReport.doc";
	// 下载能使用jquery的ajax，因为ajax的返回值不支持流
	var url = pathHeader + '/fileupload/downloadFiles.do';
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("method", "post");
	form.attr("action", url);
	var input = $("<input>");
	input.attr("type", "hidden");
	input.attr("name", "filePathName");
	input.attr("value", filePathName);
	$("body").append(form);// 将表单放置在web中
	form.append(input);
	form.submit();// 表单提交
}


/**
 *  证书打印 艹艹艹艹艹艹                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
 * @param {Object} proId
 * @param {Object} realName
 * @param {Object} period
 * @param {Object} score
 * @param {Object} year
 * @param {Object} teacherScore
 * @param {Object} idNumber
 * @param {Object} type
 */
var commonUrl="/furtheredu/edumanage/toPrinterCertificatePage.json";
function printerCertificate(proId,teacherName,teacherId,type,pdfPrint){
		if(checkIsForcePaper(proId,type)){
			jQuery.generalAlert("有必须回答的调查问卷还没有提交，请先在-->培训项目-->项目调查,列表中进行回答提交，方可进行打印.");
			return;
		}
		
		if(checkIsSetCertificate(proId,type)){
			/*var url =  pathHeader + '/furtheredu/edumanage/toPrinterCertificatePage.htm?projectId=';
			var form= $("<form>");//定义一个form表单
			form.attr("style","display:none");
			form.attr("method","post");
			form.attr("action",url);
			var input1=$("<input>");
			input1.attr("type","hidden");
			input1.attr("name","projectId");
			input1.attr("value",proId);
			var input2=$("<input>");
			input2.attr("type","hidden");
			input2.attr("name","name");
			input2.attr("value",realName);
			var input3=$("<input>");
			input3.attr("type","hidden");
			input3.attr("name","period");
			input3.attr("value",period);
			var input4=$("<input>");
			input4.attr("type","hidden");
			input4.attr("name","score");
			input4.attr("value",score);
			var input5=$("<input>");
			input5.attr("type","hidden");
			input5.attr("name","year");
			input5.attr("value",year);
			var input6=$("<input>");
			input6.attr("type","hidden");
			input6.attr("name","grade");
			input6.attr("value",teacherScore);
			var input7=$("<input>");
			input7.attr("type","hidden");
			input7.attr("name","idNumber");
			input7.attr("value",idNumber);
			var input8=$("<input>");
			input8.attr("type","hidden");
			input8.attr("name","type");
			input8.attr("value",type);
			var input9=$("<input>");
			input9.attr("type","hidden");
			input9.attr("name","teacherId");
			input9.attr("value",teacherId);
			var input10=$("<input>");
			input10.attr("type","hidden");
			input10.attr("name","periodCertificateCode");
			input10.attr("value",periodCertificateCode);
			var input11=$("<input>");
			input11.attr("type","hidden");
			input11.attr("name","projectCertificateCode");
			input11.attr("value",projectCertificateCode);
			form.append(input1);
			form.append(input2);
			form.append(input3);
			form.append(input4);
			form.append(input5);
			form.append(input6);
			form.append(input7);
			form.append(input8);
			form.append(input9);
			form.append(input10);
			form.append(input11);
			$("body").append(form);//将表单放置在web中
			
			form.submit();//表单提交*/
			/*证书PDF打印*/
			var url =  pathHeader + "/furtheredu/edumanage/printePDFCertificate.json?projectId="+proId+"&teacherName=" + teacherName + "&teacherId=" +teacherId+"&type=" +type+"&isShowTip=true&commonUrl="+commonUrl ;
			/*证书在线打印*/
			//var url =  pathHeader + "/furtheredu/edumanage/toPrinterCertificatePage.json?projectId="+proId+"&teacherName=" + teacherName + "&teacherId=" +teacherId+"&type=" +type+"&isShowTip=true" ;
			window.open(url,"_blank");		
		}else{
			if(type == '1'){
				jQuery.generalAlert("该项目还没有设置年度证书");
			}else if(type == '2'){
				jQuery.generalAlert("该项目还没有设置项目证书");
			}else if(type == '3'){
				jQuery.generalAlert("该项目还没有设置学时证书");
			}
			
		}
}
//先查询是否已经设置了设置了强制项目调查问卷
function  checkIsForcePaper(projectId,type){
	var isForce = false;
	var url = pathHeader+ "/teacher/teacherProject/checkIsForcePaper.do";
		$.ajax( {
					type : "POST",
					url : url,
					data : {
						projectId : projectId,
						type : type
					},
					async : false,
					success : function(data) {
						if(data.success){
							isForce = true;
						}
					},
					error : function() {
					}
				});
		
		return isForce;
}
//先查询是否已经设置了项目证书
function  checkIsSetCertificate(projectId,type){
	var isSet = false;
	var url = pathHeader
	+ "/furtheredu/certificate/queryCertificate.do";
		$.ajax( {
					type : "POST",
					url : url,
					data : {
						projectId : projectId,
						type : type
					},
					async : false,
					success : function(data) {
						if(data.success){
							isSet = true;
						}
					},
					error : function() {
					}
				});
		
		return isSet;
}