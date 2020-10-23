package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3431. 준환이의 운동관리
public class S3431 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if(X>=U) System.out.printf("#%d %d\n", t+1, -1);
            else if(X>=L) System.out.printf("#%d %d\n", t+1, 0);
            else System.out.printf("#%d %d\n", t+1, L-X);
        }

        br.close();
    }
}

