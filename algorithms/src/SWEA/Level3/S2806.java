package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2806. N-Queen
public class S2806 {
    private static int N;
    private static int[] selected;
    private static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            selected = new int[N];
            count = 0;
            countNQueen(0);
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.println(answer.toString().trim());
        br.close();
    }

    private static void countNQueen(int index) {
        if(index == N) count++;
        else {
            for (int i = 0; i < N; i++) {
                selected[index] = i;
                if(isPossible(index)) countNQueen(index+1);
            }
        }
    }

    private static boolean isPossible(int index) {
        for (int i = 0; i < index; i++) {
            if(selected[i] == selected[index] || Math.abs(index-i) == Math.abs(selected[index] - selected[i]))
                return false;
        }
        return true;
    }

}
