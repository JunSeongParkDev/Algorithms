package programmers.level1;

public class Solution_가운데글자가져오기 {

    public String solution(String s) {
    	String answer = s.length()%2==0?s.substring(s.length()/2-1, s.length()/2+1):s.substring(s.length()/2, s.length()/2+1);
        return answer;
    }
    
	public static void main(String[] args) {
		Solution_가운데글자가져오기 s = new Solution_가운데글자가져오기();
		System.out.println(s.solution("abcde"));
		System.out.println(s.solution("qwer"));
	}
}
