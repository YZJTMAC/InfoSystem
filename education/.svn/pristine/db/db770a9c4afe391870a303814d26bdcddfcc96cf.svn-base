$(function(){
	initAutoComplete();
});

// 筛选条件数组
var queryConditionArray = [];

/**
 * 最后确认, 个开发人 自己实现
 */
function lastForSure() {
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var areaA = conditionArray[1]
		var text = conditionArray[2]
		$('#areaName').val(text);
		queryConditionArray[9] = areaA+"_" + belone;
	}
	$(".deleteCondition").parent().parent().remove();
	//重新生成查询条件
	showQueryCondition();
	showInfoList();
	
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}


/**
 * 初始化
 */
function initAutoComplete(){
	
	queryDic('stduty_section', 'stdutySection');  //学段
	
//	queryDic('project_subject', 'stdutySubject');
	
	queryEducationalDic('educational_user');  //最低/最高学历
	
	queryDicA('xkdtr_type', 'subjectLeader');	//学科带头人
	queryDicA('ggjs_type', 'coreTeacher');		//骨干教师
	
	queryDicA('gwlb_type', 'gwlb');  //岗位类别
	queryDicA('gwdj_type', 'gwdj');  //岗位等级
	
	queryJobPositionDic('teacher_professional');  //(评)/(聘)教师职称
	
	$("#chk_all").click(function(){
     $("input[name='chk_list']").attr("checked",$(this).attr("checked"));
	});
	
	$("#pageSize").change(function(){
		showInfoList();
	});
	
	$("#chk_all").click(function(){
     $("input[name='chk_list']").attr("checked",$(this).attr("checked"));
	});
	
	$(".batchAudit").click(function(){
		var arrChk=$("input[name='chk_list']:checked");
		if(arrChk == null || arrChk == "" || arrChk.length <=0) {
			jQuery.generalAlert("请选择要审核的信息");
			return;
		}
  		$(".tip").fadeIn(200);
  	});
	
	//批量删除
	$(".batchDelete").click(function(){
		
  		var arrChk=$("input[name='chk_list']:checked");
		var idStr = "";
    	$(arrChk).each(function(){
    		var option = $('#' + this.value + '_batchOption').val();
    		//判断是否有审核权限
       		if(option.indexOf('r') > 0) {
	       		idStr += this.value + ",";
       		}
    	});
    	idStr = idStr.substring(0,idStr.length -1);
    	teacherDelete(idStr)
  	});

	$(".tiptop a").click(function() {
		$(".tip11").fadeOut(200);
		$(".tip").fadeOut(200);
	});

	//批量提交审核
	$(".sure").click(function() {
		var arrChk=$("input[name='chk_list']:checked");
		var idStr = "";
    	$(arrChk).each(function(){
    		var option = $('#' + this.value + '_batchOption').val();
    		//判断是否有审核权限
       		if(option.indexOf('h') > 0) {
	       		idStr += this.value + ",";
       		}
    	});
    	idStr = idStr.substring(0,idStr.length -1);
    	teacherAudit(idStr)
		$(".tip").fadeOut(100);
	});

	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});
	
	// 筛选条件 点击事件
	$(":radio").live("click",function(){
		if($(this).attr("class") == 'no') return; 
		//筛选属性查询
		queryConditionArray[$(this).attr("id")] = $(this).attr("name") + "_" + $(this).val();
		
		//选择学段时，已选的学科需要清除
		if($(this).attr("id") == 7){
			queryConditionArray[8] = null;
		}
		
		//清空条件
		$(".deleteCondition").parent().parent().remove();
		//重新生成查询条件
		showQueryCondition();
		showInfoList();
	});
	
	//筛选时间事件
	$(".Wdate").click(function(){
		WdatePicker({
			//选中事件
			onpicking:function(dp){
				//筛选属性查询
				queryConditionArray[$(this).attr("id")] = $(this).attr("name") + "_" + dp.cal.getNewDateStr();
				
				//清空条件
				$(".deleteCondition").parent().parent().remove();
				//重新生成查询条件
				showQueryCondition();
				showInfoList();
			},
			//清空事件
			onclearing:function(dp){
		  		queryConditionArray[$(this).attr("id")] = null;
		  		
		  		$(".deleteCondition").parent().parent().remove();
		  		//重新生成查询条件
				showQueryCondition();
				
		  		showInfoList();
			}
		});
	});
	
	// 清空已筛选条件
	$(".tablelink").click(function() {
		queryConditionArray = [];
		$(".deleteCondition").parent().parent().remove();
		showInfoList();
	});
	
	// 已筛选条件 单个清楚
	$(".deleteCondition").live("click",function(){
  		$(this).parent().parent().remove();
  		queryConditionArray[$(this).attr("id")] = null;
  		showInfoList();
	});
