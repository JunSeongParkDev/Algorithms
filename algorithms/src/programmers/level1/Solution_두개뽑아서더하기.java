package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_두개뽑아서더하기 {

	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		Solution_두개뽑아서더하기 s = new Solution_두개뽑아서더하기();
		System.out.println(Arrays.toString(s.solution(new int[] {2, 1, 3, 4, 1})));
		System.out.println(Arrays.toString(s.solution(new int[] {5, 0, 2, 7})));
	}
}
