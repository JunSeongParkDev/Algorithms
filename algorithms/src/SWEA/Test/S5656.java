package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5656. [모의 SW 역량테스트] 벽돌 깨기
public class S5656 {
    private static int B;
    private static int M;
    private static int N;
    private static int[] perm;
    private static int[][] mCopy;
    private static int[][] map;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int minBlock;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(br);
            makePermutation(0, M, B);
            answer.append('#').append(t).append(' ').append(minBlock).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void doSimulate() {
        for (int i = 0; i < B; i++) {
            bfs(perm[i]);
            gravity();
        }
        int blockCnt = 0;
        for (int i = 0; i < mCopy.length; i++) {
            for (int j = 0; j < mCopy[i].length; j++) {
                if(mCopy[i][j]!=0) blockCnt++;
            }
        }

        if(blockCnt < minBlock) minBlock = blockCnt;
        if(minBlock==0) return;
        clearMap();
    }

    private static void clearMap() {
        for (int i = 0; i < mCopy.length; i++) {
            for (int j = 0; j < mCopy[i].length; j++) {
                mCopy[i][j] = map[i][j];
            }
        }
    }

    private static void gravity() {
        for (int i = 0; i < M; i++) {
            for (int j = N-1; j >=0; j--) {
                if(mCopy[j][i]==0) {
                    int k = j;
                    while(k>=0 && mCopy[k][i]==0) k--;
                    if(k>-1) {
                        mCopy[j][i] = mCopy[k][i];
                        mCopy[k][i] = 0;
                    }
                }
            }
        }
    }

    private static void bfs(int y) {
        int x = 0;
        while(x < N && mCopy[x][y]==0) x++;
        if(x==N) return;
        queue.offer(x);
        queue.offer(y);

        while(!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            int coverage = mCopy[x][y];
            mCopy[x][y] = 0;
            for (int i = 0; i < coverage-1; i++) {
                if(x-1-i>=0 && mCopy[x-1-i][y]!=0) {
                    queue.offer(x-1-i);
                    queue.offer(y);
                }
                if(x+1+i<N && mCopy[x+1+i][y]!=0) {
                    queue.offer(x+1+i);
                    queue.offer(y);
                }
                if(y-1-i>=0 && mCopy[x][y-1-i]!=0) {
                    queue.offer(x);
                    queue.offer(y-1-i);
                }
                if(y+1+i<M && mCopy[x][y+1+i]!=0) {
                    queue.offer(x);
                    queue.offer(y+1+i);
                }
            }
        }
    }

    private static void makePermutation(int index, int n, int r) {
        if(index==r) {
            doSimulate();
        } else {
            for (int i = 0; i < n; i++) {
                perm[index] = i;
                makePermutation(index+1, n, r);
            }
        }
    }

    private static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        perm = new int[B];
        mCopy = new int[N][M];
        map = new int[N][M];
        minBlock = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[i].length; j++) {
                mCopy[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

