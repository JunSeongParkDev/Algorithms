package programmers.level1;

import java.util.Arrays;

public class Solution_최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        return new int[] {getGCD(n, m), getLCM(n, m)};
    }
    
    private int getGCD(int n, int m) {
    	int a = Math.max(n, m);
    	int b = Math.min(n, m);
    	while(b != 0) {
    		int temp = a%b;
    		a = b;
    		b = temp;
    	}
    	return a;
    }
    
    private int getLCM(int n, int m) {
    	return n * m / getGCD(n, m);
    }
    
    public static void main(String[] args) {
    	Solution_최대공약수와최소공배수 s = new Solution_최대공약수와최소공배수();
		System.out.println(Arrays.toString(s.solution(3, 12)));
		System.out.println(Arrays.toString(s.solution(7, 7)));
		System.out.println(Arrays.toString(s.solution(2, 5)));
	}
}
