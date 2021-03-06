package programmers.level1;

import java.util.Arrays;

public class Solution_문자열내림차순으로배치하기 {
	public String solution(String s) {
		char[] sorted = s.toCharArray();
		Arrays.sort(sorted);
		return new StringBuilder(new String(sorted)).reverse().toString();
	}

	public static void main(String[] args) {
		Solution_문자열내림차순으로배치하기 s = new Solution_문자열내림차순으로배치하기();
		System.out.println(s.solution("Zbcdefg"));
	}
}
