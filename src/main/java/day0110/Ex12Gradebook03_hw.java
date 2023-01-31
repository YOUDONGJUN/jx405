package day0110;

// id, name, korean, english, math

// 1. 5명의 학생의 성적을 관리하는 프로그램
//  단, 5명을 모두 입력한 후에는 더이상 입력할 수 없도록 코드 작성

// 2. 5명의 학생 성적을 관리하는 프로그램
//  단, 5명을 모두 입력한 후에 새로운 학생 정보를 입력할 시에는
//     가장 오래된 기록을 제거하고 새로운 학생 정보를 입력되도록 코드 작성

import java.util.Scanner;


public class Ex12Gradebook03_hw {
    public static final Scanner scanner = new Scanner(System.in);
    static Student[] s = new Student[5];

    public static void main(String[] args) {


        //boolean inputSwitch = false;


        System.out.println("학생 5명 정보 입력 (번호/이름/국어점수/영어점수/수학점수)");

        Student(scanner);

        while (true) {
            String message = "1.추가 2.출력 3.종료";
            System.out.println(message);

            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                infoPlus(s);
//                inputSwitch = true;

            } else if (userChoice == 2) {
//                if (inputSwitch) {
                printInfo(s);
//                } else {
//                    System.out.println("다시 입력");
//                }


            } else if (userChoice == 3) {
                System.out.println("종료");
                break;
            }
        }
    }

    public static void Student(Scanner scanner) {

        for (int i = 0; i < 5; i++) {
            s[i] = new Student();

            s[i].id = Ex12Gradebook03_hw.scanner.nextInt();
            String temp = scanner.nextLine();
            s[i].name = Ex12Gradebook03_hw.scanner.nextLine();
            s[i].korean = Ex12Gradebook03_hw.scanner.nextInt();
            s[i].english = Ex12Gradebook03_hw.scanner.nextInt();
            s[i].math = Ex12Gradebook03_hw.scanner.nextInt();
        }

    }

    public static void printInfo(Student[] s) {
        for (int i = 0; i < 5; i++) {
            System.out.printf("번호 : %d번, 이름: %s\n", s[i].id, s[i].name);
            System.out.printf("국어 점수 : %d점, 영어 점수 : %d점, 수학 점수 : %d점\n", s[i].korean, s[i].english, s[i].math);
            System.out.printf("총점 : %d점, 평균 : %.2f점\n", Ex04Gradebook02.calculateSum(s[i]), Ex04Gradebook02.calculateAverage(s[i]));
        }
    }

    public static void infoPlus(Student[] s) {

        for (int i = 1; i < 5; i++) {
            s[i - 1] = s[i];
        }
        s[4].id = Ex12Gradebook03_hw.scanner.nextInt();
        String temp = scanner.nextLine();
        s[4].name = Ex12Gradebook03_hw.scanner.nextLine();
        s[4].korean = Ex12Gradebook03_hw.scanner.nextInt();
        s[4].english = Ex12Gradebook03_hw.scanner.nextInt();
        s[4].math = Ex12Gradebook03_hw.scanner.nextInt();


    }

}


