package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3289. 서로소 집합
public class S3289 {
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;
    private static int[] p;
    private static int[] rank;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            p = new int[N+1];
            rank = new int[N+1];
            for (int i = 0; i < p.length; i++) {
                makeSet(i);
            }
            answer.append('#').append(t).append(' ');
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int operation = Integer.parseInt(st.nextToken());
                int x = findSet(Integer.parseInt(st.nextToken()));
                int y = findSet(Integer.parseInt(st.nextToken()));
                if(operation==0) {
                    if(x!=y) {
                        union(x, y);
                    }
                } else if(operation==1) {
                    if(x==y) answer.append(1);
                    else answer.append(0);
                }
            }
            answer.append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static void union(int px, int py) {
        if(rank[px] > rank[py]) {
            p[py] = px;
        } else {
            p[px] = py;
            if(rank[px]==rank[py]) {
                rank[py]++;
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

