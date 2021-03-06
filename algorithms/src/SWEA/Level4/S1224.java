package SWEA.Level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1224. [S/W 문제해결 기본] 6일차 - 계산기3
public class S1224 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            Integer.parseInt(br.readLine());
            String input = br.readLine();
            System.out.printf("#%d %d\n", t+1, calcPostFix(makePostFix(input)));
        }	// end of for
        br.close();
    }	// end of main
    public static String makePostFix(String input) {
        String[] arr = input.split("");
        char[] stack = new char[arr.length];
        StringBuilder sb = new StringBuilder();

        int top = -1;
        stack[++top] = arr[0].charAt(0);

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            switch(c) {
                case '(':
                    stack[++top] = c;
                    break;
                case '*':
                case '/':
                    while(top>-1 && ((stack[top]=='*')||(stack[top]=='/'))) {
                        sb.append(stack[top--] + " ");
                    }
                    stack[++top] = c;
                    break;
                case '+':
                case '-':
                    while(top>-1 && (stack[top]!='(')) {
                        sb.append(stack[top--] + " ");
                    }
                    stack[++top] = c;
                    break;
                case ')':
                    while(top>-1 && (stack[top]!='(')) {
                        sb.append(stack[top--] + " ");
                    }
                    if(stack[top] == '(') {
                        top--;
                    }
                    break;
                default :
                    sb.append(c + " ");
                    break;
            }
        }
        while(top>-1) {
            if(stack[top--] == '(')
                continue;
            sb.append(stack[top--]);
        }

        return sb.toString().trim();
    }
    public static int calcPostFix(String input) {
        String[] arr = input.split(" ");
        int[] stack = new int[arr.length];
        int top = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            int num1 = 0, num2 = 0;
            switch(c) {
                case '+':
                    num2 = stack[top--];
                    num1 = stack[top--];
                    stack[++top] = num1 + num2;
                    break;
                case '-':
                    num2 = stack[top--];
                    num1 = stack[top--];
                    stack[++top] = num1 - num2;
                    break;
                case '*':
                    num2 = stack[top--];
                    num1 = stack[top--];
                    stack[++top] = num1 * num2;
                    break;
                case '/':
                    num2 = stack[top--];
                    num1 = stack[top--];
                    stack[++top] = num1 / num2;
                    break;
                default:
                    stack[++top] = Integer.parseInt(arr[i]);
                    break;
            }
        }
        return stack[top];
    }
}	// end of class

