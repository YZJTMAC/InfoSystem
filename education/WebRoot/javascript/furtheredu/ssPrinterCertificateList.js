$(function(){
	queryProList();
	
	initSelect();
	
	$('#select').click(function(){
		queryProList();
	});
});


/**
 * 初始化选择菜单
 */
function initSelect(){
	//项目培训方式
	var projectTrainType = SysCode.getJsonArray("PROJECT_DIM_PROJECT_TRAIN_TYPE","");
	createCommonOpt(projectTrainType,"projectTrainType");
	
	//项目性质
	var projectProperty = SysCode.getJsonArray("PROJECT_DIM_PROJECT_PROPERTY","");
	createCommonOpt(projectProperty,"projectProperty");
	
	//项目范围
	var projectScope = SysCode.getJsonArray("PROJECT_DIM_PROJECT_SCOPE","");
	createCommonOpt(projectScope,"projectScope");
}


/**
 * 创建select选项
 * @param {Object} rows
 * @param {Object} sid
 */
function createCommonOpt(rows,sid){
	var opt = "<option value=''>请选择</option>";
	for(var i = 0;i<rows.length;i++){
		opt += "<option value='"+rows[i].id+"' ";
		opt += ">"+rows[i].text+"</option>";
	}
		$("#"+sid).append(opt);
}


/**
 * 实施/管理查询已关闭或已结束的项目
 */
function queryProList(){
	$('#ss_pro_list').html('');
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + '/furtheredu/edumanage/queryProByStatus.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			startIndex : pageIndex,
			projectName : $('#projectName').val(),
			print: $('#print').val(),
			year : $('#yearpicker').find("option:selected").val(),
			trainType : $('#projectTrainType').find("option:selected").val(),
			projectProperty : $('#projectProperty').find("option:selected").val(),
			projectScope : $('#projectScope').find("option:selected").val()
		},
		success:function(data){
			var userAreaId = data.userAreaId;
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element,userAreaId);
				});
				$('#ss_pro_list').append(gridHtml);
			} else {
				gridHtml = "<tr><td align='center'colspan='5'>暂无查询结果！</td></tr>";
				$('#ss_pro_list').append(gridHtml);
			}
			pagination(data, function(){queryProList();});
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}

//项目证书设置和项目证书打印公用一个查询列表页面
function getTdHtml(obj,userAreaId){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+nullFormatter(obj.proName)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.startDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.endDate)+"</td>";
	gridHtml += "<td>"+nullFormatter(obj.trainScopeName)+"</td>";
	//gridHtml += "<td>"+nullFormatter(obj.organizer)+"</td>";
	if($('#print').val() == 1) {
		gridHtml += "<td>"+optionFormatter(obj,userAreaId)+"</td></tr>";
 	} else {
 		gridHtml += "<td>"+optionFormatterB(obj,userAreaId)+"</td></tr>";
 	}
	
	return gridHtml;
	
	function nullFormatter(obj){
		if(obj==null || obj=='null' || obj.length==0){
			return '';
		} else {
			return obj;
		}
	}
	
	function optionFormatterB(obj,userAreaId){
		var ret ="";
//		if(obj.createByArea==userAreaId) {
			
			if(obj.printXueshiCertificate == 1) {
				
				ret += '<a href="###" class="tablelink" onclick="periodCertificateSet(\''+obj.proId+'\',\''+obj.proName+'\',\''+obj.type+'\');">学时证书设置</a> &nbsp;&nbsp;' 
				+ '<a href="###" class="tablelink" onclick="periodCertificateSetShow(\''+obj.proId+'\',\''+obj.proName+'\',3,\'true\');">学时证书预览</a>&nbsp;&nbsp; ';
			}
			else{
				ret += '未设置学时证书打印&nbsp&nbsp&nbsp&nbsp';
			}
			
			if(obj.printProjectCertificate == 1){
				ret +='<a href="###" class="tablelink" onclick="printerCertificateSet(\''+obj.proId+'\',\''+obj.proName+'\',\''+obj.type+'\');">项目证书设置</a> &nbsp;&nbsp;' 
				+ '<a href="###" class="tablelink" onclick="printerCertificateSetShow(\''+obj.proId+'\',\''+obj.proName+'\',2);">项目证书预览</a>';
			}
			else{
				ret += '&nbsp&nbsp&nbsp&nbsp未设置项目证书打印';
			}
			return ret;
//		}else{
//			return "不在操作范围内";
//		}
		
	}
		
	function optionFormatter(obj,userAreaId){		
		var ret = "";
//		if(obj.createByArea==userAreaId) {
			if(obj.printXueshiCertificate == 1) {
				ret +='<a href="###" class="tablelink" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.proName+'\');">打印学时证书</a> &nbsp;' ;
				/*+
				'<a href="###" class="tablelink" onclick="periodCertificateSetShow('+obj.proId+');">学时证书预览</a>&nbsp;&nbsp;&nbsp;&nbsp;';*/
			}
			else{
				ret += '未设置学时证书打印&nbsp&nbsp&nbsp&nbsp';
			}
			if(obj.printProjectCertificate == 1){
				ret += '<a href="###" class="tablelink" onclick="printerCertificate(\''+obj.proId+'\',\''+obj.proName+'\');">打印项目证书</a> &nbsp;'; 
				/*+
				'<a href="###" class="tablelink" onclick="printerCertificateSetShow('+obj.proId+');">项目证书预览</a>';*/
			}
			else{
				ret += '&nbsp&nbsp&nbsp&nbsp未设置项目证书打印';
			}
			
			return ret;
//		}else {
//				return "不在操作范围内";
//		}
     }
	
}


