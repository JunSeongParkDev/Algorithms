package SWEA.Level2;

import java.util.Scanner;

// 초심자의 회문 검사
public class S1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<T+1; t++) {
            int answer = 0;
            int n;
            String testString = sc.next();
            if(testString.length()/2==0) n = testString.length()/2;
            else n = testString.length()/2+1;
            char[] splited1 = new char[n];
            char[] splited2 = new char[n];

            for(int i=0; i<n; i++) {
                splited1[i] = testString.charAt(i);
                splited2[i] = testString.charAt(testString.length()-1-i);
            }
            if(String.valueOf(splited1).equals(String.valueOf(splited2)))
                answer = 1;
            System.out.printf("#%d %d\n", t, answer);
        }
        sc.close();
    }
}

