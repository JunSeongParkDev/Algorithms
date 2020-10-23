package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1210. [S/W 문제해결 기본] 2일차 - Ladder1
public class S1210 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dir = 1;

        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());

            int[][] map = new int[100][102];

            for (int i = 0; i < map.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");	// 내부를 보면 whitespace 전체 처리하는데 구분자로 쓸거만 써주면 좀 더 빠름

                for (int j = 1; j < 101; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int r = 99;
            int c = 0;
            for (int i = 1; i < 101; i++) {
                if(map[99][i]==2)
                    c=i;
            }

            final int 상 = 1;
            final int 좌 = 2;
            final int 우 = 3;

            dir = 상;

            while(r>0) {
                if(dir!=우 && map[r][c-1]==1) {
                    dir = 좌;
                    c--;
                } else if(dir!=좌 &&map[r][c+1]==1) {
                    dir = 우;
                    c++;
                } else {
                    dir = 상;
                    r--;
                }
            }
            System.out.printf("#%d %d\n", tc, c-1);
        }	// end of test case
    }	// end of main
}	// end of class