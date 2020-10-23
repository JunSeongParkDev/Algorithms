package SWEA.Level6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 응용] 8일차 - 사람 네트워크2
public class S1263 {
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;
    private static int[][] map;
    private static final int M = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if(i==j) continue;
                    map[i][j] = value==0?M:value;
                }
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if(k==i) continue;
                    if(map[i][k]==M) continue;
                    for (int j = 0; j < N; j++) {
                        if(i==j) continue;
                        if(map[k][j]==M) continue;
                        int origin = map[i][j];
                        int comp = map[i][k] + map[k][j];
                        if(comp<origin) map[i][j] = comp;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < map.length; i++) {
                int sum = 0;
                for (int j = 0; j < map.length; j++) {
                    sum+=map[i][j];
                }
                if(sum<min) min=sum;
            }
            answer.append('#').append(t).append(' ').append(min).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

