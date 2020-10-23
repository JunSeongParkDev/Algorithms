package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2115. [모의 SW 역량테스트] 벌꿀채취
public class S2115 {
    private static int[][] map;
    private static int workSpaceX;
    private static int workSpaceY;
    private static int[][] maxProfit;
    private static int maxProfitInThisArea;
    private static int C;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            maxProfit = new int[N][N];
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length-(M-1); j++) {
                    maxProfitInThisArea = 0;
                    for (int m = 1; m <= M; m++) {
                        workSpaceX = i;
                        workSpaceY = j;
                        makeCombination(M, m, 0, 0);
                        maxProfit[i][j] = maxProfitInThisArea;
                    }
                }
            }
            int sumOfMaxProfit = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    int profitOfWorkerA = maxProfit[i][j];
                    for (int k = 0; k < map.length; k++) {
                        for (int l = 0; l < map[k].length; l++) {
                            if(i==k && Math.abs(j-l)<M) continue;
                            int profitOfWorkerB = maxProfit[k][l];
                            if(profitOfWorkerA+profitOfWorkerB>sumOfMaxProfit)
                                sumOfMaxProfit = profitOfWorkerA+profitOfWorkerB;
                        }
                    }
                }
            }
            answer.append('#').append(t).append(' ').append(sumOfMaxProfit).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void makeCombination(int n, int r, int profit, int gatheringAmount) {
        if(r==0) {
            if(gatheringAmount<=C && profit>maxProfitInThisArea) maxProfitInThisArea = profit;
        } else if(n < r) {
            return;
        } else {
            int gathering = map[workSpaceX][workSpaceY+(n-1)];
            int calculatedProfit = gathering*gathering;

            makeCombination(n-1, r-1, profit+calculatedProfit, gatheringAmount+gathering);
            makeCombination(n-1, r, profit, gatheringAmount);
        }
    }
}
