package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 7792. 반장 선출
public class S7792 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] name = new String[N];
            boolean[] isUsed = new boolean['Z'+1];
            int[] variety = new int[N];
            for (int i = 0; i < name.length; i++) {
                name[i] = br.readLine();
            }
            Arrays.sort(name);
//			System.out.println(Arrays.toString(name));
            for (int i = 0; i < name.length; i++) {
                for (int j = 0; j < isUsed.length; j++) {
                    isUsed[j] = false;
                }
                for (int j = 0; j < name[i].length(); j++) {
                    if(!isUsed[name[i].charAt(j)]) {
                        if(name[i].charAt(j)==' ') continue;
                        isUsed[name[i].charAt(j)] = true;
                        variety[i]++;
                    }
                }
            }
//			System.out.println(Arrays.toString(name));
//			System.out.println(Arrays.toString(variety));
            int vMaxIndex = 0;
            int vMax = variety[vMaxIndex];
            for (int i = 1; i < variety.length; i++) {
                if(vMax<variety[i]) {
                    vMax = variety[i];
                    vMaxIndex = i;
                }
            }
            System.out.printf("#%d %s\n", t+1, name[vMaxIndex]);
        }	// end of test case

        br.close();
    }	// end of main
}
