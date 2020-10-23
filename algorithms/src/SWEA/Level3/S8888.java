package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 8888. 시험
public class S8888 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int TC = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= TC; t++) {
            // 각 문제의 점수는 해당 문제를 풀지 못한 사람의 수
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int N = Integer.parseInt(st.nextToken());   // 참가자 수
            int T = Integer.parseInt(st.nextToken());   // 문제의 수
            int P = Integer.parseInt(st.nextToken())-1;   // 타겟 P의 점수와 등수 : answer

            int[][] result = new int[N][T];
            int[] point = new int[T];
            int[][] score = new int[N][3];
            Arrays.fill(point, N);
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                for (int j=0; j<T; j++) {
                    point[j] -= result[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<result.length; i++ ) {
                score[i][0] = i;
                for(int j=0; j<result[i].length; j++) {
                    if(result[i][j]==1) {
                        score[i][1] += 1;
                        score[i][2] += point[j];
                    }
                }
            }
            List<int[]> scoreList = new ArrayList<>(Arrays.asList(score));
            scoreList.sort((o1, o2) -> {
                return o2[1]-o1[1];
            });
            scoreList.sort((o1, o2) -> {
                return o2[2]-o1[2];
            });

            answer.append('#').append(t).append(' ');
            for (int i=0; i<scoreList.size(); i++) {
                if(scoreList.get(i)[0]==P) {
                    answer.append(scoreList.get(i)[2]).append(' ').append(i+1).append('\n');
                }
            }
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}

