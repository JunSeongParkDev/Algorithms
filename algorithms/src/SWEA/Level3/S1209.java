package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 2일차 - Sum
public class S1209 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] array = new int[100][100];
            for (int i = 0; i < array.length; i++) {
                StringTokenizer singleLineInput = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = Integer.parseInt(singleLineInput.nextToken());
                }
            }
            int[] sumArray = new int[202];

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sumArray[i] += array[i][j];
                    sumArray[100+i] += array[j][i];
                }
                sumArray[200] += array[i][i];
                sumArray[201] += array[i][99-i];
            }

            int answer = sumArray[0];
            for (int i = 1; i < sumArray.length; i++) {
                if(sumArray[i]>answer) answer = sumArray[i];
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
        br.close();
    }	// end of main
}
