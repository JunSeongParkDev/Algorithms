package programmers.level1;

public class Solution_수박수박수박수박수 {
    public String solution(int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
			sb.append(i%2==0?"수":"박");
		}
        return sb.toString();
    }
}
