package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3143. 가장 빠른 문자열 타이핑
public class S3143 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String origin = st.nextToken();
            String sc = st.nextToken();
            int cnt = 0;

            while(origin.contains(sc)) {
                origin = origin.replaceFirst(sc, "");
                cnt++;
            }
            answer.append('#').append(t).append(' ').append(cnt+origin.length()).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}