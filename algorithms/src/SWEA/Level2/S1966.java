package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자를 정렬하자
public class S1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int length = Integer.parseInt(br.readLine());
            int[] arr = new int[length];
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(input.nextToken());
            }
            Arrays.sort(arr);
            System.out.printf("#%d %s\n", t+1, Arrays.toString(arr).substring(1, Arrays.toString(arr).length()-1).replaceAll(",", ""));
        }
        br.close();
    }
}
