package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
public class S1240 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] codes = {
                "0001101",
                "0011001",
                "0010011",
                "0111101",
                "0100011",
                "0110001",
                "0101111",
                "0111011",
                "0110111",
                "0001011"
        };
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Integer.parseInt(st.nextToken());
            String[] input = new String[N];

            int codeHere = 0;
            for (int i = 0; i < input.length; i++) {
                input[i] = br.readLine();
                if(input[i].contains("1")) codeHere = i;
            }
            int[] processed = new int[8];
            for(int i=0; i<processed.length; i++) {
                processed[i] = Integer.MIN_VALUE;
            }
            int answerTop = 0;
            int codeStart = 0;
            boolean flag = false;
            for (int i = 0; i < input[codeHere].length()-7; i++) {
                int j = 0;
                for (j = 0; j < codes.length; j++) {
                    if(input[codeHere].substring(i, i+7).equals(codes[j])) {
                        codeStart = i;
                        flag = true;
                        processed[answerTop++] = j;
                        i+=6;
                        break;
                    }
                }
                if(j==codes.length&&flag) {
                    i = codeStart;
                    answerTop = 0;
                    flag = false;
                }
            }
            if(((processed[0]+processed[2]+processed[4]+processed[6])*3 + processed[1]+processed[3]+processed[5]+processed[7])%10==0) {
                int answer = 0;
                for (int i = 0; i < processed.length; i++) {
                    answer+=processed[i];
                }
                System.out.printf("#%d %d\n", t+1, answer);
            }
            else {
                System.out.printf("#%d 0\n", t+1);
            }
        }	// end of test case
        br.close();
    }	// end of main
}