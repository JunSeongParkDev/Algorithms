package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3314. 보충학습과 평균
public class S3314 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i=0; i<5; i++) {
                int score = Integer.parseInt(input.nextToken());
                sum+= score<40? 40:score;
            }
            System.out.printf("#%d %d\n", t+1, sum/5);
        }	// end of test case
    }	// end of main
}
