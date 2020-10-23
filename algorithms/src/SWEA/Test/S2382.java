package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2382. [모의 SW 역량테스트] 미생물 격리
public class S2382 {
    private static int[][] map;
    private static Microorganism[] mArray;
    private static int M;	// 시간
    private static int N;
    private static int K;	// 초기 미생물 수
    private static StringBuilder answer = new StringBuilder();
    private static List<Microorganism> cHistory;
    private static class Microorganism {
        int x;
        int y;
        int amount;
        int direction;
        public Microorganism(int x, int y, int amount, int direction) {
            this.x = x;
            this.y = y;
            this.amount = amount;
            this.direction = direction;
        }
        @Override
        public String toString() {
            return "Microorganism [x=" + x + ", y=" + y + ", amount="
                    + amount + ", direction=" + direction + "]\n";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            init(br);
            for (int i = 0; i < M; i++) {
                move();
            }
            int sum = 0;
            for (int i = 0; i < mArray.length; i++) {
                if(mArray[i]!=null) sum+=mArray[i].amount;
            }
            answer.append('#').append(t).append(' ').append(sum).append('\n');
//			System.out.println(Arrays.toString(mArray));
        }
        System.out.print(answer.toString().trim());
        br.close();
    }

    private static void move() {
        for (int i = 1; i < mArray.length; i++) {
            if(mArray[i]!=null) {
                switch(mArray[i].direction) {
                    case 1:
                        mArray[i].x = mArray[i].x-1;
                        if(mArray[i].x==0) {
                            mArray[i].amount/=2;
                            mArray[i].direction=2;
                        }
                        if(map[mArray[i].x][mArray[i].y]!=0) {
                            int originAmount = mArray[map[mArray[i].x][mArray[i].y]].amount;
                            for (int j = 0; j < cHistory.size(); j++) {
                                Microorganism m = cHistory.get(j);
                                if(m.x==mArray[i].x && m.y==mArray[i].y) {
                                    originAmount-=m.amount;
                                }
                            }

                            if(originAmount<mArray[i].amount) {
                                cHistory.add(mArray[map[mArray[i].x][mArray[i].y]]);
                                mArray[i].amount += mArray[map[mArray[i].x][mArray[i].y]].amount;
                                mArray[map[mArray[i].x][mArray[i].y]] = null;
                                map[mArray[i].x][mArray[i].y] = i;
                            } else {
                                cHistory.add(mArray[i]);
                                mArray[map[mArray[i].x][mArray[i].y]].amount += mArray[i].amount;
//							map[mArray[i].x-1][mArray[i].y] = 0;
                                mArray[i] = null;
                            }
                        } else {
                            map[mArray[i].x][mArray[i].y] = i;
                        }
                        break;
                    case 2:
                        mArray[i].x = mArray[i].x+1;
                        if(mArray[i].x==N-1) {
                            mArray[i].amount/=2;
                            mArray[i].direction=1;
                        }
                        if(map[mArray[i].x][mArray[i].y]!=0) {
                            int originAmount = mArray[map[mArray[i].x][mArray[i].y]].amount;
                            for (int j = 0; j < cHistory.size(); j++) {
                                Microorganism m = cHistory.get(j);
                                if(m.x==mArray[i].x && m.y==mArray[i].y) {
                                    originAmount-=m.amount;
                                }
                            }

                            if(originAmount<mArray[i].amount) {
                                mArray[i].amount += mArray[map[mArray[i].x][mArray[i].y]].amount;
                                cHistory.add(mArray[map[mArray[i].x][mArray[i].y]]);
                                mArray[map[mArray[i].x][mArray[i].y]] = null;
                                map[mArray[i].x][mArray[i].y] = i;
                            } else {
                                mArray[map[mArray[i].x][mArray[i].y]].amount += mArray[i].amount;
//							map[mArray[i].x+1][mArray[i].y] = 0;
                                cHistory.add(mArray[i]);
                                mArray[i] = null;
                            }
                        } else {
                            map[mArray[i].x][mArray[i].y] = i;
                        }
                        break;
                    case 3:
                        mArray[i].y = mArray[i].y-1;
                        if(mArray[i].y==0) {
                            mArray[i].amount/=2;
                            mArray[i].direction=4;
                        }
                        if(map[mArray[i].x][mArray[i].y]!=0) {
                            int originAmount = mArray[map[mArray[i].x][mArray[i].y]].amount;
                            for (int j = 0; j < cHistory.size(); j++) {
                                Microorganism m = cHistory.get(j);
                                if(m.x==mArray[i].x && m.y==mArray[i].y) {
                                    originAmount-=m.amount;
                                }
                            }

                            if(originAmount<mArray[i].amount) {
                                mArray[i].amount += mArray[map[mArray[i].x][mArray[i].y]].amount;
                                cHistory.add(mArray[map[mArray[i].x][mArray[i].y]]);
                                mArray[map[mArray[i].x][mArray[i].y]] = null;
                                map[mArray[i].x][mArray[i].y] = i;
                            } else {
                                mArray[map[mArray[i].x][mArray[i].y]].amount += mArray[i].amount;
//							map[mArray[i].x][mArray[i].y-1] = 0;
                                cHistory.add(mArray[i]);
                                mArray[i] = null;
                            }
                        } else {
                            map[mArray[i].x][mArray[i].y] = i;
                        }
                        break;
                    case 4:
                        mArray[i].y = mArray[i].y+1;
                        if(mArray[i].y==N-1) {
                            mArray[i].amount/=2;
                            mArray[i].direction=3;
                        }
                        if(map[mArray[i].x][mArray[i].y]!=0) {
                            int originAmount = mArray[map[mArray[i].x][mArray[i].y]].amount;
                            for (int j = 0; j < cHistory.size(); j++) {
                                Microorganism m = cHistory.get(j);
                                if(m.x==mArray[i].x && m.y==mArray[i].y) {
                                    originAmount-=m.amount;
                                }
                            }

                            if(originAmount<mArray[i].amount) {
                                mArray[i].amount += mArray[map[mArray[i].x][mArray[i].y]].amount;
                                cHistory.add(mArray[map[mArray[i].x][mArray[i].y]]);
                                mArray[map[mArray[i].x][mArray[i].y]] = null;
                                map[mArray[i].x][mArray[i].y] = i;
                            } else {
                                mArray[map[mArray[i].x][mArray[i].y]].amount += mArray[i].amount;
                                cHistory.add(mArray[i]);
//							map[mArray[i].x][mArray[i].y+1] = 0;
                                mArray[i] = null;
                            }
                        } else {
                            map[mArray[i].x][mArray[i].y] = i;
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
        cHistory.clear();
    }
    public static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 1 : 상, 2 : 하, 3 : 좌, 4 : 우
        map = new int[N][N];
        mArray = new Microorganism[K+1];
        cHistory = new ArrayList<Microorganism>();
        for (int i = 1; i < mArray.length; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            mArray[i] = new Microorganism(x, y, amount, direction);
        }
//		System.out.println(Arrays.toString(mArray));
    }
}
