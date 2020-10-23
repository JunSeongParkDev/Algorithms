package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 3750. Digit sum
public class S3750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int[] arr = new int[input.length()];
            for(int i=0; i<arr.length; i++) {
                arr[i] = input.charAt(i)-'0';
            }
            int sum = Integer.MAX_VALUE;
            while(sum>9) {
                sum = 0;
                for(int i=0; i<arr.length; i++) {
                    sum+=arr[i];
                }
                String sumString = String.valueOf(sum);
                arr = new int[sumString.length()];
                for(int i=0; i<arr.length; i++) {
                    arr[i] = sumString.charAt(i)-'0';
                }
            }

            System.out.printf("#%d %s\n", t+1, sum);
        }	// end of test case
        br.close();
    }	// end of main
}

