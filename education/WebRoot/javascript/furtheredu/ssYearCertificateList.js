$(function(){
	queryProList();
	$('#select').click(function(){
		queryProList();
	});
});
/**
 * 打开添加新的年度证书页面
 * @returns
 */
function addYearCertificate(){
	var url = pathHeader+ "/furtheredu/edumanage/addYearCertificate.htm?click=24";
//	alert("123"+url);
	window.location.href=url;
}

/**
 * 列表
 */
function queryProList(){
	var year = $('#queryYear').val();
	var url = pathHeader + "/furtheredu/edumanage/queryYearCertificateList.do";
	$('#ss_year_cer_list').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			year:year
		},
		beforeSend: function(){
			$('#ss_year_cer_list').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#ss_year_cer_list').html(gridHtml);
			}else{
				$('#ss_year_cer_list').html("<tr><td colspan='14'>无查询记录</td></tr>");
			}
		},
		error:function(){
			$('#ss_year_cer_list').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}

function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.year+"</td>";
		gridHtml += "<td>"+obj.title+"</td>";
		gridHtml += "<td>"+obj.startDate+"</td>";
		gridHtml += "<td>"+obj.endDate+"</td>";
		gridHtml += "<td>"+obj.needCredit1+"</td>";
	 	gridHtml += "<td>"+optionFormatter(obj)+"</td>";
	 	gridHtml += "<td><a href='javascript:updateObj("+obj.id+")''>编辑</a> " +
		 				"<a href='javascript:deleteObj("+obj.id+")''>删除</a>" +
		 			"</td>";
		gridHtml+= "</tr>";
	return gridHtml;
}

/**
 * 删除
 * @param id
 */
function deleteObj(id){
	var url = pathHeader + "/furtheredu/edumanage/yearCertificateDelete.do";
	$('#ss_year_cer_list').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			id:id
		},
		success:function(data){
			if(data.success){
				jQuery.generalAlert("删除成功");
			}else{
				jQuery.generalAlert("删除失败");
			}
			queryProList();
		},
		error:function(){
			jQuery.generalAlert("删除失败");
		}
		
	});
}
/**
 * 编辑
 * @param id
 */
function updateObj(id){
	var url = pathHeader+ "/furtheredu/edumanage/updateYearCertificate.htm?click=24&id="+id;
	window.location.href=url;
}


function optionFormatter(obj){
	var ret ="";
	ret += '<a href="###" class="tablelink" onclick="periodCertificateSet(\''+obj.id+'\');">年度证书设置</a> &nbsp;&nbsp;' 
	+ '<a href="###" class="tablelink" onclick="periodCertificateSetShow(\''+obj.id+'\',\''+obj.title+'\');">年度证书预览</a>&nbsp;&nbsp; ';
	return ret;
}

function periodCertificateSet(id){
	var openUrl = pathHeader + '/furtheredu/certificate/yearCertificateAddPage.htm?click=24&type=1&id='+id;
	window.location.href = openUrl;
}


/**
* 学时证书预览
*/
var commonUrl = "/furtheredu/certificate/certificateShowPage.json";
function periodCertificateSetShow(diplomaId,title){
	if(hasSetCertificate(diplomaId)){
		var openUrl = pathHeader + '/furtheredu/certificate/printePDFCertificateSet.json?type=1&diplomaId='+diplomaId+'&commonUrl='+commonUrl+'&projectName='+title;
		window.open(openUrl,"_blank");
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

