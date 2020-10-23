package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1953. [모의 SW 역량테스트] 탈주범 검거
public class S1953 {

    private static int N;
    private static int M;
    private static int time;
    private static int[][] map;
    private static int[][] isVisited;
    private static int R;
    private static int C;
    private static StringBuilder answer = new StringBuilder();

    private static int[][] dir = {
            {},
            {0, 1, 2, 3},
            {0, 1},
            {2, 3},
            {0, 3},
            {1, 3},
            {1, 2},
            {0, 2}
    };
    private static int[][] type = {
            {1, 2, 5, 6},
            {1, 2, 4, 7},
            {1, 3, 4, 5},
            {1, 3, 6, 7}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(br);
            bfs();
            int cnt = 0;
            for (int i = 0; i < isVisited.length; i++) {
                for (int j = 0; j < isVisited[i].length; j++) {
                    if(isVisited[i][j]!=0) cnt++;
                }
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static void bfs() {
        int x = R;
        int y = C;
        int step = 1;
        isVisited[x][y] = step;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(x);
        queue.offer(y);
        queue.offer(step);

        while(!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            step = queue.poll();
            int thisType = map[x][y];
            for (int i = 0; i < dir[thisType].length; i++) {
                switch(dir[thisType][i]) {
                    case 0:
                        if(x-1>=0 && isVisited[x-1][y]==0) {
                            for (int j = 0; j < type[0].length; j++) {
                                if(map[x-1][y]==type[0][j] && step+1<=time) {
                                    queue.offer(x-1);
                                    queue.offer(y);
                                    queue.offer(step+1);
                                    isVisited[x-1][y] = step+1;
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if(x+1<N && isVisited[x+1][y]==0) {
                            for (int j = 0; j < type[1].length; j++) {
                                if(map[x+1][y]==type[1][j] && step+1<=time) {
                                    queue.offer(x+1);
                                    queue.offer(y);
                                    queue.offer(step+1);
                                    isVisited[x+1][y] = step+1;
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        if(y-1>=0 && isVisited[x][y-1]==0) {
                            for (int j = 0; j < type[2].length; j++) {
                                if(map[x][y-1]==type[2][j] && step+1<=time) {
                                    queue.offer(x);
                                    queue.offer(y-1);
                                    queue.offer(step+1);
                                    isVisited[x][y-1] = step+1;
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        if(y+1<M && isVisited[x][y+1]==0) {
                            for (int j = 0; j < type[3].length; j++) {
                                if(map[x][y+1]==type[3][j] && step+1<=time) {
                                    queue.offer(x);
                                    queue.offer(y+1);
                                    queue.offer(step+1);
                                    isVisited[x][y+1] = step+1;
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    }
    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
