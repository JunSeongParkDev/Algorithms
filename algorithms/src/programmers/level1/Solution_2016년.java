package programmers.level1;

import java.util.Calendar;

public class Solution_2016년 {
    public String solution(int a, int b) {
        Calendar c = Calendar.getInstance();
        c.set(2016, a-1, b);
        return c.getTime().toString().split(" ")[0].toUpperCase();
    }
	
    public static void main(String[] args) {
		Solution_2016년 s = new Solution_2016년();
		System.out.println(s.solution(5,  24));
	}
}
