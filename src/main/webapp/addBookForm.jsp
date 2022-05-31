<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 5/31/2022
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
Add book:
<form:form modelAttribute="book" method="post" action="/addBookByForm">
    Title: <form:input path="title"/><br>
    Rating: <form:input path="rating"/><br>
    Description: <form:textarea path="description" cols="20" rows="20"/><br>
<%--    Publisher: <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name"/><br>--%>
    <input type="submit">
</form:form>
</body>
</html>
