package programmers.level1;

import java.util.Arrays;

public class Solution_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[][] students = new boolean[2][n+2];
        Arrays.fill(students[0], true);
        for (int i = 0; i < lost.length; i++) students[0][lost[i]] = false;
        for (int i = 0; i < reserve.length; i++) {
        	if(!students[0][reserve[i]]) {
        		students[0][reserve[i]] = true;
        		continue;
        	}
        	students[1][reserve[i]] = true;
        }
        
        for (int i = 1; i < students[0].length-1; i++) {
			if(!students[0][i]) {
				if(students[1][i-1]) {
					students[1][i-1] = false;
					students[0][i] = true;
				} else if(students[1][i+1]) {
					students[1][i+1] = false;
					students[0][i] = true;
				}
			}
			
			if(students[0][i]) answer++;
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution_체육복 s = new Solution_체육복();
		System.out.println(s.solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
		System.out.println(s.solution(5, new int[] {2, 4}, new int[] {3}));
		System.out.println(s.solution(3, new int[] {3}, new int[] {1}));
	}
}
