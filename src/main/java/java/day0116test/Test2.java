package java.day0116test;


//※ 다음 문제를 해결할 수 있도록 프로그래밍 하시오.
//
//
//        1부터 1000까지의 소수 구하기
//        소수란? 1과 자기 자신외에는 약수가 없는 숫자.
//
//
//        2중 for문을 사용하여 1부터 1000까지의 소수를 모두 구하는 프로그램을 만드시오.


public class Test2 {

    public static void main(String[] args) {

        for (int i = 1; i <= 1000; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }


            if (count == 2) {
                System.out.println(i);
            }
        }
    }
}
