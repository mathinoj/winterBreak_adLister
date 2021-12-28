<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Welcome to das site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1 class="my-3 text-center">Gyms</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Gym Name</th>
            <th>Type</th>
            <th>Membership Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${gyms}" var="gym">
            <tr>
                <td>${gym.name}</td>
                <td>${gym.type}</td>
                <td>${gym.membership}</td>
                <td>
                    <input type="button" class="btn-increment" value="-" onclick="button1()" />
                    <input type="button" class="btn-decrement" value="2" onclick="button2()" />
                    <span id="output-area"></span>
                    <form action="/gyms/delete" method="post">
                        <input type="hidden" name="gym_id" value="${gym.id}">
                        <input class="btn btn-danger btn-sm" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
