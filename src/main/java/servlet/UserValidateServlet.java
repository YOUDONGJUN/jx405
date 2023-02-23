package servlet;

import connector.ConnectionMaker;
import connector.MySqlConnectionMaker;
import controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserValidate", value = "/user/validate")
public class UserValidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        UserController userController = new UserController(connectionMaker);

        String username = request.getParameter("username");
        boolean result = userController.validateUsername(username);

        PrintWriter writer = response.getWriter();

        // message에 포함할 내용
        // 1. 결과
        // 2. 성공시 결과 내용
        String message = "{status: \"success\", message: \"" + result + "\"}";

        writer.print(message);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
