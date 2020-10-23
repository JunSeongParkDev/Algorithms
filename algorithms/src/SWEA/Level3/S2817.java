package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2817. 부분 수열의 합
public class S2817 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int targetNum = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            outer:		for (int i = 1; i < 1<<N; i++) {
                int sum = 0;
                for (int j = 0; j < arr.length; j++) {
                    if((i&1<<j)!=0) {
                        sum += arr[j];
                        if(sum>targetNum) continue outer;
                    }
                }
                if(sum==targetNum) answer++;
            }
            System.out.printf("#%d %d\n", t, answer);
        }
        br.close();
    }
}

