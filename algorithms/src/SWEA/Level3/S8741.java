package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 8741. 두문자어
public class S8741 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb;
        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            sb = new StringBuilder();
            sb.append(input.charAt(0));
            for (int i = 1; i < input.length(); i++) {
                if(input.charAt(i)==32) {
                    sb.append(input.charAt(i+1));
                }
            }
            answer.append('#').append(t).append(' ').append(sb.toString().toUpperCase()).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
