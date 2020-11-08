package programmers.level1;

public class Solution_콜라츠추측 {

    public int solution(int num) {
        int answer = 0;
        long temp = num;
        while(temp != 1 && answer < 500) {
        	if(temp % 2 == 0) temp /= 2;
        	else temp = temp * 3 + 1;
        	
        	answer++;
        }
        
        return answer>=500?-1:answer;
    }
	
	public static void main(String[] args) {
		Solution_콜라츠추측 s = new Solution_콜라츠추측();
		System.out.println(s.solution(6));
		System.out.println(s.solution(16));
		System.out.println(s.solution(626331));
	}
}
