package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6109. 추억의 2048게임
public class S6109 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int[][] map = new int[N][N];
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            switch(operation) {
                case "up":
                    for (int i = 0; i < N-1; i++) {
                        for (int j = 0; j < N; j++) {
                            if(map[i][j]==0) {
                                int temp = i;
                                while(temp<N-1 && map[temp][j]==0) temp++;
                                map[i][j] = map[temp][j];
                                map[temp][j] = 0;
                            }
                        }
                    }
                    for (int i = 0; i < N-1; i++) {
                        for (int j = 0; j < N; j++) {
                            if(map[i][j]==map[i+1][j]) {
                                map[i][j]*=2;
                                map[i+1][j] = 0;
                                int temp = i+1;
                                for (; temp < N-1; temp++) {
                                    map[temp][j] = map[temp+1][j];
                                } map[temp][j] = 0;
                            }
                        }
                    }
                    break;
                case "down":
                    for (int i = N-1; i > 0; i--) {
                        for (int j = 0; j < N; j++) {
                            if(map[i][j]==0) {
                                int temp = i;
                                while(temp>0 && map[temp][j]==0) temp--;
                                map[i][j] = map[temp][j];
                                map[temp][j] = 0;
                            }
                        }
                    }
                    for (int i = N-1; i > 0; i--) {
                        for (int j = 0; j < N; j++) {
                            if(map[i][j]==map[i-1][j]) {
                                map[i][j]*=2;
                                map[i-1][j] = 0;
                                int temp = i-1;
                                for (; temp > 0; temp--) {
                                    map[temp][j] = map[temp-1][j];
                                } map[temp][j] = 0;
                            }
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N-1; j++) {
                            if(map[i][j]==0) {
                                int temp = j;
                                while(temp<N-1 && map[i][temp]==0) temp++;
                                map[i][j] = map[i][temp];
                                map[i][temp] = 0;
                            }
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N-1; j++) {
                            if(map[i][j]==map[i][j+1]) {
                                map[i][j]*=2;
                                map[i][j+1] = 0;
                                int temp = j+1;
                                for (; temp < N-1; temp++) {
                                    map[i][temp] = map[i][temp+1];
                                } map[i][temp] = 0;
                            }
                        }
                    }
                    break;
                case "right":
                    for (int i = 0; i < N; i++) {
                        for (int j = N-1; j > 0; j--) {
                            if(map[i][j]==0) {
                                int temp = j;
                                while(temp>0 && map[i][temp]==0) temp--;
                                map[i][j] = map[i][temp];
                                map[i][temp] = 0;
                            }
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        for (int j = N-1; j > 0; j--) {
                            if(map[i][j]==map[i][j-1]) {
                                map[i][j]*=2;
                                map[i][j-1] = 0;
                                int temp = j-1;
                                for (; temp > 0; temp--) {
                                    map[i][temp] = map[i][temp-1];
                                } map[i][temp] = 0;
                            }
                        }
                    }
                    break;
            }
            answer.append('#').append(t).append('\n');
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    answer.append(map[i][j]).append(' ');
                } answer.append('\n');
            }
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
