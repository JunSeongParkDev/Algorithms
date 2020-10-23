package SWEA.Level3;

// 3131. 100만 이하의 모든 소수
public class S3131 {
    public static void main(String[] args) {
        StringBuilder answer = new StringBuilder();
        boolean[] isNotPrime = new boolean[1000001];
        for (int i = 2; i < isNotPrime.length; i++) {
            if(!isNotPrime[i]) {
                for (int j = i*2; j < isNotPrime.length; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i = 2; i < isNotPrime.length; i++) {
            if(!isNotPrime[i]) answer.append(i).append(' ');
        }

        System.out.println(answer.toString().trim());
    }
}
