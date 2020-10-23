package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1231. [S/W 문제해결 기본] 9일차 - 중위순회
public class S1231 {
    public static String[] input;
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            N = Integer.parseInt(br.readLine()) + 1;
            input = new String[N];
            for (int i = 0; i < N-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                input[Integer.parseInt(st.nextToken())] = st.nextToken();
            }
            answer = new StringBuilder();
            System.out.printf("#%d ", t+1);
            inOrder(1);
            System.out.println(answer.toString().trim());
        }
        br.close();
    }	// end of main
    public static StringBuilder answer;
    public static void inOrder(int index) {
        if((index*2) < N) inOrder(index*2);
        answer.append(input[index]);
        if((index*2)+1 < N) inOrder((index*2)+1);
    }
}

