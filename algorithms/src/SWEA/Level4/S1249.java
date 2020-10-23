package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 1249. [S/W 문제해결 응용] 4일차 - 보급로
public class S1249 {
    private static int N;
    private static int[][] map;
    private static int[][] min;
    private static final int INFINITE = Integer.MAX_VALUE;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(br);
            bfs();
            answer.append('#').append(t).append(' ').append(min[N-1][N-1]).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        int x = 0;
        int y = 0;
        int time = 0;
        queue.offer(x);
        queue.offer(y);
        queue.offer(time);
        while(!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            time = queue.poll();
            if(y+1<N && time+map[x][y+1]<min[x][y+1]) {
                min[x][y+1] = time+map[x][y+1];
                queue.offer(x);
                queue.offer(y+1);
                queue.offer(time+map[x][y+1]);
            }
            if(x+1<N && time+map[x+1][y]<min[x+1][y]) {
                min[x+1][y] = time+map[x+1][y];
                queue.offer(x+1);
                queue.offer(y);
                queue.offer(time+map[x+1][y]);
            }
            if(y-1>=0 && time+map[x][y-1]<min[x][y-1]) {
                min[x][y-1] = time+map[x][y-1];
                queue.offer(x);
                queue.offer(y-1);
                queue.offer(time+map[x][y-1]);
            }
            if(x-1>=0 && time+map[x-1][y]<min[x-1][y]) {
                min[x-1][y] = time+map[x-1][y];
                queue.offer(x-1);
                queue.offer(y);
                queue.offer(time+map[x-1][y]);
            }
        }
    }
    private static void init(BufferedReader br) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        min = new int[N][N];
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min[i].length; j++) {
                min[i][j] = INFINITE;
            }
        }
        String input;
        for (int i = 0; i < map.length; i++) {
            input = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
    }
}