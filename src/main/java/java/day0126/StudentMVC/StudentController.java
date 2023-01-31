package java.day0126.StudentMVC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    public final Scanner SCANNER = new Scanner(System.in);
    public PreparedStatement pstmt;
    public Connection connection;
    public ResultSet resultSet;

    public StudentViewer studentViewer;




    public ArrayList<StudentDTO> selectAll(PreparedStatement pstmt, Connection connection, ResultSet resultSet) {
        ArrayList<StudentDTO> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                StudentDTO s = new StudentDTO();
                s.setId(resultSet.getInt("id"));
                s.setKorean(resultSet.getInt("korean"));
                s.setEnglish(resultSet.getInt("english"));
                s.setMath(resultSet.getInt("math"));
                s.setName(resultSet.getString("name"));

                list.add(s);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


    public StudentDTO selectOne(int id, PreparedStatement pstmt, Connection connection, ResultSet resultSet) {
        String query = "SELECT * FROM `student` WHERE `id` = ?";
//        StudentDTO s = new StudentDTO();
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                StudentDTO s = new StudentDTO();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setKorean(resultSet.getInt("korean"));
                s.setEnglish(resultSet.getInt("english"));
                s.setMath(resultSet.getInt("math"));

                return s;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }




}
