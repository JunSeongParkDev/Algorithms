package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 5549. 홀수일까 짝수일까
public class S5549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            if((input.charAt(input.length()-1)-'0')%2==1) System.out.printf("#%d %s\n", t+1, "Odd");
            else System.out.printf("#%d %s\n", t+1, "Even");
        }

        br.close();
    }
}

