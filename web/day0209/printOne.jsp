<%@ page import="dbConn.ConnectionMaker" %>
<%@ page import="dbConn.MySqlConnectionMaker" %>
<%@ page import="controller.StudentController" %>
<%@ page import="model.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: ehdwnsdb
  Date: 2023-02-09
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>개별 학생 보기</title>
</head>
<body>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  ConnectionMaker connectionMaker = new MySqlConnectionMaker();
  StudentController controller = new StudentController(connectionMaker.makeConnection());
  StudentDTO studentDTO = controller.selectOne(id);
  int sum = studentDTO.getKorean() + studentDTO.getEnglish() + studentDTO.getMath();
  double average = (double) sum /3;
%>

<table>
  <tr>
    <td>번호 : <%=studentDTO.getId()%></td>
    <td>이름 : <%=studentDTO.getName()%></td>
  </tr>

  <tr>
    <td>국어 : <%=studentDTO.getKorean()%></td>
    <td>영어 : <%=studentDTO.getEnglish()%></td>
    <td>수학 : <%=studentDTO.getMath()%></td>
  </tr>

  <tr>
    <td>총점 : <%=sum%>점</td>
    <td>평균 : <%=average%>점</td>
  </tr>
</table>

</body>
</html>
