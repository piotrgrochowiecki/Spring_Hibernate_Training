<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/3/2022
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Editing of ${publisher.name}</title>
</head>
<body>
Edit publisher:
<form:form modelAttribute="publisher" method="post" action="/publishers/editConfirmation">
    First Name: <form:input path="name"/><br>
    <input type="submit">
</form:form>
</body>
</html>