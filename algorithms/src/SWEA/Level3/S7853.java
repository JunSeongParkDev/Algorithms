package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7853. 오타
public class S7853 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] input = br.readLine().toCharArray();
            int[] multiple = new int[input.length];
            for (int i = 1; i < multiple.length-1; i++) {
                multiple[i]++;
                if(input[i-1]!=input[i]) multiple[i]++;
                if(input[i+1]!=input[i]) multiple[i]++;
                if(input[i-1]==input[i+1]) multiple[i]--;
                if(multiple[i]==0) multiple[i]++;
            }
            multiple[0]++;
            multiple[input.length-1]++;
            if(input[0]!=input[1]) multiple[0]++;
            if(input[input.length-1]!=input[input.length-2]) multiple[input.length-1]++;
            long words = 1;
            for (int i = 0; i < multiple.length; i++) {
                words *= multiple[i];
                words %= 1000000007;
            }
            answer.append('#').append(t).append(' ').append(words).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
