package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3349. 최솟값으로 이동하기
public class S3349 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            Integer.parseInt(st.nextToken());
            Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] point = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                point[i][1] = Integer.parseInt(st.nextToken());
                point[i][0] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i = 0; i < point.length-1; i++) {
                int path1 = Math.abs(point[i+1][0]-point[i][0]) + Math.abs(point[i+1][1]-point[i][1]);
                int path2 = 0;
                if(Math.abs(point[i+1][0]-point[i][0])<Math.abs(point[i+1][1]-point[i][1])) {
                    path2 += Math.abs(point[i+1][0] - point[i][0]);
                    path2 += Math.abs(point[i+1][1] - (point[i][1] + point[i+1][0] - point[i][0]));
                } else {
                    path2 += Math.abs(point[i+1][1] - point[i][1]);
                    path2 += Math.abs(point[i+1][0] - (point[i][0] + point[i+1][1] - point[i][1]));
                }
                sum += path1>path2?path2:path1;
            }
            answer.append('#').append(t).append(' ').append(sum).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
