<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8"/>
</head>
<body>

    <form action="/login" method="post">
        <c:if test="${param.error != null}">
            <p>Invalid username or password.</p>
        </c:if>
        <c:if test="${param.logout != null}">
            <p>You have been logged out successfully.</p>
        </c:if>
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <br/>
    <a href="/"> index page </a>
</body>
</html>