package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9229. 한빈이와 Spot Mart
public class S9229 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine().trim(), " ");
            int[] weights = new int[N];
            for (int i = 0; i < weights.length; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }
            int maxValue = -1;
            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < weights.length; j++) {
                    if(i==j) continue;
                    int sum = 0;
                    sum = weights[i] + weights[j];
                    if(sum<=M && sum>maxValue) maxValue = sum;
                }
            }
            answer.append('#').append(t).append(' ').append(maxValue).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
