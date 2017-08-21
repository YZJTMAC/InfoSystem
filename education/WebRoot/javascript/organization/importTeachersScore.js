/**
 * 模版下载
 */
function downTemplate(){
	$("#downIframe",document.body).attr("src",pathHeader + "/template/upload_score.xls");
}


/**
 * 校验数据
 */
function testData(){
	getNames();
	
	$.ajax({
		url:pathHeader + "/org/testData.do",
		type:"POST",
		cache:"false",
		async:false,
		data : {'projectId':projectId, path:$("#savePath").val()},
		success:function(data){
			if(data.success){
				// 隐藏第二步div, 显示第三步div
				$('#second').hide();
				$('#third').show();
				var db = data.toDB;
				var exl = data.toExl;
				var toDB = "";
				var toExl = "";
				$("#toDB").html(toDB);
				$("#toExl").html(toExl);
				if(db.length>0){
					$("#toDBPath").val(db[0].substring(0,db[0].lastIndexOf("/")));
					for(var i = 0;i<db.length;i++){
						var str = db[i].split(":");
						var size = str[1];
						var name = str[0];
							toDB += "<ol class='fileol'>";
							toDB += "<li><img src='"+pathHeader+"/images/iconfile_ok.png'/></li>";
							toDB += "<li>"+names[i]+"</li>";
							toDB += "<li>数据正常</li>";
							toDB += "</ol>"
					}
					$("#toDB").html(toDB);
				}
				if(exl.length>0){
					for(var i = 0;i<exl.length;i++){
						var str = exl[i].split(":");
						var size = str[1];
						var name = str[0];
							toExl += "<ol class='fileol'>";
							toExl += "<li><img src='"+pathHeader+"/images/iconfile_x.png'/></li>";
							toExl += "<li>"+names[i]+"</li>";
							toExl += "<li class='txtred'>"+size+"条数据异常</li>";
							toExl += "<li><a href='javascript:dataDetail(\""+name+"\");'>查看异常</a></li>";
							toExl += "</ol>"
					}
					$("#toExl").html(toExl);
				}
			} else {
				jQuery.generalAlert("检测失败!");
			}
		},
		error:function(){
			jQuery.generalAlert("检测失败!");
		}
	});
}


/**
 * 查看异常
 * @param {Object} fileName
 */
function download(fileName){
	var url = pathHeader +"/template/"+fileName;
	window.open(url);
}


/**
 * 合并下载
 */
function downZip(){
	var url = pathHeader + "/edupm/teachermanage/downZip.htm?path="+$("#toDBPath").val();
	window.open(url);
}


/**
 * 提交数据
 */
function submitData(){
	var url = pathHeader + "/org/importTeachersScore.do";
	$.ajax({
		url:url,
		data:{'path':$("#toDBPath").val(), 'projectId':projectId},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				// 隐藏第三步div, 显示第四步div
				$("#third").hide();
				$("#four").show();
				$("#total").html("恭喜您，已成功导入了"+data.total+"条教师成绩数据。");
			}
		},
		error:function(){
			
		}
		
	});
}


/**
 * 继续导入
 */
function importAgain(){
	var url = pathHeader + "/edupm/teachermanage/toImportTeacherScorePage.htm?click=4&projectId="+projectId;
	window.open(url);
}