//	$(".schoolclick").live("click",function(){
//	});

	$(".more").click(function() {
		$('.moreChoose').toggle();
	});
	
	lastForSure();
}



// 查询学校
/*function querySchoolByCondition(){
	var url = pathHeader +"/sys/querySchool.do";
 
	$.ajax({
		url:url,
		data:{
		},
		type:"post",
		async:true,
		success:function(data){
			if(data.success) {
				var obj = data.rows;
				var flag = 1;
				var gridHtml = "";
				$.each(obj, function(index,element) {
					if(flag == 1) {
						gridHtml += "<tr>";
					} 
						gridHtml += "<td><a href='###' class='schoolclick' title='"+element.schoolProvinceName+"_"+ element.schoolCityName +"_"+element.schoolDistrictName+"'>"+element.schoolName+"</a></td>";
					if(flag ==3) {
						gridHtml += "</tr>";
						flag = 1;
						return true;
					}
					flag ++;
				});
				if(flag == 2) {
					gridHtml += "<td></td><td></td></tr>";
				} else if(flag == 3) {
					gridHtml += "<td></td></tr>";
				}
				$("#schoolList").html(gridHtml);
			}
		},
		error:function(){
			
		}
	});
}*/

//展现筛选查询
function showQueryCondition() {
	for(var i = 0 ; i < queryConditionArray.length; i++) {
		if(queryConditionArray[i] != null && queryConditionArray[i] != "" && queryConditionArray[i].length > 0) {
			var id = i;
			var value = queryConditionArray[i].substring(queryConditionArray[i].indexOf('_')+1);
			spellQueryCondition(id, value);
		}
	}
}

function spellQueryCondition(id, value) {
	var logicStr = "";
		var text = "";
		if(id == 0 ) {
			text = "性别：";
			logicStr = value == 1 ? '男':'女';
			text =  text + logicStr;
		} else 	if(id >0 && id < 6 ) {
			logicStr = value == 1 ? '是':'非';
			text = $('#queryTitle_' + id).text() ;
			text = logicStr +　text;
		} else if(id == 6) {
			text = "在职状态：";
			if(value == 6) 
				logicStr = "未审核";
			if(value == 7) 
				logicStr = "审核不通过";
			if(value == 8) 
				logicStr = "在职";
			if(value == 31) 
				logicStr = "已退休";
			if(value == 32) 
				logicStr = "已死亡";
			if(value == 33) 
				logicStr = "已离休";
			if(value == 34) 
				logicStr = "已离岗";
			if(value == 35) 
				logicStr = "已病休";
			text =  text + logicStr;
		} else if(id == 7) {
			text = "学段：" + stdutySectionArray[value];
		} else if(id == 8) {
			text = "学科：" + stdutySubjectArray[value];
		} else if( id == 9) {
			var conditionArray = lastSelect.split("_");
			text = "地区：" + conditionArray[2];
		}  else if( id == 10) {
			text = "最低学历：" + lowEducationArray[value];
		} else if( id == 11) {
			text = "年龄段：";
			logicStr = $("#age_" + value).text();
			text =  text + logicStr;
		} else if( id == 12) {
			text = "婚姻状况：";
			logicStr = (value == 1 ? '已婚':'未婚');
			text = text + logicStr ;
		} else if( id == 13) {
			text = "参加工作最低年限：";
			logicStr = $("#work_" + value).text();
			text =  text + logicStr;
		} else if( id == 14) {
			if(subjectLeaderArray[value]=='否'){
				text = "非" + $('#queryTitle_' + id).text();
			}else{
				text = $('#queryTitle_' + id).text() + "：" + subjectLeaderArray[value];
			}
		} else if( id == 15) {
			if(coreTeacherArray[value]=='否'){
				text = "非" + $('#queryTitle_' + id).text();
			}else{
				text = $('#queryTitle_' + id).text() + "：" + coreTeacherArray[value];
			}
		} else if( id == 16) {
			text = "最高学历：" + topEducationArray[value];
		} else if( id == 17) {
			text = "岗位类别：" + gwlbArray[value];
		} else if( id == 18) {
			text = "(评)教师职称：" + jobCommentPositionArray[value];
		} else if( id == 19) {
			text = "(聘)教师职称：" + jobRecruitmentPositionArray[value];
		} else if( id == 20) {
			text = "岗位等级：" + gwdjArray[value];
		} else if( id == 21) {
			text = "(评)职称时间：" + value;
		} else if( id == 22) {
			text = "(聘)职称时间：" + value;
		}  else if( id == 23) {
			text = "聘任岗位等级时间：" + value;
		}  else if( id == 24) {
			text = "本校任教起始时间：" + value;
		}  else if( id == 25) {
			text = "借调分流时间：" + value;
		}  else if( id == 26) {
			text = "离岗待退时间：" + value;
		}  else if( id == 27) {
			logicStr = value == 1 ? '是':'非';
			text = $('#queryTitle_' + id).text() ;
			text = logicStr + text;
		} 
		
	addQueryCondition(id, "", text);
}

