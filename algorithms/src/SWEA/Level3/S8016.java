package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 8016. 홀수 피라미드
public class S8016 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long layer = Integer.parseInt(br.readLine());

            BigInteger right = BigInteger.valueOf((long)(2*layer*layer-1));
            BigInteger left = BigInteger.valueOf((long)2*((layer*layer)-((layer*layer)-((layer-1)*(layer-1)+1)))-1);

            System.out.printf("#%d %d %d\n", t+1, left, right);
        }
        br.close();
    }	// end of main
}

