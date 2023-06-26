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
        function insert(url,name){
            window.open(url,name,"width=600, height=500");
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
                <th><strong>제목</strong></th>
                <th><strong>내용</strong></th>
                <th><strong>작성자</strong></th>
            </tr>
            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td><a href="Servlet?command=board_view&no=${board.no}">
                            ${board.title } </a></td>
                    <td>${board.content}</td>
                    <td>${board.id}</td>
                </tr>
            </c:forEach>
            <tr>
                <input type="button" value="게시글 등록"
                       onclick="insert('Servlet?command=boardWriteForm&no=${product.no}','insert')">
                <input type="button" value="게시글 수정"
                       onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'write')">
                <input type="button" value="게시글 삭제"
                       onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'delete')">
            </tr>
        </table>
        </div>
</body>
<%@ include file="footer.jsp"%>
</html>
