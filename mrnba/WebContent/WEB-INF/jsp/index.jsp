<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>Index</title> 
		
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
		<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
	</head>
	
	<body style="background: #e1e9eb;">
	
		<form action="<%=basePath%>PlayerList.action" id="mainForm" method="post">
		
			<div class="right">
				
				<!-- Add url here to jump to MP -->
				<div class="current">current position:<a href="javascript:void(0)" style="color:#6E6E6E;">Homepage</a></div>

				<div class="rightCont">
					<p class="k_title">
						<a href="<%=basePath %>InitTalkP.action">Talk about NBA player</a>
					</p>
					<br/>
					<p class="k_title">
						<a href="<%=basePath %>InitTalkT.action">Talk about NBA team</a>
					</p>
					<br/>				
					<p class="k_title">
						<a href="<%=basePath %>PlayerList.action">Management - player</a>
					</p>
					<br/>
					<p class="k_title">
						<a href="<%=basePath %>TeamList.action">Management - team</a>
					</p>

				</div>
			</div>
	    </form>
	</body>

</html>