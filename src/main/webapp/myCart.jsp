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
<html>
<head>
  <title>cart</title>
</head>
<body>
<c:forEach var="product" items="${product}">
<div id="cart" align="center">
  <h2>상품 목록</h2>
  <table class="list">
    <tr class="record">
      <td>${product.image}</td>
      <td>${product.title}<br>${product.name}</td>
      <td>${product.price}</td>
      <td><button onclick="addOrderSearch(count,${product.no})">주문목록에 추가</button></td>
    </tr>
  </table>
  </c:forEach>
  <div id="cart">
    <h2>장바구니</h2>
    <input type="submit" value="주문하기" onclick="return ">
    <input type="reset" value="취소">
  </div>
</div>
</div>
</body>
<%@ include file="footer.jsp"%>
</html>