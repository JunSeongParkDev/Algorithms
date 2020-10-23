package SWEA.Level1;

import java.util.Scanner;

// 더블더블
public class S2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < num+1; i++) {
            answer.append((1 << i)).append(' ');
        }
        System.out.println(answer.toString().trim());
        sc.close();
    }
}
