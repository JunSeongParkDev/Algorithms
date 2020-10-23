package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1234. [S/W 문제해결 기본] 10일차 - 비밀번호
public class S1234 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            String str = input.nextToken();
            int[] stack = new int[N];
            int top = -1;
            stack[++top] = str.charAt(0)-'0';
            for (int i = 1; i < str.length(); i++) {
                if(top==-1 || stack[top]!=str.charAt(i)-'0') {
                    stack[++top] = str.charAt(i)-'0';
                }
                else {
                    top--;
                }
            }
            StringBuilder answer = new StringBuilder();
            while(top!=-1) {
                answer.append(stack[top--]);
            }
            System.out.printf("#%d %s\n", t+1, answer.reverse().toString().trim());
        }
        br.close();
    }	// end of main
}
