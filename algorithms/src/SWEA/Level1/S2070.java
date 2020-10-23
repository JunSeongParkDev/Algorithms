package SWEA.Level1;

import java.util.Scanner;

// 큰 놈, 작은 놈, 같은 놈
public class S2070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t < T+1; t++) {
            char answer;
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            if(num1 > num2) answer = '>';
            else if(num1 < num2) answer = '<';
            else answer = '=';

            System.out.printf("#%d %c\n", t, answer);
        }	// end of test case
        sc.close();
    }	// end of main
}
