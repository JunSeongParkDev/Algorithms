package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 4050. 재관이의 대량 할인
public class S4050 {
    private static int[] prices;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(br);
            for (int i = prices.length-3; i >= 0; i-=3) {
                prices[i] = 0;
            }
            int sum = 0;
            for (int i = 0; i < prices.length; i++) {
                sum += prices[i];
            }
            answer.append('#').append(t).append(' ').append(sum).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void init(BufferedReader br) throws Exception {
        int N = Integer.parseInt(br.readLine());
        prices = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(prices);
    }
}