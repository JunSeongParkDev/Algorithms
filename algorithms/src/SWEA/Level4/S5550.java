package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 5550. 나는 개구리로소이다
public class S5550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            int result = 0;

            int[] cnt = new int[5];
            ex:			for (int i = 0; i < s.length(); i++) {
                switch(s.charAt(i)) {
                    case 'c':
                        if(cnt[4]>=1) {
                            cnt[4]--;
                            cnt[0]++;
                        } else {
                            cnt[0]++;
                        }
                        break;
                    case 'r':
                        if(cnt[0]>=1) {
                            cnt[0]--;
                            cnt[1]++;
                        } else {
                            result = -1;
                            break ex;
                        }
                        break;
                    case 'o':
                        if(cnt[1]>=1) {
                            cnt[1]--;
                            cnt[2]++;
                        } else {
                            result = -1;
                            break ex;
                        }
                        break;
                    case 'a':
                        if(cnt[2]>=1) {
                            cnt[2]--;
                            cnt[3]++;
                        } else {
                            result = -1;
                            break ex;
                        }
                        break;
                    case 'k':
                        if(cnt[3]>=1) {
                            cnt[3]--;
                            cnt[4]++;
                        } else {
                            result = -1;
                            break ex;
                        }
                        break;
                }
            }
            if(result != -1) {
                if(cnt[0]!=0 || cnt[1]!=0 || cnt[2]!=0 || cnt[3]!=0)
                    result = -1;
                else
                    result = cnt[4];
            }
            System.out.printf("#%d %d\n", t, result);
        }	// end of test case
        br.close();
    }	// end of main
}

