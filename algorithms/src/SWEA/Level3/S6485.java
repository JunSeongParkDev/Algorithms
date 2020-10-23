package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6485. 삼성시의 버스 노선
public class S6485 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] route = new int[N][2];
            for (int i = 0; i < route.length; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                for(int j=0; j<route[i].length; j++) {
                    route[i][j] = Integer.parseInt(input.nextToken());
                }
            }
            int P = Integer.parseInt(br.readLine());

            int[] busStop = new int[5001];
            int[] checkPoint = new int[P];

            for(int i=0; i<checkPoint.length; i++) {
                checkPoint[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < route.length; i++) {
                for(int j=route[i][0]; j<route[i][1]+1; j++) {
                    busStop[j]++;
                }
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < checkPoint.length; i++) {
                answer.append(busStop[checkPoint[i]] + " ");
            }
            System.out.printf("#%d %s\n", t+1, answer.toString().trim());
        }

        br.close();
    }
}

