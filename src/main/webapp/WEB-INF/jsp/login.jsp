<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<c:import url="include/head.jsp"/>
    <body>
    <c:import url="include/header.jsp"/>
        <div id="Wrapper">
            <main>
                <div id="LoginWrapper">
                    <form action="http://localhost:8080/group13/login" method="post">
                        <h3>Bitte melden sie sich an</h3>
                        <table>
                            <tr>
                                <td>Anmeldename:</td>
                                <td>
                                    <input type="text" name="username" placeholder="Name">
                                </td>
                            </tr>
                            <tr>
                                <td>Passwort:</td>
                                <td>
                                    <input type="password" name="password" placeholder="Passwort">
                                    </p> <p class="error-msg">${msg}</p>
                                </td>    
                            </tr>
                            </table>
                            <input type="submit" name="submit" value="anmelden">
                    </form>
                </div>
            </main>
        </div>
     <c:import url="include/footer.jsp"/>
    </body>
</html>
