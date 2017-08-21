var filePath = '';
var extName = '';
var names = new Array();

//打印证书上传电子印章
function uploadFile(){
	
	// 获取上传文件名
	var filePath = $('#photoFile').val();
	
	var ext = filePath.substring(filePath.lastIndexOf('.') + 1, filePath.length).toLowerCase();
	if (ext !="png") {
		jQuery.generalAlert("电子印章只支持.png格式");
		return;
	}
	
	$.ajaxFileUpload({
		//需要链接到服务器地址
        url:pathHeader + '/sys/uploadUserPhoto.do',
        secureuri:false,
        fileElementId:'photoFile',  //文件选择框的id属性（必须）
        dataType: 'json',  
        data : {'upload': 'first', 'savePath':''},
		success:function(data){
			if(data.success){
				// 隐藏第一步div, 显示第二步div
				$('#first').hide();
				$('#second').show();
	
				var src = data.filePath;
				$("#photoTemp").attr("src", imageServer + src);
				$("#imageSrcTemp").val(src);
				clearInterval(the_timeout);
				$('#progress').css('width', 100);
				$('#create').remove();
				$('#ol').append(createCancel(extName, src));
				$('#savePath').val("");
				$('#savePath').val(data.savePath);
				jQuery.generalAlert("上传成功");
			} else {
				jQuery.generalAlert("上传失败");
			}
		},
		error:function(){
		}
	});
}


//用户修改图像,上传图片
function uploadPhotoFile(){
	// 获取上传文件名
	var filePath = $('#photoFile').val();
	
	var ext = filePath.substring(filePath.lastIndexOf('.') + 1, filePath.length).toLowerCase();
	if (ext !="png" && ext !="jpg" && ext !="bmp" && ext !="gif") {
		jQuery.generalAlert("上传头像不支持该格式!");
		return;
	}
	
	$.ajaxFileUpload({
		//需要链接到服务器地址
        url:pathHeader + '/sys/uploadUserPhoto.do',
        secureuri:false,
        fileElementId:'photoFile',  //文件选择框的id属性（必须）
        dataType: 'json',  
        data : {'upload': 'first', 'savePath':''},
		success:function(data){
			if(data.success){
				// 隐藏第一步div, 显示第二步div
				$('#first').hide();
				$('#second').show();

				var src = data.filePath;
				$("#photoTemp").attr("src", imageServer + src);
				$("#imageSrcTemp").val(src);
				//alert(src);
				clearInterval(the_timeout);
				$('#progress').css('width', 100);
				$('#create').remove();
				$('#ol').append(createCancel(extName, src));
				$('#savePath').val("");
				$('#savePath').val(data.savePath);
				jQuery.generalAlert("上传成功");
			} else {
				jQuery.generalAlert("上传失败");
			}
		},
		error:function(){
		}
	});
}
/**
 * 继续添加
 */
function uploadFileAgain(){
	// 获取上传文件名
	filePath = $('#again').val();
	extName =  getFileName(filePath);
	$('#ol').append(createUploading_2(filePath, extName));
	
	timeOut();
	
	$.ajaxFileUpload({
		//需要链接到服务器地址
        url:pathHeader + '/org/uploadFile.do',
        secureuri:false,
        fileElementId:'again',  //文件选择框的id属性（必须）
        dataType: 'json',  
        data : {'upload':'again', 'savePath':$('#savePath').val()},
		success:function(data){
			if(data.success){
				var src = data.filePath;
				clearInterval(the_timeout);
				$('#progress_2').css('width', 100);
				$('#create_2').remove();
				$('#ol').append(createCancel(extName, src));
				$('#savePath').val("");
				$('#savePath').val(data.savePath);
			} else {
				clearInterval(the_timeout);
				alert("失败!");
			}
		},
		error:function(){
			clearInterval(the_timeout);
			alert("上传失败!");
		}
	});
}


/**
 * 删除已上传的文件
 * @param {Object} src
 */
function delFile(src){
	var filePath = $(src).attr('id');
	$.ajax({
		url:pathHeader + "/org/delUploadFile.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data :{'filePath':filePath},
		success:function(data){
			if(data.success){
				alert("删除成功!");
				$(src).parent('li').parent('ol').remove();
			} else {
				alert("删除失败!");
			}
		},
		error:function(){
			alert("删除失败!");
		}
	});	
}



