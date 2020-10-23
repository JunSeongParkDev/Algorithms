package SWEA.Level4;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 2819. 격자판의 숫자 이어 붙이기
public class S2819 {
    private static int[][] map;
    private static Map<String, Integer> save;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            map = new int[4][4];
            save = new HashMap<>();
            StringTokenizer st;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    dfs(i, j, 0, "");
                }
            }
            answer.append('#').append(t).append(' ').append(save.size()).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void dfs(int x, int y, int step, String builded) {
        if(step==7) {
            save.put(builded, save.size()+1);
            return;
        } else {
            if(x+1 < 4) dfs(x+1, y, step+1, builded.concat(String.valueOf(map[x][y])));
            if(x-1 >=0) dfs(x-1, y, step+1, builded.concat(String.valueOf(map[x][y])));
            if(y+1 < 4) dfs(x, y+1, step+1, builded.concat(String.valueOf(map[x][y])));
            if(y-1 >=0) dfs(x, y-1, step+1, builded.concat(String.valueOf(map[x][y])));
        }
    }
}
