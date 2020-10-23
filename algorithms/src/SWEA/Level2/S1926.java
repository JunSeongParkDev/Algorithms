package SWEA.Level2;

import java.util.Scanner;

// 간단한 369게임
public class S1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String answer = "";
        for (int i = 1; i < N+1; i++) {
            String str = String.valueOf(i);
            char[] temp;
            temp = str.toCharArray();
            int cnt = 0;
            for (int j = 0; j < temp.length; j++) {
                if(temp[j]=='3'||temp[j]=='6'||temp[j]=='9') cnt++;
            }
            if(cnt!=0) {
                str = "";
                for (int j = 0; j < cnt; j++) {
                    str += "-";
                }
            }
            answer += str + " ";
        }
        answer = answer.trim();
        System.out.println(answer);
        sc.close();
    }
}