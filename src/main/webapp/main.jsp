<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-22
  Time: AM 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="jongjin" align="center">
    <table class="list">
        <c:forEach var="product" items="${product}">
            <tr class="product">
                <td>${product.title}</td>
                <td>${product.price}원</td>
                <td>${product.image}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<%@ include file="footer.jsp"%>
</html>
