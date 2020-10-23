package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 7985. Rooted Binary Tree 재구성
public class S7985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int[] preNum = new int[(1<<k)-1];
            StringTokenizer input = new StringTokenizer(br.readLine());
            for(int i=0; i<preNum.length; i++) {
                preNum[i] = Integer.parseInt(input.nextToken());
            }
            answer = new StringBuilder[k];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = new StringBuilder();
            }
            process(preNum, k);
            System.out.printf("#%d ", t+1);
            for (int i = answer.length-1; i >-1 ; i--) {
                System.out.println(answer[i].toString().trim());
            }
        }
        br.close();
    }	// end of main
    static StringBuilder[] answer;
    public static void process(int[] arr, int level) {
        if(level==1) {
            answer[level-1].append(arr[0] + " ");
            return;
        }
        else {
            answer[level-1].append(arr[arr.length/2] + " ");
            process(Arrays.copyOfRange(arr, 0, arr.length/2), level-1);
            process(Arrays.copyOfRange(arr, arr.length/2+1, arr.length), level-1);
        }
    }
}
