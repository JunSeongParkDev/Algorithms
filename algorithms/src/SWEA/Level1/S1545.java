package SWEA.Level1;

import java.util.Scanner;

// 거꾸로 출력해 보아요
public class S1545 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = num; i > -1; i--) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
