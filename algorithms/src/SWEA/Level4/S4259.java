package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 4259. 제곱수의 합 계산하기
public class S4259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] exp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                int input = Integer.parseInt(st.nextToken());
                arr[i] = input/10;
                exp[i] = input%10;
            }
            BigInteger result = BigInteger.ZERO;
            for (int i = 0; i < arr.length; i++) {
                BigInteger temp = BigInteger.valueOf(arr[i]);
                if(exp[i]==0) temp = BigInteger.valueOf(1);
                for (int j = 0; j < exp[i]-1; j++) {
                    temp = temp.multiply(BigInteger.valueOf(arr[i]));
                }
                result = result.add(temp);
            }
            answer.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}