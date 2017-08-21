<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@include file="../common/commonHead.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查看报名教师</title>
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
						<a href="#">培训名额上报</a>
					</li>
					<li>
						<a href="#">查看报名教师</a>
					</li>
				</ul>
			</div>

			<div class="formbody">
				<div class="tabson">
					<p class="xmTool">
						项目名称：
						<b>${name }</b>计划培训人数：
						<b>${num }</b> 地区:
						<b id="area">${area }</b> 当前地区名额:
						<b id="num">${planNum }</b>
					</p>
				</div>
				<table class="tablelist" style="margin-top: 0px;">
					<thead>
						<tr>
							<th>
								姓名
							</th>
							<th>
								身份证号
							</th>
							<th>
								学科
							</th>
							<th>
								省
							</th>
							<th>
								市
							</th>
							<th>
								县
							</th>
							<th>
								校
							</th>
							<th>
								手机
							</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${info}" var="o">
							<tr>
								<td>
									${o.realName}
								</td>
								<td>
									${o.idNumber}
								</td>
								<td>
									${o.jobFormerTeachingSubject}
								</td>
								<td>
									${o.userProvinceName}
								</td>
								<td>
									${o.userCityName}
								</td>
								<td>
									${o.userDistrict}
								</td>
								<td>
									${o.schoolName}
								</td>
								<td>
									${o.mobile}
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>