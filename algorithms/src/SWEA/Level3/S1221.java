package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 5일차 - GNS
public class S1221 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            br.readLine();
            StringTokenizer input = new StringTokenizer(br.readLine());
            StringBuilder[] answers = new StringBuilder[10];
            for (int i = 0; i < answers.length; i++) {
                answers[i] = new StringBuilder();
            }
            //"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
            while(input.hasMoreTokens()) {
                String temp = input.nextToken();
                switch(temp) {
                    case "ZRO":
                        answers[0].append(temp + " ");
                        break;
                    case "ONE":
                        answers[1].append(temp + " ");
                        break;
                    case "TWO":
                        answers[2].append(temp + " ");
                        break;
                    case "THR":
                        answers[3].append(temp + " ");
                        break;
                    case "FOR":
                        answers[4].append(temp + " ");
                        break;
                    case "FIV":
                        answers[5].append(temp + " ");
                        break;
                    case "SIX":
                        answers[6].append(temp + " ");
                        break;
                    case "SVN":
                        answers[7].append(temp + " ");
                        break;
                    case "EGT":
                        answers[8].append(temp + " ");
                        break;
                    case "NIN":
                        answers[9].append(temp + " ");
                        break;
                }
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < answers.length; i++) {
                answer.append(answers[i]);
            }
            System.out.printf("#%d %s\n", t+1, answer.toString().trim());
        }	// end of test case

        br.close();
    }	// end of main
}
