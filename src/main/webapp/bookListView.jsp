<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/1/2022
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<table>
    <thead>
    <c:forEach items="${bookList}" var="book">
    <tr>
        <td>${book.title}</td>
        <td>${book.rating}</td>
        <td>${book.description}</td>
        <td><a href="/books/deleteConfirmation/${book.id}">Delete book</a></td>
        <td><a href="/books/edit/${book.id}">Edit book</a></td>
    </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
