package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5643. [Professional] 키 순서
public class S5643 {
    private static int[][] map;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            map = new int[N+1][N+1];
            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int small = Integer.parseInt(st.nextToken());
                int tall = Integer.parseInt(st.nextToken());
                map[small][tall] = 1;
            }

            // 인접 행렬을 Update
            for (int i = 1; i < map.length; i++) {
                up(i);
            }
            // 학생 수 만큼 up() 호출 후에는 인접 행렬에는 나랑 직접 연관이 아니라도 큰 학생들이 표시되어 있다
            int totalN = 0;
            for (int i = 1; i < map.length; i++) {
                int sum = 0;
                for (int j = 1; j < map.length; j++) {
                    sum += map[i][j] + map[j][i];
                }
                if(sum==N-1) {	// 자신의 순위를 정확히 알 수 있다는 조건
                    totalN++;
                }
            }
            answer.append('#').append(t).append(' ').append(totalN).append('\n');
        }	// end of test case
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
    // V 정점의 인접 행렬(V보다 큰 학생)을 업데이트 (OR 연산)
    private static void up(int v) {
        if(map[v][0]==-1) return;	// 메모이제이션 사용
        for (int i = 1; i < map.length; i++) {
            if(map[v][i] == 1) { // v보다 i가 크다.
                up(i);	// 나보다 큰 학생의 인접 행렬을 먼저 업데이트 한다.
                for (int j = 1; j < map.length; j++) {
                    map[v][j] |= map[i][j];
                }
            }
        }
        map[v][0] = -1;
    }
}
