<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-26
  Time: PM 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<%@ include file="header.jsp" %>
<body>
<div id="jongjin" align="center">
    <table border="1px" class="list">
        <c:forEach var="product" items="${product}">
            <tr class="product">
                <td><img src= ${product.image}></td>
                <td>
                    <a href="Servlet?command=productDetail&no=${product.no}">${product.title}</a>
                    <br><br><br>
                    <fmt:formatNumber value="${product.price}" pattern="###,###,###"/>원
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
