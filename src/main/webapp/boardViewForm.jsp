<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-27
  Time: 오전 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/qna.css">
    <script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
    <h1>게시글 상세보기</h1>
    <table>
        <tr>
            <th>작성자</th>
            <td>${board.id}</td>
            <th>제목</th>
            <td>${board.title}</td>
            <th>내용</th>
            <td>${board.content}</td>
        </tr>
    </table>
    <br> <br> <input type="button" value="게시글 수정"
                     onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.no}', 'update')">
    <input type="button" value="게시글 삭제"
           onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.no}', 'delete')">
    <input type="button" value="게시글 리스트"
           onclick="location.href='BoardServlet?command=board_list'">
    <input type="button" value="게시글 등록"
           onclick="location.href='BoardServlet?command=board_write_form'">
</div>
</body>
</html>
