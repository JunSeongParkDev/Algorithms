package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 7일차 - 암호생성기
public class S1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc;
        while((tc = br.readLine())!=null) {
            int t = Integer.parseInt(tc);
            int[] input = new int[40000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            int sub = 1;
            int front = 0;
            int rear = 7;
            while(input[rear]>0) {
                if(sub>5) {
                    sub=1;
                }
                input[++rear] = input[front++] - sub++;
                if(input[rear]<0)
                    input[rear] = 0;
            }
            StringBuilder answer = new StringBuilder();
            for (int i = front; i < rear+1; i++) {
                answer.append(input[i] + " ");
            }

            System.out.printf("#%d %s\n", t, answer.toString().trim());

        }
        br.close();
    }
}