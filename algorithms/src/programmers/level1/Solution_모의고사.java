package programmers.level1;

import java.util.Arrays;

public class Solution_모의고사 {
	
	private int[] solution(int[] answers) {
		
		int[][] students = {
			{1, 2, 3, 4 ,5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		
		int[] counts = new int[3];
		
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if(students[j][i%students[j].length] == answers[i])
					counts[j]++;
			}
		}
		
		int maxScore = Integer.MIN_VALUE;
		int size = 0;
		for (int i = 0; i < counts.length; i++) if(counts[i] > maxScore) maxScore = counts[i];
		for (int i = 0; i < counts.length; i++) if(counts[i] == maxScore) size++;
		int[] answer = new int[size];
		for (int i = counts.length-1; i >= 0; i--) if(counts[i] == maxScore) answer[--size] = i+1;
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_모의고사 s = new Solution_모의고사();
		System.out.println(Arrays.toString(s.solution(new int[] {1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(s.solution(new int[] {1, 3, 2, 4, 2})));
	}
}
