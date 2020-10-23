package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 지그재그 숫자
public class S1986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
            int negative = 1;
            for(int i=1; i<num+1; i++) {
                sum = sum + i*negative;
                negative *= -1;
            }
            System.out.printf("#%d %d\n", t+1, sum);
        }
        br.close();
    }
}

