package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 5432. 쇠막대기 자르기
public class S5432 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int answer = 0;
            String input = br.readLine();
            input = input.replace("()", "1");
            char[] stack = new char[input.length()];
            int[] pieces = new int[input.length()];
            int top = -1;
            for(int i=0; i<input.length(); i++) {
                if(input.charAt(i)=='(') {
                    stack[++top] = input.charAt(i);
                }
                else if(input.charAt(i)==')') {
                    answer+=pieces[top]+1;
                    pieces[top] = 0;
                    top--;
                }
                else {
                    for(int j=0; j<top+1; j++) {
                        pieces[j]++;
                    }
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }
        br.close();
    }
}
