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
    <script type="text/javascript">
        function open_win(url,name){
            window.open(url,name,"width=500, height=200");
        }
    </script>
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
    <br> <br>
    <input type="button" value="게시글 수정" onclick="open_win('Servlet?command=boardConfirmForm&seq=${board.seq}', 'update')">
    <input type="button" value="게시글 삭제" onclick="open_win('Servlet?command=boardConfirmForm&seq=${board.seq}', 'delete')">
</div>
</body>
</html>
