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
  <script type="text/javascript" src="script/member.js"></script>
    <title>로그인 - 11번가</title>
    <div class="jimin-header">
      <h1 calss="jimin-header_logo">
        <a href="login.jsp"><img src="https://c.011st.com/img/common/v3/logoday.png" alt="11번가 로고"></a>
      </h1>
    </div>
</head>
<body>
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