package day0109;

import java.util.Scanner;

public class StarPrinter09_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("별 찍기 9번");
        System.out.println("출력할 줄 수를 입력하세요.");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        //다른 방법
        for (int i = 0; i < lineNumber; i++) {
            for (int j = lineNumber - 1 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = (lineNumber - i - 1) * 2 - 1; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println();

        scanner.close();
    }
}
