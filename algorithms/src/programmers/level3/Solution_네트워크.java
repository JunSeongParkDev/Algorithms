package programmers.level3;

public class Solution_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
        	if(!isVisited[i]) {
        		answer++;
        		dfs(i, computers, isVisited);
        	}
		}
        
        return answer;
    }
    
    private void dfs(int index, int[][] computers, boolean[] isVisited) {
    	for (int i = 0; i < computers.length; i++) {
			if(i==index) continue;
			if(!isVisited[i] && computers[index][i] == 1) {
				isVisited[i] = true;
				dfs(i, computers, isVisited);
			}
		}
	}
    
	public static void main(String[] args) {
		Solution_네트워크 s = new Solution_네트워크();
		System.out.println(s.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(s.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
}
