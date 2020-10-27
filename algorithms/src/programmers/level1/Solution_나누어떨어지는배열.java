package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_나누어떨어지는배열 {

    public int[] solution(int[] arr, int divisor) {
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < arr.length; i++)
			if(arr[i] % divisor == 0) list.add(arr[i]);
    	if(list.size()==0) list.add(-1);
        return list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    public static void main(String[] args) {
		Solution_나누어떨어지는배열 s = new Solution_나누어떨어지는배열();
		System.out.println(Arrays.toString(s.solution(new int[] {5, 9, 7, 10}, 5)));
		System.out.println(Arrays.toString(s.solution(new int[] {3, 2, 6}, 10)));
	}
}
