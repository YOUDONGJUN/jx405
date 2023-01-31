package java.dbFilm.viewer;

import dbConn.ConnectionMaker;
import dbFilm.model.StaffDTO;
import dbFilm.viewer.FilmViewer;
import dbFilm.viewer.StaffViewer;
import util.ScannerUtil;

import java.sql.Connection;
import java.util.Scanner;

public class CustomerViewer {
    private final Scanner SCANNER;
    private Connection connection;
    private StaffDTO logIn;
    private StaffViewer staffViewer;
    private FilmViewer filmViewer;

    public CustomerViewer(ConnectionMaker connectionMaker) {
        SCANNER = new Scanner(System.in);
        connection = connectionMaker.makeConnection();
    }

    public void showIndex() {
        String message = "1.영화 목록 보기 2.관리자 로그인 3.종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if (userChoice == 1) {
                filmViewer.printList();
            } else if (userChoice == 2) {
                staffViewer.auth();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }
}
