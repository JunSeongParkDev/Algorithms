package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4261. 빠른 휴대전화 키패드
public class S4261 {
    private static int N;
    private static String pressedNum;
    private static char[][] charForEachNumber= {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    private static String[] words;
    private static int count;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pressedNum = st.nextToken();
            N = Integer.parseInt(st.nextToken());
            words = new String[N];
            count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < words.length; i++) {
                words[i] = st.nextToken();
            }
            String word;
            outer:		for (int i = 0; i < words.length; i++) {
                word = words[i];
                if(word.length()!=pressedNum.length()) continue;
                int j=0;
                for (j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    int k = 0;
                    for (k = 0; k < charForEachNumber[pressedNum.charAt(j)-'0'].length; k++) {
                        if(charForEachNumber[pressedNum.charAt(j)-'0'][k]==c) break;
                    }
                    if(k==charForEachNumber[pressedNum.charAt(j)-'0'].length) continue outer;
                }
                if(j==word.length()) count++;
            }
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}