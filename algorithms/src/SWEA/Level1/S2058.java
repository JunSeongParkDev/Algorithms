package SWEA.Level1;

import java.util.Scanner;

// 자릿수 더하기
public class S2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int answer = 0;
        for(int i = 0; i < str.length(); i++) {
            answer += Integer.parseInt(str.substring(i, i+1));
        }
        System.out.println(answer);
        sc.close();
    }	// end of main
}
