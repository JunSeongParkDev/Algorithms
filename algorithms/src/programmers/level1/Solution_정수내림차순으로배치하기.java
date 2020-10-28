package programmers.level1;

import java.util.Arrays;

public class Solution_정수내림차순으로배치하기 {
    public long solution(long n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length/2; i++) {
			char temp = arr[arr.length-1-i];
			arr[arr.length-1-i] = arr[i];
			arr[i] = temp;
		}
    	
    	
    	return Long.parseLong(String.valueOf(arr));
    }
	
    public static void main(String[] args) {
		Solution_정수내림차순으로배치하기 s = new Solution_정수내림차순으로배치하기();
		System.out.println(s.solution(118372));
	}
}