function addQueryCondition(id, value, text) {
	var gridHtml = "<dd>";
	gridHtml += "<span><a href='###' class='deleteCondition' id='"+id+"' >";
	gridHtml += "<img src=  '"+pathHeader +"/images/closed.jpg' width='9' height='9' title='删除'/></a>";
	gridHtml += text;
	gridHtml += "</span></dd>";
	$('#addQueryCOndition').after(gridHtml);
}

// 学段 
var stdutySectionArray = [];

// 学科 
var stdutySubjectArray = [];

// 最低学历 
var lowEducationArray = [];

// 最高学历 
var topEducationArray = [];

// 学科带头人
var subjectLeaderArray = [];

// 骨干教师
var coreTeacherArray = [];

// 岗位类别
var gwlbArray = [];

// (评)教师职称
var jobCommentPositionArray = [];

// (聘)教师职称
var jobRecruitmentPositionArray = [];

// 岗位等级
var gwdjArray = [];

/**
 * 查询学科
 */
function qrySubject(sectionName,id){
	$(".deleteSubject").remove();
	var url = pathHeader + "/sys/querySubject.do";
	$.ajax({
		url:url,
		data:{ sectionName:sectionName},
		type:"post",
		async:false,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				if(rows.length > 0){
					var gridHtml = "";
					for(var i = 0;i<rows.length;i++){
						var obj = rows[i];
						gridHtml += "<dd class='deleteSubject'>";
						gridHtml += "<INPUT id='8' name='stdutySubject' value='"+obj.dictionaryId+"' type='radio' >";
						gridHtml += obj.dictionaryName;
						gridHtml += "</dd>";
						stdutySubjectArray[obj.dictionaryId] = obj.dictionaryName;
					}
					$("#stdutySubject").after(gridHtml);
				} else {
					$("#stdutySubject").after("<dd class='deleteSubject'>未查询出相关学科</dd>");
				}
			}
		},
		error:function(){
			
		}
	});
//	return flag;
}

//(评)/(聘)教师职称
function queryJobPositionDic(dicType){
	var url = pathHeader+ "/sys/queryDicByType.do";
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "", html = "";
				$.each(objList, function(index,element) {
					var r = index %4;
					if(r === 3){
						gridHtml += "</tr><tr>";
					}
					gridHtml += "<td><INPUT id='18'  name='jobCommentPosition' value='"+element.dictionaryId+"' type='radio' ></td>";
					gridHtml += "<td>";
					gridHtml += element.dictionaryName;
					gridHtml += "</td>";
					gridHtml += "<td width='40'>&nbsp;</td>";
					
					jobCommentPositionArray[element.dictionaryId] = element.dictionaryName;
				});
				$('#jobCommentPosition').html("<tr>"+gridHtml+"</tr>");
				
				$.each(objList, function(index,element) {
					var r = index %4;
					if(r === 3){
						html += "</tr><tr>";
					}
					html += "<td><INPUT id='19'  name='jobRecruitmentPosition' value='"+element.dictionaryId+"' type='radio' ></td>";
					html += "<td>";
					html += element.dictionaryName;
					html += "</td>";
					html += "<td width='40'>&nbsp;</td>";
					
					jobRecruitmentPositionArray[element.dictionaryId] = element.dictionaryName;
				});
				$('#jobRecruitmentPosition').html("<tr>"+html+"</tr>");
			}  
		},
		error:function(){
			
		}
	});
}

