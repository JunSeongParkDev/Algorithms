package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3499. 퍼펙트 셔플
public class S3499 {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int length = Integer.parseInt(br.readLine());
            String[] input = new String[length];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<length; i++) input[i] = st.nextToken();
            StringBuilder answer = new StringBuilder();
            int oddEven = length%2==1? 1 : 0;
            for(int i=0; i<length/2; i++) {
                answer.append(input[i] + " ");
                answer.append(input[(length/2)+i+oddEven] + " ");
            }
            System.out.printf("#%d %s\n", t+1, oddEven==1?answer.append(input[length/2]).toString():answer.toString().trim());
        }
        br.close();
        System.out.println(System.currentTimeMillis()-startTime);
    }
}