$(function(){
	initTrainForm();
	queryList();
	lastForSure();
	initChecked();
});
var forms = null;
function initTrainForm(){
	var url = pathHeader+ "/org/queryPxxsList.do";
	$.ajax({
		url:url,
		data:{},
		type:"post",
		async:false,
		success:function(data){
			if(data.rows.length > 0){
				forms = data.rows;
			}
		},
		error:function(){
		}
	});
}
function search(){
	queryList();
}
var aId = "";
function queryList(){
	
	if(aId != $("#areaId").val()){
		aId = $("#areaId").val();
		$("#pageIndex").val(1);
	}
	
	var idNumber = $("#idNumber").val();
	var teacherName = $("#teacherName").val();
	var schoolName = $('#schoolName').val();
	var areaId = $('#areaId').val();
	var areaType = $('#areaType').val();
	var queryYear = $('#queryYear').val();
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();

	var url = pathHeader + "/furtheredu/edumanage/queryCreditList.do";
	$('#dataList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			idNumber:idNumber,
			startIndex : pageIndex,
			pageSize:sizePerPage,
			teacherName: teacherName,
			schoolName : schoolName,
			areaId: areaId,
			areaType: areaType,
			queryYear:queryYear
		},
		beforeSend: function(){
			$('#dataList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
				$('#dataList').html(gridHtml);
				pagination(data, function(){queryList();});
			}else{
				$('#dataList').html("<tr><td colspan='14'>无查询记录</td></tr>");
				pagination(data, function(){queryList();});
			}
			getAndSetChecked();
		},
		error:function(){
			$('#dataList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
	});
}

function getObjHtml(obj){
	var rowStr = "<tr>";
	rowStr += "<td><input name='chk_list' type='checkbox' value='"+obj.teacherId+"'></td>";
	rowStr += "<td>"+obj.teacherName+"</td>";
	rowStr += "<td>"+ obj.schoolName+"</td>";
	rowStr += "<td>"+ obj.idNumber+"</td>";
	if(obj.remainCredit == null || obj.remainCredit == ""){
		rowStr += "<td>无结余</td>";
	}else{
		rowStr += "<td>"+ obj.remainCredit+"</td>";
	}
	rowStr += "<td>"+ obj.totalScore +"("+obj.score1+")"+"</td>";
//	rowStr += "<td><a href='javascript:toTeacherCredit("+obj.teacherId+")'>查询教师详细学分</a> &nbsp;&nbsp;";
//				if(obj.pushExcellent == 0){
//					rowStr += 	"<a href='javascript:pushExcellent("+obj.teacherId+")'>推优</a>";
//				}else{
//					rowStr += 	"<a href='javascript:pushedExcellent("+obj.teacherId+")'>已推优</a>";
//				}
//				rowStr += 	"</td>";
	rowStr += "</tr>";
	return rowStr;
}

/**
 * 推优，向表edu_teacher_train_score中添加一条数据
 * @param teacherId
 */
function pushExcellent(teacherId){}

/**
 * 查看教师具体成绩
 * @param teacherId
 */
function toTeacherCredit(teacherId){
	var queryYear = $('#queryYear').val();
	var url =  pathHeader + "/furtheredu/edumanage/toScoreQuery.htm?click=26&teacherId="+teacherId+"&queryYear="+queryYear+"&info=from";
	window.location.href=url;
}

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
		$('#areaType').val(areaA);
		$('#areaId').val(belone);
	}
	//清空
	clear();
	
	$(".tip11").fadeOut(200);
}


function initChecked(){
	$("#chk_all").click(function() {
		if($(this).attr("checked")){
			$("input[name='chk_list']").attr("checked", $(this).attr("checked"));			
		}
		else{
		$("input[name='chk_list']").attr("checked", false);
		}
	});
}


//子选项全选中同时选中全选项, 子选项未选中全选项取消选中
function getAndSetChecked(){	
	$("input[name='chk_list']").click(function(){		
		if($(this).attr("checked")){			
			var sum = 0;
			$("input[name='chk_list']").each(function(){
				if($(this).attr("checked")){
					sum += 1;
				}
				else{
					sum += 0;
				}
			});
			if(sum == $("input[name='chk_list']").length){
				$("#chk_all").attr("checked",true)
			}
		}
		else{
			$("#chk_all").attr("checked",false)
		}
	});
}
/**
 * 获得选中ids
 * @param str
 */
function getCheckedIds() {
	var arrChk = $("input[name='chk_list']:checked");
	var idStr = "";
	$(arrChk).each(function() {
		idStr += this.value + ",";
	});
	idStr = idStr.substring(0, idStr.length - 1);
	$('#checkedId').val(idStr);
}

function exportExl(){
	$('#myModal').modal('show');
	getCheckedIds();
	var teacherIds = $('#checkedId').val();
	var idNumber = $("#idNumber").val();
	var teacherName = $("#teacherName").val();
	var schoolName = $('#schoolName').val();
	var areaId = $('#areaId').val();
	var areaType = $('#areaType').val();
	var queryYear = $('#queryYear').val();
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	var url = "/furtheredu/edumanage/exportTeacherCredit.do?teacherIds="+teacherIds+"&idNumber="+idNumber+"&teacherName="+teacherName
				+"&areaId="+areaId+"&areaType="+areaType+"&queryYear="+queryYear+"&sizePerPage="+sizePerPage
				+"&pageIndex="+pageIndex;
	$("#downIframe",document.body).attr("src",pathHeader + url);
	$('#myModal').modal('hide');

}