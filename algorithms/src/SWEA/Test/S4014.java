package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4014. [모의 SW 역량테스트] 활주로 건설
public class S4014 {
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            boolean[][] isConstructed = new boolean[N][N];
            int[][] map = new int[N][N];
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                boolean isConstructable = true;
                for (int j = 0; j < N-1; j++) {
                    int gap = map[i][j]-map[i][j+1];
                    int temp = 0;
                    int length = 0;
                    if(gap==-1) {
                        temp = j;
                        while(temp>=0 && map[i][temp]==map[i][j] && !isConstructed[i][temp] && length<X) {
                            isConstructed[i][temp] = true;
                            temp--;
                            length++;
                        }
                        if(length<X) {
                            isConstructable = false;
                            break;
                        }
                    } else if(gap==1) {
                        temp = j+1;
                        while(temp<N && map[i][temp]==map[i][j+1] && !isConstructed[i][temp] && length<X) {
                            isConstructed[i][temp] = true;
                            temp++;
                            length++;
                        }
                        if(length<X) {
                            isConstructable = false;
                            break;
                        }
                    } else if(gap==0) {
                        continue;
                    } else {
                        isConstructable = false;
                        break;
                    }
                }
                if(isConstructable) count++;
            }
            for (int i = 0; i < isConstructed.length; i++) {
                for (int j = 0; j < isConstructed[i].length; j++) {
                    isConstructed[i][j]=false;
                }
            }
            for (int j = 0; j < N; j++) {
                boolean isConstructable = true;
                for (int i = 0; i < N-1; i++) {
                    int gap = map[i][j]-map[i+1][j];
                    int temp = 0;
                    int length = 0;
                    if(gap==-1) {
                        temp = i;
                        while(temp>=0 && map[temp][j]==map[i][j] && !isConstructed[temp][j] && length<X) {
                            isConstructed[temp][j] = true;
                            temp--;
                            length++;
                        }
                        if(length<X) {
                            isConstructable = false;
                            break;
                        }
                    } else if(gap==1) {
                        temp = i+1;
                        while(temp<N && map[temp][j]==map[i+1][j] && !isConstructed[temp][j] && length<X) {
                            isConstructed[temp][j] = true;
                            temp++;
                            length++;
                        }
                        if(length<X) {
                            isConstructable = false;
                            break;
                        }
                    } else if(gap==0) {
                        continue;
                    } else {
                        isConstructable = false;
                        break;
                    }
                }
                if(isConstructable) count++;
            }
            answer.append('#').append(t).append(' ').append(count).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
}
