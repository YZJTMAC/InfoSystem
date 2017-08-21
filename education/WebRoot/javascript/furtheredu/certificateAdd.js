$(function() {
	//查询证书模板
	queryCertificateInfo();
	getQRCodeImage();
});
function kedit(){ 
	KindEditor.create('#content', {
		urlType : 'relative',
		height:'600px',
		afterBlur: function(){this.sync();}
	});
}
function showUpload() {
	$(".tip14").fadeIn(200);
}

function showQRCodeUpload() {
	$(".tip16").fadeIn(200);
}
function closeUpload() {
	$(".tip14").fadeOut(200);
}

function closeUploadQRCode() {
	$(".tip16").fadeOut(200);
}

function closeUpload2() {
	$(".tip15").fadeOut(200);
}
function closeUpload3() {
	$(".tip17").fadeOut(200);
}
var signetId = 0;

//查询证书模板，如果没有，则使用默认的
function queryCertificateInfo() {
	$.ajax( {
				type : "POST",
				url : pathHeader
						+ "/furtheredu/certificate/queryCertificate.do",
				data : {
					id : id,
					projectId : projectId,
					type : type,
					//是否保存标识 0为保存状态 1为 查询状态
					certificateView :"0"
				},
				async : false,
				success : function(msg) {
					if (msg.success) {
						if(msg.obj == null) {
							showSignetList();
						}
						var obj = msg.obj;
						signetId = obj.signetId;
						showSignetList();
						id = obj.id;
						
						$("#oldProjectCode").val(obj.projectCode);
						if(obj.seal == '1') {
							$("#isDisplay").attr("checked", 'checked');
						}
						if(obj.qrcode == '1') {
							$("#isDisplayQRCode").attr("checked", 'checked');
						}
						if(obj.isProjectPrefix == '1') {
							$("#isprojectPrefix").attr("checked", 'checked');
						}
						if(obj.isAreaCode == '1') {
							$("#isareaCode").attr("checked", 'checked');
						}
						if(obj.isYearCode == '1') {
							$("#isyearCode").attr("checked", 'checked');
						}
						if(obj.isProjectScopeCode == '1') {
							$("#isProjectScopeCode").attr("checked", 'checked');
						}
						if(obj.isProjectTrainTypeCode == '1') {
							$("#isProjectTrainTypeCode").attr("checked", 'checked');
						}
						if(obj.isOrgCode == '1') {
							$("#isOrgCode").attr("checked", 'checked');
						}
						$("#id").val(obj.id);
						$('#title').val(obj.title);
						$('#head').val(obj.head);
						$('#content').val(obj.content);
						kedit();
						$('#foot').val(obj.foot);
						$('#positionRight').val(obj.positionRight);
						$('#positionTop').val(obj.positionTop);
						$('#positionWidth').val(obj.positionWidth);
						$('#positionHeight').val(obj.positionHeight);
						$('#QRCodeRight').val(obj.qrcodeRight);
						$('#QRCodeTop').val(obj.qrcodeTop);
						$('#QRCodeWidth').val(obj.qrcodeWidth);
						$('#QRCodeHeight').val(obj.qrcodeHeight);
//						$("#rblImageList_" +  obj.signetId).attr("checked", 'checked');
						$("#backgroundImg").val(obj.backgroundImg);
						$("#QRbackgroundImg").val(obj.qrbackgroundImg);
						$("#periodCertificateTitle").val(obj.periodCertificateTitle);
						
						//项目前缀
						$("#projectPrefixCode").val(obj.projectPrefix);
						//地区代码
						$("#areaCode").val(areaCode);
						//年份代码
						$('#yearCode').val(yearCode);
						//培训级别
						$("#projectScopeCode").val(projectScopeCode);
						//培训项目类型
						$("#projectTrainTypeCode").val(projectTrainTypeCode);
						//机构代码
						$("#orgCode").val(orgCode);
					} else {
						if(type == '1'){
							$('#title').val('默认年度证书模板');
							$('#content').val(msg.obj);
							kedit();
						}else if(type == '2'){
							$('#title').val('默认项目证书模板');
							$('#content').val(msg.obj);
							kedit();
							$("#isprojectPrefix").attr("checked", 'checked');
							//电子印章/二维码默认显示位置
							$('#positionRight').val('500');//440
							$('#positionTop').val('460');//359
							$('#positionWidth').val('148');
							$('#positionHeight').val('148');
							$("#isDisplay").attr("checked", 'checked');
							$("#isDisplayQRCode").attr("checked", 'checked');
							$('#QRCodeRight').val('200');
							$('#QRCodeTop').val('510');
							$('#QRCodeWidth').val('100');
							$('#QRCodeHeight').val('100');
						}else if(type=='3'){
							$('#title').val('默认学时证书模板-白色背景');
							$('#content').val(msg.obj);
							kedit();
							$("#isprojectPrefix").attr("checked", 'checked');
							//电子印章/二维码默认显示位置
							$('#positionRight').val('470');//440
							$('#positionTop').val('360');//359
							$('#positionWidth').val('148');
							$('#positionHeight').val('148');
							$("#isDisplay").attr("checked", 'checked');
							$("#isDisplayQRCode").attr("checked", 'checked');
							$('#QRCodeRight').val('310');
							$('#QRCodeTop').val('390');
							$('#QRCodeWidth').val('100');
							$('#QRCodeHeight').val('100');
						}
						
						
						showSignetList();
					}
				},
				error : function() {
				}
			});
}

