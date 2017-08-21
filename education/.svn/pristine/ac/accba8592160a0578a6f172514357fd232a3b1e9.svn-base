
$(function(){
	queryProList();
	
	$('#select').click(function(){
		queryProList();
	});
	$("#chk_all").click(function(){
		if(this.checked){
			$("input[name='chk_list']").attr("checked",$(this).attr("checked"));
		}
		else{
			$("input[name='chk_list']").attr("checked",false);
		}
	});
});


/*********************************************批量生成PDF项目证书**************************************************************/
var teacherIds = [];
var base_common_url = "/furtheredu/edumanage/batchPrinterCertificatePage.json";
function batchProductCertificate(){
	teacherIds.length = 0;
	var arrChk=$("input[name='chk_list']:checked");
	if(arrChk == null || arrChk == "" || arrChk.length <=0) {
		jQuery.generalAlert("请选择下载项目证书的学员！");
		return;
	}
	$(arrChk).each(function(){
		var option = $('#' + $(this).val() + '_batchOption').val();
		var auth = $("#link_"+option).val();
		
		//判断该选中学员是否可以打印证书
   		if(auth.indexOf('scorePass') != -1) {
   			teacherIds.push($(this).val());
   		}
	});
	productCertificatePDFPage(teacherIds);
}

function productCertificatePDFPage(ids,URLPara){
	if(ids.length==0){
		jQuery.generalAlert("没有合格学员证书可以打印！");
		return false;
	}
	$('#myModal').modal({show:true,backdrop: 'static', keyboard: false});
	setTimeout('hideTip()',3000); 
	var url = pathHeader + "/furtheredu/edumanage/batchPrintePDFCertificatePage.json";
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("method", "post");
	form.attr("action", url);
	var input1 = $("<input>");
	input1.attr("type", "hidden");
	input1.attr("name", "commonUrl");
	input1.attr("value", base_common_url);
	
	var input2 = $("<input>");
	input2.attr("type", "hidden");
	input2.attr("name", "projectId");
	input2.attr("value", proId);
	
	var input3 = $("<input>");
	input3.attr("type", "hidden");
	input3.attr("name", "teacherIds");
	input3.attr("value", ids);
	
	var input4 = $("<input>");
	input4.attr("type", "hidden");
	input4.attr("name", "type");
	input4.attr("value", "2");
	
	$("body").append(form);// 将表单放置在web中
	form.append(input1);
	form.append(input2);
	form.append(input3);
	form.append(input4);
	form.submit();// 表单提交
}

function hideTip(){
	$('#myModal').modal('hide');
}


function getAndSetChecked(){
	// 子选项全选中同时选中全选项, 子选项未选中全选项取消选中
	$('#chk_all').attr('checked', false);
	$("input[name='chk_list']").click(function () {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='chk_list']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='chk_list']").length){
				$('#chk_all').attr('checked', true);
			}
		} else {				
			$('#chk_all').attr('checked', false);
		} 		
		});
}


/**
 * 查询项目下有成绩的参训教师
 */
function queryProList(){
	$('#teacher_list').html('');
	
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	
	$.ajax({
		url : pathHeader + '/furtheredu/edumanage/queryTeacherByProId.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			proId : proId,
			teacherName : $('#teacherName').val(),
			pageIndex : pageIndex,
			sizePerPage : sizePerPage
		},
		success:function(data){
			if(data.success) {
				$("#proName").html(data.projectName);
				$("#counts").html(data.total);
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#teacher_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='8'>暂无查询结果！</td></tr>";
				$('#teacher_list').append(gridHtml);
			}
			
			pagination(data, function(){queryProList();});
			getAndSetChecked();
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td><input id='"+obj.teacherId+"_batchOption' name='chk_list' type='checkbox' value='"+obj.teacherId+"'></td>";
	gridHtml += "<td>"+obj.teacherName+"</td>";
	gridHtml += "<td>"+genderFormatter(obj.gender)+"</td>";
	gridHtml += "<td>"+obj.schoolName+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.teacherClassPeriod)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.auditStatus)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.teacherClassScore)+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function genderFormatter(gender){
		if(gender == 1){
			return '男';
		} else {
			return '女';
		}
	}
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatter(obj){
		var status = obj.trainStatus;
		var period = obj.teacherClassPeriod;
		var str = "";
		//是否打印学时证书
		if(obj.printXueshiCertificate == 1){
		if(period>0 && (status=='合格'||status=='良好'||status=='优秀')){
			//str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherClassPeriod+'\',\''+obj.teacherClassScore+'\',\''+obj.year+'\',\''+obj.teacherScore+'\',\''+obj.idNumber+'\',\''+obj.teacherId+'\',\''+obj.periodCertificateCode+'\',\''+obj.projectCertificateCode+'\',\'3\');">打印学时证书</a> &nbsp;&nbsp;';
			str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherId+'\',3,true);">打印学时证书</a> &nbsp;&nbsp;';
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
			//str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherClassPeriod+'\',\''+obj.teacherClassScore+'\',\''+obj.year+'\',\''+obj.teacherScore+'\',\''+obj.idNumber+'\',\''+obj.teacherId+'\',\''+obj.periodCertificateCode+'\',\''+obj.projectCertificateCode+'\',\'2\');">打印项目证书</a> &nbsp;';
			//str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.teacherName+'\',\''+obj.teacherId+'\',2,false);">打印项目证书</a> &nbsp;';
			str += '<a href="###" class="huibtn_a" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.proName+"【"+obj.teacherName+"】"+'\',\''+obj.teacherId+'\',2,true);">下载项目证书</a> &nbsp;';
			str += "<input id='link_"+obj.teacherId+"' type='hidden' value='scorePass'/>";
		} else {
			str += '学分未达标，不能打印';
			str += "<input id='link_"+obj.teacherId+"' type='hidden' value='scoreNoPass'/>";
		}
		}
		else{
			str += '&nbsp&nbsp&nbsp&nbsp未设置项目证书打印';
			str += "<input id='link_"+obj.teacherId+"' type='hidden' value='projectNoSet'/>";
		}
		
		return str;
	}
	
}


/**
 *  证书打印
 * @param {Object} proId
 * @param {Object} realName
 * @param {Object} period
 * @param {Object} score
 * @param {Object} year
 * @param {Object} teacherScore

function printerCertificate(proId, realName, period, score, year, teacherScore){
	var openUrl = pathHeader + '/furtheredu/edumanage/toPrinterCertificatePage.htm?projectId='+proId+'&name='+realName+'&period='+period+'&score='+score+'&year='+year+'&grade='+teacherScore;
	window.open(openUrl);
}
*/

/**
 *  证书打印 艹艹艹艹艹艹    只能用构造表单的方式来提交，否则会引起中文乱码                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
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
	if(checkIsSetCertificate(proId,type)){
		if(pdfPrint){
			/*证书PDF打印*/
			var url =  pathHeader + "/furtheredu/edumanage/printePDFCertificate.json?projectId="+proId+"&teacherName=" + teacherName + "&teacherId=" +teacherId+"&type=" +type+"&isShowTip=true&commonUrl="+commonUrl ;
		}else{
			/*证书在线打印*/
			var url =  pathHeader + "/furtheredu/edumanage/toPrinterCertificatePage.json?projectId="+proId+"&teacherName=" + teacherName + "&teacherId=" +teacherId+"&type=" +type+"&isShowTip=true" ;
		}
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