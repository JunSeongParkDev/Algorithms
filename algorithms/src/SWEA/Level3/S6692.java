package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6692. 다솔이의 월급 상자
public class S6692 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            double[] probability = new double[N];
            int[] salary = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                probability[i] = Double.parseDouble(input.nextToken());
                salary[i] = Integer.parseInt(input.nextToken());
            }
            double answer = 0.0;
            for (int i = 0; i < N; i++) {
                answer+= probability[i]*salary[i];
            }
            System.out.printf("#%d %.6f\n", t+1, answer);
        }

        br.close();
    }	// end of main
}

