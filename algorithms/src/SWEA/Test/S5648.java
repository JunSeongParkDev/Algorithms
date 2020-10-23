package SWEA.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5648. [모의 SW 역량테스트] 원자 소멸 시뮬레이션
public class S5648 {
    private static Atom[] atoms;
    private static int[][] map = new int[4001][4001];
    private static int sumOfEnergy;
    private static int N;
    private static Queue<Integer> collusionPoint = new LinkedList<>();
    private static StringBuilder answer = new StringBuilder();
    private static class Atom {
        int x;
        int y;
        int direction;
        int energy;

        public Atom(int x, int y, int direction, int energy) {
            super();
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.energy = energy;
        }

        @Override
        public String toString() {
            return "Atom [x=" + x + ", y=" + y + ", direction=" + direction + ", energy=" + energy + "]\n";
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(br);
            simulate();
            answer.append('#').append(t).append(' ').append(sumOfEnergy).append('\n');
        }
        System.out.print(answer.toString().trim());
        br.close();
    }
    private static void simulate() {
        while(N!=0) {
            for (int i = 1; i < atoms.length; i++) {
                if(atoms[i]!=null) {
                    Atom a = atoms[i];
                    switch(a.direction) {
                        case 0:	// 상
                            map[a.x][a.y] = 0;
                            a.x = a.x-1;
                            if(a.x<0) {
                                atoms[i] = null;
                                N--;
                                continue;
                            }
                            if(map[a.x][a.y]==0) map[a.x][a.y]=i;
                            else if(map[a.x][a.y]==-1) {
                                sumOfEnergy += a.energy;
                                atoms[i] = null;
                                N--;
                            } else {
                                sumOfEnergy += (atoms[map[a.x][a.y]].energy + a.energy);
                                atoms[map[a.x][a.y]] = null;
                                map[a.x][a.y] = -1;
                                collusionPoint.offer(a.x);
                                collusionPoint.offer(a.y);
                                atoms[i] = null;
                                N-=2;
                            }
                            break;
                        case 1:	// 하
                            map[a.x][a.y] = 0;
                            a.x = a.x+1;
                            if(a.x>4000) {
                                atoms[i] = null;
                                N--;
                                continue;
                            }
                            if(map[a.x][a.y]==0) map[a.x][a.y]=i;
                            else if(map[a.x][a.y]==-1) {
                                sumOfEnergy += a.energy;
                                atoms[i] = null;
                                N--;
                            } else {
                                sumOfEnergy += (atoms[map[a.x][a.y]].energy + a.energy);
                                atoms[map[a.x][a.y]] = null;
                                map[a.x][a.y] = -1;
                                collusionPoint.offer(a.x);
                                collusionPoint.offer(a.y);
                                atoms[i] = null;
                                N-=2;
                            }
                            break;
                        case 2:	// 좌
                            map[a.x][a.y] = 0;
                            a.y = a.y-1;
                            if(a.y<0) {
                                atoms[i] = null;
                                N--;
                                continue;
                            }
                            if(map[a.x][a.y]==0) map[a.x][a.y]=i;
                            else if(map[a.x][a.y]==-1) {
                                sumOfEnergy += a.energy;
                                atoms[i] = null;
                                N--;
                            } else {
                                sumOfEnergy += (atoms[map[a.x][a.y]].energy + a.energy);
                                atoms[map[a.x][a.y]] = null;
                                map[a.x][a.y] = -1;
                                collusionPoint.offer(a.x);
                                collusionPoint.offer(a.y);
                                atoms[i] = null;
                                N-=2;
                            }
                            break;
                        case 3:	// 우
                            map[a.x][a.y] = 0;
                            a.y = a.y+1;
                            if(a.y>4000) {
                                atoms[i] = null;
                                N--;
                                continue;
                            }
                            if(map[a.x][a.y]==0) map[a.x][a.y]=i;
                            else if(map[a.x][a.y]==-1) {
                                sumOfEnergy += a.energy;
                                atoms[i] = null;
                                N--;
                            } else {
                                sumOfEnergy += (atoms[map[a.x][a.y]].energy + a.energy);
                                atoms[map[a.x][a.y]] = null;
                                map[a.x][a.y] = -1;
                                collusionPoint.offer(a.x);
                                collusionPoint.offer(a.y);
                                atoms[i] = null;
                                N-=2;
                            }
                            break;
                    }
                }
            }
            while(!collusionPoint.isEmpty()) {
                map[collusionPoint.poll()][collusionPoint.poll()] = 0;
            }
        }
    }
    private static void init(BufferedReader br) throws Exception {
        N = Integer.parseInt(br.readLine());
        atoms = new Atom[N+1];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }

        sumOfEnergy = 0;
        StringTokenizer st;
        for (int i = 1; i < atoms.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int temp = x;
            x = 2000-y*2;
            y = 2000+temp*2;
            int dir = Integer.parseInt(st.nextToken());
            int energy = Integer.parseInt(st.nextToken());
            atoms[i] = new Atom(x, y, dir, energy);
            map[x][y] = i;
        }
    }
}
