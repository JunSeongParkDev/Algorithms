package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 5658. [모의 SW 역량테스트] 보물상자 비밀번호
public class S5658 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int wordLength = N/4;

            StringBuilder input = new StringBuilder(br.readLine());
            long[] nums = new long[N*(wordLength+1)];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    nums[i*wordLength+j] = Integer.parseInt(input.substring(wordLength*j, wordLength*(j+1)), 16);
                }
                input.insert(0, input.charAt(N-1)).deleteCharAt(N);
            }
            Arrays.sort(nums);
            Stack<Long> stack = new Stack<Long>();
            stack.push(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if(stack.peek()!=nums[i]) stack.push(nums[i]);
            }
            long num = -1;
            for (int i = 0; i < K; i++) {
                num = stack.pop();
            }
            answer.append('#').append(t).append(' ').append(num).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

