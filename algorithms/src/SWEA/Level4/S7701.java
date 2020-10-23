package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

// 7701. 염라대왕의 이름 정렬
public class S7701 {
    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int c = o1.length()-o2.length();
                    if(c==0) return o1.compareTo(o2);
                    else return c;
                }
            });
            for (int i = 0; i < N; i++) {
                ts.add(br.readLine());
            }
            answer.append('#').append(t).append('\n');
            for (String s : ts) {
                answer.append(s).append('\n');
            }
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}