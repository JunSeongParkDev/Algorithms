package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어디에 단어가 들어갈 수 있을까
public class S1979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int wordLength = Integer.parseInt(st.nextToken());
            int[][] map = new int[N+2][N+2];
            for(int i=1; i<map.length-1; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<map[i].length-1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < map.length-1; i++) {
                for (int j = 1; j < map[i].length-1; j++) {
                    if(map[i][j]==1) {
                        int k = 1;
                        while(map[i][j+k]==1) {
                            k++;
                        }
                        if(k==wordLength && map[i][j-1]!=1) answer++;

                        k = 1;
                        while(map[i+k][j]==1) {
                            k++;
                        }
                        if(k==wordLength && map[i-1][j]!=1) answer++;
                    }
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }
        br.close();
    }
}

