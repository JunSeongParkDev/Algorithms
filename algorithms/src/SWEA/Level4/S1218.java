package SWEA.Level4;

import java.util.Scanner;

// 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
public class S1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t=0; t<10; t++) {
            int length = sc.nextInt();
            String tc = sc.next();

            int answer = 1;
            int small = 0;
            int middle = 0;
            int large = 0;
            int huge = 0;

            for(int i=0; i<length; i++) {
                if(tc.charAt(i)=='(') small++;
                else if(tc.charAt(i)=='{') middle++;
                else if(tc.charAt(i)=='[') large++;
                else if(tc.charAt(i)=='<') huge++;

                else if(tc.charAt(i)==')') {
                    if(--small<0) {
                        answer = 0;
                        break;
                    }
                }
                else if(tc.charAt(i)=='}') {
                    if(--middle<0) {
                        answer = 0;
                        break;
                    }
                }
                else if(tc.charAt(i)==']') {
                    if(--large<0) {
                        answer = 0;
                        break;
                    }
                }
                else {
                    if(--huge<0) {
                        answer = 0;
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }
        sc.close();
    }
}

