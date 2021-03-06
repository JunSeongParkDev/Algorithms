package programmers.level1;

import java.util.HashMap;

public class Solution_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
    	int i;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String name : completion) hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        for (i = 0; i < participant.length; i++) {
        	String name = participant[i];
        	if(hashMap.get(participant[i]) == null) break;
        	else {
        		if(hashMap.get(name) > 0) {
        			hashMap.put(name, hashMap.get(name) - 1);
        		} else break;
        	}
        }
        
        return participant[i];
    }
    
	public static void main(String[] args) {
		Solution_완주하지못한선수 s = new Solution_완주하지못한선수();
		System.out.println(s.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
		System.out.println(s.solution(new String[] {"leo", "kiki", "eden", "leo"}, new String[] {"eden", "kiki", "leo"}));
	}
}
