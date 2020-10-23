package SWEA.Level1;

import java.util.Scanner;

// 서랍의 비밀번호
public class S2043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pw = sc.nextInt();
        int num = sc.nextInt();
        int i;
        for (i = num; i < pw; i++);
        System.out.println(i - num + 1);
        sc.close();
    }
}