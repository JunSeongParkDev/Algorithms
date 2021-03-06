package programmers.level1;

public class Solution_두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b) return a;
        
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for (int i = min; i <= max; i++) {
			answer += i;
		}
        
        return answer;
    }
	
    public static void main(String[] args) {
    	Solution_두정수사이의합 s = new Solution_두정수사이의합();
		System.out.println(s.solution(3, 5));
		System.out.println(s.solution(3, 3));
		System.out.println(s.solution(5, 3));
	}
}
