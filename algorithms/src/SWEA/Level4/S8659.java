package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 8659. GCD
public class S8659 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 1 2 3 5 8 13 21
        long[] fibo = new long[92];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            answer.append('#').append(t).append(' ').append(fibo[N+1]).append(' ').append(fibo[N]).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}