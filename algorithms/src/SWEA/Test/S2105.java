package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2105. [모의 SW 역량테스트] 디저트 카페
public class S2105 {
    private static int[][] map;
    private static boolean[] kindsOfDesert;
    private static int N;
    private static int maxDesert;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxDesert = -1;
            kindsOfDesert = new boolean[101];
            for (int i = 0; i < map.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] stack = new int[1000];
            int top = -1;
            for (int i = 0; i < map.length; i++) {
                for (int j = 1; j < map[i].length; j++) {
                    for (int d1 = 1; d1 < map.length; d1++) {
                        if(j-d1<0) continue;
                        for (int d2 = 1; d2 < map[i].length; d2++) {
                            if(j+d2>N-1) continue;
                            if(i+d1+d2>N-1) continue;
                            int tempD1 = 0;
                            int tempD2 = 0;
                            while(tempD1<d1 && !kindsOfDesert[map[i+tempD1][j-tempD1]]) {
                                kindsOfDesert[map[i+tempD1][j-tempD1]] = true;
                                stack[++top] = i+tempD1;
                                stack[++top] = j-tempD1;
                                tempD1++;
                            }
                            while(tempD2<d2 && !kindsOfDesert[map[i+tempD1+tempD2][j-tempD1+tempD2]]) {
                                kindsOfDesert[map[i+tempD1+tempD2][j-tempD1+tempD2]] = true;
                                stack[++top] = i+tempD1+tempD2;
                                stack[++top] = j-tempD1+tempD2;
                                tempD2++;
                            }
                            while(tempD1>0 && !kindsOfDesert[map[i+tempD1+tempD2][j-tempD1+tempD2]]) {
                                kindsOfDesert[map[i+tempD1+tempD2][j-tempD1+tempD2]] = true;
                                stack[++top] = i+tempD1+tempD2;
                                stack[++top] = j-tempD1+tempD2;
                                tempD1--;
                            }
                            while(tempD2>0 && !kindsOfDesert[map[i+tempD2][j+tempD2]]) {
                                kindsOfDesert[map[i+tempD2][j+tempD2]] = true;
                                stack[++top] = i+tempD2;
                                stack[++top] = j+tempD2;
                                tempD2--;
                            }
                            if(top==(d1+d2)*4-1) {
                                if(maxDesert<(d1+d2)*2) maxDesert = (d1+d2)*2;
                            }
                            while(top!=-1) {
                                int y = stack[top--];
                                int x = stack[top--];
                                kindsOfDesert[map[x][y]] = false;
                            }
                        }
                    }
                }
            }
            answer.append('#').append(t).append(' ').append(maxDesert).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
