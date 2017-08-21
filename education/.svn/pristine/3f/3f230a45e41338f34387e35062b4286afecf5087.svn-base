$(function(){
//	querySubject();
	querySection();
	initSelect();
	queryOrg();
	queryXiangMuList();
	queryXiangMuNeiXingList();
	queryXueLiList();
	queryZhiWuList();
	queryZhiChengList();
	queryPxxsList();
	$("input[type='checkbox']").click(function(){
		if($(this).attr("checked")){
			var name = $(this).attr("name");
			$("hasSelected").append(name);
		}
	});
	
	$("a[name='rm']").click(function(){
		$(this).parent().parent().remove();
	});
	
})

function initSelect(){
	
	//项目培训形式
	/*var projectTrainType = SysCode.getJsonArray("PROJECT_DIM_PROJECT_TRAIN_TYPE","");
	createCommonOpt(projectTrainType,"projectTrainType");*/
	
	
	/*//项目性质
	var projectScope = SysCode.getJsonArray("PROJECT_DIM_PROJECT_SCOPE","");
	createCommonOpt(projectScope,"projectScope");
	//项目属性
	var projectProperty = SysCode.getJsonArray("PROJECT_DIM_PROJECT_PROPERTY","");
	createCommonOpt(projectProperty,"projectProperty");
	
	//学历
	var projectEduBg = SysCode.getJsonArray("PROJECT_DIM_EDUCATION_BACKGROUND","");
	createCommonOpt(projectEduBg,"projectEduBg");
	//职称
	var projectProTit = SysCode.getJsonArray("PROJECT_DIM_PROFESSIONAL_TITLE","");
	createCommonOpt(projectProTit,"projectProTit");
	//学校行政职务
	var projectPos = SysCode.getJsonArray("TEACHER_OFFICE_TYPE","");
	createCommonOpt(projectPos,"projectPos");*/
	
	//SysCode.createSelect("TEACHER_OFFICE_TYPE", "jobSchoolAdministrationOfficeType", "<option value=''>请选择</option>");
	
	
	
	//学历
	var projectEduBg = SysCode.getJsonArray("PROJECT_DIM_EDUCATION_BACKGROUND","");
	createCommonOpt(projectEduBg,"projectEduBg");
	
	
	var projectGrade = SysCode.getJsonArray("PROJECT_DIM_GRADE","");
	createCommonOpt(projectGrade,"projectGrade");
	//继教信息模块
	 initEduModel();
}
/**
 * 查询字典表
 */
var section;
var subject;
function queryDic(dicType){
	var url = pathHeader+ "/sys/queryDicByType.do";
	$.ajax({
		url:url,
		data:{dicType:dicType},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				if(dicType == "project_subject"){
					subject = data.rows;
				}else if(dicType == "stduty_section"){
					section = data.rows;
				}
			}
		},
		error:function(){
			
		}
	});
}

/**
 * 查询实施机构
 * @param {Object} dicType
 */
function queryOrg(){
	var url = pathHeader+ "/org/queryOrgList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#orgId").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#orgId").append(
					"<option  value=\"" + value.organizationId + "\">"
					+ value.organizationName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
}


/**
 * 查询学段
 */
function querySection(){
	queryDic("stduty_section");
	if(section.length > 0){
		var girdHtml = "<tr>";
		for(var i = 0;i<section.length;i++){
			var obj = section[i];
			girdHtml +="<td><a id='target' href='javascript:qrySubject(\""+obj.dictionaryCode+"\","+obj.dictionaryId+")'>"+obj.dictionaryName+"</a></td>";
			if( i != 0 && (i%6) == 0){
				girdHtml +="</tr><tr>"
			}
		}
		girdHtml +="</tr>";
	}
	$("#section").html(girdHtml);
}

/**
 * 查询学科
 */
var allSubjectData;
var sectionId;
function qrySubject(sectionName,id){
	sectionId = id;
	$("#subject").html("");
	$("#showCheck").css("display","block");
	var url = pathHeader + "/sys/querySubject.do";
	$.ajax({
		url:url,
		data:{sectionName:sectionName},
		type:"post",
		async:true,
		success:function(data){
			if(data.success){
				var rows = data.rows;
				allSubjectData = rows;
				$("[id=isAll]").attr("checked",false);
				$("[id=fanxuan]").attr("checked",false);
				if(rows.length > 0){
					var girdHtml = "<tr >";
					for(var i = 0;i<rows.length;i++){
						var obj = rows[i];
						girdHtml +="<td><input type='checkbox' id='"+sectionId+"' name='"+obj.dictionaryName+"' value='"+obj.dictionaryId+"' onclick='setValues(this)'>"+obj.dictionaryName+"</td>";
						if( i != 0 && (i%2) == 0){
							girdHtml +="</tr><tr>"
						}
					}
					girdHtml +="</tr>";
					$("#subject").html(girdHtml);
				}
			}
			//学科查询完成后触发模拟点击事件
			//var evt = document.createEvent("MouseEvents"); 
			//evt.initEvent("click", false, false);
			//$("#isAll").get(0).dispatchEvent(evt);
			//判断当前选中学段的学科是否被选中
			isChecked();
		},
		error:function(){
			
		}
	});
}

