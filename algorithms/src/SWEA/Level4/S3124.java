package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 3124. 최소 스패닝 트리
public class S3124 {
    private static int[] p;
    private static int[] rank;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<int[]>(E);
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            list.sort(Comparator.comparingInt(o -> o[2]));

            p = new int[V+1];
            rank = new int[V+1];

            for (int i = 0; i < p.length; i++) {
                makeSet(i);
            }

            long MST = 0;
            int eCnt = 0;
            for (int i = 0; i < E; i++) {
                int[] temp = list.get(i);
                int px = findSet(temp[0]);
                int py = findSet(temp[1]);
                if(px!=py) {
                    union(temp[0], temp[1]);
                    eCnt++;
                    MST += temp[2];
                }
                if(eCnt==V-1) {
                    break;
                }
            }
            answer.append(String.format("#%d %d\n", t, MST));
        }	// end of test case
        System.out.print(answer.toString());
        br.close();
    }	// end of main


    private static void makeSet(int x) {
        p[x] = x;
        rank[x] = 0;
    }
    private static int findSet(int x) {
        if(p[x]==x) {
            return x;
        }
        p[x] = findSet(p[x]);
        return p[x];
    }
    private static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if(px!=py) {
            link(px, py);
        } else {
            return;
        }
    }
    private static void link(int px, int py) {
        if (rank[px] > rank[py]) {
            p[py] = px;
        } else {
            p[px] = py;
            if (rank[px] == rank[py]) {
                rank[py]++;
            }
        }
    }
}
