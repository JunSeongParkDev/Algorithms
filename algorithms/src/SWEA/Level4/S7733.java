package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7733. 치즈 도둑
public class S7733 {
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            isVisited = new boolean[N][N];
            int maxValue = 0;
            for (int i = 0; i < map.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(maxValue < map[i][j]) maxValue = map[i][j];
                }
            }
            int maxCheese = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int m = 0; m <= maxValue; m++) {
                int cheese = 0;
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if(!isVisited[i][j] && map[i][j]>m) {
                            queue.offer(i);
                            queue.offer(j);
                            isVisited[i][j] = true;
                            while(!queue.isEmpty()) {
                                int x = queue.poll();
                                int y = queue.poll();
                                if(x+1<N && !isVisited[x+1][y] && map[x+1][y]>m) {
                                    queue.offer(x+1);
                                    queue.offer(y);
                                    isVisited[x+1][y] = true;
                                }
                                if(x-1>=0 && !isVisited[x-1][y] && map[x-1][y]>m) {
                                    queue.offer(x-1);
                                    queue.offer(y);
                                    isVisited[x-1][y] = true;
                                }
                                if(y+1<N && !isVisited[x][y+1] && map[x][y+1]>m) {
                                    queue.offer(x);
                                    queue.offer(y+1);
                                    isVisited[x][y+1] = true;
                                }
                                if(y-1>=0 && !isVisited[x][y-1] && map[x][y-1]>m) {
                                    queue.offer(x);
                                    queue.offer(y-1);
                                    isVisited[x][y-1] = true;
                                }
                            }
                            cheese++;
                        }
                    }
                }
                for (int i = 0; i < isVisited.length; i++) {
                    for (int j = 0; j < isVisited[i].length; j++) {
                        isVisited[i][j] = false;
                    }
                }
                if(cheese>maxCheese) maxCheese = cheese;
            }
            answer.append('#').append(t).append(' ').append(maxCheese).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}