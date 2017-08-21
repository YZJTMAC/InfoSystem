/**
 * 校验数据
 */

function importTeachers(){
	$("#showLoading").css('display','block'); 
	$("#checkDataBtn").attr("disabled",true);
	getNames();
	var url = pathHeader + "/edupm/teachermanage/importTeacher.do";
	$.ajax({
		url:url,
		data:{path:$("#savePath").val()},
		async:false,
		success:function(data){
			if(data.success){
				$("#second").hide();
				$("#third").show();
				var db = data.toDB;
				var exl = data.toExl;
				var toDB = "";
				var toExl = "";
				$("#toDB").html(toDB);
				$("#toExl").html(toExl);
				if(db.length>0){
					$("#submitD").attr("disabled",false);
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
					$("#toExlPath").val(exl[0].substring(0,exl[0].lastIndexOf("/")));
					$("#downZip").show();
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
			}
			$("#checkDataBtn").attr("disabled",false);
		},
		error:function(){
			$("#checkDataBtn").attr("disabled",false);
			jQuery.generalAlert("url error!");
		}
	});
}
function download(){	
	$("#downIframe", document.body).attr("src",pathHeader + "/edupm/teachermanage/downTeachersTemplate.do");
}

function showTip(){
	$(".tip").show();
}

/**
 * 提交数据
 */
function submitData(){
	$("#showLoadingSubmit").css('display','block'); 
	var url = pathHeader + "/edupm/teachermanage/importTeacherStep4.do";
	$.ajax({
		url:url,
		data:{path:$("#toDBPath").val(),names:names.toString(),toExlPath:$("#toExlPath").val()},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				$("#third").hide();
				$("#four").show();
				$("#total").html("恭喜您，已成功导入了"+data.total+"条教师数据。");
				names.length = 0;
			}
			else{
				jQuery.generalAlert(data.errMsg);
			}
		},
		error:function(){
			jQuery.generalAlert("url error!");
		}
		
	});
}

function downZip(){
	var url = pathHeader + "/edupm/teachermanage/downZip.htm?path="+$("#toExlPath").val();
	window.open(url);
//	$.ajax({
//		url:url,
//		data:{path:$("#toDBPath").val()},
//		type:"post",
//		async:true,
//		success:function(data){
//			
//		},
//		error:function(){
//			
//		}
//		
//	});
}