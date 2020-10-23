package SWEA.Level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 현주가 좋아하는 제곱근 놀이
public class S6782 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long num = Long.parseLong(br.readLine());
            long operationCnt = 0;
            while(num!=2) {
                if(Math.sqrt(num)-(int)Math.sqrt(num)!=0) {
                    long increasedNum = (long) Math.pow(((long) Math.sqrt(num)+1), 2);
                    operationCnt += increasedNum - num;
                    num = (long) Math.sqrt(increasedNum);
                } else {
                    num = (long) Math.sqrt(num);
                }
                operationCnt++;
            }
            answer.append('#').append(t).append(' ').append(operationCnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
