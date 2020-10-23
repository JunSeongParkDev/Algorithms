package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 4366. 정식이의 은행업무
public class S4366 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String sys2 = br.readLine();
            String sys3 = br.readLine();

            String temp;
            long result = -1;
            outer:		for (int i = 0; i < sys2.length(); i++) {
                int digit2 = sys2.charAt(i)-'0';
                temp = sys2.substring(0, i) + (1-digit2) + sys2.substring(i+1);
                long bNum = Long.parseLong(temp, 2);
                for (int j = 0; j < sys3.length(); j++) {
                    int digit3 = sys3.charAt(j)-'0';
                    for (int k = 0; k < 3; k++) {
                        if(digit3 == k) continue;
                        temp = sys3.substring(0, j) + k + sys3.substring(j+1);
                        long tNum = Long.parseLong(temp, 3);
                        if(bNum==tNum) {
                            result = bNum;
                            break outer;
                        }
                    }
                }
            }
            answer.append('#').append(t).append(' ').append(result).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
