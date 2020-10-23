package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [Professional] 조합
public class S5607 {
    private static final long mod = 1234567891;
    private static long ans;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if(R > N/2) R = N - R;
            long x = 1, y = 1;
            for(int i = N; i > N - R; i--) {
                x *= i;
                if(x > mod) x %= mod;
            }
            for(int i = 2; i <= R; i++) {
                y *= i;
                if(y > mod) y %= mod;
            }
            y = pow(y, mod - 2);
            ans = (x * y) % mod;
            answer.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    static long pow(long base, long ex) {
        if (ex == 0) return 1;
        if (ex % 2 != 0) return (pow(base, ex - 1) * base) % mod;
        long half = pow(base, ex / 2) % mod;
        return (half * half) % mod;
    }
}