<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/3/2022
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authors List</title>
</head>
<body>
<table>
  <thead>
  <c:forEach items="${authorList}" var="author">
    <tr>
      <td>${author.firstName}</td>
      <td>${author.lastName}</td>
      <td><a href="/authors/deleteConfirmation/${author.id}">Delete author</a></td>
      <td><a href="/authors/edit/${author.id}">Edit author</a></td>
    </tr>
  </c:forEach>
  </thead>
</table>
</body>
</html>
