package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 8821. 적고 지우기
public class S8821 {
    private static StringBuilder answer = new StringBuilder();
    private static boolean[] count = new boolean[10];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < count.length; i++) {
                count[i] = false;
            }
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                int num = input.charAt(i)-'0';
                count[num] = !count[num];
            }
            int cnt = 0;
            for (int i = 0; i < count.length; i++) {
                if(count[i]) cnt++;
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}