//触发学段中所有事件
function showSection(){
	queryDic("project_subject");
	if(subject.length > 0){
		allSubjectData = subject;
		var girdHtml = "<tr >";
		for(var i = 0;i<subject.length;i++){
			var obj = subject[i];
			girdHtml +="<td><input type='checkbox' id='res' name='"+obj.dictionaryName+"' value='"+obj.dictionaryId+"' onclick='setValues(this)'>"+obj.dictionaryName+"</td>";
			if( i != 0 && (i%4) == 0){
				girdHtml +="</tr><tr>"
			}
		}
		girdHtml +="</tr>";
		$("#subject").html(girdHtml);
	}
	var evt = document.createEvent("MouseEvents"); 
	evt.initEvent("click", false, false);
	$("[id=res]").trigger("click");
	selectAllSubject(subject);
	//for(var m=0;m<subject.length;m++){
		//$("#res").get(m).dispatchEvent(evt);
		//$("#res").get(0).dispatchEvent(evt);
	//}
	//$("[id=target]").trigger("click");
	//$("#target").trigger("click");
	 //$("#target").triggerHandler("click");
}
//学科全选
var subAry = new Array();
function selectAllSub(){
	var CheckStatus = $("#isAll").attr("checked");
	$("#fanxuan").attr("checked",false);
	if(CheckStatus){
		$("[id='"+sectionId+"']").attr("checked",true);
		//触发全选
		selectAll(allSubjectData,sectionId);
	}else{
		$("[id='"+sectionId+"']").attr("checked",false);
		//取消全选
		unSelectAll(subAry,sectionId);
	}
}
//学科反选
function selectNoCheckSub(){
	var CheckStatus = $("#fanxuan").attr("checked");
	$("input[id=selectSub]").each(function(){
		if(this.checked){
			$(this).attr("checked",false);
		}else{
			$(this).attr("checked",true);
		}
		//反选操作
		invertSub();
	});
}

//全选操作
var h = "";
function selectAll(allSubjectData,sectionId){
	h = allSubjectData.length;
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		};
		
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				subAry.splice(j,1);
				$("[name='"+obj.dictionaryName+"']").attr("checked",true);
			}
		}
		
		if($("[id='"+sectionId+"']").attr("checked")){
			subAry.push(sub);
		}
	}	
		$("#hasSelected").html("");
		for(var i = 0;i<subAry.length;i++){
			$("#hasSelected").append(subAry[i].subjectName+" ");
		}
}
//当点击选择按钮时，选中全部学科[必须使用同一数组subAry]
function selectAllSubject(subject){
	h = subject.length;
	for(var i = 0;i<subject.length;i++){
		var obj = subject[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		};
		
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				subAry.splice(j,1);
			}
		}
		
		if($("[id='res']").attr("checked")){
			subAry.push(sub);
		}
	}	
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}

//判断数组中的学科是否包含选中学段里的学科
function isChecked(){
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		for(var j = 0;j<subAry.length;j++){
			if(subAry[j].subjectName == obj.dictionaryName){
				$("[name='"+obj.dictionaryName+"']").attr("checked",true);
			}
		}
	}
	var temp = $("input[id='"+sectionId+"']:checked");
	if(temp.length != allSubjectData.length){
		$("#isAll").attr("checked",false);
	}else{
		$("#isAll").attr("checked",true);
	}
}

//取消全选
function unSelectAll(subAry,sectionId){
	console.log("subAry:"+subAry);
	for(var j = 0;j<subAry.length;j++){
		for(var n=0;n<allSubjectData.length;n++){
			var name = allSubjectData[n].dictionaryName;
			if(subAry[j] != null && subAry[j].subjectName == name){
				subAry.splice(j,1);
			}
		}
	}
	
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}

