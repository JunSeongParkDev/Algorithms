package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) 
			if(arr[i] != arr[i-1]) list.add(arr[i]);
		
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
		Solution_같은숫자는싫어 s = new Solution_같은숫자는싫어();
		System.out.println(Arrays.toString(s.solution(new int[] {1, 1, 3, 3, 0, 1, 1})));
		System.out.println(Arrays.toString(s.solution(new int[] {4, 4, 4, 3, 3})));
	}
}
