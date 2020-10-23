package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1226. [S/W 문제해결 기본] 7일차 - 미로1
public class S1226 {
    public static int[][] map;
    public static boolean isVisited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            map = new int[18][18];
            isVisited = new boolean[18][18];
            int startPointX = 0;
            int startPointY = 0;
            int destinationX = 0;
            int destinationY = 0;
            for (int i = 1; i < map.length-1; i++) {
                String input = br.readLine();
                for (int j = 1; j < map[i].length-1; j++) {
                    map[i][j] = input.charAt(j-1)-'0';
                    if(map[i][j]==2) {
                        startPointX = i;
                        startPointY = j;
                    }
                    if(map[i][j]==3) {
                        destinationX = i;
                        destinationY = j;
                    }
                }
            }
            dfs(startPointX, startPointY);
            System.out.printf("#%d %d\n", tc, isVisited[destinationX][destinationY]?1:0);
        }	// end of test case
        br.close();
    }	// end of main
    public static void dfs(int x, int y) {
        isVisited[x][y] = true;
        if(map[x][y+1]!=1 && !isVisited[x][y+1]) dfs(x, y+1);
        if(map[x+1][y]!=1 && !isVisited[x+1][y]) dfs(x+1, y);
        if(map[x][y-1]!=1 && !isVisited[x][y-1]) dfs(x, y-1);
        if(map[x-1][y]!=1 && !isVisited[x-1][y]) dfs(x-1, y);
    }
}

