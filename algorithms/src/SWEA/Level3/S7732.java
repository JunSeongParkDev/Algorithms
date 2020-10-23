package SWEA.Level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 7732. 시간 개념
public class S7732 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] cTime = br.readLine().split(":");
            String[] mTime = br.readLine().split(":");
            int cSec = Integer.parseInt(cTime[0])*3600 + Integer.parseInt(cTime[1])*60 + Integer.parseInt(cTime[2]);
            int mSec = Integer.parseInt(mTime[0])*3600 + Integer.parseInt(mTime[1])*60 + Integer.parseInt(mTime[2]);
            int oneDay = 3600*24;
            int remain = 0;
            if(cSec>mSec) {	// 약속시간이 더 클 때는 내일
                remain = oneDay - cSec + mSec;
            }
            else {
                remain = mSec-cSec;
            }
            String hour = String.valueOf(remain/3600);
            if(hour.length()==1) hour = "0" + hour;
            remain%=3600;
            String min = String.valueOf(remain/60);
            if(min.length()==1) min = "0" + min;
            remain%=60;
            String sec = String.valueOf(remain);
            if(sec.length()==1) sec = "0" + sec;

            System.out.printf("#%d %s\n", t+1, String.format("%s:%s:%s", hour, min, sec));
        }	// end of test case
        br.close();
    }	// end of main
}
