<%--
  Created by IntelliJ IDEA.
  User: Jimin
  Date: 2023-06-22
  Time: 오전 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>로그인</h2>
<form name="frm" method="post" action="Servlet">
  <input type="hidden" name="command" value="login">
  <table>
    <tr>
      <td>아이디</td>
      <td><input type="text" name="id"></td>
    </tr>
    <tr>
      <td>비밀번호</td>
      <td><input type="password" name="pw"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
        <input type="reset" value="취소">&nbsp;&nbsp;
        <input type="button" value="회원가입" onclick="location.href='joinMember.jsp'">
      </td>
    </tr>
    <tr>
      <td colspan="2">${message}</td>
    </tr>
  </table>
</form>
</body>
</html>