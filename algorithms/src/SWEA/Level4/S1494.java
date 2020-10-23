package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1494. 사랑의 카운슬러
public class S1494 {
    private static int[][] ew;
    private static int sumX;
    private static int sumY;
    private static long min;
    private static StringBuilder answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            ew = new int[N][2];
            sumX = 0;
            sumY = 0;
            for (int i = 0; i < ew.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                sumX += ew[i][0] = Integer.parseInt(st.nextToken());
                sumY += ew[i][1] = Integer.parseInt(st.nextToken());
            }

            min = Long.MAX_VALUE;
            makeCombination(N, N/2, 0, 0);
            answer.append('#').append(t).append(' ').append(min).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    /*
     * nCr selX, selX : 현재까지 더해온 합 들고다니면 중복연산 X
     * 재귀의 장점을 충분히 활용할 것
     */
    private static void makeCombination(int n, int r, int selX, int selY) {
        if(r==1) {
//			System.out.println(Arrays.toString(comb));
            selX += ew[0][0];
            selY += ew[0][1];
            long vX = selX * 2 - sumX;
            long vY = selY * 2 - sumY;
            long v = vX*vX + vY*vY;
            if(v<min) min=v;

            return;
        } else if(n < r) {
            return;
        } else {
            makeCombination(n-1, r-1, selX+ew[n-1][0], selY+ew[n-1][1]);
            makeCombination(n-1, r, selX, selY);
        }
    }
}
