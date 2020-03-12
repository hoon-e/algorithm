package basic;

import java.util.Scanner;
import java.util.Stack;

// 식 평가 문제
// 2 1 + 3 * -> ((2+1)*3) -> 9
// 4 13 5 / + -> (4 + (13/5)) -> 6
public class ReversePolishNotation {

    public static int evalExp(String[] tokens){
        int returnValue = 0;
        // 연산자 저장
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){ // 포함하고 있다면
                stack.push(t);
            }else{
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a)); // b가 큰지, a가 큰지 확인
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        if( a == 0 )
                            throw new ArithmeticException("Cannot Divide By Zero");
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        returnValue = Integer.parseInt(stack.pop());
        return returnValue;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] word = scn.nextLine().split(" ");

        System.out.println(evalExp(word));
    }
}
