$(function() {

	// 条件查询
	$("#select").click(function() {
		showMobilizeAddList();
	});
	
	$(".sure").click(function() {
		if($("#mobilizeMark").val()==""){
			$("#msgs").html("请填写操作说明！");
			return false;
		}else{
			$("#msgs").html("");
		}
		
		$.post(pathHeader + "/teacher/teachermanage/teacherRetirees.do",
		  {
		    teacherId:$("#teacherId").val(),
		    mobilizeMark:$("#mobilizeMark").val(),
		    changeType:$("#changeType").val()
		  },
		  function(data,status){
			  if(data.success) {
			  	  window.location.href =  $("#goto").attr("href");
			  } else {
				  if(data.msgcode == -1) {
					  jQuery.generalAlert("该用户已经处于离退休状态！");
				  }
			  }
		  });

	});
	
	
})

/*function clearPCD() {
	$('#schoolProvinceId').val("");
	$('#schoolCityId').val("");
	$('#schoolDistrictId').val("");
	$('#schoolId2').val("");
	$('#tss').val("");
}

function lastForSure() {
	var str = "";
	var tempArray = chilkQueryConditionArray;
	$(tempArray).each(function(index, element) {
		if (element != null && element.length > 0) {
			var temp = element.split("_");
			if (temp[1] == "provinceId") {
				$("#schoolProvinceId").val(temp[0]);
				str = temp[2];
			} else if (temp[1] == "cityId") {
				$("#schoolCityId").val(temp[0]);
				str += "—" + temp[2];
			} else if (temp[1] == "districtId") {
				$("#schoolDistrictId").val(temp[0]);
				str += "—" + temp[2];
			} else if (temp[1] == "schoolId") {
				if (temp[0] != undefined) {
					$("#schoolId2").val(temp[0]);
				}
				str += "—" + temp[2];
			}

		}
	})

	$('#tss').val(str);

	clear();
}*/

function showMobilizeAddList() {
	if ($('#realName').val() == "" && $('#idNumber').val() == "") {
		$("#msg").html("请输入教师姓名或身份证号！");
		return false;
	} else {
		$("#msg").html("");
	}
	$('#proTeacher_list').html('');
	var pageIndex = $("#pageIndex").val();
	var sizePerPage = $("#sizePerPage").val();
	$
			.ajax( {
				url : pathHeader + '/teacher/teachermanage/queryCreateMobilize.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					retiress : $('#retiress').val(),
					realName : $('#realName').val(),
					idNumber : $('#idNumber').val()
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});
						if (gridHtml.length == 0) {
							gridHtml = "<dl class=\"teacherdlxinxi\" style='text-align:center'>暂无查询结果！</dl>";
						}
						$('#proTeacher_list').append(gridHtml);

						$(".tiptop2 a").click(function() {
							$(".tip2").fadeOut(200);
						});

//						$(".sure").click(function() {
//							$(".tip2").fadeOut(100);
//						});

						$(".cancel").click(function() {
							$(".tip2").fadeOut(100);
						});

					} else {
						gridHtml = "<dl class=\"teacherdlxinxi\" style='text-align:center'>暂无查询结果！</dl>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<dl class=\"teacherdlxinxi\" style='text-align:center'>暂无查询结果！</dl>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
	var gridHtml = "<dl class=\"teacherdlxinxi\"><dt style='height: 190px;'>";
//	gridHtml += "<img src=\"" + imageServer 
//			+ obj.userImageUrl + "\" title=\"头像\" />";
	if( obj.userImageUrl == null || obj.userImageUrl == "" || obj.userImageUrl.length == 0){
		gridHtml += "<img src='"+ pathHeader+ "/images/u8_normal.jpg' style='width:71px;height:99px' title='头像120×120'>";
	} else {
		gridHtml += "<img src='"+ imageServer+ obj.userImageUrl +"' style='width:71px;height:99px' title='头像120×120'>";
	}
	gridHtml += "</dt><dd  ><span class=\"titlewidth\">姓名：</span><span>"
			+ obj.realName + "</span></dd>";
	gridHtml += "<dd>";
	gridHtml += "<span class=\"titlewidth\">教师编制：</span><span style='overflow: hidden;'>"
	gridHtml +=  obj.adjustName + "</span></dd>";
		gridHtml += "<dd>";
	gridHtml += "<span class=\"titlewidth\">在职状态：</span><span style='overflow: hidden;'>"
	gridHtml += "在职</span></dd>";
	gridHtml += "<dd><span class=\"titlewidth\">身份证号：</span><span>" + obj.idNumber
			+ "</span>";
	gridHtml += "</dd><dd >";
	gridHtml += "<span class=\"titlewidth\" >教师资格证书号：</span><span>"
			+ obj.jobCertificateNum + "</span>";
	gridHtml += "</dd><dd  >";
	gridHtml += "<span class=\"titlewidth\">原地区：</span><span style='overflow: hidden;width: 160px;'>"
			+ obj.userProvinceName
			+ "-"
			//+ obj.userCityName
			//+ obj.userDistrictName
			+ obj.schoolName + "</span>"
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">(评)教师职称：</span><span>"
			+ obj.jobCommentPosition + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">(聘)教师职称：</span><span>"
			+ obj.jobRecruitmentPosition + "</span>";
	gridHtml += "</dd><dd  >";
	gridHtml += "<span class=\"titlewidth\" >学校行政职务：</span><span>"
			+ obj.jobSchoolAdministrationOffice + "</span>";
	gridHtml += "</dd>";
	gridHtml += "<dd><span class=\"titlewidth\">任教学段/学科：</span><span>"
			+ obj.jobFormerTeachingSubject + "</span>";
	gridHtml += "</dd>";
	gridHtml += "<dd><span class=\"titlewidth\">是否为骨干教师：</span><span>"
			+ obj.jobCoreTeacher + "</span>";
	gridHtml += "</dd><dd  >";
	gridHtml += "<span class=\"titlewidth\">是否为班主任：</span><span>"
			+ obj.jobWhetherTeacher + "</span>";
	gridHtml += "</dd><dd>";
	gridHtml += "<span class=\"titlewidth\">国培计划农村骨干教师：</span><span>"
			+ obj.jobCountyRuralTeacher + "</span>";
	gridHtml += "</dd><dd class=\"tohaid1\"><span></span></dd>";
	gridHtml += "<dd></dd>";
	gridHtml += "<dd class=\"tohaid1\">";
	gridHtml += "<table width=\"100%\"><tr><td align=\"left\">";
	gridHtml += "<div>";
	var str = (obj.userProvinceName + "—" + obj.userCityName + "—"
			+ obj.userDistrictName + "—" + obj.schoolName);

	gridHtml += "<input type=\"button\" onclick='addMobilize(\""+ obj.id+ "\");' class=\"btn click\" value=\"发起\" />";
	gridHtml += "</div></td></tr></table></dd></dl>";
	return gridHtml;
}

function addMobilize(teacherId) {
	$(".tip2").fadeIn(200);
	$("#teacherId").val(teacherId);
}

 