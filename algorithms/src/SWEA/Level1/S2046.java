package SWEA.Level1;

import java.util.Scanner;

// 스탬프 찍기
public class S2046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("#");
        }
        sc.close();
    }
}