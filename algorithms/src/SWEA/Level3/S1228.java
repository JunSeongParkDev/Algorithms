package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1228. [S/W 문제해결 기본] 8일차 - 암호문1
public class S1228 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int originLength = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<originLength; i++) {
                list.offer(st.nextToken());
            }
            int orderLength = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] order = input.substring(1).split("I");
            for(int i=0; i<orderLength; i++) {
                String[] eachOrder = order[i].trim().split(" ");
                for(int j=Integer.parseInt(eachOrder[1]); j>0; j--) {
                    list.add(Integer.parseInt(eachOrder[0]), eachOrder[j+1]);
                }
            }
            StringBuilder answer = new StringBuilder();
            for(int i=0; i<10; i++) {
                answer.append(list.get(i) + " ");
            }
            System.out.printf("#%d %s\n", t+1, answer.toString().trim());
        }
        br.close();
    }	// end of main
}
