package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8338. 계산기
public class S8338 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                int sum = result+arr[i];
                int mul = result*arr[i];
                result = sum>mul?sum:mul;
            }
            answer.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

