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
		<title>Add New Team</title> 
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	
	<body style="background: #ffffff;">
		<form action="<%=basePath%>AddOneTeam.action" method="post">
			<!-- Title -->
			<p class="g_title fix">&nbsp;&nbsp;Add New Team</p>

			<!-- Input List -->
			<table class="tab1">
				<tbody>
					<tr>
						<td width="110" align="center">Team Name:&nbsp;&nbsp;</td>
						<td>
							<input name="tnameAdd" type="text" class="allInput" required="required"/>
						</td>
		       		</tr>
					<tr>		       								
						<td width="110" align="center">Full Name:&nbsp;&nbsp;</td>
						<td>
							<input name="tfullnameAdd" type="text" class="allInput"/>
						</td>
		       		</tr>
					<tr>
						<td width="110" align="center">State:&nbsp;&nbsp;</td>
						<td>
							<input name="tstateAdd" type="text" class="allInput"/>
						</td>	
					</tr>
					<tr>
						<td width="110" align="center">Arena:&nbsp;&nbsp;</td>
						<td>
							<input name="tarenaAdd" type="text" class="allInput"/>
						</td>	
					</tr>
					<tr>
						<td width="110" align="center">Year:&nbsp;&nbsp;</td>
						<td>
							<input name="tyearAdd" type="text" class="allInput"/>
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
