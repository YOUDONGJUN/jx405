<%@ page import="model.UserDTO" %>
<%@ page import="connector.MySqlConnectionMaker" %>
<%@ page import="connector.ConnectionMaker" %>
<%@ page import="controller.ReplyController" %>
<%@ page import="model.ReplyDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    UserDTO logIn = (UserDTO) session.getAttribute("logIn");
    if (logIn == null) {
        response.sendRedirect("/index.jsp");
    }

    ConnectionMaker connectionMaker = new MySqlConnectionMaker();
    ReplyController replyController = new ReplyController(connectionMaker);
    ReplyDTO r = new ReplyDTO();

    r.setWriterId(logIn.getId());
    r.setBoardId(request.getParameter("boardId"));
    r.setWriterNickname(request.getParameter("writerNickname"));
    r.setContent(request.getParameter("content"));

    replyController.insert(r);

    response.sendRedirect("/board/printList.jsp");
%>
</body>
</html>
