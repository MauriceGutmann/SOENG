<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="include/head.jsp"/>
    <body>
    <c:import url="include/header.jsp"/>
        <div id="Wrapper">
            <main>
            <h1>Retro : ${Retro.name}</h1>
                <div id="LoginWrapper">
                	<form action="retro" method="post">
                        <table>
                            <tr>
                                <td>Name:</td>
                                <td>
                                    <input type="text" name="name" value="${Retro.name}" oninput="EnableSaveButton()"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Scheduled:</td>
                                <td>
                                    <input type="datetime" name="scheduled" value="${Retro.scheduled}" oninput="EnableSaveButton()"/>
                                    <p> <p class="error-msg">${msg}</p>
                                </td>    
                            </tr>
                            </table>
                            <c:choose>
    								<c:when test="${Retro.active}">
        								<input type="checkbox" name="active" checked />
    								</c:when>    
    								<c:otherwise>
    									<input type="checkbox" name="active"/>
    								</c:otherwise>
								</c:choose>
                            <input id="saveButton" type="submit" name="submit" value="save" disabled="disabled"/>
                            <input type="hidden" name="id" value="${Retro.id}"/>
                    </form>
                </div>
            </main>
        </div>
     <c:import url="include/footer.jsp"/>
    </body>
    <script>
    	function EnableSaveButton(){
    		var btn = document.getElementById('saveButton');
    		btn.removeAttribute("disabled");}
    </script>
</html>