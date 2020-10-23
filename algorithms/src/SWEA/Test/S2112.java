package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2112. [모의 SW 역량테스트] 보호 필름
public class S2112 {
    private static int[][] map;
    private static int[][] mCopy;
    private static int K;
    private static int M;
    private static int N;
    private static int[] combination;
    private static int combSize;
    private static StringBuilder answer = new StringBuilder();
    private static int minCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            mCopy = new int[N][M];
            combination = new int[N];
            minCount = -1;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                } mCopy[i] = map[i].clone();
            }
            if(checkIsTrustable()) {
                answer.append('#').append(t).append(' ').append(0).append('\n');
                continue;
            } else {
                for (int n = 1; n <= K; n++) {
                    combSize = n;
                    makeCombination(N, n);
                    if(minCount!=-1){
                        answer.append('#').append(t).append(' ').append(minCount).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void makeCombination(int n, int r) {
        if(r==0) {

            for(int i=0; i<(1<<combSize); i++) {
                for (int j = 0; j < combSize; j++) {
                    if((i & (1<<j)) !=0) {
                        for (int k = 0; k < mCopy[combination[j]].length; k++) {
                            mCopy[combination[j]][k] = 0;
                        }
                    }
                    else {
                        for (int k = 0; k < mCopy[combination[j]].length; k++) {
                            mCopy[combination[j]][k] = 1;
                        }
                    }
                }
                if(checkIsTrustable()) {
                    minCount = combSize;
                    return;
                }
                for (int j = 0; j < mCopy.length; j++) {
                    mCopy[j] = map[j].clone();
                }
            }
        } else if(n < r) {
            return;
        } else {
            combination[r-1] = n-1;
            makeCombination(n-1, r-1);
            makeCombination(n-1, r);
        }
    }

    private static boolean checkIsTrustable() {
        for (int j = 0; j < M; j++) {
            int maxDepth = 0;
            int depth = 1;
            for (int i = 0; i < N-1; i++) {
                if(mCopy[i][j]==mCopy[i+1][j]) depth++;
                else depth = 1;

                if(maxDepth<depth) maxDepth = depth;
            }
            if(maxDepth<K) return false;
        }
        return true;
    }
}