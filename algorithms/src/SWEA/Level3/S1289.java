package SWEA.Level3;

import java.util.Scanner;

// 1289. 원재의 메모리 복구하기
public class S1289 {
    static Scanner sc = new Scanner(System.in);
    static int Answer;
    static int T;
    public static void main(String[] args) {
        int T = sc.nextInt();	// TestCase
        for(int i=0; i<T; i++) {
            Answer = 0;
            String origin = sc.next();
            int[] presentState = new int[origin.length()];
            for(int j=origin.indexOf("1"); j<presentState.length; j++) {
                if(presentState[j] != (int)origin.charAt(j)) {
                    for(int k=j; k<presentState.length; k++) {
                        presentState[k] = (int)origin.charAt(j);
                    }
                    Answer++;
                }
            }
            System.out.printf("#%d %d\n", i+1, Answer);
        }
        sc.close();
    }
}
