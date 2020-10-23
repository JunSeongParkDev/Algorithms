package SWEA.Level1;

import java.util.Scanner;

// 몫과 나머지 출력하기
public class S2029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.printf("#%d %d %d\n", t + 1, num1 / num2, num1 % num2);
        }
        sc.close();
    }
}