//最低/最高学历
function queryEducationalDic(dicType){
	var url = pathHeader+ "/sys/queryDicByType.do";
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "", html = "";
				$.each(objList, function(index,element) {
					var r = index %4;
					if(r === 3){
						gridHtml += "</tr><tr>";
					}
					gridHtml += "<td><INPUT id='10'  name='lowEducation' value='"+element.dictionaryId+"' type='radio' ></td>";
					gridHtml += "<td>";
					gridHtml += element.dictionaryName;
					gridHtml += "</td>";
					gridHtml += "<td width='40'>&nbsp;</td>";
					
					lowEducationArray[element.dictionaryId] = element.dictionaryName;
				});
				$('#lowEducationExperience').html("<tr>"+gridHtml+"</tr>");
				
				$.each(objList, function(index,element) {
					var r = index %4;
					if(r === 3){
						html += "</tr><tr>";
					}
					html += "<td><INPUT id='16'  name='topEducation' value='"+element.dictionaryId+"' type='radio' ></td>";
					html += "<td>";
					html += element.dictionaryName;
					html += "</td>";
					html += "<td width='40'>&nbsp;</td>";
					
					topEducationArray[element.dictionaryId] = element.dictionaryName;
				});
				$('#topEducationExperience').html("<tr>"+html+"</tr>");
			}  
		},
		error:function(){
			
		}
	});
}

function queryDicA(dicType, id){
	var url = pathHeader+ "/sys/queryDicByType.do";
	var vid = 0, name = '';
	if(id == 'subjectLeader') {//学科带头人
		vid = 14;
		name = 'subjectLeader';
	}else if(id == 'coreTeacher') {//骨干教师
		vid = 15;
		name = 'coreTeacher';
	}else if(id == 'gwlb') { //岗位类别
		vid = 17;
		name = 'gwlb';
	}else if(id == 'gwdj') { //岗位等级
		vid = 20;
		name = 'gwdj';
	}
	
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					var r = index %4;
					if(r === 3){
						gridHtml += "</tr><tr>";
					}
					gridHtml += "<td><INPUT id='"+ vid +"'  name='"+ name +"'  value='"+element.dictionaryId+"' type='radio' ></td>";
					gridHtml += "<td>";
					gridHtml += element.dictionaryName;
					gridHtml += "</td>";
					gridHtml += "<td width='40'>&nbsp;</td>";
					
					if(id == 'subjectLeader'){
						subjectLeaderArray[element.dictionaryId] = element.dictionaryName;
					}else if(id == 'coreTeacher'){
						coreTeacherArray[element.dictionaryId] = element.dictionaryName;
					}else if(id == 'gwlb'){
						gwlbArray[element.dictionaryId] = element.dictionaryName;
					}else if(id == 'gwdj'){
						gwdjArray[element.dictionaryId] = element.dictionaryName;
					}
					 
				});
				$('#' + id).html("<tr>"+gridHtml+"</tr>");
			}  
		},
		error:function(){
			
		}
	});
}

/**
 * 查询字典表(注意：目前仅支持查询学段)
 */
function queryDic(dicType, id){
	var url = pathHeader+ "/sys/queryDicByType.do";
	var vid = 0;
	if(id == 'stdutySection') {
		vid = 7;
	} else if(id == 'stdutySubject' ) {
		vid = 8;
	}

	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += "<dd>";
					gridHtml += "<INPUT id='"+vid+"'  name='"+id+"' onclick='qrySubject(\""+element.dictionaryCode+"\","+element.dictionaryId+")' value='"+element.dictionaryId+"' type='radio' >";
					gridHtml += element.dictionaryName;
					gridHtml += "</dd>";
					if(id == 'stdutySection') {
						stdutySectionArray[element.dictionaryId] = element.dictionaryName;
					} else if(id == 'stdutySubject' ) {
						stdutySubjectArray[element.dictionaryId] = element.dictionaryName;
					}
				});
				$('#' + id).after(gridHtml);
				$('#' + id).after('<div style="clear:both"></div>');
			} else {
			}
		},
		error:function(){
			
		}
	});
}


