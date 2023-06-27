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
<link rel="stylesheet" type="text/css" href="css/cart.css">
<html>
<head>
  <title>cart</title>
  <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
<form action="helloServlet" method="post">
  <input type="hidden" name="command" value="orderUpdate">
  <input type="hidden" name="num" value="-1">
  <h2 style="background-color: #ff5a36; ">장바구니</h2>
  <table class="list" border="1px" align="center">
    <c:forEach var="Cart" items="${Cart}" varStatus="status">
      <tr style="height: 90px; background-color: #f2f2f2;">
        <td style="text-align: left; text-align: center; border-right: #ff5a36;">
          <input type="checkbox" name="checkbox" value="${cart.no}">
        </td>
        <td style="border-left: none; border-right: none;"><img style="width: 150px;" src = ${Cart.image}></td>
        <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">${Cart.title}</td>
        <td><span style="padding-left: 10px;"> ${Cart.price}</span></td>
        <td>-</td>
        <td>기본배송</td>
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