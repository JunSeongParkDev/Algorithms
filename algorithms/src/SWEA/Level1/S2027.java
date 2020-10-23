package SWEA.Level1;

// 대각선 출력하기
public class S2027 {
    public static void main(String[] args) {
        int point = 0;
        for(int i = 0; i < 25; i++) {
            if(i % 5 == point) System.out.print("#");
            else System.out.print("+");
            if(i % 5 == 4) {
                System.out.println();
                point++;
            }
        }
    }
}