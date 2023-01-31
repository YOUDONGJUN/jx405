package java.dbFilm.viewer;

import dbFilm.Controller.FilmController;
import dbFilm.model.CustomerDTO;
import dbFilm.model.FilmDTO;
import util.ScannerUtil;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class FilmViewer {
    private final Scanner SCANNER;
    private final String DATE_FORMAT = "yy/MM/dd HH:mm:ss";
    private FilmController filmController;
    private CustomerDTO logIn;
    private Connection connection;

    public FilmViewer(Scanner scanner, Connection connection, CustomerDTO logIn) {
        this.connection = connection;
        filmController = new FilmController(this.connection);
        this.logIn = logIn;
        SCANNER = scanner;
    }

    public void showMenu() {
        String message = "1. 영화 등록하기 2.영화 목록 보기 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if (userChoice == 1) {
                RegisterFilm();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void RegisterFilm() {
        FilmDTO filmDTO = new FilmDTO();

//        filmDTO.setWriterId(logIn.getId());

        String message = "영화 제목을 입력해주세요.";
        filmDTO.setTitle(ScannerUtil.nextLine(SCANNER, message));

        message = "영화 줄거리를 입력해주세요.";
        filmDTO.setDescription(ScannerUtil.nextLine(SCANNER, message));

        message = "영화 출시년도를 입력해주세요.";
        filmDTO.setRelease_year(ScannerUtil.nextInt(SCANNER, message));

        message = "영화 대여 가능 기간을 입력해주세요.";
        filmDTO.setRental_duration(ScannerUtil.nextInt(SCANNER, message));

        message = "영화 대여료를 입력해주세요.";
        filmDTO.setRental_rate(ScannerUtil.nextInt(SCANNER, message));

        message = "영화 상영시간을 입력해주세요.";
        filmDTO.setLength(ScannerUtil.nextInt(SCANNER, message));

        message = "영화 특징을 입력해주세요.";
        filmDTO.setSpecial_features(ScannerUtil.nextLine(SCANNER, message));

        filmController.insert(filmDTO);
    }

    public void printList() {
        ArrayList<FilmDTO> list = filmController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 영화가 없습니다.");
        } else {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            for (FilmDTO f : list) {
                System.out.printf("%d, %s, %s, %d, %d, %%s - %s\n", f.getFilm_id(), f.getTitle(), f.getDescription(), f.getRelease_year(), f.getRental_duration(), f.getRental_rate(), f.getLength(), f.getSpecial_features());
            }

            String message = "상세보기할 영화의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            while (userChoice != 0 && !list.contains(new FilmDTO())) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);
            }

//            if (userChoice != 0) {
//                printOne(userChoice);
//            }
        }
    }

    private void printOne(int film_id) {
        FilmController filmController = new FilmController(connection);
//        ReplyViewer replyViewer = new ReplyViewer(SCANNER, connection, logIn);

//        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        FilmDTO filmDTO = filmController.selectOne(film_id);
        System.out.println("=================================================");
        System.out.println("영화 번호 : " + filmDTO.getFilm_id());
        System.out.println("영화 제목" + filmDTO.getTitle());
        System.out.println("-------------------------------------------------");
        System.out.println("영화 줄거리: " + filmDTO.getDescription());
        System.out.println("출시년도: " + filmDTO.getRelease_year());
        System.out.println("특징 : " + filmDTO.getSpecial_features());
        System.out.println("-------------------------------------------------");
        System.out.println("대여 가능 기간 : " + filmDTO.getRental_duration());
        System.out.println("대여료 : " + filmDTO.getRental_rate());
//        replyViewer.printAll(id);
        System.out.println("=================================================");


        String message = null;
        int userChoice = ScannerUtil.nextInt(SCANNER, message);


        if (filmDTO.getFilm_id() == logIn.getId()) {
            message = "1.수정 2.삭제 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
        }


        if (userChoice == 1) {
            update(film_id);
        } else if (userChoice == 2) {
            delete(film_id);
        } else if (userChoice == 3) {

//            replyViewer.showMenu(id);
            printOne(film_id);
        } else if (userChoice == 4) {
            printList();
        }
    }

    private void update(int film_id) {
        FilmDTO f = filmController.selectOne(film_id);

        String message = "새로운 영화 제목을 입력해주세요.";
        f.setTitle(ScannerUtil.nextLine(SCANNER, message));

        message = "새로운 내용을 입력해주세요.";
        f.setDescription(ScannerUtil.nextLine(SCANNER, message));

        filmController.update(f);
    }

    private void delete(int film_id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            filmController.delete(film_id);
            printList();
        } else {
            printOne(film_id);
        }
    }
}

