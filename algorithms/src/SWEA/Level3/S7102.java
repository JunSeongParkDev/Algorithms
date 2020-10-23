package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7102. 준홍이의 카드놀이
public class S7102 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            int M = Integer.parseInt(input.nextToken());

            int[] answerArray = new int[N+M+1];
            for(int n=1; n<N+1; n++) {
                for (int m = 1; m < M+1; m++) {
                    answerArray[n+m]++;
                }
            }
            int max = answerArray[0];
            for(int i=0; i<answerArray.length; i++) {
                if(answerArray[i]>max)
                    max = answerArray[i];
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < answerArray.length; i++) {
                if(answerArray[i]==max)
                    answer.append(i + " ");
            }
            System.out.printf("#%d %s\n", t+1, answer.toString().trim());
        }	// end of test case
        br.close();
    }	// end of main
}

