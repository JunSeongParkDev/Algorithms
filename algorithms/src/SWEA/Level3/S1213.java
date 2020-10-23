package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// [S/W 문제해결 기본] 3일차 - String
public class S1213 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int testCaseNum = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String sentence = br.readLine();
            int cnt = 0;
            int index = 0;
            while(sentence.indexOf(word, index)!=-1) {
                index = sentence.indexOf(word, index)+1;
                cnt++;
            }
            System.out.printf("#%d %d\n", testCaseNum, cnt);
        }	// end of test case

        br.close();
    }	// end of main
}
