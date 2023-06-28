<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/qna.css">
    <script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="qna" align="center">
    <h1>게시글 등록</h1>
    <form name="frm" method="post" action="Servlet">
        <input type="hidden" name="command" value="boardInsert">
        <input type="hidden" name="no" value="${param.no}">
        <table>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="id" value="${id.id}" readonly="true"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="pass"> * 필수 (게시물 수정
                    삭제시 필요합니다.)</td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" size="70" name="title"> * 필수</td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea cols="70" rows="15" name="content"></textarea></td>
            </tr>
        </table>
        <br>
        <br> <input type="submit" value="등록"> <input type="reset" value="다시 작성">
    </form>
</div>
</body>
</html>