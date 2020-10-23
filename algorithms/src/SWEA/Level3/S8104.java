package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8104. 조 만들기
public class S8104 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            StringBuilder answer = new StringBuilder();

            int cnt = 1;
            int oddEven = N%2==1?1:0;

            for(int i=0; i<K; i++) {
                answer.append((((N-oddEven)*K)+1)*(N/2) + (K*(N-1)+cnt++)*oddEven + " ");
            }
            System.out.printf("#%d %s\n", t+1, answer.toString().trim());
        }
        br.close();
    }
}


