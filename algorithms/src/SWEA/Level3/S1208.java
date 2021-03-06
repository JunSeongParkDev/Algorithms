package SWEA.Level3;

import java.util.Arrays;
import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - Flatten
public class S1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t=1; t<11; t++) {
            int dump_cnt = sc.nextInt();
            int[] arr = new int[100];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            int target = 1;		// 평탄화 작업 후 최대 최소의 차이
            if(sum%arr.length==0) target = 0;
            Arrays.sort(arr);	// 오름차순 정렬

            for (int i = 0; i < dump_cnt && arr[99]-arr[0] > target; i++) {
                arr[99]--;	// 가장 높은 박스를 하나 제거
                arr[0]++;	// 가장 낮은 박스에 추가
                Arrays.sort(arr);
            }
            System.out.printf("#%d %d\n", t, arr[99]-arr[0]);
        }
        sc.close();
    }	// end of main
}	// end of class

