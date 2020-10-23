package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 배열 회전
public class S1961 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(input.nextToken());
                }
            }
            System.out.printf("#%d\n", t+1);

            StringBuilder[] lines = new StringBuilder[N];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = new StringBuilder();
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    lines[i].append(arr[arr.length-1-j][i]);
                }
                lines[i].append(" ");
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    lines[i].append(arr[arr.length-1-i][arr.length-1-j]);
                }
                lines[i].append(" ");
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    lines[i].append(arr[j][arr.length-1-i]);
                }
                lines[i].append(" ");
            }
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i].toString().trim());
            }
        }

        br.close();
    }	// end of main
}
