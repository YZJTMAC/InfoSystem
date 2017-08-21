<%@ page pageEncoding="UTF-8"%>
<%@ page import="project.util.ApplicationProperties" %>
<%
	String basePathHeader = request.getContextPath();
	String eduHostPath = ApplicationProperties.getPropertyValue("eduHostPath").toString();
	
	String imageServer = request.getContextPath();
	if (ApplicationProperties.getPropertyValue("imageServer").toString().length() > 0)
		imageServer = ApplicationProperties.getPropertyValue("imageServer").toString();
		
	String pdfImageServer = request.getContextPath();
	if (ApplicationProperties.getPropertyValue("pdfImageServer").toString().length() > 0)
		pdfImageServer = ApplicationProperties.getPropertyValue("pdfImageServer").toString();	
%>

<script type="text/javascript">  
    var pathHeader = '<%=basePathHeader%>';
    var eduHostPath = '<%=eduHostPath%>';
    var imageServer='<%=imageServer%>';
    var pdfImageServer='<%=pdfImageServer%>';
</script>

<script type="text/javascript">
	var urls ='<%=session.getAttribute("roleUrl")%>';
		urls = urls.substring(1,urls.length-1).replace(" ","").split(",");
		function judgeAuthority(uri){
			for(var i = 0;i<urls.length;i++){
				var url =trim(urls[i]);
				if(url == uri){
					return true;
				}
			}
			return false;
	}
	
	function trim(url){
		return url.replace(/(^\s*)|(\s*$)/g,"");
	}
</script>
