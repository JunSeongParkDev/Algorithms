package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4466. 최대 성적표 만들기
public class S4466 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer nk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(nk.nextToken());
            int K = Integer.parseInt(nk.nextToken());
            StringTokenizer input = new StringTokenizer(br.readLine());
            int[] scores = new int[N];
            for(int i=0; i<N; i++) {
                scores[i] = Integer.parseInt(input.nextToken());
            }
            int answer = 0;
            for (int i = 0; i < K; i++) {
                int max = Integer.MIN_VALUE;
                int maxIndex = -1;
                for (int j = 0; j < scores.length; j++) {
                    if(scores[j]>max) {
                        max = scores[j];
                        maxIndex = j;
                    }
                }
                answer += max;
                scores[maxIndex] = Integer.MIN_VALUE;
            }
            System.out.printf("#%d %s\n", t+1, answer);
        }	// end of test case

        br.close();
    }	// end of main
}

