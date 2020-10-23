package SWEA.Level1;

import java.util.Scanner;

// 홀수만 더하기
public class S2072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t < T+1; t++) {
            int answer = 0;
            for(int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                if(num%2==1) answer+=num;
            }
            System.out.printf("#%d %d\n", t, answer);
        }	// end of test case
        sc.close();
    }	// end of main
}	// end of class
