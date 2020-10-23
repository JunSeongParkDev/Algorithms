package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2117. [모의 SW 역량테스트] 홈 방범 서비스
public class S2117 {
    private static int[][] map;
    private static int M;
    private static int N;
    private static int[] cost;
    private static int maxCnt;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cost = new int[41];
        for (int i = 1; i < cost.length; i++) {
            cost[i] = (i-1)*(i-1) + i*i;
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            maxCnt = 0;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    calcProfit(i, j);
                }
            }
            answer.append('#').append(t).append(' ').append(maxCnt).append('\n');
        }
        System.out.println(answer.toString().trim());
        br.close();
    }
    private static void calcProfit(int x, int y) {
        for (int n = 1; n < 2*N+1; n++) {
            int cnt = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if((Math.abs(i-x)+Math.abs(j-y))<n && map[i][j]==1) {
                        cnt++;
                    }
                }
            }
            int profit = cnt*M-cost[n];
            if(profit>=0 && maxCnt<cnt) maxCnt=cnt;
        }
    }
}