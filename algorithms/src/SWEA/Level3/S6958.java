package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6958. 동철이의 프로그래밍 대회
public class S6958 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer nq = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(nq.nextToken());
            int Q = Integer.parseInt(nq.nextToken());
            int[] answer = new int[N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                for (int j = 0; j < Q; j++) {
                    answer[i] += Integer.parseInt(input.nextToken());
                }
                if(answer[i]>max)
                    max = answer[i];
            }
            int winnerCnt = 0;
            for(int i=0; i<N; i++) {
                if(answer[i]==max) winnerCnt++;
            }
            System.out.printf("#%d %d %d\n", t+1, winnerCnt, max);
        }	// end of test case
        br.close();
    }	// end of main
}
