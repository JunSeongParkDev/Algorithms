package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// [S/W 문제해결 기본] 3일차 - 회문1
public class S1215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            char[][] map = new char[8][8];
            for (int i = 0; i < map.length; i++) {
                String input = br.readLine().trim();
                for (int j = 0; j < map[i].length; j++) map[i][j] = input.charAt(j);
            }
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    int index;
                    boolean flag;
                    if(j+N-1<map[i].length) {
                        index = j;
                        flag = true;
                        for (int k = 0; k < N/2; k++)
                            if(map[i][index+k] != map[i][index+N-1-k]) flag = false;
                        if (flag) count++;
                    }
                    if(i+N-1<map.length) {
                        index = i;
                        flag = true;
                        for (int k = 0; k < N/2; k++) if(map[index+k][j] != map[index+N-1-k][j]) flag = false;
                        if (flag) count++;
                    }
                }
            }
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
