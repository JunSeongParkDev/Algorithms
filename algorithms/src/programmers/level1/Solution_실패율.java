package programmers.level1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] count = new int[N+2];
        for (int i = 0; i < stages.length; i++) count[stages[i]]++;
        List<Fail> list = new ArrayList<Fail>();
        
        int divide = count[N+1]==0?1:count[N+1];
        for (int i = N; i >= 1; i--) {
        	Fail fail = new Fail();
        	fail.stage = i;
        	if(count[i] == 0) fail.f = 0.0;
        	else {
        		divide += count[i];
        		fail.f = (double)count[i] / divide;
        	}
        	list.add(fail);
		}
        
        list.sort((o1, o2) -> o1.stage-o2.stage);
        list.sort((o1, o2) -> -Double.compare(o1.f, o2.f));
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).stage;
		}
        return answer;
    }
    
    private static class Fail {
    	int stage;
    	double f;
    }
    
    public static void main(String[] args) {
		Solution_실패율 s = new Solution_실패율();
		System.out.println(Arrays.toString(s.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(s.solution(4, new int[] {4, 4, 4, 4, 4})));
	}
}
