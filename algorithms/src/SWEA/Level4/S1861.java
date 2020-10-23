package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1861. 정사각형 방
public class S1861 {
    private static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N+2][N+2];
            StringTokenizer st;
            for (int i = 1; i < map.length-1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j < map[i].length-1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isVisited = new int[((int)Math.pow(N, 2))+1];
            for (int i = 0; i < isVisited.length; i++) {
                isVisited[i] = -1;
            }
            for (int i = 1; i < map.length-1; i++) {
                for (int j = 1; j < map[i].length-1; j++) {
                    if(isVisited[map[i][j]]==-1) {
                        maxStep = 0;
                        dfs(i, j, 1);
                    }
                }
            }
            int answerIndex = 0;
            int answerValue = isVisited[0];
            for (int i = 1; i < isVisited.length; i++) {
                if(answerValue<isVisited[i]) {
                    answerValue = isVisited[i];
                    answerIndex = i;
                }
            }

            System.out.printf("#%d %d %d\n", t, answerIndex, answerValue);
        }	// end of test case
        br.close();
    }	// end of main
    private static int maxStep;
    private static int[] isVisited;
    public static void dfs(int x, int y, int step) {
        if(step>maxStep) maxStep=step;
        isVisited[map[x][y]] = 0;
        if(map[x][y+1]!=0 && map[x][y+1]==map[x][y]+1) {
            if(isVisited[map[x][y+1]]!=-1) {
                isVisited[map[x][y]] = 1+isVisited[map[x][y+1]];
                return;
            }
            else dfs(x, y+1, step+1);
        }
        if(map[x+1][y]!=0 && map[x+1][y]==map[x][y]+1) {
            if(isVisited[map[x+1][y]]!=-1) {
                isVisited[map[x][y]] = 1+isVisited[map[x+1][y]];
                return;
            }
            else dfs(x+1, y, step+1);
        }
        if(map[x][y-1]!=0 && map[x][y-1]==map[x][y]+1) {
            if(isVisited[map[x][y-1]]!=-1) {
                isVisited[map[x][y]] = 1+isVisited[map[x][y-1]];
                return;
            }
            else dfs(x, y-1, step+1);
        }
        if(map[x-1][y]!=0 && map[x-1][y]==map[x][y]+1) {
            if(isVisited[map[x-1][y]]!=-1) {
                isVisited[map[x][y]] = 1+isVisited[map[x-1][y]];
                return;
            }
            else dfs(x-1, y, step+1);
        }
        isVisited[map[x][y]] = maxStep-step+1;
    }
}

