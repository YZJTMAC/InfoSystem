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
		var areaA = conditionArray[1];
		var text = conditionArray[2];
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
	
	queryDic('stduty_section', 'stdutySection'); //学段
	
//	queryDic('project_subject', 'stdutySubject');
	
	queryEducationalDic('educational_user');  //最低/最高学历
	
	queryDicA('xkdtr_type', 'subjectLeader');  //学科带头人
	queryDicA('ggjs_type', 'coreTeacher');		//骨干教师
	
	queryDicA('gwlb_type', 'gwlb');  //岗位类别
	queryDicA('gwdj_type', 'gwdj');  //岗位等级
	
	queryJobPositionDic('teacher_professional');  //(评)/(聘)教师职称
	
	/*$("#chk_all").click(function(){
     $("input[name='chk_list']").attr("checked",$(this).attr("checked"));
	});*/
	
	$("#pageSize").change(function(){
		showInfoList();
	});
	
	//已审核
	
	$(".yes").click(function(){
		$("#auditStatus").val(8);
		showInfoListes();
		
  	});
	
   //未审核
	
	$(".no").click(function(){
		$("#auditStatus").val(6);
		showInfoListes();
		
  	});
	
	
	
	$("#chk_all").click(function(){
		if(this.checked){
			$("input[name='chk_list']").attr("checked",$(this).attr("checked"));
		}
		else{
			$("input[name='chk_list']").attr("checked",false);
		}
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
		$(".tip2").fadeOut(100);
		$(".tip_vp").fadeOut(100);
	});

	$(".tiptop2 a").click(function() {
		$(".tip1").fadeOut(200);
		$(".tip2").fadeOut(100);
	});
	
	$(".cancel1").click(function() {
		$(".tip1").fadeOut(100);
		$(".tip2").fadeOut(100);
		$(".tips_zb").fadeOut(100);
	});
	$(".cancel2").click(function() {
		$(".tips_zb").hide();
	});
	
	$(".sure").click(function() {
		$(".tip_vp").hide();
	});
	
	//批量提交审核
	$("#sureAudit").click(function() {
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
    	$("input[name='chk_list']").attr("checked",false);
		$(".tip").fadeOut(100);
    	//$('#myModal').modal('hide');
	});

	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});
	
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
	$('#chk_all').attr('checked', false);
	
	//导出
	initExportInfo();
}

//多选
function getAndSetChecked(){
	// 子选项全选中同时选中全选项, 子选项未选中全选项取消选中
	$('#chk_all').attr('checked', false);
	$("input[name='chk_list']").click(function () {
		if($(this).attr('checked')){
			var sum = 0;
			$("input[name='chk_list']").each(function(){				
				if($(this).attr('checked')){
					sum += 1;
				} else {
					sum += 0;
				}
			});
			if(sum == $("input[name='chk_list']").length){
				$('#chk_all').attr('checked', true);
			}
		} else {				
			$('#chk_all').attr('checked', false);
		} 		
		});
}


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
				logicStr = "<font style='color: red;'>未审核</font>";
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

//最低学历 
var lowEducationArray = [];

//最高学历 
var topEducationArray = [];

// 学科带头人
var subjectLeaderArray = [];

// 骨干教师
var coreTeacherArray = [];

//岗位类别
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
	//return flag;
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
			
					gridHtml += "<td><INPUT id='"+ vid +"'  name='"+ name +"' value='"+element.dictionaryId+"' type='radio' ></td>";
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
			} else {
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
					gridHtml += "<INPUT id='7'  name='"+id+"' onclick='qrySubject(\""+element.dictionaryCode+"\","+element.dictionaryId+")'  value='"+element.dictionaryId+"' type='radio' >";
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
	if(!confirm('此操作将删除教师在系统中的所有信息！确定要删除选中的教师吗？'))
			return false;
	$.ajax({
		/*url : pathHeader + "/teacher/teachermanage/removeTeacher.do",*/  //假删教师信息
		url : pathHeader + "/teacher/teachermanage/deleteTeacher.do",   //真删教师信息
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
	//$('#myModal').modal('show');
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
				 window.location.reload();
			} else {
				
			}
		},
		error:function(){
		}
	});
}
//查询数据标志 初始状态
var count = '-1';
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
			$('#teacherList').html("<tr><td align='center' colspan='9'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
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
				count = data.total;
				pagination(data, function(){showInfoList(); });
			} else {
				$('#teacherList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				$('#totleCount').text(0);
			}
			getAndSetChecked();
		},
		error:function(){
		}
	});
}

//审核
function showInfoListes() {
	
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
			pageIndex:pageIndex,
			userStatus: $("#auditStatus").val()
		},
		beforeSend: function(){
			$('#teacherList').html("<tr><td align='center' colspan='9'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
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
				pagination(data, function(){showInfoListes(); });
			} else {
				$('#teacherList').html("<tr><td colspan='12'>无查询记录</td></tr>");
				$('#totleCount').text(0);
			}
			getAndSetChecked();
		},
		error:function(){
		}
	});
}



