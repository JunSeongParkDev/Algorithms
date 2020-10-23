package SWEA.Level2;

// 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
import java.util.Scanner;

public class S1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer;
        int[] scoreArray = new int[1000];
        for (int t = 0; t < T; t++) {
            int testCaseNum = sc.nextInt();
            answer = 0;
            for (int i = 0; i < scoreArray.length; i++) scoreArray[i] = sc.nextInt();
            int[] count = new int[101];
            for (int i = 0; i < scoreArray.length; i++) {
                count[scoreArray[i]]++;
            }
            int maxCountValue = Integer.MIN_VALUE;
            for (int i = 0; i < count.length; i++) {
                if(count[i]>=maxCountValue) {
                    maxCountValue = count[i];
                    answer = i;
                }
            }
            System.out.printf("#%d %d\n", testCaseNum, answer);
        }
        sc.close();
    }
}