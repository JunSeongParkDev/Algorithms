package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1486. 장훈이의 높은 선반
public class S1486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] ps = new int[N];
            int answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                ps[i] = i;
            }
            
            for (int i = 0; i < (1<<ps.length); i++) {
                int sum = 0;
                for (int j = 0; j < ps.length; j++) {
                    if((i & (1<<j))!= 0) {
                        sum += arr[ps[j]];
                    }
                }
                if(sum>=B && Math.abs(B-sum) < answer) {
                    answer = Math.abs(B-sum);
                }
                if(answer==0) break;
            }
            System.out.printf("#%d %d\n", t, answer);
        }	// end of test case

        br.close();
    }	// end of main
}
