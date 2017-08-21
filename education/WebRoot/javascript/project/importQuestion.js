/**
 * 校验数据
 */

function checkData() {
	getNames()
	var url = pathHeader + "/edupm/paper/checkUploadPaperQuestion.do";
	$.ajax( {
		url : url,
		data:{path:$("#savePath").val(),paperId:pId},
		async : false,
		success : function(data) {
			if (data.success) {
				$("#second").hide();
				$("#third").show();
				var db = data.toDB;
				var exl = data.toExl;
				var toDB = "";
				var toExl = "";
				$("#toDB").html(toDB);
				$("#toExl").html(toExl);
				if (db.length > 0 ) {
					$("#submitD").show();
					$("#toDBPath").val(
							db[0].substring(0, db[0].lastIndexOf("/")));
					for ( var i = 0; i < db.length; i++) {
						var str = db[i].split(":");
						var size = str[1];
						var name = str[0];
						toDB += "<ol class='fileol'>";
						toDB += "<li><img src='" + pathHeader
								+ "/images/iconfile_ok.png'/></li>";
						toDB += "<li>" + names[i] + "</li>";
						toDB += "<li>数据正常</li>";
						toDB += "</ol>"
					}
					$("#toDB").html(toDB);
				}
				if (exl.length > 0) {
					for ( var i = 0; i < exl.length; i++) {
						var str = exl[i].split(":");
						var size = str[1];
						var name = str[0];
						toExl += "<ol class='fileol'>";
						toExl += "<li><img src='" + pathHeader
								+ "/images/iconfile_x.png'/></li>";
						toExl += "<li>" + names[i] + "</li>";
						toExl += "<li class='txtred'>" + size + "条数据异常</li>";
						toExl += "<li><a href='javascript:dataDetail(\""+name+"\");'>查看异常</a></li>";
						toExl += "</ol>"
					}
					$("#toExl").html(toExl);
					$("#toExlPath").val(exl[0].substring(0,exl[0].lastIndexOf("/")));
					$("#downZip").show();
				}
			} else {
				$(".tip1").fadeIn(200);
				$("#msgHtml").html("检查数据发生错误，请稍后重试！")
				$(".sure1").click(function() {
					toPage(0)
				});
			}
		},
		error : function() {
			$(".tip1").fadeIn(200);
			$("#msgHtml").html("检查数据发生错误，请稍后重试！")
			$(".sure1").click(function() {
				toPage(0)
			});
		}
	});
}
function download() {
	/*var url = pathHeader + "/template/" + fileName;
	window.open(url);*/
	
	$("#downIframe", document.body).attr("src",pathHeader + "/edupm/paper/downPaperQuestion.do");
}

/**
 * 提交数据
 */
function submitData() {
	$("#showLoadingSubmit").css('display','block');
	$('#myModal').modal('show');
	var url = pathHeader + "/edupm/paper/submitUploadPaperQuestion.do";
	$.ajax( {
		url : url,
		data : {
			path : $("#toDBPath").val(),paperId:pId
		},
		type : "post",
		async : true,
		success : function(data) {
			if (data.success) {
				$("#third").hide();
				$("#four").show();
				$("#total").html("恭喜您，已成功导入了" + data.total + "条数据。");
				$("#showLoadingSubmit").css('display','none');
				$('#myModal').modal('hide');
			} else {
				$(".tip1").fadeIn(200);
				$("#msgHtml").html("导入失败！")
				$(".sure1").click(function() {
					toPage(0);
				});
			}
		},
		error : function() {
			$('#myModal').modal('hide');
			$(".tip1").fadeIn(200);
			$("#msgHtml").html("导入失败！")
			$(".sure1").click(function() {
				toPage(0)
			});
		}

	});
}

function toPage(lx) {
	if (lx == 1) {
		window.location.href = pathHeader + "";
	} else {
		$(".tip1").fadeOut(100);
	}
}

function downZip() {
	var url = pathHeader + "/edupm/teachermanage/downZip.htm?path="
			+ $("#toExlPath").val();
	window.open(url);
}