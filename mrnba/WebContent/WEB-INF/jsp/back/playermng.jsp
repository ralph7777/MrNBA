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
		<title>Player Management</title> 
		
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
		<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
		<script src="<%=basePath%>resources/js/back/list.js"></script>
	</head>
	
	<body style="background: #e1e9eb;">
	
		<form action="<%=basePath%>PlayerList.action" id="mainForm" method="post">
		
			<div class="right">
				
				<!-- Add url here to jump to MP -->
				<!-- "location='<%=basePath%>PlayerList.action'" -->
				<div class="current">current position:<a href="<%=basePath %>index" style="color:#6E6E6E;">Homepage</a> &gt; Player Management</div>
				
				<div class="rightCont">
				
				<!-- Title, aline with batch deleting and adding -->
					<p class="g_title fix">Player List
						<!-- External js method -->
						<a class="btn03" href="javascript:deleteBatchPlayer('<%=basePath%>');">Delete</a>
						<!-- Another page -->
						<a class="btn03" href="<%=basePath%>AddPlayerButton.action">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					
					<!-- Searching -->
					<table class="tab1">
						<tbody>
							<tr>
								<td width="50" align="center">Name:&nbsp;</td>
								<td>
									<input id="searchPlayerName" name="name" type="text" class="allInput" value="${name}"/>
								</td>
								<td width="50" align="center">&nbsp;Team:&nbsp;</td>
								<td>
									<input id="searchPlayerTeam" name="team" type="text" class="allInput" value="${team}"/>
								</td>
	                            <td width="80" align="right"><input type="submit" class="tabSub" value="Search"/></td>
	       					</tr>
						</tbody>
					</table>
					
					<!-- Result display -->
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
							
								<!-- Header -->
								<tr>
									<th></th>
								    <!-- <th><input type="checkbox" id="all" onclick="#"/></th> -->
								    <th>Id</th>
								    <th>Name</th>
								    <th>Team</th>
								    <th>Number</th>								    
								    <th>Management</th>
								</tr>
								
								<!-- Body -->
								<c:forEach items="${playerList}" var="player" varStatus="status">
									<tr <c:if test="${status.index % 2 != 0}"> style="background-color:#ECF6EE;" </c:if>>
										<td>
											<input type="checkbox" name="id" value="${player.id}"/>
										</td>
										<td>${player.id}</td>
										<td>${player.name}</td>
										<td>${player.team}</td>
										<td>${player.number}</td>											
										<td>
											<a href="<%=basePath %>DeleteOnePlayer.action?id=${player.id}">delete</a>
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