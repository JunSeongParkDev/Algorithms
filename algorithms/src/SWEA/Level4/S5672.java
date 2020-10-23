package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 5672. [Professional] 올해의 조련사
public class S5672 {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            char[] origin = new char[N];
            for (int i = 0; i < origin.length; i++) {
                origin[i] = br.readLine().trim().charAt(0);
            }
            char[] updated = new char[N];
            int first = 0;
            int last = origin.length - 1;
            boolean flag = true;
            for (int i = 0; i < updated.length; i++) {
                if (origin[first] != origin[last]) {
                    updated[i] = origin[first] < origin[last] ? origin[first++] : origin[last--];
                } else {
                    int searchIndexFirst = first;
                    int searchIndexLast = last;
                    while (flag && origin[searchIndexFirst] == origin[searchIndexLast]) {
                        searchIndexFirst++;
                        searchIndexLast--;
                        if(searchIndexFirst>N-1 || searchIndexLast<0 || searchIndexFirst>=searchIndexLast) {
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) updated[i] = origin[first++];
                    else updated[i] = origin[searchIndexFirst] < origin[searchIndexLast] ? origin[first++] : origin[last--];
                }
            }
            answer.append('#').append(t).append(' ').append(updated).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

