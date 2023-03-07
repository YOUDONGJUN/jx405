<%@ page import="connector.ConnectionMaker" %>
<%@ page import="connector.MySqlConnectionMaker" %>
<%@ page import="controller.UserController" %>
<%@ page import="model.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<%
    ConnectionMaker connectionMaker = new MySqlConnectionMaker();
    UserController userController = new UserController(connectionMaker);
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    System.out.println("userId : " + userId);
    System.out.println("password : " + password);


    UserDTO userDTO = userController.auth(userId, password);
    String address;
    if (userDTO == null) {
        address = "/index.jsp";
    } else {
        address = "/index.jsp";
        session.setAttribute("logIn", userDTO);
    }
    response.sendRedirect(address);
%>
</body>
</html>
