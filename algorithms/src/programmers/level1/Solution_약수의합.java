package programmers.level1;

public class Solution_약수의합 {
    public int solution(int n) {
    	int answer = 0;
    	for (int i = 1; i <= Math.sqrt(n); i++) 
    		if(n%i == 0) {
    			if(i!=n/i) answer += (i + n/i);
    			else answer+=i;
    		}
    	
    	return answer;
    }
    
    public static void main(String[] args) {
		Solution_약수의합 s = new Solution_약수의합();
		System.out.println(s.solution(12));
		System.out.println(s.solution(5));
	}
}
