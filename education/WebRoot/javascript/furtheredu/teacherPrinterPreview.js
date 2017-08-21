$(function(){
	printerPreview();
});

function printerPreview(){
		$.ajax( {
			type : "POST",
			url : pathHeader + "/furtheredu/edumanage/queryCertificateByYear.do",
			data:{				
				projectId:projectId,
				teacherId : teacherId,				
				type : type
			},
			async : false,
			success : function(msg) {
				if (msg.success) {
					var obj = msg.obj;
					if(msg.obj.backgroundImg == - 1){
						if(type ==2){
							$("#backgroundImage").attr("src",pathHeader+"/images/imgTemplate/code_back.jpg");
						}
						if(type ==3){
							$("#backgroundImage").attr("src",pathHeader+"/images/imgTemplate/period.jpg");
						}
					}else{
						$("#backgroundImage").attr("src",pathHeader+"/"+obj.backgroundImgUrl);
					}
					$('#content').append(obj.content);
					if(obj.qrcode == '1'){
						$('#content').append("<img src= \""+imageServer+obj.qrcodeUrl+"\" style=\"position: absolute; z-index: -1;width: "+obj.qrcodeWidth+"px; height: "+obj.qrcodeHeight+"px; left: "+obj.qrcodeRight+"px; top: "+obj.qrcodeTop+"px;\"/>");
					}
					if(obj.seal == '1') {
						$('#content').append("<img src=\""+imageServer+obj.signetUrl+"\"  style=\"position: absolute; z-index: -1; width: "+obj.positionWidth+"px; height: "+obj.positionHeight+"px; left: "+obj.positionRight+"px; top: "+obj.positionTop+"px;\"/>");
					}
					
				} else {
				}
 			},
			error : function() {
			}
		});
}


function printView(){
	$('input').hide();
	$.printPreview.loadPrintPreview();
	//$.printPreview.jqprint();
	//$('a.print-preview').jqprint();
	$('input').show();
}


function printCertificate(){
	$('input').hide();
	window.print();
	$('input').show();
}

if(isTip){
	setTimeout('tipInfo()',500); 	
}
function tipInfo(){
	alert("重要通知:为了更好的打印证书，请学员们配合！" + "\r"
			+"1:请使用标配IE8及IE8以上浏览器,其它浏览器打印如有问题,请切换IE浏览器。" + "\r"
			+"2:使用360浏览器的用户，请设置成兼容模式。" + "\r"
			+"3:请在浏览器的打印预览中，设置成A4纸，横版，无页眉页脚，无边距打印。" + "\r"
			+"4:对于以上操作不清楚的，可以返回上一界面下载打印操作说明书。" + "\r"
			+"5:如打印证书有问题的,请切换浏览器尝试。"+ "\r"
			+"6:请老师们配合,打印并保存好证书!"
			);
}
