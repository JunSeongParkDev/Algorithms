package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3347. 올림픽 종목 투표
public class S3347 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            int[] vote = new int[N];
            for (int i = 0; i < B.length; i++) {
                int max = Integer.MIN_VALUE;
                int maxIndex = -1;
                for (int j = 0; j < A.length; j++) {
                    if(A[j]<=B[i] && max<A[j]) {
                        max = A[j];
                        maxIndex = j;
                        break;
                    }
                }
                vote[maxIndex]++;
            }
            int max = vote[0];
            int maxIndex = 0;
            for (int i = 1; i < vote.length; i++) {
                if(max<vote[i]) {
                    max = vote[i];
                    maxIndex = i;
                }
            }
            System.out.format("#%d %d\n", t, maxIndex+1);
        }	// end of test case
        br.close();
    }	// end of main
}

