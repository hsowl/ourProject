<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-23
  Time: 오후 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>결제내역리스트</title>
</head>
<body>
<form action="Servlet" method="post">
    <h2>결제내역조회</h2>
    <h3>주문일자 검색</h3>
    <select name="date">
        <option name="date" value="-1">전체</option>
        <option name="date" value="0">1개월 내</option>
        <option name="date" value="1">3개월 내</option>
    </select>
    <input type="hidden" name="command" value="orderSearch">
    <input type="submit" value="조회">
    <br><br>
    <table class="list" border="1px" align="center">
        <tr>
            <td></td>
            <td>상품코드</td>
            <td>상품명</td>
            <td>가격</td>
            <td>주문일자</td>
        </tr>
        <c:forEach var="orderSearch" items="${orderSearch}">
        <tr class="record">
            <td style="border-left: none; border-right: none;"><img style="width: 150px;" src = ${orderSearch.image}></td>
            <td>${orderSearch.no}</td>
            <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">${orderSearch.title}</td>
            <td><span style="padding-left: 10px;"><fmt:formatNumber value="${orderSearch.price}" pattern="###,###,###"/>원</span></td>
            <td>${orderSearch.orderDate}</td>
            <td><input type="hidden" name="delete" value="${orderSearch.no}"><input type="submit" value="삭제"></td>
        </tr>
        </c:forEach>
    </table>
    <div >
        <input type="button" value="메인화면으로 가기" onclick="location='Servlet?command=main'">
    </div>
</form>
</body>
<%@ include file="footer.jsp"%>
</html>
