package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 8931. 제로
public class S8931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                if(num==0) stack.pop();
                else stack.push(num);
            }
            int sum = 0;
            while(!stack.isEmpty()) sum+=stack.pop();
            answer.append('#').append(t).append(' ').append(sum).append('\n');
        }
        System.out.println(answer);
        br.close();
    }
}