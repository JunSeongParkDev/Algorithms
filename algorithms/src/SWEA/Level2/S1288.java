package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 새로운 불면증 치료법
public class S1288 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            boolean[] isUsed = new boolean[10];
            int startNumber = Integer.parseInt(br.readLine());
            boolean flag = true;
            int answer = 0;
            int nextNumber = startNumber;
            while(flag) {
                nextNumber = startNumber*(answer+1);
                String[] strings = String.valueOf(nextNumber).split("");
                for (String s : strings) {
                    isUsed[Integer.parseInt(s)] = true;
                }
                int i=0;
                for(i=0; i<isUsed.length; i++) {
                    if(!isUsed[i]) break;
                }
                if(i==isUsed.length) {
                    flag = false;
                }
                answer++;
            }
            System.out.printf("#%d %d\n", t+1, nextNumber);
        }
        br.close();
    }
}
