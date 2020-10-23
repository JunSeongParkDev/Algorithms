package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 4672. 수진이의 팰린드롬
public class S4672 {
    private static int[] alphabets = new int[26];
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            for (int i = 0; i < alphabets.length; i++) {
                alphabets[i] = 0;
            }
            for (int i = 0; i < input.length(); i++) {
                alphabets[input.charAt(i)-'a']++;
            }
            int cnt = 0;
            for (int i = 0; i < alphabets.length; i++) {
                for (int j = 0; j <= alphabets[i]; j++) {
                    cnt+=j;
                }
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
