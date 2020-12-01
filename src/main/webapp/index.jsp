<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.andersenlab.katokoleg.servlets.controller.command.CommandType" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="sign-in">
    <c:if test="${not empty requestScope.message}">
        <c:out value="${requestScope.message.badMessage}"/>
    </c:if>
    <form method="post" class="sign-in-form" action="${pageContext.request.contextPath}/users/${sessionScope.user.id}">
        <label for="login">Login:</label><br>
        <input type="text" class="intup" id="login" name="login"><br><br>
        <label for="password">Password:</label><br>
        <input type="password" class="intup" id="password" name="password"><br><br>
        <input type="hidden" name="command_name" value="${CommandType.SIGN_IN_COMMAND.getName()}">
        <input type="submit" class="sign-button" value="Sign in">
    </form>
</div>

</body>
</html>