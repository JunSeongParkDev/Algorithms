package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 개의 문자열
public class S1959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr1 = new int[N];
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            int[] arr2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            if(N<M) {
                for(int i=0; i<M-N+1; i++) {
                    int sum = 0;
                    for(int j=0; j<arr1.length; j++) {
                        sum += (arr1[j]*arr2[j+i]);
                    }
                    if(sum>max) {
                        max=sum;
                    }
                }
            }
            else {
                for(int i=0; i<N-M+1; i++) {
                    int sum = 0;
                    for(int j=0; j<arr2.length; j++) {
                        sum += (arr2[j]*arr1[j+i]);
                    }
                    if(sum>max) {
                        max=sum;
                    }
                }
            }
            System.out.printf("#%d %d\n", t+1, max);
        }
        br.close();
    }
}
