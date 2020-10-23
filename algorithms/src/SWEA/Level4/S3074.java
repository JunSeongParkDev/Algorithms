package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3074. 입국심사
public class S3074 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] immigration = new int[N];
            for (int i = 0; i < immigration.length; i++) {
                immigration[i] = Integer.parseInt(br.readLine());
            }
            long start = 0;
            long end = (long)1000000000*M;
            long min = Long.MAX_VALUE;
            while(start <= end) {
                long mid = (start+end)/2;
                long sum = 0;
                for (int i = 0; i < immigration.length; i++) {
                    sum += mid/immigration[i];
                }
                if(sum >= M) {
                    end = mid - 1;
                    if(mid < min) min = mid;
                }
                else start = mid +1;
            }
            answer.append('#').append(t).append(' ').append(min).append('\n');
        }	// end of test case
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
}