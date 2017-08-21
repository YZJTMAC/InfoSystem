$(function(){
//	showTeacherAssessList();
	getThead(); //取表头
	getTbody(); //给表填充数据
});

//0.全局变量
var dictArray=new Array();//学段字典 

//1.取表头
function getThead() {
	 
	$.ajax( {
		url : pathHeader + '/dictionary/dictionaryManages/dictionaryList.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			dictionaryTypeId : "school_type",
			sizePerPage : 400,
			pageIndex : 0,
			status : 1
		},
		success : function(data) {
			if (data.success) {
				var objList = data.rows;
				var gridHtml = "";
				$.each(objList, function(index, element) {
					var dictname=element.dictionaryName;
					dictArray.push(dictname);
				});
				var th= formatHeader(dictArray);
				console.log(dictArray);
				console.log(th);
				$('#thSchool').html(th);
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>学历暂无查询结果！</td></tr>";
				alert(gridHtml);//$('#dictionary_list').append(gridHtml);
			}
		},
		error : function() {
			gridHtml = "<tr><td align='center' colspan='4'>学历暂无查询结果！</td></tr>";
			alert(gridHtml);//$('#dictionary_list').append(gridHtml);
		}
	});
}

function formatHeader(obj){
	var th="<tr>";
	th+='<th width="6%"></th>';
	th+='<th width="4%">编号</th>';
		th+='<th width="5%">小计</th>';
	
	for (var i = 0; i < obj.length; ++i) {
		th += "<th >"+obj[i]+"</<th >";
	}
	th += "</tr>";
	return th;
}

//2.给表填充数据
function getTbody(){
	showTeacherAssessList();
}

function showTeacherAssessList(){
	$('#tableList').html('');
	$.ajax({
		url : pathHeader + '/stats/querySchoolStats.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data : {
			area_id:"0",
			dictionaryTypeId : "school_type",
			sizePerPage : 400,
			pageIndex : 0
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				console.log(objList);
				var trs= formatDictRows(dictArray,objList);//formatRows(objList);
				$('#tbSchool').append(trs);
				
				/*var gridHtml = "";
				$.each(objList, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#tableList').append(gridHtml);*/
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				$('#tableList').append(gridHtml);
			}
		},
		error:function(){
			gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
			$('#tableList').append(gridHtml);
		}
	});
}


function formatDictRows(dict,rows){
	console.log('dict='+dict);
	var trs="";
	for (var index = 0; index < rows.length; ++index) {
		var tmp=rows[index];
		var curRowIndex=index+1;
	    var tr="<tr>";
	    tr +="<td>"+tmp['area_name']+"</td>";
	    tr +="<td>"+curRowIndex+"</td>";
	   
	    var count=0;
	    var tdDict="";
	    for (var i = 0; i < dict.length; ++i) {
	    	var dictCount=tmp[dict[i]]; 
	    	count+=dictCount;
	    	
	    	tdDict += "<td >"+dictCount+"</<td >";
		}
	    tr +="<td>"+count+"</td>";
	    tr += tdDict;
	    tr += "</tr>";
		trs+=tr;
		console.log(trs);
	}
	
	return trs;
}
function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td>"+obj.year+"年</td>";
	gridHtml += "<td>"+obj.teacherClassScore+"学分</td>";
	if(obj.isAssess=="1"){
		gridHtml += "<td>已达标</td>";
	}else{
		gridHtml += "<td><i>未达标</i></td>";
	}
	gridHtml += "<td><a href=\""+pathHeader+"/furtheredu/edumanage/teacherAssessWithYearInfo.htm?year="+obj.year+"\">查看年度详情</a></td>";
	return gridHtml;
}
