package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 3408. 세가지 합 구하기
public class S3408 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long answer = (long)N*(N+1)/2;
            System.out.printf("#%d %d %d %d\n", t+1, answer, 2*answer-N, 2*answer);
        }
        br.close();
    }	// end of main
}
