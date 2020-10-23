package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4301. 콩 많이 심기
public class S4301 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[N][M];
            for (int i = 0; i < map.length; i+=4) {
                for (int j = 0; j < map[i].length; j+=4) {
                    map[i][j] = true;
                    if(j+1<M) map[i][j+1] = true;
                    if(i+1<N) map[i+1][j] = true;
                    if(i+1<N && j+1<M) map[i+1][j+1] = true;
                }
            }
            for (int i = 2; i < map.length; i+=4) {
                for (int j = 2; j < map[i].length; j+=4) {
                    map[i][j] = true;
                    if(j+1<M) map[i][j+1] = true;
                    if(i+1<N) map[i+1][j] = true;
                    if(i+1<N && j+1<M) map[i+1][j+1] = true;
                }
            }
            int cnt = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if(map[i][j]) cnt++;
                }
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}