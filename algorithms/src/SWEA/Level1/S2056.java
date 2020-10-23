package SWEA.Level1;

import java.util.Scanner;

// 연월일 달력
public class S2056 {
    public static String[][] monthDay = {
            {"01", "31"}, {"02", "28"}, {"03", "31"}, {"04", "30"},
            {"05", "31"}, {"06", "30"}, {"07", "31"}, {"08", "31"},
            {"09", "30"}, {"10", "31"}, {"11", "30"}, {"12", "31"}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            StringBuilder answer = new StringBuilder();
            String input = sc.next();
            String year = input.substring(0, 4);
            String month = input.substring(4, 6);
            String day = input.substring(6, 8);

            if(Integer.parseInt(year) > 0) answer.append(year).append('/');
            if(Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13) answer.append(month).append('/');
            int i;
            for (i = 0; i < monthDay.length; i++) {
                if(month.contentEquals(monthDay[i][0])) break;
            }
            if(i < 12 && (Integer.parseInt(day) <= Integer.parseInt(monthDay[i][1])) && Integer.parseInt(day) > 0)
                answer.append(day);
            if(answer.length() != 10) {
                System.out.printf("#%d %d\n", t + 1, -1);
                continue;
            }

            System.out.printf("#%d %s\n", t + 1, answer);
        }	// end of test case
        sc.close();
    }	// end of main
}	// end of class
