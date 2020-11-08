package programmers.level1;

public class Solution_x만큼간격이있는n개의숫자 {
	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		for (int i = 0; i < answer.length; i++)
			answer[i] = (long) x * (i + 1);
		return answer;
	}
}
