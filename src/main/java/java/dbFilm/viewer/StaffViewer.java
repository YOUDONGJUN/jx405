package java.dbFilm.viewer;

import dbConn.ConnectionMaker;
import dbFilm.Controller.StaffController;
import dbFilm.model.StaffDTO;
import dbFilm.viewer.FilmViewer;
import util.ScannerUtil;

import java.sql.Connection;
import java.util.Scanner;

public class StaffViewer {
    private final Scanner SCANNER;
    private Connection connection;
    private FilmViewer filmViewer;
    private StaffDTO logIn;

    public StaffViewer(ConnectionMaker connectionMaker) {
        SCANNER = new Scanner(System.in);
        connection = connectionMaker.makeConnection();
    }

    public void showIndex() {
        String message = "1. 로그인 2. 회원가입 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if (userChoice == 1) {
                auth();
                if (logIn != null) {
                    showMenu();
                }
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void register() {
        String message;
        message = "사용하실 아이디를 입력해주세요.";

        StaffDTO s = new StaffDTO();
        s.setUsername(ScannerUtil.nextLine(SCANNER, message));

        message = "사용하실 비밀번호를 입력해주세요.";
        s.setPassword(ScannerUtil.nextLine(SCANNER, message));

        message = "근무중인 가게 번호를 입력해주세요.";
        s.setStore_id(ScannerUtil.nextInt(SCANNER, message));

        StaffController staffController = new StaffController(connection);
        if (!staffController.insert(s)) {
            System.out.println("중복된 아이디입니다.");
            message = "새로운 아이디로 가입을 시도하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(SCANNER, message);
            if (yesNo.equalsIgnoreCase("Y")) {
                register();
            }
        }

    }

    public void auth() {
        String message;
        message = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(SCANNER, message);

        message = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(SCANNER, message);

        StaffController staffController = new StaffController(connection);
        logIn = staffController.auth(username, password);

        if (logIn == null) {
            System.out.println("로그인 정보가 정확하지 않습니다.");
        }
    }

    private void showMenu() {
        String message = "1.비디오 목록 보기 2. 관리자 정보 관리  3. 회원 정보 관리 4. 로그아웃";
        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if (userChoice == 1) {
                filmViewer.printList();
//                FilmViewer filmViewer = new FilmViewer(SCANNER, connection, logIn);
//                FilmViewer.printList();
            } else if (userChoice == 2) {
                printStaffInfo();
            } else if (userChoice == 3) {
                printCustomerInfo();
            } else if (userChoice == 4) {
                logIn = null;
                System.out.println("정상적으로 로그아웃되었습니다.");
            }
        }

    }


    private void printCustomerInfo(){
        System.out.println("관리자 번호: " + logIn.getStaff_id());
        System.out.println("회원 이름: " + logIn.getUsername());
        System.out.println("주소 번호 : " + logIn.getAddress_id());
        System.out.println("대여점 번호 : " + logIn.getStore_id());
        System.out.println("---------------------------------------------");
        String message = "1. 수정 2. 탈퇴 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(SCANNER, message);
        if (userChoice == 1) {
            update();
        } else if (userChoice == 2) {
            delete();
        }




//        String message = "상세보기할 영화의 번호나 뒤로 가실려면 0을 입력해주세요.";
//        int userChoice = ScannerUtil.nextInt(SCANNER, message);
//
//        while (userChoice != 0 && !list.contains(new FilmDTO())) {
//            System.out.println("잘못 입력하셨습니다.");
//            userChoice = ScannerUtil.nextInt(SCANNER, message);
//        }

    }
    private void printStaffInfo() {
        System.out.println("관리자 번호: " + logIn.getStaff_id());
        System.out.println("회원 이름: " + logIn.getUsername());
        System.out.println("주소 번호 : " + logIn.getAddress_id());
        System.out.println("대여점 번호 : " + logIn.getStore_id());
        System.out.println("---------------------------------------------");
        String message = "1. 수정 2. 탈퇴 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(SCANNER, message);
        if (userChoice == 1) {
            update();
        } else if (userChoice == 2) {
            delete();
        }
    }

    private void update() {

        String message = "새로운 비밀번호를 입력해주세요.";
        String newPassword = ScannerUtil.nextLine(SCANNER, message);

        message = "기존 비밀번호를 입력해주세요.";
        String oldPassword = ScannerUtil.nextLine(SCANNER, message);

        StaffController staffController = new StaffController(connection);

        if (staffController.auth(logIn.getUsername(), oldPassword) != null) {
            logIn.setPassword(newPassword);

            staffController.update(logIn);
        } else {
            System.out.println("회원 정보 변경에 실패하였습니다.");
        }
    }

    private void delete() {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = "비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(SCANNER, message);

            StaffController staffController = new StaffController(connection);

            if (staffController.auth(logIn.getUsername(), password) != null) {
                staffController.delete(logIn.getStaff_id());
                logIn = null;
            }
        }
    }
}










