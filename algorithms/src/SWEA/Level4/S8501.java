package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 8501. 은비의 동전 뒤집기
public class S8501 {
    private static long[] arr = new long[1001];
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 1; i <= N; i++) {
                if(arr[i]==0) {
                    long fac = 1;
                    for (int j = 1; j <= i; j++) {
                        fac = fac % 1000000007 * j;
                    }
                    arr[i] = (long) (arr[i-1]*i + fac * (i/2) / i) % 1000000007;
                }
            }
            answer.append('#').append(t).append(' ').append(arr[N]).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
