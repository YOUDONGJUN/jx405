<%@ page import="model.UserDTO" %>
<%@ page import="connector.ConnectionMaker" %>
<%@ page import="connector.MySqlConnectionMaker" %>
<%@ page import="controller.BoardController" %>
<%@ page import="model.BoardDTO" %>
<%@ page import="controller.UserController" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            response.sendRedirect("/index.jsp");
        }

        int id = Integer.parseInt(request.getParameter("id"));

        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        BoardController boardController = new BoardController(connectionMaker);
        UserController userController = new UserController(connectionMaker);

        BoardDTO b = boardController.selectOne(id);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
    %>

    <script>
        function confirmDelete() {
            let result = confirm("정말로 삭제하시겠습니까?");
            if (result) {
                location.href = "/board/delete.jsp?id=" +
                <%=b.getId()%>
            }
        }
    </script>
    <title>
        <%=b.getTitle()%>
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <c:set var="b" value="<%=b%>"/>
    <c:set var="logIn" value="<%=logIn%>"/>
    <div class="row align-items-center vh-100  justify-content-center">
        <div class="col-10">
            <table class="table table-striped table-dark">
                <tr>
                    <th class="col-2">글번호</th>
                    <td class="col-10">${b.id}
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td>${b.title}
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><%=userController.selectOne(b.getWriterId()).getNickname()%>
                    </td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td>
                        <fmt:formatDate value="${b.entryDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
                    </td>
                </tr>
                <tr class="mb-2">
                    <th>수정일</th>
                    <td><fmt:formatDate value="${b.modifyDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="text-center">
                        ${b.content}
                    </td>
                </tr>
                <c:if test="${b.writerId eq logIn.id}">
                    <tr>
                        <td colspan="2" class="text-center">
                            <div class="btn btn-outline-success" onclick="location.href='/board/update.jsp?id=<%=b.getId()%>'">수정하기</div>
                            <div class="btn btn-outline-danger" onclick="confirmDelete()">삭제하기</div>
                        </td>
                    </tr>
                </c:if>
            </table>
        </div>
    </div>
</div>
</body>
</html>



















