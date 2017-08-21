/**
 * 查询学科
 */
function querySubject(){
	queryDic("project_subject")
	if(subject.length > 0){
		createOpt(subject,"subject");
	}
}

function querySubject(sid){
	queryDic("project_subject")
	if(subject.length > 0){
		createOpt(subject,sid);
	}
}

/**
 * 查询学段
 */
function querySection(){
	queryDic("stduty_section");
	if(section.length > 0){
		createOpt(section,"section");
	}
}


function createCommonOpt(rows,sid){
	for(var i = 0;i<rows.length;i++){
		var opt = "<option value='"+rows[i].id+"' ";
		opt += ">"+rows[i].text+"</option>";
		$("#"+sid).append(opt);
	}
}


function createOpt(rows,sid){
	for(var i = 0;i<rows.length;i++){
		var opt = "<option value='"+rows[i].dictionaryId+"'>"+rows[i].dictionaryName+"</option>";
		$("#"+sid).append(opt);
	}
}



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

function delProject(id){
	var url = pathHeader+ "/edupm/projectmanage/delProject.do";
		$.ajax({
			url:url,
			data:{
			proId:id
			},
			type:"post",
			async:false,
			success:function(data){
				if(data.success){
					projectList();
				}
			},
			error:function(){
				alert("URL error！");
			}
		})
}
function del(id){
	jQuery.confirmWindow("", "确定要删除该项目？", function(){delProject(id); });
}

function setup(id){
	var url = pathHeader + "/edupm/projectmanage/toModifyProPage.htm?click=0&proId="+id;
	openWindow(url);
}

function projectInfo(id,createBy,applyer){
	//var url = pathHeader+ "/edupm/projectmanage/projectInfo.htm?click=0&proId="+id+"&createBy="+createBy+"&auditStatus="+auditStatus+"&applyer="+applyer;
	var url = pathHeader+ "/edupm/projectmanage/projectInfo.htm?click=0&proId="+id+"&createBy="+createBy+"&applyer="+applyer;
	window.open(url);
}