//查询证书模板背景
function queryCertificateBackground(){
	$("#certificateFiles").html('');
	var url = pathHeader + "/fileupload/viewFiles.do?time="
	+ (new Date()).getTime();
	$.ajax({
		dataType : 'json',
		url : url,
		type : 'post',
		data : {
			projectId : projectId,
			type : "certificate"
		},
		success : function(data) {
			$.each(data.files,function(i, item) {
				$("#certificateFiles").append('<div><img id="certificateTemp" title="模板" src="'+pathHeader+"/"+item.url+'"  style="height: 200px; width: 200px; border: 1px solid #eee; margin-top: 10px;">');
				$("#certificateFiles").append('<input type="radio" name="certificateBackgroundImg" value="'+item.id+'"/>选择 &nbsp;&nbsp;');
				$("#certificateFiles").append("<a href='#' onclick= removeTemplate('"
						+ item.id + "','" + item.url
						+ "','"
						+ item.projectId
						+ "') >删除 </a></div>");
				
			});
		},
		error : function() {
			jQuery.generalAlert("查询数据出错！请联系管理员");
		}
	});
	$(".tip15").fadeIn(200);
}

//查询二维码背景
function queryQRCodeBackground(){
	$("#QRCodeFiles").html('');
	var url = pathHeader + "/fileupload/viewQRCodeFiles.do?time="
	+ (new Date()).getTime();
	$.ajax({
		dataType : 'json',
		url : url,
		type : 'post',
		data : {
			projectId : projectId,
			type : "qrcode"
		},
		success : function(data) {
			$.each(data.files,function(i, item) {
				$("#QRCodeFiles").append('<div><img id="QRCodeTemp_back" title="二维码验证背景" src="'+pathHeader+"/"+item.url+'"  style="height: 200px; width: 200px; border: 1px solid #eee; margin-top: 10px;">');
				$("#QRCodeFiles").append('<input type="radio" name="QRCodeBackgroundImg" value="'+item.id+'"/>选择 &nbsp;&nbsp;');
				$("#QRCodeFiles").append("<a href='#' onclick= removeTemplate('"
						+ item.id + "','" + item.url
						+ "','"
						+ item.projectId
						+ "') >删除 </a></div>");
				
			});
		},
		error : function() {
			jQuery.generalAlert("查询数据出错！请联系管理员");
		}
	});
	$(".tip17").fadeIn(200);
}
function saveUpImg(){
	 var backgroundImg= $('input:radio[name="certificateBackgroundImg"]:checked').val();
	 $("#backgroundImg").val(backgroundImg);
	 jQuery.generalAlert("设置模板成功");
	 $(".tip15").fadeOut(200);
}
// 设置二维码背景
function saveUpQRImg(){
	 var QRbackgroundImg= $('input:radio[name="QRCodeBackgroundImg"]:checked').val();
	 $("#QRbackgroundImg").val(QRbackgroundImg);
	 jQuery.generalAlert("设置二维码背景成功");
	 $(".tip17").fadeOut(200);
}

	/**
	 * id:总结报告id filePath：文件名 pid：项目id
	 */
function removeTemplate(id, filePath, pid) {
		jQuery.confirmWindow(
						"提示",
						"是否删除该模板？",
						function() {
							var url = pathHeader
									+ "/fileupload/deleteFile.do?";
							$.ajax({
									dataType : 'json',
									type : 'post',
									url : url,
									data : {
										id : id,
										filePath : filePath,
										pid : pid
									},
									success : function(data) {
										$('.tipbox').hide();										
										jQuery.generalAlert("删除成功");
										
									},
									error : function() {
										jQuery.generalAlert("删除失败");
									}
								});
						});

}


