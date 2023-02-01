package dbFilm.viewer;

import dbFilm.Controller.CustomerController;
import dbFilm.Controller.StaffController;
import dbFilm.model.CustomerDTO;
import dbFilm.model.StaffDTO;
import util.ScannerUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffViewer {
    private Scanner SCANNER;
    private Connection connection;
    private FilmViewer filmViewer;
    private StaffDTO logIn;
    private StaffController staffController;
    private CustomerController customerController;
    private CustomerDTO customerDTO;


    public StaffViewer(Scanner SCANNER, Connection connection) {
        this.SCANNER = SCANNER;
        this.connection = connection;

//        connection = connectionMaker.makeConnection();
    }


    public void showIndex() {
        String message = "1.관리자 로그인 2.관리자 회원가입 3.뒤로 가기";
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
                System.out.println("뒤로 가기");
                break;
            }
        }
    }

    private void register() {
        String message;

        StaffDTO s = new StaffDTO();
        message = "사용하실 아이디를 입력해주세요.";
        s.setUsername(ScannerUtil.nextLine(SCANNER, message));

        message = "사용하실 비밀번호를 입력해주세요.";
        s.setPassword(ScannerUtil.nextLine(SCANNER, message));

        message = "address_id를 입력해주세요.";
        s.setAddress_id(ScannerUtil.nextInt(SCANNER, message));

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
        String message = "1.비디오 목록 보기 2. 관리자 목록 관리  3. 회원 목록 관리 4. 로그아웃";
        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if (userChoice == 1) {
                filmViewer.printList();
            } else if (userChoice == 2) {
                printStaffList();
            } else if (userChoice == 3) {
                printCustomerList();
            } else if (userChoice == 4) {
                logIn = null;
                System.out.println("정상적으로 로그아웃되었습니다.");
            }
        }

    }


    private void printCustomerList() {
        ArrayList<CustomerDTO> list = customerController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 영화가 없습니다.");
        } else {
            for (CustomerDTO c : list) {
                System.out.printf("%d, %d, %s, %s, %s, %d, %s, &s\n",
                        c.getCustomer_id(), c.getStore_id(), c.getFirst_name(), c.getLast_name(), c.getEmail(), c.getAddress_id(), c.getCreate_date(), c.getLast_update());
            }

            String message = "상세보기할 회원의 id나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            if (userChoice != 0 && list.contains(new StaffDTO())) {
                printCustomerInfoOne();
            } else if (userChoice == 0) {
                showMenu();
            }

