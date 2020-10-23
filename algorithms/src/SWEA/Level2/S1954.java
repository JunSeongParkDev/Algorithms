package SWEA.Level2;

import java.util.Scanner;

// 달팽이 숫자
public class S1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] array = new int[N][N];

            int x = 0;
            int y = 0;
            int upDown = 1;
            int leftRight = 1;
            int limit = array.length;
            int check = 0;
            int num = 1;

            while(!(x==array.length/2&&y==array.length/2)) {
                if(check%2==0) {
                    for (int i = 0; i < limit; i++) {
                        array[x][y] = num++;
                        y+=leftRight;
                    }
                    x+=upDown;
                    y-=leftRight;
                    limit--;
                    leftRight*=-1;
                }
                else {
                    for (int i = 0; i < limit; i++) {
                        array[x][y] = num++;
                        x+=upDown;
                    }
                    y+=leftRight;
                    x-=upDown;
                    upDown*=-1;
                }
                check++;
            }
            if(N%2==0) {
                array[array.length/2][array.length/2] = num++;
                array[array.length/2][array.length/2-1] = num;
            }
            else {
                array[array.length/2][array.length/2] = num;
            }

            System.out.printf("#%d\n", t+1);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }	// end of main
}
