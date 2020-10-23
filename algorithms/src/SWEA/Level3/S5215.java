package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5215. 햄버거 다이어트
public class S5215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int N = Integer.parseInt(st.nextToken());	// 재료의 수 1 <= N <= 20
            int K = Integer.parseInt(st.nextToken());	// 칼로리 리미트
            int[][] arr = new int[N][2];
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
//			for (int[] is : arr) {
//				System.out.println(Arrays.toString(is));
//			}

            int[] pSet = new int[N];
            for (int i = 0; i < pSet.length; i++) {
                pSet[i] = i;
            }

            int answer = 0;
            int score = 0;
            int kcal = 0;
            outer:		for (int i = 0; i < (1<<pSet.length); i++) {
                score = 0;
                kcal = 0;
                for (int j = 0; j < pSet.length; j++) {
                    if((i & (1 << j)) !=0) {
                        score += arr[j][0];
                        kcal += arr[j][1];
                    }
                    if(kcal>K) {
                        continue outer;
                    }
                }
                if(answer<score) {
                    answer = score;
                }
            }
            System.out.printf("#%d %d\n", t, answer);
        }	// end of test case
        br.close();
    }	// end of main
}
