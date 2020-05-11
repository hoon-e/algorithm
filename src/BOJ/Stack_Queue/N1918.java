package BOJ.Stack_Queue;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 중위표기법 : 덧셈과 곱셈의 우선순위에 차이가 있다.
 * 후위표기법 : 순서를 적절히 조절하여 순서를 정해줄 수 있다.
 * 전위표기법 : 연산자를 먼저 표시하고 연산에 필요한 피연산자를 나중에 표시하는 방법
 */

public class N1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] line = br.readLine().toCharArray();
        Map<Character, Integer> priority = new HashMap<>();

        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        Stack<Character> paren = new Stack<>();
        Stack<Character> ops = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for(char op : line){
            if(Character.isAlphabetic(op)){
                sb.append(op);
            }else{
                switch (op){
                    case '(':
                        paren.push(op);
                        break;
                    case ')':
                        while(paren.peek() != '('){
                            char p = paren.pop();
                            sb.append(p);
                        }
                        paren.pop();
                        break;
                    default:
                        if(!paren.isEmpty()){
                            if(paren.peek() == '(')
                                paren.push(op);
                            else{
                                while(paren.peek() != '(' && priority.get(paren.peek()) >= priority.get(op)){
                                    sb.append(paren.pop());
                                }
                                paren.push(op);
                            }
                        }else{
                            if(ops.isEmpty()){
                                ops.push(op);
                            }else{
                                while(!ops.isEmpty() && priority.get(ops.peek()) >= priority.get(op)){
                                    sb.append(ops.pop());
                                }
                                ops.push(op);
                            }
                        }
                        break;
                }
            }
        }

        while(!ops.isEmpty()){
            sb.append(ops.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
