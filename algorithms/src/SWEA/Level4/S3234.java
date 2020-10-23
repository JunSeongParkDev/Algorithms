package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3234. 준환이의 양팔저울
public class S3234 {
    private static int[] weight;
    private static int count;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            weight = new int[N];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < weight.length; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            makePermutation(N, 0);
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void makePermutation(int n, int k) {
        if(n==k) {
            dfs(weight[0], 0, 1);
        } else {
            for (int i = k; i < n; i++) {
                swap(i, k);
                makePermutation(n, k+1);
                swap(i, k);
            }
        }
    }

    private static void dfs(int left, int right, int step) {
        if(step==weight.length) {
            count++;
            return;
        }
        if(right+weight[step]<=left) dfs(left, right+weight[step], step+1);
        dfs(left+weight[step], right, step+1);
    }

    private static void swap(int index1, int index2) {
        int temp = weight[index1];
        weight[index1] = weight[index2];
        weight[index2] = temp;
    }
}
