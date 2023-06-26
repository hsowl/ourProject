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
    <script type="text/javascript" src="script/update.js"></script>
</head>
<%@ include file="header.jsp" %>
<body>
<h2 align="center">내 정보 수정</h2>
<form method="post" action="Servlet?command=infoUpdate" name="frm">
    <table align="center" border="1px">
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${id.name}"></td>
        </tr>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${id.id}"></td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input type="password" name="pw" value="${id.pw}"></td>
        </tr>
        <tr>
            <th>PW Check</th>
            <td><input type="password" name="pwCheck"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="email" name="email" value="${id.email}"></td>
        </tr>
        <tr>
            <th>생년월일</th>
            <td><input type="text" name="birthDate" value="${id.birthDate}" readonly="readonly"></td>
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
            <td><input type="text" name="phone" value="${id.phone}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input align="center" type="submit" value="확인" onclick="return update()">
                <input align="center" type="reset" value="취소">
            </td>
        </tr>
    </table>
</form>
</body>
<%@ include file="footer.jsp" %>
</html>
