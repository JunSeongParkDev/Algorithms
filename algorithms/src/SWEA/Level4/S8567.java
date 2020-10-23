package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 8567. 약수의 개수가 많은 수
public class S8567 {
    private static int[] memo = new int[100001];
    private static int[] memo2 = new int[100001];
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < memo.length; i++) {
            for (int j = i; j < memo.length; j+=i) {
                memo[j]++;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int maxIndex = N;
            for (int i = N-1; i >=0; i--) {
                if(memo2[i]!=0) {
                    maxIndex = memo[memo2[i]]>memo[maxIndex]?memo2[i]:maxIndex;
                    break;
                }
                if(memo[maxIndex] < memo[i]) {
                    maxIndex = i;
                }
            }
            memo2[N] = maxIndex;
            answer.append('#').append(t).append(' ').append(maxIndex).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
