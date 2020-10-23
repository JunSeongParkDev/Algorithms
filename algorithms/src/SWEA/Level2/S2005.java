package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 파스칼의 삼각형
public class S2005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int layer = Integer.parseInt(br.readLine());
            System.out.printf("#%d\n", t+1);
            for(int i=0; i<layer; i++) {
                System.out.print(1 + " ");
                for(int j=0; j<i; j++) {
                    if(j==i-1) System.out.print(1);
                    else System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        br.close();
    }
}