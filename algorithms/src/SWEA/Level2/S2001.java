package SWEA.Level2;

import java.util.Scanner;

// 파리 퇴치
public class S2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<T+1; t++) {
            int answer = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            for(int i=0; i<map.length; i++)
                for (int j = 0; j < map.length; j++)
                    map[i][j] = sc.nextInt();

            for(int i=0; i<map.length-M+1; i++) {
                for(int m=0; m<map.length-M+1; m++) {
                    int sum = 0;
                    for(int j=i; j<i+M; j++) {
                        for(int k=m; k<m+M; k++) {
                            sum += map[j][k];
                        }
                    }
                    if(sum>answer) answer = sum;
                }
            }
            System.out.printf("#%d %d\n", t, answer);
        }
        sc.close();
    }
}