/**
 * 删除教师
 */
function teacherDelete(data) {
	if(data == null || data == "" || data.length <=0) {
		jQuery.generalAlert("请选择要删除的信息");
		return;
	}
	if(!confirm('确定要删除选中的教师吗？'))
			return false;
	$.ajax({
		url : pathHeader + "/teacher/teachermanage/removeTeacher.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{data:data},
		success:function(data){
			if(data.success) { 
				showInfoList();
			} else {
			}
		},
		error:function(){
		}
	});
}

/**
 * 审核教师
 */
function teacherAudit(data) {
	var auditTeacher = $('input:radio[name="auditTeacher"]:checked').val();
	
	$.ajax({
		url : pathHeader + "/teacher/teachermanage/auditTeacher.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{data:data, isPass:auditTeacher, memo:$("#memo").val()},
		success:function(data){
			if(data.success) {
				 showInfoList();
			} else {
				
			}
		},
		error:function(){
		}
	});
}

function showInfoList() {
	var sizePerPage = $("#pageSize").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/teacher/teachermanage/queryTeacherActivetyList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			queryConditionArray:$.toJSON(queryConditionArray),
			queryRealName:$('#queryRealName').val(),
			queryTeacherNo:$('#queryTeacherNo').val(),
			queryIdNumber:$('#queryIdNumber').val(),
			queryJdfldw: $('#queryJdfldw').val(),
			sizePerPage:sizePerPage, 
			pageIndex:pageIndex
		},
		beforeSend: function(){
			$('#teacherList').html("<tr><td align='center' colspan='8'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			if(data.success) {
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					indexFlag ++;
					gridHtml += getTdEHtml(element, indexFlag);
				});
				$('#teacherList').html("");
				$('#teacherList').html(gridHtml);
				$('#totleCount').text(data.total);
				pagination(data, function(){showInfoList(); });
			} else {
				$('#teacherList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				$('#totleCount').text(0);
			}
		},
		error:function(){
		}
	});
}



