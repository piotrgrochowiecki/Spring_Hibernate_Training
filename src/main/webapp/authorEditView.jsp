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
    <title>Editing of ${author.fullName}</title>
</head>
<body>
Edit book:
<form:form modelAttribute="author" method="post" action="/authors/editConfirmation">
    First Name: <form:input path="firstName"/><br>
    Last Name: <form:input path="lastName"/><br>
    <input type="submit">
</form:form>
</body>
</html>