//                while (userChoice != 0 && !list.contains(new StaffDTO())) {
//                    System.out.println("잘못 입력하셨습니다.");
//                    userChoice = ScannerUtil.nextInt(SCANNER, message);
//                }

        }
    }


    private void printCustomerInfoOne() {
        System.out.println("회원 번호: " + customerDTO.getCustomer_id());
        System.out.println("회원 first name: " + customerDTO.getFirst_name());
        System.out.println("회원 last name: " + customerDTO.getLast_name());
        System.out.println("회원 email: " + customerDTO.getEmail());
        System.out.println("회원 주소: " + customerDTO.getAddress_id());
        System.out.println("회원 가입 날짜: " + customerDTO.getCreate_date());
        System.out.println("회원 마지막 수정 날짜: " + customerDTO.getLast_update());
        System.out.println("---------------------------------------------");
        String message = "1.등록 2.수정 3.삭제 4.뒤로가기";
        int userChoice = ScannerUtil.nextInt(SCANNER, message);
        if (userChoice == 1) {
            customerRegitser();
        } else if (userChoice == 2) {
            customerUpdate();
        } else if (userChoice == 3) {
            customerDelete();
        } else if (userChoice == 4) {
            showMenu();
        }
//        String message = "상세보기할 영화의 번호나 뒤로 가실려면 0을 입력해주세요.";
//        int userChoice = ScannerUtil.nextInt(SCANNER, message);
//
//        while (userChoice != 0 && !list.contains(new FilmDTO())) {
//            System.out.println("잘못 입력하셨습니다.");
//            userChoice = ScannerUtil.nextInt(SCANNER, message);
//        }

    }

    private void customerRegitser() {
        CustomerDTO customerDTO = new CustomerDTO();

        String message = "대여점을 입력해주세요.";
        customerDTO.setStore_id(ScannerUtil.nextInt(SCANNER, message));

        message = "first_name을 입력해주세요.";
        customerDTO.setFirst_name(ScannerUtil.nextLine(SCANNER, message));

        message = "last_name을 입력해주세요.";
        customerDTO.setLast_name(ScannerUtil.nextLine(SCANNER, message));

        message = "email을 입력해주세요.";
        customerDTO.setEmail(ScannerUtil.nextLine(SCANNER, message));

        message = "address_id를 입력해주세요.";
        customerDTO.setAddress_id(ScannerUtil.nextInt(SCANNER, message));


        customerController.insert(customerDTO);

    }


    private void customerUpdate() {

        String message = "새로운 비밀번호를 입력해주세요.";
        String newPassword = ScannerUtil.nextLine(SCANNER, message);

        message = "기존 비밀번호를 입력해주세요.";
        String oldPassword = ScannerUtil.nextLine(SCANNER, message);

        CustomerController customerController = new CustomerController(connection);

        if (staffController.auth(logIn.getUsername(), oldPassword) != null) {
            logIn.setPassword(newPassword);

            staffController.update(logIn);
        } else {
            System.out.println("회원 정보 변경에 실패하였습니다.");
        }
    }

    private void customerDelete() {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = "비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(SCANNER, message);

            CustomerController customerController = new CustomerController(connection);

            if (staffController.auth(logIn.getUsername(), password) != null) {
                staffController.delete(logIn.getStaff_id());
                logIn = null;
            }
        }
    }


    private void printStaffList() {
        ArrayList<StaffDTO> list = staffController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 staff가 없습니다.");
        } else {
            for (StaffDTO s : list) {
                System.out.printf("%d, %s, %s, %d, %d\n",
                        s.getStaff_id(), s.getUsername(), s.getPassword(), s.getAddress_id(), s.getStore_id());
            }

            String message = "상세보기할 staff의 id나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            if (userChoice == 1) {
                printStaffInfoOne();
            } else {
                showMenu();
            }

//                while (userChoice != 0 && !list.contains(new StaffDTO())) {
//                    System.out.println("잘못 입력하셨습니다.");
//                    userChoice = ScannerUtil.nextInt(SCANNER, message);
//                }

        }

    }


    private void printStaffInfoOne() {
        System.out.println("관리자 번호: " + logIn.getStaff_id());
        System.out.println("회원 이름: " + logIn.getUsername());
        System.out.println("주소 번호 : " + logIn.getAddress_id());
        System.out.println("대여점 번호 : " + logIn.getStore_id());
        System.out.println("---------------------------------------------");
        String message = "1.등록 2.수정 3.탈퇴 4.뒤로가기";
        int userChoice = ScannerUtil.nextInt(SCANNER, message);
        if (userChoice == 1) {
            staffRegister();
        } else if (userChoice == 2) {
            staffUpdate();
        } else if (userChoice == 3) {
            staffDelete();
        } else if (userChoice == 4) {
            printStaffList();
        }
    }


    private void staffRegister() {
        StaffDTO staffDTO = new StaffDTO();

        String message = "username을 입력해주세요.";
        staffDTO.setUsername(ScannerUtil.nextLine(SCANNER, message));

        message = "password를 입력해주세요.";
        staffDTO.setPassword(ScannerUtil.nextLine(SCANNER, message));

        message = "address_id를 입력해주세요.";
        staffDTO.setAddress_id(ScannerUtil.nextInt(SCANNER, message));

        message = "store_id를 입력해주세요.";
        staffDTO.setStore_id(ScannerUtil.nextInt(SCANNER, message));


        staffController.insert(staffDTO);

    }

    private void staffUpdate() {

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

    private void staffDelete() {
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

