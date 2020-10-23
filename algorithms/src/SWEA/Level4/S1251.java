package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1251. [S/W 문제해결 응용] 4일차 - 하나로
public class S1251 {
    public static class Edge  {
        int from;
        int to;
        double weight;
        public Edge(int from, int to, double weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }
    }
    private static int[] p;
    private static int[] rank;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][2];
            p = new int[N];
            rank = new int[N];
            StringTokenizer x = new StringTokenizer(br.readLine());
            StringTokenizer y = new StringTokenizer(br.readLine());
            for (int i = 0; i < map.length; i++) {
                map[i][0] = Integer.parseInt(x.nextToken());
                map[i][1] = Integer.parseInt(y.nextToken());
            }
            List<Edge> list = new ArrayList<Edge>();

            double tax = Double.parseDouble(br.readLine());
            for (int i = 0; i < map.length; i++) {
                for (int j = i+1; j < map.length; j++) {
                    list.add(new Edge(i, j, (Math.pow((map[i][0]-map[j][0]), 2) + Math.pow((map[i][1]-map[j][1]), 2))*tax));
                }
            }

            list.sort((o1, o2) -> {
                return o1.weight-o2.weight<0?-1:1;
            });


            for (int i = 0; i < N; i++) {
                makeSet(i);
            }

            double MST = 0;
            int eCnt = 0;
            for (int i = 0; i < list.size(); i++) {
                Edge e = list.get(i);
                int px = findSet(e.from);
                int py = findSet(e.to);
                if(px!=py) {
                    union(e.from, e.to);
                    eCnt++;
                    MST += e.weight;
                }
                if(eCnt==N-1) {
                    break;
                }
            }

            answer.append(String.format("#%d %d\n", t, Math.round(MST)));
        }	// end of test case
        System.out.print(answer.toString());
        br.close();
    }	// end of main

    private static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px != py) {
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

    private static int findSet(int x) {
        if(p[x]==x) return x;
        else {
            p[x] = findSet(p[x]);
            return p[x];
        }
    }

    private static void makeSet(int x) {
        p[x] = x;
        rank[x] = 0;
    }
}
