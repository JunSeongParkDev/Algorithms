package SWEA.Level1;

import java.util.Scanner;

// 알파벳을 숫자로 치환
public class S2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            answer.append(input.charAt(i) - 64).append(' ');
        }
        System.out.println(answer.toString().trim());
        sc.close();
    }	// end of main
}	// end of class

