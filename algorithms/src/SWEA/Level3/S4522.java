package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 4522. 세상의 모든 팰린드롬
public class S4522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            boolean answer = true;
            for (int i = 0; i < input.length()/2; i++) {
                if(input.charAt(i)=='?') continue;
                if(input.charAt(input.length()-1-i)=='?') continue;
                if(input.charAt(i)!=input.charAt(input.length()-1-i)) {
                    answer = false;
                    break;
                }
            }
            System.out.printf("#%d %s\n", t+1, answer?"Exist":"Not exist");
        }	// end of test case
        br.close();
    }	// end of main
}
