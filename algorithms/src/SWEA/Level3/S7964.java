package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7964. 부먹왕국의 차원 관문
public class S7964 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int k = 0;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==0) k++;
                if(arr[i]==1) {
                    cnt += k/K;
                    k=0;
                }
            }
            if(k>=K) cnt+=k/K;
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
