package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3752. 가능한 시험 점수
public class S3752 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int[] point = new int[N];
            int maxPoint = 1;
            for (int i = 0; i < point.length; i++)
                maxPoint += point[i] = Integer.parseInt(st.nextToken());
            boolean[] possibleScore = new boolean[maxPoint];
            possibleScore[0] = true;
            for (int i = 0; i < point.length; i++) {
                for (int j = possibleScore.length-1; j >=0; j--) {
                    if(possibleScore[j]) possibleScore[j+point[i]] = true;
                }
            }
            int count = 0;
            for (int i = 0; i < possibleScore.length; i++) if(possibleScore[i]) count++;
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}