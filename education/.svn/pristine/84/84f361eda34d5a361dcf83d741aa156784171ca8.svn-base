$(function(){
	$('#queryYear').val(queryYear);
	queryRemainQuery();
})

/**
 * 查询去年结余学时学分
 */
 var creditStr = "";
function queryRemainQuery(){
	creditStr = "";
	queryYear = $('#queryYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryRemainScore.do";
	$('#queryList').html("");
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			queryYear:queryYear,
			teacherId:teacherId
		},
		beforeSend: function(){
			$('#queryList').html("<tr><td align='center' colspan='14'><img src='"+pathHeader+"/images/loding.gif'  alt='加载中'/></td></tr>");
		},
		success:function(data){
			var gridHtml = "";
			gridHtml += getObjHtml1(data);
			queryList(gridHtml);
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});

}

function queryList(gridHtml){
	var queryYear = $('#queryYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherScore.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			queryYear:queryYear,
			teacherId:teacherId
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml(element);
				});
			}
			
			$('#creditRule').html("<li>要求学分："+data.needCredit+"</li>");
			queryIsList(gridHtml);
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}
/**
 * 查询自主研修
 * @param gridHtml
 */
function queryIsList(gridHtml){
	var queryYear = $('#queryYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherIsScore.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			queryYear:queryYear,
			teacherId:teacherId,
			status:2
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml4(element);
				});
			}
			queryCreditLend(gridHtml);
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}
/**
 * 查询借贷记录
 * @param gridHtml
 */
function queryCreditLend(gridHtml){
	var lendYear = $('#queryYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			lendYear:lendYear,
			lendStatus: "审批通过,已偿还",
			teacherId:teacherId
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml2(element);
				});
			}
			queryRepayCreditLend(gridHtml);
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}
/**
 * 查询偿还记录
 * @param gridHtml
 */
function queryRepayCreditLend(gridHtml){
	var lendYear = $('#queryYear').val();
	var url = pathHeader + "/teacher/teacherProject/queryTeacherLendCredit.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			lendYear:lendYear - 1,
			lendStatus: "已偿还",
			teacherId:teacherId
		},
		success:function(data){
			var rows = data.rows;
			var totalNum = data.count;
			if(rows.length > 0){
				$.each(rows, function(index,element) {
					gridHtml += getObjHtml3(element);
				});
			}
			getTotalCredit();
			if(gridHtml == null){
				$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
			}else{
				$('#queryList').html(gridHtml);
			}
		},
		error:function(){
			$('#queryList').html("<tr><td colspan='14'>无查询记录</td></tr>");
		}
		
	});
}
function getTotalCredit(){
	var url = pathHeader + "/teacher/teacherProject/getTotal.do";
	$.ajax({
		url:url,
		type:"post",
		async:true,
		data:{
			creditStr : creditStr
		},
		success:function(data){
			$('#creditMap').html("<li>获得学分："+data.credit+"</li>");
		},
		error:function(){}
	});
}

function getObjHtml(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.projectName+"</td>";
		gridHtml += "<td>"+obj.trainFormName+"</td>";
		gridHtml += "<td>"+obj.teacherClassScore+"</td>";
		gridHtml+= "</tr>";

		var studyCredit = (obj.trainFormName+"="+obj.teacherClassScore+",");
		creditStr += studyCredit;
	return gridHtml;
}
//查询结余
function getObjHtml1(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>去年结余学时学分</td>";
		gridHtml += "<td></td>";
		gridHtml += "<td>"+obj.remainCredit+"</td>";
		gridHtml+= "</tr>";
		creditStr += obj.remainCredit + ",";
	return gridHtml;
}
//查询借贷
function getObjHtml2(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td><font color='red'> 学分借贷</font></td>";
		gridHtml += "<td><font color='red'>"+obj.trainFormName+"</font></td>";
		gridHtml += "<td><font color='red'>"+obj.lendCredit+"</font></td>";
		gridHtml+= "</tr>";
		var lendCredit = (obj.trainFormName+"="+obj.lendCredit+",");
		creditStr += lendCredit;
	return gridHtml;
}
//查询 
function getObjHtml3(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td><font color='red'>偿还学分借贷</font></td>";
		gridHtml += "<td><font color='red'>-"+obj.trainFormName+"</font></td>";
		gridHtml += "<td><font color='red'>-"+obj.repayCredit+"</font></td>";
		gridHtml+= "</tr>";

		var repayCredit = (obj.trainFormName+"=-"+obj.repayCredit+",");
		creditStr += repayCredit;
	return gridHtml;
}
//自主研修
function getObjHtml4(obj){
	var gridHtml = "<tr>";
		gridHtml += "<td>"+obj.isStudyTypeName+"</td>";
		gridHtml += "<td>"+obj.trainFormName+"</td>";
		gridHtml += "<td>"+obj.isCredit+"</td>";
		gridHtml+= "</tr>";
		var studyCredit = (obj.trainFormName+"="+obj.isCredit+",");
		creditStr += studyCredit;
	return gridHtml;
}