//反选操作
function invertSub(){
	//将已选学科清空并取消已选
	//unSelectAll();
	//当点击反选按钮后,如果没有全选就将全选选中
	$("#isAll").attr("checked",false);
	for(var i = 0;i<allSubjectData.length;i++){
		var obj = allSubjectData[i];
		var sub = {
				subjectId:obj.dictionaryId,
				subjectName:obj.dictionaryName
		}
		if($("[name='"+obj.dictionaryName+"']").attr("checked")){
			if(subAry[i].subjectName == sub.subjectName){
				subAry.push(sub);
			}
		}
	}
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}

function createOpt(rows,sid){
	var opt = "<option value='0'>请选择</option>";
	for(var i = 0;i<rows.length;i++){
		opt += "<option value='"+rows[i].dictionaryId+"'>"+rows[i].dictionaryName+"</option>";
	}
		$("#"+sid).append(opt);
}

function createCommonOpt(rows,sid){
	var opt = "<option value='0'>请选择</option>";
	for(var i = 0;i<rows.length;i++){
		opt += "<option value='"+rows[i].id+"' ";
		opt += ">"+rows[i].text+"</option>";
	}
		$("#"+sid).append(opt);
}

function savePro(){
	
	

	
	
	/*var files = $("input[name='file']");
	for(var i = 0;i<files.length;i++){
		var name = files[i].value.toString();
		var ext = name.substring(name.lastIndexOf('.')+1,name.length);
		if(ext=="jsp" || ext == "html"){
			jQuery.generalAlert("上传文件格式非法！请重新上传！");
			return ;
		}
	}*/
	

/*	$("#submitPro").attr("disabled",true);*/
	setValue();
	var url = pathHeader+"/edupm/projectmanage/savePro.do";
	
	
	
	
	if(!validatEduModelType()){
		jQuery.generalAlert("继教板块不能为空！");
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateName()){
		jQuery.generalAlert("请填写项目名称！");
		$("input[name='projectName']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	/*if(!validateProjectNO()){
		jQuery.generalAlert("请填写项目编号！");
		$("input[name='projectNo']").focus();
		$("#submitPro").attr("disabled",false);
		return;
	}*/
	
	
	if(!validateStartDateEmpty()){
		jQuery.generalAlert("开始时间不能为空！");
		$("input[name='startDate']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateEndDateEmpty()){
		jQuery.generalAlert("结束时间不能为空！");
		$("input[name='endDate']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	
	if(!validateDate()){
		jQuery.generalAlert("开始时间不能大于结束时间！");
		$("input[name='startDate']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	
	// 验证实施机构
	if(!validateSSOrg()){
		jQuery.generalAlert("请选择实施机构！");
		$("input[name='orgId']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	/*if(!validatexmyz()){
		jQuery.generalAlert("请选择项目性质！");
		$("input[name='projectScope']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}*/
	
	if(!validatePlanNum()){
		jQuery.generalAlert("培训人数请填写非0的正整数数字！");
		$("input[name='planNum']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateXmxz()){
		jQuery.generalAlert("请选择项目性质！");
		$("input[name='projectScope']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validatePxnx()){
		jQuery.generalAlert("请选择培训类型！");
		$("input[name='projectProperty']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validatePxxs()){
		jQuery.generalAlert("请选择培训形式！");
		$("input[name='projectTrainType']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateTrainScope()){
		jQuery.generalAlert("请选择培训范围！");
		$("input[name='trainScopeName']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateSubject()){
		jQuery.generalAlert("请选择学科/学段！");
		$("input[name='subject']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	//验证项目名称是否已经存在
	if(!validateProName()){
		jQuery.generalAlert("项目名称已经存在！");
		//$("input[name='projectName']").focus();
		$("#submitPro").attr("disabled",false);
		return ;
	}
	//验证项目编号
	if(!validateNO()){
		jQuery.generalAlert("项目编号已经存在！");
		$("#submitPro").attr("disabled",false);
		return ;
	}
	
	if(!validateClassPeriod()){
		return;
	}
	$('#myModal').modal('show');
	$("#proForm").ajaxSubmit({
		url:url,
		async:false,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.success){
				url = pathHeader + "/edupm/projectmanage/toProjectDeclarePage.htm?click=21&status=10";
				jQuery.generalAlertAndJump("保存成功！", url);
			}else if(data.msg == "-1"){
				jQuery.generalAlert(data.uploadSizeExceeded);
			}else if(data.msg == "-2"){
				jQuery.generalAlert(data.notParseRequest);
			} else {
				jQuery.generalAlert("保存失败！");
			}
			$('#myModal').modal('hide');
			$("#submitPro").attr("disabled",false);
		},
		error:function(){
			$("#submitPro").attr("disabled",false);
		}
	});
}

function getSelected(sid){
	var value,text;
	text = $("#"+sid+" option:selected").text();
	value = $("#"+sid).val();
	scontent={
		value:value,
		text:text
	};
	return scontent;
}

function setInputValue(name,value){
	$("input[name='"+name+"']").val(value);
}

function setValue(){
	
	//培训形式
	var projectTrainType = getSelected("projectTrainType");
	
	setInputValue("trainTypeId",projectTrainType.value);
	setInputValue("trainTypeName",projectTrainType.text=="请选择"?'':projectTrainType.text);
	
	//项目性质
	var projectScope = getSelected("projectScope");
	setInputValue("projectScopeId",projectScope.value)
	setInputValue("projectScopeName",projectScope.text=="请选择"?'':projectScope.text);

	//培训类型
	var projectProperty = getSelected("projectProperty");
	setInputValue("projectPropertyId",projectProperty.value);
	setInputValue("projectPropertyName",projectProperty.text=="请选择"?'':projectProperty.text);
	//学历
	var projectEduBg = getSelected("projectEduBg");
	setInputValue("educationBackgroundId",projectEduBg.value);
	setInputValue("educationBackgroundName",projectEduBg.text=="请选择"?'':projectEduBg.text);
	//职位
	var projectPos = getSelected("projectPos");
	setInputValue("positionId",projectPos.value);
	setInputValue("positionName",projectPos.text=="请选择"?'':projectPos.text);
	//教师职称
	var projectProTit = getSelected("projectProTit");
	setInputValue("professionalTitleId",projectProTit.value);
	setInputValue("professionalTitleName",projectProTit.text == '请选择'?'':projectProTit.text );
	//是否收费
	var isFree = $("input[name='if']:checked").val();
	setInputValue("isFree",isFree);
		
	var signUpWay = $("input[name='t1']:checked").val();
	setInputValue("signUpWay",signUpWay);
	
	var printxueshi = $("input[name='printxueshi']").is(':checked');
	if(printxueshi) {
		setInputValue("printXueshiCertificate", 1);
	}else {
		setInputValue("printXueshiCertificate",0);
	}

	
	var printprojectcert = $("input[name='printproject']").is(':checked');
	if(printprojectcert) {
		setInputValue("printProjectCertificate", 1);
	}else {
		setInputValue("printProjectCertificate", 0);
	}
	
	
	
//	var projectScope=$("#projectScope").val();
	//setInputValue("projectScopeName",projectScope);
	
	//var projectProperty=$("#projectProperty").val();
	//setInputValue("projectPropertyName",projectProperty);
	
	/*var projectTrainType=$("#projectTrainType").val();
	setInputValue("trainTypeId",projectTrainType.value);
	//alert(projectTrainType);
	setInputValue("trainTypeName",projectTrainType);*/
	
	//学科
//	var subject = getSelected("subject");
//	setInputValue("subjectId",subject.value);
//	setInputValue("subjectName",subject.text);
	//学段
//	var section = getSelected("section");
//	setInputValue("stdutySectionId",section.value);
//	setInputValue("stdutySection",section.text);
	
//	var projectGrade = getSelected("projectGrade");
//	setInputValue("gradeId",projectGrade.value);
//	setInputValue("gradeName",projectGrade.text);
}


function lastForSure(){
	if(lastSelect != null && lastSelect.length > 0) {
		var conditionArray = lastSelect.split("_");
		var belone = conditionArray[0];
		var text = conditionArray[2];
		$("input[name='trainScopeId']").val(belone);
		$("#ts").val(text);
	}
	clear();
}


function showS(){
	$("#XDshow").show();
	$("#showCheck").css("display","none");
	showSection();
}

function hideMe(){
	$("#XDshow").hide();
}

//var subAry = new Array();
function setValues(obj){
	
	var sub = {
		subjectId:obj.value,
		subjectName:obj.name
	}
	var flag = true;
	for(var i = 0;i<subAry.length;i++){
		if(subAry[i].subjectName == sub.subjectName){
			flag = false;
		}
	}
	if(flag && obj.checked){
		subAry.push(sub);
	}
	if(!obj.checked){//取消选择
		var index = -1;
		for(var i = 0;i<subAry.length;i++){
			if(subAry[i].subjectName == sub.subjectName){
				//subAry.pop(i);//不能pop，应该是删除指定位置,而且pop()方法是 不带参数的
				subAry.splice(i, 1);
				break;
			}
		}
	}
	var temp = $("input[id='"+sectionId+"']:checked");
	if(temp.length != allSubjectData.length){
		$("#isAll").attr("checked",false);
	}else{
		$("#isAll").attr("checked",true);
	}
	$("#hasSelected").html("");
	for(var i = 0;i<subAry.length;i++){
		$("#hasSelected").append(subAry[i].subjectName+" ");
	}
}


function lastSure(){
	if(subAry.length>0){
		var ids = "";
		var names = "";
		for(var i = 0;i<subAry.length;i++){
			var obj = subAry[i];
			ids += obj.subjectId+",";
			names += obj.subjectName+",";
		}
	}
	$("input[name='subjectId']").val(ids.substring(0,ids.length-1));
	$("input[name='subjectName']").val(names.substring(0,names.length-1));
	var values = "";
	for(var i = 0;i<subAry.length;i++){
		values += subAry[i].subjectName+" ";
	}
	$("input[name='subject']").val(values);
	//subAry.length = 0;
	$("#XDshow").hide();
}

function cancel(){
	window.location.href = pathHeader + "/edupm/projectmanage/toProjectListPage.htm?click=0";
}


function removeMe(o){
	$(o).parent().remove();
}

function addMore(){
	var tr = "<tr><td width='260' colspan='2'><input type='file' name='file'/><a href='###' onclick='removeMe(this)'>删除</a></td></tr>";
	$("#files").append(tr);
}

/**
 * 验证项目名称
 * @return {TypeName} 
 */
function validateProName(){
	var ok = false;
	var url1 = pathHeader + "/edupm/projectmanage/validateProjectName.do";
	$.ajax({
		url:url1,
		data:{projectName:$("input[name='projectName']").val()},
		type:"post",
		async:false,
		success:function(data){
			if(data.ok){
				ok = true;
			}
		},
		error:function(){
			
		}
	});
	return ok;
}

/**
 * 验证项目编号
 * @return {TypeName} 
 */
function validateNO(){
	var ok = false;
	var url2 = pathHeader + "/edupm/projectmanage/validateProjectNO.do";
	$.ajax({
		url:url2,
		data:{projectNO:$("input[name='projectNo']").val()},
		type:"post",
		async:false,
		success:function(data){
			if(data.ok){
				ok = true;
			}
		},
		error:function(){
			
		}
	});
	return ok;
}

//继教信息板块
function initEduModel(){
	var url = pathHeader + "/edupm/projectmanage/queryEduModelNoPage.do";
	$.ajax({
		url:url,
		type:"post",
		async:false,
		success:function(data){
				if(data.success){
					var rows = data.rows;
				var opts = "";
				for(var i = 0;i<rows.length;i++){
					var obj = rows[i];
					opts +="<option value='"+obj.id+"'>";
					opts += obj.name;
					opts+="</option>";
				}
				$("select[name='eduModelType']").html(opts);
				}
		},
		error:function(){
			jQuery.generalAlert("初始化继教信息模块失败！");
		}
		
	});
}


/*
 * 
 * start
 */
//查询项目性质
function queryXiangMuList(){
	var url = pathHeader+ "/org/queryXiangMuList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#projectScope").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#projectScope").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}

//查询培训类型
function queryXiangMuNeiXingList(){
	var url = pathHeader+ "/org/queryXiangMuNeiXingList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#projectProperty").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#projectProperty").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}

function queryXueLiList(){
	var url = pathHeader+ "/org/queryXueLiList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#projectEduBg").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#projectEduBg").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}

function queryZhiWuList(){
	var url = pathHeader+ "/org/queryZhiWuList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#projectPos").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#projectPos").append(
					"<option  value=\"" + value.dictionaryId+ "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}


function queryZhiChengList(){
	var url = pathHeader+ "/org/queryZhiChengList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
			$("#projectProTit").append("<option  value=''>请选择</option>");
			$.each(data.rows, function(key, value) {
				$("#projectProTit").append(
					"<option  value=\"" + value.dictionaryId + "\">"
					+ value.dictionaryName + "</option>");
			});
			}
		},
		error:function(){
			
		}
	});
	
}
//培训形式
function queryPxxsList(){
	var url = pathHeader+ "/org/queryPxxsList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				$("#projectTrainType").append("<option  value=''>请选择</option>");
				$.each(data.rows, function(key, value) {
					$("#projectTrainType").append(
							"<option  value=\"" + value.dictionaryId + "\">"
							+ value.dictionaryName + "</option>");
				});
			}
		},
		error:function(){
			
		}
	});
	
}

/*
 * end
 * 
 */

