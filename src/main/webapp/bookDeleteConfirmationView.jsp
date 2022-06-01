<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/1/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Confirmation</title>
</head>
<body>
<c:out value="Are you sure you want to delete book ${book.title}?"></c:out>
<a href="/books/delete/${book.id}">Yes, delete</a>
<a href="/books/findAll">No, go back to book list</a>
</body>
</html>
