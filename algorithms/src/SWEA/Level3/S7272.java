package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7272. 안경이 없어!
public class S7272 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            if(input[0].length()!=input[1].length()) {
                System.out.printf("#%d %s\n", t+1, "DIFF");
                continue;
            }
            String[] same = {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B"};
            boolean flag = true;
            for(int i=0; i<input[1].length(); i++) {
                int first = Integer.MAX_VALUE;
                int second = Integer.MIN_VALUE;
                for(int j=0; j<same.length; j++) {
                    if(same[j].contains(String.valueOf(input[0].charAt(i)))) {
                        first = j;
                    }
                    if(same[j].contains(String.valueOf(input[1].charAt(i)))) {
                        second = j;
                    }
                }
                if(first!=second) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.printf("#%d %s\n", t+1, "SAME");
            else
                System.out.printf("#%d %s\n", t+1, "DIFF");
        }


        br.close();
    }	// end of main
}

