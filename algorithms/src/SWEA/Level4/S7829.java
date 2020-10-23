package SWEA.Level4;

import java.util.Arrays;
import java.util.Scanner;

// 7829. 보물왕 태혁
public class S7829 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        int answer;
        for (int t = 0; t < T; t++) {
            answer = 0;
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int n = 0; n < N; n++) {
                arr[n] = sc.nextInt();
            }
            Arrays.sort(arr);
            if(arr.length==1) {
                answer = arr[0]*arr[0];
            }
            else answer = arr[0]*arr[arr.length-1];
            System.out.printf("#%d %d\n", t+1, answer);
        }
    }
}