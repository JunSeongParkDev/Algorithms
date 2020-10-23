package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3501. 순환소수 짧게 표현하기
public class S3501 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] remainders = new int[Q];

            int quotient = P/Q;
            int remainder = P%Q;
            answer.append('#').append(t).append(' ');
            if(remainder==0) {
                answer.append(quotient).append('\n');
                continue;
            }
            answer.append(quotient).append('.');


            for (int i = answer.length(); remainder>0; i++) {
                if(remainders[remainder]!=0) {
                    answer.insert(remainders[remainder], '(');
                    answer.append(')');
                    break;
                }
                remainders[remainder] = i;
                remainder*=10;
                quotient = remainder/Q;
                remainder = remainder%Q;
                answer.append(quotient);
            }
            answer.append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}