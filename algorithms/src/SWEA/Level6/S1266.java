package SWEA.Level6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// [S/W 문제해결 응용] 9일차 - 소수 완제품 확률
public class S1266 {
    private static int[] notPrime = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
    private static int[] comb = {};
    public static void main(String[] args) throws Exception {
        // init 18C?
        comb = new int[19];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            comb[i] = 1;
            for (int j = 1; j < i+1; j++) {
                comb[i] *= comb.length-j;
                comb[i] /= j;
            }
        }
        System.out.println(Arrays.toString(comb));
        // 둘 중 하나라도 소수 개수의 완제품을 만들 확률 == 1 - 둘 다 소수 개수가 아닌 완제품을 만들 확률
        // += A가 0개 만들었을때 B가 0 1 4 6 8 9 ... 18개 만들 확률
        // a0*b0 + a0*b1 + a0*b4 + ... a0*b18
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            double[] pA = new double[notPrime.length];
            double[] pB = new double[notPrime.length];
            for (int i = 0; i < notPrime.length; i++) {
                pA[i] = 1.0;
                pB[i] = 1.0;
                for (int j = 0; j < notPrime[i]; j++) {	// 소수 개수가 아닌 완제품을 만들 확률
                    pA[i] *= (double)A/100;
                    pB[i] *= (double)B/100;
                }
                for (int j = 0; j < 18-notPrime[i]; j++) {	// 18 - 소수 아닌 개수 만큼 실패할 확률
                    pA[i] *= (double)(100-A)/100;
                    pB[i] *= (double)(100-B)/100;
                }
                pA[i] *= comb[notPrime[i]];
                pB[i] *= comb[notPrime[i]];
            }	// end of prime for
            // A가 0개를 만들었을 때 B가 0 1 4 6 8 9 10 12 14 15 16 18개를 만들 수 있다.
            double answer = 0.0;
            for (int i = 0; i < pB.length; i++) {
                for (int j = 0; j < pB.length; j++) {
                    answer += pA[i]*pB[j];
                }
            }
            System.out.printf("#%d %.6f\n", t+1, 1-answer);
        }	// end of test case
        br.close();
    }	// end of main
}
