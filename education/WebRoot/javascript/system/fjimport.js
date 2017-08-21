function fjimport(){
	getNames();
	$("#showLoading").css('display','block');
	var url = pathHeader + "/sys/fjimport.do";
	$.ajax({
		url:url,
		data:{path:$("#savePath").val(),
			type:"fjimport"
		},
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
					$("#submitD").show();
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
		},
		error:function(){
			
		}
	});
}

function download(fileName){
	/*var url = pathHeader +"/template/"+fileName;
	window.open(url);
	*/
	
	$("#downIframe", document.body).attr("src",pathHeader + "/sys/downFjTemplate.do");

}

/**
 * 提交数据
 */
function submitData(){
	$("#showLoadingSubmit").css('display','block');
	$('#myModal').modal('show');
	var url = pathHeader + "/sys/importFJ4.do";
	$.ajax({
		url:url,
		data:{path:$("#toDBPath").val(),
			type:"fjimport"
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				$("#third").hide();
				$("#four").show();
				$("#total").html("恭喜您，已成功导入了"+data.total+"条机构数据。");
			}
			$("#showLoadingSubmit").css('display','none');
			$('#myModal').modal('hide');
		},
		error:function(){
			$('#myModal').modal('hide');
		}
		
	});
}

function downZip(){
	var url = pathHeader + "/edupm/teachermanage/downZip.htm?path="+$("#toExlPath").val();
	window.open(url);
}

function stilImport() {
	var url  = pathHeader + "/sys/fjimport.htm";
	window.location.href = url;
}

function backImport() {
	var url = pathHeader + "/sys/fjimportHistory.htm?click=99";
	window.location.href = url;
}