package programmers.level1;

public class Solution_자릿수더하기 {
    public int solution(int n) {
    	int answer = 0;
    	while(n!=0) {
    		answer += n%10;
    		n/=10;
    	}
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution_자릿수더하기 s = new Solution_자릿수더하기();
		System.out.println(s.solution(123));
		System.out.println(s.solution(987));
	}
}
