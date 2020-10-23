package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1949. [모의 SW 역량테스트] 등산로 조성
public class S1949 {
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N;
    private static int K;
    private static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            isVisited = new boolean[N][N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(max < map[i][j]) max = map[i][j];
                }
            }
            answer = Integer.MIN_VALUE;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(map[i][j]==max) {
                        dfs(i, j, 1, true);
//						System.out.println();
                    }
                }
            }
            output.append('#').append(t).append(' ').append(answer).append('\n');
        }	// end of test case
        System.out.print(output.toString().trim());
        br.close();
    }	// end of main
    private static int answer;

    private static void dfs(int x, int y, int step, boolean cut) {
        isVisited[x][y] = true;
//		System.out.print(map[x][y] + " ");
        if(answer < step) answer = step;
        if(y+1<N && !isVisited[x][y+1]) {
            if(map[x][y+1]<map[x][y]) {
                dfs(x, y+1, step+1, cut);
            } else if(cut && map[x][y+1]-K<map[x][y]) {
                int temp = map[x][y+1];
                map[x][y+1] = map[x][y]-1;
                dfs(x, y+1, step+1, !cut);
                map[x][y+1] = temp;

//				for(int i=map[x][y]-1; i>=map[x][y+1]-K; i--) {
//					int temp = map[x][y+1];
//					map[x][y+1] = i;
//					dfs(x, y+1, step+1, !cut);
//					map[x][y+1] = temp;
//				}
            }
        }
        if(y-1>=0 && !isVisited[x][y-1]) {
            if(map[x][y-1]<map[x][y]) {
                dfs(x, y-1, step+1, cut);
            } else if(cut && map[x][y-1]-K<map[x][y]) {
                int temp = map[x][y-1];
                map[x][y-1] = map[x][y]-1;
                dfs(x, y-1, step+1, !cut);
                map[x][y-1] = temp;
//				for(int i=map[x][y]-1; i>=map[x][y-1]-K; i--) {
//					int temp = map[x][y-1];
//					map[x][y-1] = i;
//					dfs(x, y-1, step+1, !cut);
//					map[x][y-1] = temp;
//				}
            }
        }
        if(x+1<N && !isVisited[x+1][y]) {
            if(map[x+1][y]<map[x][y]) {
                dfs(x+1, y, step+1, cut);
            } else if(cut && map[x+1][y]-K<map[x][y]) {
                int temp = map[x+1][y];
                map[x+1][y] = map[x][y]-1;
                dfs(x+1, y, step+1, !cut);
                map[x+1][y] = temp;
//				for(int i=map[x][y]-1; i>=map[x+1][y]-K; i--) {
//					int temp = map[x+1][y];
//					map[x+1][y] = i;
//					dfs(x+1, y, step+1, !cut);
//					map[x+1][y] = temp;
//				}
            }
        }
        if(x-1>=0 && !isVisited[x-1][y]) {
            if(map[x-1][y]<map[x][y]) {
                dfs(x-1, y, step+1, cut);
            } else if(cut && map[x-1][y]-K<map[x][y]) {
                int temp = map[x-1][y];
                map[x-1][y] = map[x][y]-1;
                dfs(x-1, y, step+1, !cut);
                map[x-1][y] = temp;
//				for(int i=map[x][y]-1; i>=map[x-1][y]-K; i--) {
//					int temp = map[x-1][y];
//					map[x-1][y] = i;
//					dfs(x-1, y, step+1, !cut);
//					map[x-1][y] = temp;
//				}
            }
        }
        isVisited[x][y]=false;
    }
}
