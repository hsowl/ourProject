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
<link rel="stylesheet" type="text/css" href="css/qna.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table>
            <tr>
                <td>
                    <img src=${product.image}>
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
                                <form name="form1" method="post" action="Servlet">
                                    <input type="hidden" name="command" value="cartUpdate">
                                    <input type="submit" value="장바구니에 담기" onclick="return cartCheck()">
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
        <div id="wrap" align="center">
        <h1>Q&A</h1>
        <table class="list">
            <tr>
                <th>제목</th>
                <th>내용</th>
            </tr>
            <c:forEach var="board" items="${boardList}">
                <tr class="record">
                    <td>${board.no}</td>
                    <td><a href="Servlet?command=board_view&no${board.no}">
                            ${board.title } </a></td>
                    <td>${board.content}</td>
                </tr>
            </c:forEach>
            <tr>
                <input type="button" value="게시글 등록"
                       onclick="open_win('Servlet?command=Board_write_form&no=${board.no}', 'write')">
            </tr>
        </table>
        </div>
</body>
<%@ include file="footer.jsp"%>
</html>