//上传证书模板背景
function uploadFile(){
	$.ajaxFileUpload({
        url:pathHeader + '/fileupload/saveSingleFile.do',
        secureuri:false,
        fileElementId:'certificateFile',  //文件选择框的id属性（必须）
        dataType: 'json',  
        type:'post',
        data : {type: 'certificate',projectId:projectId,isCompression:'1'},
		success:function(data){
			if(data.success){
				$("#certificateTemp_back").attr("src", pathHeader +"/"+ data.file.url);
				$("#backgroundImg").val(data.file.id);
				$("#imageSrcTemp").val(src);
				clearInterval(the_timeout);
				$('#progress').css('width', 100);
				$('#create').remove();
				$('#ol').append(createCancel(extName, src));
				$('#savePath').val("");
				$('#savePath').val(data.savePath);
			} else {
				alert("失败!");
			}
		},
		error:function(){
		}
	});
}

function saveUp(data) {

	$(".tip14").fadeOut(200);
}
function saveQRUp(data) {

	$(".tip16").fadeOut(200);
}

//证书编码前缀设置必须勾选
$(function(){
	$("#isprojectPrefix").click(function(){
		var isCheckProjectPrefix = $("#isprojectPrefix").attr("checked");
		if(!isCheckProjectPrefix){
			jQuery.generalAlert("设置证书编号必须勾选项目前缀！");
			$("#isprojectPrefix").attr("checked",true);
			return;
		}
	});
});

function checkProjectCode(code){
	if(!codeValidate(code)){
		jQuery.generalAlert("请使用大写字母和正整数组成的项目前缀！");
	}
}
/**
 * 校验项目编码前缀 组成为正整数数和大写字母组成
 * @param obj
 * @returns
 */
function codeValidate(obj){
	var b = /^[A-Z0-9]+$/;
	var patt1 = new RegExp(b);
	var result = patt1.test(obj.val());
	return result;
}

/**
 * 保存证书
 * @return {TypeName} 
 */
