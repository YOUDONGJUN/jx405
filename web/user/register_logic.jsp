<%@ page import="model.UserDTO" %>
<%@ page import="connector.ConnectionMaker" %>
<%@ page import="connector.MySqlConnectionMaker" %>
<%@ page import="controller.UserController" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: BIT
  Date: 2023-02-10
  Time: 오전 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
//    Date birthDate = request.getParameter("birthDate");
//    System.out.println(request.getParameter("birthDate"));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    Date birthDate = sdf.parse(request.getParameter("birthDate"));
//    System.out.println("bDate: " + bDate);
    Date birthDate = sdf.parse(request.getParameter("birthDate"));
    String phoneNumber = request.getParameter("phoneNumber");
    String email = request.getParameter("email");

    UserDTO userDTO = new UserDTO();
    userDTO.setUserId(userId);
    userDTO.setPassword(password);
    userDTO.setName(name);
    userDTO.setBirthDate(birthDate);
    userDTO.setPhoneNumber(phoneNumber);
    userDTO.setEmail(email);

    ConnectionMaker connectionMaker = new MySqlConnectionMaker();
    UserController userController = new UserController(connectionMaker);

    boolean result = userController.insert(userDTO);
    System.out.println("result : "+result);

    if (result) {
        System.out.println("success");
        response.sendRedirect("/index.jsp");
    } else {
%>
<script>
    alert("중복된 아이디로 가입하실 수 없습니다.");
    history.go(-1);
</script>
<%
    }
%>
</body>
</html>