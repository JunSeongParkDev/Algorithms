package programmers.level1;

import java.util.Arrays;

public class Solution_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[][] cMap1 = new char[n][n];
        char[][] cMap2 = new char[n][n];
        for (int i = 0; i < arr1.length; i++) {
			String bs = Integer.toBinaryString(arr1[i]);
			for (int j = bs.length()-1; j >= 0; j--) cMap1[i][j + n-bs.length()] = bs.charAt(j);

			bs = Integer.toBinaryString(arr2[i]);
			for (int j = bs.length()-1; j >= 0; j--) cMap2[i][j + n-bs.length()] = bs.charAt(j);
		}
        
        for (int i = 0; i < n; i++) {
        	StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if(cMap1[i][j] == '1' || cMap2[i][j] == '1') sb.append('#');
				else sb.append(' ');
			}
			answer[i] = sb.toString();
		}
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution_비밀지도 s = new Solution_비밀지도();
    	int[] arr1 = {9, 20, 28, 18, 11};
    	int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(s.solution(5, arr1, arr2)));
	}
}
