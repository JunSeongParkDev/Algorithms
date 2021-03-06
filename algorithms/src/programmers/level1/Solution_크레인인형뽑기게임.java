package programmers.level1;

public class Solution_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] topIndex = new int[board[0].length];
        for (int i = 0; i < topIndex.length; i++) {
			int index = 0;
			while(board[index][i] == 0 && index < board.length) {
				index++;
			}
			topIndex[i] = index;
		}
        
        int top = -1;
        int[] stack = new int[moves.length+1];
        stack[++top] = board[topIndex[moves[0]-1]++][moves[0]-1];
        
        for (int i = 1; i < moves.length; i++) {
        	int y = moves[i] - 1;
        	int x = topIndex[y];
        	if(x == board.length) continue;
        	
        	if(top > -1 && stack[top] == board[x][y]) {
        		top--;
        		answer += 2;
        	} else {
        		stack[++top] = board[x][y];
        	}
    		topIndex[y]++;
    		
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
		Solution_크레인인형뽑기게임 s = new Solution_크레인인형뽑기게임();
		int[][] board = {{0, 0, 0, 0, 0},{0, 0, 1, 0, 3},{0, 2, 5, 0, 1},
				{4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(s.solution(board, moves));
	}
}
