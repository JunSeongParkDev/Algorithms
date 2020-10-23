package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2805. 농작물 수확하기
public class S2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for(int i=0; i<map.length; i++) {
                String input = br.readLine();
                for(int j=0; j<map[i].length; j++) {
                    map[i][j] = input.charAt(j)-'0';
                }
            }
            int answer = 0;
            for(int i=0; i<N; i++) {
                answer+=map[i][N/2];
            }
            int coverage = 1;
            boolean flag = true;
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j <= coverage; j++) {
                    answer+=map[i][(N/2)+j];
                    answer+=map[i][(N/2)-j];
                }
                if(coverage==N/2)
                    flag = false;
                if(flag) {
                    coverage++;
                }
                else {
                    coverage--;
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }
        br.close();
    }   // end of main
}