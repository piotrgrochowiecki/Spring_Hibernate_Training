<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/3/2022
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Publisher List</title>
</head>
<body>
<table>
    <thead>
    <c:forEach items="${publisherList}" var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td><a href="/publishers/deleteConfirmation/${publisher.id}">Delete publisher</a></td>
            <td><a href="/publishers/edit/${publisher.id}">Edit publisher</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
