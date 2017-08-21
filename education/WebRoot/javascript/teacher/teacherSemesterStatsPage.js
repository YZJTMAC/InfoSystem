//0.全局变量
var edu=new Array();//学历字典
var pro=new Array();//职称字典
var sub=new Array();//学科字典

//1.取表头
function getThead(){
	getEduHead();//学历 educational_user
	getProHead();//职称 teacher_professional
	//getSubHead();//学科 project_subject
}

//2.给表填充数据
function getTbody(){
	getEduBody();//学历
	getProBody();//职称
	//getSubBody();//学科
	getAgeBody();//年龄段
}

function getProHead(){
	var dict2_type='teacher_professional';
	 var thEdu=$('#thPro');
	 getDict(pro,thEdu,dict2_type);
	 pro.push('无教师职称');
}
function getEduHead(){
	 var dict2_type='educational_user';
 	 var thEdu=$('#thEdu');
	 getDict(edu,thEdu,dict2_type);
	 $('#extEdu').val(edu);
}
function getSubHead(){
	var dict2_type='project_subject';
	 var thEdu=$('#thSub');
	 getDict(sub,thEdu,dict2_type);
}

function getEduBody(){
	var dict2_type='educational_user';
	var tbody=$('#tbEdu'); 
	getBodyList(edu,tbody,dict2_type);
	//console.log('eud='+edu);
	//alert(edu);
	//showExportData(edu);
}

function getProBody(){
	var dict2_type='teacher_professional';
	var tbody=$('#tbPro'); 
	getBodyList(pro,tbody,dict2_type);
}

function getSubBody(){
	var dict2_type='project_subject';
	var tbody=$('#tbSub'); 
	getBodyList(sub,tbody,dict2_type);
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
				//console.log(dictArray);
				//console.log(th);
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
	th+='<th ></th>';
	th+='<th >编号</th>';
		th+='<th>小计</th>';
	
	for (var i = 0; i < obj.length; ++i) {
		th += "<th >"+obj[i]+"</<th >";
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
			_type:"1",
			_dict1_type:"stduty_section",
			_dict1_id:"0",
			dictionaryTypeId : dict_type,
			pageIndex : 1,
			pageSize:20
		},
		success:function(data){
			 
			if(data && data.success) {
				var objList = data.rows;
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
	//console.log('dict='+dict);
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
	    		dictCount =0;
	    	}
	    	count+=dictCount;
	    	
	    	tdDict += "<td>"+dictCount+"</<td >";
		}
	    tr +="<td>"+count+"</td>";
	    tr += tdDict;
	    tr += "</tr>";
		trs+=tr;
		//console.log(trs);
	}
	
	return trs;
}
function showExportData(){
	var head = getHead();
	console.log("head");
	console.log(head);
	 $('#hideTableEdu').dataTable({
		 "sAjaxDataProp": "rows",
		  "ajax":{
	             "url": pathHeader + '/stats/teacherRegionStatsProfession.do',
	             "type":"POST",
	             "dataType": 'json',
	             "data":  {
	                    "_type":"1",
	        			"_dict1_type":"stduty_section",
	        			"_dict1_id":"0",
	        			"dictionaryTypeId" : "educational_user",
	        			"pageIndex" : "1",
	        			"pageSize":"20"
	             }  
	           },
		"dataSrc":"",
		"aoColumns":head,
		paging: false ,
	       processing: false,
	        dom: 'T<"clear">',
	        tableTools: {
	           "sSwfPath":pathHeader+"/javascript/common/DataTables/extensions/TableTools/swf/copy_csv_xls_pdf.swf",
	            "aButtons": [
	                        /* "copy",
	                         "print", */
				              {
				                "sExtends": "csv",
				                "sButtonText": "导出"
				              } /*,
				              {
				                "sExtends": "copy",
				                "sButtonText": "复制"
				              },
				                {
				                    "sExtends":    "collection",
				                    "sButtonText": "Save",
				                    "aButtons":    [ "csv", "xls", "pdf" ]
				                }*/
	            ]
	        }

		 
	}); 
}

function getHead(){
	  var h=new Array();
      var o = {};
		o.mDataProp="dict1_name";
		o.sTitle="";
		o.bSortable="false";
		h.push(o);
		edu.forEach(function(e){
			var o = {};
			o.mDataProp=e;
			o.sTitle=e;
			o.bSortable="false";
			h.push(o);
		});
	return h;
}


$(document).ready(function() {
	getThead(); //取表头
	getTbody(); //给表填充数据
	 
	//showExportData();
	$('#hideTableEdu').hide();
	 setTimeout( showExportData, 3000);
});

