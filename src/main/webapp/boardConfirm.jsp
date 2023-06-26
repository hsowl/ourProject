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
</head>
<body>
<script type="text/javascript">
  if(window.name=='insert'){
    window.opener.parent.location.href=
            "Servlet?command=boardWriteForm&no=${param.id}";
  }else if(window.name=='delete'){
    alert("삭제되었습니다");
    window.opener.parent.location.href=
            "BoardServlet?command=board_delete&num=${param.num}";
  }
  window.close();
</script>
</body>
</html>
