package programmers.level1;

public class Solution_문자열다루기기본 {
    public boolean solution(String s) {
    	if(s.length()==4 || s.length()==6) {
    		try {
    			Integer.parseInt(s);
    			return true;
    		} catch (NumberFormatException e) {
    			return false;
			}
    	}
    	else return false;
    }
}
