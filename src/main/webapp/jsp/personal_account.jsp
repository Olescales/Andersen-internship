<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="Hello${sessionScope.user.login}"/>

<c:if test="${sessionScope.user.roles.contains('ADMIN')}">
    <form class="admin_room">
        <input type="submit" class="button" value="Enter to admin room">
    </form>
</c:if>
