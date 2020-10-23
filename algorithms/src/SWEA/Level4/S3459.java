package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 3459. 승자 예측하기
public class S3459 {
    private static StringBuilder answer = new StringBuilder();
    private static String[] winner = { "Alice\n", "Bob\n" };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long input = Long.parseLong(br.readLine());
            long x = 1;
            if (input == 1) {
                answer.append('#').append(t).append(' ').append(winner[1]);
                continue;
            }
            long i = 4;
            while (x < input) {
                x += i;
                if (input <= x) {
                    answer.append('#').append(t).append(' ').append(winner[0]);
                    break;
                }
                x += i;
                if (input <= x) {
                    answer.append('#').append(t).append(' ').append(winner[1]);
                    break;
                }
                i <<= 2;
            }
        }
        System.out.print(answer);
        br.close();
    }
}

