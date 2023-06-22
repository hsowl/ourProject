<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-22
  Time: 오전 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrap" align="center">
        <table>
            <tr>
                <td>
                    <img src="${product.image}">
                <td>
                    <table>
                        <tr align="center">
                            <td>상품명</td>
                            <td>${product.title}</td>
                        </tr>
                        <tr align="center">
                            <td>가격</td>
                            <td><fmt:formatNumber value="${product.price}" pattern="###,###,###"/> </td>
                        </tr>
                        <tr align="center">
                            <td colspan="3">
                                <form name="form1" method="post" action="">
                                    <input type="hidden" name="productno" value="$no">
                                    <select name="amount">
                                        <c:forEach begin="1" end="10" var="i">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select>&nbsp;개
                                    <input type="submit" value="장바구니에 담기" onclick="return cartCheck()">
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <br> <input type="button" value="목록" onclick="location.href='movieList.do'">
    </form>
</div>
</body>
<%@ include file="footer.jsp"%>
</html>
