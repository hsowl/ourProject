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
</head>
<body>
<form action="/hello-servlet" method="post">
  <h2>상품 목록</h2>
  <table class="list" border="1" align="center">
    <c:forEach var="product" items="${product}">
    <tr class="record">
      <td> <img src="${product.image}"></td>
      <td>${product.title}<br>${product.name}</td>
      <td>${product.price}원</td>
      <td><button onclick="insertOrderSearch(${product.id},${product.no})">주문하기</button></td>
      <--addOrderSearch(${product.no})==주문시 product.no 받아서 orderDB에 추가하는 함수-->
    </tr>
    </c:forEach>
  </table>
  <div id="cart">
    <h2>장바구니</h2>
    <input type="button" value="주문목록 보기" onclick="location.href='hello-servlet?command=orderSearch'">
    <input type="reset" value="취소">
  </div>
</form>
</body>
<%@ include file="footer.jsp"%>
</html>