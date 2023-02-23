package servlet;

import com.google.gson.JsonObject;
import connector.ConnectionMaker;
import connector.MySqlConnectionMaker;
import controller.UserController;
import model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthServlet", value = "/user/auth")
public class UserAuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        UserController userController = new UserController(connectionMaker);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDTO userDTO = userController.auth(username, password);

        JsonObject result = new JsonObject();
        if (userDTO != null) {
            HttpSession session = request.getSession();
            session.setAttribute("logIn", userDTO);

            result.addProperty("status", "success");
        } else {
            result.addProperty("result", "fail");
        }

        PrintWriter writer = response.getWriter();
        writer.print(result);


    }
}



















