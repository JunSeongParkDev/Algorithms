package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6719. 성수의 프로그래밍 강좌 시청
public class S6719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
//			System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);

            double score = 0.0;
            for (int i = arr.length-K; i < arr.length; i++) {
                score = (score+arr[i])/2;
            }
            System.out.printf("#%d %f\n", t, score);
        }	// end of test case
        br.close();
    }	// end of main
}
