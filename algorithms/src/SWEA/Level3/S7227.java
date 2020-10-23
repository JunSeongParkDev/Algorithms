package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7227. 사랑의 카운슬러
public class S7227 {
    private static int[] comb;
    private static int[][] ew;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            ew = new int[N][2];
            for (int i = 0; i < ew.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ew[i][0] = Integer.parseInt(st.nextToken());
                ew[i][1] = Integer.parseInt(st.nextToken());
            }
            comb = new int[ew.length/2];
//			for (int[] is : ew) {
//				System.out.println(Arrays.toString(is));
//			}
//			comb[0] = 0;
            minVec = Long.MAX_VALUE;
            combination(ew.length, comb.length);
            System.out.printf("#%d %d\n", t, minVec);
        }

        br.close();
    }
    private static long minVec;
    private static void combination(int n, int k) {
        if(k==1) {
            int selectedX = 0;
            int selectedY = 0;
            int unselectedX = 0;
            int unselectedY = 0;
            int cnt = 0;
            for (int i = 0; i < ew.length; i++) {
                if(cnt<comb.length && i==comb[cnt]) {
                    selectedX += ew[i][0];
                    selectedY += ew[i][1];
                    cnt++;
                } else {
                    unselectedX += ew[i][0];
                    unselectedY += ew[i][1];
                }
            }
            int x = selectedX-unselectedX;
            int y = selectedY-unselectedY;
            long tVec = (long)x*x + (long)y*y;
            if(tVec<minVec) minVec = tVec;
//			System.out.println(Arrays.toString(comb));
        } else if(n < k) {
            return;
        } else {
            comb[k-1] = n-1;
            combination(n-1, k-1);
            combination(n-1, k);
        }
    }
}

