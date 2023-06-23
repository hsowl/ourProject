<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-23
  Time: PM 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/myInfoStyle.css">
</head>
<%@ include file="header.jsp" %>
<body>
<h2 align="center">나의 정보 페이지</h2>
<table align="center" border="1px">
    <tr>
        <th>이름</th>
        <td>${id.name}</td>
    </tr>
    <tr>
        <th>ID</th>
        <td>${id.id}</td>
    </tr>
    <tr>
        <th>pw</th>
        <td>${id.pw}</td>
    </tr>
    <tr>
        <th>email</th>
        <td>${id.email}</td>
    </tr>
    <tr>
        <th>생년월일</th>
        <td>${id.birthDate}</td>
    </tr>
    <tr>
        <th>성별</th>
        <c:choose>
            <c:when test="${id.gender == 1}">
                <td>남자</td>
            </c:when>
            <c:otherwise>
                <td>여자</td>
            </c:otherwise>
        </c:choose>
    </tr>
    <tr>
        <th>전화번호</th>
        <td>${id.phone}</td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input align="center" type="button" onclick="수정으로갈예정임" value="회원정보 수정">
        </td>
    </tr>
</table>
</body>
<%@ include file="footer.jsp" %>
</html>
