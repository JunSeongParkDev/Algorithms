package SWEA.Level2;

import java.util.Scanner;

// 패턴 마디의 길이
public class S2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer;
        String str;
        int T = sc.nextInt();
        for (int t = 1; t < T+1; t++) {
            answer = 0;
            str = sc.next();
            String temp = "";
            for (int i = 0; i < str.length(); i++) {
                if(!temp.contains(String.valueOf(str.charAt(i)))) {
                    temp += String.valueOf(str.charAt(i));
                }
                else {
                    if(str.substring(temp.length(), temp.length()*2).equals(temp)) {
                        answer = temp.length();
                        break;
                    }
                    else {
                        temp += String.valueOf(str.charAt(i));
                    }
                }
            }
            System.out.printf("#%d %d\n", t, answer);
        }
        sc.close();
    }
}