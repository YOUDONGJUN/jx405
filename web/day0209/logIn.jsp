<%@ page import="dbConn.MySqlConnectionMaker" %>
<%@ page import="dbController.UserController" %>
<%@ page import="model.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: ehdwnsdb
  Date: 2023-02-09
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  String username = request.getParameter("username");
  String password = request.getParameter("password");

    MySqlConnectionMaker connectionMaker = new MySqlConnectionMaker();
    UserController userController = new UserController(connectionMaker);

    UserDTO userDTO = userController.auth(username, password);

    System.out.println(userDTO);

    if(userDTO == null){
      response.sendRedirect("/day0209/index.jsp");
    } else {
      response.sendRedirect("/day0209/printList.jsp");
    }


%>

</body>
</html>
