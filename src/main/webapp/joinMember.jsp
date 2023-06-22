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
</head>
<body>
<h2>회원 가입</h2>
'*' 표시 항목은 필수 입력 항목입니다.
<form action="Servlet" method="post" name="frm">
    <table>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" size=20></td>
        </tr>
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="userid" size=20 id="userid">*
                <input type="hidden" name="reid" size=20>
                <input type="button" value="중복체크" onclick="idCheck()">
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pwd" size=20>*</td>
        </tr>
        <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" name="pwd_check" size=20>*</td>
        </tr>
        <tr>
            <td>생년월일</td>
            <td><input type="date" name="birthdate"></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="email" name="email" size=20></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" size=20></td>
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