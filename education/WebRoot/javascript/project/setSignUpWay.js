$(function(){
	projectList();

  $(".sure").click(function(){
	  var radioVal = $("input[name='radio']:checked").val();
	  var url = pathHeader +"/edupm/projectmanage/setWay.do";
	  $.ajax({
		  url:url,
		  type:"post",
		  data:{way:radioVal,proId:proId},
		  async:true,
		  success:function(data){
			  if(data.success != -1){
				  if(data.success){
				  	projectList();
				 	 $(".tip").fadeOut(100);
			  	}
			  }else{
				  jQuery.generalAlert("已经有报名的教师，不能更改报名方式！");
				  $(".tip").fadeOut(100);
			  }
		  },
		  error:function(){
			  jQuery.generalAlert("url error!");
		  }
	  });
  	
	});
  
  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});
});

function projectList(){
	$('#proList').html("");
	var sizePerPage = $("#sizePerPage").val();
	var pageIndex = $("#pageIndex").val();
	
	var url = pathHeader+ "/edupm/projectmanage/projectList.do";
	
	$.ajax({
		url:url,
		type:"post",
		data:{
			projectName : $('#projectName').val(),
			start : $('#beginDate').val(),
			end : $('#endDate').val(),
			startIndex : pageIndex
		},
		async:true,
		success:function(data){
			var rows = data.rows;
			if(rows.length > 0){
				var gridHtml = "";
				$.each(rows, function(index,element) {
					gridHtml += getTdHtml(element);
				});
				$('#proList').append(gridHtml);
				pagination(data, function(){projectList();});
			}else{
				$('#proList').html("<tr><td colspan='4'>无查询记录</td></tr>");
			}
		},
		error:function(){
			
		}
		
	});
	
}


function getTdHtml(obj){
	var gridHtml = "<tr>";
	gridHtml += "<td><a href='javascript:projectInfo("+obj.id+")'>"+obj.projectName+"</a></td>";
//	gridHtml += "<td>"+obj.startDate+"</td>";
//	gridHtml += "<td>"+obj.endDate+"</td>";
//	gridHtml += "<td>"+obj.trainTypeName+"</td>";
//	gridHtml += "<td>"+obj.projectScopeName+"</td>";
	gridHtml += "<td>"+obj.planNum+"</td>";
	if(obj.signUpWay == 1){
		gridHtml += "<td>组织报名</td>";
	}else if(obj.signUpWay == 2){
		gridHtml += "<td>自由报名</td>";
	}else{
		gridHtml += "<td></td>";
	}
//	gridHtml +="<td>"+obj.classPeriod+"学时/"+obj.classScore+"学分"+"</td>";
	gridHtml += "<td>"+optionFormatter(obj)+"</td></tr>";
	
	return gridHtml;
	
	function optionFormatter(row){
		var returnStr = "";
		if(row.signUpWay == null){
			returnStr += 	 "<a href='###' class='huibtn_a click' onclick='setup(\"" + row.id + "\");'>设置报名方式</a>";
		} else if(row.signUpWay == 1){
			returnStr += "<a href='###' class='huibtn_a click' onclick='toImportTeachersPage(\"" + row.id + "\");'>导入教师名单</a>";
			returnStr += 	 "<a href='###' class='huibtn_a click' onclick='setup(\"" + row.id + "\");'>调整报名方式</a>";
		}else if(row.signUpWay == 2){
			returnStr += 	 "<a href='###' class='huibtn_a click' onclick='setup(\"" + row.id + "\");'>调整报名方式</a>";
		}
		return returnStr;
	}
}

function projectInfo(id){
	var url = pathHeader+ "/edupm/projectmanage/projectInfo.htm?proId="+id;
	openWindow(url);
}


var proId;
function setup(id){
//	$(".tip").fadeIn(200);
	proId = id;
	$(".tip").fadeIn(200);
}

function toImportTeachersPage(id){
	var url = pathHeader +"/edupm/projectmanage/toBatchSignUpPage.htm?proId="+id+"&click=1";
	openWindow(url);
}

function qryPro(){
	
	if(validateYear()){
		projectList();
		
	}else{
		jQuery.generalAlert("查询开始年度不能大于结束年度！");
	}
}