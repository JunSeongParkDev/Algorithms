package programmers.level1;

public class Solution_다트게임 {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int gameSeq = 0;
        String number = "";
        for (int i = 0; i < dartResult.length(); i++) {
        	char c = dartResult.charAt(i);
        	switch(c) {
        	case 'S':
        		score[gameSeq++] = (int) Math.pow(Integer.parseInt(number), 1);
        		number = "";
        		break;
        	case 'D':
        		score[gameSeq++] = (int) Math.pow(Integer.parseInt(number), 2);
        		number = "";
        		break;
        	case 'T':
        		score[gameSeq++] = (int) Math.pow(Integer.parseInt(number), 3);
        		number = "";
        		break;
        	case '#':
        		score[gameSeq-1] *= -1;
        		break;
        	case '*':
        		score[gameSeq-1] *= 2;
        		if(gameSeq-2 >= 0) score[gameSeq-2] *= 2;
        		break;
        	default:
        		number += c;
        		break;
        	}
		}
        return score[0] + score[1] + score[2];
    }
    
    public static void main(String[] args) {
		Solution_다트게임 s = new Solution_다트게임();
		System.out.println(s.solution("1S2D*3T"));
		System.out.println(s.solution("1D2S#10S"));
		System.out.println(s.solution("1D2S0T"));
		System.out.println(s.solution("1S*2T*3S"));
		System.out.println(s.solution("1D#2S*3S"));
		System.out.println(s.solution("1T2D3D#"));
		System.out.println(s.solution("1D2S3T*"));
	}
}
