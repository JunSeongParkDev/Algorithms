package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4008. [모의 SW 역량테스트] 숫자 만들기
public class S4008 {
    private static int[] numbers;
    private static int[] operations = new int[4];
    private static int N;

    private static int minResult, maxResult;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            init(br);
            dfs(1, numbers[0]);
            answer.append('#').append(t).append(' ').append(maxResult-minResult).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void dfs(int step, int result) {
        if(step == N) {
            if(result>maxResult) maxResult = result;
            if(result<minResult) minResult = result;
            return;
        } else {
            for (int i = 0; i < operations.length; i++) {
                if(operations[i]>0) {
                    operations[i]--;
                    switch(i) {
                        case 0:
                            dfs(step+1, result+numbers[step]);
                            break;
                        case 1:
                            dfs(step+1, result-numbers[step]);
                            break;
                        case 2:
                            dfs(step+1, result*numbers[step]);
                            break;
                        case 3:
                            dfs(step+1, result/numbers[step]);
                            break;
                    }
                    operations[i]++;
                }
            }
        }
    }

    private static void init(BufferedReader br) throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < operations.length; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        minResult = Integer.MAX_VALUE;
        maxResult = Integer.MIN_VALUE;
    }
}
