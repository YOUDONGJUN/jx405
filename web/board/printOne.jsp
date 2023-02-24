<%@ page import="model.UserDTO" %>
<%@ page import="connector.ConnectionMaker" %>
<%@ page import="connector.MySqlConnectionMaker" %>
<%@ page import="controller.BoardController" %>
<%@ page import="model.BoardDTO" %>
<%@ page import="controller.UserController" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="controller.ReplyController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ReplyDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script src="/assets/js/board/printOne.js"></script>
</head>
<body onload="initPage()">
<div class="container-fluid">

</div>
<script>
    let addNewRow = () => {
        let newRow = document.getElementById('tr-new-row');
        let table = document.getElementById('table-board');

        table.children[0].removeChild(newRow);

        let tr = document.createElement('tr');
        let td = document.createElement('td');
        td.colSpan = 2;

        tr.appendChild(td);

        table.children[0].appendChild(tr);
        table.children[0].appendChild(newRow);
    }
</script>
</div>
</body>
</html>




















