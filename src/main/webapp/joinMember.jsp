<%--
  Created by IntelliJ IDEA.
  User: Jimin
  Date: 2023-06-22
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2>회원 가입</h2>
'*' 표시 항목은 필수 입력 항목입니다.
<form action="Servlet" method="post" name="frm">
    <input type="hidden" name="command" value="joinMember">
    <table>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" size=20>*</td>
        </tr>
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="id" size=20 id="id">*
                <input type="hidden" name="reid" size=20>
                <input type="button" value="중복체크" onclick="idCheck()">
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pw" size=20>*</td>
        </tr>
        <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" name="pw_check" size=20>*</td>
        </tr>
        <tr>
            <td>주민등록번호</td>
            <td><input type="text" name="birthDate">앞 6자리만 입력해 주세요</td> <%-- js에서 6자리 넘어가면 체크하게 --%>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="email" name="email" size=20></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" size=20>*</td>
        </tr>
        <tr>
            <td>성별</td>
            <td>
                <input type="radio" name="gender" value="1" checked="checked"> 남
                <input type="radio" name="gender" value="2"> 여
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="확인" onclick="return joinCheck()">&nbsp;&nbsp;
                <input type="reset" value="취소">
            </td>
        </tr>
        <tr><td colspan="2">${message}</td></tr>
    </table>
</form>
</body>
</html>