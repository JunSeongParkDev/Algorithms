package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배낭 문제 Knapsack
 * Fractional Knapsack : 물건이 여러개 or 1개씩 Greedy
 * 0/1 Knapsack : 완탐, DP, Back Tracking 물건 여러개 or 1개씩
 */

// 3282. 0/1 Knapsack
public class S3282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] item = new int[N][2];				// 가격, 무게
            for (int i = 0; i < item.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j >=0; j--) {
                    item[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] K = new int[item.length+1][n+1];	// 최대 가치를 저장할 배열 행 : 물건의 개수, 열 : 임시 무게

            // 첫 행, 첫 열은 0으로 초기화

            //	물건의 무게가 배낭의 무게가 적은 경우 이전 행의 데이터를 그대로 복사
            for (int i = 0; i < item.length; i++) {
                for (int w = 0; w < item[i][1]; w++) {
                    K[i+1][w] = K[i][w];
                }
                for (int w = item[i][1]; w < n+1; w++) {
                    int now = K[i][w-item[i][1]] + item[i][0];	// 1번 물건을 고려한 경우
                    int pre = K[i][w];	// 1번 물건을 고려하지 않은 경우
                    K[i+1][w] = now>pre?now:pre;
                }
            }
            System.out.printf("#%d %d\n", t, K[item.length][n]);
        }	// end of test case
        br.close();
    }	// end of main
}