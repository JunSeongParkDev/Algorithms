package programmers.level1;

public class Solution_정수제곱근판별 {
    public long solution(long n) {
    	int sqrt = (int)Math.sqrt(n);
    	if(((long)sqrt * (long)sqrt) - n == 0) 
    		return (long)(sqrt+1) * (long) (sqrt+1);
    	else return -1;
    }
}
