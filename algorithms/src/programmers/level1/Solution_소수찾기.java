package programmers.level1;

import java.util.Arrays;

public class Solution_소수찾기 {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < isPrime.length/2; i++) {
			for (int j = i*2; j < isPrime.length; j+=i) {
				isPrime[j] = false;
			}
		}
        for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) answer++;
		}
        return answer;
    }
    
    public static void main(String[] args) {
		Solution_소수찾기 s = new Solution_소수찾기();
		System.out.println(s.solution(10));
	}
}
