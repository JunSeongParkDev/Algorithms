package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6730. 장애물 경주 난이도
public class S6730 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int up = 0;
            int down = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer input = new StringTokenizer(br.readLine());
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(input.nextToken());
            }

            for (int i = 0; i < array.length-1; i++) {
                if(array[i]>array[i+1] && down<(array[i]-array[i+1]))
                    down = array[i] - array[i+1];
                if(array[i]<array[i+1] && up<array[i+1]-array[i])
                    up = array[i+1]-array[i];
            }
            System.out.printf("#%d %d %d\n", t+1, up, down);
        }

        br.close();
    }	// end of main
}

