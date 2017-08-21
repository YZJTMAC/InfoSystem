var current_area=0;
$(function() {
	 getTrainTimes();// 年度培训人次统计
	
	 $('#projectYear').change(function(){
			getTrainTimes();// 年度培训人次统计
			getTtrinTeachers();// 年度教师人数统计
	 });
	/* $("#btnExport").click(function () {
         $("#tableTimes").btechco_excelexport({
             containerid: "tableTimes"
            , datatype: $datatype.Table
         });
     });
	 */
	$('#tabPage0').click(function(){
		 getTrainTimes();// 年度培训人次统计
	});
	 
	$('#tabPage1').click(function(){
		 getTtrinTeachers();// 年度教师人数统计
	});
	 
	 var tmp_area=GetURLParameter("area_id");
		if(tmp_area){
			 $('#btnBack').show();
		}else{
			 $('#btnBack').hide();
		}
	
});

function reloadData(area_id){
	 var tmp_area=GetURLParameter("area_id");
	 current_area=area_id;
	 console.log('ta='+tmp_area);
	 console.log('ca='+current_area);
	 
		if(tmp_area){
			 console.log('if(tmp_area)' );
			 $('#btnBack').show();
		}else{
			if(current_area){
				console.log('if(current_area)' );
				$('#btnBack').show();
			}else{
				console.log('if(hide)' );
			 $('#btnBack').hide();
			}
		}
	
	getTrainTimes();// 年度培训人次统计
}

function reloadDataes(area_id){
	var tmp_area=GetURLParameter("area_id");
	current_area=area_id;
	console.log('ta='+tmp_area);
	console.log('ca='+current_area);
	
	if(tmp_area){
		console.log('if(tmp_area)' );
		$('#btnBack').show();
	}else{
		if(current_area){
			console.log('if(current_area)' );
			$('#btnBack').show();
		}else{
			console.log('if(hide)' );
			$('#btnBack').hide();
		}
	}
	
	getTtrinTeachers();// 年度教师人数统计
}

//年度培训人次统计
function getTrainTimes(){
	$("#tbTimes").html('');
	
	var tmp_area=GetURLParameter("area_id");
	if(tmp_area){
		current_area=tmp_area;
	}
	
	$.ajax({
		url : pathHeader + '/stats/queryFurtherStats.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data:{
			projectYear: $('#projectYear').find("option:selected").val(),
			area_id: current_area
		},
		success : function(data) {
			if (data.success) {
				var objList = data.rows;
				var gridHtml = "";
				
				$.each(objList, function(index,element) {
					gridHtml += getTdEHtml(element, index+1);
				});
				
				$('#tbTimes').append(gridHtml);
				$('#tbTimes').find('tr:odd').addClass('odd');
				
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				alert(gridHtml);
			}
		},
		error : function() {
			gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
			alert(gridHtml);
		}
	});
}

//年度教师人数统计
function getTtrinTeachers(){
	$("#tbTeacher").html('');
	
	var tmp_area=GetURLParameter("area_id");
	if(tmp_area){
		current_area=tmp_area;
	}
	
	$.ajax({
		url : pathHeader + '/stats/queryFurtherStats.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data:{
			projectYear : $('#projectYear').find("option:selected").val(),
			area_id : current_area
		},
		success : function(data) {
			if (data.success) {
				var objList = data.rows;
				var gridHtml = "";
				
				$.each(objList, function(index,element) {
					gridHtml += getTdDataEHtml(element, index+1);
				});
				$('#tbTeacher').append(gridHtml);
				$('#tbTeacher').find('tr:odd').addClass('odd');
				
			} else {
				gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
				alert(gridHtml);
			}
		},
		error : function() {
			gridHtml = "<tr><td align='center' colspan='4'>暂无查询结果！</td></tr>";
			alert(gridHtml);
		}
	});
}

function getTdEHtml(obj,index) {
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='#' onclick='reloadData("+ obj.area_id +");' class='tablelink'>"+ obj.area_name +"</a></td>";
	gridHtml += "<td>"+ index +"</td>";
	gridHtml += "<td>"+ obj.year +"</td>";
	gridHtml += "<td>"+ (obj.train_num==null ? '0': obj.train_num) +"</td>";
	gridHtml += "<td>"+ (obj.percent==null ? '0': obj.percent) +"</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

function getTdDataEHtml(obj,index) {
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='#' onclick='reloadDataes("+ obj.area_id +");' class='tablelink'>"+ obj.area_name +"</a></td>";
	gridHtml += "<td>"+ index +"</td>";
	gridHtml += "<td>"+ obj.year +"</td>";
	gridHtml += "<td>"+ (obj.teacher_num==null ? '0': obj.teacher_num) +"</td>";
	gridHtml += "<td>"+ (obj.percent==null ? '0': obj.percent) +"</td>";
	gridHtml += "</tr>";
	return gridHtml;
}

/*var tableToExcel = (function() {
	  var uri = 'data:application/vnd.ms-excel;base64,'
	    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
	    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
	    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
	  return function(table, name) {
	    if (!table.nodeType) table = document.getElementById(table)
	    var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
	    window.location.href = uri + base64(format(template, ctx))
	  }
	})();*/
