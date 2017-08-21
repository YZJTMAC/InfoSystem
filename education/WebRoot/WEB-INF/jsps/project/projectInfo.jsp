<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>查看项目</title>
		<script type="text/javascript">
		  function downloadFile(filePathName) {
	// 下载能使用jquery的ajax，因为ajax的返回值不支持流
					var url ="<%=basePathHeader%>/fileupload/downloadFiles.do" ;
					var form = $("<form>");// 定义一个form表单
					form.attr("style", "display:none");
					form.attr("method", "post");
					form.attr("action", url);
					var input = $("<input>");
					input.attr("type", "hidden");
					input.attr("name", "filePathName");
					input.attr("value", filePathName);
					$("body").append(form);// 将表单放置在web中
					form.append(input);
					form.submit();// 表单提交
				}
		</script>
	</head>
	<body>
		<!-- top -->
		<div class="head">
			<jsp:include page="../common/top.jsp">
				<jsp:param value="project" name="flag" />
			</jsp:include>
		</div>
		<!-- left -->
		<div class="leftNav">
			<%@include file="../common/projectLeft.jsp"%>
		</div>
		<div class="content">
			<div class="place">
				<span>位置：</span>
				<ul class="placeul">
					<li>
						<a href="#">培训项目管理</a>
					</li>
					<li>
						我的培训项目
					</li>
					<li>
						查看
					</li>
				</ul>
			</div>

			<div class="formbody">

				<div class="tabson" id="txtBox">
					<h4 style="padding: 0 0 20px 40px;">
						项目基本信息：
					</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td>
								继教信息模板
							</td>
							<td>
								${info.eduModelTypeName}
							</td>
						</tr>
						<tr>

							<td>
								项目名称：
							</td>
							<td colspan="4">
								${info.projectName }
							</td>
						</tr>
						<tr>
							<td width="84">
								项目年度：
							</td>
							<td width="260">
								${info.year}
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td>
								项目编号：
							</td>
							<td width="260">
								${info.projectNo }
							</td>
						</tr>


						<tr>
							<td>
								项目开始时间：
							</td>
							<td>
								${info.startDate }
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								项目结束时间：
							</td>
							<td>
								${info.endDate }
							</td>
							
							
						</tr>
						<tr>
							<td>报名方式：</td>
							<td>
							<c:if test="${info.signUpWay==3 }">
								层级分配/报名
							</c:if>
							<c:if test="${info.signUpWay==2 }">
								自由报名
							</c:if>
							<c:if test="${info.signUpWay==1 }">
								组织报名
							</c:if>
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								收费情况：
							</td>
							<td >
								${info.chargingStandard }
							</td>
						</tr>
						<tr>
						  <td>打印学时证书:</td>
						  <td>
						  <c:if test="${info.printXueshiCertificate==1 }">
								是
							</c:if>
							<c:if test="${info.printXueshiCertificate==0 }">
								否
							</c:if>
						  </td>
						  <td>&nbsp;</td>
						  <td>打印项目证书:</td>
						  <td>
						   <c:if test="${info.printProjectCertificate==1 }">
								是
							</c:if>
							<c:if test="${info.printProjectCertificate==0 }">
								否
							</c:if>
						  </td>
						</tr>
						
					</table>
					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						项目内容：
					</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td width="84">
								培训人数
							</td>
							<td width="260">
								<div class="vocation">
									${info.planNum }
								</div>
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td width="84">
							</td>
							<td width="260">
							</td>
						</tr>
						<tr>
							<td width="84">
								项目性质：
							</td>
							<td width="260">
								${info.projectScopeName }
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td width="84">
								培训范围：
							</td>
							<td width="260">
								${info.trainScopeName }
							</td>
						</tr>
						<tr>
							<td>
								培训类型：
							</td>
							<td>
								${info.projectPropertyName }
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								培训形式：
							</td>
							<td>
								${info.trainTypeName}
							</td>
						</tr>
					</table>
					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						项目培训对象：
					</h4>
					<table border="0" cellpadding="0" cellspacing="0"
						style="line-height: 42px; margin: 0 auto;">
						<tr>
							<td width="84">
								学历：
							</td>
							<td width="260">
								${info.educationBackgroundName }
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td width="84">
								学科/学段：
							</td>
							<td colspan="260">
								${info.subjectName }
							</td>
						</tr>
						<tr>
							<td width="84">
								职务：
							</td>
							<td width="260">
								${info.positionName }
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td width="84">
								职称：
							</td>
							<td width="260">
								${info.professionalTitleName }
							</td>
						</tr>
						<%--
        <tr>
          <td>是否为班主任：</td>
            <c:if test="${info.isClassCharger == 1}">
          <td> 是 </td>
          </c:if>
          <c:if test="${info.isClassCharger == 0}">
          	<td> 否 </td>
          </c:if>
           <c:if test="${info.isClassCharger == -1}">
          	<td> &nbsp; </td>
          </c:if>
          <td>&nbsp;</td>
        </tr>
        --%>
						<%--<tr>
							<td>
								是否收费：
							</td>
							<c:if test="${info.isFree == 1}">
								<td>
									是
								</td>
							</c:if>
							<c:if test="${info.isFree == 0}">
								<td>
									否
								</td>
							</c:if>
							<c:if test="${info.isFree == -1}">
								<td>
									&nbsp;
								</td>
							</c:if>
							<td width="60">
								&nbsp;
							</td>
							<td>
								收费标准：
							</td>
							<td>
								${info.chargingStandard }
							</td>
						</tr>



					--%></table>
					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						项目说明：
					</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<!-- <td width="84">
								项目范围：
							</td> -->
							<td width="260">
								${info.memo }&nbsp;
							</td>
							<td width="60">
								&nbsp;
							</td>
							<td width="84">
								&nbsp;
							</td>
							<td width="260">
								&nbsp;
							</td>
						</tr>
					</table>
				
						<h4  style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						
						项目申报书 :
			           </h4><!-- 当项目创建人或申报人和当前登录人相同时可以查看项目附件 -->
                             <c:if test="${loginame == createBy || userinfo.loginAccount == applyer}">
								
							
					   <table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<c:forEach items="${files}" var="file" varStatus="status">
							<tr style="text-align:left;">
								<td width="560" >
								【${status.index+1}】 <a href="javascript:void(0)"; onclick="previewFile('${file.url}');">${file.name}</a>
								<a class="tablelink" href="javascript:downloadFile('${file.url}')">下载申报书</a>
								</td>
								<td width="260">申报时间: ${fn:substring(file.createDate, 0,fn:length(file.createDate)-2)}  </td>
								<td width="220">申报人：${file.userName}</td>
							</tr>
						</c:forEach>
												
						
					</table>
					</c:if>
					
					<c:if test="${auditzt=='0' || auditzt=='1'}">
								
					  <table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<%-- <c:forEach items="${files}" var="file" varStatus="status">
							<tr>
								<td width="300" >
								${file.name}
								<!-- ${names[status.index]} -->
								  <a class="tablelink" href="javascript:downloadFile('${file.url}')">下载申报书</a>
								  <!-- <a href="<%=basePathHeader%>/fileupload/downloadFiles.do?filePathName=${file.url}${file.name}"
										class="tablelink">下载申报书 </a> -->
									
								</td>
								<td width="440"></td>
							</tr>
						</c:forEach> --%>
												
						
					</table>
					</c:if> 
					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						培训实施机构：
					</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<c:forEach items="${orgs}" var="o">
								<td width="84">
									${o}
								</td>
								<%--<td width="400">果实网</td> --%>
							</c:forEach>
						</tr>
					</table>
					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						继教信息：
					</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<td>
								学时:${info.classPeriod }
							</td>
							<td width="700px"></td>
						</tr>
					</table>

					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						项目状态：
					</h4>
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">
						<tr>
							<c:if test="${info.status == 10}">
								<td>
									待申报
								</td>
							</c:if>
							<c:if test="${info.status == 20}">
								<td>
									未审批
								</td>
							</c:if>
							<c:if test="${info.status == 22}">
								<td>
									审批不通过
								</td>
							</c:if>
							<c:if test="${info.status == 30}">
								<td>
									待启动
								</td>
							</c:if>
							<c:if test="${info.status == 40}">
								<td>
									进行中
								</td>
							</c:if>
							<c:if test="${info.status == 50}">
								<td>
									已结束
								</td>
							</c:if>
							<c:if test="${info.status == 60}">
								<td>
									已关闭
								</td>
							</c:if>
							<td width="700px">
								&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>

					<h4
						style="padding: 20px 0 20px 40px; margin-top: 30px; border-top: 1px dashed #a7b5bc;">
						审批记录：
					</h4>
               <c:if test="${loginame==createBy}">
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">

						<c:forEach items="${audit}" var="o">
						<c:if test="${!empty o.auditorRealName }">
							<tr>
								<td width="120">
									${o.status}
								</td>
								<td width="200">
									${o.memo}
								</td>
								<td width="100">
									${o.auditorRealName}
								</td>
								<td width="150">
									${o.auditDate}
								</td>
							</tr>
						</c:if>
						</c:forEach>

					</table>
                   </c:if>
                  
                       <c:if test="${auditzt=='0' || auditzt=='1'}">
					<table border="0" cellspacing="0" cellpadding="0"
						style="line-height: 40px; margin: 0 auto;">

						<c:forEach items="${audit}" var="o">
						<c:if test="${!empty o.auditorRealName }">
							<tr>
								<td width="120">
									${o.status}
								</td>
								<td width="200">
									${o.memo}
								</td>
								<td width="100">
									${o.auditorRealName}
								</td>
								<td width="150">
									${o.auditDate}
								</td>
							</tr>
							</c:if>
						</c:forEach>

					</table>
                   </c:if>
				</div>
				<table border="0" cellspacing="0" cellpadding="0"
					style="margin: 0 auto;">
					<%--
  <tr>
    <td><a href="peixun_1.1.html" class="dian3">返 回</a></td>
  </tr>
--%>
				</table>

			</div>


		</div>
		<div class="black" style="display: none;" id="black"></div>
	</body>
</html>
