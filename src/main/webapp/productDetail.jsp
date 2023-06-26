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
    <script type="text/javascript">
        function insert(){
            let options = "toolbar=no,scrollbars=no,resizable=yes,status=no,menubar=no,width=1200, height=800, top=0,left=0";

            window.open("http://www.naver.com","_blank", options);
        }
    </script>
    <script type="text/javascript" src="script/cartgo.js"></script>
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
                                    <input type="hidden" name="id" value=${id.id}>
                                    <input type="hidden" name="no" value=${product.no}>
                                    <input type="submit" value="장바구니에 담기" onclick="return confirmSelection()">
                                </form>
                                <input type="submit" value="구매하기">
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
                <tr>
                    <td><a href="Servlet?command=board_view&no=${board.no}">
                            ${board.title } </a></td>
                    <td>${board.content}</td>
                </tr>
            </c:forEach>
            <tr>
                <input type="button" onclick="insert()" value="현재창에서 열기"/>
                <input type="button" value="게시글 삭제"
                       onclick="return insert()">
            </tr>
        </table>
        </div>
</body>
<%@ include file="footer.jsp"%>
</html>
