package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수도 요금 경쟁
public class S1284 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(input.nextToken());
            int q = Integer.parseInt(input.nextToken());
            int r = Integer.parseInt(input.nextToken());
            int s = Integer.parseInt(input.nextToken());
            int w = Integer.parseInt(input.nextToken());

            int paymentA = p*w;
            int paymentB = r>w ? q : q+s*(w-r);

            System.out.printf("#%d %d\n", t+1, Math.min(paymentA, paymentB));
        }
        br.close();
    }
}

