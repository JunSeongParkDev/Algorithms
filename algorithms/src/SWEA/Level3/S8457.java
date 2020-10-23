package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8457. 알 덴테 스파게티
public class S8457 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int[] list = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < list.length; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
//			System.out.println(Arrays.toString(list));
            int answer = 0;
            for (int i = 0; i < list.length; i++) {
                int cnt = 1;
                while(true) {
                    if(list[i]*cnt<=B+E && list[i]*cnt>=B-E) {
                        answer++;
                        break;
                    }
                    if(list[i]*cnt>B+E) break;
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n", t, answer);
        }	// end of test case

        br.close();
    }	// end of main
}

