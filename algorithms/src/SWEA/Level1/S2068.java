package SWEA.Level1;

import java.util.Scanner;

// 최대수 구하기
public class S2068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t < T+1; t++) {
            int answer = Integer.MIN_VALUE;
            for(int i=0; i<10; i++) {
                int input = sc.nextInt();
                if(input > answer) answer = input;
            }
            System.out.printf("#%d %d\n", t, answer);
        }	// end of test case
        sc.close();
    }	// end of main
}
