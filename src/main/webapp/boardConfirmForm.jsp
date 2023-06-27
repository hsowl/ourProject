<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-26
  Time: 오후 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/qna.css">
    <script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div align="center">
    <h1>비밀번호 확인</h1>
    <form action="Servlet" name="frm" method="get">
        <input type="hidden" name="command" value="boardConfirm">
        <input type="hidden" name="seq" value="${param.seq}">
        <table style="width: 80%">
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pass" size="20"></td>
            </tr>
        </table>
        <br> <input type="submit" value=" 확 인 "
                    onclick="return loginCheck()"> <br>
        <br>${message}
    </form>
</div>
</body>
</html>
