package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 4일차 - 거듭 제곱
public class S1217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer input = new StringTokenizer(br.readLine());
            int base = Integer.parseInt(input.nextToken());
            int exp = Integer.parseInt(input.nextToken());
            System.out.printf("#%d %d\n", tc, pow(base, exp));
        }
        br.close();
    }	// end of main
    public static int pow(int base, int exp) {
        if(exp==1) {
            return base;
        }
        else {
            return base*pow(base, exp-1);
        }
    }
}
