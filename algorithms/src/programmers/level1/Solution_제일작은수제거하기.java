package programmers.level1;

public class Solution_제일작은수제거하기 {
    public int[] solution(int[] arr) {
    	int minIndex = 0;
    	int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
			if(arr[i] < minValue) {
				minValue = arr[i];
				minIndex = i;
			}
		}
        int[] answer = new int[arr.length-1];
        if(answer.length==0) return new int[] {-1};
        else {
        	for (int i = 0; i < arr.length; i++) {
				if(i==minIndex) continue;
				answer[i>minIndex?i-1:i] = arr[i];
			}
        }
        return answer;
    }
}
