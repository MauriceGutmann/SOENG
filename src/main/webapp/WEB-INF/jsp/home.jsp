<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="include/head.jsp"/>
<body>
	<c:import url="include/header.jsp"/>
	<div id="MainWrapper">
	<h2>Welcome ${userName}!</h2>
	<c:if test = "${isAdmin}">
		<a href="admin">Administration</a>
	</c:if>
	<br/>
	<a href="logout">Logout</a>
	<br/>
	<button id="getProjects" >projects</button>
	<br/>
	<p id="projects"/>
	<p id="project"></p>
	<script src="resources/js/scriptProject.js"></script>
	</div>
	<c:import url="include/footer.jsp"/>
</body>
</html>