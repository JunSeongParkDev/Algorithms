package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

// 1258. [S/W 문제해결 응용] 7일차 - 행렬찾기
public class S1258 {
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N;
    private static int xMax;
    private static int yMax;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            isVisited = new boolean[N][N];
            StringTokenizer st;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ArrayList<int[]> list = new ArrayList<int[]>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if(map[i][j]!=0 && !isVisited[i][j]) {
                        xMax = i;
                        yMax = j;
                        dfs(i, j);
                        list.add(new int[] {(xMax-i+1)*(yMax-j+1), (xMax-i+1), (yMax-j+1)});
                    }
                }
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            Iterator<int[]> it = list.iterator();
            answer.append("#" + t + " " + list.size() + " ");
            while(it.hasNext()) {
                int[] temp = it.next();
                answer.append(temp[1] + " " + temp[2] + " ");
            }
            answer.append("\n");
        }	// end of test case
        System.out.println(answer.toString());
        br.close();
    }	// end of main
    private static void dfs(int x, int y) {
        isVisited[x][y] = true;
        if(xMax<x) xMax=x;
        if(yMax<y) yMax=y;
        if(y+1<N && map[x][y+1]!=0 && !isVisited[x][y+1]) {
            dfs(x, y+1);
        }
        if(x+1<N && map[x+1][y]!=0 && !isVisited[x+1][y]) {
            dfs(x+1, y);
        }
        if(y-1>0 && map[x][y-1]!=0 && !isVisited[x][y-1]) {
            dfs(x, y-1);
        }
        if(x-1>0 && map[x-1][y]!=0 && !isVisited[x-1][y]) {
            dfs(x-1, y);
        }
    }
}
