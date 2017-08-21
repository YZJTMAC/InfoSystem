$(document).ready(function() {
	getThead(); //取表头
	getTbody(); //给表填充数据
});

//0.全局变量
var edu=new Array();//学历字典
var pro=new Array();//职称字典

//1.取表头
function getThead(){
	getEduHead();//学历 educational_user
	getProHead();//职称 teacher_professional
}

//2.给表填充数据
function getTbody(){
	getEduBody();//学历
	getProBody();//职称
	getAgeBody();//年龄段
}

function getProHead(){
	var dict2_type='teacher_professional';
	 var thEdu=$('#thPro');
	 getDict(pro,thEdu,dict2_type);
}
function getEduHead(){
	 var dict2_type='educational_user';
 	 var thEdu=$('#thEdu');
	 getDict(edu,thEdu,dict2_type);
}
 

function getEduBody(){
	var dict2_type='educational_user';
	var tbody=$('#tbEdu'); 
	getBodyList(edu,tbody,dict2_type);
}

function getProBody(){
	var dict2_type='teacher_professional';
	var tbody=$('#tbPro'); 
	getBodyList(pro,tbody,dict2_type);
	pro.push('无教师职称');
}

 

function getAgeBody(){
	var dict2_type='age';
	var tbody=$('#tbAge'); 
	var  age =['age0','age1','age2','age3','age4','age5','age6','age7','age8','age9'];
	getBodyList(age,tbody,dict2_type);
}

