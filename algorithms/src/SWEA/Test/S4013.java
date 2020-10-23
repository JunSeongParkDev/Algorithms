package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4013. [모의 SW 역량테스트] 특이한 자석
public class S4013 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[][] operations = new int[K][2];
            int[][] magnets = new int[6][8];
            for (int i = 0; i < magnets[0].length; i++) {
                magnets[0][i] = -1;
                magnets[5][i] = -1;
            }

            StringTokenizer st;
            for (int i = 1; i < magnets.length - 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < magnets[i].length; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < operations.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < operations[i].length; j++) {
                    operations[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < operations.length; i++) {
                int toggle = operations[i][1]; // 시계1, 반시계-1
                for (int j = operations[i][0]; j < magnets.length-1; j++) {
                    if (toggle == 1) {
                        int temp = magnets[j][7];
                        for (int k = magnets[j].length-1; k > 0; k--) {
                            magnets[j][k] = magnets[j][k-1];
                        } magnets[j][0] = temp;
                        if (magnets[j][3] == magnets[j+1][6]) break;
                        toggle = -1;
                    } else {
                        int temp = magnets[j][0];
                        for (int k = 0; k < magnets[j].length-1; k++) {
                            magnets[j][k] = magnets[j][k+1];
                        } magnets[j][7] = temp;
                        if (magnets[j][1] == magnets[j+1][6]) break;
                        toggle = 1;
                    }
                }

                if(operations[i][1]==1 && magnets[operations[i][0]][7]==magnets[operations[i][0]-1][2]) continue;
                if(operations[i][1]==-1 && magnets[operations[i][0]][5]==magnets[operations[i][0]-1][2]) continue;

                toggle = operations[i][1]==1?-1:1;
                for (int j = operations[i][0]-1; j > 0; j--) {
                    if (toggle == 1) {
                        int temp = magnets[j][7];
                        for (int k = magnets[j].length-1; k > 0; k--) {
                            magnets[j][k] = magnets[j][k-1];
                        } magnets[j][0] = temp;
                        if (magnets[j][7] == magnets[j-1][2]) break;
                        toggle = -1;
                    } else {
                        int temp = magnets[j][0];
                        for (int k = 0; k < magnets[j].length-1; k++) {
                            magnets[j][k] = magnets[j][k+1];
                        } magnets[j][7] = temp;
                        if (magnets[j][5] == magnets[j-1][2]) break;
                        toggle = 1;
                    }
                }
            }
            int point = 0;
            for (int i = 1; i < magnets.length-1; i++) {
                point += (1<<(i-1))*magnets[i][0];
            }
            answer.append('#').append(t).append(' ').append(point).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

