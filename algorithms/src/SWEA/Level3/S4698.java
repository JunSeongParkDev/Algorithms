package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4698. 테네스의 특별한 소수
public class S4698 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < isNotPrime.length; i++) {
            if(!isNotPrime[i]) {
                for (int j = i*2; j < isNotPrime.length; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            String targetNum = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = start; i <= end; i++) {
                if(!isNotPrime[i]) {
                    String temp = String.valueOf(i);
                    if(temp.contains(targetNum)) {
                        cnt++;
                    }
                }
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }	// end of test case
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
}
