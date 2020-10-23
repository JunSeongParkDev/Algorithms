package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3378. 스타일리쉬 들여쓰기
public class S3378 {
    private static int[][] m;
    private static int[][] dap;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());	// 마스터의 코드 줄 수
            int q = Integer.parseInt(st.nextToken());	// 내 코드 줄 수			1<= p, q <=10

            // master의 배열
            // [0].의 개수 [1]소괄호 개수 [2]중괄호 개수 [3]대괄호 개수
            m = new int[p][4];
            for (int i = 0; i < p; i++) {
                if(i>0) m[i] = m[i-1].clone();
                String line = br.readLine();
                int index=0;
                while(line.charAt(index)=='.') {
                    index++;
                }
                m[i][0] = index;	// 점의 개수 저장
                for (int j = index; j < line.length(); j++) {
                    switch(line.charAt(j)) {
                        case '(': m[i][1]++; break;
                        case ')': m[i][1]--; break;
                        case '{': m[i][2]++; break;
                        case '}': m[i][2]--; break;
                        case '[': m[i][3]++; break;
                        case ']': m[i][3]--; break;
                    }
                }
            }
            dap = new int[q][4];
            for (int i = 0; i < q; i++) {
                if(i>0) {
                    dap[i][1] = dap[i-1][1];
                    dap[i][2] = dap[i-1][2];
                    dap[i][3] = dap[i-1][3];
                }
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    switch(line.charAt(j)) {
                        case '(': dap[i][1]++; break;
                        case ')': dap[i][1]--; break;
                        case '{': dap[i][2]++; break;
                        case '}': dap[i][2]--; break;
                        case '[': dap[i][3]++; break;
                        case ']': dap[i][3]--; break;
                    }
                }
            }
            for (int i = 0; i < dap.length; i++) {
                dap[i][0] = -2;
            }
            for (int R = 1; R <= 20; R++) {
                for (int C = 1; C <= 20; C++) {
                    for (int S = 1; S <= 20; S++) {
                        if(check(R, C, S)) {	// 마스터 코드에서 답이 맞는지 체크
                            //	구한 RCS를 내 코드에 적용했을 때 각 줄의 답을 구한다.
                            cal(R, C, S);
                        }
                    }
                }
            }
            answer.append('#').append(t).append(" 0 ");
            for (int i = 1; i < dap.length; i++) {
                answer.append(dap[i][0]).append(' ');
            }
            answer.append('\n');
        }	// end of test case
        System.out.println(answer.toString().trim());
        br.close();
    }	// end of main
    private static void cal(int R, int C, int S) {
        for (int i = 1; i < dap.length; i++) {
            int x = dap[i-1][1] * R + dap[i-1][2] * C + dap[i-1][3] * S;
            if(dap[i][0]==-2) {
                dap[i][0] = x;
            } else if(dap[i][0] == -1) {

            } else if(dap[i][0] != x) {	// 이전엔 답을 구한적있지만 현재 계산결과와 다르면 해가 여러가지 있는것
                dap[i][0] = -1;	// 해가 한 개가 아니다
            }
        }
    }
    /**
     * 스타일 리쉬 코드에서 RCS값이 맞는지 체크
     */
    private static boolean check(int R, int C, int S) {
        for (int i = 1; i < m.length; i++) {
            if(m[i][0] != m[i-1][1]*R + m[i-1][2]*C + m[i-1][3]*S) {
                return false;
            }
        }
        return true;
    }
}