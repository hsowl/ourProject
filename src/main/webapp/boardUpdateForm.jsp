<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-27
  Time: 오후 2:49
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
<div id="zzz" align="center">
  <h1>게시글 수정</h1>
  <form name="frm" method="post" action="Servlet">
    <input type="hidden" name="command" value="board_update">
    <input type="hidden" name="seq" value="${board.seq}">
    <input type="hidden" name="no" value="${board.no}">
    <table>
      <tr>
        <th>작성자</th>
        <td><input type="text" size="12" name="id"
                   value="${board.id}" readonly="true"></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" size="12" name="pass"> *
          0                    필수 (게시물 수정 삭제시 필요합니다.)</td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input type="text" size="70" name="title"
                   value="${board.title}"></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea cols="70" rows="15" name="content">${board.content}</textarea></td>
      </tr>
    </table>
    <br>
    <br> <input type="submit" value="등록"> <input type="reset" value="다시 작성">
  </form>
</div>
</body>
</html>