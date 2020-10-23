package SWEA.Level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 응용] 3일차 - 최적 경로
public class S1247 {

    private static int[] perm;
    private static int[][] clients;
    private static int[] home;
    private static int[] comp;
    private static boolean[] isUsed;
    private static int N;
    private static int minDistance;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            perm = new int[N];
            isUsed = new boolean[N];
            clients = new int[N][2];
            home = new int[2];
            comp = new int[2];
            minDistance = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

            comp[0] = Integer.parseInt(st.nextToken());
            comp[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < clients.length; i++) {
                clients[i][0] = Integer.parseInt(st.nextToken());
                clients[i][1] = Integer.parseInt(st.nextToken());
            }
            makePermutation(0);
            answer.append('#').append(t).append(' ').append(minDistance).append('\n');
        }
        System.out.println(answer.toString().trim());
        br.close();
    }

    private static void makePermutation(int index) {
        if(index==N) {
            int distance = 0;
            distance += Math.abs(comp[0]-clients[perm[0]][0]) + Math.abs(comp[1]-clients[perm[0]][1]);
            for (int i = 0; i < clients.length-1; i++) {
                distance += Math.abs(clients[perm[i]][0]-clients[perm[i+1]][0]) + Math.abs(clients[perm[i]][1] - clients[perm[i+1]][1]);
            }
            distance += Math.abs(home[0]-clients[perm[N-1]][0]) + Math.abs(home[1]-clients[perm[N-1]][1]);
            if(distance < minDistance) minDistance = distance;
        } else {
            for (int i = 0; i < perm.length; i++) {
                if(isUsed[i]) continue;
                isUsed[i] = true;
                perm[index] = i;
                makePermutation(index+1);
                isUsed[i] = false;
            }
        }
    }
}
