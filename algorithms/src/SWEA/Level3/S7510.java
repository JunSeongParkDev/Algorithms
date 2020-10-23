package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7510. 상원이의 연속 합
public class S7510 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 1; i < N+1; i++) {
                int sum = 0;
                for (int j = i; ; j++) {
                    sum+=j;
                    if(sum==N) {
                        answer++;
                    } else if(sum>N)
                        break;
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }	// end of test case
        br.close();
    }	// end of main
}

