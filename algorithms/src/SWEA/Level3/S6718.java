package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 6718. 희성이의 원근법
public class S6718 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int distance = Integer.parseInt(br.readLine());
            int[] perspective = {100, 1000, 10000, 100000, 1000000};
            int i=0;
            for (i = 0; i < perspective.length; i++) {
                if(distance<perspective[i]) break;
            }
            System.out.printf("#%d %d\n", t+1, i);
        }
        br.close();
    }	// end of main
}

