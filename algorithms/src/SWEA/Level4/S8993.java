package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 8993. 하지 추측
public class S8993 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            long N = Long.parseLong((br.readLine().trim()));
            N = N==1?N*3:N;
            answer.append('#').append(t).append(' ');
            while(N>1) {
                if(N%2==1) {
                    answer.append("NO\n");
                    break;
                }
                N/=2;
            }
            if(N==1) answer.append("YES\n");
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

