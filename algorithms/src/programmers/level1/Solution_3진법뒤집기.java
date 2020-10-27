package programmers.level1;

public class Solution_3진법뒤집기 {
    public int solution(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
    }
    
    public static void main(String[] args) {
		Solution_3진법뒤집기 s = new Solution_3진법뒤집기();
		System.out.println(s.solution(45));
		System.out.println(s.solution(125));
	}
}
