$(function(){
	queryProList();
	
	$('#select').click(function(){
		queryProList();
	});
});



function queryProList(){
	var year = $('#queryYear').val();
	var url = pathHeader + "/furtheredu/edumanage/queryYearCertificateList.do";
	$('#year_cer_print').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			year:year
		},
		beforeSend: function(){
			$('#year_cer_print').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#year_cer_print').html(gridHtml);
			}else{
				$('#year_cer_print').html("<tr><td colspan='14'>无查询记录</td></tr>");
			}
		},
		error:function(){
			$('#year_cer_print').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}

function getObjHtml(obj){

	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.year+"</td>";
		gridHtml += "<td>"+obj.startDate+"</td>";
		gridHtml += "<td>"+obj.endDate+"</td>";
		gridHtml += "<td>"+obj.needCredit1+"</td>";
	 	gridHtml += optionFormatter(obj);
		gridHtml+= "</tr>";
	return gridHtml;
}
function optionFormatter(obj){
	var ret ="<td>";
	ret +='<a href="###" class="tablelink" onclick="printerCertificate(\''+obj.id+'\');">打印学时证书</a> &nbsp;' ;
	ret += "</td>";
	return ret;
}
	

var commonUrl="/furtheredu/edumanage/toPrinterYearCertificatePage.json";
function printerCertificate(id){
	
	//查询教师是否有资格打印年度证书
	if(hasSetCertificate(id) && printQualified(id)){
		var url =  pathHeader + "/furtheredu/edumanage/printePDFCertificate.json?diplomaId="+id+"&type=1&isShowTip=true&commonUrl="+commonUrl ;
		window.open(url,"_blank");
	}
}

/**
 * 检测是否设置年度证书
 */
function hasSetCertificate(id){
	var qualified = false;
	var url = pathHeader
	+ "/furtheredu/certificate/hasSetCertificate.do";
		$.ajax( {
					type : "POST",
					url : url,
					data : {
						diplomaId:id
					},
					async : false,
					success : function(data) {
						if(data.success){
							qualified = true;
						}else{
							jQuery.generalAlert(data.message);
						}
					},
					error : function() {
					}
				});
		
		return qualified;
}

/***
 * 校验教师是否有资格打印年度证书
 */
function printQualified(id){
	var qualified = false;
	var url = pathHeader
	+ "/teacher/teacherProject/teacherPrintQualified.do";
		$.ajax( {
					type : "POST",
					url : url,
					data : {
						diplomaId:id
					},
					async : false,
					success : function(data) {
						if(data.success){
							jQuery.generalAlert(data.message);
							qualified = true;
						}else{
							jQuery.generalAlert(data.message);
						}
					},
					error : function() {
					}
				});
		
		return qualified;
}


