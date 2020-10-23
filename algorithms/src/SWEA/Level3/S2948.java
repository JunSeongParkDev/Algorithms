package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2948. 문자열 교집합
public class S2948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            int M = Integer.parseInt(input.nextToken());
            String[] first = new String[N];
            String[] second = new String[M];
            input = new StringTokenizer(br.readLine());
            for (int i = 0; i < first.length; i++) {
                first[i] = input.nextToken();
            }
            input = new StringTokenizer(br.readLine());
            for (int i = 0; i < second.length; i++) {
                second[i] = input.nextToken();
            }
            Arrays.sort(first);
            Arrays.sort(second);
            int answer = 0;
            int i = 0;
            int j = 0;
            while(i<N && j<M) {
                if(first[i].compareTo(second[j])==0) {
                    answer++;
                    i++;
                    j++;
                }
                else if(first[i].compareTo(second[j])>0) {
                    j++;
                }
                else {
                    i++;
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }
        br.close();
    }	// end of main
}