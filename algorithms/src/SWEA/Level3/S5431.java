package SWEA.Level3;

import java.util.Scanner;

// 5431. 민석이의 과제 체크하기
public class S5431 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int[] allStudent = new int[N];
            int[] submitted = new int[S];
            for (int j = 0; j < submitted.length; j++) {
                submitted[j] = sc.nextInt();
            }
            for (int j = 1; j < N+1; j++) {
                allStudent[j-1] = j;
            }
            String answer = "";
            for(int j=0; j<allStudent.length; j++) {
                boolean flag = false;
                for(int k=0; k<submitted.length; k++) {
                    if(allStudent[j]==submitted[k]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) answer+=String.valueOf(j+1 + " ");
            }
            System.out.printf("#%d %s\n", t+1, answer.trim());
        }
        sc.close();
    }
}

