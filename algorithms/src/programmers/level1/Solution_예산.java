package programmers.level1;

import java.util.Arrays;

public class Solution_예산 {
	public int solution(int[] d, int budget) {
		int i = 0;
		Arrays.sort(d);
		int sum = 0;
		for (i = 0; i < d.length; i++) {
			sum += d[i];
			if (sum > budget) break;
		}
		return i;
	}
}
