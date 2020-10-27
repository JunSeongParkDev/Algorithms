package programmers.level1;

public class Solution_이상한문자만들기 {
    public String solution(String s) {
    	char[] arr = s.toUpperCase().toCharArray();
    	
    	boolean isOdd = false;
    	for (int i = 0; i < arr.length; i++) {
    		if(arr[i] == ' ') {
    			isOdd = false;
    			continue;
    		}
			if(isOdd) arr[i] += 32;
			isOdd = !isOdd;
		}
    	
    	return String.valueOf(arr);
    }
    
    public static void main(String[] args) {
    	Solution_이상한문자만들기 s = new Solution_이상한문자만들기();
    	System.out.println(s.solution("try hello world"));
	}
}
