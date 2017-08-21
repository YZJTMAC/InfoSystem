var plot2;
$(function(){
	initAutoComplete();
});

/**
 * 初始化
 */
function initAutoComplete(){
	showInfoList();
	
}
function queryChartDtial(projectId, orgId) {
	$.ajax({
		url : pathHeader + "/furtheredu/edumanage/evaluationInfo.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:projectId,
		orgId:orgId
		 },
		success:function(data){
			if(data.success) {
				 var obj = data.obj;
				 var a = 0;
				 var b = 0;
				 var c = 0;
				 var d = 0;
				 var e = 0;
				 $.each(obj, function(index,element) {
					 if(element.scoreLevel == 1) 
						a = element.scoreCount;
				     if(element.scoreLevel == 2) 
						b = element.scoreCount;
				     if(element.scoreLevel == 3) 
						c = element.scoreCount;
				     if(element.scoreLevel == 4) 
						d = element.scoreCount;
				     if(element.scoreLevel == 5) 
						e = element.scoreCount;
				});
				 showChart(a,b,c,d,e);
			} else {
			}
		},
		error:function(){
		}
	});
}

function showChart(a, b, c, d, e) {
	s1 = [['非常满意',e], ['满意',d], ['一般',c], ['不满意',b], ['非常不满意',a]];
    plot2 = $.jqplot('chart2', [s1], {
  title: '项目-机构-评分情况',
        seriesDefaults:{
            renderer:jQuery.jqplot.PieRenderer,
            rendererOptions: {
                showDataLabels: true,
                dataLabelThreshold: 1,
                dataLabelFormatString: '%.1f%%'
            }
        },
        legend: {
            show: true,
            placement: 'outside'
        }
    });
}
function queryCommet(projectId, orgId,e) {
	var projectName = e.title;
	$.ajax({
		url : pathHeader + "/org/selectOrgProjectCommet.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:projectId,
		orgId:orgId,
		projectName:projectName
		 },
		success:function(data){
			if(data.success) {
				 var obj = data.obj;
				 showComment(obj,projectName);
			} else {
				var obj = data.obj;
				addComment(obj,projectName);
			}
		},
		error:function(){
		}
	});
}
function saveComment(projectId, orgId) {
	var starVal="";
	$("#comment").find("tr").each(function(i){ 
		var arr=$(this).find("a");
		if(arr.length==5){
			 var count=0;
			for(var i = 0;i<arr.length;i++){
			  	 if(arr[i].title==1){
			  		 count++;
			  	 }
			   }
			
			starVal=starVal+count+",";
		}
	});
	if(starVal.indexOf("0")!=-1){
		alert("评价等级不能为空!");
		return false;
	}
	var commentContent = $('#commentCountent').val();
	if(commentContent == ""){
		alert("评价说明不能为空!");
		return false;
	}
	$.ajax({
		url : pathHeader + "/org/updateOrgProjectComment.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		projectId:projectId,
		orgId:orgId,
		comment:starVal,
		commentContent:commentContent
		 },
		success:function(data){
			if(data.success) {
				 $(".tip2").fadeOut(200);
	  			location.reload();
			} else {
				 $(".tip2").fadeOut(200);
		  			location.reload();
			}
		},
		error:function(){
		}
	});
}
function showComment(obj,projectName) {
	//var comment = SysCode.get(COMMENT_DIM_COUNTRY);
	var comment = SysCode.getJsonArray("COMMENT_DIM_COUNTRY","");
	var text="";
	var text2="";
	var textmsg="";
	var Content="";
	$('#comment').html("");
	var textTop="<tr><td width='60'><strong>项目名称：</strong></td><td colspan='2'><h4>"+projectName+"</h4></td></tr>";
	$('#comment').append(textTop);
	var commetSP=obj.comment.split(",");
	for(var i = 0;i<comment.length;i++){
		text=comment[comment.length-i-1].text;
		text2=commetSP[i];
		if(text2==1){
			textmsg='很不满意';
		}else if(text2==2){
			textmsg='不满意';
		}else if(text2==3){
			textmsg='一般';
		}else if(text2==4){
			textmsg='满意';
		}else{
			textmsg='非常满意';
		} 
		if(obj.commentContent!=null){
			Content=obj.commentContent;
		}
	var tr="<tr id='star1'><td>&nbsp;</td><td width='96'>"+text+"</td>" +
		"<td width='138' >" +
		"<a href=' javascript:void(0);' ></a>" +
		"<a href=' javascript:void(0);' ></a>" +
		"<a href=' javascript:void(0);' ></a>" +
		"<a href=' javascript:void(0);' ></a>" +
		"<a href=' javascript:void(0);' ></a></td>" +
		"<td width='106'><span>"+textmsg+"</span></td></tr>";
		$('#comment').append(tr);
		 current("comment",i,text2);
	}
	var qd="<tr><td>评价说明：</td><td colspan='3' rowspan='2' style='padding-top:0;'>" +
			"<textarea name='textarea' cols='' rows=''>"+Content+"</textarea></td></tr>" +
			"<tr><td>&nbsp;</td></tr><tr><td colspan='4'>" +
			"<table border='0' cellspacing='0' cellpadding='0' style='margin:0 auto;'>" +
			"<tr><td align='center'></td>" +
			"<td width='30'>&nbsp;</td><td  align='center'>" +
			"<input type='button' class='dian3' onclick='commnetClose()'  value='关 闭'/></td></tr>";
	   $('#comment').append(qd);  
	  
	
	//$('#comment').html("项目名称是"+projectName+"字典是"+text+"结项值"+text2+"");
	
	
}
function commnetClose(){
	 $(".tip2").fadeOut(200);
}
function addComment(obj,projectName) {
	var comment = SysCode.getJsonArray("COMMENT_DIM_COUNTRY","");
	var text="";
	$('#comment').html("");
	var textTop="<tr><td width='60'><strong>项目名称：</strong></td><td colspan='2'><h4>"+projectName+"</h4></td></tr>";
	$('#comment').append(textTop);
	for(var i = 0;i<comment.length;i++){
		text=comment[comment.length-i-1].text;
	var tr="<tr id='star"+i+"'><td>&nbsp;</td><td width='96'>"+text+"：</td>" +
		"<td width='138' onmouseout='clearStar(this)'>" +
		"<a href=' javascript:void(0);' onclick='rateIt(this,"+i+")' onmousemove='starChoose(this)'></a>" +
		"<a href=' javascript:void(0);' onclick='rateIt(this,"+i+")' onmousemove='starChoose(this)'></a>" +
		"<a href=' javascript:void(0);' onclick='rateIt(this,"+i+")' onmousemove='starChoose(this)'></a>" +
		"<a href=' javascript:void(0);' onclick='rateIt(this,"+i+")' onmousemove='starChoose(this)'></a>" +
		"<a href=' javascript:void(0);' onclick='rateIt(this,"+i+")' onmousemove='starChoose(this)'></a></td>" +
		"<td width='106'><span></span></td></tr>";
		$('#comment').append(tr);
	}
	var qd="<tr><td>评价说明：</td><td colspan='3' rowspan='2' style='padding-top:0;'>" +
			"<textarea id='commentCountent' cols='' rows=''></textarea></td></tr>" +
			"<tr><td>&nbsp;</td></tr><tr><td colspan='4'>" +
			"<table border='0' cellspacing='0' cellpadding='0' style='margin:0 auto;'>" +
			"<tr><td align='center'><input type='button' class='btn' onclick='saveComment("+obj.projectId+", "+obj.organizationId+")'  value='确定'/></td>" +
			"<td width='30'>&nbsp;</td><td  align='center'>" +
			"<input type='button' class='btn' onclick='commnetClose()' value='取 消'/></td></tr>";
	   $('#comment').append(qd);  
	//$('#comment').html("字典是2"+text+"结项值2"+""+"</tr>");
}
function showInfoList() {
	$('#targetList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	$.ajax({
		url : pathHeader + "/furtheredu/edumanage/queryEvaluationList.do",
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
		fromYear:$('#fromYear').val(),
		toYear:$('#toYear').val(),
		projectName:$('#projectName').val(),
		sizePerPage:sizePerPage, 
		pageIndex:pageIndex},
		success:function(data){
			if(data.success) {
				var indexFlag = data.startIndex ;
				var objList = data.rows;
				var roleType=data.roleType;
				var areaId = data.areaId;
				var gridHtml = "";
				$.each(objList, function(index,element) {
					indexFlag ++;
					gridHtml += getTdEHtml(element, indexFlag,roleType,areaId);
				});
				
				$('#targetList').append(gridHtml);
				
				$('#totleCount').text(data.total);
				
			} else {
				$('#targetList').html("<tr><td colspan='4'>无查询记录</td></tr>");
			}
			 pagination(data, function(){showInfoList(); });
		},
		error:function(){
		}
	});
}

