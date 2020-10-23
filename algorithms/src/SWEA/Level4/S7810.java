package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 7810. 승현이의 질문
public class S7810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int standard = 0;
            int previous = 0;
            int save = 0;
            boolean flag = false;
            while(true) {
                standard++;
                flag = false;
                for (int i = previous; i < arr.length; i++) {
                    if(arr[i]>=standard) {
                        previous = i;
                        flag = true;
                        if(arr.length-i>=standard) save = standard;
                        break;
                    }
                }
                if(!flag) break;
            }
            answer.append('#').append(t).append(' ').append(save).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
