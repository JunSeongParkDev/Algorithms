package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 3456. 직사각형 길이 찾기
public class S3456 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            Stack<Integer> s = new Stack<>();
            s.push(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                if(!s.isEmpty() && s.peek()==arr[i]) {
                    s.pop();
                    continue;
                }
                s.push(arr[i]);
            }
            System.out.printf("#%d %d\n", t+1, s.peek());
        }

        br.close();
    }	// end of main
}
