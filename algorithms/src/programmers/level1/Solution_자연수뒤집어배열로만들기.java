package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
    	List<Integer> list = new ArrayList<Integer>();
    	while(n!=0) {
    		list.add((int)(n%10));
    		n/=10;
    	}
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
    	Solution_자연수뒤집어배열로만들기 s = new Solution_자연수뒤집어배열로만들기();
		System.out.println(Arrays.toString(s.solution(10000000000L)));
		System.out.println(Arrays.toString(s.solution(12345)));
	}
}