function saveCertificate() {
	var checkCode = $('#projectPrefixCode');
	if(!codeValidate(checkCode)){
		jQuery.generalAlert("请使用大写字母和正整数组成的项目前缀！");
		return false;
	}
	$certificate = {
		type : type,
		id : $('#id').val(),
		title : $('#title').val(),
		//head : $('#head').val(),
		content : $('#content').val(),
		//foot : $('#foot').val(),
		backgroundImg:$("#backgroundImg").val(),
		qrbackgroundImg:$("#QRbackgroundImg").val(),
		projectId : projectId,
		year:$('#year').val(),
		//设置是否显示电子印章
		seal:($("#isDisplay").attr("checked") ? "1" : "0"),
		signetId : $('input:radio[name="rblImageList"]:checked').val(),
		// 设置二维码是否显示
		qrcode:($("#isDisplayQRCode").attr("checked") ? "1" : "0"),
		//获取电子印章的位置
		positionRight : $('#positionRight').val(),
		positionTop : $('#positionTop').val(),
		positionWidth : $('#positionWidth').val(),
		positionHeight : $('#positionHeight').val(),
		//获取二维码信息的位置
		qrcodeRight : $('#QRCodeRight').val(),
		qrcodeTop : $('#QRCodeTop').val(),
		qrcodeWidth : $('#QRCodeWidth').val(),
		qrcodeHeight : $('#QRCodeHeight').val(),
		periodCertificateTitle :$('#periodCertificateTitle').val(),
		
		//证书编号相关
		 
		 projectPrefix :$('#projectPrefixCode').val(),
		 isProjectPrefix:($("#isprojectPrefix").attr("checked") ? "1" : "0"),
		 isAreaCode:($("#isareaCode").attr("checked") ? "1" : "0"),
		 areaCode:$('#areaCode').val(),
		 isYearCode:($("#isyearCode").attr("checked") ? "1" : "0"),
		 yearCode:$('#yearCode').val(),
	     isProjectScopeCode:($("#isProjectScopeCode").attr("checked") ? "1" : "0"),
	     projectScopeCode:$('#projectScopeCode').val(),
	     isProjectTrainTypeCode:($("#isProjectTrainTypeCode").attr("checked") ? "1" : "0"),
	     projectTrainTypeCode:$('#projectTrainTypeCode').val(),
	     isOrgCode:($("#isOrgCode").attr("checked") ? "1" : "0"),
		 orgCode:$('#orgCode').val()
		
	}

	$.ajax( {
		type : "POST",
		url : pathHeader + "/furtheredu/certificate/addCertificate.do",
		data : {
			data : $.toJSON($certificate),
			oldProjectCode : $('#oldProjectCode').val()
		},
		async : true,
		success : function(data) {
			$("#toCancel").css("display", "none");
			if (data.success) {
				jQuery.generalAlertAndJump("保存成功！", goback());
				$("#toPage").html("<input name=\"\" onclick='goback();'  type=\"button\" class=\"sure1\" value=\"确定\" />");
			} else if(data.msg == -1){
				jQuery.generalAlert("项目证书编码重复！");
			} else {
				jQuery.generalAlert("保存失败，请重试！");
				$("#toPage").html("<input name=\"\" onclick='close();'  type=\"button\" class=\"sure1\" value=\"关闭\" />");
			}
		},
		error : function() {
			$("#toCancel").css("display", "none");
		}
	});
}
function goback() {
	var openUrl = pathHeader + "/furtheredu/certificate/certificateListPage.htm?click=3";
	if (click == 13 ) {
		openUrl = pathHeader + "/furtheredu/edumanage/toProPrinterCertificateSetPage.htm?click=13";
	} 
//	else if(click==13 && type==3){
//		var openUrl = pathHeader
//				+ "/furtheredu/edumanage/toProPrinterCertificateSetPage.htm?click=13";
//	} 
	
	return openUrl;
	//showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}

//加载二维码
function getQRCodeImage(){
	$('#QRCodeImg').append("<input type='radio' name='QRCodeCheck' id='isDisplayQRCode' checked='checked'>");
	$('#QRCodeImg').append("<img src= \""+imageServer+"/QRCode.jpg"+"\"  style=\"position: relative; left: 5px; top:0px\"/>");
}


//上传二维码验证背景
function uploadQRCodeFile(){
	$.ajaxFileUpload({
        url:pathHeader + '/fileupload/saveQRCodeFile.do',
        secureuri:false,
        fileElementId:'QRCodeFile',  //文件选择框的id属性（必须）
        dataType: 'json',  
        type:'post',
        data : {type: 'qrcode',projectId:projectId},
		success:function(data){
			if(data.success){
				// 设置背景文件名称
				$("#QRCodeTemp_back").attr("src", pathHeader +"/"+ data.file.url);
				$("#QRbackgroundImg").val(data.file.id);
				$("#imageQRCodeSrcTemp").val(src);
				clearInterval(the_timeout);
				$('#progress').css('width', 100);
				$('#create').remove();
				$('#ol').append(createCancel(extName, src));
				$('#savePath').val("");
				$('#savePath').val(data.savePath);
			} else {
				alert("失败!");
			}
		},
		error:function(){
		}
	});
}

function showSignetList() {
	$.ajax( {
		url : pathHeader + "/furtheredu/edumanage/querySignetList.do",
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			flag : 1
		},
		success : function(data) {
			if (data.success) {
				var objList = data.rows;
				var accLog=data.accLog;
				var gridHtml = "";
				$.each(objList, function(index, element) {
					gridHtml += getDivHtml(element, index,accLog);
				});
				$('#signetHtml').html(gridHtml);
				$("#rblImageList_" +  signetId).attr("checked", 'checked');
			}
			
		}
	});

}

function getDivHtml(obj, index,accLog) {
	var ht = "";
	//if(obj.createBy==accLog){
	ht += "<input id=\"rblImageList_" + obj.id
			+ "\" type=\"radio\" name=\"rblImageList\" value=\"" + obj.id
			+ "\" " + (index == 0 ? "checked" : "") + " />";
	ht += "<label for=\"rblImageList_" + obj.id + "\">";
	ht += "<img src=\"" + imageServer + obj.signetUrl
			+ "\" width=100 height=100 /></label>";
	//}
	return ht + "&nbsp;&nbsp;";
}
function close() {
	$(".tip0").fadeOut(200);
}
function toPage() {
	window.location.href = pathHeader
			+ "/furtheredu/certificate/certificateListPage.htm?click=3";
}

function cancel(){
	if(type == 1){
		window.location.href = pathHeader + "/furtheredu/certificate/certificateListPage.htm?click=3";
	} else if(type==2 || type==3){
		window.location.href = pathHeader + "/furtheredu/edumanage/toProPrinterCertificateSetPage.htm?click=13";
	} 
}

