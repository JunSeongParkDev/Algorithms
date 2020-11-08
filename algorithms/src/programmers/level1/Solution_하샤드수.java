package programmers.level1;

public class Solution_하샤드수 {
    public boolean solution(int x) {
    	int num = x, sum = 0;
    	while(num != 0) {
    		sum += num % 10;
    		num /= 10;
    	}
    	return x % sum == 0;
    }
}
