package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7465. 창용 마을 무리의 개수
public class S7465 {
    private static int[] p;
    private static int[] rank;
    private static boolean[] bunch;
    private static StringTokenizer st;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            p = new int[N+1];
            rank = new int[N+1];
            bunch = new boolean[N+1];
            for (int i = 0; i < p.length; i++) {
                makeSet(i);
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for (int i = 1; i < p.length; i++) {
                findSet(i);
                bunch[p[i]] = true;
            }
            int tempAnswer = 0;
            for (int i = 1; i < bunch.length; i++) {
                if(bunch[i]) tempAnswer++;
            }
            answer.append('#').append(t).append(' ').append(tempAnswer).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if(px==py) {
            return;
        } else {
            if(px > py) {
                p[py] = px;
            } else {
                p[px] = py;
                if(px==py) {
                    rank[py]++;
                }
            }
        }
    }
    private static int findSet(int x) {
        if(p[x]==x) return p[x];
        else {
            p[x] = findSet(p[x]);
            return p[x];
        }
    }
    private static void makeSet(int i) {
        p[i] = i;
        rank[i] = 0;
    }
}
