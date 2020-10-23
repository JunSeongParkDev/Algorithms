package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7728. 다양성 측정
public class S7728 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] answerArray = new int[10];
            String input = br.readLine();
            for(int i=0; i<input.length(); i++) {
                answerArray[input.charAt(i)-'0']++;
            }
            int answer = 0;
            for (int i = 0; i < answerArray.length; i++) {
                if(answerArray[i]!=0) answer++;
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }
    }
}

