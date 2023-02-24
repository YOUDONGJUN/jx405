package servlet.board;

import com.google.gson.JsonObject;
import connector.ConnectionMaker;
import connector.MySqlConnectionMaker;
import controller.BoardController;
import controller.UserController;
import model.BoardDTO;
import model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

@WebServlet(name = "PrintOneServlet", value = "/board/printOne")
public class PrintOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            response.sendRedirect("/index.jsp");
        }

        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        JsonObject object = new JsonObject();

        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        BoardController boardController = new BoardController(connectionMaker);
        UserController userController = new UserController(connectionMaker);

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            BoardDTO boardDTO = boardController.selectOne(id);
            if (boardDTO == null) {
                throw new NullPointerException();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

            JsonObject boardJson = new JsonObject();
            boardJson.addProperty("id", boardDTO.getId());
            boardJson.addProperty("title", boardDTO.getTitle());
            boardJson.addProperty("writerNickname", userController.selectOne(boardDTO.getWriterId()).getNickname());
            boardJson.addProperty("entryDate", sdf.format(boardDTO.getEntryDate()));
            boardJson.addProperty("modifyDate", sdf.format(boardDTO.getModifyDate()));
            boardJson.addProperty("content", boardDTO.getContent());
            boardJson.addProperty("isOwned", boardDTO.getWriterId() == logIn.getId());

            object.addProperty("status", "success");
            object.addProperty("status", boardJson.toString());

            writer.print(object);

        } catch (Exception e) {
            object.addProperty("status", "fail");
            object.addProperty("message", "유효하지 않은 글 번호 입니다.");

            writer.print(object);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
