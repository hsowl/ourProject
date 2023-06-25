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
    <title>주문조회리스트</title>
</head>
<body>
<form action="Servlet?command=orderSearch" method="post">
    <h2>주문조회</h2>
    <h3>주문일자 검색</h3>
    <select name="date">
        <option value="-1">전체</option>
        <option value="0">1개월 내</option>
        <option value="1">3개월 내</option>
    </select>
    <input type="submit" value="검색">
    <table class="list" border="1" align="center">
    <c:forEach var="product" items="${product}">
            <tr class="record">
                <td>${orderSearch.no}</td>
                <td>${orderSearch.title}<br>${orderSearch.name}</td>
                <td>${orderSearch.price}원</td>
            </tr>
    </table>
    </c:forEach>
    <div >
        <input type="button" value="메인화면으로 가기" onclick="location='Servlet?command=main'">
    </div>
</form>
</body>
<%@ include file="footer.jsp"%>
</html>
