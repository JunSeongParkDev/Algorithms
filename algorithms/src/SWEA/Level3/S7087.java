package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7087. 문제 제목 붙이기
public class S7087 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            boolean[] alphabet = new boolean[26];
            int inputLength = Integer.parseInt(br.readLine());
            for (int i = 0; i < inputLength; i++) {
                alphabet[br.readLine().charAt(0)-'A'] = true;
            }
            int i=0;
            for (i = 0; i < alphabet.length; i++) {
                if(!alphabet[i]) break;
            }
            System.out.printf("#%d %d\n", t+1, i);
        }	// end of test case
        br.close();
    }	// end of main
}
