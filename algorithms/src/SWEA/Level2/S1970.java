package SWEA.Level2;

import java.util.Scanner;

// 쉬운 거스름돈
public class S1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int money = sc.nextInt();
            int[] answer = new int[8];
            int devide = 50000;
            boolean flag = true;
            for(int i=0; i<answer.length; i++) {
                answer[i] = money/devide;
                money%=devide;
                if(flag) {
                    devide/=5;
                    flag = false;
                }
                else {
                    devide/=2;
                    flag = true;
                }
            }
            System.out.println("#" + (t+1));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<answer.length; i++) {
                sb.append(answer[i]).append(' ');
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}