/**
 * 重新上传---->(上传附件)
 * @param {Object} again
 */
function uploadAgain(again){
	$(again).parent('li').parent('ol').remove();
	uploadFile();
}


/**
 * 重新上传---->(继续添加)
 * @param {Object} again
 */
function uploadAgain_2(again){
	$(again).parent('li').parent('ol').remove();
	uploadFileAgain();
}


/**
 * 取消上传---->(上传附件)
 * @param {Object} del
 */
function cancelUpload(del){
	$(del).parent('li').parent('ol').remove();
	clearInterval(the_timeout);
	$('#ol').append(createUploadAgain(extName));
}


/**
 * 取消上传---->(继续添加)
 * @param {Object} del
 */
function cancelUpload_2(del){
	$(del).parent('li').parent('ol').remove();
	clearInterval(the_timeout);
	$('#ol').append(createUploadAgain_2(extName));
}



/**
 * 创建上传中ol---->(上传附件)
 * @param {Object} extName
 */
function createUploading(src, extName){
	return '<ol id="create" class="fileol">'+
				'<li><img src="'+pathHeader+'/images/iconfile.png" /></li>'+
				'<li>'+extName+'</li>'+
				'<li><div style="border: 1px solid #657b90; margin-top: 3px; width: 100px;">'+
				'<span id="progress" style="background-color: #5c7e9a; height: 10px; width: 0px;"></span>'+
				'</div></li>'+
				'<li><a href="###" onclick="cancelUpload(this)">取消</a></li>'+
			'</ol>'
}


/**
 * 创建上传中ol---->(继续添加)
 * @param {Object} extName
 */
function createUploading_2(src, extName){
	return '<ol id="create_2" class="fileol">'+
				'<li><img src="'+pathHeader+'/images/iconfile.png" /></li>'+
				'<li>'+extName+'</li>'+
				'<li><div style="border: 1px solid #657b90; margin-top: 3px; width: 100px;">'+
				'<span id="progress_2" style="background-color: #5c7e9a; height: 10px; width: 0px;"></span>'+
				'</div></li>'+
				'<li><a href="###" onclick="cancelUpload_2(this)">取消</a></li>'+
			'</ol>'
}


/**
 * 创建上传完成ol, 删除
 * @param {Object} extName
 */
function createCancel(extName, src){
	return	'<ol class="fileol">'+
				'<li><img src="'+pathHeader+'/images/iconfile_ok.png" /></li>'+
		 		"<li class='name'>"+extName+"</li>"+
				'<li><a href="###" id="'+src+'" onclick="delFile(this)">删除</a></li>'+
			'</ol>'
}


/**
 * 创建重新上传ol---->(上传附件)
 * @param {Object} extName
 */
function createUploadAgain(extName){
	return	'<ol class="fileol">'+
				'<li><img src="'+pathHeader+'/images/iconfile_x.png" /></li>'+
				"<li>"+extName+"</li>"+
				'<li><a href="###" onclick="uploadAgain(this);">重新上传</a></li>'+
			'</ol>'
}


/**
 * 创建重新上传ol---->(继续添加)
 * @param {Object} extName
 */
function createUploadAgain_2(extName){
	return	'<ol class="fileol">'+
				'<li><img src="'+pathHeader+'/images/iconfile_x.png" /></li>'+
				"<li>"+extName+"</li>"+
				'<li><a href="###" onclick="uploadAgain_2(this);">重新上传</a></li>'+
			'</ol>'
}


/**
 * 获取上传文件名
 * @param {Object} path
 * @return {TypeName} 
 */
function getFileName(path){
	var pos1 = path.lastIndexOf('/');
	var pos2 = path.lastIndexOf('\\');
	var pos  = Math.max(pos1, pos2)
	if( pos<0 ){
		return path;
	} else {
		var name = path.substring(pos+1);
		return name;
	}
}



/**
 * 定时器
 */
function timeOut(){
	var length =0;
	the_timeout = setInterval(function progress(){
		length += Math.floor(Math.random()*35);
		if(length >= 100){
			clearInterval(the_timeout);
			length = 99;
		}
		$('#progress').css('width', length);
	},1000);
}

function getNames(){
	$("li[class='name']").each(function(){
		var name = $(this).text();
		names.push(name);
	});
}