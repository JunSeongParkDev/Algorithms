package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8382. 방향 전환
public class S8382 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());

            int x = Math.abs(startX-destX);
            int y = Math.abs(startY-destY);

            int answer = 0;
            int move = x+y;
            if(move%2==0) {
                answer = (x>y?x:y)*2;
            } else {
                answer = (x>y?x:y)*2-1;
            }
            System.out.format("#%d %d\n", t, answer);
        }

        br.close();
    }
}
