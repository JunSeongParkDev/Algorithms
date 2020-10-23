package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백만 장자 프로젝트
public class S1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<int[]> maxInfo = new ArrayList<>(arr.length);
            for (int i = 0; i < arr.length; i++) maxInfo.add(new int[] {arr[i], i});
            maxInfo.sort((o1, o2) -> o2[0]-o1[0]);
            long profit = 0;
            int[] max = maxInfo.get(0);
            int j = 1;
            for (int i = 0; i < arr.length; i++) {
                while(arr[i]>max[0] || i>max[1]) {
                    max = maxInfo.get(j++);
                }
                profit += max[0]-arr[i];
            }
            answer.append('#').append(t).append(' ').append(profit).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

