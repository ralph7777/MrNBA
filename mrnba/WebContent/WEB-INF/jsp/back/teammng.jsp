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
		<title>team Management</title> 
		
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
		<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
	</head>
	
	<body style="background: #e1e9eb;">
	
		<form action="<%=basePath%>TeamList.action" id="teamForm" method="post">
		
			<div class="right">
				
				<!-- Add url here to jump to MP -->
				<!-- "location='<%=basePath%>TeamList.action'" -->
				<div class="current">current position:<a href="<%=basePath %>index" style="color:#6E6E6E;">Homepage</a> &gt; Team Management</div>
				
				<div class="rightCont">
			
					<!-- Searching -->
					<table class="tab1">
						<tbody>
							<tr>
								<td width="50" align="center">Team:&nbsp;</td>
								<td>
									<input id="searchTeamName" name="searchTeamName" type="text" class="allInput" value="${name}"/>
								</td>
	                            <td width="80" align="right"><input type="submit" class="tabSub" value="Search"/></td>
	       					</tr>
						</tbody>
					</table>
					
					<br/>
					<!-- Titile -->
					<p class="g_title fix">Team List
						<a class="btn03" href="<%=basePath%>AddTeamButton.action">Add team</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					
					<!-- Team List -->
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<!-- Header -->
								<tr>
								    <th>Name</th>
								    <th>Full Name</th>
								    <th>State</th>
								    <th>Arena</th>								    
								    <th>Year of Establishment</th>
								    <th>Management</th>	
								</tr>
								
								<!-- Body -->
								<c:forEach items="${teamList}" var="team" varStatus="status">
									<tr <c:if test="${status.index % 2 != 0}"> style="background-color:#ECF6EE;" </c:if>>
										<td>${team.name}</td>
										<td>${team.fullname}</td>
										<td>${team.state}</td>
										<td>${team.arena}</td>
										<td>${team.year}</td>
										<td>
											<a href="<%=basePath %>UpdateTeamButton.action?name=${team.name}">update</a>&nbsp;&nbsp;&nbsp;
											<a href="<%=basePath %>DeleteOneTeam.action?name=${team.name}">delete</a>
										</td>
																			
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					<br/>
					<!-- Titile -->
					<p class="g_title fix">Team Information List
						<a class="btn03" href="<%=basePath%>AddTeamInfoButton.action">Add info</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					
					<!-- TeamInfo List -->
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<!-- Header -->
								<tr>
									<th>Id</th>
								    <th>Name</th>
								    <th>Information</th>
								    <th>Management</th>								    
								</tr>
								
								<!-- Body -->
								<c:forEach items="${teamInfoList}" var="teamInfo" varStatus="status">
									<tr <c:if test="${status.index % 2 != 0}"> style="background-color:#ECF6EE;" </c:if>>
										<td>${teamInfo.id}</td>
										<td>${teamInfo.name}</td>
										<td>${teamInfo.information}</td>								
										<td>
											<a href="<%=basePath %>DeleteOneTeamInfo.action?id=${teamInfo.id}">delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
				</div>
			</div>
	    </form>

	    
	    
	</body>

</html>