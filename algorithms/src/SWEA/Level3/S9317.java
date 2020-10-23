package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 9317. 석찬이의 받아쓰기
public class S9317 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String first = br.readLine();
            String second = br.readLine();
            int count = 0;
            for (int i = 0; i < N; i++) {
                if(first.charAt(i) == second.charAt(i)) count++;
            }
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
