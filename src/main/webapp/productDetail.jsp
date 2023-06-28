<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href="css/qna.css">

<html>
<head>
    <title>Title</title>
    <!-- 부트스트랩 CSS 링크 추가 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        /* 커스텀 스타일 */
        .product-image {
            width: 100%;
            height: auto;
        }
        .qna-header {
            margin-top: 2rem;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <img src="${product.image}" class="product-image">
        </div>
        <div class="col-md-6">
            <table class="table">
                <tr>
                    <th>상품명</th>
                    <td>${product.title}</td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td><fmt:formatNumber value="${product.price}" pattern="###,###,###"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form name="frm1" method="post" action="Servlet">
                            <input type="hidden" name="command" value="cartUpdate">
                            <input type="hidden" name="id" value="${id.id}">
                            <input type="hidden" name="no" value="${product.no}">
                            <input type="submit" class="btn btn-primary" value="장바구니에 담기" onclick="return cartConfirmSelection()">
                        </form>
                        <form name="frm2" method="post" action="Servlet">
                            <input type="hidden" name="command" value="directOrderUpdate">
                            <input type="hidden" name="no" value="${product.no}">
                            <input type="submit" class="btn btn-primary" value="구매하기" onclick="return orderConfirmSelection()">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div id="qna" class="qna-header">
        <h1 class="display-4">Q&A</h1>
        <table class="table table-striped">
            <tr>
                <td colspan="3">
                    <input style="text-align: left" type="button" class="btn btn-primary" value="게시글 등록" onclick="insert('Servlet?command=boardInsertForm&no=${product.no}','insert')">
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <th>내용</th>
                <th>작성자</th>
            </tr>
            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td><a href="#" onclick="view('Servlet?command=boardViewForm&seq=${board.seq}','view'); return false">${board.title}</a></td>
                    <td>${board.content}</td>
                    <td>${board.id}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<!-- 부트스트랩 JS 및 jQuery 링크 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<!-- 추가적인 자바스크립트 코드 작성 -->
<script type="text/javascript">
    function cartConfirmSelection() {
        var response = confirm("장바구니에 담으시겠습니까?");
        if (response) {
            return true;
        } else {
            return false;
        }
    }

    function orderConfirmSelection() {
        var response = confirm("구매하시겠습니까?");
        if (response) {
            return true;
        } else {
            return false;
        }
    }

    function insert(url, name) {
        window.open(url, name, "width=600, height=500");
    }

    function view(url, name) {
        window.open(url, name, "width=600, height=500");
    }
</script>

</body>
<%@ include file="footer.jsp"%>
</html>
