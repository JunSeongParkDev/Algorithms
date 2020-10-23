package SWEA.Level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 종구의 딸이름 짓기
public class S7396 {

    private static int N;
    private static int M;
    private static char[][] map;
    private static char[] name;
    private static boolean[][] isVisited;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(br);
            BFS();
            answer.append('#').append(t).append(' ').append(String.valueOf(name)).append('\n');
        }	// end of test case
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
    private static void BFS() {
        PriorityQueue<V> pq = new PriorityQueue<V>((o1, o2) -> o1.c-o2.c);
        PriorityQueue<V> pqChild = new PriorityQueue<V>((o1, o2) -> o1.c-o2.c);
        PriorityQueue<V> temp;

        pq.offer(new V(0, 0));
        isVisited[0][0] = true;

        while(!pq.isEmpty()) {
            V v = pq.poll();
            char c = v.c;
            name[v.x + v.y] = c;
            pqChild.clear();

            if(v.y+1<M) {
                pqChild.offer(new V(v.x, v.y+1));
                isVisited[v.x][v.y+1] = true;
            }
            if(v.x+1<N) {
                pqChild.offer(new V(v.x+1, v.y));
                isVisited[v.x+1][v.y] = true;
            }
            for (int i = pq.size(); i > 0 ; i--) {
                v = pq.poll();
                if(v.c == c) {	// 우선 순위가 같은 글자이면 큐에 자식을 넣기
                    if(v.y+1<M && !isVisited[v.x][v.y+1]) {
                        pqChild.offer(new V(v.x, v.y+1));
                        isVisited[v.x][v.y+1] = true;
                    }
                    if(v.x+1<N && !isVisited[v.x+1][v.y]) {
                        pqChild.offer(new V(v.x+1, v.y));
                        isVisited[v.x+1][v.y] = true;
                    }
                } else {
                    break;
                }
            }
            temp = pq;
            pq = pqChild;
            pqChild = temp;
        }
    }
    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().toCharArray();
        }
        name = new char[N+M-1];
        isVisited = new boolean[N][M];
    }
    private static class V {
        int x;
        int y;
        char c;
        public V(int x, int y) {
            this.x = x;
            this.y = y;
            this.c = map[x][y];
        }
    }
}