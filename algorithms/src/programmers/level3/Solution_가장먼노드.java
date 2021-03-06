package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[][] edges = new boolean[n+1][n+1];
        for (int i = 0; i < edge.length; i++) edges[edge[i][0]][edge[i][1]] = edges[edge[i][1]][edge[i][0]] = true;
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        dist[1] = 0;
        int maxDist = 0;
        
        while(!queue.isEmpty()) {
        	int[] now = queue.poll();
        	for (int i = 1; i < edges[now[0]].length; i++) {
				if(dist[i] == -1 && edges[now[0]][i]) {
					int step = now[1] + 1;
					queue.offer(new int[] {i, step});
					dist[i] = step;
					if(maxDist < step) maxDist = step;
				}
			}
        }
        
        for (int i = 0; i < dist.length; i++) if(dist[i] == maxDist) answer++;
        
        return answer;
    }
    
    public static void main(String[] args) {
		Solution_가장먼노드 s = new Solution_가장먼노드();
		System.out.println(s.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
	}
}
// [3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]