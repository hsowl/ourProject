<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-22
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
  <title>cart</title>
  <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
<form action="/hello-servlet" method="post">
  <input type="hidden" name="command" value="orderUpdate">
  <h2>장바구니</h2>
  <table class="list" border="1px" align="center">
    <c:forEach var="product" items="${product}">
    <tr>
      <input type="checkbox" name="">
      <td>${product.image}</td>
      <td>${product.title}</td>
      <td>${product.price}</td>
      <td>${product.id}</td>
      <td>${product.no}</td>
      <td></td>
      <td><input type="hidden" name="id" value="${product.id}"></td>
      <td><input type="hidden" name="no" value="${product.no}"></td>
    </tr>
    </c:forEach>
  </table>
  <div id="cart" align="center">
    <input type="submit" value="주문하기" >
    <input type="reset" value="취소">
  </div>
</form>
</body>
<%@ include file="footer.jsp"%>
</html>