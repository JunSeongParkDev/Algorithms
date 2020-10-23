package SWEA.Level1;

import java.util.Scanner;

// 간단한 N의 약수
public class S1933 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < num+1; i++) {
            if(num % i == 0) answer.append(i).append(' ');
        }
        System.out.println(answer.toString().trim());
        sc.close();
    }
}
