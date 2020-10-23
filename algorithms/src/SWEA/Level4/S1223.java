package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1223. [S/W 문제해결 기본] 6일차 - 계산기2
public class S1223 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=0; t<10; t++) {
            int length = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split("");

            int[] stack = new int[length];
            int top = -1;
            stack[++top] = Integer.parseInt(input[0]);
            for (int i = 1; i < input.length; i+=2) {
                char op = input[i].charAt(0);
                int num = Integer.parseInt(input[i+1]);
                if(op == '+') {
                    stack[++top] = num;
                }
                else {
                    int pre = stack[top--];
                    stack[++top] = pre*num;
                }
            }
            int result = 0;
            for (int i = 0; i < top+1; i++) {
                result += stack[i];
            }
            System.out.printf("#%d %d\n", t+1, result);
        }	// end of test case
        br.close();
    }	// end of main
}

