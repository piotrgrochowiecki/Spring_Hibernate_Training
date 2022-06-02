<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/2/2022
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<html>
<head>
    <title>Editing of ${book.title} book</title>
</head>
<body>
Edit book:
<form:form modelAttribute="book" method="post" action="/books/editConfirmation">
    Title: <form:input path="title"/><br>
    Rating: <form:input path="rating"/><br>
    Description: <form:textarea path="description" cols="100" rows="20"/><br>
    Publisher: <form:select path="publisher.id" items="${publishers}" itemValue="id" itemLabel="name"/><br>
    Authors: <form:select path="authors" items="${authors}" itemValue="id" itemLabel="lastName"/><br>
    <input type="submit">
</form:form>
</body>
</html>
