package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 8658. Summation
public class S8658 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] sum = new int[10];
            int i = 0;
            while(st.hasMoreTokens()) {
                String num = st.nextToken();
                for (int j = 0; j < num.length(); j++) {
                    sum[i]+=num.charAt(j)-'0';
                }
                i++;
            }
            Arrays.sort(sum);
            answer.append('#').append(t).append(' ').append(sum[i-1]).append(' ').append(sum[10-i]).append('\n');
        }
        System.out.println(answer.toString().trim());
        br.close();
    }
}
