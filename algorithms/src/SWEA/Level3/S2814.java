package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2814. 최장 경로
public class S2814 {
    private static boolean[] isVisited;
    private static boolean[][] map;
    private static StringBuilder answer = new StringBuilder();
    private static int maxLength;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new boolean[N+1][N+1];
            isVisited = new boolean[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = true;
                map[to][from] = true;
            }
            maxLength = 0;
            for (int i = 1; i < map.length; i++) dfs(i, 1);

            answer.append('#').append(t).append(' ').append(maxLength).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
    private static void dfs(int vertex, int depth) {
        if(maxLength < depth) maxLength = depth;

        isVisited[vertex] = true;
        for (int i = 1; i < map[vertex].length; i++) {
            if(map[vertex][i] && !isVisited[i]) dfs(i, depth+1);
        }
        isVisited[vertex] = false;
    }
}
