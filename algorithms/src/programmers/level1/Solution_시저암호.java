package programmers.level1;

public class Solution_시저암호 {
    public String solution(String s, int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(c >= 'a' && c <= 'z') sb.append((char) ((c+n)>'z'?(c+n)%'z'+'a'-1:(c+n)));
    		else if(c >= 'A' && c <= 'Z') sb.append((char) ((c+n)>'Z'?(c+n)%'Z'+'A'-1:(c+n)));
    		else sb.append(c);
		}
        return sb.toString();
    }
    
    public static void main(String[] args) {
		Solution_시저암호 s = new Solution_시저암호();
		System.out.println(s.solution("AB", 1));
		System.out.println(s.solution("z", 1));
		System.out.println(s.solution("a B z", 4));
	}
}
