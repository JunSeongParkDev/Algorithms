package SWEA.Level1;

import java.util.Scanner;

// N줄덧셈
public class S2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num * (num + 1) / 2);
        sc.close();
    }
}
