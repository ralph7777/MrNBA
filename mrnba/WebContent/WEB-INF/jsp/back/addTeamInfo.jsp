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
		<title>Add Team Info</title> 
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	
	<body style="background: #ffffff;">
		<form action="<%=basePath%>AddOneTeamInfo.action" method="post">
			<!-- Title -->
			<p class="g_title fix">&nbsp;&nbsp;Add Team Info</p>

			<!-- Input List -->
			<table class="tab1">
				<tbody>
					<tr>
						<td width="110" align="center">Team Name:&nbsp;&nbsp;</td>
						<td>
							<input name="tnameAdd" type="text" class="allInput" style="width:300px"/>
						</td>
		       		</tr>
					<tr>		       								
						<td width="110" align="center">Information:&nbsp;&nbsp;</td>
						<td>
							<textarea name="tinfoAdd" rows="3" cols="1" style="width:300px; height:69px; line-height:23px; border:1px solid #c3ced0"></textarea>
							<!-- <input name="tinfoAdd" type="text" class="allInput"  style="width:120px; height:69px; line-height:23px; border:1px solid #c3ced0"/>
							 -->
						</td>
		       		</tr>
					<tr>
						<td width="80" align="center">
							<input type="submit" class="tabSub" value="Add" />
						</td>
						<td width="80" align="center">
							<input type="button" class="tabSub" onclick="location='<%=basePath%>TeamList.action'" value="Cancel" />
						</td>		
		       		</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
