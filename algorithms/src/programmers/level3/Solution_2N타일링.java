package programmers.level3;

public class Solution_2N타일링 {
    public int solution(int n) {        
        int[] fibonacci = new int[n+1];
        fibonacci[0] = fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
        	fibonacci[i] = (fibonacci[i-2] + fibonacci[i-1])%1000000007;
        }
        
        return fibonacci[n];
    }
    
    public static void main(String[] args) {
    	Solution_2N타일링 s = new Solution_2N타일링();
    	System.out.println(s.solution(4));
	}
}
