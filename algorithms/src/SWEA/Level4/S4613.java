package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4613. 러시아 국기 같은 깃발
public class S4613 {
    private static int[][] arr;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    if(input.charAt(j)=='W') arr[i][0]++;
                    else if(input.charAt(j)=='B') arr[i][1]++;
                    else if(input.charAt(j)=='R') arr[i][2]++;
                }
            }
            int[][] memo = new int[N][3];
            memo[0][0] = arr[0][1] + arr[0][2];
            memo[0][1] = 987654321;
            memo[0][2] = 987654321;

            for (int i = 1; i < memo.length; i++) {
                memo[i][0] = memo[i-1][0] + arr[i][1] + arr[i][2];
                memo[i][1] = (memo[i-1][0] <= memo[i-1][1] ? memo[i-1][0] : memo[i-1][1]) + arr[i][0] + arr[i][2];
                memo[i][2] = (memo[i-1][1] <= memo[i-1][2] ? memo[i-1][1] : memo[i-1][2]) + arr[i][0] + arr[i][1];
            }
            answer.append('#').append(t).append(' ').append(memo[N-1][2]).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}