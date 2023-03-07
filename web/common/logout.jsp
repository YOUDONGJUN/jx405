<%--
  Created by IntelliJ IDEA.
  User: ehdwnsdb
  Date: 2023-03-07
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그아웃</title>
</head>
<body>
<%
  session.invalidate();
  response.sendRedirect("/index.jsp");
  System.out.println("logOut ok");
%>

</body>
</html>