function getDict(dictArray,thead,dict_type) {

	$.ajax( {
		url : pathHeader + '/dictionary/dictionaryManages/dictionaryList.do',
		type : "POST",
		cache : "false",
		async : "true",
		dataType : "json",
		data : {
			dictionaryTypeId : dict_type,
			sizePerPage : 400,
			pageIndex : 0
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
//				console.log(dictArray);
//				console.log(th);
				thead.html(th);
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
	th+='<th></th>';
	th+='<th  >编号</th>';
	th+='<th >小计</th>';
	
	for (var i = 0; i < obj.length; ++i) {
		th += "<th  >"+obj[i]+"</<th >";
	}
	th += "</tr>";
	return th;
}

function getBodyList(dictArray,tbody,dict_type){
	$.ajax({
		url : pathHeader + '/stats/teacherRegionStatsProfession.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			_type:"0",
			_dict1_type:"",
			_dict1_id:"0",
			dictionaryTypeId : dict_type,
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data && data.success) {
				var objList = data.rows;
				var str = JSON.stringify(objList);
				var trs= formatDictRows(dictArray,objList);//formatRows(objList);
				tbody.append(trs);
				
			} else {
				 var row = tbody.prev('thead').find('tr th');
				 tbody.append('<tr><td colspan='+row.length+'>查询失败!</td></tr>');
			}
		},
		error:function(){
			 var row = tbody.prev('thead').find('tr th');
			 tbody.append('<tr><td colspan='+row.length+'>查询错误!</td></tr>');
		}
	});
}
 

function formatDictRows(dict,rows){
//	console.log('dict='+dict);
	var trs="";
	for (var index = 0; index < rows.length; ++index) {
		var tmp=rows[index];
		var curRowIndex=index+1;
	    var tr="<tr>";
	    tr +="<td>"+tmp['dict1_name']+"</td>";
	    tr +="<td>"+curRowIndex+"</td>";
	   
	    var count=0;
	    var tdDict="";
	    for (var i = 0; i < dict.length; ++i) {
	    	var dictCount=tmp[dict[i]]; 
	    	if(!dictCount){
	    		dictCount=0;
	    	}
	    	count+=dictCount;
	    	tdDict += "<td>"+dictCount+"</<td >";
		}
	   
	    tr +="<td>"+count+"</td>";
	    tr += tdDict;
	    tr += "</tr>";
		trs+=tr;
//		console.log(trs);
	}
	
	return trs;
}



/*
$(document).ready(function() {
		 showList() ;
		 showProList();
		 getEduList(); //地区学历统计
		 getProList();//地区职称统计
		  getAgeList();//地攻年龄段统计
		 
});

function formatHeader(obj){
	var th="<tr>";
	th+='<th width="10%"></th>';
	th+='<th width="4%">编号</th>';
		th+='<th width="5%">小计</th>';
	
	for (var i = 0; i < obj.length; ++i) {
		th += "<th >"+obj[i]+"</<th >";
	}
	th += "</tr>";
	return th;
//	$('#thEdu').html(th);
}
function getProList(){
	$.ajax({
		url : pathHeader + '/stats/teacherRegionStatsProfession.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			dictionaryTypeId : "teacher_professional",
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
//				alert("success.");
				var objList = data.rows;
				var trs= formatDictRows(pro,objList);
				$('#tbPro').append(trs);
				
			} else {
				alert("failure.");
			}
		},
		error:function(){
			alert("error.");
		}
	});
}

function getAgeList(){
	var age =new Array();
	age =['age0','age1','age2','age3','age4','age5','age6','age7','age8','age9'];
	$.ajax({
		url : pathHeader + '/stats/teacherRegionStatsProfession.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			dictionaryTypeId : "age",
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				 
				var objList = data.rows;
				 var trs= formatDictRows(age,objList);
				$('#tbAge').append(trs);
				
			} else {
				alert("failure.");
			}
		},
		error:function(){
			alert("error.");
		}
	});
}


function getEduList(){
	$.ajax({
		url : pathHeader + '/stats/teacherRegionStatsProfession.do',
		type:"POST",
		cache:"false",
		async:"true",
		dataType:"json",
		data:{
			dictionaryTypeId : "educational_user",
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			if(data.success) {
				var objList = data.rows;
				var trs= formatRows(objList);
				$('#tbEdu').append(trs);
				
			} else {
				alert("failure.");
			}
		},
		error:function(){
			alert("error.");
		}
	});
}


function formatRows(rows){
	console.log('edu='+edu);
	var trs="";
	for (var index = 0; index < rows.length; ++index) {
		var tmp=rows[index];
		var curRowIndex=index+1;
	    var tr="<tr>";
	    tr +="<td>"+tmp['dict1_name']+"</td>";
	    tr +="<td>"+curRowIndex+"</td>";
	   
	    var count=0;
	    var tdDict="";
	    for (var i = 0; i < edu.length; ++i) {
	    	var dictCount=tmp[edu[i]]; 
	    	count+=dictCount;
	    	
	    	tdDict += "<td width='5%'>"+dictCount+"</<td >";
		}
	    tr +="<td>"+count+"</td>";
	    tr += tdDict;
	    tr += "</tr>";
		trs+=tr;
		console.log(trs);
	}
	
	return trs;
}

function formatDictRows(dict,rows){
	console.log('dict='+dict);
	var trs="";
	for (var index = 0; index < rows.length; ++index) {
		var tmp=rows[index];
		var curRowIndex=index+1;
	    var tr="<tr>";
	    tr +="<td>"+tmp['dict1_name']+"</td>";
	    tr +="<td>"+curRowIndex+"</td>";
	   
	    var count=0;
	    var tdDict="";
	    for (var i = 0; i < dict.length; ++i) {
	    	var dictCount=tmp[dict[i]]; 
	    	count+=dictCount;
	    	
	    	tdDict += "<td width='5%'>"+dictCount+"</<td >";
		}
	    tr +="<td>"+count+"</td>";
	    tr += tdDict;
	    tr += "</tr>";
		trs+=tr;
		console.log(trs);
	}
	
	return trs;
}

 

var edu=new Array();
function showList() {
	 
			$.ajax( {
				url : pathHeader + '/dictionary/dictionaryManages/dictionaryList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					dictionaryTypeId : "educational_user",
					sizePerPage : 400,
					pageIndex : 0
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$.each(objList, function(index, element) {
							var dictname=element.dictionaryName;
							edu.push(dictname);
						});
						var th= formatHeader(edu);
						$('#thEdu').html(th);
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
 

var pro=new Array();
function showProList() {
	 
			$.ajax( {
				url : pathHeader + '/dictionary/dictionaryManages/dictionaryList.do',
				type : "POST",
				cache : "false",
				async : "true",
				dataType : "json",
				data : {
					dictionaryTypeId : "teacher_professional",
					sizePerPage : 400,
					pageIndex : 0
				},
				success : function(data) {
					if (data.success) {
						var objList = data.rows;
						var gridHtml = "";
						$.each(objList, function(index, element) {
							var dictname=element.dictionaryName;
							pro.push(dictname);
						});
						var th= formatHeader(pro);
						$('#thPro').html(th);
					} else {
						gridHtml = "<tr><td align='center' colspan='4'>职称暂无查询结果！</td></tr>";
						alert(gridHtml);//$('#dictionary_list').append(gridHtml);
					}
				},
				error : function() {
					gridHtml = "<tr><td align='center' colspan='4'>职称暂无查询结果！</td></tr>";
					alert(gridHtml);//$('#dictionary_list').append(gridHtml);
				}
			});
}
*/