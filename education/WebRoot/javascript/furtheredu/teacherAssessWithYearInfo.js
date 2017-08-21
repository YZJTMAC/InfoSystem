$(function() {
	showTeacherAssessInfo();

	// 条件查询
	$("#select").click(function() {
		$('#SZ').html("");
		year=$("#startYear").val();
		showTeacherAssessInfo();
	});
});

function goback() {
	var openUrl = toUrlById(click);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}

function showTeacherAssessInfo() {
	$('#proTeacher_list').html('');
	$
			.ajax( {
				url : pathHeader + '/furtheredu/edumanage/queryTeacherAssessInfo.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					year : year
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						var gidHtmlNoT = "";
						$.each(objList, function(index, element) {
							gridHtml += getTdHtml(element);
						});
						$('#proTeacher_list').append(gridHtml);
						$.each(data.rows3, function(index, element) {
							gidHtmlNoT += getTdHtml(element);
						});
						if(gidHtmlNoT.length >0){
							$('#proTeacher_list').append(gidHtmlNoT);
						}
						var objList1 = data.rows1;
						var ulHtmlPr="";
						var ulHtmlCi="";
						var ulHtmlDi="";
						var ulHtmlSh="";
						$.each(objList1, function(index, element) {
							//"+obj.provinceName+"、"+obj.cityName+"、"+obj.districtName+"、"+obj.schoolName+"
							if(element.provinceName!=null && element.provinceName.toString().length>0
								&& (element.cityName==null || element.cityName.toString().length==0)
								&& (element.districtName==null || element.districtName.toString().length==0)
								&& (element.schoolName==null || element.schoolName.toString().length==0)
							){
								ulHtmlPr = getUlHtmlPr(element);
							}
							
							else if(element.provinceName!=null && element.provinceName.toString().length>0
								&& (element.cityName!=null && element.cityName.toString().length>0)
								&& (element.districtName==null || element.districtName.toString().length==0)
								&& (element.schoolName==null || element.schoolName.toString().length==0)
							){
								if(ulHtmlPr.length>0){
									ulHtmlCi = getUlHtmlCi(element,"1");
								}else{
									ulHtmlCi = getUlHtmlCi(element,"0");
								}
								
							}
							
							else if(element.provinceName!=null && element.provinceName.toString().length>0
								&& (element.cityName!=null && element.cityName.toString().length>0)
								&& (element.districtName!=null && element.districtName.toString().length>0)
								&& (element.schoolName==null || element.schoolName.toString().length==0)
							){
								if(ulHtmlCi.length>0 || ulHtmlPr.length>0){
									ulHtmlDi = getUlHtmlDi(element,"1");
								}else{
									ulHtmlDi = getUlHtmlDi(element,"0");
								}
								
							}
							
							else if(element.provinceName!=null && element.provinceName.toString().length>0
								&& (element.cityName!=null && element.cityName.toString().length>0)
								&& (element.districtName!=null && element.districtName.toString().length>0)
								&& (element.schoolName!=null && element.schoolName.toString().length>0)
							){
								if(ulHtmlCi.length>0 || ulHtmlPr.length>0 || ulHtmlDi.length>0){
								 	ulHtmlSh = getUlHtmlSh(element,"1");
								}else{
									ulHtmlSh = getUlHtmlSh(element,"0");
								}
							}
							
						});
						
						$('#SZ').html(ulHtmlPr+ulHtmlCi+ulHtmlDi+ulHtmlSh);

					} else {
						gridHtml = "<tr><td align='center' colspan='8'>暂无查询结果！</td></tr>";
						$('#proTeacher_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='8'>暂无查询结果！</td></tr>";
					$('#proTeacher_list').append(gridHtml);
				}
			});
}

function getTdHtml(obj) {
    var startDate = new Date(obj.startDate).format("yyyy-MM-dd");
	var endDate = new Date(obj.endDate).format("yyyy-MM-dd");
	var gridHtml = "<tr>";
	gridHtml += "<td>" + obj.projectNo + "</td>";
	gridHtml += "<td>" + obj.projectName + "</td>";
	gridHtml += "<td>" + startDate + "至<br/>" + endDate + "</td>";
	gridHtml += "<td>" + (obj.teacherScore==null?0:obj.teacherScore) + "</td>";
//	gridHtml += "<td>" + obj.subjectName + "</td>";
//	if (obj.teacherTrainStatusName != null) {
//		if (obj.teacherTrainStatusName.toString() == "合格") {
//			gridHtml += "<td>合格</td>";
//		} else {
//			gridHtml += "<td><i>不合格</i></td>";
//		}
//	} else {
//		gridHtml += "<td></td>";
//	}
//	gridHtml += "<td>" + (obj.teacherClassPeriod!=null?obj.teacherClassPeriod:0) + "学时</td>";
	gridHtml += "<td>" + (obj.teacherClassScore!=null?obj.teacherClassScore:0) + "学分</td>";
	gridHtml += "<td>"+(obj.teacherScoreAuditStatusName==null?'-':obj.teacherScoreAuditStatusName)+"</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function getUlHtmlPr(obj){
	var ulHtml="<ul class=\"seachform\" style=\"padding-left: 23px;\">\n";
	ulHtml+="<li>考核设定所在区：</li>\n";
	ulHtml+="<li>"+obj.provinceName+"</li>\n";
	ulHtml+="<li>考核要求：</li>\n";
	ulHtml+="<li>[总学时/学分要求]"+obj.classPeriod+"学时/"+obj.classScore+"学分</li>\n</ul>"
	return ulHtml;
}

function getUlHtmlCi(obj,lx){
	var color="";
	if(lx=="1"){
		color="style='color: #fff;'";
	}
	var ulHtml="<ul class=\"seachform\" style=\"padding-left: 23px;\">\n";
	ulHtml+="<li "+color+">考核设定所在区：</li>\n";
	ulHtml+="<li>"+obj.provinceName+"、"+obj.cityName+"</li>\n";
	ulHtml+="<li>考核要求：</li>\n";
	ulHtml+="<li>[总学时/学分要求]"+obj.classPeriod+"学时/"+obj.classScore+"学分</li>\n</ul>"
	return ulHtml;
}

function getUlHtmlDi(obj,lx){
	var color="";
	if(lx=="1"){
		color="style='color: #fff;'";
	}
	var ulHtml="<ul class=\"seachform\" style=\"padding-left: 23px;\">\n";
	ulHtml+="<li "+color+">考核设定所在区：</li>\n";
	ulHtml+="<li>"+obj.provinceName+"、"+obj.cityName+"、"+obj.districtName+"</li>\n";
	ulHtml+="<li>考核要求：</li>\n";
	ulHtml+="<li>[总学时/学分要求]"+obj.classPeriod+"学时/"+obj.classScore+"学分</li>\n</ul>"
	return ulHtml;
}

function getUlHtmlSh(obj,lx){
	var color="";
	if(lx=="1"){
		color="style='color: #fff;'";
	}
	var ulHtml="<ul class=\"seachform\" style=\"padding-left: 23px;\">\n";
	ulHtml+="<li "+color+">考核设定所在区：</li>\n";
	ulHtml+="<li>"+obj.provinceName+"、"+obj.cityName+"、"+obj.districtName+"、"+obj.schoolName+"</li>\n";
	ulHtml+="<li>考核要求：</li>\n";
	ulHtml+="<li>[总学时/学分要求]"+obj.classPeriod+"学时/"+obj.classScore+"学分</li>\n</ul>"
	return ulHtml;
}
