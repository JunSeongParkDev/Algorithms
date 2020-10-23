package SWEA.Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 간단한 압축 풀기
public class S1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringBuilder answer = new StringBuilder();
            int length = Integer.parseInt(br.readLine());
            String[] ch = new String[length];
            int[] cnt = new int[length];
            for(int i=0; i<length; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                ch[i] = input.nextToken();
                cnt[i] = Integer.parseInt(input.nextToken());
            }

            int temp = 0;
            for(int i=0; i<length; i++) {
                for(int j=0; j<cnt[i]; j++) {
                    answer.append(ch[i]);
                    if(answer.length()%10==temp) {
                        answer.append("\n");
                        temp++;
                        if(temp==10) {
                            temp = 0;
                        }
                    }
                }
            }

            System.out.printf("#%d\n", t+1);
            System.out.println(answer.toString());

        }

        br.close();
    }
}

