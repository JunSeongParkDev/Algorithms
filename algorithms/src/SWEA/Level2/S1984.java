package SWEA.Level2;

import java.util.Arrays;
import java.util.Scanner;

// 중간 평균값 구하기
public class S1984 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0; t<T; t++) {
            int[] array = new int[10];
            for(int i=0; i<array.length; i++) {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            int sum = 0;
            for(int j=1; j<array.length-1; j++) {
                sum+=array[j];
            }
            System.out.printf("#%d %d\n", t+1, (int) Math.round(sum/8.0));
        }
        sc.close();
    }
}