package SWEA.Level4;

import java.util.Scanner;

// 4796. 의석이의 우뚝 선 산
public class S4796 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            int cnt = 0;
            for (int i = 1; i < arr.length-1; i++) {
                if(arr[i-1]<arr[i] && arr[i+1]<arr[i]) {
                    int j=i-1, k=i+1;
                    for (; j-1>=0 && arr[j-1]<arr[j]; j--);
                    for (; k+1 < arr.length && arr[k+1]<arr[k]; k++);
                    cnt += (i-j)*(k-i);
                }
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        sc.close();
    }
}
