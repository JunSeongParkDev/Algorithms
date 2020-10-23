package SWEA.Level2;

import java.util.Arrays;
import java.util.Scanner;

// 스도쿠 검증
public class S1974 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++) {
            int answer = 1;
            int[][] map = new int[9][9];

            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            boolean[] isUsed = new boolean[10];
            outer : for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    Arrays.fill(isUsed, false);
                    for(int k=0; k<3; k++) {
                        for(int l=0; l<3; l++) {
                            if(isUsed[map[i*3+k][j*3+l]]) {
                                answer = 0;
                                break outer;
                            }
                            else  {
                                isUsed[map[i*3+k][j*3+l]] = true;
                            }
                        }
                    }
                }
            }
            outer :for(int i=0; i<9; i++) {
                for(int j=0; j<isUsed.length; j++) {
                    isUsed[j] =false;
                }
                for(int j=0; j<9; j++) {
                    if(isUsed[map[i][j]]) {
                        answer = 0;
                        break outer;
                    }
                    isUsed[map[i][j]] = true;
                }
                for(int j=0; j<isUsed.length; j++) {
                    isUsed[j] =false;
                }
                for(int j=0; j<9; j++) {
                    if(isUsed[map[j][i]]) {
                        answer = 0;
                        break outer;
                    }
                    isUsed[map[j][i]] = true;
                }
            }



            System.out.printf("#%d %d\n", t+1, answer);
        }

        sc.close();
    }	// end of main
}

