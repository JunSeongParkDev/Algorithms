package programmers.level1;

import java.util.Arrays;

public class Solution_문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
    	Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n)-o2.charAt(n));
        return strings;
    }
    
    public static void main(String[] args) {
		Solution_문자열내마음대로정렬하기 s = new Solution_문자열내마음대로정렬하기();
		System.out.println(Arrays.toString(s.solution(new String[] {"sun", "bed", "car"},  1)));
		System.out.println(Arrays.toString(s.solution(new String[] {"abce", "abcd", "cdx"}, 2)));
	}
}
