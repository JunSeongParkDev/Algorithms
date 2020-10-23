package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Greedy 빠르다. 매우 위험
 * 완탐 : 시간이 많이 걸림(반드시 답을 찾을 수 있다.)
 * Back tracking 해야한다. 가지치기를 해서 반드시 답을 찾지만, 시간을 절약한다.
 */

// 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
public class S1244 {
    public static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int[] num = new int[s.length()];
            for (int i = 0; i < num.length; i++) {
                num[i] = s.charAt(i)-'0';
            }
            int N = Integer.parseInt(st.nextToken());
            max = 0;
            find(num, N);
            System.out.printf("#%d %d\n", t+1, max);
        }	// end of test case
        br.close();
    }	// end of main
    /**
     * @param num : 숫자 배열
     * @param N : 교환 횟수
     */
    public static HashSet<String> hs = new HashSet<String>();
    public static void find(int[] num, int N) {
        // 숫자 6자리 999999로 할 수 있고, HashSet을 쓸 수 있다.
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            result += num[i]*Math.pow(10, num.length-1-i);
        }
        String str = "" + result + N;
        if(hs.contains(str)) {
            return;
        }
        else {
            hs.add(str);
        }
        if(N==0) {	// 종료 파트, 최대값이 되었는지 확인
            if(result>max) max = result;
        } else {	// 교환을 1번 할 수 있는 모든 경우를 만들어서 재귀 호출
            for (int i = 0; i < num.length; i++) {
                for (int j = i+1; j < num.length; j++) {
                    // i <--> j swap
                    swap(num, i, j);
                    // 재귀 호출
                    find(num, N-1);
                    // 원상 복구
                    swap(num, i, j);
                }
            }
        }
    }
    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
