package programmers.level1;

public class Solution_평균구하기 {
    public double solution(int[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        return sum/arr.length;
    }
}
