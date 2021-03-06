package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Solution_섬연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<int[]> edges = new ArrayList<>(costs.length);
        for (int i = 0; i < costs.length; i++) edges.add(costs[i]);
        edges.sort((o1, o2)-> o1[2]-o2[2]);
        
        int[] parent = makeSet(n);
        int edgeCnt = 0;
        int i = 0;
        while(edgeCnt < n-1) {
        	int[] edge = edges.get(i++);
        	if(union(edge[0], edge[1], parent)) {
        		edgeCnt++;
        		answer += edge[2];
        	}
        }
        
        return answer;
    }
    
    private int[] makeSet(int n) {
    	int[] parent = new int[n];
    	for (int i = 0; i < parent.length; i++) parent[i] = i;
    	
    	return parent;
    }
    
    private int findSet(int x, int[] parent) {
    	if(parent[x] == x) return parent[x];
    	else return parent[x] = findSet(parent[x], parent);
    }
    
    private boolean union(int x, int y, int[] parent) {
    	int px = findSet(x, parent);
    	int py = findSet(y, parent);
    	if(px != py) parent[py] = parent[px];
    	
    	return px!=py;
    }
    
    
    public static void main(String[] args) {
    	Solution_섬연결하기 s = new Solution_섬연결하기();
		System.out.println(s.solution(4, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
	}
}
