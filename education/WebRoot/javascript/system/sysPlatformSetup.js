$(function(){
	initPlatformSetupInfo();
	
});


/**
 * 查询平台设置
 */
function initPlatformSetupInfo(){
	$.ajax({
		url : pathHeader + '/sys/platform/sysPlatformSetupInfo.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		success:function(data){
			if(data.success){
				var obj = data.obj;
				$("#sys_style").find("option[value="+obj.sysStyle+"]").attr("selected",true);
				
				initSelect();
				
				$('#sys_name').val(obj.sysName);
				$('#sys_logo').attr('src', pathHeader+'/static/'+obj.sysLogo);
				$('#login_logo').attr('src', pathHeader+'/static/'+obj.loginLogo);
				$('#copyright').val(obj.copyrightNotice);
				$('#contact_way').val(obj.contactWay);
			} else {
				jQuery.generalAlert("查询失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("查询失败!");
		}
	});
}


function modifyStyle(obj){
	var style = $(obj).val();
	if(style == 0){
		$('link[id=style]').attr('href', pathHeader+'/style/sblue/style.css');
	} else if(style == 1){
		$('link[id=style]').attr('href', pathHeader+'/style/style.css');
	} else if(style == 2){
		$('link[id=style]').attr('href', pathHeader+'/style/green/style.css');
	} else if(style == 3){
		$('link[id=style]').attr('href', pathHeader+'/style/red/style.css');
	}
}



function modifySysLogo(id){
	validatePic(id);
	var obj = document.getElementById('sysLogo');
	$('#sys_logo').attr('src', getFullPath(obj));
}


function modifyLoginLogo(id){
	validatePic(id);
	var obj = document.getElementById('loginLogo');
	$('#login_logo').attr('src', getFullPath(obj));
}

/**
 * 图片格式验证
 * @param {Object} id
 */
function validatePic(id){
	var picPath = $('#'+id).val();
	var extName =  picPath.substring(picPath.lastIndexOf(".")+1,picPath.length);
	extName = extName.toLowerCase();//处理大小写
   	if(extName!="bmp" && extName!="jpg" && extName!="png"){
		jQuery.generalAlert("只能上传bmp,jpg,png格式的图片！");
    	return false;
   	}
}


/**
 * 获取上传图片绝对路径
 * @param {Object} obj
 */
function getFullPath(obj) { 
	if(obj) { 
		//ie 
		if (window.navigator.userAgent.indexOf("MSIE")>=1) { 
			obj.select(); 
			return document.selection.createRange().text; 
		//firefox 
		} else if(window.navigator.userAgent.indexOf("Firefox")>=1){ 
			if(obj.files){ 
				return window.URL.createObjectURL(obj.files[0]);
			} 
			return obj.value; 
		} 
		return obj.value; 
	} 
}


/**
 * 保存修改
 */
function save(){
	$('#save').attr('href', '###');
	
	$('#sysStyle').val($('#sys_style').val());
	
	$("#sysForm").ajaxSubmit({
		url: pathHeader + '/sys/savePlatformSetup.do',
		async:false,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data){
				jQuery.generalAlert("保存成功！");
				location.reload();				
			}else{
				jQuery.generalAlert("保存失败！");
				$("#save").attr("href",'javascript: save();');
			}
		},
		error:function(){
			$("#save").attr("href",'javascript: save();');
		}
	});
}


function initSelect(){
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	
	$("dt").attr({'style': 'width : 100px'});
}