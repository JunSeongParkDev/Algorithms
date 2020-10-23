package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5789. 현주의 상자 바꾸기
public class S5789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int[] boxes = new int[N];
            int[][] task = new int[Q][2];
            for (int i = 0; i < task.length; i++) {
                st = new StringTokenizer(br.readLine());
                task[i][0] = Integer.parseInt(st.nextToken());
                task[i][1] = Integer.parseInt(st.nextToken());
                for (int j = task[i][0]; j <task[i][1]+1; j++) {
                    boxes[j-1] = i+1;
                }
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < boxes.length; i++) {
                answer.append(boxes[i] + " ");
            }
            System.out.printf("#%d %s\n", t+1, answer.toString().trim());
        }

        br.close();
    }
}

