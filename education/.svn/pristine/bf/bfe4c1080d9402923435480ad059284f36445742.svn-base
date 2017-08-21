
//添加文件
function addMore(){
	var tr = '<tr class="addMore"><td>' +
			 '<input type="file" id="file" onchange="uploadFile();" name="file"/> ' +
			 '</td><td><img id="loading" src="'+pathHeader+'/static/photo/loading.gif" style="display:none;">'+
			 '<span id="progress" style="color:green;"></span></td> ' +
			 '<td><a href="###" onclick="removeMe(this)">删除</a></td></tr>';
	$("#noUpload").html(tr);
}

//文件上传(项目申报,提交培训材料,项目过程管理,培训总结,项目总结报告)
function uploadFile(){
	$("#progress").html("");
	var pid = $("#projectId").val();
	var pname = $("#projectName3").val();
	var type = $("#type").val();
	var files = $("input[name='file']");
	if(files==null || files.length ==0 || files[0].value == ""){
		jQuery.generalAlert("请上传相关文件！");
		return ;
	}
	for(var i = 0;i<files.length;i++){
		var name = files[i].value.toString();
		var ext = name.substring(name.lastIndexOf('.')+1,name.length);
		if(ext=="jsp" || ext == "exe"){
			jQuery.generalAlert("上传文件格式非法！请重新上传！");
			return ;
		}
	}
	
	$("#loading")
	.ajaxStart(function(){
		$(this).show();
	})
	.ajaxComplete(function(){
		$(this).hide();
	});
	
	$.ajaxFileUpload({
        url : pathHeader + "/fileupload/saveFiles.do",
        fileElementId:'file',  //文件选择框的id属性（必须）
        dataType: 'json',  
        type:'post',
        data : {type: type,projectId : pid,projectName : pname},
		success:function(data){
			var table="";
			if(data.success){
				var item = data.file;
				table += "<tr><td>"
					+ (data.fileNum+1)
					+ "</td><td>"
					+ item.name
					+ "</td><td>"
					+ item.userName
					+ "</td><td>"
					+ nullFormatter(item.createDate.replace(".0",""))
					+ "</td><td>"
					+ "<a href='#' onclick=downloadFile('"
					+ item.url
					+ "') >下载 </a></td>"
					+ "<td><a href='#' onclick= removeFile('"
					+ item.id + "','" + item.url
					+ "','"
					+ item.projectId
					+ "') >删除 </a>" + "</td></tr>";
			
				$("#hasUpload").append(table);
				//$("#progress").html((item.pBytesRead / item.pContentLength *100 ).toFixed(2) + "%");
				$("#progress").html(item.name+" 文件上传成功     " + data.progress + "%");
			} else if(data.msg == "-1"){
				$("#progress").html(data.uploadSizeExceeded);
			}else if(data.msg == "-2"){
				$("#progress").html(data.notParseRequest);
			} else {
				$("#progress").html(data.info);
			}
		},
		error:function(){
			$("#progress").html("上传失败,文件大小不能超出30M!");
		}
	});
}

//查看文件
function previewFile(fileUrl){
	var url = pathHeader+ "/fileupload/isFileExist.do";
	$.ajax({
		url:url,
		data:{fileUrl:fileUrl},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				window.open(pathHeader +"/"+ fileUrl,'文件预览',"height=450, width=680, top=120, left=350,toolbar=no, menubar=no, scrollbars=no, resizable=no, location=n o, status=no");
				//var openUrl = pathHeader +"/"+ fileUrl;
				openFileUrl(openUrl);
			}else{
				alert("文件不存在！");
			}
		},
		error:function(){
			alert("error！");
		}
	});
}
function openFileUrl(url){
    var a = document.createElement("a");
    a.setAttribute("href", url);
    a.setAttribute("target", "_blank");
    a.setAttribute("id", "openwin");
    document.body.appendChild(a);
    a.click();
}
//删除文件
function removeMe(o){
	$(o).parent().parent().remove();
	//$("#addFile").attr("disabled",false);
	//$("#addFile").show();
}
function nullFormatter(obj){
	if(obj==null || obj=='null' || obj.length==0){
		return '';
	} else {
		return obj;
	}
}

function downLoadPDFReader(){
	var filePathName="tool/PDFReader.rar";
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