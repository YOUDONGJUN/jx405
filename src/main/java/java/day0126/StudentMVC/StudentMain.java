package java.day0126.StudentMVC;

import java.sql.SQLException;
import java.util.Scanner;


public class StudentMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentViewer studentViewer = new StudentViewer(scanner);
        StudentController studentController = new StudentController();

        studentViewer.initialize();
        studentViewer.showMenu();
        try {
            studentViewer.terminate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