//images/u8_normal.jpg
function getTdEHtml(obj ,index) {
	var gridHtml = "<tr>";
//	gridHtml += "<td>"+index+"</td>";
	//gridHtml += "<td><input name='chk_list' type='checkbox' value='"+obj.id+"'></td>";
	
	if( obj.userImageUrl == null || obj.userImageUrl == "" || obj.userImageUrl.length == 0){
		gridHtml += "<td><img src='"+ pathHeader+ "/images/u8_normal.jpg' style='width:45px;height:45px' title='头像45×45'></td>";
	} else {
		gridHtml += "<td><img src='"+ imageServer + obj.userImageUrl +"' style='width:45px;height:45px' title='头像45×45'></td>";
	}
	
//	gridHtml += "<td><img src='"+ pathHeader+ "/images/icon01.png' title='头像45×45'></td>";
	gridHtml += "<td>"+obj.realName+"</td>";
	gridHtml += "<td><a href='"+pathHeader+"/teacher/teachermanage/editeTeacherPage.htm?teacherId="+obj.id+"&click="+click+"'>"+obj.idNumber+"</a></td>";
	gridHtml += "<td><ol><li title='"+obj.schoolProvinceName+"'>"+obj.schoolProvinceName+"</li><li title='"+obj.schoolCityName+"'>"+obj.schoolCityName+"</li><li title='"+obj.schoolDistrictName+"'>"+obj.schoolDistrictName+"</li><li title='"+obj.schoolDistrictName+"'>"+obj.schoolName+"</li></ol></td>";
	gridHtml += "<td>"+obj.teachingSection+"</td>";
	gridHtml += "<td>"+obj.teachingSubject+"</td>";
	gridHtml += "<td>"+statusFormatter(obj)+"</td>";
	gridHtml += "</tr>";
	
	return gridHtml;
	
	function statusFormatter(rows) {
		var returnStr = "";
		if (rows.status == 1) {
			returnStr = "正常";
		} else if (rows.status == 44) {
			returnStr = "禁用";
		} else if (rows.status == 6) {
			returnStr = "<font style='color: red;'>未审核</font>";
		} else if (rows.status == 7) {
			returnStr = "审核未通过";
		} else if (rows.status ==8) {
			returnStr = "在职";
		} else if(rows.status == 31) 
			returnStr = "已退休";
		else if(rows.status == 32) 
			returnStr = "已死亡";
		else if(rows.status == 33) 
			returnStr = "已离休";
		else if(rows.status == 34) 
			returnStr = "已离岗";
		else if(rows.status == 35) 
			returnStr = "已病休";
		return returnStr;
	}
	
	function optionFormatter(rows){
		var endit = "<a href='"+pathHeader+"/teacher/teachermanage/editeTeacherPage.htm?teacherId="+rows.id+"' class='tablelink'>编辑</a>";
		var remove = "<a href='###' onclick='teacherDelete("+rows.id+")' class='tablelink'> 删除</a>";
		var handle = "<a href='"+pathHeader+"/teacher/teachermanage/auditTeacherPage.htm?teacherId="+rows.id+"' class='tablelink'>审核</a></p>";
		var returnStr = "";
		if(rows.status == 6) {
			returnStr += "<p>" +endit;
			returnStr += "&nbsp;&nbsp;&nbsp;&nbsp;" + remove + "</p>";
			returnStr += "<p>" +handle+ "</p>";
			returnStr +="<input id='"+rows.id+"_batchOption' type='hidden' value='e_r_h' />"
		} else if (rows.status == 7) {
			returnStr += "<p>" +endit;
			returnStr += "&nbsp;&nbsp;&nbsp;&nbsp;" + remove + "</p>";
			returnStr +="<input id='"+rows.id+"_batchOption' type='hidden' value='e_r' />"
		}  else if (rows.status == 8) {
			returnStr += endit;
			returnStr +="<input id='"+rows.id+"_batchOption' type='hidden' value='e' />"
		}  else if (rows.status == 9 ) { // 订单状态“待签收”
			//已提货待签收状态应该不用异常， 
			//如果需要异常签收，那么不应该判断48小时
			returnStr += "--";
			returnStr +="<input id='"+rows.id+"_batchOption' type='hidden' value='' />"
		} 
//			returnStr += handle;
//			returnStr += charge;
//			returnStr += getGoods;
//			returnStr += exception;
		return returnStr;
	}
	
}

/*function downTeacherExcl() {
	var arrChk=$("input[name='chk_list']:checked");
	var idStr = "";
	$(arrChk).each(function(){
		var option = $('#' + this.value + '_batchOption').val();
		//判断是否有审核权限
   		idStr += this.value + ",";
	});
	idStr = idStr.substring(0,idStr.length -1);
//	window.open("www.baidu.com");
//	downIframe
	$("#downIframe",document.body).attr("src",pathHeader + "/teacher/teachermanage/exportTeacherInforList.do?queryIdNumber="+$('#queryIdNumber').val()+"&queryTeacherNo="+$('#queryTeacherNo').val()+"&queryRealName="+$('#queryRealName').val()+"&queryConditionArray="+$.toJSON(queryConditionArray) + "&arrChk="+idStr);
//	$.post(pathHeader + "/teacher/teachermanage/exportTeacherInforList.do",
//		  {
//		   arrChk:arrChk,
//		   queryConditionArray:$.toJSON(queryConditionArray),
//		   queryRealName:$('#queryRealName').val(),
//		   queryTeacherNo:$('#queryTeacherNo').val(),
//		   queryIdNumber:$('#queryIdNumber').val()
//		  },
//		  function(data,status){
//			  if(data.success) {
//				  	jQuery.generalAlert('成功');
//			  } else {
//				   jQuery.generalAlert('失败');
//			  }
//		  });
}*/

/**
 * 详情
 */
function info(orderId) {
	var openUrl = pathHeader + "/order/orderInfoPage.htm?orderId=" +　LogisticToString(orderId);
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}