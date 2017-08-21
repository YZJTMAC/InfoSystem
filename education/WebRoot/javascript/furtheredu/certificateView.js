$(function(){
		queryCertificateInfo();
});

//查询项目证书
function queryCertificateInfo(){
	$.ajax( {
			type : "POST",
			url : pathHeader + "/furtheredu/certificate/queryCertificate.do",
			data:{
				id: id,
				projectId:projectId,
				type : type,
				//是否保存标识 0为保存状态 1为 查询状态
				certificateView:"1"
			},			
			async : true,
			success : function(msg) {
				if (msg.success) {
					var obj = msg.obj;
					if(msg.obj.backgroundImg == - 1){
						if(type ==2){
							$("#backgroundImage").attr("src",pathHeader+"/images/imgTemplate/code_back.jpg");
						}
						if(type ==3){
							//当预览学时，使用白色背景
							$("#backgroundImage").attr("src",pathHeader+"/images/imgTemplate/period.jpg");
						}
					}else{
						$("#backgroundImage").attr("src",pathHeader+"/"+obj.backgroundImgUrl);
					}
					$('#content').append(obj.content);//absolute relative; left: 300px; top:-180px\"
					//设置学时证书,项目证书预览二维码
					if(obj.qrcode == '1'){
						$('#content').append("<img src= \""+imageServer+msg.qrcodeUrl+"\" style=\"position: absolute; z-index: -1;width: "+obj.qrcodeWidth+"px; height: "+obj.qrcodeHeight+"px; left: "+obj.qrcodeRight+"px; top: "+obj.qrcodeTop+"px;\"/>");
					}
					// 设置电子印章
					if(obj.seal == '1') {
						$('#content').append("<img src=\""+imageServer+obj.signetUrl+"\" style=\"position: absolute; z-index: -1; width: "+obj.positionWidth+"px; height: "+obj.positionHeight+"px; left: "+obj.positionRight+"px; top: "+obj.positionTop+"px;\"  />");
					}																										
				}else{
				} 
 			}
		});
}

