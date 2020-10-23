package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1238. [S/W 문제해결 기본] 10일차 - Contact
public class S1238 {
    private static boolean[][] map;
    private static int[] isVisited;
    private static int start;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            init(br);
            answer.append('#').append(t).append(' ').append(bfs(start)).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        isVisited[start] = 1;
        int lastLevel = isVisited[start];
        while(!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < map[v].length; i++) {
                if(map[v][i] && isVisited[i]==0) {
                    q.offer(i);
                    lastLevel = isVisited[i] = isVisited[v] + 1;
                }
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if(isVisited[i]==lastLevel && maxIndex<i) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    private static void init(BufferedReader br) throws Exception {
        map = new boolean[101][101];
        isVisited = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N/2; i++) {
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
    }
}

