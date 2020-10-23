package SWEA.Level2;

import java.util.Arrays;
import java.util.Scanner;

// 조교의 성적 매기기
public class S1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int wonder = sc.nextInt();
            int[][] score = new int[N][3];
            int[] finalScore = new int[N];
            for (int i = 0; i < score.length; i++) {
                score[i][0] = sc.nextInt();
                score[i][1] = sc.nextInt();
                score[i][2] = sc.nextInt();
                finalScore[i] = score[i][0]*35 + score[i][1]*45 + score[i][2]*20;
            }

//			System.out.println(Arrays.toString(finalScore));
            int cmpScore = finalScore[wonder-1];
            Arrays.sort(finalScore);
            int cnt = 0;
            for(int i=finalScore.length-1; i>-1; i--) {
                if(finalScore[i]==cmpScore) {
                    break;
                }
                cnt++;
            }
            String[] ABC = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D"};
            System.out.printf("#%d %s\n", t+1, ABC[10*cnt/N]);
        }
        sc.close();
    }
}