function getTdEHtml(obj ,index,roleType,areaId) {
	var gridHtml = "<tr>";
	//gridHtml += "<td>"+obj.projectName+"</td>";
	//创建项目者所属地区和登陆者地区相同，方可查看项目。
//	if(obj.createByArea == areaId){	
		gridHtml += "<td><a href='javascript:projectInfo("+obj.projectId+",\"" + obj.createBy +"\",\"" + obj.applyer+ "\")'>"+obj.projectName+"</a></td>";
//	}
//	else{
//		gridHtml += "<td>"+obj.projectName+"</td>";
//	}
	gridHtml += "<td>"+obj.orgName+"</td>";
	var starCount = 1;
	var text = "";
	
	if(obj.allScore >= 1 && obj.allScore < 2) {
		text = '非常不满意';
		starCount = 1;
	}
	
	if(obj.allScore >= 2 && obj.allScore < 3) {
		text = '不满意';
		starCount = 2
	}
	
	if(obj.allScore >= 3 && obj.allScore < 4) {
		text = '一般';
		starCount = 3
	}
	
	if(obj.allScore >= 4 && obj.allScore < 5) {
		text = '满意';
		starCount = 4
	}
	
	if(obj.allScore >= 5 ) {
		text = '非常满意';
		starCount = 5
	}
	gridHtml += "<td>"
	for(var i = 0; i < starCount; i++) {
		gridHtml += "<img src='"+pathHeader +"/images/star.png' title='"+text+"' width='20' height='20' />";
	}
	gridHtml += "</td>"
		var text = "";
	/*if(roleType ==1 ){
		
		text="结项评价";
	}else{
		text="";
	}
	gridHtml += "<td><a href='###' onclick='queryChartDtial("+obj.projectId+", "+obj.orgId+")' class='tablelink click'>查看教师评价</a>&nbsp&nbsp&nbsp <a title='"+obj.projectName+"'  href='###' onclick='queryCommet("+obj.projectId+","+obj.orgId+",this)' class='tablelink comment'>"+text+"</a></td>";
	*/
	//创建项目者的所属区域和登陆者的区域相同，方可有操作权限
//	if(obj.createByArea == areaId){
		gridHtml += "<td><a href='###' onclick='queryChartDtial("+obj.projectId+", "+obj.orgId+")' class='tablelink click'>查看教师评价</a>&nbsp&nbsp&nbsp <a title='"+obj.projectName+"'  href='###' onclick='queryCommet("+obj.projectId+","+obj.orgId+",this)' class='tablelink comment'>结项评价</a></td>";
//	}
//	else{
//		gridHtml += "<td></td>";
//	}
	gridHtml += "</tr>";
	return gridHtml;
	
	function optionFormatter(rows){
		var view = "<A class='tablelink  ' href='"+pathHeader +"/furtheredu/certificate/certificateShowPage.htm?id="+rows.id+"'  target=_blank>查看 </A>";
		var edit = "<A class='tablelink click' href='###' onclick='edit("+rows.id+")' >编辑 </A>";
		var remove = "<A class='tablelink  ' href='###' onclick='deleteCertificateInfo("+rows.id+")' >删除 </A>";
		var disable = "<A class='tablelink' href='###' onclick='changeCertificateStatus("+rows.id+", 0);'>禁用 </A>";
		var enable = "<A class='tablelink' href='###' onclick='changeCertificateStatus("+rows.id+", 1);'>启用 </A>";
		var returnStr = "";
		returnStr += view;
		returnStr += edit;
		returnStr += remove;
		if(rows.status == 1) {
			returnStr += disable;
		} else if (rows.status == 0) {
			returnStr += enable;
		}   
		return returnStr;
	}
}

/**
 * 详情
 */
function info(orderId) {
	var openUrl = pathHeader + "/order/orderInfoPage.htm?orderId=" +　LogisticToString(orderId);
	showWindow(openUrl);
}

function edit(id) {
	var openUrl = pathHeader + "/furtheredu/certificate/certificateAddPage.htm?id=" +　id;
	showWindow(openUrl);
}

function showWindow(url) {
	window.location.href = url;
}

