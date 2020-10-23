package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8568. 3으로 나눈 순열
public class S8568 {
    private static int[] arr;
    private static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken())%3;
            }
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]!=i%3) {
                    int swapIndex = -1;
                    for (int j = i+1; j < arr.length; j++) {
                        if(arr[j]==i%3 && arr[i]==j%3) {
                            swapIndex = j;
                            break;
                        }
                    }
                    if(swapIndex!=-1) {
                        swap(i, swapIndex);
                        cnt++;
                    } else {
                        for (int j = i+1; j < arr.length; j++) {
                            if(arr[j]==i%3 && j%3!=i%3) {
                                swapIndex = j;
                                break;
                            }
                        }
                        swap(i, swapIndex);
                        cnt++;
                    }
                }
            }
            answer.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
