package SWEA.Level1;

import java.util.Scanner;

// 1대1 가위바위보
public class S1936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a == 1) {
            if(b == 2) System.out.println("B");
            if(b == 3) System.out.println("A");
        } else if(a == 2) {
            if(b == 1) System.out.println("A");
            if(b == 3) System.out.println("B");
        } else {
            if(b == 1) System.out.println("B");
            if(b == 2) System.out.println("A");
        }
        sc.close();
    }
}
