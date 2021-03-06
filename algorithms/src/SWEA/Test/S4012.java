package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4012. [모의 SW 역량테스트] 요리사
public class S4012 {
    private static int[][] synergy;
    private static int min;
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;
    private static int[] comb;
    private static int[] unSelected;
    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            synergy = new int[N][N];
            for (int i = 0; i < synergy.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < synergy[i].length; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            comb = new int[N/2];
            unSelected = new int[N/2];
            makeCombination(N, comb.length);
            answer.append('#').append(t).append(' ').append(min).append('\n');
        }	// end of test case
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
    private static void makeCombination(int n, int r) {
        if(r==1) {
//			System.out.println(Arrays.toString(comb));
            int sum1 = 0;
            int sum2 = 0;
outer:		for (int i = 0; i < N; i++) {
                for (int j = 0; j < comb.length; j++) {
                    if(comb[j]==i) continue outer;
                }
                unSelected[sum1++]=i;
            }
            sum1 = 0;
//			System.out.println("unselected : " + Arrays.toString(unSelected));
            for (int i = 0; i < comb.length; i++) {
                for (int j = 0; j < comb.length; j++) {
                    sum1 += synergy[comb[i]][comb[j]];
                }
            }
            for (int i = 0; i < unSelected.length; i++) {
                for (int j = 0; j < unSelected.length; j++) {
                    sum2 += synergy[unSelected[i]][unSelected[j]];
                }
            }
            if(Math.abs(sum1 - sum2) < min) min = Math.abs(sum1 - sum2);
        } else if(n < r) {
            return;
        } else {
            comb[r-1] = n-1;
            makeCombination(n-1, r-1);
            makeCombination(n-1, r);
        }
    }
}
