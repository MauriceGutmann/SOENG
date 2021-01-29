<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<c:import url="include/head.jsp"/>
	<body>
	<c:import url="include/header.jsp"/>
                <div id="MainWrapper">
                <h1>Project ${Project1.name}</h1>
                <br/>
                <div id="TableWrapper">
                <br/>
                <table class="table table-striped">
                	<tr><th>Name</th><th>Created</th></tr>
                	<c:forEach items="${Retros}" var = "retro">
                		<tr><td><a href="retro?id=<c:out value = "${retro.id}"/>"><c:out value = "${retro.name}"/></a></td>
 						<td><c:out value = "${retro.created}"/></td></tr>
 					</c:forEach>
                </table>
                </div>
                <br/>
                <a href="home">Home</a>	
				</div>
    <c:import url="include/footer.jsp"/>
	</body>
</html>