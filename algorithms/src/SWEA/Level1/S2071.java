package SWEA.Level1;

import java.util.Scanner;

// 평균값 구하기
public class S2071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t < T+1; t++) {
            int answer = 0;
            int sum = 0;
            for(int i=0; i<10; i++) {
                sum += sc.nextInt();
            }
            answer = (int) Math.round((double) sum/10);
            System.out.printf("#%d %d\n", t, answer);
        }	// end of test case
        sc.close();
    }	// end of main
}	// end of class