/**
 * 学时证书模版设置
 * @param {Object} proId
 */
function periodCertificateSet(proId){
	var openUrl = pathHeader + '/furtheredu/certificate/certificateAddPage.htm?click=13&type=3&projectId='+proId;
	window.location.href = openUrl;
}


/**
 * 项目证书模版设置
 * @param {Object} proId
 */
function printerCertificateSet(proId){
	var openUrl = pathHeader + '/furtheredu/certificate/certificateAddPage.htm?click=13&type=2&projectId='+proId;
	window.location.href = openUrl;
}


/**
 * 项目证书预览
 * @param {Object} proId
 */
var commonUrl = "/furtheredu/certificate/certificateShowPage.json";
function printerCertificateSetShow(proId,projectName,type){
	if(checkIsSetCertificate(proId,projectName,type)){
		/*证书PDF预览*/
		var openUrl = pathHeader + '/furtheredu/certificate/printePDFCertificateSet.json?commonUrl='+commonUrl+'&type=2&projectId='+proId+'&projectName='+projectName;
		/*证书在线预览*/
		//var openUrl = pathHeader + '/furtheredu/certificate/certificateShowPage.json?type=2&projectId='+proId+'&projectName='+projectName;
		window.open(openUrl,"_blank");
	}else{
		jQuery.generalAlert("该项目还没有设置项目证书");
	}
}


/**
 * 学时证书预览
 * @param {Object} proId
 */
function periodCertificateSetShow(proId,projectName,type,flag){
	if(checkIsSetCertificate(proId,projectName,type)){
		if(flag == 'true'){
			var openUrl = pathHeader + '/furtheredu/certificate/printePDFCertificateSet.json?commonUrl='+commonUrl+'&type=3&projectId='+proId+'&projectName='+projectName;
			window.open(openUrl,"_blank");
		}else if(flag == 'false'){
			var openUrl = pathHeader + '/furtheredu/certificate/certificateShowPage.json?type=3&projectId='+proId;
			window.open(openUrl,"_blank");
		}
	}else{
		jQuery.generalAlert("该项目还没有设置学时证书");
	}
}


/**
 * 查询项目下参训教师并打印证书
 * @param {Object} proId
 */
function printerCertificate(proId, proName){
	var openUrl = pathHeader + '/furtheredu/edumanage/toSSPrinterCertificatePage.htm?click=1005&proId='+proId;
	window.location.href = openUrl;
}

//先查询是否已经设置了项目证书
function  checkIsSetCertificate(projectId,proName,type){
	var isSet = false;
	var url = pathHeader
	+ "/furtheredu/certificate/queryCertificate.do";
		$.ajax( {
					type : "POST",
					url : url,
					data : {
						projectId : projectId,
						type : type,
						certificateView:'1'
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
