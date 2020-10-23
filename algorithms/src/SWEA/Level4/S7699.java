package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7699. 수지의 수지 맞는 여행
public class S7699 {

    private static char[][] map;
    private static int[] visited;
    private static int max;
    private static int R;
    private static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }
            // 65~90 사용
            visited = new int['Z'+1];
            visited[map[0][0]]++;	// 방문 체크
            max = 1;
            dfs(0, 0, 1);
            sb.append('#').append(t).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int r, int c, int step) {
        // 재귀 : 깊이 우선, 너비 우선, 가지 치기 등을 자유롭게 가능
        // 반복 : 같은 구조면 재귀보다 빠름
        // 백 트래킹의 포커스는 가지 치기
        if(max==26) {
            return;
        }

        if(max<step) max = step;
        if(0<=r-1 && visited[map[r-1][c]]==0) {
            visited[map[r-1][c]]++;
            dfs(r-1, c, step+1);
            visited[map[r-1][c]]--;
        }
        if(r+1<R && visited[map[r+1][c]]==0) {
            visited[map[r+1][c]]++;
            dfs(r+1, c, step+1);
            visited[map[r+1][c]]--;
        }
        if(0<=c-1 && visited[map[r][c-1]]==0) {
            visited[map[r][c-1]]++;
            dfs(r, c-1, step+1);
            visited[map[r][c-1]]--;
        }
        if(c+1<C && visited[map[r][c+1]]==0) {
            visited[map[r][c+1]]++;
            dfs(r, c+1, step+1);
            visited[map[r][c+1]]--;
        }
    }
}
