package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 4408. 자기 방으로 돌아가기
public class S4408 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            List<int[]> list = new ArrayList<int[]>(N);
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int depart = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                if(depart>dest) {
                    int temp = depart;
                    depart = dest;
                    dest = temp;
                }
                list.add(new int[] {depart, dest});
            }
            list.sort((o1, o2) -> {
                return o1[0]-o2[0];
            });
            int cnt = 0;
            while(list.size()!=0) {
                int std[] = list.get(0);
                for (int i = 0; i < std.length; i++) {
                    if(std[i]%2==1) std[i]++;
                }
                List<int[]> moveTogether = new ArrayList<int[]>();
                moveTogether.add(std);
                for(int i=1; i<list.size(); i++) {
                    int[] cmp = list.get(i);
                    if(cmp[0]>std[1]) {
                        moveTogether.add(cmp);
                        std[1] = cmp[1];
                    }
                }
                list.removeAll(moveTogether);
                cnt++;
            }
            answer.append(String.format("#%d %d\n", t, cnt));
        }	// end of test case
        System.out.print(answer.toString().trim());
        br.close();
    }	// end of main
}