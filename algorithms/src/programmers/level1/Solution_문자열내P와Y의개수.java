package programmers.level1;

public class Solution_문자열내P와Y의개수 {
    boolean solution(String s) {
        s = s.toUpperCase();
        int pcnt = 0;
        int ycnt = 0;
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='P') pcnt++;
			if(s.charAt(i)=='Y') ycnt++;
		}
        return pcnt==ycnt;
    }
    
    public static void main(String[] args) {
		Solution_문자열내P와Y의개수 s = new Solution_문자열내P와Y의개수();
		System.out.println(s.solution("ppoooyy"));
		System.out.println(s.solution("pyy"));
	}
}
