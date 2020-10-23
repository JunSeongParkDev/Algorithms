package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7965. 퀴즈
public class S7965 {
    private static long[] memo = new long[1000001];
    private static final int MOD = 1000000007;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 1000000; i++) {
            memo[i] = (memo[i-1] + pow(i))%1000000007;
        }
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            answer.append('#').append(t).append(' ').append(memo[N]).append('\n');
        }
        System.out.println(answer.toString().trim());
        br.close();
    }	// end of main
    private static long pow(int i) {
        long result = 1;
        long mul = i;
        while (i > 0) {
            if ((i & 1) == 1)
                result = (result * mul) % MOD;
            mul = (mul * mul) % MOD;
            i = i >> 1;
        }
        return result % MOD;
    }
}