//images/u8_normal.jpg
function getTdEHtml(obj ,index) {
	var gridHtml = "<tr>";
//	gridHtml += "<td>"+index+"</td>";
	gridHtml += "<td><input name='chk_list' type='checkbox' value='"+obj.id+"'></td>";
	
	if( obj.userImageUrl == null || obj.userImageUrl == "" || obj.userImageUrl.length == 0){
		gridHtml += "<td><img src='"+ pathHeader+ "/images/u8_normal.jpg' style='width:45px;height:45px' title='头像45×45'></td>";
	} else {
		gridHtml += "<td><img src='"+ imageServer+ obj.userImageUrl +"' style='width:45px;height:45px' title='头像45×45'></td>";
	}
	
//	gridHtml += "<td><img src='"+ pathHeader+ "/images/icon01.png' title='头像45×45'></td>";
	gridHtml += "<td><a href='"+pathHeader+"/teacher/teachermanage/editeTeacherPage.htm?click=1&teacherId="+obj.id+"'>"+obj.realName+"</a></td>";
	gridHtml += "<td><a href='"+pathHeader+"/teacher/teachermanage/editeTeacherPage.htm?click=1&teacherId="+obj.id+"'>"+obj.idNumber+"</a></td>";
	gridHtml += "<td><ol><li title='"+obj.schoolProvinceName+"'>"+obj.schoolProvinceName+"</li><li title='"+obj.schoolCityName+"'>"+obj.schoolCityName+"</li><li title='"+obj.schoolDistrictName+"'>"+obj.schoolDistrictName+"</li><li title='"+obj.schoolDistrictName+"'>"+obj.schoolName+"</li></ol></td>";
	gridHtml += "<td>"+obj.teachingSection+"</td>";
	gridHtml += "<td>"+obj.teachingSubject+"</td>";
	gridHtml += "<td>"+statusFormatter(obj)+"</td>";
	gridHtml += "<td>"+ optionFormatter(obj)+"</td>";
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
		var endit = "<a href='"+pathHeader+"/teacher/teachermanage/editeTeacherPage.htm?click=1&teacherId="+rows.id+"' class='tablelink'>编辑</a>";
		var remove = "<a href='###' onclick='teacherDelete("+rows.id+")' class='tablelink'> 删除</a>";
		var handle = "<a href='"+pathHeader+"/teacher/teachermanage/auditTeacherPage.htm?click=1&teacherId="+rows.id+"' class='tablelink'>审核</a></p>";
		var returnStr = "";
		if(rows.status == 1 || rows.status == 44) {
			returnStr += endit;
			returnStr +="<input id='"+rows.id+"_batchOption' type='hidden' value='' />"
		} else if(rows.status == 6) {
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
			returnStr +="<input id='"+rows.id+"_batchOption' type='hidden' value='e_y' />"
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

//报表导出
var tIds = "";
function exportTeacherExcl(){
	tIds = "";
	var arrChk=$("input[name='chk_list']:checked");
	$(arrChk).each(function(){
		tIds += this.value + ",";
	});
	tIds = tIds.substring(0,tIds.length -1);
	if(count == '-1'){
		jQuery.generalAlert('请稍后，数据加载完成后再进行操作！');
		return;
	}else if(count == 0){
		jQuery.generalAlert('没有数据可以导出！');
		return ;
	}else if(tIds.length==0 && count > 60000){
		jQuery.generalAlert('报表导出数据不能超出60000条记录,请选择勾选筛选条件导出！');
		return;
	}
	// 弹出模态框, 用于自由组合报表导出内容
	$(".tip1").fadeIn(200);
}
//获取复选框选中的字段名称
function getChecked(){
	var checkedData = [];
    $("input[name='checkbox']:checkbox").each(function(){ 
        if($(this).attr("checked")){
        	if($(this).val() != null && $(this).val() != ''){
        		checkedData.push($(this).val());
        	}
        }
    });
    return checkedData;
}

//获取字段属性的id值
function getFeildsAry(){
	var feildsAry = [];
	 $("input[name='checkbox']:checkbox").each(function(){ 
	        if($(this).attr("checked")){
	        	feildsAry.push($(this).attr("id"));
	        }
	  });
	 return feildsAry;
}

//操作默认导出字段选项
function defaultChecked(flag){
	$("input[name='checkbox']:checkbox").each(function(){ 
		for(var i=0;i<defalutFeilds.length;i++){
			if(defalutFeilds[i]==$(this).attr("id")){
				$("#"+$(this).attr("id")).attr("checked",flag);
			}
		}
	});
}

//默认导出报表
var defalutFeilds = ['realName','idNumber','sex','userProvinceName','userCityName','userDistrictName','schoolName','jobFormerTeachingSection','jobFormerTeachingSubject'];
$(function(){
	//事件切换
	$("#default").click(function(){
		if($("#default").attr("checked")){
			defaultChecked(true);
		}else if(!($("#checkAll").attr("checked"))){
			defaultChecked(false);
		}
	});
});

//设置全选复选框
$(function(){
	$("#checkAll").click(function(){
		getAllChecked();
	});
	$("input[name='checkbox']").click(function(){
		//var hasChecked = getChecked();
		var hasChecked = [];
	    $("input[name='checkbox']:checkbox").each(function(){ 
	        if($(this).attr("checked")){
	        	hasChecked.push($(this).val());
	        }
	    });
		if(hasChecked.length == $("input[name='checkbox']:checkbox").length){
			$("#checkAll").attr("checked",true);
		}else{
			$("#checkAll").attr("checked",false);
		}
	});
});
//全选checkAll
function getAllChecked(){
	var CheckStatus = $("#checkAll").attr("checked");
	if(CheckStatus){
		$("[name='checkbox']").attr("checked",true);
		//如果全选为选中，将默认选项设置为选中
		$("#default").attr("checked",true)
	}else{
		$("[name='checkbox']").attr("checked",false);
		//如果默认导出字段已勾选则不作处理
		$("input[name='checkbox']:checkbox").each(function(){ 
			for(var i=0;i<defalutFeilds.length;i++){
				if($("#default").attr("checked") && defalutFeilds[i]==$(this).attr("id")){
					$("#"+$(this).attr("id")).attr("checked",true);
				}
			}
		});
	}
}

//修复教师信息按地区/学校查询Bug 设置schoolName复选框选中值
var schoolName = "学校名称";
function initExportInfo(){
	$("#checkAll").attr("checked",false);
	$("input[name='checkbox']:checkbox").attr("checked",false);
	$("#exportTeacherInfo").click(function(){
		var strs = getFeildsAry();
		var checkedData = getChecked();
		for(var i=0;i<strs.length;i++){
			if(strs[i] == "schoolName"){
				checkedData.splice(i, 0, schoolName);  
			}
		}
		if(checkedData.length == 0){
			jQuery.generalAlert('请您选择所需的字段进行导出！');
			return ;
		}
		
		$('#myModal').modal({show:true,backdrop: 'static', keyboard: false});
		setTimeout('hideTip()',2000); 
		
		var url = pathHeader + "/teacher/teachermanage/exportTeachers.do";
		var form = $("<form>");// 定义一个form表单
		form.attr("style", "display:none");
		form.attr("method", "post");
		form.attr("action", url);
		
		var input1 = $("<input>");
		input1.attr("type", "hidden");
		input1.attr("name", "queryIdNumber");
		input1.attr("value", $('#queryIdNumber').val());
		
		var input2 = $("<input>");
		input2.attr("type", "hidden");
		input2.attr("name", "queryTeacherNo");
		input2.attr("value", $('#queryTeacherNo').val());
		
		var input3 = $("<input>");
		input3.attr("type", "hidden");
		input3.attr("name", "queryRealName");
		input3.attr("value", $('#queryRealName').val());
		
		var input4 = $("<input>");
		input4.attr("type", "hidden");
		input4.attr("name", "queryJdfldw");
		input4.attr("value", $('#queryJdfldw').val());
		
		var input5 = $("<input>");
		input5.attr("type", "hidden");
		input5.attr("name", "checkedData");
		input5.attr("value", checkedData);
		
		var input6 = $("<input>");
		input6.attr("type", "hidden");
		input6.attr("name", "tIds");
		input6.attr("value", tIds);
		
		var input7 = $("<input>");
		input7.attr("type", "hidden");
		input7.attr("name", "feildsAry");
		input7.attr("value", strs);
		
		var input8 = $("<input>");
		input8.attr("type", "hidden");
		input8.attr("name", "queryConditionArray");
		input8.attr("value", queryConditionArray);
		
		$("body").append(form);// 将表单放置在web中
		form.append(input1);
		form.append(input2);
		form.append(input3);
		form.append(input4);
		form.append(input5);
		form.append(input6);
		form.append(input7);
		form.append(input8);
		form.submit();// 表单提交
		
		/*if (iframe.attachEvent){
		    iframe.attachEvent("onload", function(){
		    	$('#myModal').modal('hide'); 
		    });
		} else {
			iframe.onload  = function(){
		    	$('#myModal').modal('hide');
		    };
		}*/
		//document.body.appendChild(iframe);
		//document.body.insertBefore(iframe, document.body.lastChild);
		$(".tip1").fadeOut(500);
	});
}


function hideTip(){
	$('#myModal').modal('hide');
}

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

